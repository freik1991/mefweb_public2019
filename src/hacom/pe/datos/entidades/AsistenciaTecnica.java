package hacom.pe.datos.entidades;

import java.math.BigInteger;
import java.util.Date;

public class AsistenciaTecnica {

	private String representantName;
	private String representantWorkingPosition;
	private String assistanceStartTime; 
	private String assistanceEndTime;
	private String arrivalDate;
	private String COORDENADAS;
	private int isFunctional;
	private int isTechnical;
	private int isTraining;
	private String secEjec;
	private int sectorist_id;
	private int department;
	private String unitName;
	private String name;
	private String IMPLANTADOR;
	private String departureDate;
	private int id;
	private String nameSec;
	private Long fechaIni;
	private Long fechaFin;
	private Date fechaICal = new Date();
	private Date fechaFCal = new Date();
	
	private boolean checkSecEje;
	private boolean checkDepa;
	private boolean checkEntidad;
	private boolean checkSectorista;
	private boolean checkImpl;
	private boolean checkFunc;
	private boolean checkTec;
	private boolean checkCap;
	private boolean checkRep;
	private boolean checkCarR;

	private int idAssip;
	private String 	representantEmail;
	private String 	localType;
	private String 	assistanceType;
	private int 	system_id;
	private int 	itinerary_id;
	private float 	coordinateX;
	private float 	coordinateY;
	private String 	typeAttention;
	private int 	unitid;
	private String 	status;
private String phoneNumber;
private String assistanceDescription;
private String recomendacion;
private Date horaIni;
private Date horaFin;

	public AsistenciaTecnica() {
		super();
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
	
	
	public String getAssistanceEndTime() {
		return assistanceEndTime;
	}
	public void setAssistanceEndTime(String assistanceEndTime) {
		this.assistanceEndTime = assistanceEndTime;
	}
	public void setAssistanceStartTime(String assistanceStartTime) {
		this.assistanceStartTime = assistanceStartTime;
	}
	
	
	public String getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public String getAssistanceStartTime() {
		return assistanceStartTime;
	}
	public String getCOORDENADAS() {
		return COORDENADAS;
	}
	public void setCOORDENADAS(String cOORDENADAS) {
		COORDENADAS = cOORDENADAS;
	}
	

	public int getIsFunctional() {
		return isFunctional;
	}
	public void setIsFunctional(int isFunctional) {
		this.isFunctional = isFunctional;
	}
	public int getIsTechnical() {
		return isTechnical;
	}
	public void setIsTechnical(int isTechnical) {
		this.isTechnical = isTechnical;
	}
	public int getIsTraining() {
		return isTraining;
	}
	public void setIsTraining(int isTraining) {
		this.isTraining = isTraining;
	}
	
	
	
	public String getSecEjec() {
		return secEjec;
	}
	public void setSecEjec(String secEjec) {
		this.secEjec = secEjec;
	}
	public int getDepartment() {
		return department;
	}
	public void setDepartment(int department) {
		this.department = department;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
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
	
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameSec() {
		return nameSec;
	}
	public void setNameSec(String nameSec) {
		this.nameSec = nameSec;
	}
	
	public Long getFechaIni() {
		return fechaIni;
	}
	public void setFechaIni(Long fechaIni) {
		this.fechaIni = fechaIni;
	}
	public Long getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Long fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Date getFechaICal() {
		return fechaICal;
	}
	public void setFechaICal(Date fechaICal) {
		this.fechaICal = fechaICal;
	}
	public Date getFechaFCal() {
		return fechaFCal;
	}
	public void setFechaFCal(Date fechaFCal) {
		this.fechaFCal = fechaFCal;
	}
	public int getSectorist_id() {
		return sectorist_id;
	}
	public void setSectorist_id(int sectorist_id) {
		this.sectorist_id = sectorist_id;
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
	public boolean isCheckFunc() {
		return checkFunc;
	}
	public void setCheckFunc(boolean checkFunc) {
		this.checkFunc = checkFunc;
	}
	public boolean isCheckTec() {
		return checkTec;
	}
	public void setCheckTec(boolean checkTec) {
		this.checkTec = checkTec;
	}
	public boolean isCheckCap() {
		return checkCap;
	}
	public void setCheckCap(boolean checkCap) {
		this.checkCap = checkCap;
	}
	public boolean isCheckRep() {
		return checkRep;
	}
	public void setCheckRep(boolean checkRep) {
		this.checkRep = checkRep;
	}
	public boolean isCheckCarR() {
		return checkCarR;
	}
	public void setCheckCarR(boolean checkCarR) {
		this.checkCarR = checkCarR;
	}
	public int getIdAssip() {
		return idAssip;
	}
	public void setIdAssip(int idAssip) {
		this.idAssip = idAssip;
	}
	public String getRepresentantEmail() {
		return representantEmail;
	}
	public void setRepresentantEmail(String representantEmail) {
		this.representantEmail = representantEmail;
	}
	public String getLocalType() {
		return localType;
	}
	public void setLocalType(String localType) {
		this.localType = localType;
	}
	public String getAssistanceType() {
		return assistanceType;
	}
	public void setAssistanceType(String assistanceType) {
		this.assistanceType = assistanceType;
	}

	public int getSystem_id() {
		return system_id;
	}
	public void setSystem_id(int system_id) {
		this.system_id = system_id;
	}
	public int getItinerary_id() {
		return itinerary_id;
	}
	public void setItinerary_id(int itinerary_id) {
		this.itinerary_id = itinerary_id;
	}
	
	public float getCoordinateX() {
		return coordinateX;
	}
	public void setCoordinateX(float coordinateX) {
		this.coordinateX = coordinateX;
	}
	public float getCoordinateY() {
		return coordinateY;
	}
	public void setCoordinateY(float coordinateY) {
		this.coordinateY = coordinateY;
	}
	public String getTypeAttention() {
		return typeAttention;
	}
	public void setTypeAttention(String typeAttention) {
		this.typeAttention = typeAttention;
	}
	public int getUnitid() {
		return unitid;
	}
	public void setUnitid(int unitid) {
		this.unitid = unitid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAssistanceDescription() {
		return assistanceDescription;
	}
	public void setAssistanceDescription(String assistanceDescription) {
		this.assistanceDescription = assistanceDescription;
	}
	public String getRecomendacion() {
		return recomendacion;
	}
	public void setRecomendacion(String recomendacion) {
		this.recomendacion = recomendacion;
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
	
	
	
	
	
}
