package com.example.demo.di.models.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component("miServicioPrincipal")	
//@Primary
public class MiServicio implements IServiciable {
	@Override
	public String operacion() 
	{
		return "ejecutando proceso importante simple...";
	}

	
	
}
