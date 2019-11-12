package hacom.pe.datos.entidades;

import lombok.Data;

@Data
public class User {
	private String userName;
	private String userPass;
	private String name;
	private String perfil;
	//private String userID;
	
	public User() {
		super();
	}

	public User(String userName, String userPass, String name) {
		this.userName = userName;
		this.userPass = userPass;
		this.name = name;
		//this.userID = userID;
	}

	

}
