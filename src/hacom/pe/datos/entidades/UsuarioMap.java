package hacom.pe.datos.entidades;

public class UsuarioMap {
    private int idUsumap;
    private String usuario;
    private String clave;
    private String tipo;
       
	public UsuarioMap() {
		super();
	}
	public int getIdUsumap() {
		return idUsumap;
	}
	public void setIdUsumap(int idUsumap) {
		this.idUsumap = idUsumap;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

    
}
