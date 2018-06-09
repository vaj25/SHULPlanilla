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
import com.shuldevelop.model.NivelEstructura;
import com.shuldevelop.model.Usuario;
import com.shuldevelop.model.validator.NivelEstructuraValidator;
import com.shuldevelop.service.ModuloService;
import com.shuldevelop.service.NivelEstructuraService;
import com.shuldevelop.service.UsuarioService;

@Controller
public class NivelEstructuraController {
	@Autowired
	private NivelEstructuraService nivelEstructuraService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ModuloService moduloService;
	
	private NivelEstructuraValidator nivelEstructuraValidator;
	
	public NivelEstructuraController() {
		this.nivelEstructuraValidator = new NivelEstructuraValidator();
	}
	
	public Usuario getUsuario() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		
		return usuarioService.findUserByUsername(userDetails.getUsername());
	}
	
	public List<Modulo> getModulos() {
		
		return moduloService.getAllModuloByRol(getUsuario().getRol().getId());
		
	}
	
	@RequestMapping(value = "/nivel-estructura/index", method = RequestMethod.GET)
	public ModelAndView nivelEstructura() {
		ModelAndView mav  = new ModelAndView();
		
		List<NivelEstructura> listNivelEstructura = nivelEstructuraService.getAllNivelEstructura();
		
		mav.setViewName("nivel_estructura/index");
		mav.addObject("nivelEstructuraList", listNivelEstructura);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		return mav;
	}
	
	
	@RequestMapping(value = "/nivel-estructura/add", method = RequestMethod.GET)
	public ModelAndView addNivelEstructura() {
		ModelAndView mav  = new ModelAndView();
		
		mav.setViewName("nivel_estructura/add");
		mav.addObject("NivelEstructura", new NivelEstructura());
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		return mav;
	}
	
	@RequestMapping(value = "/nivel-estructura/add", method = RequestMethod.POST)
	public ModelAndView addNivelEstructura(
			@ModelAttribute("NivelEstructura") NivelEstructura u,
			BindingResult result,
			SessionStatus status,
			final RedirectAttributes redirectAttributes
			) {
		
		this.nivelEstructuraValidator.validate(u,result);
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("nivel_estructura/add");
			mav.addObject("NivelEstructura", u);
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
			
			return mav;
		}
		
		nivelEstructuraService.add(u);
		redirectAttributes.addFlashAttribute("messageSuccess", "El Nivel de la Estructura se agregó exitosamente.");
		return new ModelAndView("redirect:/nivel-estructura/index.html");
	}
	
	@RequestMapping(value = "/nivel-estructura/edit", method = RequestMethod.GET)
		public ModelAndView editNivelEstructura(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		
		NivelEstructura nivelEstructura = nivelEstructuraService.getNivelEstructura(id);
		mav.setViewName("nivel_estructura/edit");
		mav.addObject("NivelEstructura", nivelEstructura);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
	@RequestMapping(value = "/nivel-estructura/edit", method = RequestMethod.POST)
	public ModelAndView editNivelEstructura(
			@ModelAttribute("NivelEstructura") NivelEstructura u,
			BindingResult result,
			SessionStatus status,
			HttpServletRequest request,
			final RedirectAttributes redirectAttributes
			) {
		
		this.nivelEstructuraValidator.validate(u,result);
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("nivel_estructura/edit");
			mav.addObject("NivelEstructura", u);
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
			
			return mav;
		}
		nivelEstructuraService.edit(u);
		redirectAttributes.addFlashAttribute("messageSuccess", "El Nivel de la Estructura se editó exitosamente.");
		return new ModelAndView("redirect:/nivel-estructura/index.html");
	}
	
	@RequestMapping(value = "/nivel-estructura/delete", method = RequestMethod.GET)
	public ModelAndView deleteNivelEstructura(HttpServletRequest request,
			final RedirectAttributes redirectAttributes) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		nivelEstructuraService.delete(id);
		redirectAttributes.addFlashAttribute("messageSuccess", "El Nivel de la Estructura se eliminó exitosamente.");
		return new ModelAndView("redirect:/nivel-estructura/index.html");
	}
	
	
}
