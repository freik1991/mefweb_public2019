package hacom.pe.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import hacom.pe.datos.entidades.TipoUe;
import hacom.pe.datos.entidades.TipoVisita;
import hacom.pe.service.GenericoService;

@ManagedBean(name = "tipoVisitaController")
@SessionScoped
public class TipoVisitaController {

	
	@ManagedProperty(value = "#{genericoService}")
	private GenericoService genericoService;

	private List<TipoVisita> lstAdm;
    private TipoVisita userBean;
    private TipoVisita selectItemsAdm;
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


    public String listaTipoVisita() throws Exception{
    	userBean = new TipoVisita();
    	selectItemsAdm = new TipoVisita();
		lstAdm = genericoService.getAllTipoVisita();
        return "tipovisita.jsf";
    }

    
     
     public void resetearUser() {
    	 userBean = new TipoVisita();
         selectItemsAdm = new TipoVisita();
    	 setDisplayEstado(false);
    	 setDisabledUser(false);
     }

     public void habilitarUser() {
    	 setDisabledUser(false);
     }
     
     public void evaluarMetodo() throws Exception {
    	 System.out.println("Id:"+this.selectItemsAdm.getIdTipoVis());
    	 if(this.selectItemsAdm.getIdTipoVis() == 0) {
    		 this.guardarAdmin();
    	 }else {
    		 this.updateAdmin();
    	 }
     }
     public void guardarAdmin() throws Exception {
    	// userBean.setEstado("A");
    	 genericoService.getSaveTipoVisita(userBean);
 		lstAdm = genericoService.getAllTipoVisita();
     }
	
     public void updateAdmin() throws Exception {
//    	 userBean.setEstado("A");
    	 genericoService.getUpdateTipoVisita(userBean);
 		 lstAdm = genericoService.getAllTipoVisita();
     }	
     public void deleteAdmin() throws Exception {
    	 genericoService.getdeleteTipoVisita(this.getSelectItemsAdm().getIdTipoVis());
    	 listaTipoVisita();
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


	public List<TipoVisita> getLstAdm() {
		return lstAdm;
	}


	public void setLstAdm(List<TipoVisita> lstAdm) {
		this.lstAdm = lstAdm;
	}


	public TipoVisita getUserBean() {
		return userBean;
	}


	public void setUserBean(TipoVisita userBean) {
		this.userBean = userBean;
	}


	public TipoVisita getSelectItemsAdm() {
		return selectItemsAdm;
	}


	public void setSelectItemsAdm(TipoVisita selectItemsAdm) {
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
