package hacom.pe.datos.entidades;

import java.util.Date;

public class Actividad {

	private int idAct;
	private int implId;
	private int systemId;
	private int idMot;
	private String activitieDate;
	private String comment;
	private String implanted_name;
	private String systemName;
	private String titulo;
	private String state;
    private Date fechaVis;
private int capacitadorId;
private int idCap;
	public int getIdAct() {
		return idAct;
	}
	public void setIdAct(int idAct) {
		this.idAct = idAct;
	}
	public int getImplId() {
		return implId;
	}
	public void setImplId(int implId) {
		this.implId = implId;
	}
	public int getSystemId() {
		return systemId;
	}
	public void setSystemId(int systemId) {
		this.systemId = systemId;
	}
	public int getIdMot() {
		return idMot;
	}
	public void setIdMot(int idMot) {
		this.idMot = idMot;
	}
	public String getActivitieDate() {
		return activitieDate;
	}
	public void setActivitieDate(String activitieDate) {
		this.activitieDate = activitieDate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getImplanted_name() {
		return implanted_name;
	}
	public void setImplanted_name(String implanted_name) {
		this.implanted_name = implanted_name;
	}
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Date getFechaVis() {
		return fechaVis;
	}
	public void setFechaVis(Date fechaVis) {
		this.fechaVis = fechaVis;
	}
	public int getCapacitadorId() {
		return capacitadorId;
	}
	public void setCapacitadorId(int capacitadorId) {
		this.capacitadorId = capacitadorId;
	}
	public int getIdCap() {
		return idCap;
	}
	public void setIdCap(int idCap) {
		this.idCap = idCap;
	}

	
}
