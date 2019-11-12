package hacom.pe.controller;

public class MensajeMapa {

	private String tipo;
	private String tipoMensaje;
	private int periodo;
	private int numDif;
	private String modoVis;
	private String fechaIni;
	private String MensajeCont;
	private String tecnologia;
	
	
	public MensajeMapa(String tipo, String tipoMensaje, int periodo, int numDif, String modoVis, String fechaIni,
			String mensajeCont, String tecnologia) {
		super();
		this.tipo = tipo;
		this.tipoMensaje = tipoMensaje;
		this.periodo = periodo;
		this.numDif = numDif;
		this.modoVis = modoVis;
		this.fechaIni = fechaIni;
		this.MensajeCont = mensajeCont;
		this.tecnologia = tecnologia;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTipoMensaje() {
		return tipoMensaje;
	}
	public void setTipoMensaje(String tipoMensaje) {
		this.tipoMensaje = tipoMensaje;
	}
	public int getPeriodo() {
		return periodo;
	}
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	public int getNumDif() {
		return numDif;
	}
	public void setNumDif(int numDif) {
		this.numDif = numDif;
	}
	public String getModoVis() {
		return modoVis;
	}
	public void setModoVis(String modoVis) {
		this.modoVis = modoVis;
	}
	public String getFechaIni() {
		return fechaIni;
	}
	public void setFechaIni(String fechaIni) {
		this.fechaIni = fechaIni;
	}
	public String getMensajeCont() {
		return MensajeCont;
	}
	public void setMensajeCont(String mensajeCont) {
		MensajeCont = mensajeCont;
	}
	public String getTecnologia() {
		return tecnologia;
	}
	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}
	
	
}
