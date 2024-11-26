package com.example.demo.di;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.example.demo.di.models.domain.ItemFactura;
import com.example.demo.di.models.domain.Producto;
import com.example.demo.di.models.service.IServiciable;
import com.example.demo.di.models.service.MiServicio;
import com.example.demo.di.models.service.MiServicioComplejo;

@Configuration
public class AppConfig {
	@Bean("miServicioSimple")
	public IServiciable registrarMiServicio(){
		return new MiServicio();
	}
	@Bean("miServicioComplejo")
	@Primary	
	public IServiciable registrarMiServicioConmplejo(){
		return new MiServicioComplejo();
	}
	
	@Bean("itemsFactura")		
	public  List<ItemFactura> registrarItems(){
		Producto producto1 = new Producto("Camara prueba",100);
		Producto producto2 = new Producto("Bici",200);
		
		ItemFactura linea1=new ItemFactura(producto1,2);
		ItemFactura linea2=new ItemFactura(producto2,4);
		
		return Arrays.asList(linea1,linea2);
		
	}
	
	@Bean("itemsFacturaOficina")	
	@Primary
	public  List<ItemFactura> registrarItemsOficina(){
		Producto producto1 = new Producto("Monitor",250);
		Producto producto2 = new Producto("silla",200);
		Producto producto3 = new Producto("impresora",500);
		Producto producto4 = new Producto("portatil",600);
		
		ItemFactura linea1=new ItemFactura(producto1,2);
		ItemFactura linea2=new ItemFactura(producto2,4);
		ItemFactura linea3=new ItemFactura(producto1,1);
		ItemFactura linea4=new ItemFactura(producto2,1);
		
		return Arrays.asList(linea1,linea2,linea3,linea4);
		
	}
}
