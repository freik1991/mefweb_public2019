package hacom.pe.datos.entidades.util;

import hacom.pe.util.GenerateExpressions;
import lombok.Data;

@Data
public class GpsControl {

	private int accountID;
	private String bussinessName;
	private int routeID;
	private int vehicleID;
	private String padron;
	private String placa;
	private int gpsID;
	private String esn;
	private String gpsType;
	private String rutaName;
	private int personID;
	private String statusName;
	private int checkPointID;
	private String address;
	private Long timeIngreso;
	private Long creationTime;
	private String diff;
	private boolean apagado=false;
	private boolean problema=false;
	
	public GpsControl() {
		super();
	}


	public GpsControl(int accountID, String bussinessName, int routeID, int vehicleID, String padron, String placa,
			int gpsID, String esn, String gpsType, String rutaName, int personID, String statusName, int checkPointID,
			String address, Long timeIngreso, Long creationTime, String diff) {
		super();
		this.accountID = accountID;
		this.bussinessName = bussinessName;
		this.routeID = routeID;
		this.vehicleID = vehicleID;
		this.padron = padron;
		this.placa = placa;
		this.gpsID = gpsID;
		this.esn = esn;
		this.gpsType = gpsType;
		this.rutaName = rutaName;
		this.personID = personID;
		this.statusName = statusName;
		this.checkPointID = checkPointID;
		this.address = address;
		this.timeIngreso = timeIngreso;
		this.creationTime = creationTime;
		this.diff = diff;
	}


	public String getAgoShort() {
		if (timeIngreso != null) {
			Long diffTime = (System.currentTimeMillis() / 1000) - timeIngreso;
			diff = GenerateExpressions.ConvertSecondsToHourMinuteSecond(diffTime);
		} else {
			diff = "";
		}
		return diff;
	}

	public void setAgoShort(String agoShort) {
		this.diff = agoShort;
	}
	
	public String getTimeIngresoText() {
		if (this.timeIngreso == null) {
			return null;
		}
		return GenerateExpressions.ConvertEpochToDateFormat(this.timeIngreso, "dd/MM/yyyy HH:mm:ss");
	}

	public String getCreationTimeText() {
		if (this.creationTime == null) {
			return null;
		}
		return GenerateExpressions.ConvertEpochToDateFormat(this.creationTime, "dd/MM/yyyy HH:mm:ss");
	}

}
