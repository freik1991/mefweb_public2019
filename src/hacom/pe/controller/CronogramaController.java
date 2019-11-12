package hacom.pe.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import hacom.pe.datos.entidades.Cronograma;
import hacom.pe.datos.entidades.Departamento;
import hacom.pe.datos.entidades.Entidad;
import hacom.pe.datos.entidades.Implantador;
import hacom.pe.datos.entidades.Modalidad;
import hacom.pe.datos.entidades.Sectorista;
import hacom.pe.datos.entidades.TipoLocal;
import hacom.pe.datos.entidades.TipoSistema;
import hacom.pe.datos.entidades.TipoVisita;
import hacom.pe.service.GenericoService;
import hacom.pe.util.GenerateExpressions;

@ManagedBean(name = "cronogramaController")
@SessionScoped
public class CronogramaController {

	@ManagedProperty(value = "#{genericoService}")
	private GenericoService genericoService;

	private List<Cronograma> lstAdm;
	private Cronograma userBean;
	private Cronograma selectItemsAdm;
	private boolean disabledUser;
	private boolean displayEstado;

	private List<Entidad> lstEntidad;
	private List<TipoSistema> lstTipoSis;
	private List<TipoVisita> lstTipoVis;
    private List<Implantador> lstImp;
    
	@PostConstruct
	public void inicializarObjetos() {

		try {
			// lstGeo = genericoService.getAllGeozona();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String listaCronograma() throws Exception {
		userBean = new Cronograma();
		selectItemsAdm = new Cronograma();
		lstAdm = genericoService.getAllCronograma();
		this.cargarSelectAsistenciaRem();
		return "cronograma.jsf";
	}

	public void cargarSelectAsistenciaRem() throws Exception {
		lstEntidad = this.genericoService.getAllEntidadSel();
		lstTipoSis = this.genericoService.getAllTipoSistema();
		lstTipoVis = this.genericoService.getAllTipoVisita();
		lstImp = this.genericoService.getAllImplantadorSel();

	}

	public void resetearUser() {
		try {

			userBean = new Cronograma();
			selectItemsAdm = new Cronograma();
			this.cargarSelectAsistenciaRem();
			setDisplayEstado(false);
			setDisabledUser(false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void habilitarUser() throws Exception {
		setDisabledUser(false);
		cargarSelectAsistenciaRem();
	}

	public void evaluarMetodo() throws Exception {
		System.out.println("Id:" + this.selectItemsAdm.getIdCrono());
		if (this.selectItemsAdm.getIdCrono() == 0) {
			this.guardarAdmin();
		} else {
			this.updateAdmin();
		}
	}

	public void guardarAdmin() throws Exception {
		// userBean.setEstado("A");
		String fechaVisCad = GenerateExpressions.ConvertDateOneToString(userBean.getFechaVis());
		String horaVisCad = GenerateExpressions.ConvertHoraToString(userBean.getHoraVis());

		System.out.println("fechaVisCad:"+fechaVisCad);
		System.out.println("horaVisCad:"+horaVisCad);

        userBean.setVisitDate(fechaVisCad);
        userBean.setVisitHour(horaVisCad);
		genericoService.getSaveCronograma(userBean);
		lstAdm = genericoService.getAllCronograma();

	}

	public void updateAdmin() throws Exception {
//    	 userBean.setEstado("A");
		//Date fechaVis = GenerateExpressions.ConvertStringToDate(userBean.getVisitDate());
		String fechaVisCad = GenerateExpressions.ConvertDateOneToString(userBean.getFechaVis());
		String horaVisCad = GenerateExpressions.ConvertHoraToString(userBean.getHoraVis());

		System.out.println("fechaVisCad:"+fechaVisCad);
		System.out.println("horaVisCad:"+horaVisCad);

        userBean.setVisitDate(fechaVisCad);
        userBean.setVisitHour(horaVisCad);
		genericoService.getUpdateCronograma(userBean);
		lstAdm = genericoService.getAllCronograma();
	}

	public void deleteAdmin() throws Exception {
		genericoService.getdeleteCronograma(this.getSelectItemsAdm().getIdCrono());
		listaCronograma();
	}

	public void vistaUser() {
		setDisabledUser(true);
		System.out.println("disabled:" + this.disabledUser);
	}

	public void selectedAdm() throws ParseException {
		Date fechaCadena = GenerateExpressions.ConvertStringToDate(getSelectItemsAdm().getVisitDate());
		getSelectItemsAdm().setFechaVis(fechaCadena);
		Date horaCadena = GenerateExpressions.ConvertStringToHour(getSelectItemsAdm().getVisitHour());
		getSelectItemsAdm().setHoraVis(horaCadena);
		
		setUserBean(getSelectItemsAdm());
		setDisabledUser(true);
		setDisplayEstado(true);
//		FacesMessage msg = new FacesMessage("Cronograma Seleccionado",
//				this.getSelectItemsAdm().getUserItineraryDescription());
//		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public GenericoService getGenericoService() {
		return genericoService;
	}

	public void setGenericoService(GenericoService genericoService) {
		this.genericoService = genericoService;
	}

	public List<Cronograma> getLstAdm() {
		return lstAdm;
	}

	public void setLstAdm(List<Cronograma> lstAdm) {
		this.lstAdm = lstAdm;
	}

	public Cronograma getUserBean() {
		return userBean;
	}

	public void setUserBean(Cronograma userBean) {
		this.userBean = userBean;
	}

	public Cronograma getSelectItemsAdm() {
		return selectItemsAdm;
	}

	public void setSelectItemsAdm(Cronograma selectItemsAdm) {
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

	public List<Entidad> getLstEntidad() {
		return lstEntidad;
	}

	public void setLstEntidad(List<Entidad> lstEntidad) {
		this.lstEntidad = lstEntidad;
	}

	public List<TipoSistema> getLstTipoSis() {
		return lstTipoSis;
	}

	public void setLstTipoSis(List<TipoSistema> lstTipoSis) {
		this.lstTipoSis = lstTipoSis;
	}

	public List<TipoVisita> getLstTipoVis() {
		return lstTipoVis;
	}

	public void setLstTipoVis(List<TipoVisita> lstTipoVis) {
		this.lstTipoVis = lstTipoVis;
	}

	public List<Implantador> getLstImp() {
		return lstImp;
	}

	public void setLstImp(List<Implantador> lstImp) {
		this.lstImp = lstImp;
	}

}
