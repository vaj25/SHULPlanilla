package com.shuldevelop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shuldevelop.model.Usuario;
import com.shuldevelop.service.UsuarioService;

@Controller
public class WelcomeController {

	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value= {"/", "/welcome"})
	public ModelAndView home() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		
		Usuario usuario = usuarioService.findUserByUsername(userDetails.getUsername()); 
		
		return new ModelAndView("welcome").addObject("Usuario", usuario);
		
	}
	
}
