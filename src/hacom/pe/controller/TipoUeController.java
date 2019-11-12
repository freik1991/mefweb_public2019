package hacom.pe.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import hacom.pe.datos.entidades.Entidad;
import hacom.pe.datos.entidades.Geozona;
import hacom.pe.datos.entidades.MsUser;
import hacom.pe.datos.entidades.TipoUe;
import hacom.pe.service.GenericoService;

@ManagedBean(name = "tipoUeController")
@SessionScoped
public class TipoUeController {

	
	@ManagedProperty(value = "#{genericoService}")
	private GenericoService genericoService;

	private List<TipoUe> lstAdm;
    private TipoUe userBean;
    private TipoUe selectItemsAdm;
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


    public String listaTipoUe() throws Exception{
    	userBean = new TipoUe();
    	selectItemsAdm = new TipoUe();
		lstAdm = genericoService.getAllTipoUe();
        return "tipoue.jsf";
    }

    
     
     public void resetearUser() {
    	 userBean = new TipoUe();
         selectItemsAdm = new TipoUe();
    	 setDisplayEstado(false);
    	 setDisabledUser(false);
     }

     public void habilitarUser() {
    	 setDisabledUser(false);
     }
     
     public void evaluarMetodo() throws Exception {
    	 System.out.println("Id:"+this.selectItemsAdm.getIdTipoUe());
    	 if(this.selectItemsAdm.getIdTipoUe() == 0) {
    		 this.guardarAdmin();
    	 }else {
    		 this.updateAdmin();
    	 }
     }
     public void guardarAdmin() throws Exception {
    	// userBean.setEstado("A");
    	 genericoService.getSaveTipoUe(userBean);
 		lstAdm = genericoService.getAllTipoUe();
     }
	
     public void updateAdmin() throws Exception {
//    	 userBean.setEstado("A");
    	 genericoService.getUpdateTipoUe(userBean);
 		 lstAdm = genericoService.getAllTipoUe();
     }	
     public void deleteAdmin() throws Exception {
    	 genericoService.getdeleteTipoUe(this.getSelectItemsAdm().getIdTipoUe());
    	 listaTipoUe();
     }
     
     public void vistaUser() {
    	 setDisabledUser(true);
    	 System.out.println("disabled:"+this.disabledUser);
     }
     
     
     public void selectedAdm() {
    	 setUserBean(getSelectItemsAdm());
    	 setDisabledUser(true);
    	 setDisplayEstado(true);
//         FacesMessage msg = new FacesMessage("TipoUe Seleccionado", this.getSelectItemsAdm().getDescripcion());
//         FacesContext.getCurrentInstance().addMessage(null, msg);
     }
     
	public GenericoService getGenericoService() {
		return genericoService;
	}



	public void setGenericoService(GenericoService genericoService) {
		this.genericoService = genericoService;
	}


	public List<TipoUe> getLstAdm() {
		return lstAdm;
	}


	public void setLstAdm(List<TipoUe> lstAdm) {
		this.lstAdm = lstAdm;
	}


	public TipoUe getUserBean() {
		return userBean;
	}


	public void setUserBean(TipoUe userBean) {
		this.userBean = userBean;
	}


	public TipoUe getSelectItemsAdm() {
		return selectItemsAdm;
	}


	public void setSelectItemsAdm(TipoUe selectItemsAdm) {
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
