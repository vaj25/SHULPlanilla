package com.shuldevelop.controller;

import java.util.Hashtable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.shuldevelop.model.EmpleadoView;
import com.shuldevelop.model.Modulo;
import com.shuldevelop.model.Usuario;
import com.shuldevelop.service.EmpleadoService;
import com.shuldevelop.service.ModuloService;
import com.shuldevelop.service.UsuarioService;

@Controller
public class EmpleadoViewController {

	@Autowired
	private EmpleadoService empleadoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ModuloService moduloService;
	
	public Usuario getUsuario() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		
		return usuarioService.findUserByUsername(userDetails.getUsername());
	}
	
	public List<Modulo> getModulos() {
		
		return moduloService.getAllModuloByRol(getUsuario().getRol().getId());
		
	}
	
	@RequestMapping(value = "/empleados/index", method = RequestMethod.GET)
	public ModelAndView empleado() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("view_empleado/form");
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		return mav;
		
	}
	
	@RequestMapping(value = "/empleados/index", method = RequestMethod.POST)
	public ModelAndView empleado(
			SessionStatus status,
			HttpServletRequest request
			) {
		ModelAndView mav = new ModelAndView();
		
		String[] inputs = request.getParameterValues("input");
		
		Hashtable<String, String> parameter = new Hashtable<>(); 
		
		for (String string : inputs) {
						
			String[] input = string.split(",");
			
			String s = request.getParameter(input[0]);
			String t = request.getParameter(input[1]);
			
			parameter.put(s, t.replace(" ", ""));
			
		}
		
		List<EmpleadoView> list = empleadoService.getViewEmpleado(parameter);
		
		mav.setViewName("view_empleado/index");
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		mav.addObject("listEmpleado", list);
		return mav;
		
	}
		
}
