package hacom.pe.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import hacom.pe.datos.entidades.AsistenciaTecnica;
import hacom.pe.datos.entidades.Departamento;
import hacom.pe.datos.entidades.Encuesta;
import hacom.pe.datos.entidades.Modulo;
import hacom.pe.datos.entidades.Motivo;
import hacom.pe.datos.entidades.MsUser;
import hacom.pe.datos.entidades.Visita;
import hacom.pe.service.AsistenciaTecService;
import hacom.pe.service.EncuestaService;
import hacom.pe.service.ModuloService;
import hacom.pe.service.UserService;
import hacom.pe.service.VisitaService;
import hacom.pe.util.GenerateExpressions;

@ManagedBean(name = "moduloController")
@SessionScoped
public class ModuloController {

	@ManagedProperty(value = "#{moduloService}")
	private ModuloService moduloService;

	private List<Modulo> lstAsis;
	private Modulo moduloBean;
	private List<Departamento> lstDepa;
	@ManagedProperty(value = "#{asistenciaTecService}")
	private AsistenciaTecService asistenciaTecService;
    private Modulo selectItemsAdm;
    private boolean disabledUser;
    private boolean displayEstado;
    
	@PostConstruct
	public void inicializarObjetos() {
		lstAsis = new ArrayList<Modulo>();
		lstDepa = new ArrayList<Departamento>();

		try {
			lstAsis = moduloService.getAllModulo();
			lstDepa = asistenciaTecService.listarDepartamento();
			moduloBean = new Modulo();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void buscarDepa() {

		try {
			lstDepa = asistenciaTecService.listarDepartamento();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    public String listaModulo() throws Exception{
    	moduloBean = new Modulo();
    	selectItemsAdm = new Modulo();
		lstAsis = moduloService.getAllModulo();
        return "modulomant.jsf";
    }

    public void resetearUser() {
   	 moduloBean = new Modulo();
        selectItemsAdm = new Modulo();
   	 setDisplayEstado(false);
   	 setDisabledUser(false);
    }
    
	public void validarSeleccion() {
		if (!moduloBean.isCheckModulo()) {
			moduloBean.setModuleName("");
		}
		if (!moduloBean.isCheckSystem()) {
			moduloBean.setSystem_id(0);
		}

	}

	  public void habilitarUser() {
	    	 setDisabledUser(false);
	     }
	  
	  public void evaluarMetodo() throws Exception {
	    	 System.out.println("Id:"+this.selectItemsAdm.getId());
	    	 if(this.selectItemsAdm.getId() == 0) {
	    		 this.guardarAdmin();
	    	 }else {
	    		 this.updateAdmin();
	    	 }
	     }
	  
	  public void guardarAdmin() throws Exception {
	    	// userBean.setEstado("A");
		 
		    moduloBean.setStatus(1);
	    	moduloService.getSaveModulo(moduloBean);
	 	    lstAsis = moduloService.getAllModulo();
	     }
	  
	  public void deleteAdmin() throws Exception {
		  moduloService.getdeleteModulo(this.getSelectItemsAdm().getId());
	    	 listaModulo();
	     }
	  
	  public void updateAdmin() throws Exception {
//	    	 userBean.setEstado("A");
		  moduloService.getUpdateModulo(moduloBean);
	 		 lstAsis = moduloService.getAllModulo();
	     }	
	  
	  public void selectedAdm() {
	    	 setModuloBean(getSelectItemsAdm());
	    	 setDisabledUser(true);
	    	 setDisplayEstado(true);
//	         FacesMessage msg = new FacesMessage("Modulo Seleccionado", this.getSelectItemsAdm().getModuleName());
//	         FacesContext.getCurrentInstance().addMessage(null, msg);
	     }
	  
	public void filtroModulo() throws Exception {
		try {

			this.validarSeleccion();

			lstAsis = moduloService.getFindModulo(moduloBean);
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

	

	public ModuloService getModuloService() {
		return moduloService;
	}

	public void setModuloService(ModuloService moduloService) {
		this.moduloService = moduloService;
	}

	public List<Modulo> getLstAsis() {
		return lstAsis;
	}

	public void setLstAsis(List<Modulo> lstAsis) {
		this.lstAsis = lstAsis;
	}

	public Modulo getModuloBean() {
		return moduloBean;
	}

	public void setModuloBean(Modulo moduloBean) {
		this.moduloBean = moduloBean;
	}

	public List<Departamento> getLstDepa() {
		return lstDepa;
	}

	public void setLstDepa(List<Departamento> lstDepa) {
		this.lstDepa = lstDepa;
	}

	public Modulo getSelectItemsAdm() {
		return selectItemsAdm;
	}

	public void setSelectItemsAdm(Modulo selectItemsAdm) {
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

}
