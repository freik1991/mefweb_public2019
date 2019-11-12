package hacom.pe.datos.entidades;

public class SubModulo {

	private int subModuleID;
	private int status;
	private int moduleID;
	private String subModuleName;
	private String moduleName;
	
	public SubModulo() {
		super();
	}
	public int getSubModuleID() {
		return subModuleID;
	}
	public void setSubModuleID(int subModuleID) {
		this.subModuleID = subModuleID;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getModuleID() {
		return moduleID;
	}
	public void setModuleID(int moduleID) {
		this.moduleID = moduleID;
	}
	public String getSubModuleName() {
		return subModuleName;
	}
	public void setSubModuleName(String subModuleName) {
		this.subModuleName = subModuleName;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
	
}
