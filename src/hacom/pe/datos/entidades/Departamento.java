package hacom.pe.datos.entidades;

import java.io.Serializable;

public class Departamento implements Serializable{

	private int id;
	private String name;
	private String mefid;
	
	
	
	public Departamento() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMefid() {
		return mefid;
	}
	public void setMefid(String mefid) {
		this.mefid = mefid;
	}
	
	
}
