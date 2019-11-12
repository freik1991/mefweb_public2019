package hacom.pe.datos.entidades;

import java.util.Date;

public class MsUser {

	private String useriD;
	private String password;
	private int id;
	private String is_superuser;
	private String username;
	private String dni_boss;
	private int sectorist_id;
	private String first_name;
	private String last_name;
	private String userType;
	private String sectorist_cumpl;
	private String device_id;
    private String name_usu;
    private String sectorist;
    
    private boolean checkRuc;
	private boolean checkUsu;
	private boolean checkDisp;
	private boolean checkTipo;
	private boolean checkSecNam;
	
	private int is_supperuser;
	private int iduser;
	private String contrasena;
	private String nombre_use;
	private String apellido_use;
	private String estado;
	private String tipo;
	private String dni;
    private String email;
	
    //auth-user
    private Date last_login;
    private int is_staff;
    private Date date_joined;
    private int is_active;
    private int idIdentif;
    private int userId;
    private int idSec;
    private int idCap;
    private int idImpl;

    
	public String getUseriD() {
		return useriD;
	}
	public void setUseriD(String useriD) {
		this.useriD = useriD;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public MsUser(String useriD, String password) {
		super();
		this.useriD = useriD;
		this.password = password;
	}
	public MsUser() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIs_superuser() {
		return is_superuser;
	}
	public void setIs_superuser(String is_superuser) {
		this.is_superuser = is_superuser;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDni_boss() {
		return dni_boss;
	}
	public void setDni_boss(String dni_boss) {
		this.dni_boss = dni_boss;
	}
	public int getSectorist_id() {
		return sectorist_id;
	}
	public void setSectorist_id(int sectorist_id) {
		this.sectorist_id = sectorist_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getSectorist_cumpl() {
		return sectorist_cumpl;
	}
	public void setSectorist_cumpl(String sectorist_cumpl) {
		this.sectorist_cumpl = sectorist_cumpl;
	}
	public String getDevice_id() {
		return device_id;
	}
	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}
	public String getName_usu() {
		return name_usu;
	}
	public void setName_usu(String name_usu) {
		this.name_usu = name_usu;
	}
	public String getSectorist() {
		return sectorist;
	}
	public void setSectorist(String sectorist) {
		this.sectorist = sectorist;
	}
	public boolean isCheckRuc() {
		return checkRuc;
	}
	public void setCheckRuc(boolean checkRuc) {
		this.checkRuc = checkRuc;
	}
	public boolean isCheckUsu() {
		return checkUsu;
	}
	public void setCheckUsu(boolean checkUsu) {
		this.checkUsu = checkUsu;
	}
	public boolean isCheckDisp() {
		return checkDisp;
	}
	public void setCheckDisp(boolean checkDisp) {
		this.checkDisp = checkDisp;
	}
	public boolean isCheckTipo() {
		return checkTipo;
	}
	public void setCheckTipo(boolean checkTipo) {
		this.checkTipo = checkTipo;
	}
	public boolean isCheckSecNam() {
		return checkSecNam;
	}
	public void setCheckSecNam(boolean checkSecNam) {
		this.checkSecNam = checkSecNam;
	}
	
	public int getIs_supperuser() {
		return is_supperuser;
	}
	public void setIs_supperuser(int is_supperuser) {
		this.is_supperuser = is_supperuser;
	}
	public int getIduser() {
		return iduser;
	}
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getNombre_use() {
		return nombre_use;
	}
	public void setNombre_use(String nombre_use) {
		this.nombre_use = nombre_use;
	}
	public String getApellido_use() {
		return apellido_use;
	}
	public void setApellido_use(String apellido_use) {
		this.apellido_use = apellido_use;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getLast_login() {
		return last_login;
	}
	public void setLast_login(Date last_login) {
		this.last_login = last_login;
	}
	
	public Date getDate_joined() {
		return date_joined;
	}
	public void setDate_joined(Date date_joined) {
		this.date_joined = date_joined;
	}
	
	public int getIs_staff() {
		return is_staff;
	}
	public int getIs_active() {
		return is_active;
	}
	public void setIs_staff(int is_staff) {
		this.is_staff = is_staff;
	}
	public void setIs_active(int is_active) {
		this.is_active = is_active;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getIdSec() {
		return idSec;
	}
	public void setIdSec(int idSec) {
		this.idSec = idSec;
	}
	public int getIdCap() {
		return idCap;
	}
	public void setIdCap(int idCap) {
		this.idCap = idCap;
	}
	public int getIdImpl() {
		return idImpl;
	}
	public void setIdImpl(int idImpl) {
		this.idImpl = idImpl;
	}
	public int getIdIdentif() {
		return idIdentif;
	}
	public void setIdIdentif(int idIdentif) {
		this.idIdentif = idIdentif;
	}
	
	
}
