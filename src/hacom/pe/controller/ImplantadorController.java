package hacom.pe.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DualListModel;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import hacom.pe.datos.entidades.Entidad;
import hacom.pe.datos.entidades.EntidadSectorista;
import hacom.pe.datos.entidades.Implantador;
import hacom.pe.datos.entidades.MsUser;
import hacom.pe.datos.entidades.Sectorista;
import hacom.pe.datos.entidades.UsuarioMap;
import hacom.pe.service.EntidadService;
import hacom.pe.service.GenericoService;
import hacom.pe.util.ManagerArchivo;
import hacom.pe.util.SistConstants;

@ManagedBean(name = "implantadorController")
@SessionScoped
public class ImplantadorController {

	@ManagedProperty(value = "#{genericoService}")
	private GenericoService genericoService;

	@ManagedProperty(value = "#{entidadService}")
	private EntidadService entidadService;

	@ManagedProperty(value = "#{loginController}")
	private LoginController loginController;
	
	private List<Implantador> lstAdm;
	private Implantador userBean;
	private Implantador selectItemsAdm;
	private boolean disabledUser;
	private boolean displayEstado;
	private EntidadSectorista entBean;
	private List<Entidad> lstEntidad;
	private DualListModel<Entidad> lstEntidadSel;
	private List<Entidad> lstEntidadSource;
	private List<Entidad> lstEntidadIdTarget;
	private List<Entidad> lstEntidadTarget;
	private List<EntidadSectorista> lstEntidadImpTarget;
	private List<Sectorista> lstSectorista;
	private UploadedFile file;
	private String nombreFile;
	private String codigoFile;
	private StreamedContent fileStream;
	private UsuarioMap usumapBean;
    private String displayButton;

	@PostConstruct
	public void inicializarObjetos() {
		lstEntidad = new ArrayList<Entidad>();
		lstEntidadSource = new ArrayList<Entidad>();
		lstEntidadTarget = new ArrayList<Entidad>();

		try {
			lstEntidad = genericoService.getAllMfUnit();

			// lstGeo = genericoService.getAllGeozona();
			for (Entidad nameent : lstEntidad) {
				lstEntidadSource.add(nameent);
			}
			lstEntidadSel = new DualListModel<Entidad>(lstEntidadSource, lstEntidadTarget);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void resetearlistaEntidad() throws Exception {
		lstEntidad = new ArrayList<Entidad>();
		lstEntidadSource = new ArrayList<Entidad>();
		lstEntidadTarget = new ArrayList<Entidad>();

		lstEntidad = genericoService.getAllMfUnit();
		lstEntidadImpTarget = genericoService.getAllEntidadSec(getSelectItemsAdm().getIdImpl());
		// lstGeo = genericoService.getAllGeozona();
		for (Entidad nameent : lstEntidad) {
			lstEntidadSource.add(nameent);
		}
		int cont = 0;
		for (EntidadSectorista ent : lstEntidadImpTarget) {
			lstEntidadIdTarget = genericoService.getAllMfUnitId(ent.getEntidadId());
			lstEntidadTarget.add(lstEntidadIdTarget.get(cont));
			// cont += cont;
		}

		lstEntidadSel = new DualListModel<Entidad>(lstEntidadSource, lstEntidadTarget);
	}

	public void asignarEntidad() throws Exception {
		System.out.println("asignarEntidad");
		System.out.println("Id:" + userBean.getIdImpl());
		entBean = new EntidadSectorista();

		genericoService.getDeleteEntidadImp(userBean.getIdImpl());
		for (Entidad ent : lstEntidadTarget) {
			genericoService.getUpdateEntidadIRese(ent.getId());
//			entBean.setEntidadId(ent.getId());
//			entBean.setImplantadorId(userBean.getIdImpl());
//			genericoService.getSaveEntidadImp(entBean);
			System.out.println("Ident:" + ent.getId());
		}

		for (Entidad ent : lstEntidadSel.getTarget()) {
			System.out.println("entidad:" + ent.getId());
			genericoService.getUpdateEntidadI(ent.getId());
			entBean.setEntidadId(ent.getId());
			entBean.setImplantadorId(userBean.getIdImpl());
			genericoService.getSaveEntidadImp(entBean);
		}
//    	for(String ent : lstEntidadSel.getTarget()) {
//    		System.out.println("entidad:"+ent);
//    		genericoService.getUpdateEntidadI(ent);
//    	}
	}

	public String listaImplantador() throws Exception {
		userBean = new Implantador();
        if(loginController.getTipo().equals("I")) {
        	setDisplayButton("none");
        	userBean = new Implantador();
    		selectItemsAdm = new Implantador();
    		lstAdm = genericoService.getAllImplantador();
//    		entBean = new EntidadSectorista();
//        	entBean.setImplantadorId(9);
    		lstSectorista = genericoService.getAllSectoristaAdm();
        }else if(loginController.getTipo().equals("S")) {
        	setDisplayButton("none");
        	Sectorista sec=new Sectorista();
    		sec.setUsuSec(loginController.getNombre());
    		Sectorista sectorista = this.genericoService.getFindUsuImplSec(sec);
    		Implantador imp = new Implantador();
    		imp.setSectoristaId(sectorista.getIdSec());
    		lstAdm = genericoService.getFindImplantadorSec(imp);
        }else if(loginController.getTipo().equals("A")) {
        	System.out.println("Administrador");
        	setDisplayButton("block");
        	userBean = new Implantador();
    		selectItemsAdm = new Implantador();
    		lstAdm = genericoService.getAllImplantador();
//    		entBean = new EntidadSectorista();
//        	entBean.setImplantadorId(9);
    		lstSectorista = genericoService.getAllSectoristaAdm();
        }
	
		
//		for(EntidadSectorista ent : genericoService.getAllEntidadSec(entBean.getImplantadorId()))
//		{
//			for(Entidad nameent : lstEntidad) {
//				if(nameent.getId() == ent.getEntidadId()) {
//					lstEntidadSource.add(nameent.getUnitName());
//				}
//			}
//		}
		return "implantador.jsf";
	}

	public void upload() {
		FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, message);

	}

	public void resetearUser() {
		userBean = new Implantador();
		selectItemsAdm = new Implantador();
		setDisplayEstado(false);
		setDisabledUser(false);
		userBean.setFotografiaEncoder("images/fotos/sin-fotografia.png");
	}

	public void habilitarUser() {
		setDisabledUser(false);
	}

	public void evaluarMetodo() throws Exception {
		System.out.println("Id:" + this.selectItemsAdm.getIdImpl());
		if (this.selectItemsAdm.getIdImpl() == 0) {
			this.guardarAdmin();
		} else {
			this.updateAdmin();
		}
	}

	public void guardarUsuarioMap() throws Exception {
		UsuarioMap usuMap = new UsuarioMap();
		usuMap.setUsuario(userBean.getUsuaImpl());
		usuMap.setClave(userBean.getContImpl());
		usuMap.setTipo("I");
		this.genericoService.getSaveUsuarioMap(usuMap);
	}

	public void updateUsuarioMap() throws Exception {
		int id = 0;
		List<UsuarioMap> lstidUsu = this.genericoService.getAllIdUsuarioMap(usumapBean);
		if (!lstidUsu.isEmpty()) {
			id = lstidUsu.get(0).getIdUsumap();
		}
		System.out.println("Usuario:" + usumapBean.getUsuario());
		System.out.println("Clave:" + usumapBean.getClave());
		System.out.println("Tipo:" + usumapBean.getTipo());

		System.out.println("idusuMap:" + id);

		UsuarioMap usuMap = new UsuarioMap();
		usuMap.setIdUsumap(id);
		usuMap.setUsuario(userBean.getUsuaImpl());
		usuMap.setClave(userBean.getContImpl());
		usuMap.setTipo("I");
		this.genericoService.getUpdateUsuarioMap(usuMap);
	}

	public void deleteUsuarioMap() throws Exception {
		int id = 0;
		List<UsuarioMap> lstidUsu = this.genericoService.getAllIdUsuarioMap(usumapBean);
		if (!lstidUsu.isEmpty()) {
			id = lstidUsu.get(0).getIdUsumap();
		}
		UsuarioMap usuMap = new UsuarioMap();
		usuMap.setIdUsumap(id);
		this.genericoService.getDeleteUsuMap(usuMap);

	}

	public void guardarAdmin() throws Exception {
		userBean.setEstado("A");
		userBean.setTipo("I");
        try {
        	System.out.println("dni:" + userBean.getDni());
    		System.out.println("imei:" + userBean.getImei());
    		System.out.println("nombreImpl:" + userBean.getNombreImpl());
    		System.out.println("apellidoImpl:" + userBean.getApellidoImpl());
    		System.out.println("celular:" + userBean.getCelular());
    		System.out.println("ruc:" + userBean.getRuc());
    		System.out.println("foto:" + userBean.getFoto());
    		System.out.println("usuaImpl:" + userBean.getUsuaImpl());
    		System.out.println("contImpl:" + userBean.getContImpl());
    		System.out.println("correo:" + userBean.getCorreo());
    		System.out.println("sectoristaId:" + userBean.getSectoristaId());
    		System.out.println("entidadId:" + userBean.getEntidadId());
    		System.out.println("estado:" + userBean.getEstado());
    		System.out.println("FotografiaEncoder:" + userBean.getFotografiaEncoder());
    		System.out.println("Foto:" + userBean.getFotoAdjunto());
    		this.guardarUsuarioMap();
    		userBean.setFotografiaEncoder("");
    		if (userBean.getFotoAdjunto() == null) {
    			byte[] b2 = new byte[1];
    			userBean.setFotoAdjunto(b2);
    		}
    		
    		genericoService.getSaveImplantador(userBean);
    		//Implantador imp = genericoService.getFindIdImpl();
    		// this.asignarEntidad(imp.getIdImpl());
    		MsUser adminId = this.genericoService.getImplantadoId();
    		System.out.println("Usuario name:"+adminId.getUsername());
    		int id = adminId.getIdImpl();
    		System.out.println("id-admin:"+id);
    		MsUser user = new MsUser();
    		user.setPassword(userBean.getContImpl());
    		user.setUsername(userBean.getUsuaImpl());
    		user.setFirst_name(userBean.getNombreImpl());
    		user.setLast_name(userBean.getApellidoImpl());
    		user.setEmail("");
            user.setIdIdentif(id);
            System.out.println("nombre:"+userBean.getNombreImpl());
    		System.out.println("ape:"+userBean.getApellidoImpl());
    		System.out.println("user:"+userBean.getUsuaImpl());
    		System.out.println("contra:"+userBean.getContImpl());
    		System.out.println("ema:"+user.getEmail());

           this.genericoService.getSaveAuthUser(user);

    		lstAdm = genericoService.getAllImplantador();
        }catch(Exception ex) {
        	ex.printStackTrace();
        }
	
	}

	public void handleFileUpload(FileUploadEvent event) throws IOException {
		System.out.println("handleFileUpload");
		FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		userBean.setFoto(event.getFile().getFileName());
//         
//         byte[] b = new byte[(int) event.getFile().getSize()];
//		 InputStream im = event.getFile().getInputstream();
//		 System.out.println("im:"+im);
//		 File file = new File(event.getFile().getFileName());
//		 System.out.println("path:"+file.getAbsolutePath());			
//		 System.out.println("path2:"+file.getCanonicalPath());			
//         String destino = System.getProperty("user.dir") + "/images/" + event.getFile().getFileName();
//         String dire = System.getProperty("user.dir");
//         System.out.println("dire:"+dire);
//         File currentDirFile = new File(".");
//         String helper = currentDirFile.getAbsolutePath();
//         String currentDir = helper.substring(0, helper.length() - currentDirFile.getCanonicalPath().length());
//         System.out.println("currentDir:"+currentDir);
//         //this.GrabarArchivo(destino,im);
//         

		byte[] b2 = new byte[(int) event.getFile().getSize()];
		event.getFile().getInputstream().read(b2);

		userBean.setFotoAdjunto(b2);

		 userBean.setFotografiaEncoder("data:image/png;base64," + ManagerArchivo.getEncode(b2));
		//System.out.println("fotografia encoder: " + userBean.getFotografiaEncoder());

	}

	public void GrabarArchivo(String destino, InputStream im) {
		codigoFile = this.GenerarNombreArchivo();
// 		nombreFile = getFile().getFileName();
		userBean.setFotografiaEncoder(codigoFile);
		try {
			this.copyFile(codigoFile, im);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getFileArchivo(byte[] cadena) {
		if ((cadena != null)) {
			System.out.println("FotografiaEncoder:" + cadena);
			String foto = ManagerArchivo.getEncode(cadena);
			System.out.println("foto:"+foto);
			if(foto != null) {
				userBean.setFotografiaEncoder("data:image/png;base64," + foto);
			}
            
		} else {
			userBean.setFotografiaEncoder("images/fotos/sin-fotografia.png");
		}
		return userBean.getFotografiaEncoder();
	}

	public static String GenerarNombreArchivo() {
		String cadenaAleatoria = "";
		File fichero;
		long milis = new java.util.GregorianCalendar().getTimeInMillis();
		Random r = new Random(milis);
		while (true) {
			cadenaAleatoria = "";
			int i = 0;
			while (i < 20) {
				char c = (char) r.nextInt(255);
				if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z')) {
					cadenaAleatoria += c;
					i++;
				}
			}
			fichero = new File(SistConstants.DIRECTORIOFILE + cadenaAleatoria + ".jpg");
			if (!fichero.exists()) {
				break;
			}
		}
		return cadenaAleatoria;
	}

	public void copyFile(String destino, InputStream in) throws Exception {
		String ruta = "";
		System.out.println("generarArchivo:" + this.GenerarNombreArchivo());
		// ruta = ruta + "Data" + File.separator;
		ruta = File.separator + "mefweb" + File.separator;
		System.out.println("destino:" + destino);
		OutputStream out = new FileOutputStream(new File(destino));
		int read = 0;
		byte[] bytes = new byte[1024];
		while ((read = in.read(bytes)) != -1) {
			out.write(bytes, 0, read);
		}
		in.close();
		out.flush();
		out.close();

	}

	public void cargarFotografia(FileUploadEvent event) {

		FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void updateAdmin() throws Exception {
		userBean.setEstado("A");
		userBean.setEstado("A");
		userBean.setFotografiaEncoder("");
		if (userBean.getFotoAdjunto() == null) {
			byte[] b2 = new byte[1];
			userBean.setFotoAdjunto(b2);
		}
		System.out.println("dni:" + userBean.getDni());
		System.out.println("imei:" + userBean.getImei());
		System.out.println("nombreImpl:" + userBean.getNombreImpl());
		System.out.println("apellidoImpl:" + userBean.getApellidoImpl());
		System.out.println("celular:" + userBean.getCelular());
		System.out.println("ruc:" + userBean.getRuc());
		System.out.println("foto:" + userBean.getFoto());
		System.out.println("usuaImpl:" + userBean.getUsuaImpl());
		System.out.println("contImpl:" + userBean.getContImpl());
		System.out.println("correo:" + userBean.getCorreo());
		System.out.println("sectoristaId:" + userBean.getSectoristaId());
		System.out.println("entidadId:" + userBean.getEntidadId());
		System.out.println("estado:" + userBean.getEstado());
		System.out.println("FotografiaEncoder:" + userBean.getFotografiaEncoder());
		System.out.println("Foto:" + userBean.getFotoAdjunto());
		this.updateUsuarioMap();
		genericoService.getUpdateImplantador(userBean);
		// this.asignarEntidad(userBean.getIdImpl());
		
	
		MsUser user = new MsUser();
		user.setPassword(userBean.getContImpl());
		user.setUsername(userBean.getUsuaImpl());
		user.setFirst_name(userBean.getNombreImpl());
		user.setLast_name(userBean.getApellidoImpl());
		user.setEmail("");
        user.setIdIdentif(userBean.getIdImpl());
        System.out.println("nombre:"+userBean.getNombreImpl());
		System.out.println("ape:"+userBean.getApellidoImpl());
		System.out.println("user:"+userBean.getUsuaImpl());
		System.out.println("contra:"+userBean.getContImpl());
		System.out.println("ema:"+user.getEmail());

	       this.genericoService.getUpdateAuthUser(user);

		lstAdm = genericoService.getAllImplantador();
	}

	public void deleteAdmin() throws Exception {
		this.deleteUsuarioMap();
		genericoService.getdeleteImplantador(this.getSelectItemsAdm().getIdImpl());
		this.genericoService.getdeleteAuthUser(this.getSelectItemsAdm().getIdImpl());

		listaImplantador();
	}

	public void vistaUser() {
		setDisabledUser(true);
		System.out.println("disabled:" + this.disabledUser);
	}

	public void selectedAdm() {
		setUserBean(getSelectItemsAdm());
		UsuarioMap usuMap = new UsuarioMap();
		usuMap.setUsuario(getSelectItemsAdm().getUsuaImpl());
		usuMap.setClave(getSelectItemsAdm().getContImpl());
		usuMap.setTipo(getSelectItemsAdm().getTipo());
		setUsumapBean(usuMap);
		setDisabledUser(true);
		setDisplayEstado(true);
		// mostrando la imagen
		if (userBean.getFotoAdjunto() != null) {
			userBean.setFotografiaEncoder(
					"data:image/png;base64," + ManagerArchivo.getEncode(userBean.getFotoAdjunto()));
		} else {
			userBean.setFotografiaEncoder("images/fotos/sin-fotografia.png");
		}
//		FacesMessage msg = new FacesMessage("Implantador Seleccionado",
//				this.getSelectItemsAdm().getNombreImpl() + " " + this.getSelectItemsAdm().getApellidoImpl());
//		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public GenericoService getGenericoService() {
		return genericoService;
	}

	public void setGenericoService(GenericoService genericoService) {
		this.genericoService = genericoService;
	}

	public List<Implantador> getLstAdm() {
		return lstAdm;
	}

	public void setLstAdm(List<Implantador> lstAdm) {
		this.lstAdm = lstAdm;
	}

	public Implantador getUserBean() {
		return userBean;
	}

	public void setUserBean(Implantador userBean) {
		this.userBean = userBean;
	}

	public Implantador getSelectItemsAdm() {
		return selectItemsAdm;
	}

	public void setSelectItemsAdm(Implantador selectItemsAdm) {
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

	public EntidadService getEntidadService() {
		return entidadService;
	}

	public void setEntidadService(EntidadService entidadService) {
		this.entidadService = entidadService;
	}

	public EntidadSectorista getEntBean() {
		return entBean;
	}

	public void setEntBean(EntidadSectorista entBean) {
		this.entBean = entBean;
	}

	public List<Entidad> getLstEntidad() {
		return lstEntidad;
	}

	public void setLstEntidad(List<Entidad> lstEntidad) {
		this.lstEntidad = lstEntidad;
	}

	public DualListModel<Entidad> getLstEntidadSel() {
		return lstEntidadSel;
	}

	public void setLstEntidadSel(DualListModel<Entidad> lstEntidadSel) {
		this.lstEntidadSel = lstEntidadSel;
	}

	public List<Entidad> getLstEntidadSource() {
		return lstEntidadSource;
	}

	public void setLstEntidadSource(List<Entidad> lstEntidadSource) {
		this.lstEntidadSource = lstEntidadSource;
	}

	public List<Entidad> getLstEntidadTarget() {
		return lstEntidadTarget;
	}

	public void setLstEntidadTarget(List<Entidad> lstEntidadTarget) {
		this.lstEntidadTarget = lstEntidadTarget;
	}

	public List<Sectorista> getLstSectorista() {
		return lstSectorista;
	}

	public void setLstSectorista(List<Sectorista> lstSectorista) {
		this.lstSectorista = lstSectorista;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public String getNombreFile() {
		return nombreFile;
	}

	public void setNombreFile(String nombreFile) {
		this.nombreFile = nombreFile;
	}

	public String getCodigoFile() {
		return codigoFile;
	}

	public void setCodigoFile(String codigoFile) {
		this.codigoFile = codigoFile;
	}

	public StreamedContent getFileStream() {
		return fileStream;
	}

	public void setFileStream(StreamedContent fileStream) {
		this.fileStream = fileStream;
	}

	public List<EntidadSectorista> getLstEntidadImpTarget() {
		return lstEntidadImpTarget;
	}

	public void setLstEntidadImpTarget(List<EntidadSectorista> lstEntidadImpTarget) {
		this.lstEntidadImpTarget = lstEntidadImpTarget;
	}

	public List<Entidad> getLstEntidadIdTarget() {
		return lstEntidadIdTarget;
	}

	public void setLstEntidadIdTarget(List<Entidad> lstEntidadIdTarget) {
		this.lstEntidadIdTarget = lstEntidadIdTarget;
	}

	public UsuarioMap getUsumapBean() {
		return usumapBean;
	}

	public void setUsumapBean(UsuarioMap usumapBean) {
		this.usumapBean = usumapBean;
	}

	public LoginController getLoginController() {
		return loginController;
	}

	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}

	public String getDisplayButton() {
		return displayButton;
	}

	public void setDisplayButton(String displayButton) {
		this.displayButton = displayButton;
	}

	
}
