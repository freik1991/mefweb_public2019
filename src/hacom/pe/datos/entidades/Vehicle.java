package hacom.pe.datos.entidades;

import lombok.Data;

@Data
public class Vehicle {
	private int vehicleID;
	private int accountID;
	private int routeID;
	private int gpsID;
	private String vehicleName;
	private int isActive;

	public Vehicle() {
		super();
	}

	public Boolean getIsActiveBoolean() {
		if (this.isActive == 1) {
			return true;
		} else {
			return false;
		}
	}

	public void setIsActiveBoolean(Boolean isActiveBoolean) {
		if (isActiveBoolean) {
			this.isActive = 1;
		} else {
			this.isActive = 2;
		}
	}

	public String getIsActiveString() {
		if (this.isActive == 1) {
			return "Active";
		} else if (this.isActive == 2){
			return "Inactivo";
		} else {
			return "Mantemiento";
		}
	}

}
