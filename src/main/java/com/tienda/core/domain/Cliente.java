package com.tienda.core.domain;

public class Cliente {
	private String userName; 
	private String password; 
	private String nombre;
	
	public Cliente() {
	}
	
	
	
	public Cliente(String userName, String password, String nombre) {
		super();
		this.userName = userName;
		this.password = password;
		this.nombre = nombre;
	}




	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
