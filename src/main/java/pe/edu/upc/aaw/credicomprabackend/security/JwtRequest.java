package pe.edu.upc.aaw.credicomprabackend.security;

import java.io.Serializable;

/*
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

//Clase 4
@Data
@AllArgsConstructor
@NoArgsConstructor*/
public class JwtRequest implements Serializable {
	private static final long serialVersionUID = 5926468583005150707L;
	private String nameUsuario;
	private String passwordUsuario;
	public JwtRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JwtRequest(String nameUsuario, String passwordUsuario) {
		super();
		this.nameUsuario = nameUsuario;
		this.passwordUsuario = passwordUsuario;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getNameUsuario() {
		return nameUsuario;
	}
	public String getPasswordUsuario() {
		return passwordUsuario;
	}
	public void setNameUsuario(String nameUsuario) {
		this.nameUsuario = nameUsuario;
	}
	public void setPasswordUsuario(String passwordUsuario) {
		this.passwordUsuario = passwordUsuario;
	}
}