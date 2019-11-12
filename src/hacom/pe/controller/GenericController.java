package hacom.pe.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import hacom.pe.datos.entidades.AsistenciaRemota;
import hacom.pe.datos.entidades.Entidad;
import hacom.pe.datos.entidades.EntidadSectorista;
import hacom.pe.datos.entidades.Geozona;
import hacom.pe.datos.entidades.MsUser;
import hacom.pe.datos.entidades.UsuarioMap;
import hacom.pe.service.EntidadService;
import hacom.pe.service.GenericoService;

@ManagedBean(name = "genericController")
@SessionScoped
public class GenericController {

	@ManagedProperty(value = "#{genericoService}")
	private GenericoService genericoService;

	@ManagedProperty(value = "#{entidadService}")
	private EntidadService entidadService;

	private List<MsUser> lstAsis;
	private List<Geozona> lstGeo;
	private List<MsUser> lstAdm;
	private MsUser userBean;
	private MsUser selectItemsAdm;
	private boolean disabledUser;
	private boolean displayEstado;
	private EntidadSectorista entBean;
	private List<Entidad> lstEntidad;
	private List<Entidad> lstEntidadSel;
	private UsuarioMap usumapBean;
	private Geozona userAsiBean;
	private Geozona selectItemsGeo;

	@PostConstruct
	public void inicializarObjetos() {
		lstAsis = new ArrayList<MsUser>();

		try {
			lstAsis = genericoService.getAllSectorista();

			// lstGeo = genericoService.getAllGeozona();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String listaGeozona() throws Exception {
		System.out.println("dentro de listaGeozona");
		userAsiBean = new Geozona();
		lstGeo = genericoService.getAllGeozona();
		return "geozona.jsf";
	}

	public String listaAdministrador() throws Exception {
		userBean = new MsUser();

		selectItemsAdm = new MsUser();
		lstAdm = genericoService.getAllUsuarioAdm();

		return "administrador.jsf";
	}

	public String Ubigeo(int depa, int dis, int prov) throws Exception {
		Entidad depart = genericoService.getAllDepartamento(depa);
		Entidad distr = genericoService.getAllDistricto(dis);
		Entidad provi = genericoService.getAllProvincia(prov);
		// String cadena = depart.getDepaname() + distr.getDisname();
		String cadena = "";
		if (depart != null && distr != null && provi != null) {
			cadena = depart.getDepaname() + " " + distr.getDisname() + " " + provi.getProvname();
		}
		System.out.println("cadena:" + cadena);
		return cadena;
	}

	public void resetearUser() {
		userBean = new MsUser();
		selectItemsAdm = new MsUser();
		setDisplayEstado(false);
		setDisabledUser(false);
	}

	public void habilitarUser() {
		setDisabledUser(false);
	}

	public void evaluarMetodo() throws Exception {
		System.out.println("Id:" + this.selectItemsAdm.getIduser());
		if (this.selectItemsAdm.getIduser() == 0) {
			this.guardarAdmin();
		} else {
			this.updateAdmin();
		}
	}

	public void guardarAdmin() throws Exception {
		userBean.setIs_supperuser(1);
		userBean.setEstado("A");
		userBean.setTipo("A");
		System.out.println("usuname:" + userBean.getUsername());
		
		genericoService.getSaveAdmin(userBean);
		this.guardarUsuarioMap();
		
		MsUser adminId = this.genericoService.getUsuarioId();
		System.out.println("Usuario name:"+adminId.getUsername());
		int id = adminId.getIduser();
		System.out.println("id-admin:"+id);
		MsUser user = new MsUser();
		user.setPassword(userBean.getContrasena());
		user.setUsername(userBean.getUsername());
		user.setFirst_name(userBean.getNombre_use());
		user.setLast_name(userBean.getApellido_use());
		user.setEmail("");
        user.setIdIdentif(id);
		System.out.println("nombre:"+userBean.getNombre_use());
		System.out.println("ape:"+userBean.getApellido_use());
		System.out.println("user:"+userBean.getUsername());
		System.out.println("contra:"+userBean.getContrasena());
		System.out.println("ema:"+user.getEmail());

       this.genericoService.getSaveAuthUser(user);
       
		
		lstAdm = genericoService.getAllUsuarioAdm();
	}

	public void guardarUsuarioMap() throws Exception {
		UsuarioMap usuMap = new UsuarioMap();
		usuMap.setUsuario(userBean.getUsername());
		usuMap.setClave(userBean.getContrasena());
		usuMap.setTipo(userBean.getTipo());
		this.genericoService.getSaveUsuarioMap(usuMap);
	}

	public void updateUsuarioMap() throws Exception {
		int id = 0;
		List<UsuarioMap> lstidUsu = this.genericoService.getAllIdUsuarioMap(usumapBean);
		if (!lstidUsu.isEmpty()) {
			id = lstidUsu.get(0).getIdUsumap();
		}
		System.out.println("Usuario:" + usumapBean.getUsuario());
		System.out.println("Clave:" + usumapBean.getClave());
		System.out.println("Tipo:" + usumapBean.getTipo());

		System.out.println("idusuMap:" + id);

		UsuarioMap usuMap = new UsuarioMap();
		usuMap.setIdUsumap(id);
		usuMap.setUsuario(userBean.getUsername());
		usuMap.setClave(userBean.getContrasena());
		usuMap.setTipo(userBean.getTipo());
		this.genericoService.getUpdateUsuarioMap(usuMap);
	}

	public void deleteUsuarioMap() throws Exception {
		int id = 0;
		List<UsuarioMap> lstidUsu = this.genericoService.getAllIdUsuarioMap(usumapBean);
		if (!lstidUsu.isEmpty()) {
			id = lstidUsu.get(0).getIdUsumap();
		}
		UsuarioMap usuMap = new UsuarioMap();
		usuMap.setIdUsumap(id);
		this.genericoService.getDeleteUsuMap(usuMap);

	}

	public void updateAdmin() throws Exception {
		userBean.setIs_supperuser(1);
//    	 userBean.setEstado("A");
		userBean.setTipo("A");
		System.out.println("usuname:" + userBean.getUsername());
		System.out.println("userid:" + this.userBean.getIduser());
		System.out.println("dni:" + this.userBean.getDni());
		System.out.println("tipo:" + this.userBean.getTipo());
		this.updateUsuarioMap();
		genericoService.getUpdateAdmin(userBean);
		
		
		MsUser user = new MsUser();
		user.setPassword(userBean.getContrasena());
		user.setUsername(userBean.getUsername());
		user.setFirst_name(userBean.getNombre_use());
		user.setLast_name(userBean.getApellido_use());
		user.setEmail("");
        user.setIdIdentif(userBean.getIduser());
		System.out.println("nombre:"+userBean.getNombre_use());
		System.out.println("ape:"+userBean.getApellido_use());
		System.out.println("user:"+userBean.getUsername());
		System.out.println("contra:"+userBean.getContrasena());
		System.out.println("ema:"+user.getEmail());

       this.genericoService.getUpdateAuthUser(user);
       
		lstAdm = genericoService.getAllUsuarioAdm();
	}

	public void deleteAdmin() throws Exception {
		this.deleteUsuarioMap();
		genericoService.getDeleteAdmin(this.getSelectItemsAdm().getIduser());
		this.genericoService.getdeleteAuthUser(this.getSelectItemsAdm().getIduser());
		listaAdministrador();
	}

	public void vistaUser() {
		setDisabledUser(true);
		System.out.println("disabled:" + this.disabledUser);
	}

	public void guardarZona() throws Exception {
		System.out.println("latitud:" + getUserAsiBean().getLatitude());
		System.out.println("longitud:" + getUserAsiBean().getLongitude());
		System.out.println("radio:" + getUserAsiBean().getRadius());
		this.genericoService.getUpdateCoordenadas(userAsiBean);
		lstGeo = genericoService.getAllGeozona();

	}

	public void onRowSelect(SelectEvent event) {
		setUserBean(getSelectItemsAdm());
		FacesMessage msg = new FacesMessage("Usuario Seleccionado", this.getSelectItemsAdm().getUsername());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void selectGeo() {
		setUserAsiBean(getSelectItemsGeo());
		FacesMessage msg = new FacesMessage("geo Seleccionado", this.getSelectItemsGeo().getId());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void selectedAdm() {
		setUserBean(getSelectItemsAdm());
		UsuarioMap usuMap = new UsuarioMap();
		usuMap.setUsuario(getSelectItemsAdm().getUsername());
		usuMap.setClave(getSelectItemsAdm().getContrasena());
		usuMap.setTipo(getSelectItemsAdm().getTipo());
		setUsumapBean(usuMap);
		setDisabledUser(true);
		setDisplayEstado(true);
//         FacesMessage msg = new FacesMessage("Usuario Seleccionado", this.getSelectItemsAdm().getUsername());
//         FacesContext.getCurrentInstance().addMessage(null, msg);
		System.out.println("usesss:" + getUserBean().getUsername());
	}

	public GenericoService getGenericoService() {
		return genericoService;
	}

	public void setGenericoService(GenericoService genericoService) {
		this.genericoService = genericoService;
	}

	public List<MsUser> getLstAsis() {
		return lstAsis;
	}

	public void setLstAsis(List<MsUser> lstAsis) {
		this.lstAsis = lstAsis;
	}

	public List<Geozona> getLstGeo() {
		return lstGeo;
	}

	public void setLstGeo(List<Geozona> lstGeo) {
		this.lstGeo = lstGeo;
	}

	public List<MsUser> getLstAdm() {
		return lstAdm;
	}

	public void setLstAdm(List<MsUser> lstAdm) {
		this.lstAdm = lstAdm;
	}

	public MsUser getUserBean() {
		return userBean;
	}

	public void setUserBean(MsUser userBean) {
		this.userBean = userBean;
	}

	public MsUser getSelectItemsAdm() {
		return selectItemsAdm;
	}

	public void setSelectItemsAdm(MsUser selectItemsAdm) {
		this.selectItemsAdm = selectItemsAdm;
	}

	public boolean isDisabledUser() {
		return disabledUser;
	}

	public void setDisabledUser(boolean disabledUser) {
		this.disabledUser = disabledUser;
	}

	public boolean isDisplayEstado() {
		return displayEstado;
	}

	public void setDisplayEstado(boolean displayEstado) {
		this.displayEstado = displayEstado;
	}

	public EntidadService getEntidadService() {
		return entidadService;
	}

	public void setEntidadService(EntidadService entidadService) {
		this.entidadService = entidadService;
	}

	public EntidadSectorista getEntBean() {
		return entBean;
	}

	public void setEntBean(EntidadSectorista entBean) {
		this.entBean = entBean;
	}

	public List<Entidad> getLstEntidad() {
		return lstEntidad;
	}

	public void setLstEntidad(List<Entidad> lstEntidad) {
		this.lstEntidad = lstEntidad;
	}

	public List<Entidad> getLstEntidadSel() {
		return lstEntidadSel;
	}

	public void setLstEntidadSel(List<Entidad> lstEntidadSel) {
		this.lstEntidadSel = lstEntidadSel;
	}

	public UsuarioMap getUsumapBean() {
		return usumapBean;
	}

	public void setUsumapBean(UsuarioMap usumapBean) {
		this.usumapBean = usumapBean;
	}

	public Geozona getUserAsiBean() {
		return userAsiBean;
	}

	public void setUserAsiBean(Geozona userAsiBean) {
		this.userAsiBean = userAsiBean;
	}

	public Geozona getSelectItemsGeo() {
		return selectItemsGeo;
	}

	public void setSelectItemsGeo(Geozona selectItemsGeo) {
		this.selectItemsGeo = selectItemsGeo;
	}

}
