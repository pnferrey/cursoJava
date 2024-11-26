package com.example.demo.error.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.error.app.models.domain.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
   private List<Usuario> lista;
   
	public UsuarioServiceImpl() {

	this.lista = new ArrayList<>();
	this.lista.add(new Usuario(1,"Adres","Guzman"));
	this.lista.add(new Usuario(2,"pepa","Guzman"));
	this.lista.add(new Usuario(3,"Paco","Guzman"));
	this.lista.add(new Usuario(4,"Juan","Guzman"));
	this.lista.add(new Usuario(5,"Luci","Guzman"));
	this.lista.add(new Usuario(6,"John","Guzman"));
	this.lista.add(new Usuario(7,"Juan","Guzman"));
			
	}

	@Override
	public List<Usuario> lsitar() {
	
		return this.lista;
	}

	@Override
	public Usuario obtenerPorId(Integer id) {
		Usuario resultado=null;
		for (Usuario u:this.lista)
		{
			if (u.getId().equals(id)) {
				resultado=u;
				break;
			}
		}	
		
		return resultado;
	}

}
