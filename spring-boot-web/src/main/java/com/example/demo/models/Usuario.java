package com.example.demo.models;

public class Usuario {
	private String nombre;
	private String email;

	public String getEmail() {
		return email;
	}

	public Usuario(String nombre, String email, String apellido) {
		this.nombre = nombre;
		this.email = email;
		this.apellido = apellido;
	}

	public Usuario() {
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private String apellido;

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
}
