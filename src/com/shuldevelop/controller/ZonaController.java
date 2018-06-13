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

import com.shuldevelop.model.Modulo;
import com.shuldevelop.model.Usuario;
import com.shuldevelop.model.Zona;
import com.shuldevelop.model.validator.ZonaValidator;
import com.shuldevelop.service.ModuloService;
import com.shuldevelop.service.UsuarioService;
import com.shuldevelop.service.ZonaService;

@Controller
public class ZonaController {
	@Autowired
	private ZonaService zonaService;
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ModuloService moduloService;
	
	private ZonaValidator zonaValidator;
	
	public ZonaController() {
		this.zonaValidator = new ZonaValidator();
	}
	
	public Usuario getUsuario() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		
		return usuarioService.findUserByUsername(userDetails.getUsername());
	}
	
	public List<Modulo> getModulos() {
		
		return moduloService.getAllModuloByRol(getUsuario().getRol().getId());
		
	}
	
	@RequestMapping(value = "/zona/index", method = RequestMethod.GET)
	public ModelAndView zona() {
		ModelAndView mav = new ModelAndView();
		List<Zona> listZona = zonaService.getAllZona();
		mav.setViewName("zona/index");
		mav.addObject("zonaList", listZona);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
	@RequestMapping(value = "/zona/add", method = RequestMethod.GET)
	public ModelAndView addZona() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("zona/add");
		mav.addObject("Zona", new Zona());
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
	@RequestMapping(value = "/zona/add", method = RequestMethod.POST)
	public ModelAndView addZona(
			@ModelAttribute("Zona") Zona u,
			BindingResult result,
			SessionStatus status,
			final RedirectAttributes redirectAttributes
			) {
		this.zonaValidator.validate(u, result);
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("zona/add");
			mav.addObject("Zona", u);
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
			
			return mav;
		}
		zonaService.add(u);
		redirectAttributes.addFlashAttribute("messageSuccess", "La profesión u oficio se agregó exitosamente.");
		return new ModelAndView("redirect:/zona/index.html");
	}
	
	@RequestMapping(value = "/zona/edit", method = RequestMethod.GET)
	public ModelAndView editZona(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		Zona zona = zonaService.getZona(id);
		mav.setViewName("zona/edit");
		mav.addObject("Zona", zona);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
	@RequestMapping(value = "/zona/edit", method = RequestMethod.POST)
	public ModelAndView editZona(
			@ModelAttribute("Zona") Zona u,
			BindingResult result,
			SessionStatus status,
			HttpServletRequest request,
			final RedirectAttributes redirectAttributes
			) {
		this.zonaValidator.validate(u, result);
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("zona/edit");
			mav.addObject("ProfesionOficio", u);
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
			
			return mav;
		}
		zonaService.edit(u);
		redirectAttributes.addFlashAttribute("messageSuccess", "La profesión u oficio se editó exitosamente.");
		return new ModelAndView("redirect:/zona/index.html");
		
	}
	
	@RequestMapping(value = "/zona/delete", method = RequestMethod.GET)
	public ModelAndView deleteZona(HttpServletRequest request,
			final RedirectAttributes redirectAttributes) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		zonaService.delete(id);
		redirectAttributes.addFlashAttribute("messageSuccess", "La profesión u oficio se eliminó exitosamente.");
		return new ModelAndView("redirect:/zona/index.html");
	}
}
