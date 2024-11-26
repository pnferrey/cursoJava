package com.example.demo.error.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.error.app.models.domain.Usuario;
import com.example.demo.error.app.services.IUsuarioService;

@Controller
public class AppControllerError {
	@Autowired
	private IUsuarioService usuarioService;
	@GetMapping("/index")
	public String index() {
		Integer valor=100/0;
		return "index";

	}
	@GetMapping("/ver/{id}")
	public String ver (@PathVariable Integer id, Model model)
	{
		Usuario usuario =usuarioService.obtenerPorId(id);
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Detalle susuario: ".concat(usuario.getNombre()));
		return "ver";
	}
}
