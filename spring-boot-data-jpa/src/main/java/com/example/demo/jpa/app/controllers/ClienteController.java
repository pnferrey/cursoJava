package com.example.demo.jpa.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.jpa.app.models.entity.Cliente;
import com.example.demo.jpa.app.models.service.IClienteService;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("cliente")
public class ClienteController {
	@Autowired
	@Qualifier("clienteServiceImpl")
	private IClienteService clienteService;

	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de clientes");
		model.addAttribute("clientes", clienteService.findAll());
		return "listar";
	}
	@GetMapping("/form")
	public String crear(Map<String,Object> model)
	{
		Cliente cliente = new Cliente();
		model.put("titulo","Formulario de cliente");
		model.put("cliente", cliente);	
		return "form";
	}
	
	@RequestMapping (value="/form/{id}")
	public String editar(@PathVariable(value="id") Long id,Map <String, Object> model,RedirectAttributes flash)
	{
		Cliente cliente=null;
		if (id>0)
		{
			cliente=clienteService.findOne(id);
			if (cliente == null)
			{
				flash.addFlashAttribute("error","El ID de cliente no se encuentra en la BBDD");
				return "redirect:/listar";
			}
		}
		else
		{
			flash.addFlashAttribute("error","El ID del cliente no puede ser cero");
			return "redirect:/listar";
		}	
		model.put("titulo","Editar cliente");
		model.put("cliente", cliente);	
		return "form";
	}
	
	
	
	@RequestMapping (value="/form",method= RequestMethod.POST)
	public String guardar(@Valid Cliente cliente , BindingResult result,Model model,RedirectAttributes flash,SessionStatus status)
	{
		if (result.hasErrors())
		{
			model.addAttribute("titulo", "Formulario de clientes");
			return "form";
		}	
		String mensajeFlash=(cliente.getId() !=null)? "Cliente editado con éxito":"Cliente creado con éxito";
	
		
		clienteService.save(cliente);
		status.setComplete();
		flash.addFlashAttribute("success",mensajeFlash);
	
		return "redirect:listar";
		
	}
	
	@RequestMapping (value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id,RedirectAttributes flash)
	{
		
		if (id>0)
		{
			clienteService.delete(id);
			flash.addFlashAttribute("success","Cliente eliminado con exito!");
		}		
		return "redirect:/listar";
	}
	
}
