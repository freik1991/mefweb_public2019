package hacom.pe.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import hacom.pe.service.IncidenciaService;
import hacom.pe.util.GenerateExpressions;
import hacom.pe.datos.entidades.AsistenciaTecnica;
import hacom.pe.datos.entidades.Incidencias;

@ManagedBean(name = "incidenciaController")
@SessionScoped
public class IncidenciaController {

	@ManagedProperty(value = "#{incidenciaService}")
	private IncidenciaService incidenciaService;

	private List<Incidencias> lstInc ;
private Incidencias inciBean;

	@PostConstruct
	public void inicializarObjetos() {
		lstInc = new ArrayList<Incidencias>();
		inciBean = new Incidencias();
		try {
			lstInc = incidenciaService.listarIncidencias();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void validarSeleccion() {
		if(!inciBean.isCheckSecEje()) {
			inciBean.setSecEjec("");
		}
		
		if(!inciBean.isCheckEntidad()) {
			inciBean.setUnitName("");
		}
		if(!inciBean.isCheckSectorista()) {
			inciBean.setSectorist_names("");
		
		}
		if(!inciBean.isCheckImpl()) {
			inciBean.setImplanterName("");;
		}

		if(!inciBean.isCheckSis()) {
			inciBean.setSystemName("");
		}
	
			
	}
	
	public void filtroIncidencia() throws Exception {
		try {
			
		
		
//			String sectoristaName = String.valueOf(inciBean.getSectorist_id());
			if(inciBean.getFechaIncICal() != null && inciBean.getFechaIncFCal() != null) {
				String fechaIni = GenerateExpressions.ConvertDateOneToStringIn(inciBean.getFechaIncICal());
				String fechaFin = GenerateExpressions.ConvertDateOneToStringIn(inciBean.getFechaIncFCal());

				inciBean.setFechaIncIni(fechaIni);
				inciBean.setFechaIncHas(fechaFin);
			}else {
				inciBean.setFechaIncIni("");
				inciBean.setFechaIncHas("");
			}
			System.out.println("fechainicio:"+inciBean.getFechaIncIni());
			System.out.println("fechafin:"+inciBean.getFechaIncHas());

			this.validarSeleccion();

			lstInc = incidenciaService.findIncidencias(inciBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    	
	    }

	
	public IncidenciaService getIncidenciaService() {
		return incidenciaService;
	}

	public void setIncidenciaService(IncidenciaService incidenciaService) {
		this.incidenciaService = incidenciaService;
	}


	public List<Incidencias> getLstInc() {
		return lstInc;
	}


	public void setLstInc(List<Incidencias> lstInc) {
		this.lstInc = lstInc;
	}

	public Incidencias getInciBean() {
		return inciBean;
	}

	public void setInciBean(Incidencias inciBean) {
		this.inciBean = inciBean;
	}
	
	
	
}
