package hacom.pe.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import hacom.pe.datos.entidades.TipoSistema;
import hacom.pe.datos.entidades.TipoUe;
import hacom.pe.service.GenericoService;

@ManagedBean(name = "tipoSistemaController")
@SessionScoped
public class TipoSistemaController {

	
	@ManagedProperty(value = "#{genericoService}")
	private GenericoService genericoService;

	private List<TipoSistema> lstAdm;
    private TipoSistema userBean;
    private TipoSistema selectItemsAdm;
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


    public String listaTipoSistema() throws Exception{
    	userBean = new TipoSistema();
    	selectItemsAdm = new TipoSistema();
		lstAdm = genericoService.getAllTipoSistema();
        return "tiposistema.jsf";
    }

    
     
     public void resetearUser() {
    	 userBean = new TipoSistema();
         selectItemsAdm = new TipoSistema();
    	 setDisplayEstado(false);
    	 setDisabledUser(false);
     }

     public void habilitarUser() {
    	 setDisabledUser(false);
     }
     
     public void evaluarMetodo() throws Exception {
    	 System.out.println("Id:"+this.selectItemsAdm.getIdTiposis());
    	 if(this.selectItemsAdm.getIdTiposis() == 0) {
    		 this.guardarAdmin();
    	 }else {
    		 this.updateAdmin();
    	 }
     }
     public void guardarAdmin() throws Exception {
    	// userBean.setEstado("A");
    	 genericoService.getSaveTipoSistema(userBean);
 		lstAdm = genericoService.getAllTipoSistema();
     }
	
     public void updateAdmin() throws Exception {
//    	 userBean.setEstado("A");
    	 genericoService.getUpdateTipoSistema(userBean);
 		 lstAdm = genericoService.getAllTipoSistema();
     }	
     public void deleteAdmin() throws Exception {
    	 genericoService.getdeleteTipoSitema(this.getSelectItemsAdm().getIdTiposis());
    	 listaTipoSistema();
     }
     
     public void vistaUser() {
    	 setDisabledUser(true);
    	 System.out.println("disabled:"+this.disabledUser);
     }
     
     
     public void selectedAdm() {
    	 setUserBean(getSelectItemsAdm());
    	 setDisabledUser(true);
    	 setDisplayEstado(true);
//         FacesMessage msg = new FacesMessage("TipoUe Seleccionado", this.getSelectItemsAdm().getTipoSistema());
//         FacesContext.getCurrentInstance().addMessage(null, msg);
     }
     
	public GenericoService getGenericoService() {
		return genericoService;
	}



	public void setGenericoService(GenericoService genericoService) {
		this.genericoService = genericoService;
	}


	

	public List<TipoSistema> getLstAdm() {
		return lstAdm;
	}


	public void setLstAdm(List<TipoSistema> lstAdm) {
		this.lstAdm = lstAdm;
	}


	public TipoSistema getUserBean() {
		return userBean;
	}


	public void setUserBean(TipoSistema userBean) {
		this.userBean = userBean;
	}


	public TipoSistema getSelectItemsAdm() {
		return selectItemsAdm;
	}


	public void setSelectItemsAdm(TipoSistema selectItemsAdm) {
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

