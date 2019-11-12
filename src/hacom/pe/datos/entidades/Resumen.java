package hacom.pe.datos.entidades;

import java.io.Serializable;
import java.util.Date;

public class Resumen implements Serializable{

	private String name;
	private String assitance;
	private String totalRemote;
	private String total;
	private String fechaVisCadI;
	private String fechaVisCadF;
	
	private Date fechaResCalI = new Date();
	private Date fechaResCalF = new Date();
	
	public Resumen() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAssitance() {
		return assitance;
	}
	public void setAssitance(String assitance) {
		this.assitance = assitance;
	}
	public String getTotalRemote() {
		return totalRemote;
	}
	public void setTotalRemote(String totalRemote) {
		this.totalRemote = totalRemote;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getFechaVisCadI() {
		return fechaVisCadI;
	}
	public void setFechaVisCadI(String fechaVisCadI) {
		this.fechaVisCadI = fechaVisCadI;
	}
	public String getFechaVisCadF() {
		return fechaVisCadF;
	}
	public void setFechaVisCadF(String fechaVisCadF) {
		this.fechaVisCadF = fechaVisCadF;
	}
	public Date getFechaResCalI() {
		return fechaResCalI;
	}
	public void setFechaResCalI(Date fechaResCalI) {
		this.fechaResCalI = fechaResCalI;
	}
	public Date getFechaResCalF() {
		return fechaResCalF;
	}
	public void setFechaResCalF(Date fechaResCalF) {
		this.fechaResCalF = fechaResCalF;
	}

	
}
