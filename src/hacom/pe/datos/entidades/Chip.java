package hacom.pe.datos.entidades;

import java.util.Date;

import hacom.pe.util.GenerateExpressions;
import lombok.Data;

@Data
public class Chip implements Cloneable {
	private int chipID;
	private int gpsID;
	private String sim;
	private String iccid;
	private int chipSupplierID;
	private int chipStatusID;
	private Long deliveryDate;
	private Long creationTime;
	private Long sessionIDCreation;
	private Long lastUpdateTime;
	private Long sessionIDUpdate;
	private String description;
	
	private String esn;
	private String statusName;
	private String supplierName;
	private int displayID;
	
	private int chipStatusIDOld;
	private int chipSupplierIDOld;
	private String iccidOld;
	
	private int chipHistoryID;
	private String userName;
	private String statusNameOld;
	private String supplierNameOld;
	
	public void voidPrepararEdicion() {
		try {
			this.chipStatusIDOld = this.chipStatusID;
			this.chipSupplierIDOld = this.chipSupplierID;
			this.iccidOld = this.iccid;
		}catch (Exception e) {
			e.printStackTrace();
		}

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
		
	public Chip clone(){
        try {
			return (Chip) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
}
