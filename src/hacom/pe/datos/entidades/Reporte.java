package hacom.pe.datos.entidades;

import java.math.BigInteger;
import java.util.Date;

public class Reporte {

	private int registerType;
	private String modality;
	private String timestamp;
	private String description;
	private String unitName;
	private String secEjec;
	private int sectorist_id;
	private int department;
	private String name;
	private String IMPLANTADOR;
	private String systemName;
	private String moduleName;
	private String subModuleName;
	private String assistanceDate;
	private String nameSec;
	private String representativeName;
	private String representativePosition;
	private String representativePhone;
	private String representativeEmail;
	private String depaname;
	private String assistanceType;
	private String sectorist_names;
	private String implantador_names;
	private String assistanceStartTime;
	private String assistanceEndTime;

	private Long fechaAsisIni;
	private Long FechaAsisHas;
	private Long FechaRegIni;
	private Long FechaRegHas;

	private String modalidad;
	private String sistema;
	private int registro;

	private boolean checkSecEje;
	private boolean checkDepa;
	private boolean checkEntidad;
	private boolean checkSectorista;
	private boolean checkImpl;
	private boolean checkMod;
	private boolean checkSis;
	private boolean checkTipA;
	private boolean checkFechaAsisRIni;
	private boolean checkFechaAsisRFin;
	private String rbFechaSelec;
	private boolean disEnvio;
	private boolean disResp;

	private Date fechaAsiICal = new Date();
	private Date fechaAsiFCal = new Date();

	private Date fechaRegICal = new Date();
	private Date fechaARegFCal = new Date();

	private int unitID;
	private String email;
	private int systemID;
	private int moduleID;
	private int subModuleID;
	private int implanterID;
	private String creationTime;
	private String status;
	private int remoteAssistanceID;
	private String implanted_name;
	private Date horaIni;
	private Date horaFin;
	private Date fechaVis;
	private String recomendacion;
	private String representantName;
	private String representantWorkingPosition;
    private String departament_name;
	private int assitance;
	private int totalRemote;
	private int total;
private String coordenadas;
	private int typeAttention;
	private BigInteger arrivalDate;
	private BigInteger departureDate;
    private String isFunctional;
    private String isTechnical;
    private String isTraining;
    private String answerComment;
	private int idAttention;
	public int getRegisterType() {
		return registerType;
	}

	public void setRegisterType(int registerType) {
		this.registerType = registerType;
	}

	public String getModality() {
		return modality;
	}

	public void setModality(String modality) {
		this.modality = modality;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
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

	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department) {
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIMPLANTADOR() {
		return IMPLANTADOR;
	}

	public void setIMPLANTADOR(String iMPLANTADOR) {
		IMPLANTADOR = iMPLANTADOR;
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

	public String getAssistanceDate() {
		return assistanceDate;
	}

	public void setAssistanceDate(String assistanceDate) {
		this.assistanceDate = assistanceDate;
	}

	public String getNameSec() {
		return nameSec;
	}

	public void setNameSec(String nameSec) {
		this.nameSec = nameSec;
	}

	public String getRepresentativeName() {
		return representativeName;
	}

	public void setRepresentativeName(String representativeName) {
		this.representativeName = representativeName;
	}

	public String getRepresentativePosition() {
		return representativePosition;
	}

	public void setRepresentativePosition(String representativePosition) {
		this.representativePosition = representativePosition;
	}

	public String getRepresentativePhone() {
		return representativePhone;
	}

	public void setRepresentativePhone(String representativePhone) {
		this.representativePhone = representativePhone;
	}

	public String getRepresentativeEmail() {
		return representativeEmail;
	}

	public void setRepresentativeEmail(String representativeEmail) {
		this.representativeEmail = representativeEmail;
	}

	public String getDepaname() {
		return depaname;
	}

	public void setDepaname(String depaname) {
		this.depaname = depaname;
	}

	public String getAssistanceType() {
		return assistanceType;
	}

	public void setAssistanceType(String assistanceType) {
		this.assistanceType = assistanceType;
	}

	public String getSectorist_names() {
		return sectorist_names;
	}

	public void setSectorist_names(String sectorist_names) {
		this.sectorist_names = sectorist_names;
	}

	public String getImplantador_names() {
		return implantador_names;
	}

	public void setImplantador_names(String implantador_names) {
		this.implantador_names = implantador_names;
	}

	public String getAssistanceStartTime() {
		return assistanceStartTime;
	}

	public void setAssistanceStartTime(String assistanceStartTime) {
		this.assistanceStartTime = assistanceStartTime;
	}

	public String getAssistanceEndTime() {
		return assistanceEndTime;
	}

	public void setAssistanceEndTime(String assistanceEndTime) {
		this.assistanceEndTime = assistanceEndTime;
	}

	public Long getFechaAsisIni() {
		return fechaAsisIni;
	}

	public void setFechaAsisIni(Long fechaAsisIni) {
		this.fechaAsisIni = fechaAsisIni;
	}

	public Long getFechaAsisHas() {
		return FechaAsisHas;
	}

	public void setFechaAsisHas(Long fechaAsisHas) {
		FechaAsisHas = fechaAsisHas;
	}

	public Long getFechaRegIni() {
		return FechaRegIni;
	}

	public void setFechaRegIni(Long fechaRegIni) {
		FechaRegIni = fechaRegIni;
	}

	public Long getFechaRegHas() {
		return FechaRegHas;
	}

	public void setFechaRegHas(Long fechaRegHas) {
		FechaRegHas = fechaRegHas;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public String getSistema() {
		return sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	public int getRegistro() {
		return registro;
	}

	public void setRegistro(int registro) {
		this.registro = registro;
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

	public boolean isCheckMod() {
		return checkMod;
	}

	public void setCheckMod(boolean checkMod) {
		this.checkMod = checkMod;
	}

	public boolean isCheckSis() {
		return checkSis;
	}

	public void setCheckSis(boolean checkSis) {
		this.checkSis = checkSis;
	}

	public boolean isCheckTipA() {
		return checkTipA;
	}

	public void setCheckTipA(boolean checkTipA) {
		this.checkTipA = checkTipA;
	}

	public boolean isCheckFechaAsisRIni() {
		return checkFechaAsisRIni;
	}

	public void setCheckFechaAsisRIni(boolean checkFechaAsisRIni) {
		this.checkFechaAsisRIni = checkFechaAsisRIni;
	}

	public boolean isCheckFechaAsisRFin() {
		return checkFechaAsisRFin;
	}

	public void setCheckFechaAsisRFin(boolean checkFechaAsisRFin) {
		this.checkFechaAsisRFin = checkFechaAsisRFin;
	}

	public String getRbFechaSelec() {
		return rbFechaSelec;
	}

	public void setRbFechaSelec(String rbFechaSelec) {
		this.rbFechaSelec = rbFechaSelec;
	}

	public boolean isDisEnvio() {
		return disEnvio;
	}

	public void setDisEnvio(boolean disEnvio) {
		this.disEnvio = disEnvio;
	}

	public boolean isDisResp() {
		return disResp;
	}

	public void setDisResp(boolean disResp) {
		this.disResp = disResp;
	}

	public Date getFechaAsiICal() {
		return fechaAsiICal;
	}

	public void setFechaAsiICal(Date fechaAsiICal) {
		this.fechaAsiICal = fechaAsiICal;
	}

	public Date getFechaAsiFCal() {
		return fechaAsiFCal;
	}

	public void setFechaAsiFCal(Date fechaAsiFCal) {
		this.fechaAsiFCal = fechaAsiFCal;
	}

	public Date getFechaRegICal() {
		return fechaRegICal;
	}

	public void setFechaRegICal(Date fechaRegICal) {
		this.fechaRegICal = fechaRegICal;
	}

	public Date getFechaARegFCal() {
		return fechaARegFCal;
	}

	public void setFechaARegFCal(Date fechaARegFCal) {
		this.fechaARegFCal = fechaARegFCal;
	}

	public int getUnitID() {
		return unitID;
	}

	public void setUnitID(int unitID) {
		this.unitID = unitID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSystemID() {
		return systemID;
	}

	public void setSystemID(int systemID) {
		this.systemID = systemID;
	}

	public int getModuleID() {
		return moduleID;
	}

	public void setModuleID(int moduleID) {
		this.moduleID = moduleID;
	}

	public int getSubModuleID() {
		return subModuleID;
	}

	public void setSubModuleID(int subModuleID) {
		this.subModuleID = subModuleID;
	}

	public int getImplanterID() {
		return implanterID;
	}

	public void setImplanterID(int implanterID) {
		this.implanterID = implanterID;
	}

	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getRemoteAssistanceID() {
		return remoteAssistanceID;
	}

	public void setRemoteAssistanceID(int remoteAssistanceID) {
		this.remoteAssistanceID = remoteAssistanceID;
	}

	public String getImplanted_name() {
		return implanted_name;
	}

	public void setImplanted_name(String implanted_name) {
		this.implanted_name = implanted_name;
	}

	public Date getHoraIni() {
		return horaIni;
	}

	public void setHoraIni(Date horaIni) {
		this.horaIni = horaIni;
	}

	public Date getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Date horaFin) {
		this.horaFin = horaFin;
	}

	public Date getFechaVis() {
		return fechaVis;
	}

	public void setFechaVis(Date fechaVis) {
		this.fechaVis = fechaVis;
	}

	public String getRecomendacion() {
		return recomendacion;
	}

	public void setRecomendacion(String recomendacion) {
		this.recomendacion = recomendacion;
	}

	public String getRepresentantName() {
		return representantName;
	}

	public void setRepresentantName(String representantName) {
		this.representantName = representantName;
	}

	public String getRepresentantWorkingPosition() {
		return representantWorkingPosition;
	}

	public void setRepresentantWorkingPosition(String representantWorkingPosition) {
		this.representantWorkingPosition = representantWorkingPosition;
	}

	public String getDepartament_name() {
		return departament_name;
	}

	public void setDepartament_name(String departament_name) {
		this.departament_name = departament_name;
	}

	public int getAssitance() {
		return assitance;
	}

	public void setAssitance(int assitance) {
		this.assitance = assitance;
	}

	public int getTotalRemote() {
		return totalRemote;
	}

	public void setTotalRemote(int totalRemote) {
		this.totalRemote = totalRemote;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(String coordenadas) {
		this.coordenadas = coordenadas;
	}

	public int getTypeAttention() {
		return typeAttention;
	}

	public void setTypeAttention(int typeAttention) {
		this.typeAttention = typeAttention;
	}

	public BigInteger getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(BigInteger arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public BigInteger getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(BigInteger departureDate) {
		this.departureDate = departureDate;
	}

	public String getIsFunctional() {
		return isFunctional;
	}

	public void setIsFunctional(String isFunctional) {
		this.isFunctional = isFunctional;
	}

	public String getIsTechnical() {
		return isTechnical;
	}

	public void setIsTechnical(String isTechnical) {
		this.isTechnical = isTechnical;
	}

	public String getIsTraining() {
		return isTraining;
	}

	public void setIsTraining(String isTraining) {
		this.isTraining = isTraining;
	}

	public String getAnswerComment() {
		return answerComment;
	}

	public void setAnswerComment(String answerComment) {
		this.answerComment = answerComment;
	}

	public int getIdAttention() {
		return idAttention;
	}

	public void setIdAttention(int idAttention) {
		this.idAttention = idAttention;
	}

}
