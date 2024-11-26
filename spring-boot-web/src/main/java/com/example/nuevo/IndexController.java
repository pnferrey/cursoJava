package com.example.nuevo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Usuario;


@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	
	@GetMapping(value={"/index","/","/home"})
	public String index(Model model)
	{
		model.addAttribute("titulo", textoIndex);
		return "index";
	}
	@RequestMapping("/perfil")	
	public String perfil(Model model)
	{
		Usuario usuario=new Usuario();
		usuario.setNombre("Andres");
		usuario.setApellido("papellido");
		usuario.setEmail("prueba@correo.com");
		model.addAttribute("usuario",usuario);
		model.addAttribute("titulo", textoPerfil .concat(usuario.getNombre()));
		return "perfil";
	}
	
	@RequestMapping("/listar")	
	public String listar(Model model)
	{
		model.addAttribute("titulo", textoListar);
		
	
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	 public List<Usuario> poblarUsuarios(){
	  List<Usuario> usuarios=new ArrayList<>();
		usuarios.add(new Usuario("Andres","papellido","prueba@correo.com"));
		usuarios.add(new Usuario("John","doe","prueba2@correo.com"));
		usuarios.add(new Usuario("Jake","doe","prueba3@correo.com"));		
		return usuarios;
  	
  	}
	
	
	
}
