package hacom.pe.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

import hacom.pe.datos.entidades.Capacitador;
import hacom.pe.datos.entidades.MsUser;
import hacom.pe.datos.entidades.UsuarioMap;
import hacom.pe.service.GenericoService;
import hacom.pe.util.ManagerArchivo;

@ManagedBean(name = "capacitadorController")
@SessionScoped
public class CapacitadorController {

	@ManagedProperty(value = "#{genericoService}")
	private GenericoService genericoService;

	private List<Capacitador> lstAdm;
	private Capacitador userBean;
	private Capacitador selectItemsAdm;
	private boolean disabledUser;
	private boolean displayEstado;
	private UsuarioMap usumapBean;

	@PostConstruct
	public void inicializarObjetos() {

		try {
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String listaCapacitador() throws Exception {
		userBean = new Capacitador();
		selectItemsAdm = new Capacitador();
		userBean.setFotografiaEncoder("images/fotos/sin-fotografia.png");
		lstAdm = genericoService.getAllCapacitador();
		return "capacitador.jsf";
	}

	public void handleFileUpload(FileUploadEvent event) throws IOException {
		System.out.println("handleFileUpload");
		FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		// userBean.setFoto(event.getFile().getFileName());

		byte[] b2 = new byte[(int) event.getFile().getSize()];
		event.getFile().getInputstream().read(b2);

		userBean.setFotoAdjunto(b2);
		userBean.setFotografiaEncoder(
				"data:image/png;base64," + ManagerArchivo.getEncode(b2));
		//System.out.println("fotografia encoder: " + userBean.getFotografiaEncoder());

	}

	public String getFileArchivo(byte[] cadena) {
		if ((cadena != null)) {
			System.out.println("FotografiaEncoder:" + cadena);
			userBean.setFotografiaEncoder("data:image/png;base64," + ManagerArchivo.getEncode(cadena));

		} else {
			userBean.setFotografiaEncoder("images/fotos/sin-fotografia.png");
		}
		return userBean.getFotografiaEncoder();
	}

	public void resetearUser() {
		userBean = new Capacitador();
		selectItemsAdm = new Capacitador();
		setDisplayEstado(false);
		setDisabledUser(false);
	}

	public void habilitarUser() {
		setDisabledUser(false);
	}

	public void evaluarMetodo() throws Exception {
		System.out.println("Id:" + this.selectItemsAdm.getIdCap());
		if (this.selectItemsAdm.getIdCap() == 0) {
			this.guardarAdmin();
		} else {
			this.updateAdmin();
		}
	}

	public void guardarUsuarioMap() throws Exception {
		UsuarioMap usuMap = new UsuarioMap();
		usuMap.setUsuario(userBean.getUsuario());
		usuMap.setClave(userBean.getClave());
		usuMap.setTipo("C");
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
		usuMap.setUsuario(userBean.getUsuario());
		usuMap.setClave(userBean.getClave());
		usuMap.setTipo("C");
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

	public void guardarAdmin() throws Exception {
		userBean.setEstado("A");
		//userBean.setFotografiaEncoder("");
		userBean.setTipo("C");
		this.guardarUsuarioMap();
		System.out.println("nombreCap:" + userBean.getNombreCap());
		System.out.println("apeCap:" + userBean.getApeCap());
		System.out.println("dni:" + userBean.getDni());
		System.out.println("correo:" + userBean.getCorreo());
		System.out.println("usuario:" + userBean.getUsuario());
		System.out.println("clave:" + userBean.getClave());
		System.out.println("fotoCadena:" + userBean.getFotografiaEncoder());
		System.out.println("estado:" + userBean.getEstado());
		System.out.println("tipo:" + userBean.getTipo());

		if (userBean.getFoto() == null) {
			byte[] b2 = new byte[1];
			userBean.setFotoAdjunto(b2);
		}else {
			userBean.setFotoAdjunto(userBean.getFoto());
		}
		System.out.println("foto:" + userBean.getFotoAdjunto());
		System.out.println("fotoAdj:" + userBean.getFotografiaEncoder());

		genericoService.getSaveCapacitador(userBean);
		
		MsUser adminId = this.genericoService.getCapacitadorId();
		System.out.println("Usuario name:"+adminId.getUsername());
		int id = adminId.getIdCap();
		System.out.println("id-admin:"+id);
		MsUser user = new MsUser();
		user.setPassword(userBean.getClave());
		user.setUsername(userBean.getUsuario());
		user.setFirst_name(userBean.getNombreCap());
		user.setLast_name(userBean.getApeCap());
		user.setEmail("");
        user.setIdIdentif(id);
    	System.out.println("nombre:"+userBean.getNombreCap());
		System.out.println("ape:"+userBean.getApeCap());
		System.out.println("user:"+userBean.getUsuario());
		System.out.println("contra:"+userBean.getClave());
		System.out.println("ema:"+user.getEmail());

       this.genericoService.getSaveAuthUser(user);
		       
		lstAdm = genericoService.getAllCapacitador();
	}

	public void updateAdmin() throws Exception {
//    	 userBean.setEstado("A");
	//	userBean.setFotografiaEncoder("");
		System.out.println("fotoup:" + userBean.getFotoAdjunto());
		if (userBean.getFotoAdjunto() == null) {
			byte[] b2 = new byte[1];
			userBean.setFotoAdjunto(b2);
		}
		
		this.updateUsuarioMap();
		genericoService.getUpdateCapacitador(userBean);
		
		
		MsUser user = new MsUser();
		user.setPassword(userBean.getClave());
		user.setUsername(userBean.getUsuario());
		user.setFirst_name(userBean.getNombreCap());
		user.setLast_name(userBean.getApeCap());
		user.setEmail("");
        user.setIdIdentif(userBean.getIdCap());
    	System.out.println("nombre:"+userBean.getNombreCap());
		System.out.println("ape:"+userBean.getApeCap());
		System.out.println("user:"+userBean.getUsuario());
		System.out.println("contra:"+userBean.getClave());
		System.out.println("ema:"+user.getEmail());
	    this.genericoService.getUpdateAuthUser(user);

	       
		lstAdm = genericoService.getAllCapacitador();
	}

	public void deleteAdmin() throws Exception {
		this.deleteUsuarioMap();
		genericoService.getUpdateEstadoCapa(this.getSelectItemsAdm().getIdCap());
		this.genericoService.getdeleteAuthUser(this.getSelectItemsAdm().getIdCap());

		listaCapacitador();
	}

	public void vistaUser() {
		setDisabledUser(true);
		System.out.println("disabled:" + this.disabledUser);
	}

	public void selectedAdm() {
		
		setUserBean(getSelectItemsAdm());
		UsuarioMap usuMap = new UsuarioMap();
		usuMap.setUsuario(getSelectItemsAdm().getUsuario());
		usuMap.setClave(getSelectItemsAdm().getClave());
		usuMap.setTipo(getSelectItemsAdm().getTipo());
		setUsumapBean(usuMap);
		setDisabledUser(true);
		setDisplayEstado(true);
		if (userBean.getFoto() != null) {
			userBean.setFotografiaEncoder(
					"data:image/png;base64," + ManagerArchivo.getEncode(userBean.getFoto()));
			userBean.setFotoAdjunto(userBean.getFoto());
		} else {
			userBean.setFotografiaEncoder("images/fotos/sin-fotografia.png");
		}
//         FacesMessage msg = new FacesMessage("Capacitador Seleccionado", this.getSelectItemsAdm().getNombreCap());
//         FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public GenericoService getGenericoService() {
		return genericoService;
	}

	public void setGenericoService(GenericoService genericoService) {
		this.genericoService = genericoService;
	}

	public List<Capacitador> getLstAdm() {
		return lstAdm;
	}

	public void setLstAdm(List<Capacitador> lstAdm) {
		this.lstAdm = lstAdm;
	}

	public Capacitador getUserBean() {
		return userBean;
	}

	public void setUserBean(Capacitador userBean) {
		this.userBean = userBean;
	}

	public Capacitador getSelectItemsAdm() {
		return selectItemsAdm;
	}

	public void setSelectItemsAdm(Capacitador selectItemsAdm) {
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

	public UsuarioMap getUsumapBean() {
		return usumapBean;
	}

	public void setUsumapBean(UsuarioMap usumapBean) {
		this.usumapBean = usumapBean;
	}

}
