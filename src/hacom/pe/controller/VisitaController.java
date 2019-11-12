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
import hacom.pe.datos.entidades.Visita;
import hacom.pe.service.AsistenciaTecService;
import hacom.pe.service.EncuestaService;
import hacom.pe.service.VisitaService;
import hacom.pe.util.GenerateExpressions;

@ManagedBean(name = "visitaController")
@SessionScoped
public class VisitaController {

	@ManagedProperty(value = "#{visitaService}")
	private VisitaService visitaService;

	
	
	private List<Visita> lstAsis;
	private Visita visitaBean;
    private List<Departamento> lstDepa;
	@ManagedProperty(value = "#{asistenciaTecService}")
	private AsistenciaTecService asistenciaTecService;
	
    @PostConstruct
	public void inicializarObjetos() {
		lstAsis = new ArrayList<Visita>();
		lstDepa = new ArrayList<Departamento>();
		
		try {
			lstAsis = visitaService.getAllVisita();
			lstDepa = asistenciaTecService.listarDepartamento();
			visitaBean = new Visita();


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
    	if(!visitaBean.isCheckSecEje()) {
    		visitaBean.setSecEjec("");
    	}
    	if(!visitaBean.isCheckDepa()) {
    		visitaBean.setDepa(0);
    	}
    
    	if(!visitaBean.isCheckSectorista()) {
    		visitaBean.setSectorist_names("");
    	}
    	if(!visitaBean.isCheckImpl()) {
    		visitaBean.setImplanter_names("");
    	}
    	
    	
    }
    
 
    
    public void filtroVisita() throws Exception {
		try {

			// lstAsisTec = asistenciaTecService.getFindAsistencia(visitaBean);

			if(visitaBean.getFechaVisCalI() != null && visitaBean.getFechaVisCalF() != null) {
				String fechaEIni = GenerateExpressions.ConvertDateOneToString(visitaBean.getFechaVisCalI());
				String fechaEFin = GenerateExpressions.ConvertDateOneToString(visitaBean.getFechaVisCalF());
				
				visitaBean.setFechaVisCadI(fechaEIni);
				visitaBean.setFechaVisCadF(fechaEFin);
		
			}else {
				visitaBean.setFechaVisCadI("");
				visitaBean.setFechaVisCadF("");
			
			}
			
			
			System.out.println("depa:"+visitaBean.getDepa());
			 this.validarSeleccion();

			lstAsis = visitaService.getFindEncuesta(visitaBean);
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



	


	public VisitaService getVisitaService() {
		return visitaService;
	}

	public void setVisitaService(VisitaService visitaService) {
		this.visitaService = visitaService;
	}

	public List<Visita> getLstAsis() {
		return lstAsis;
	}

	public void setLstAsis(List<Visita> lstAsis) {
		this.lstAsis = lstAsis;
	}

	public Visita getVisitaBean() {
		return visitaBean;
	}

	public void setVisitaBean(Visita visitaBean) {
		this.visitaBean = visitaBean;
	}

	public List<Departamento> getLstDepa() {
		return lstDepa;
	}



	public void setLstDepa(List<Departamento> lstDepa) {
		this.lstDepa = lstDepa;
	}



	
}
