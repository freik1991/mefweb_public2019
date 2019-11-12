package hacom.pe.datos.entidades;

import java.util.Date;

public class Visita {

	private String secEjec;
	private String departamento;
	private int depa;
	private String name;

	private String unitName;
	private String sectorist_names;
	private String implanter_names;
	private String fechaVisCadI;
	private String fechaVisCadF;
	
	private Date fechaVisCalI = new Date();
	private Date fechaVisCalF = new Date();

	
	private String statusNoPlanificado;
	private String totalRemote;
	private String statusTotal;

	
	private boolean checkSecEje;
	private boolean checkDepa;
	private boolean checkEntidad;
	private boolean checkSectorista;
	private boolean checkImpl;
	private boolean disAsis;
	private boolean checkFechaAsis;
	
	
	
	public Visita() {
		super();
	}
	public String getSecEjec() {
		return secEjec;
	}
	public void setSecEjec(String secEjec) {
		this.secEjec = secEjec;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public int getDepa() {
		return depa;
	}
	public void setDepa(int depa) {
		this.depa = depa;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getSectorist_names() {
		return sectorist_names;
	}
	public void setSectorist_names(String sectorist_names) {
		this.sectorist_names = sectorist_names;
	}
	public String getImplanter_names() {
		return implanter_names;
	}
	public void setImplanter_names(String implanter_names) {
		this.implanter_names = implanter_names;
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
	public Date getFechaVisCalI() {
		return fechaVisCalI;
	}
	public void setFechaVisCalI(Date fechaVisCalI) {
		this.fechaVisCalI = fechaVisCalI;
	}
	public Date getFechaVisCalF() {
		return fechaVisCalF;
	}
	public void setFechaVisCalF(Date fechaVisCalF) {
		this.fechaVisCalF = fechaVisCalF;
	}
	public String getStatusNoPlanificado() {
		return statusNoPlanificado;
	}
	public void setStatusNoPlanificado(String statusNoPlanificado) {
		this.statusNoPlanificado = statusNoPlanificado;
	}
	public String getTotalRemote() {
		return totalRemote;
	}
	public void setTotalRemote(String totalRemote) {
		this.totalRemote = totalRemote;
	}
	public String getStatusTotal() {
		return statusTotal;
	}
	public void setStatusTotal(String statusTotal) {
		this.statusTotal = statusTotal;
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
	public boolean isDisAsis() {
		return disAsis;
	}
	public void setDisAsis(boolean disAsis) {
		this.disAsis = disAsis;
	}
	public boolean isCheckFechaAsis() {
		return checkFechaAsis;
	}
	public void setCheckFechaAsis(boolean checkFechaAsis) {
		this.checkFechaAsis = checkFechaAsis;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
