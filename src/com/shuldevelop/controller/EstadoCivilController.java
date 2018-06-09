package com.shuldevelop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shuldevelop.model.EstadoCivil;
import com.shuldevelop.model.Modulo;
import com.shuldevelop.model.Usuario;
import com.shuldevelop.model.validator.EstadoCivilValidator;
import com.shuldevelop.service.EstadoCivilService;
import com.shuldevelop.service.ModuloService;
import com.shuldevelop.service.UsuarioService;

@Controller
public class EstadoCivilController {
	
	@Autowired
	private EstadoCivilService estadoCivilService;

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ModuloService moduloService;
	
	private EstadoCivilValidator estadoCivilValidator;
		
	public EstadoCivilController() {
		this.estadoCivilValidator = new EstadoCivilValidator();
	}
	
	public Usuario getUsuario() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		
		return usuarioService.findUserByUsername(userDetails.getUsername());
	}
	
	public List<Modulo> getModulos() {
		
		return moduloService.getAllModuloByRol(getUsuario().getRol().getId());
		
	}

	@RequestMapping(value = "/estado-civil/index", method = RequestMethod.GET)
	public ModelAndView estadoCivil() {
		
		ModelAndView mav = new ModelAndView();
		
		List<EstadoCivil> listEstadoCivil = estadoCivilService.getAllEstadoCivil();
		
		mav.setViewName("estado_civil/index");
		mav.addObject("estadoCivilList", listEstadoCivil);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
	@RequestMapping(value = "/estado-civil/add", method = RequestMethod.GET)
	public ModelAndView addEstadoCivil() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("estado_civil/add");
		mav.addObject("EstadoCivil", new EstadoCivil());
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
	@RequestMapping(value = "/estado-civil/add", method = RequestMethod.POST)
	public ModelAndView addEstadoCivil(
			@ModelAttribute("EstadoCivil") EstadoCivil u,
			BindingResult result,
			SessionStatus status,
			final RedirectAttributes redirectAttributes
 			) {
		
		this.estadoCivilValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("estado_civil/add");
			mav.addObject("EstadoCivil", new EstadoCivil());
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
			
			return mav;
		}
		
		estadoCivilService.add(u);
		redirectAttributes.addFlashAttribute("messageSuccess", "El Estado Civil se agregó exitosamente.");
		return new ModelAndView("redirect:/estado-civil/index.html");
	}
	
	@RequestMapping(value = "/estado-civil/edit", method = RequestMethod.GET)
	public ModelAndView editEstadoCivil(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		
		EstadoCivil estadoCivil = estadoCivilService.getEstadoCivil(id);
		
		mav.setViewName("estado_civil/edit");
		mav.addObject("EstadoCivil", estadoCivil);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
	@RequestMapping(value = "/estado-civil/edit", method = RequestMethod.POST)
	public ModelAndView editEstadoCivil(
			@ModelAttribute("EstadoCivil") EstadoCivil u,
			BindingResult result,
			SessionStatus status,
			HttpServletRequest request,
			final RedirectAttributes redirectAttributes
 			) {
		
		this.estadoCivilValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			int id = Integer.parseInt(request.getParameter("id"));
			
			EstadoCivil estadoCivil = estadoCivilService.getEstadoCivil(id);
			
			mav.setViewName("estado_civil/edit");
			mav.addObject("EstadoCivil", estadoCivil);
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
			
			return mav;
		}
		
		estadoCivilService.edit(u);
		redirectAttributes.addFlashAttribute("messageSuccess", "El Estado Civil se editó exitosamente.");
		return new ModelAndView("redirect:/estado-civil/index.html");
	}
	
	@RequestMapping(value = "/estado-civil/delete", method = RequestMethod.GET)
	public ModelAndView deleteEstadoCivil(HttpServletRequest request,
			final RedirectAttributes redirectAttributes) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		estadoCivilService.delete(id);
		redirectAttributes.addFlashAttribute("messageSuccess", "El Estado Civil se eliminó exitosamente.");
		return new ModelAndView("redirect:/estado-civil/index.html");
	}
	
}
