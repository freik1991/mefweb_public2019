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

import hacom.pe.datos.entidades.Actividad;
import hacom.pe.datos.entidades.Capacitador;
import hacom.pe.datos.entidades.Implantador;
import hacom.pe.datos.entidades.Motivo;
import hacom.pe.datos.entidades.TipoSistema;
import hacom.pe.service.GenericoService;
import hacom.pe.util.GenerateExpressions;

@ManagedBean(name = "actividadController")
@SessionScoped
public class ActividadController {

	
	@ManagedProperty(value = "#{genericoService}")
	private GenericoService genericoService;

	private List<Actividad> lstAdm;
    private Actividad userBean;
    private Actividad selectItemsAdm;
    private boolean disabledUser;
    private boolean displayEstado;
	private List<Motivo> lstMot;
	private List<TipoSistema> lstTipoSis;
	private List<Implantador> lstImp;
	private int idCapacitador;
	@ManagedProperty(value = "#{loginController}")
	private LoginController loginController;
    
    @PostConstruct
	public void inicializarObjetos() {
		
		try {
			//lstGeo = genericoService.getAllGeozona();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    public String listaActividad() throws Exception{
    	userBean = new Actividad();
    	selectItemsAdm = new Actividad();
		lstAdm = genericoService.getAllActividad();
		Actividad act=new Actividad();
		act.setCapacitadorId(idlogin());
		lstAdm = genericoService.getFindActividadID(act);
   	    this.cargarSelect();
        return "actividad.jsf";
    }

    
    public int idlogin() throws Exception {
		Capacitador cap=new Capacitador();
		cap.setUsuario(loginController.getNombre());
		Capacitador capacitador=this.genericoService.getFindCapacitadorId(cap);
		if(capacitador != null) {
			setIdCapacitador(capacitador.getIdCap());
		}else {
			setIdCapacitador(0);
		}		return getIdCapacitador();
	}
    
    
     public void resetearUser(){
    	 userBean = new Actividad();
         selectItemsAdm = new Actividad();
    	 setDisplayEstado(false);
    	 setDisabledUser(false);
     }

     public void cargarSelect() throws Exception {
    	 lstImp = this.genericoService.getAllImplantadorSel();
    	 lstMot = this.genericoService.getAllTipoMotivo();
    	 lstTipoSis = this.genericoService.getAllTipoSistema();
     }
     public void habilitarUser() {
    	 setDisabledUser(false);
     }
     
     public void evaluarMetodo() throws Exception {
    	 System.out.println("Id:"+this.selectItemsAdm.getIdAct());
    	 if(this.selectItemsAdm.getIdAct() == 0) {
    		 this.guardarAdmin();
    	 }else {
    		 this.updateAdmin();
    	 }
     }
     public void guardarAdmin() throws Exception {
    	// userBean.setEstado("A");
    		String fechaVisCad = GenerateExpressions.ConvertDateOneToString(userBean.getFechaVis());

    		System.out.println("fechaVisCad:"+fechaVisCad);
            userBean.setIdCap(getIdCapacitador());		

         userBean.setActivitieDate(fechaVisCad);
    	 genericoService.getSaveActividad(userBean);
    	 Actividad act=new Actividad();
 		act.setCapacitadorId(idlogin());
 		lstAdm = genericoService.getFindActividadID(act);
     }
	
     public void updateAdmin() throws Exception {
//    	 userBean.setEstado("A");
    	 String fechaVisCad = GenerateExpressions.ConvertDateOneToString(userBean.getFechaVis());

 		System.out.println("fechaVisCad:"+fechaVisCad);

         userBean.setActivitieDate(fechaVisCad);
    	 genericoService.getUpdateActividad(userBean);
    	 Actividad act=new Actividad();
 		act.setCapacitadorId(idlogin());
 		lstAdm = genericoService.getFindActividadID(act);
     }	
     public void deleteAdmin() throws Exception {
    	 genericoService.getdeleteActividad(this.getSelectItemsAdm().getIdAct());
    	 listaActividad();
     }
     
     public void vistaUser() {
    	 setDisabledUser(true);
    	 System.out.println("disabled:"+this.disabledUser);
     }
     
     
     public void selectedAdm() throws ParseException {
    	 Date fechaCadena = GenerateExpressions.ConvertStringToDate(getSelectItemsAdm().getActivitieDate());
 		 getSelectItemsAdm().setFechaVis(fechaCadena);
    	 setUserBean(getSelectItemsAdm());
    	 setDisabledUser(true);
    	 setDisplayEstado(true);
         FacesMessage msg = new FacesMessage("Actividad Seleccionado", this.getSelectItemsAdm().getComment());
         FacesContext.getCurrentInstance().addMessage(null, msg);
     }
     
	public GenericoService getGenericoService() {
		return genericoService;
	}



	public void setGenericoService(GenericoService genericoService) {
		this.genericoService = genericoService;
	}


	public List<Actividad> getLstAdm() {
		return lstAdm;
	}


	public void setLstAdm(List<Actividad> lstAdm) {
		this.lstAdm = lstAdm;
	}


	public Actividad getUserBean() {
		return userBean;
	}


	public void setUserBean(Actividad userBean) {
		this.userBean = userBean;
	}


	public Actividad getSelectItemsAdm() {
		return selectItemsAdm;
	}


	public void setSelectItemsAdm(Actividad selectItemsAdm) {
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


	public List<Motivo> getLstMot() {
		return lstMot;
	}


	public void setLstMot(List<Motivo> lstMot) {
		this.lstMot = lstMot;
	}


	public List<TipoSistema> getLstTipoSis() {
		return lstTipoSis;
	}


	public void setLstTipoSis(List<TipoSistema> lstTipoSis) {
		this.lstTipoSis = lstTipoSis;
	}


	public List<Implantador> getLstImp() {
		return lstImp;
	}


	public void setLstImp(List<Implantador> lstImp) {
		this.lstImp = lstImp;
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
