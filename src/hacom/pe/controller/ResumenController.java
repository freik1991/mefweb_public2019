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
import hacom.pe.datos.entidades.Resumen;
import hacom.pe.datos.entidades.Visita;
import hacom.pe.service.AsistenciaTecService;
import hacom.pe.service.EncuestaService;
import hacom.pe.service.ResumenService;
import hacom.pe.service.VisitaService;
import hacom.pe.util.GenerateExpressions;

@ManagedBean(name = "resumenController")
@SessionScoped
public class ResumenController {

	@ManagedProperty(value = "#{resumenService}")
	private ResumenService resumenService;

	
	
	private List<Resumen> lstAsis;
	private Resumen resumenBean;
    private List<Departamento> lstDepa;
	@ManagedProperty(value = "#{asistenciaTecService}")
	private AsistenciaTecService asistenciaTecService;
	
    @PostConstruct
	public void inicializarObjetos() {
		lstAsis = new ArrayList<Resumen>();
		lstDepa = new ArrayList<Departamento>();
		
		try {
			lstAsis = resumenService.getAllResumen();
			lstDepa = asistenciaTecService.listarDepartamento();
			resumenBean = new Resumen();


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


   
    
 
    
    public void filtroResumen() throws Exception {
		try {

			// lstAsisTec = asistenciaTecService.getFindAsistencia(resumenBean);

			if(resumenBean.getFechaResCalI() != null && resumenBean.getFechaResCalF() != null) {
				String fechaEIni = GenerateExpressions.ConvertDateOneToString(resumenBean.getFechaResCalI());
				String fechaEFin = GenerateExpressions.ConvertDateOneToString(resumenBean.getFechaResCalF());
				
				resumenBean.setFechaVisCadI(fechaEIni);
				resumenBean.setFechaVisCadF(fechaEFin);
		
			}else {
				resumenBean.setFechaVisCadI("");
				resumenBean.setFechaVisCadF("");
			
			}
								
			lstAsis = resumenService.getFindResumen(resumenBean);
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


	public List<Departamento> getLstDepa() {
		return lstDepa;
	}



	public void setLstDepa(List<Departamento> lstDepa) {
		this.lstDepa = lstDepa;
	}

	public ResumenService getResumenService() {
		return resumenService;
	}

	public void setResumenService(ResumenService resumenService) {
		this.resumenService = resumenService;
	}

	public List<Resumen> getLstAsis() {
		return lstAsis;
	}

	public void setLstAsis(List<Resumen> lstAsis) {
		this.lstAsis = lstAsis;
	}

	public Resumen getResumenBean() {
		return resumenBean;
	}

	public void setResumenBean(Resumen resumenBean) {
		this.resumenBean = resumenBean;
	}



	
}
