package hacom.pe.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import hacom.pe.datos.entidades.AsistenciaTecnica;
import hacom.pe.datos.entidades.Departamento;
import hacom.pe.datos.entidades.Encuesta;
import hacom.pe.service.AsistenciaTecService;
import hacom.pe.service.EncuestaService;
import hacom.pe.util.GenerateExpressions;

@ManagedBean(name = "encuestaController")
@SessionScoped
public class EncuestaController {

	@ManagedProperty(value = "#{encuestaService}")
	private EncuestaService encuestaService;

	@ManagedProperty(value = "#{asistenciaTecService}")
	private AsistenciaTecService asistenciaTecService;
	
	private List<Encuesta> lstAsis;
	private Encuesta encuestaBean;
    private List<Departamento> lstDepa;
    
    @PostConstruct
	public void inicializarObjetos() {
		lstAsis = new ArrayList<Encuesta>();
		lstDepa = new ArrayList<Departamento>();
		
		try {
			lstAsis = encuestaService.getAllEncuesta();
			lstDepa = asistenciaTecService.listarDepartamento();
			encuestaBean = new Encuesta();
			encuestaBean.setCheckFechaEnv(true);
			encuestaBean.setDisEnvio(true);
			encuestaBean.setRbFechaSelec("1");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
public void buscarDepa(){
		
		try {
			lstDepa = asistenciaTecService.listarDepartamento();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    public void validarSeleccion() {
    	if(!encuestaBean.isCheckSecEje()) {
    		encuestaBean.setSecEjec("");
    	}
    	if(!encuestaBean.isCheckDepa()) {
    		encuestaBean.setDepa(0);
    	}
    	if(!encuestaBean.isCheckEntidad()) {
    		encuestaBean.setUnitName("");
    	}
    	if(!encuestaBean.isCheckSectorista()) {
    		encuestaBean.setSectorist_names("");
    	}
    	if(!encuestaBean.isCheckImpl()) {
    		encuestaBean.setImplanter_names("");
    	}
    	if(!encuestaBean.isCheckFunc()) {
    		encuestaBean.setAns1("");
    	}
    	if(!encuestaBean.isCheckTec()) {
    		encuestaBean.setAns2("");
    	}
    	if(!encuestaBean.isCheckCap()) {
    		encuestaBean.setAns3("");
    	}
    	if(!encuestaBean.isCheckRep()) {
    		encuestaBean.setAssistance_representant("");
    	}
    	if(!encuestaBean.isCheckCarR()) {
    		encuestaBean.setAssistance_repr_work("");
    	}
    	if(!encuestaBean.isCheckFechaEnv()) {
    		encuestaBean.setFechaEnvioCadI("");
    		encuestaBean.setFechaEnvioCadF("");
    	}
    	if(!encuestaBean.isCheckFechaResp()) {
    		encuestaBean.setFechaRespCadI("");
    		encuestaBean.setFechaRespCadF("");
    	}
    }
    
    public void eventoButtonFecha() {
    	System.out.println("Evento Radio Button:"+encuestaBean.getRbFechaSelec());
    	if(encuestaBean.getRbFechaSelec().equals("1")) {
    		encuestaBean.setCheckFechaEnv(true);
    		encuestaBean.setDisEnvio(true);
    		encuestaBean.setDisResp(false);
    		encuestaBean.setCheckFechaResp(false);

    	}
    	if(encuestaBean.getRbFechaSelec().equals("2")) {
    		encuestaBean.setCheckFechaResp(true);
    		encuestaBean.setDisResp(true);
    		encuestaBean.setDisEnvio(false);
    		encuestaBean.setCheckFechaEnv(false);    	
    	}
    }
    
    
    public void filtroEncuesta() throws Exception {
		try {

			// lstAsisTec = asistenciaTecService.getFindAsistencia(encuestaBean);

			if(encuestaBean.getFechaEnvCalI() != null && encuestaBean.getFechaEnvCalF() != null) {
				String fechaEIni = GenerateExpressions.ConvertDateOneToString(encuestaBean.getFechaEnvCalI());
				String fechaEFin = GenerateExpressions.ConvertDateOneToString(encuestaBean.getFechaEnvCalF());
				
				encuestaBean.setFechaEnvioCadI(fechaEIni);
				encuestaBean.setFechaEnvioCadF(fechaEFin);
		
			}else {
				encuestaBean.setFechaEnvioCadI("");
				encuestaBean.setFechaEnvioCadF("");
			
			}
			
			System.out.println("FechaEnvCalI:"+encuestaBean.getFechaEnvCalI());
			if(encuestaBean.getFechaRespCalI() != null   && encuestaBean.getFechaRespCalF() != null) {
			
				String fechaRIni = GenerateExpressions.ConvertDateOneToString(encuestaBean.getFechaRespCalI());
				String fechaRFin = GenerateExpressions.ConvertDateOneToString(encuestaBean.getFechaRespCalF());

				encuestaBean.setFechaRespCadI(fechaRIni);
				encuestaBean.setFechaRespCadF(fechaRFin);
			}else {

				encuestaBean.setFechaRespCadI("");
				encuestaBean.setFechaRespCadF("");
			}
	
			System.out.println("fechainicio:" + encuestaBean.getFechaEnvioCadI());
			System.out.println("fechafin:" + encuestaBean.getFechaEnvioCadF());
			System.out.println("fechaRes:" + encuestaBean.getFechaRespCadI());
			System.out.println("fechaResf:" + encuestaBean.getFechaRespCadF());


			 this.validarSeleccion();
//			encuestaBean.setSecEjec(0);
//			encuestaBean.setDepartment(0);
//			encuestaBean.setUnitName("");
//			encuestaBean.setSectorist_id(0);
//			encuestaBean.setIMPLANTADOR("");
//			encuestaBean.setIsFunctional(0);
//			encuestaBean.setIsTechnical(0);
//			encuestaBean.setIsTraining(0);
//			encuestaBean.setRepresentantName("");
//			encuestaBean.setRepresentantWorkingPosition("");
			lstAsis = encuestaService.getFindEncuesta(encuestaBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
    
	public AsistenciaTecService getAsistenciaTecService() {
		return asistenciaTecService;
	}



	public void setAsistenciaTecService(AsistenciaTecService asistenciaTecService) {
		this.asistenciaTecService = asistenciaTecService;
	}



	public List<Encuesta> getLstAsis() {
		return lstAsis;
	}



	public void setLstAsis(List<Encuesta> lstAsis) {
		this.lstAsis = lstAsis;
	}



	public Encuesta getEncuestaBean() {
		return encuestaBean;
	}



	public void setEncuestaBean(Encuesta encuestaBean) {
		this.encuestaBean = encuestaBean;
	}



	public List<Departamento> getLstDepa() {
		return lstDepa;
	}



	public void setLstDepa(List<Departamento> lstDepa) {
		this.lstDepa = lstDepa;
	}



	public EncuestaService getEncuestaService() {
		return encuestaService;
	}

	public void setEncuestaService(EncuestaService encuestaService) {
		this.encuestaService = encuestaService;
	}
	
	
	
	
}
