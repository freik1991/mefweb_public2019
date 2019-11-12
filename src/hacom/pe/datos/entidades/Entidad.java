package hacom.pe.datos.entidades;

import java.math.BigInteger;
import java.util.Date;

public class Entidad {

	private String unit_secEjec;
	private String unit_unitname;
	private String department;
	private int depa;
	private int id;
	private String unitName; // variable para entidadImplantador
	private String sectorist_names;
	private String geozoneName;
	private String address;
	private String ubigeo;
	private String coordenadas;
	private String username;
	private String implanter_names;
	private String representativeName;
	private String representativeEmail;
	private String representativePhone;
	private String representativePosition;
	private String sectorist_id;

	private boolean checkSecEje;
	private boolean checkDepa;
	private boolean checkEntidad;
	private boolean checkSectorista;
	private boolean checkImpl;
	private boolean checkDire;
	private boolean checkGeo;
	private boolean checkRuc;

	private int district;
	private int province;

	private String depaname;
	private String disname;
	private String provname;
	private String unit_unitdescription;
	private String unitType;
	private String status;
	private int tipeUe;
	private String locality;
	private Long auditCreationDate;
	private int implantadorId;
    private int sectoristaId;
    
	public Entidad() {
		super();
	}

	public String getUnit_secEjec() {
		return unit_secEjec;
	}

	public void setUnit_secEjec(String unit_secEjec) {
		this.unit_secEjec = unit_secEjec;
	}

	public String getUnit_unitname() {
		return unit_unitname;
	}

	public void setUnit_unitname(String unit_unitname) {
		this.unit_unitname = unit_unitname;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getDepa() {
		return depa;
	}

	public void setDepa(int depa) {
		this.depa = depa;
	}

	public String getSectorist_names() {
		return sectorist_names;
	}

	public void setSectorist_names(String sectorist_names) {
		this.sectorist_names = sectorist_names;
	}

	public String getGeozoneName() {
		return geozoneName;
	}

	public void setGeozoneName(String geozoneName) {
		this.geozoneName = geozoneName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUbigeo() {
		return ubigeo;
	}

	public void setUbigeo(String ubigeo) {
		this.ubigeo = ubigeo;
	}

	public String getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(String coordenadas) {
		this.coordenadas = coordenadas;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isCheckSecEje() {
		return checkSecEje;
	}

	public void setCheckSecEje(boolean checkSecEje) {
		this.checkSecEje = checkSecEje;
	}

	public boolean isCheckDepa() {
		return checkDepa;
	}

	public void setCheckDepa(boolean checkDepa) {
		this.checkDepa = checkDepa;
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

	public boolean isCheckDire() {
		return checkDire;
	}

	public void setCheckDire(boolean checkDire) {
		this.checkDire = checkDire;
	}

	public boolean isCheckGeo() {
		return checkGeo;
	}

	public void setCheckGeo(boolean checkGeo) {
		this.checkGeo = checkGeo;
	}

	public boolean isCheckRuc() {
		return checkRuc;
	}

	public void setCheckRuc(boolean checkRuc) {
		this.checkRuc = checkRuc;
	}

	public String getImplanter_names() {
		return implanter_names;
	}

	public void setImplanter_names(String implanter_names) {
		this.implanter_names = implanter_names;
	}

	public String getRepresentativeName() {
		return representativeName;
	}

	public void setRepresentativeName(String representativeName) {
		this.representativeName = representativeName;
	}

	public int getDistrict() {
		return district;
	}

	public void setDistrict(int district) {
		this.district = district;
	}

	public int getProvince() {
		return province;
	}

	public void setProvince(int province) {
		this.province = province;
	}

	public String getDepaname() {
		return depaname;
	}

	public void setDepaname(String depaname) {
		this.depaname = depaname;
	}

	public String getDisname() {
		return disname;
	}

	public void setDisname(String disname) {
		this.disname = disname;
	}

	public String getProvname() {
		return provname;
	}

	public void setProvname(String provname) {
		this.provname = provname;
	}

	public String getUnit_unitdescription() {
		return unit_unitdescription;
	}

	public void setUnit_unitdescription(String unit_unitdescription) {
		this.unit_unitdescription = unit_unitdescription;
	}

	public String getUnitType() {
		return unitType;
	}

	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getRepresentativeEmail() {
		return representativeEmail;
	}

	public void setRepresentativeEmail(String representativeEmail) {
		this.representativeEmail = representativeEmail;
	}

	public String getRepresentativePhone() {
		return representativePhone;
	}

	public void setRepresentativePhone(String representativePhone) {
		this.representativePhone = representativePhone;
	}

	public String getRepresentativePosition() {
		return representativePosition;
	}

	public void setRepresentativePosition(String representativePosition) {
		this.representativePosition = representativePosition;
	}

	public String getSectorist_id() {
		return sectorist_id;
	}

	public void setSectorist_id(String sectorist_id) {
		this.sectorist_id = sectorist_id;
	}

	public int getTupeUe() {
		return tipeUe;
	}

	public void setTupeUe(int tipeUe) {
		this.tipeUe = tipeUe;
	}

	public int getTipeUe() {
		return tipeUe;
	}

	public void setTipeUe(int tipeUe) {
		this.tipeUe = tipeUe;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public Long getAuditCreationDate() {
		return auditCreationDate;
	}

	public void setAuditCreationDate(Long auditCreationDate) {
		this.auditCreationDate = auditCreationDate;
	}

	public int getImplantadorId() {
		return implantadorId;
	}

	public void setImplantadorId(int implantadorId) {
		this.implantadorId = implantadorId;
	}

	public int getSectoristaId() {
		return sectoristaId;
	}

	public void setSectoristaId(int sectoristaId) {
		this.sectoristaId = sectoristaId;
	}

	
}
