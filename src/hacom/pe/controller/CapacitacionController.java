package hacom.pe.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import hacom.pe.datos.entidades.Capacitador;
import hacom.pe.datos.entidades.Departamento;
import hacom.pe.datos.entidades.Modalidad;
import hacom.pe.datos.entidades.Modulo;
import hacom.pe.datos.entidades.TipoSistema;
import hacom.pe.datos.entidades.UsuarioMap;
import hacom.pe.service.AsistenciaTecService;
import hacom.pe.service.GenericoService;
import hacom.pe.service.ModuloService;
import hacom.pe.util.GenerateExpressions;

@ManagedBean(name = "capacitacionController")
@SessionScoped
public class CapacitacionController {

	@ManagedProperty(value = "#{genericoService}")
	private GenericoService genericoService;

	@ManagedProperty(value = "#{asistenciaTecService}")
	private AsistenciaTecService asistenciaTecService;

	@ManagedProperty(value = "#{moduloService}")
	private ModuloService moduloService;
	
	private List<Capacitador> lstAdm;
	private Capacitador userBean;
	private Capacitador selectItemsAdm;
	private boolean disabledUser;
	private boolean displayEstado;
	private List<Modalidad> lstModa;
	private List<TipoSistema> lstTipoSis;
	private List<Departamento> lstDepa;
	private List<Modulo> lstModulo;
	private int idCapacitador;
	@ManagedProperty(value = "#{loginController}")
	private LoginController loginController;
	@PostConstruct
	public void inicializarObjetos() {

		try {
			// lstGeo = genericoService.getAllGeozona();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String listaCapacitador() throws Exception {
		userBean = new Capacitador();
		selectItemsAdm = new Capacitador();
		Capacitador cap=new Capacitador();
		cap.setCapacitadorId(idlogin());
		lstAdm = genericoService.getFindCapacitadorID(cap);
		return "capacitaciones.jsf";
	}

	public int idlogin() throws Exception {
		Capacitador cap=new Capacitador();
		cap.setUsuario(loginController.getNombre());
		Capacitador capacitador=this.genericoService.getFindCapacitadorId(cap);
		if(capacitador != null) {
			setIdCapacitador(capacitador.getIdCap());
		}else {
			setIdCapacitador(0);
		}
		return getIdCapacitador();
	}
	public void resetearUser() throws Exception {
		userBean = new Capacitador();
		selectItemsAdm = new Capacitador();
		setDisplayEstado(false);
		setDisabledUser(false);
		this.cargarCapacitacionSelect();

	}

	public void habilitarUser() throws Exception {
		setDisabledUser(false);
		this.cargarCapacitacionSelect();

	}
	
	public void cargarCapacitacionSelect() throws Exception {
		lstDepa = this.asistenciaTecService.listarDepartamento();
		lstModa = this.genericoService.getAllTipoModalidad();
		lstTipoSis = this.genericoService.getAllTipoSistema();
		lstModulo = this.moduloService.getAllModuloSele();
	}

	public void evaluarMetodo() throws Exception {
		System.out.println("Id:" + this.selectItemsAdm.getId());
		if (this.selectItemsAdm.getId() == 0) {
			this.guardarAdmin();
		} else {
			this.updateAdmin();
		}
	}

	public void guardarAdmin() throws Exception {
		userBean.setStatus("1");
		String fechaCadena = GenerateExpressions.ConvertDateOneToString(userBean.getFechaDate());
        userBean.setFechaCadena(fechaCadena);
		System.out.println("FechaCad:"+userBean.getFechaCadena());
		System.out.println("themeTraining:"+userBean.getThemeTraining());
		System.out.println("level:"+userBean.getLevel());
		System.out.println("localTraining:"+userBean.getLocalTraining());
		System.out.println("departament:"+userBean.getDepartment());
		System.out.println("typeAtenttion:"+userBean.getTypeAttention());
		System.out.println("exhibitor:"+userBean.getExhibitor());
		System.out.println("typeSystem:"+userBean.getTypeSystem());
		System.out.println("moduleId:"+userBean.getModuleId());
		System.out.println("status:"+userBean.getStatus());
		System.out.println("fechaCad:"+userBean.getFechaCadena());
		System.out.println("groupReader:"+userBean.getGroupLeader());
		System.out.println("observation:"+userBean.getObservation());
		System.out.println("nroEntGN:"+userBean.getNroEntGN());
		System.out.println("nroUsuGN:"+userBean.getNroUsuGN());
		System.out.println("nroEntGR:"+userBean.getNroEntGR());
		System.out.println("nroUsuGR:"+userBean.getNroUsuGR());
		System.out.println("nroEntGL:"+userBean.getNroEntGL());
		System.out.println("nroUsuGL:"+userBean.getNroUsuGL());
		System.out.println("nroEntUO:"+userBean.getNroEntUO());
		System.out.println("nroUsuUO:"+userBean.getNroUsuUO());
		System.out.println("nroEntMC:"+userBean.getNroEntMC());
		System.out.println("nroUsuMC:"+userBean.getNroUsuMC());
		System.out.println("nroEntIP:"+userBean.getNroEntIP());
		System.out.println("nroUsuIP:"+userBean.getNroUsuIP());
		System.out.println("nroEntTE:"+userBean.getNroEntTE());
		System.out.println("nroUsuTE:"+userBean.getNroUsuTE());

		System.out.println("observation:"+userBean.getObservation());
        userBean.setIdCapa(getIdCapacitador());		
		genericoService.getSaveCapacitacion(userBean);
		Capacitador cap=new Capacitador();
		cap.setCapacitadorId(idlogin());
		lstAdm = genericoService.getFindCapacitadorID(cap);
	}

	public void updateAdmin() throws Exception {
//    	 userBean.setEstado("A");
		String fechaCadena = GenerateExpressions.ConvertDateOneToString(userBean.getFechaDate());
        userBean.setFechaCadena(fechaCadena);
		genericoService.getUpdateCapacitadores(userBean);
		Capacitador cap=new Capacitador();
		cap.setCapacitadorId(idlogin());
		lstAdm = genericoService.getFindCapacitadorID(cap);
	}

	public void vistaUser() {
		setDisabledUser(true);
		System.out.println("disabled:" + this.disabledUser);
	}

	public void selectedAdm() throws ParseException {
		Date fechaCadena = GenerateExpressions.ConvertStringToDate(getSelectItemsAdm().getDateTraining());
		getSelectItemsAdm().setFechaDate(fechaCadena);
		setUserBean(getSelectItemsAdm());
		setDisabledUser(true);
		setDisplayEstado(true);
//		FacesMessage msg = new FacesMessage("Capacitador Seleccionado", this.getSelectItemsAdm().getLevel());
//		FacesContext.getCurrentInstance().addMessage(null, msg);
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

	public List<Modalidad> getLstModa() {
		return lstModa;
	}

	public void setLstModa(List<Modalidad> lstModa) {
		this.lstModa = lstModa;
	}

	public List<TipoSistema> getLstTipoSis() {
		return lstTipoSis;
	}

	public void setLstTipoSis(List<TipoSistema> lstTipoSis) {
		this.lstTipoSis = lstTipoSis;
	}

	public List<Departamento> getLstDepa() {
		return lstDepa;
	}

	public void setLstDepa(List<Departamento> lstDepa) {
		this.lstDepa = lstDepa;
	}

	public AsistenciaTecService getAsistenciaTecService() {
		return asistenciaTecService;
	}

	public void setAsistenciaTecService(AsistenciaTecService asistenciaTecService) {
		this.asistenciaTecService = asistenciaTecService;
	}

	public ModuloService getModuloService() {
		return moduloService;
	}

	public void setModuloService(ModuloService moduloService) {
		this.moduloService = moduloService;
	}

	public List<Modulo> getLstModulo() {
		return lstModulo;
	}

	public void setLstModulo(List<Modulo> lstModulo) {
		this.lstModulo = lstModulo;
	}

	public int getIdCapacitador() {
		return idCapacitador;
	}

	public void setIdCapacitador(int idCapacitador) {
		this.idCapacitador = idCapacitador;
	}

	public LoginController getLoginController() {
		return loginController;
	}

	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}

}
