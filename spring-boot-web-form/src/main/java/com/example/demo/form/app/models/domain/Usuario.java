package com.example.demo.form.app.models.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Usuario {
	//@Pattern(regexp="[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")
	private String identificador;
	
	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	@NotEmpty
	private String nombre;
	@NotEmpty
	private String apellido;
	
	@NotEmpty
	@Size(min=3,max=8)
	private String username;
	@NotEmpty
	private String password;
	@NotEmpty
	@Email(message="correo con formato incorrecto personalizado")
	private String email;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
}
