package com.example.demo.form.app.interceptors;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("tiempoTranscurridoInterceptor")
public class TiempoTranscurridoInterceptor implements HandlerInterceptor{
	private static final Logger logger= LoggerFactory.getLogger(TiempoTranscurridoInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		logger.info("TiempoTranscurridoInterceptor: preHandle() entrando...");
		long tiempoInicio=System.currentTimeMillis();
		request.setAttribute("tiempoInicio", tiempoInicio);
		
		Random rendom = new Random();
		Integer demora=rendom.nextInt(500);
		Thread.sleep(demora);
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		long tiempoFin=System.currentTimeMillis();
		long tiempoInicio= (Long) request.getAttribute("tiempoInicio");
		long tiempoTranscurrido = tiempoFin-tiempoInicio;
		
		if (modelAndView !=null)
		{
			modelAndView.addObject("tiempoTranscurrido",tiempoTranscurrido);
		}
		logger.info("TiempoTranscurrido: postHandle() entrando..."+tiempoTranscurrido);
		logger.info("TiempoTranscurrido: postHandle() saliendo...");
		return;
	}

}
