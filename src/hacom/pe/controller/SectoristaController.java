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
import hacom.pe.datos.entidades.Sectorista;
import hacom.pe.datos.entidades.UsuarioMap;
import hacom.pe.datos.entidades.Sectorista;
import hacom.pe.service.GenericoService;


@ManagedBean(name = "sectoristaController")
@SessionScoped
public class SectoristaController {


	@ManagedProperty(value = "#{genericoService}")
	private GenericoService genericoService;

	private List<Geozona> lstGeo;
	private List<Sectorista> lstAdm;
    private Sectorista userBean;
    private Sectorista selectItemsAdm;
    private boolean disabledUser;
    private boolean displayEstado;
    private UsuarioMap usumapBean;

    
    @PostConstruct
	public void inicializarObjetos() {
		
		try {
			//lstGeo = genericoService.getAllGeozona();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    public String listaSectorista() throws Exception{
    	userBean = new Sectorista();
    	selectItemsAdm = new Sectorista();
		lstAdm = genericoService.getAllSectoristaAdm();
        return "sectorista.jsf";
    }

   
     
     public void resetearUser() {
    	 userBean = new Sectorista();
         selectItemsAdm = new Sectorista();
    	 setDisplayEstado(false);
    	 setDisabledUser(false);
     }

     public void habilitarUser() {
    	 setDisabledUser(false);
     }
     
     public void evaluarMetodo() throws Exception {
    	 System.out.println("Id:"+this.selectItemsAdm.getIdSec());
    	 if(this.selectItemsAdm.getIdSec() == 0) {
    		 this.guardarAdmin();
    	 }else {
    		 this.updateAdmin();
    	 }
     }
     
     public void guardarUsuarioMap() throws Exception {
    	 UsuarioMap usuMap = new UsuarioMap();
    	 usuMap.setUsuario(userBean.getUsuSec());
    	 usuMap.setClave(userBean.getContSec());
    	 usuMap.setTipo("S");
    	 this.genericoService.getSaveUsuarioMap(usuMap);
     }
     
     public void updateUsuarioMap() throws Exception {
    	 int id = 0;    	
    	 List<UsuarioMap> lstidUsu = this.genericoService.getAllIdUsuarioMap(usumapBean);
    	 if(!lstidUsu.isEmpty()) {
    		 id = lstidUsu.get(0).getIdUsumap();
    	 }
    	 System.out.println("Usuario:"+usumapBean.getUsuario());
    	 System.out.println("Clave:"+usumapBean.getClave());
    	 System.out.println("Tipo:"+usumapBean.getTipo());

    	 System.out.println("idusuMap:"+id);
    	 
    	UsuarioMap usuMap = new UsuarioMap();
    	usuMap.setIdUsumap(id);
    	 usuMap.setUsuario(userBean.getUsuSec());
    	 usuMap.setClave(userBean.getContSec());
    	usuMap.setTipo("S");
    	this.genericoService.getUpdateUsuarioMap(usuMap);
     }
     
     public void deleteUsuarioMap() throws Exception {
    	 int id = 0;
    	 List<UsuarioMap> lstidUsu = this.genericoService.getAllIdUsuarioMap(usumapBean);
    	 if(!lstidUsu.isEmpty()) {
    		 id = lstidUsu.get(0).getIdUsumap();
    	 }
    	 UsuarioMap usuMap = new UsuarioMap();
    	 usuMap.setIdUsumap(id);
    	 this.genericoService.getDeleteUsuMap(usuMap);
    	 
     }
     
     
     public void guardarAdmin() throws Exception {
    	 userBean.setTipo("S");
    	 userBean.setEstado("A");
    	 System.out.println("usuname:"+userBean.getUsuSec());
    	 this.guardarUsuarioMap();
    	 genericoService.getSaveSectorista(userBean);
    	
    	//Guardar en tabla auth-user
    	MsUser adminId = this.genericoService.getSectoristaId();
 		System.out.println("Usuario name:"+adminId.getUsername());
 		int id = adminId.getIdSec();
 		System.out.println("id-admin:"+id);
 		MsUser user = new MsUser();
 		user.setPassword(userBean.getContSec());
 		user.setUsername(userBean.getUsuSec());
 		user.setFirst_name(userBean.getNombreSec());
 		user.setLast_name(userBean.getApellidoSec());
 		user.setEmail("");
        user.setIdIdentif(id);
        System.out.println("nombre:"+userBean.getApellidoSec());
 		System.out.println("ape:"+userBean.getNombreSec());
 		System.out.println("user:"+userBean.getUsuSec());
 		System.out.println("contra:"+userBean.getContSec());
 		System.out.println("ema:"+user.getEmail());

        this.genericoService.getSaveAuthUser(user);
    	 
 		 lstAdm = genericoService.getAllSectoristaAdm();
     }
	
     public void updateAdmin() throws Exception {
    	 this.updateUsuarioMap();
    	 genericoService.getUpdateSectorista(userBean);
    	 
    	 MsUser user = new MsUser();
     		user.setPassword(userBean.getContSec());
     		user.setUsername(userBean.getUsuSec());
     		user.setFirst_name(userBean.getNombreSec());
     		user.setLast_name(userBean.getApellidoSec());
     		user.setEmail("");
            user.setIdIdentif(userBean.getIdSec());
            System.out.println("nombre:"+userBean.getApellidoSec());
     		System.out.println("ape:"+userBean.getNombreSec());
     		System.out.println("user:"+userBean.getUsuSec());
     		System.out.println("contra:"+userBean.getContSec());
     		System.out.println("ema:"+user.getEmail());

        this.genericoService.getUpdateAuthUser(user);
        
 		 lstAdm = genericoService.getAllSectoristaAdm();
     }	
     public void deleteAdmin() throws Exception {
    	 this.deleteUsuarioMap();
    	 genericoService.getdeleteSectorista(this.getSelectItemsAdm().getIdSec());
 		this.genericoService.getdeleteAuthUser(this.getSelectItemsAdm().getIdSec());
 		lstAdm = genericoService.getAllSectoristaAdm();
     }
     
     public void vistaUser() {
    	 setDisabledUser(true);
    	 System.out.println("disabled:"+this.disabledUser);
     }
     
     
     
     public void selectedAdm() {
    	 setUserBean(getSelectItemsAdm());
    	 UsuarioMap usuMap = new UsuarioMap();
    	 usuMap.setUsuario(getSelectItemsAdm().getUsuSec());
    	 usuMap.setClave(getSelectItemsAdm().getContSec());
    	 usuMap.setTipo(getSelectItemsAdm().getTipo());
    	 setUsumapBean(usuMap);
    	 setDisabledUser(true);
    	 setDisplayEstado(true);
//         FacesMessage msg = new FacesMessage("Usuario Seleccionado", this.getSelectItemsAdm().getUsuSec());
//         FacesContext.getCurrentInstance().addMessage(null, msg);
         System.out.println("usesss:"+getUserBean().getUsuSec());
     }
     
	public GenericoService getGenericoService() {
		return genericoService;
	}

	public void setGenericoService(GenericoService genericoService) {
		this.genericoService = genericoService;
	}



	public List<Geozona> getLstGeo() {
		return lstGeo;
	}


	public void setLstGeo(List<Geozona> lstGeo) {
		this.lstGeo = lstGeo;
	}


	public List<Sectorista> getLstAdm() {
		return lstAdm;
	}


	public void setLstAdm(List<Sectorista> lstAdm) {
		this.lstAdm = lstAdm;
	}


	public Sectorista getUserBean() {
		return userBean;
	}


	public void setUserBean(Sectorista userBean) {
		this.userBean = userBean;
	}


	public Sectorista getSelectItemsAdm() {
		return selectItemsAdm;
	}


	public void setSelectItemsAdm(Sectorista selectItemsAdm) {
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

	public UsuarioMap getUsumapBean() {
		return usumapBean;
	}

	public void setUsumapBean(UsuarioMap usumapBean) {
		this.usumapBean = usumapBean;
	}


	

	
    

}
