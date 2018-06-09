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
import com.shuldevelop.model.UnidadOrganizacional;
import com.shuldevelop.model.Usuario;
import com.shuldevelop.model.validator.UnidadOrganizacionalValidator;
import com.shuldevelop.service.ModuloService;
import com.shuldevelop.service.UnidadOrganizacionalService;
import com.shuldevelop.service.UsuarioService;

@Controller
public class UnidadOrganizacionalController {
	@Autowired
	private UnidadOrganizacionalService unidadOrganizacionalService;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private ModuloService moduloService;
	private UnidadOrganizacionalValidator unidadOrganizacionalValidator;
	
	public UnidadOrganizacionalController() {
		this.unidadOrganizacionalValidator = new UnidadOrganizacionalValidator();
	}
	
	public Usuario getUsuario() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		
		return usuarioService.findUserByUsername(userDetails.getUsername());
	}
	
	public List<Modulo> getModulos() {
		
		return moduloService.getAllModuloByRol(getUsuario().getRol().getId());
		
	}
	
	@RequestMapping(value = "/unidad-organizacional/index", method = RequestMethod.GET)
	public ModelAndView unidadOrganizacional() {
		ModelAndView mav = new ModelAndView();
		List<UnidadOrganizacional> listUnidadOrganizacional = unidadOrganizacionalService.getAllUnidadOrganizacional();
		mav.setViewName("unidad_organizacional/index");
		mav.addObject("unidadOrganizacionalList",listUnidadOrganizacional);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		return mav;
	}
	
	@RequestMapping(value = "/unidad-organizacional/add", method = RequestMethod.GET)
	public ModelAndView addUnidadOrganizacional() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("unidad_organizacional/add");
		mav.addObject("UnidadOrganizacional", new UnidadOrganizacional());
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		return mav;
	}
	
	@RequestMapping(value = "/unidad-organizacional/add", method = RequestMethod.POST)
	public ModelAndView addUnidadOrganizacional(@ModelAttribute("UnidadOrganizacional") UnidadOrganizacional u,
			BindingResult result,
			SessionStatus status,
			final RedirectAttributes redirectAttributes) {
		
		this.unidadOrganizacionalValidator.validate(u, result);
		if(result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("unidad_organizacional/add");
			mav.addObject("UnidadOrganizacional", u);
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
			
			return mav;
		}
		unidadOrganizacionalService.add(u);
		redirectAttributes.addFlashAttribute("messageSuccess", "La Unidad Organizacional se agregó exitosamente.");
		return new ModelAndView("redirect:/unidad-organizacional/index.html");
	}
	
	@RequestMapping(value = "/unidad-organizacional/edit", method = RequestMethod.GET)
	public ModelAndView editUnidadOrganizacional(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		UnidadOrganizacional unidadOrganizacional = unidadOrganizacionalService.getUnidadOrganizacional(id);
		mav.setViewName("unidad_organizacional/edit");
		mav.addObject("UnidadOrganizacional", unidadOrganizacional);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		return mav;
	}
	
	@RequestMapping(value = "/unidad-organizacional/edit", method = RequestMethod.POST)
	public ModelAndView editUnidadOrganizacional(
			@ModelAttribute("UnidadOrganizacional") UnidadOrganizacional u,
			BindingResult result,
			SessionStatus status,
			HttpServletRequest request,
			final RedirectAttributes redirectAttributes
			) {
		this.unidadOrganizacionalValidator.validate(u, result);
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("unidad_organizacional/edit");
			mav.addObject("UnidadOrganizacional", u);
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
			
			return mav;
		}
		unidadOrganizacionalService.edit(u);
		redirectAttributes.addFlashAttribute("messageSuccess", "La Unidad Organizacional se editó exitosamente.");
		return new ModelAndView("redirect:/unidad-organizacional/index.html");
	}
	
	@RequestMapping(value = "/unidad-organizacional/delete", method = RequestMethod.GET)
	public ModelAndView deleteUnidadOrganizacional(HttpServletRequest request,
			final RedirectAttributes redirectAttributes) {
		int id = Integer.parseInt(request.getParameter("id"));
		unidadOrganizacionalService.delete(id);
		redirectAttributes.addFlashAttribute("messageSuccess", "La Unidad Organizacional se eliminó exitosamente.");
		return new ModelAndView("redirect:/unidad-organizacional/index.html");
	}
	
		
	
}
