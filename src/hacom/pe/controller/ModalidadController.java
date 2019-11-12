package hacom.pe.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import hacom.pe.datos.entidades.Modalidad;
import hacom.pe.datos.entidades.TipoUe;
import hacom.pe.service.GenericoService;

@ManagedBean(name = "modalidadController")
@SessionScoped
public class ModalidadController {

	
	@ManagedProperty(value = "#{genericoService}")
	private GenericoService genericoService;

	private List<Modalidad> lstAdm;
    private Modalidad userBean;
    private Modalidad selectItemsAdm;
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


    public String listaModalidad() throws Exception{
    	userBean = new Modalidad();
    	selectItemsAdm = new Modalidad();
		lstAdm = genericoService.getAllTipoModalidad();
        return "modalidad.jsf";
    }

    
     
     public void resetearUser() {
    	 userBean = new Modalidad();
         selectItemsAdm = new Modalidad();
    	 setDisplayEstado(false);
    	 setDisabledUser(false);
     }

     public void habilitarUser() {
    	 setDisabledUser(false);
     }
     
     public void evaluarMetodo() throws Exception {
    	 System.out.println("Id:"+this.selectItemsAdm.getIdModalidad());
    	 if(this.selectItemsAdm.getIdModalidad() == 0) {
    		 this.guardarAdmin();
    	 }else {
    		 this.updateAdmin();
    	 }
     }
     public void guardarAdmin() throws Exception {
    	// userBean.setEstado("A");
    	 genericoService.getSaveModalidad(userBean);
 		lstAdm = genericoService.getAllTipoModalidad();
     }
	
     public void updateAdmin() throws Exception {
//    	 userBean.setEstado("A");
    	 genericoService.getUpdateModalidad(userBean);
 		 lstAdm = genericoService.getAllTipoModalidad();
     }	
     public void deleteAdmin() throws Exception {
    	 genericoService.getdeleteModalidad(this.getSelectItemsAdm().getIdModalidad());
    	 listaModalidad();
     }
     
     public void vistaUser() {
    	 setDisabledUser(true);
    	 System.out.println("disabled:"+this.disabledUser);
     }
     
     
     public void selectedAdm() {
    	 setUserBean(getSelectItemsAdm());
    	 setDisabledUser(true);
    	 setDisplayEstado(true);
//         FacesMessage msg = new FacesMessage("TipoUe Seleccionado", this.getSelectItemsAdm().getTitulo());
//         FacesContext.getCurrentInstance().addMessage(null, msg);
     }
     
	public GenericoService getGenericoService() {
		return genericoService;
	}



	public void setGenericoService(GenericoService genericoService) {
		this.genericoService = genericoService;
	}


	public List<Modalidad> getLstAdm() {
		return lstAdm;
	}


	public void setLstAdm(List<Modalidad> lstAdm) {
		this.lstAdm = lstAdm;
	}


	public Modalidad getUserBean() {
		return userBean;
	}


	public void setUserBean(Modalidad userBean) {
		this.userBean = userBean;
	}


	public Modalidad getSelectItemsAdm() {
		return selectItemsAdm;
	}


	public void setSelectItemsAdm(Modalidad selectItemsAdm) {
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

