package hacom.pe.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.sun.istack.internal.Pool.Impl;

import hacom.pe.datos.entidades.Departamento;
import hacom.pe.datos.entidades.Entidad;
import hacom.pe.datos.entidades.Geozona;
import hacom.pe.datos.entidades.Implantador;
import hacom.pe.datos.entidades.Sectorista;
import hacom.pe.datos.entidades.TipoLocal;
import hacom.pe.datos.entidades.TipoUe;
import hacom.pe.datos.entidades.Ubigeo;
import hacom.pe.service.AsistenciaTecService;
import hacom.pe.service.EntidadService;
import hacom.pe.service.GenericoService;
import hacom.pe.util.GenerateExpressions;


@ManagedBean(name = "entidadController")
@SessionScoped
public class EntidadController {

	@ManagedProperty(value = "#{entidadService}")
	private EntidadService entidadService;

	@ManagedProperty(value = "#{asistenciaTecService}")
	private AsistenciaTecService asistenciaTecService;
	
	@ManagedProperty(value = "#{genericoService}")
	private GenericoService genericoService;
	
	@ManagedProperty(value = "#{loginController}")
	private LoginController loginController;

	
	private List<Entidad> lstAsis;
	private Entidad entidadBean;
    private List<Departamento> lstDepa;
	private List<TipoUe> lstTipoUe;
	private List<Geozona> lstGeozona;
	private List<Sectorista> lstSectorista;
	private Entidad selectItemsAdm;
    private boolean disabledUser;
	private List<Ubigeo> lstDepaUbi;
	private List<Ubigeo> lstProvUbi;
	private List<Ubigeo> lstDistUbi;
    private String displayButtonE;

    @PostConstruct
	public void inicializarObjetos() {
		lstAsis = new ArrayList<Entidad>();
		lstDepa = new ArrayList<Departamento>();

		try {
			
	

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public String listaEntidad() throws Exception{
		System.out.println("Nombre Usu:"+loginController.getNombre());
		System.out.println("Tipo Usu:"+loginController.getTipo());
        if(loginController.getTipo().equals("I")) {
        	
    		Implantador imp=new Implantador();
    		imp.setUsuaImpl(loginController.getNombre());
    		Implantador implantador = this.genericoService.getFindUsuImpl(imp);
    		System.out.println("IdImpl:"+implantador.getIdImpl());
    		Entidad ent = new Entidad();
    		ent.setImplantadorId(implantador.getIdImpl());
    		lstAsis = entidadService.getAllEntidadImplantador(ent);
    		setDisplayButtonE("none");
        }else if(loginController.getTipo().equals("S")){
        	Sectorista sec=new Sectorista();
    		sec.setUsuSec(loginController.getNombre());
    		Sectorista sectorista = this.genericoService.getFindUsuImplSec(sec);
    		System.out.println("IdSec:"+sectorista.getIdSec());
    		Entidad ent = new Entidad();
    		ent.setSectoristaId(sectorista.getIdSec());
        	lstAsis = entidadService.getAllEntidadSectorista(ent);
    		lstDepa = asistenciaTecService.listarDepartamento();
    		lstTipoUe  = genericoService.getAllTipoUe();
    		lstGeozona = genericoService.getAllGeozona();
    		lstSectorista = genericoService.getAllSectoristaAdm();
            lstDepaUbi = genericoService.getAllDepartamento();
    		entidadBean = new Entidad();
    		setDisplayButtonE("none");
        }else {
    		setDisplayButtonE("block");
    		lstAsis = entidadService.getAllEntidad();
    		lstDepa = asistenciaTecService.listarDepartamento();
    		lstTipoUe  = genericoService.getAllTipoUe();
    		lstGeozona = genericoService.getAllGeozona();
    		lstSectorista = genericoService.getAllSectoristaAdm();
            lstDepaUbi = genericoService.getAllDepartamento();
    		entidadBean = new Entidad();
        }
    	
		
        return "entidadman.jsf";

    }
    
    
//    public void buscarImplantadorEnt() {
//    	Entidad ent = new Entidad();
//		lstAsis = entidadService.getAllEntidad();
//
//    }
    
    
    public void listarProvincia() throws Exception {
    	System.out.println("Depa:"+entidadBean.getDepa());
    	lstProvUbi = new ArrayList<Ubigeo>();
    	lstProvUbi = genericoService.getAllProvinciaDepa(entidadBean.getDepa());
    }
    
    public void listarDistrito() throws Exception {
    	System.out.println("Prov:"+entidadBean.getProvince());
    	lstDistUbi = genericoService.getAllDistritoProvi(entidadBean.getProvince());
    }
    
public void buscarDepa(){
		
		try {
			lstDepa = asistenciaTecService.listarDepartamento();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

public void resetearUser() {
	 entidadBean = new Entidad();
    selectItemsAdm = new Entidad();
	 setDisabledUser(false);
}

public void habilitarUser() {
	 setDisabledUser(false);
}

public void vistaUser() {
	 setDisabledUser(true);
	 System.out.println("disabled:"+this.disabledUser);
}
public void validarSeleccion() {
	if(!entidadBean.isCheckSecEje()) {
		entidadBean.setSectorist_names("");
	}
	if(!entidadBean.isCheckDepa()) {
		entidadBean.setDepa(0);
	}
	if(!entidadBean.isCheckEntidad()) {
		entidadBean.setUnit_unitname("");
	}
	if(!entidadBean.isCheckSectorista()) {
		entidadBean.setSectorist_names("");
	}
	if(!entidadBean.isCheckImpl()) {
		entidadBean.setImplanter_names("");
	}
	if(!entidadBean.isCheckRuc()) {
		entidadBean.setUsername("");
	}
	if(!entidadBean.isCheckDire()) {
		entidadBean.setAddress("");
	}
	if(!entidadBean.isCheckGeo()) {
		entidadBean.setGeozoneName("");
	}
	
}
    
public String listaImplantador() throws Exception {
	entidadBean = new Entidad();
	selectItemsAdm = new Entidad();
	lstAsis= entidadService.getAllEntidad();

	lstSectorista = genericoService.getAllSectoristaAdm();

	return "implantador.jsf";
}
   
public void evaluarMetodo() throws Exception {
	System.out.println("Id:" + this.selectItemsAdm.getId());
	if (this.selectItemsAdm.getId() == 0) {
		this.guardarAdmin();
	} else {
		this.updateAdmin();
	}
}
    
public void guardarAdmin() throws Exception {
	Long fechaAI = GenerateExpressions.ConvertDateToEpoch(new Date());
	//entidadBean.setStatus("A");
    System.out.println("Estado:"+entidadBean.getStatus());
	entidadBean.setAuditCreationDate(fechaAI);
	entidadService.getSaveEntidad(entidadBean);
	
	lstAsis = entidadService.getAllEntidad();
}

    public void filtroEntidad() throws Exception {
		try {
            this.validarSeleccion();
			lstAsis = entidadService.getFindEntidad(entidadBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
    
    public void updateAdmin() throws Exception {
	    
		entidadService.getUpdateEntidad(entidadBean);
		// this.asignarEntidad(userBean.getIdImpl());
		lstAsis= entidadService.getAllEntidad();
    }
	public void deleteAdmin() throws Exception {
		entidadService.getdeleteEntidad(this.getSelectItemsAdm().getId());
		listaImplantador();
	}

	 public void selectedAdm() {
    	 setentidadBean(getSelectItemsAdm());
    	 setDisabledUser(true);

//         FacesMessage msg = new FacesMessage("Entidad Seleccionado", this.getSelectItemsAdm().getUnitName());
//         FacesContext.getCurrentInstance().addMessage(null, msg);
     }
	 
	
	public AsistenciaTecService getAsistenciaTecService() {
		return asistenciaTecService;
	}



	public void setAsistenciaTecService(AsistenciaTecService asistenciaTecService) {
		this.asistenciaTecService = asistenciaTecService;
	}



	public List<Entidad> getLstAsis() {
		return lstAsis;
	}



	public void setLstAsis(List<Entidad> lstAsis) {
		this.lstAsis = lstAsis;
	}



	public Entidad getentidadBean() {
		return entidadBean;
	}



	public void setentidadBean(Entidad entidadBean) {
		this.entidadBean = entidadBean;
	}



	public List<Departamento> getLstDepa() {
		return lstDepa;
	}



	public void setLstDepa(List<Departamento> lstDepa) {
		this.lstDepa = lstDepa;
	}

	public EntidadService getEntidadService() {
		return entidadService;
	}

	public void setEntidadService(EntidadService entidadService) {
		this.entidadService = entidadService;
	}

	public Entidad getEntidadBean() {
		return entidadBean;
	}

	public void setEntidadBean(Entidad entidadBean) {
		this.entidadBean = entidadBean;
	}

	public List<TipoUe> getLstTipoUe() {
		return lstTipoUe;
	}

	public void setLstTipoUe(List<TipoUe> lstTipoUe) {
		this.lstTipoUe = lstTipoUe;
	}

	public GenericoService getGenericoService() {
		return genericoService;
	}

	public void setGenericoService(GenericoService genericoService) {
		this.genericoService = genericoService;
	}

	public List<Geozona> getLstGeozona() {
		return lstGeozona;
	}

	public void setLstGeozona(List<Geozona> lstGeozona) {
		this.lstGeozona = lstGeozona;
	}

	public List<Sectorista> getLstSectorista() {
		return lstSectorista;
	}

	public void setLstSectorista(List<Sectorista> lstSectorista) {
		this.lstSectorista = lstSectorista;
	}

	public Entidad getSelectItemsAdm() {
		return selectItemsAdm;
	}

	public void setSelectItemsAdm(Entidad selectItemsAdm) {
		this.selectItemsAdm = selectItemsAdm;
	}

	public boolean isDisabledUser() {
		return disabledUser;
	}

	public void setDisabledUser(boolean disabledUser) {
		this.disabledUser = disabledUser;
	}

	public List<Ubigeo> getLstDepaUbi() {
		return lstDepaUbi;
	}

	public void setLstDepaUbi(List<Ubigeo> lstDepaUbi) {
		this.lstDepaUbi = lstDepaUbi;
	}

	public List<Ubigeo> getLstProvUbi() {
		return lstProvUbi;
	}

	public void setLstProvUbi(List<Ubigeo> lstProvUbi) {
		this.lstProvUbi = lstProvUbi;
	}

	public List<Ubigeo> getLstDistUbi() {
		return lstDistUbi;
	}

	public void setLstDistUbi(List<Ubigeo> lstDistUbi) {
		this.lstDistUbi = lstDistUbi;
	}

	public LoginController getLoginController() {
		return loginController;
	}

	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}
	public String getDisplayButtonE() {
		return displayButtonE;
	}

	public void setDisplayButtonE(String displayButtonE) {
		this.displayButtonE = displayButtonE;
	}


	
	
}
