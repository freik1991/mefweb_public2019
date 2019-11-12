package hacom.pe.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import hacom.pe.datos.entidades.AsistenciaRemota;
import hacom.pe.datos.entidades.AsistenciaTecnica;
import hacom.pe.datos.entidades.Departamento;
import hacom.pe.datos.entidades.Entidad;
import hacom.pe.datos.entidades.Implantador;
import hacom.pe.datos.entidades.Modalidad;
import hacom.pe.datos.entidades.Modulo;
import hacom.pe.datos.entidades.Sectorista;
import hacom.pe.datos.entidades.SubModulo;
import hacom.pe.datos.entidades.TipoLocal;
import hacom.pe.datos.entidades.TipoSistema;
import hacom.pe.service.AsistenciaRemotaService;
import hacom.pe.service.AsistenciaTecService;
import hacom.pe.service.GenericoService;
import hacom.pe.service.ModuloService;
import hacom.pe.util.GenerateExpressions;

@ManagedBean(name = "asistenciaRemotaController")
@SessionScoped
public class AsistenciaRemotaController {

	@ManagedProperty(value = "#{asistenciaRemotaService}")
	private AsistenciaRemotaService asistenciaRemotaService;

	@ManagedProperty(value = "#{genericoService}")
	private GenericoService genericoService;

	@ManagedProperty(value = "#{asistenciaTecService}")
	private AsistenciaTecService asistenciaTecService;

	@ManagedProperty(value = "#{moduloService}")
	private ModuloService moduloService;
	
	@ManagedProperty(value = "#{loginController}")
	private LoginController loginController;
	
	private List<AsistenciaRemota> lstAsis;
	private AsistenciaRemota asistenciaRemotaBean;
	private List<Departamento> lstDepa;
	private List<Entidad> lstEntidad;
	private List<Sectorista> lstSec;
	private List<Implantador> lstImp;
	private List<Modalidad> lstModa;
	private List<TipoSistema> lstTipoSis;
	private List<SubModulo> lstSubMod;
	private List<Modulo> lstModulo;
	private List<Entidad> lstEntidadId;

	private AsistenciaRemota userBean;
	private AsistenciaRemota selectItemsAdm;
	private boolean disabledUser;
	private String representativeName;
	private String representativePosition;
	private String representativePhone;
	private String representativeEmail;
	
	@PostConstruct
	public void inicializarObjetos() {
		lstAsis = new ArrayList<AsistenciaRemota>();
		lstDepa = new ArrayList<Departamento>();
		userBean = new AsistenciaRemota();
		try {
//			lstAsis = asistenciaRemotaService.listarAsistenciaRem();
//			lstDepa = asistenciaTecService.listarDepartamento();
//			asistenciaRemotaBean = new AsistenciaRemota();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void buscarAsistenciaRemota() {

		try {
			lstDepa = asistenciaTecService.listarDepartamento();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String listarAsistenciaRem() throws Exception {
		System.out.println("listarAsistenciaRem");
		System.out.println("TipoA:"+loginController.getTipo());
        if(loginController.getTipo().equals("I")) {
        	Implantador imp=new Implantador();
    		imp.setUsuaImpl(loginController.getNombre());
    		Implantador implantador = this.genericoService.getFindUsuImpl(imp);
    		System.out.println("IdImpl:"+implantador.getIdImpl());
    		AsistenciaRemota asis = new AsistenciaRemota();
    		asis.setImplanterID(implantador.getIdImpl());
    		lstAsis = genericoService.getFindAsistenciaRemImp(asis);
        }else if(loginController.getTipo().equals("S")) {
        	Sectorista sec=new Sectorista();
    		sec.setUsuSec(loginController.getNombre());
    		Sectorista sectorista = this.genericoService.getFindUsuImplSec(sec);
    		System.out.println("IdSec:"+sectorista.getIdSec());
    		AsistenciaRemota asis = new AsistenciaRemota();
    		asis.setSectorist_id(sectorista.getIdSec());
        	lstAsis = genericoService.getFindAsistenciaRemSec(asis);
    		
        }
        lstEntidad = this.genericoService.getAllEntidadSel();
		lstTipoSis= this.genericoService.getAllTipoSistema();
		lstModa= this.genericoService.getAllTipoModalidad();
		lstModulo= this.moduloService.getAllModulo();
		lstSubMod= this.genericoService.getAllSubModulo();
		return "asistenciaRem.jsf";

	}

	public void mostrarDatosEntidad() throws Exception {
		lstEntidadId = this.genericoService.getAllMfUnitId(userBean.getUnitID());
		this.resetearRepresentante();
		for(Entidad ent : lstEntidadId) {
			setRepresentativeName(ent.getRepresentativeName());
			setRepresentativeEmail(ent.getRepresentativeEmail());
			setRepresentativePosition(ent.getRepresentativePosition());
			setRepresentativePhone(ent.getRepresentativePhone());
		}
	}
	
	public void resetearRepresentante() {
		setRepresentativeName("");
		setRepresentativeEmail("");
		setRepresentativePosition("");
		setRepresentativePhone("");
	}
	
	public void resetearUser() {
		userBean = new AsistenciaRemota();
		selectItemsAdm = new AsistenciaRemota();
		resetearRepresentante();
		setDisabledUser(false);
	}

	public void habilitarUser() {
		setDisabledUser(false);
	}

	public void evaluarMetodo() throws Exception {
		System.out.println("Id:" + this.selectItemsAdm.getRemoteAssistanceID());
		if (this.selectItemsAdm.getRemoteAssistanceID() == 0) {
			this.guardarAdmin();
		} else {
			this.updateAdmin();
		}
	}

	public void guardarAdmin() throws Exception {
		// userBean.setEstado("A");
	String fechaVisCad = GenerateExpressions.ConvertDateOneToString(userBean.getFechaVis());
	String horaIni = GenerateExpressions.ConvertHoraToString(userBean.getHoraIni());
	String horaFin = GenerateExpressions.ConvertHoraToString(userBean.getHoraFin());

	System.out.println("fechaVisCad:"+horaIni);
	System.out.println("horaVisCad:"+horaFin);

    userBean.setAssistanceStartTime(horaIni);
    userBean.setAssistanceEndTime(horaFin);
    userBean.setAssistanceDate(fechaVisCad);

		genericoService.getSaveAsistenciarRem(userBean);
		lstAsis = genericoService.getAllAsistenciaRem();
	}

	public void updateAdmin() throws Exception {
// userBean.setEstado("A");
    String fechaVisCad = GenerateExpressions.ConvertDateOneToString(userBean.getFechaVis());
	String horaIni = GenerateExpressions.ConvertHoraToString(userBean.getHoraIni());
	String horaFin = GenerateExpressions.ConvertHoraToString(userBean.getHoraFin());

	System.out.println("fechaVisCad:"+horaIni);
	System.out.println("horaVisCad:"+horaFin);

    userBean.setAssistanceStartTime(horaIni);
    userBean.setAssistanceEndTime(horaFin);
    userBean.setAssistanceDate(fechaVisCad);

		genericoService.getUpdateAsistenciRem(userBean);
		lstAsis = genericoService.getAllAsistenciaRem();
	}

	public void deleteAdmin() throws Exception {
		genericoService.getdeleteAsistenciaRem(this.getSelectItemsAdm().getRemoteAssistanceID());
		listarAsistenciaRem();
	}

	public void vistaUser() {
		setDisabledUser(true);
		System.out.println("disabled:" + this.disabledUser);
	}

	public void selectedAdm() throws Exception {
	Date fechaCadena = GenerateExpressions.ConvertStringToDate(getSelectItemsAdm().getAssistanceDate());
	Date horaICadena = GenerateExpressions.ConvertStringToHour(getSelectItemsAdm().getAssistanceStartTime());
	Date horaFCadena = GenerateExpressions.ConvertStringToHour(getSelectItemsAdm().getAssistanceEndTime());
	getSelectItemsAdm().setFechaVis(fechaCadena);
	getSelectItemsAdm().setHoraIni(horaICadena);
	getSelectItemsAdm().setHoraFin(horaFCadena);
		setUserBean(getSelectItemsAdm());
		this.mostrarDatosEntidad();
		setDisabledUser(true);
//		FacesMessage msg = new FacesMessage("Asistencia Remota Seleccionado",
//				this.getSelectItemsAdm().getRepresentativeName());
//		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public AsistenciaRemotaService getAsistenciaRemotaService() {
		return asistenciaRemotaService;
	}

	public void setAsistenciaRemotaService(AsistenciaRemotaService asistenciaRemotaService) {
		this.asistenciaRemotaService = asistenciaRemotaService;
	}

	public void listarAsistenciaRemota() {
		try {
			lstAsis = asistenciaRemotaService.listarAsistenciaRem();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void validarSeleccion() {
		if (!asistenciaRemotaBean.isCheckSecEje()) {
			asistenciaRemotaBean.setSecEjec("");
		}
		if (!asistenciaRemotaBean.isCheckDepa()) {
			asistenciaRemotaBean.setDepartment(0);
		}
		if (!asistenciaRemotaBean.isCheckEntidad()) {
			asistenciaRemotaBean.setUnitName("");
		}
		if (!asistenciaRemotaBean.isCheckSectorista()) {
			asistenciaRemotaBean.setNameSec("");
			asistenciaRemotaBean.setSectorist_id(0);
		}
		if (!asistenciaRemotaBean.isCheckImpl()) {
			asistenciaRemotaBean.setIMPLANTADOR("");
			;
		}
		if (!asistenciaRemotaBean.isCheckMod()) {
			asistenciaRemotaBean.setModalidad("");
			;
		}
		if (!asistenciaRemotaBean.isCheckSis()) {
			asistenciaRemotaBean.setSistema("");
		}
//		if (!asistenciaRemotaBean.isCheckReg()) {
//			asistenciaRemotaBean.setRegistro(0);
//		}

		if (!asistenciaRemotaBean.isCheckFechaAsisRIni()) {
			asistenciaRemotaBean.setFechaAsisIni(new Long(0));
			asistenciaRemotaBean.setFechaAsisHas(new Long(0));
		}
		if (!asistenciaRemotaBean.isCheckFechaAsisRFin()) {
			asistenciaRemotaBean.setFechaRegIni(new Long(0));
			asistenciaRemotaBean.setFechaRegHas(new Long(0));
		}

	}

	public void eventoButtonFecha() {
		System.out.println("Evento Radio Button:" + asistenciaRemotaBean.getRbFechaSelec());
		if (asistenciaRemotaBean.getRbFechaSelec().equals("1")) {
			asistenciaRemotaBean.setCheckFechaAsisRIni(true);
			asistenciaRemotaBean.setDisEnvio(true);
			asistenciaRemotaBean.setDisResp(false);
			asistenciaRemotaBean.setCheckFechaAsisRFin(false);

		}
		if (asistenciaRemotaBean.getRbFechaSelec().equals("2")) {
			asistenciaRemotaBean.setCheckFechaAsisRFin(true);
			asistenciaRemotaBean.setDisResp(true);
			asistenciaRemotaBean.setDisEnvio(false);
			asistenciaRemotaBean.setCheckFechaAsisRIni(false);

		}
	}

	public void filtroAsistenciaRemota() throws Exception {
		try {

			// lstAsisTec = asistenciaTecService.getFindAsistencia(asistenciaBean);
			Long fechaAI = GenerateExpressions.ConvertDateToEpoch(asistenciaRemotaBean.getFechaAsiICal());
			Long fechaAF = GenerateExpressions.ConvertDateToEpoch(asistenciaRemotaBean.getFechaAsiFCal());
			Long fechaRI = GenerateExpressions.ConvertDateToEpoch(asistenciaRemotaBean.getFechaRegICal());
			Long fechaRF = GenerateExpressions.ConvertDateToEpoch(asistenciaRemotaBean.getFechaARegFCal());
			asistenciaRemotaBean.setFechaAsisIni(fechaAI);
			asistenciaRemotaBean.setFechaAsisHas(fechaAF);
			asistenciaRemotaBean.setFechaRegIni(fechaRI);
			asistenciaRemotaBean.setFechaRegHas(fechaRF);
			if (asistenciaRemotaBean.getFechaAsisIni() == null && asistenciaRemotaBean.getFechaAsisIni() == null
					&& asistenciaRemotaBean.getFechaRegIni() == null && asistenciaRemotaBean.getFechaRegHas() == null) {
				asistenciaRemotaBean.setFechaAsisIni(new Long(0));
				asistenciaRemotaBean.setFechaAsisHas(new Long(0));
				asistenciaRemotaBean.setFechaRegIni(new Long(0));
				asistenciaRemotaBean.setFechaRegHas(new Long(0));

			}

			System.out.println("fechainicio:" + asistenciaRemotaBean.getFechaAsisIni());
			System.out.println("fechafin:" + asistenciaRemotaBean.getFechaAsisHas());
//			String sectoristaName = String.valueOf(asistenciaBean.getSectorist_id());
//			System.out.println("sectoristaName:"+asistenciaBean.getNameSec());
//			System.out.println("check:"+asistenciaBean.isCheckSecEje());
			if (asistenciaRemotaBean.getNameSec() != "") {
				AsistenciaTecnica asis = asistenciaTecService.getSectoristaName(asistenciaRemotaBean.getNameSec());
				if (asis != null) {
					asistenciaRemotaBean.setSectorist_id(asis.getId());
				} else {
					asistenciaRemotaBean.setSectorist_id(0);

				}
			}
//			int depanuevo = asistenciaRemotaBean.getDepartment() +1 ;
//			asistenciaRemotaBean.setDepartment(depanuevo);
			System.out.println("Sectorist_id:" + asistenciaRemotaBean.getSectorist_id());
			System.out.println("Sectorist_ejec:" + asistenciaRemotaBean.getSecEjec());
			System.out.println("depa id:" + asistenciaRemotaBean.getDepartment());

			this.validarSeleccion();
//			asistenciaBean.setSecEjec(0);
//			asistenciaBean.setDepartment(0);
//			asistenciaBean.setUnitName("");
//			asistenciaBean.setSectorist_id(0);
//			asistenciaBean.setIMPLANTADOR("");
//			asistenciaBean.setIsFunctional(0);
//			asistenciaBean.setIsTechnical(0);
//			asistenciaBean.setIsTraining(0);
//			asistenciaBean.setRepresentantName("");
//			asistenciaBean.setRepresentantWorkingPosition("");
			lstAsis = asistenciaRemotaService.findAsistenciaRem(asistenciaRemotaBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<AsistenciaRemota> getLstAsis() {
		return lstAsis;
	}

	public void setLstAsis(List<AsistenciaRemota> lstAsis) {
		this.lstAsis = lstAsis;
	}

	public AsistenciaRemota getAsistenciaRemotaBean() {
		return asistenciaRemotaBean;
	}

	public void setAsistenciaRemotaBean(AsistenciaRemota asistenciaRemotaBean) {
		this.asistenciaRemotaBean = asistenciaRemotaBean;
	}

	public AsistenciaTecService getAsistenciaTecService() {
		return asistenciaTecService;
	}

	public void setAsistenciaTecService(AsistenciaTecService asistenciaTecService) {
		this.asistenciaTecService = asistenciaTecService;
	}

	public List<Departamento> getLstDepa() {
		return lstDepa;
	}

	public void setLstDepa(List<Departamento> lstDepa) {
		this.lstDepa = lstDepa;
	}

	public boolean isDisabledUser() {
		return disabledUser;
	}

	public void setDisabledUser(boolean disabledUser) {
		this.disabledUser = disabledUser;
	}

	public GenericoService getGenericoService() {
		return genericoService;
	}

	public void setGenericoService(GenericoService genericoService) {
		this.genericoService = genericoService;
	}

	public List<Entidad> getLstEntidad() {
		return lstEntidad;
	}

	public void setLstEntidad(List<Entidad> lstEntidad) {
		this.lstEntidad = lstEntidad;
	}

	public List<Sectorista> getLstSec() {
		return lstSec;
	}

	public void setLstSec(List<Sectorista> lstSec) {
		this.lstSec = lstSec;
	}

	public List<Implantador> getLstImp() {
		return lstImp;
	}

	public void setLstImp(List<Implantador> lstImp) {
		this.lstImp = lstImp;
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

	public AsistenciaRemota getUserBean() {
		return userBean;
	}

	public void setUserBean(AsistenciaRemota userBean) {
		this.userBean = userBean;
	}

	public AsistenciaRemota getSelectItemsAdm() {
		return selectItemsAdm;
	}

	public void setSelectItemsAdm(AsistenciaRemota selectItemsAdm) {
		this.selectItemsAdm = selectItemsAdm;
	}

	public List<SubModulo> getLstSubMod() {
		return lstSubMod;
	}

	public void setLstSubMod(List<SubModulo> lstSubMod) {
		this.lstSubMod = lstSubMod;
	}

	public List<Modulo> getLstModulo() {
		return lstModulo;
	}

	public void setLstModulo(List<Modulo> lstModulo) {
		this.lstModulo = lstModulo;
	}

	public ModuloService getModuloService() {
		return moduloService;
	}

	public void setModuloService(ModuloService moduloService) {
		this.moduloService = moduloService;
	}

	public List<Entidad> getLstEntidadId() {
		return lstEntidadId;
	}

	public void setLstEntidadId(List<Entidad> lstEntidadId) {
		this.lstEntidadId = lstEntidadId;
	}

	public String getRepresentativeName() {
		return representativeName;
	}

	public void setRepresentativeName(String representativeName) {
		this.representativeName = representativeName;
	}

	public String getRepresentativePosition() {
		return representativePosition;
	}

	public void setRepresentativePosition(String representativePosition) {
		this.representativePosition = representativePosition;
	}

	public String getRepresentativePhone() {
		return representativePhone;
	}

	public void setRepresentativePhone(String representativePhone) {
		this.representativePhone = representativePhone;
	}

	public String getRepresentativeEmail() {
		return representativeEmail;
	}

	public void setRepresentativeEmail(String representativeEmail) {
		this.representativeEmail = representativeEmail;
	}

	public LoginController getLoginController() {
		return loginController;
	}

	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}

}
