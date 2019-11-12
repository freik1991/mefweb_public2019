package hacom.pe.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import hacom.pe.datos.entidades.AsistenciaRemota;
import hacom.pe.datos.entidades.Departamento;
import hacom.pe.datos.entidades.Entidad;
import hacom.pe.datos.entidades.Implantador;
import hacom.pe.datos.entidades.Modalidad;
import hacom.pe.datos.entidades.Reporte;
import hacom.pe.datos.entidades.Sectorista;
import hacom.pe.datos.entidades.TipoLocal;
import hacom.pe.datos.entidades.TipoSistema;
import hacom.pe.service.AsistenciaRemotaService;
import hacom.pe.service.AsistenciaTecService;
import hacom.pe.service.GenericoService;
import hacom.pe.service.ReporteService;

@ManagedBean(name = "reporteController")
@SessionScoped
public class ReporteController {
	
	@ManagedProperty(value = "#{asistenciaRemotaService}")
	private AsistenciaRemotaService asistenciaRemotaService;

	@ManagedProperty(value = "#{genericoService}")
	private GenericoService genericoService;
	
	@ManagedProperty(value = "#{reporteService}")
	private ReporteService reporteService;
	
	
	private List<AsistenciaRemota> lstAsisRem;
	private AsistenciaRemota asistenciaRemotaBean;

	@ManagedProperty(value = "#{asistenciaTecService}")
	private AsistenciaTecService asistenciaTecService;
	private List<Entidad> lstEntidad;
    private List<Sectorista> lstSec;
    private List<Implantador> lstImp;
    private List<Modalidad> lstModa;
    private List<TipoSistema> lstTipoSis;
    private List<Departamento> lstDepa;
    
    private List<Reporte> lstCalidadSer;
    private List<Reporte> lstEvaluacionTec;
    private List<Reporte> lstEvaluacionRem;
    private List<Reporte> lstResumenVis;
    private List<Reporte> lstServicioPres;

    private boolean menusView;
	
	@PostConstruct
	public void inicializarObjetos() {
		lstAsisRem = new ArrayList<AsistenciaRemota>();
		try {
			asistenciaRemotaBean = new AsistenciaRemota();
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
		if (!asistenciaRemotaBean.isCheckTipA()) {
			asistenciaRemotaBean.setRegistro(0);
		}

		if (!asistenciaRemotaBean.isCheckFechaAsisRIni()) {
			asistenciaRemotaBean.setFechaAsisIni(new Long(0));
			asistenciaRemotaBean.setFechaAsisHas(new Long(0));
		}
		if (!asistenciaRemotaBean.isCheckFechaAsisRFin()) {
			asistenciaRemotaBean.setFechaRegIni(new Long(0));
			asistenciaRemotaBean.setFechaRegHas(new Long(0));
		}

	}
	
	
	public void cargarSelectAsistenciaRem() throws Exception {
		lstEntidad = this.genericoService.getAllEntidadSel();
		lstDepa = this.asistenciaTecService.listarDepartamento();
		lstSec = this.genericoService.getAllSectoristaAdm();
		lstImp = this.genericoService.getAllImplantadorSel();
		lstModa = this.genericoService.getAllTipoModalidad();
		lstTipoSis = this.genericoService.getAllTipoSistema();
		
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

	 public String listaAsistenciaRemota() throws Exception{
		 System.out.println("prueba");
			lstCalidadSer = reporteService.getAllCalidadServicio();
	        return "calidadServicioRemoto.jsf";
	 }

	 public String listaEvaluacionTecnica() throws Exception{
			lstEvaluacionTec = reporteService.getAllEvaluacionAtencion();
	        return "evaluacionTecnica.jsf";
	 }
	 
	 public String listaEvaluacionRemota() throws Exception{
			lstEvaluacionRem = reporteService.getAllEvaluacionRemota();
	        return "evaluacionRemota.jsf";
	 }
	 
	 public String listaResumen() throws Exception{
			lstResumenVis = reporteService.getAllResumenVisita();
	        return "resumenVisita.jsf";
	 }
	 
	 public String listaServicioPresencial() throws Exception{
			lstServicioPres = reporteService.getAllServicioPresencial();
	        return "calidadServicioPresencial.jsf";
	 }
	
	 
	public AsistenciaRemotaService getAsistenciaRemotaService() {
		return asistenciaRemotaService;
	}


	public void setAsistenciaRemotaService(AsistenciaRemotaService asistenciaRemotaService) {
		this.asistenciaRemotaService = asistenciaRemotaService;
	}


	public List<AsistenciaRemota> getLstAsisRem() {
		return lstAsisRem;
	}


	public void setLstAsisRem(List<AsistenciaRemota> lstAsisRem) {
		this.lstAsisRem = lstAsisRem;
	}


	public AsistenciaRemota getAsistenciaRemotaBean() {
		return asistenciaRemotaBean;
	}


	public void setAsistenciaRemotaBean(AsistenciaRemota asistenciaRemotaBean) {
		this.asistenciaRemotaBean = asistenciaRemotaBean;
	}

	public GenericoService getGenericoService() {
		return genericoService;
	}

	public void setGenericoService(GenericoService genericoService) {
		this.genericoService = genericoService;
	}

	public AsistenciaTecService getAsistenciaTecService() {
		return asistenciaTecService;
	}

	public void setAsistenciaTecService(AsistenciaTecService asistenciaTecService) {
		this.asistenciaTecService = asistenciaTecService;
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

	public List<Departamento> getLstDepa() {
		return lstDepa;
	}

	public void setLstDepa(List<Departamento> lstDepa) {
		this.lstDepa = lstDepa;
	}

	public List<Reporte> getLstCalidadSer() {
		return lstCalidadSer;
	}

	public void setLstCalidadSer(List<Reporte> lstCalidadSer) {
		this.lstCalidadSer = lstCalidadSer;
	}

	public List<Reporte> getLstEvaluacionTec() {
		return lstEvaluacionTec;
	}

	public void setLstEvaluacionTec(List<Reporte> lstEvaluacionTec) {
		this.lstEvaluacionTec = lstEvaluacionTec;
	}

	public List<Reporte> getLstEvaluacionRem() {
		return lstEvaluacionRem;
	}

	public void setLstEvaluacionRem(List<Reporte> lstEvaluacionRem) {
		this.lstEvaluacionRem = lstEvaluacionRem;
	}

	public List<Reporte> getLstResumenVis() {
		return lstResumenVis;
	}

	public void setLstResumenVis(List<Reporte> lstResumenVis) {
		this.lstResumenVis = lstResumenVis;
	}

	public boolean isMenusView() {
		return menusView;
	}

	public void setMenusView(boolean menusView) {
		this.menusView = menusView;
	}

	public ReporteService getReporteService() {
		return reporteService;
	}

	public void setReporteService(ReporteService reporteService) {
		this.reporteService = reporteService;
	}

	public List<Reporte> getLstServicioPres() {
		return lstServicioPres;
	}

	public void setLstServicioPres(List<Reporte> lstServicioPres) {
		this.lstServicioPres = lstServicioPres;
	}
	
	
	
}
