package hacom.pe.datos.entidades.util;

import lombok.Data;

@Data
public class Theme {
	private int id;    
    private String displayName; 
    private String name;
    
	public Theme(int id, String displayName, String name) {
		super();
		this.id = id;
		this.displayName = displayName;
		this.name = name;
	}
    
    
    
}
