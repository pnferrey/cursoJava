package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaController {
	
	@GetMapping("/")
	public String index(Model model)
	{
		model.addAttribute("titulo", "Enviar paramatros de la ruta (@PathVariable)");
		return "variables/index";
	}
	
	@GetMapping("/string/{texto}")
	public String variables(@PathVariable String texto,Model model)
	{
	   model.addAttribute("titulo", "Recibir paramatros de la ruta (@PathVariable)");
	   model.addAttribute("resultado", "El texto enviado: " +texto);
		return "variables/ver";
	}
	
	
	@GetMapping("/string/{texto}/{numero}")
	public String variables(@PathVariable String texto,@PathVariable Integer numero,Model model)
	{
	   model.addAttribute("titulo", "Recibir paramatros de la ruta (@PathVariable)");
	   model.addAttribute("resultado", "El texto enviado: " +texto
	   + "y el numero enviado en el path es :" + numero);	   					
		return "variables/ver";
	}
	

}
