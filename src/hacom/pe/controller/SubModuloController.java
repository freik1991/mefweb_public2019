package hacom.pe.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import hacom.pe.datos.entidades.Modulo;
import hacom.pe.datos.entidades.SubModulo;
import hacom.pe.service.GenericoService;
import hacom.pe.service.ModuloService;

@ManagedBean(name = "subModuloController")
@SessionScoped
public class SubModuloController {

	
	@ManagedProperty(value = "#{genericoService}")
	private GenericoService genericoService;

	@ManagedProperty(value = "#{moduloService}")
	private ModuloService moduloService;
	
	private List<SubModulo> lstAdm;
    private SubModulo userBean;
    private SubModulo selectItemsAdm;
    private boolean disabledUser;
    private boolean displayEstado;
    private List<Modulo> lstMod;
    
    @PostConstruct
	public void inicializarObjetos() {
		
		try {
			//lstGeo = genericoService.getAllGeozona();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    public String listaSubModulo() throws Exception{
    	userBean = new SubModulo();
    	selectItemsAdm = new SubModulo();
		lstAdm = genericoService.getAllSubModulo();
		lstMod = moduloService.getAllModulo();
        return "submodulo.jsf";
    }

    
     
     public void resetearUser() {
    	 userBean = new SubModulo();
         selectItemsAdm = new SubModulo();
    	 setDisplayEstado(false);
    	 setDisabledUser(false);
     }

     public void habilitarUser() {
    	 setDisabledUser(false);
     }
     
     public void evaluarMetodo() throws Exception {
    	 System.out.println("Id:"+this.selectItemsAdm.getSubModuleID());
    	 if(this.selectItemsAdm.getSubModuleID() == 0) {
    		 this.guardarAdmin();
    	 }else {
    		 this.updateAdmin();
    	 }
     }
     public void guardarAdmin() throws Exception {
    	userBean.setStatus(1);
    	 genericoService.getSaveSubModulo(userBean);
 		lstAdm = genericoService.getAllSubModulo();
     }
	
     public void updateAdmin() throws Exception {
//    	 userBean.setEstado("A");
    	 genericoService.getUpdateSubModulo(userBean);
 		 lstAdm = genericoService.getAllSubModulo();
     }	
     public void deleteAdmin() throws Exception {
    	 genericoService.getdeleteSubModulo(this.getSelectItemsAdm().getSubModuleID());
    	 listaSubModulo();
     }
     
     public void vistaUser() {
    	 setDisabledUser(true);
    	 System.out.println("disabled:"+this.disabledUser);
     }
     
     
     public void selectedAdm() {
    	 setUserBean(getSelectItemsAdm());
    	 setDisabledUser(true);
    	 setDisplayEstado(true);
//         FacesMessage msg = new FacesMessage("SubModulo Seleccionado", this.getSelectItemsAdm().getSubModuleName());
//         FacesContext.getCurrentInstance().addMessage(null, msg);
     }
     
	public GenericoService getGenericoService() {
		return genericoService;
	}



	public void setGenericoService(GenericoService genericoService) {
		this.genericoService = genericoService;
	}


	public List<SubModulo> getLstAdm() {
		return lstAdm;
	}


	public void setLstAdm(List<SubModulo> lstAdm) {
		this.lstAdm = lstAdm;
	}


	public SubModulo getUserBean() {
		return userBean;
	}


	public void setUserBean(SubModulo userBean) {
		this.userBean = userBean;
	}


	public SubModulo getSelectItemsAdm() {
		return selectItemsAdm;
	}


	public void setSelectItemsAdm(SubModulo selectItemsAdm) {
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


	public List<Modulo> getLstMod() {
		return lstMod;
	}


	public void setLstMod(List<Modulo> lstMod) {
		this.lstMod = lstMod;
	}


	public ModuloService getModuloService() {
		return moduloService;
	}


	public void setModuloService(ModuloService moduloService) {
		this.moduloService = moduloService;
	}




}
