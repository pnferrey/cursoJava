package com.example.demo.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.di.models.service.IServiciable;

@Controller
public class IndexController {
 
	//@Qualifier("miServicioPrincipal")
	@Autowired
	private IServiciable servicio;
	


	@GetMapping(value={"/index","/","/home"})
	public String index(Model model)
	{
			model.addAttribute("objeto",servicio.operacion());
		return "index";
	}

}
