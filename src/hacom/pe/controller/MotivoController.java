package hacom.pe.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import hacom.pe.datos.entidades.Motivo;
import hacom.pe.service.GenericoService;

@ManagedBean(name = "motivoController")
@SessionScoped
public class MotivoController {

	
	@ManagedProperty(value = "#{genericoService}")
	private GenericoService genericoService;

	private List<Motivo> lstAdm;
    private Motivo userBean;
    private Motivo selectItemsAdm;
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


    public String listaMotivo() throws Exception{
    	userBean = new Motivo();
    	selectItemsAdm = new Motivo();
		lstAdm = genericoService.getAllTipoMotivo();
        return "motivo.jsf";
    }

    
     
     public void resetearUser() {
    	 userBean = new Motivo();
         selectItemsAdm = new Motivo();
    	 setDisplayEstado(false);
    	 setDisabledUser(false);
     }

     public void habilitarUser() {
    	 setDisabledUser(false);
     }
     
     public void evaluarMetodo() throws Exception {
    	 System.out.println("Id:"+this.selectItemsAdm.getIdMotive());
    	 if(this.selectItemsAdm.getIdMotive() == 0) {
    		 this.guardarAdmin();
    	 }else {
    		 this.updateAdmin();
    	 }
     }
     public void guardarAdmin() throws Exception {
    	// userBean.setEstado("A");
    	 genericoService.getSaveMotivo(userBean);
 		lstAdm = genericoService.getAllTipoMotivo();
     }
	
     public void updateAdmin() throws Exception {
//    	 userBean.setEstado("A");
    	 genericoService.getUpdateMotivo(userBean);
 		 lstAdm = genericoService.getAllTipoMotivo();
     }	
     public void deleteAdmin() throws Exception {
    	 genericoService.getdeleteMotivo(this.getSelectItemsAdm().getIdMotive());
    	 listaMotivo();
     }
     
     public void vistaUser() {
    	 setDisabledUser(true);
    	 System.out.println("disabled:"+this.disabledUser);
     }
     
     
     public void selectedAdm() {
    	 setUserBean(getSelectItemsAdm());
    	 setDisabledUser(true);
    	 setDisplayEstado(true);
//         FacesMessage msg = new FacesMessage("Motivo Seleccionado", this.getSelectItemsAdm().getTitulo());
//         FacesContext.getCurrentInstance().addMessage(null, msg);
     }
     
	public GenericoService getGenericoService() {
		return genericoService;
	}



	public void setGenericoService(GenericoService genericoService) {
		this.genericoService = genericoService;
	}


	public List<Motivo> getLstAdm() {
		return lstAdm;
	}


	public void setLstAdm(List<Motivo> lstAdm) {
		this.lstAdm = lstAdm;
	}


	public Motivo getUserBean() {
		return userBean;
	}


	public void setUserBean(Motivo userBean) {
		this.userBean = userBean;
	}


	public Motivo getSelectItemsAdm() {
		return selectItemsAdm;
	}


	public void setSelectItemsAdm(Motivo selectItemsAdm) {
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
