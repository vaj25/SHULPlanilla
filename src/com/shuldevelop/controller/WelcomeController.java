package com.shuldevelop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shuldevelop.model.Modulo;
import com.shuldevelop.model.Usuario;
import com.shuldevelop.service.ModuloService;
import com.shuldevelop.service.UsuarioService;

@Controller
public class WelcomeController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ModuloService moduloService;
	
	@RequestMapping(value= {"/", "/welcome"})
	public ModelAndView home() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		
		Usuario usuario = usuarioService.findUserByUsername(userDetails.getUsername()); 
		
		List<Modulo> moduloList = moduloService.getAllModuloByRol(usuario.getRol().getId()); 
		
		ModelAndView mav = new ModelAndView("welcome");
		mav.addObject("Usuario", usuario);
		mav.addObject("modulos", moduloList);
		
		return mav;
		
	}
	
}
