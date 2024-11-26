package com.example.demo.error.app.services;

import java.util.List;

import com.example.demo.error.app.models.domain.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> lsitar();
	public Usuario obtenerPorId(Integer id);
}
