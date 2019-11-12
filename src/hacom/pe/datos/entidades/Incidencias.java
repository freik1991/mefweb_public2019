package hacom.pe.datos.entidades;

import java.util.Date;

public class Incidencias {


	private String registerDate;
	private String description;
	private String unitName;
	private String secEjec;
	private int sectorist_id;
	private String departament;
	private String sectorist_names;
	private String implanterName;
	private String systemName;
	private String moduleName;
	private String subModuleName;
	private Long assistanceDate;
	private String nameSec;
	private String name;
	private String fechaIncIni;
	private String fechaIncHas;


	private boolean checkSecEje;
	private boolean checkEntidad;
	private boolean checkSectorista;
	private boolean checkImpl;
	private boolean checkSis;


	
	private Date fechaIncICal = new Date();
	private Date fechaIncFCal = new Date();
	
	
	
	public Incidencias() {
		super();
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getSecEjec() {
		return secEjec;
	}
	public void setSecEjec(String secEjec) {
		this.secEjec = secEjec;
	}
	public int getSectorist_id() {
		return sectorist_id;
	}
	public void setSectorist_id(int sectorist_id) {
		this.sectorist_id = sectorist_id;
	}
	
	public String getDepartament() {
		return departament;
	}
	public void setDepartament(String departament) {
		this.departament = departament;
	}
	public String getSectorist_names() {
		return sectorist_names;
	}
	public void setSectorist_names(String sectorist_names) {
		this.sectorist_names = sectorist_names;
	}
	
	public String getImplanterName() {
		return implanterName;
	}
	public void setImplanterName(String implanterName) {
		this.implanterName = implanterName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getSubModuleName() {
		return subModuleName;
	}
	public void setSubModuleName(String subModuleName) {
		this.subModuleName = subModuleName;
	}
	public Long getAssistanceDate() {
		return assistanceDate;
	}
	public void setAssistanceDate(Long assistanceDate) {
		this.assistanceDate = assistanceDate;
	}
	public String getNameSec() {
		return nameSec;
	}
	public void setNameSec(String nameSec) {
		this.nameSec = nameSec;
	}
	
	public String getFechaIncIni() {
		return fechaIncIni;
	}
	public void setFechaIncIni(String fechaIncIni) {
		this.fechaIncIni = fechaIncIni;
	}

	public String getFechaIncHas() {
		return fechaIncHas;
	}
	public void setFechaIncHas(String fechaIncHas) {
		this.fechaIncHas = fechaIncHas;
	}
	public boolean isCheckSecEje() {
		return checkSecEje;
	}
	public void setCheckSecEje(boolean checkSecEje) {
		this.checkSecEje = checkSecEje;
	}
	public boolean isCheckEntidad() {
		return checkEntidad;
	}
	public void setCheckEntidad(boolean checkEntidad) {
		this.checkEntidad = checkEntidad;
	}
	public boolean isCheckSectorista() {
		return checkSectorista;
	}
	public void setCheckSectorista(boolean checkSectorista) {
		this.checkSectorista = checkSectorista;
	}
	public boolean isCheckImpl() {
		return checkImpl;
	}
	public void setCheckImpl(boolean checkImpl) {
		this.checkImpl = checkImpl;
	}
	public boolean isCheckSis() {
		return checkSis;
	}
	public void setCheckSis(boolean checkSis) {
		this.checkSis = checkSis;
	}
	public Date getFechaIncICal() {
		return fechaIncICal;
	}
	public void setFechaIncICal(Date fechaIncICal) {
		this.fechaIncICal = fechaIncICal;
	}
	public Date getFechaIncFCal() {
		return fechaIncFCal;
	}
	public void setFechaIncFCal(Date fechaIncFCal) {
		this.fechaIncFCal = fechaIncFCal;
	}
	
	
}
