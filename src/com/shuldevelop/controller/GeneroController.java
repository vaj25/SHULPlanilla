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

import com.shuldevelop.model.Genero;
import com.shuldevelop.model.Modulo;
import com.shuldevelop.model.Usuario;
import com.shuldevelop.model.validator.GeneroValidator;
import com.shuldevelop.service.GeneroService;
import com.shuldevelop.service.ModuloService;
import com.shuldevelop.service.UsuarioService;

@Controller
public class GeneroController {
	
	@Autowired
	private GeneroService generoService;
	
	private  GeneroValidator generoValidator;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ModuloService moduloService;
		
	public  GeneroController() {
		this.generoValidator = new  GeneroValidator();
	}
	
	public Usuario getUsuario() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		
		return usuarioService.findUserByUsername(userDetails.getUsername());
	}
	
	public List<Modulo> getModulos() {
		
		return moduloService.getAllModuloByRol(getUsuario().getRol().getId());
		
	}
	
	@RequestMapping(value = "/genero/index", method = RequestMethod.GET)
	public ModelAndView genero() {
		
		ModelAndView mav = new ModelAndView();
		
		List<Genero> listGenero= generoService.getAllGenero();
		
		mav.setViewName("genero/index");
		mav.addObject("generoList", listGenero);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}

	@RequestMapping(value = "/genero/add", method = RequestMethod.GET)
	public ModelAndView addGenero() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("genero/add");
		mav.addObject("Genero", new Genero());
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
	@RequestMapping(value = "/genero/add", method = RequestMethod.POST)
	public ModelAndView addGenero(
			@ModelAttribute("Genero") Genero u,
			BindingResult result,
			SessionStatus status,
			final RedirectAttributes redirectAttributes
 			) {
		
		this.generoValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("genero/add");
			mav.addObject("Genero", u);
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
			
			return mav;
		}
		
		generoService.add(u);
		redirectAttributes.addFlashAttribute("messageSuccess", "El Genero se agregó exitosamente.");
		return new ModelAndView("redirect:/genero/index.html");
	}
	
	@RequestMapping(value = "/genero/edit", method = RequestMethod.GET)
	public ModelAndView editGenero(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		
		Genero genero = generoService.getGenero(id);
		
		mav.setViewName("genero/edit");
		mav.addObject("Genero", genero);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
	@RequestMapping(value = "/genero/edit", method = RequestMethod.POST)
	public ModelAndView editGenero(
			@ModelAttribute("Genero") Genero u,
			BindingResult result,
			SessionStatus status,
			HttpServletRequest request,
			final RedirectAttributes redirectAttributes
 			) {
		
		this.generoValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("genero/edit");
			mav.addObject("Genero", u);
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
			
			return mav;
		}
		
		generoService.edit(u);
		redirectAttributes.addFlashAttribute("messageSuccess", "El Genero se editó exitosamente.");
		return new ModelAndView("redirect:/genero/index.html");
	}
	
	
	@RequestMapping(value = "/genero/delete", method = RequestMethod.GET)
	public ModelAndView deleteGenero(HttpServletRequest request,
			final RedirectAttributes redirectAttributes) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		generoService.delete(id);
		redirectAttributes.addFlashAttribute("messageSuccess", "El Genero se eliminó exitosamente.");
		return new ModelAndView("redirect:/genero/index.html");
	}
	
	
}
