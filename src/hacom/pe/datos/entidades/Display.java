package hacom.pe.datos.entidades;

import java.util.Date;

import hacom.pe.util.GenerateExpressions;
import lombok.Data;

@Data
public class Display implements Cloneable {
	private int displayID;
	private int accountID;
	private int routeID;
	private int vehicleID;
	private int chipID;
	private String token;
	private String series;
	private String brand;
	private Long creationTime;
	private Long sessionIDCreation;
	private Long lastUpdateTime;
	private Long sessionIDUpdate;
	private int unlockPassword;
	private int isTrackable; //para que envie posiciones como el GPS
	private String appVersion; //automático solo para mostrar
	private int notificationType; //No hay referencia sobre esto siempre es 1
	private int unlockPasswordSetting;
	private int gift; //para los ticket premiados //cada cantidad de impresión
	private Long deliveryDate;
	
	/*
	 * unlockPassword, unlockPasswordSetting y gift, debe ser masivo por (ruta)
	 * pero como no se elige por ruta severá ser por cuenta
	 * 
	 * */	
	
	private String routerName;
	private String bussinessName;
	private String vehicleName;
	private String sim;
	
	//para verificar cambios
	private int accountIDOld;
	private int vehicleIDOld;
	private int chipIDOld;
	private String seriesOld;
	private String brandOld;
	
	//para historyal de cambios
	private int gpsHistoryID;
	private String userName;

	private String bussinessNameOld;
	private String vehicleNameOld;
	private String simOld;

	public void voidPrepararEdicion() {
		this.accountIDOld = this.accountID;
		this.vehicleIDOld = this.vehicleID;
		this.chipIDOld = this.chipID;
		this.seriesOld = this.series;
		this.brandOld = this.brand;
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
	
	public Display clone(){
        try {
			return (Display) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
		
}
