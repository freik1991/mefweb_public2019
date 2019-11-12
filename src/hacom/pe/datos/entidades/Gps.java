package hacom.pe.datos.entidades;

import java.util.Date;

import hacom.pe.util.GenerateExpressions;
import lombok.Data;

@Data
public class Gps implements Cloneable{
	private int gpsID;
	private int accountID;
	private int vehicleID;
	private int chipID;
	private String esn;
	private int gpsTypeID;
	private float lastValidLatitude;
	private float lastValidLongitude;
	private Long lastGpsTimestamp;
	private float lastOdometer;
	private int transmitFrecuency;
	private int isActive;
	private String displayName;
	private String description;
	private String notes;
	private Long deliveryDate;
	private Long creationTime;
	private Long sessionIDCreation;
	private Long lastUpdateTime;
	private Long sessionIDUpdate;
	
	private String bussinessName;
	private String vehicleName;
	private String sim;
	private String name;

	//para verificar cambios
	private int vehicleIDOld;
	private int chipIDOld;
	private int gpsTypeIDOld;
	private int accountIDOld;
	private int isActiveOld;
	
	//para historyal de cambios
	private int gpsHistoryID;
	private String userName;

	private String bussinessNameOld;
	private String vehicleNameOld;
	private String simOld;
	private String nameOld;

	public void voidPrepararEdicion() {
		this.vehicleIDOld = this.vehicleID;
		this.chipIDOld = this.chipID;
		this.gpsTypeIDOld = this.gpsTypeID;
		this.accountIDOld = this.accountID;
		this.isActiveOld = this.isActive;
	}
	
	//deliveryDate
	public Date getDeliveryDateChange() {
		if (this.deliveryDate == null) {
			return null;
		}
		return GenerateExpressions.ConvertEpochToDate(this.deliveryDate);
	}

	public void setDeliveryDateChange(Date fecha) {
		if (fecha == null) {
			return;
		}
		this.deliveryDate = GenerateExpressions.ConvertDateToEpoch(fecha);
	}
	
	public String getDeliveryDateTxt() {
		if (this.deliveryDate == null) {
			return null;
		}
		return GenerateExpressions.ConvertEpochToDateFormat(deliveryDate, "dd/MM/yyyy");
	}
	
	//lastGpsTimestamp
	public String getLastGpsTimestampTxt() {
		if (this.lastGpsTimestamp == null) {
			return null;
		}
		return GenerateExpressions.ConvertEpochToDateFormat(lastGpsTimestamp, "dd/MM/yyyy HH:mm");
	}
	
	//creationTime
	public String getCreationTimeTxt() {
		if (this.creationTime == null) {
			return null;
		}
		return GenerateExpressions.ConvertEpochToDateFormat(creationTime, "dd/MM/yyyy HH:mm");
	}
	
	//lastUpdateTime
	public String getLastUpdateTimeTxt() {
		if (this.lastUpdateTime == null) {
			return null;
		}
		return GenerateExpressions.ConvertEpochToDateFormat(lastUpdateTime, "dd/MM/yyyy HH:mm");
	}
	
	//isActive
	public String getIsActiveTxt() {
		if(isActive==1) {
			return "Activo";
		} else {
			return "Inactivo";
		}
	}
	
	//isActiveOld
	public String getIsActiveOldTxt() {
		if(isActiveOld==1) {
			return "Activo";
		} else {
			return "Inactivo";
		}
	}
	
	public Boolean getIsActiveChange() {
		if(isActive==1) {
			return true;
		} else {
			return false;
		}
	}

	public void setIsActiveChange(Boolean activo) {
		if(activo) {
			this.isActive=1;
		} else {
			this.isActive=2;
		}
	}
	
	public Gps clone(){
        try {
			return (Gps) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
		
}
