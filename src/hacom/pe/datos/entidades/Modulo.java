package hacom.pe.datos.entidades;

public class Modulo {

	private int id;
	private String moduleName;
	private int system_id;
	private String systemName;
	private int status;
	private boolean checkModulo;
	private boolean checkSystem;
	private int idGen;
	
	public Modulo() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
	public int getSystem_id() {
		return system_id;
	}
	public void setSystem_id(int system_id) {
		this.system_id = system_id;
	}
	public boolean isCheckModulo() {
		return checkModulo;
	}
	public void setCheckModulo(boolean checkModulo) {
		this.checkModulo = checkModulo;
	}
	public boolean isCheckSystem() {
		return checkSystem;
	}
	public void setCheckSystem(boolean checkSystem) {
		this.checkSystem = checkSystem;
	}
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getIdGen() {
		return idGen;
	}
	public void setIdGen(int idGen) {
		this.idGen = idGen;
	}
	
	
}
