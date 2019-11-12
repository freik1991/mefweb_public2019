package hacom.pe.controller;

import java.io.Serializable;
import java.text.ParseException;
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

import org.springframework.beans.factory.annotation.Autowired;

import hacom.pe.datos.entidades.AsistenciaTecnica;
import hacom.pe.datos.entidades.Departamento;
import hacom.pe.datos.entidades.Entidad;
import hacom.pe.datos.entidades.Sectorista;
import hacom.pe.datos.entidades.TipoLocal;
import hacom.pe.datos.entidades.TipoSistema;
import hacom.pe.service.AsistenciaTecService;
import hacom.pe.service.GenericoService;
import hacom.pe.util.GenerateExpressions;

@ManagedBean(name = "asistenciaTecController")
@SessionScoped
public class AsistenciaTecController implements Serializable {

	@ManagedProperty(value = "#{asistenciaTecService}")
	private AsistenciaTecService asistenciaTecService;

	@ManagedProperty(value = "#{genericoService}")
	private GenericoService genericoService;

	@ManagedProperty(value = "#{loginController}")
	private LoginController loginController;

	
	private List<Departamento> lstDepa;
	private List<AsistenciaTecnica> lstAsisTec;
	private AsistenciaTecnica asistenciaBean;
	private AsistenciaTecnica userBean;
	private AsistenciaTecnica selectItemsAdm;
	private boolean disabledUser;
	private List<Entidad> lstEntidad;
    private List<TipoLocal> lstTipoLoc;
	private List<TipoSistema> lstTipoSis;

	@PostConstruct
	public void inicializarObjetos() {
		lstDepa = new ArrayList<Departamento>();
		asistenciaBean = new AsistenciaTecnica();
		userBean = new AsistenciaTecnica();
		try {
			lstAsisTec = asistenciaTecService.listarAsistenciaTec();
			lstDepa = asistenciaTecService.listarDepartamento();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void buscarAsistenciaTec() {

		try {
			lstDepa = asistenciaTecService.listarDepartamento();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String listarAsistenciaTec() throws Exception {
        if(loginController.getTipo().equals("S")) {
        	Sectorista sec=new Sectorista();
    		sec.setUsuSec(loginController.getNombre());
    		Sectorista sectorista = this.genericoService.getFindUsuImplSec(sec);
    		System.out.println("IdSec:"+sectorista.getIdSec());
    		AsistenciaTecnica asis = new AsistenciaTecnica();
    		asis.setSectorist_id(sectorista.getIdSec());
    		lstAsisTec = genericoService.getFindAsistenciaPresSec(asis);
        }else {
        	lstAsisTec = genericoService.getAllAsistenciaPres();
			lstEntidad = this.genericoService.getAllEntidadSel();
			lstTipoSis = this.genericoService.getAllTipoSistema();
			lstTipoLoc = this.genericoService.getAllTipoLocal();
        }

			

		return "asistenciaPresencial.jsf";
	}

	public String fechaEnvio(Long fecha) {
		Date date1 = GenerateExpressions.ConvertEpochToDate(fecha);
		String fechacad = GenerateExpressions.ConvertDateOneToString(date1);
		return fechacad;
	}

	public String HoraLlegada(Long fecha) {
		Date date1 = GenerateExpressions.ConvertEpochToDate(fecha);
		String fechacad = GenerateExpressions.ConvertHoraToString(date1);
		return fechacad;
	}

	public String sectoristaName(int id) {
		try {
			AsistenciaTecnica asis = asistenciaTecService.getSectorista(id);
			return asis.getNameSec();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public void validarSeleccion() {
		if (!asistenciaBean.isCheckSecEje()) {
			asistenciaBean.setSecEjec("");
		}
		if (!asistenciaBean.isCheckDepa()) {
			asistenciaBean.setDepartment(0);
		}
		if (!asistenciaBean.isCheckEntidad()) {
			asistenciaBean.setUnitName("");
		}
		if (!asistenciaBean.isCheckSectorista()) {
			asistenciaBean.setNameSec("");
			asistenciaBean.setSectorist_id(0);
		}
		if (!asistenciaBean.isCheckImpl()) {
			asistenciaBean.setIMPLANTADOR("");
			;
		}
		if (!asistenciaBean.isCheckFunc()) {
			asistenciaBean.setIsFunctional(0);
		}
		if (!asistenciaBean.isCheckTec()) {
			asistenciaBean.setIsTechnical(0);
		}
		if (!asistenciaBean.isCheckCap()) {
			asistenciaBean.setIsTraining(0);
		}
		if (!asistenciaBean.isCheckRep()) {
			asistenciaBean.setRepresentantName("");
		}
		if (!asistenciaBean.isCheckCarR()) {
			asistenciaBean.setRepresentantWorkingPosition("");
		}

	}

	public void filtroAsistenciaTecnica() throws Exception {
		try {

			// lstAsisTec = asistenciaTecService.getFindAsistencia(asistenciaBean);
			Long fechaI = GenerateExpressions.ConvertDateToEpoch(asistenciaBean.getFechaICal());
			Long fechaF = GenerateExpressions.ConvertDateToEpoch(asistenciaBean.getFechaFCal());
			asistenciaBean.setFechaIni(fechaI);
			asistenciaBean.setFechaFin(fechaF);
			if (asistenciaBean.getFechaICal() == null && asistenciaBean.getFechaFCal() == null) {
				asistenciaBean.setFechaIni(new Long(0));
				asistenciaBean.setFechaFin(new Long(0));
			}
			System.out.println("fechainicio:" + asistenciaBean.getFechaIni());
			System.out.println("fechafin:" + asistenciaBean.getFechaFin());
//		String sectoristaName = String.valueOf(asistenciaBean.getSectorist_id());
			System.out.println("sectoristaName:" + asistenciaBean.getNameSec());
			System.out.println("check:" + asistenciaBean.isCheckSecEje());
			if (asistenciaBean.getNameSec() != "") {
				AsistenciaTecnica asis = asistenciaTecService.getSectoristaName(asistenciaBean.getNameSec());
				if (asis != null) {
					asistenciaBean.setSectorist_id(asis.getId());
				} else {
					asistenciaBean.setSectorist_id(0);

				}
			}
			System.out.println("Sectorist_id:" + asistenciaBean.getSectorist_id());
			this.validarSeleccion();
//		asistenciaBean.setSecEjec(0);
//		asistenciaBean.setDepartment(0);
//		asistenciaBean.setUnitName("");
//		asistenciaBean.setSectorist_id(0);
//		asistenciaBean.setIMPLANTADOR("");
//		asistenciaBean.setIsFunctional(0);
//		asistenciaBean.setIsTechnical(0);
//		asistenciaBean.setIsTraining(0);
//		asistenciaBean.setRepresentantName("");
//		asistenciaBean.setRepresentantWorkingPosition("");
			lstAsisTec = asistenciaTecService.getFindAsistencia(asistenciaBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			lstAsisTec = asistenciaTecService.listarAsistenciaTec();
			e.printStackTrace();
		}

	}

	public void resetearUser() {
		userBean = new AsistenciaTecnica();
		selectItemsAdm = new AsistenciaTecnica();
		setDisabledUser(false);
	}

	public void habilitarUser() {
		setDisabledUser(false);
	}

	public void evaluarMetodo() throws Exception {
		System.out.println("Id:" + this.selectItemsAdm.getIdAssip());
		if (this.selectItemsAdm.getIdAssip() == 0) {
			this.guardarAdmin();
		} else {
			this.updateAdmin();
		}
	}

	public void guardarAdmin() throws Exception {
		// userBean.setEstado("A");
		String horaIni = GenerateExpressions.ConvertHoraToString(userBean.getHoraIni());
		String horaFin = GenerateExpressions.ConvertHoraToString(userBean.getHoraFin());

		System.out.println("fechaVisCad:"+horaIni);
		System.out.println("horaVisCad:"+horaFin);

        userBean.setAssistanceStartTime(horaIni);
        userBean.setAssistanceEndTime(horaFin);
        
		genericoService.getSaveAsistenciaPres(userBean);
		lstAsisTec = genericoService.getAllAsistenciaPres();
	}

	public void updateAdmin() throws Exception {
//	 userBean.setEstado("A");
		String horaIni = GenerateExpressions.ConvertHoraToString(userBean.getHoraIni());
		String horaFin = GenerateExpressions.ConvertHoraToString(userBean.getHoraFin());

		System.out.println("fechaVisCad:"+horaIni);
		System.out.println("horaVisCad:"+horaFin);

        userBean.setAssistanceStartTime(horaIni);
        userBean.setAssistanceEndTime(horaFin);
        
		genericoService.getUpdateAsistenciPres(userBean);
		lstAsisTec = genericoService.getAllAsistenciaPres();
	}

	public void deleteAdmin() throws Exception {
		genericoService.getdeleteAsistenciaPres(this.getSelectItemsAdm().getIdAssip());
		listarAsistenciaTec();
	}

	public void vistaUser() {
		setDisabledUser(true);
		System.out.println("disabled:" + this.disabledUser);
	}

	public void selectedAdm() throws ParseException {
		Date horaICadena = GenerateExpressions.ConvertStringToHour(getSelectItemsAdm().getAssistanceStartTime());
		Date horaFCadena = GenerateExpressions.ConvertStringToHour(getSelectItemsAdm().getAssistanceEndTime());

		getSelectItemsAdm().setHoraIni(horaICadena);
		getSelectItemsAdm().setHoraFin(horaFCadena);

		setUserBean(getSelectItemsAdm());
		setDisabledUser(true);		
		FacesMessage msg = new FacesMessage("Asistencia Seleccionado", this.getSelectItemsAdm().getRepresentantName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
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

	public List<AsistenciaTecnica> getLstAsisTec() {
		return lstAsisTec;
	}

	public void setLstAsisTec(List<AsistenciaTecnica> lstAsisTec) {
		this.lstAsisTec = lstAsisTec;
	}

	public AsistenciaTecnica getAsistenciaBean() {
		return asistenciaBean;
	}

	public void setAsistenciaBean(AsistenciaTecnica asistenciaBean) {
		this.asistenciaBean = asistenciaBean;
	}

	public GenericoService getGenericoService() {
		return genericoService;
	}

	public void setGenericoService(GenericoService genericoService) {
		this.genericoService = genericoService;
	}

	public AsistenciaTecnica getUserBean() {
		return userBean;
	}

	public void setUserBean(AsistenciaTecnica userBean) {
		this.userBean = userBean;
	}

	public AsistenciaTecnica getSelectItemsAdm() {
		return selectItemsAdm;
	}

	public void setSelectItemsAdm(AsistenciaTecnica selectItemsAdm) {
		this.selectItemsAdm = selectItemsAdm;
	}

	public boolean isDisabledUser() {
		return disabledUser;
	}

	public void setDisabledUser(boolean disabledUser) {
		this.disabledUser = disabledUser;
	}

	public List<Entidad> getLstEntidad() {
		return lstEntidad;
	}

	public void setLstEntidad(List<Entidad> lstEntidad) {
		this.lstEntidad = lstEntidad;
	}

	public List<TipoLocal> getLstTipoLoc() {
		return lstTipoLoc;
	}

	public void setLstTipoLoc(List<TipoLocal> lstTipoLoc) {
		this.lstTipoLoc = lstTipoLoc;
	}

	public List<TipoSistema> getLstTipoSis() {
		return lstTipoSis;
	}

	public void setLstTipoSis(List<TipoSistema> lstTipoSis) {
		this.lstTipoSis = lstTipoSis;
	}

	public LoginController getLoginController() {
		return loginController;
	}

	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}

}
