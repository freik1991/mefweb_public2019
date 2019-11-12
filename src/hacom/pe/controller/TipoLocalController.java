package hacom.pe.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import hacom.pe.datos.entidades.TipoLocal;
import hacom.pe.service.GenericoService;


@ManagedBean(name = "tipoLocalController")
@SessionScoped
public class TipoLocalController{

	
	@ManagedProperty(value = "#{genericoService}")
	private GenericoService genericoService;

	private List<TipoLocal> lstAdm;
    private TipoLocal userBean;
    private TipoLocal selectItemsAdm;
    private boolean disabledUser;
    private boolean displayEstado;
    
    
    @PostConstruct
	public void inicializarObjetos() {
		
		try {
			//lstGeo = genericoService.getAllGeozona();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    public String listaTipoLocal() throws Exception{
    	userBean = new TipoLocal();
    	selectItemsAdm = new TipoLocal();
		lstAdm = genericoService.getAllTipoLocal();
        return "tipolocal.jsf";
    }

    
     
     public void resetearUser() {
    	 userBean = new TipoLocal();
         selectItemsAdm = new TipoLocal();
    	 setDisplayEstado(false);
    	 setDisabledUser(false);
     }

     public void habilitarUser() {
    	 setDisabledUser(false);
     }
     
     public void evaluarMetodo() throws Exception {
    	 System.out.println("Id:"+this.selectItemsAdm.getIdTipoLocal());
    	 if(this.selectItemsAdm.getIdTipoLocal() == 0) {
    		 this.guardarAdmin();
    	 }else {
    		 this.updateAdmin();
    	 }
     }
     public void guardarAdmin() throws Exception {
    	// userBean.setEstado("A");
    	 genericoService.getSaveTipoLocal(userBean);
 		lstAdm = genericoService.getAllTipoLocal();
     }
	
     public void updateAdmin() throws Exception {
//    	 userBean.setEstado("A");
    	 genericoService.getUpdateTipoLocal(userBean);
 		 lstAdm = genericoService.getAllTipoLocal();
     }	
     public void deleteAdmin() throws Exception {
    	 genericoService.getdeleteTipoLocal(this.getSelectItemsAdm().getIdTipoLocal());
    	 listaTipoLocal();
     }
     
     public void vistaUser() {
    	 setDisabledUser(true);
    	 System.out.println("disabled:"+this.disabledUser);
     }
     
     
     public void selectedAdm() {
    	 setUserBean(getSelectItemsAdm());
    	 setDisabledUser(true);
    	 setDisplayEstado(true);
//         FacesMessage msg = new FacesMessage("TipoLocal Seleccionado", this.getSelectItemsAdm().getTipoLocal());
//         FacesContext.getCurrentInstance().addMessage(null, msg);
     }
     
	public GenericoService getGenericoService() {
		return genericoService;
	}



	public void setGenericoService(GenericoService genericoService) {
		this.genericoService = genericoService;
	}


	public List<TipoLocal> getLstAdm() {
		return lstAdm;
	}


	public void setLstAdm(List<TipoLocal> lstAdm) {
		this.lstAdm = lstAdm;
	}


	public TipoLocal getUserBean() {
		return userBean;
	}


	public void setUserBean(TipoLocal userBean) {
		this.userBean = userBean;
	}


	public TipoLocal getSelectItemsAdm() {
		return selectItemsAdm;
	}


	public void setSelectItemsAdm(TipoLocal selectItemsAdm) {
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
