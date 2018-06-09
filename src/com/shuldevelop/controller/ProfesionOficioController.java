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
import com.shuldevelop.model.ProfesionOficio;
import com.shuldevelop.model.Usuario;
import com.shuldevelop.model.validator.ProfesionOficioValidator;
import com.shuldevelop.service.ModuloService;
import com.shuldevelop.service.ProfesionOficioService;
import com.shuldevelop.service.UsuarioService;

@Controller
public class ProfesionOficioController {
	@Autowired
	private ProfesionOficioService profesionService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ModuloService moduloService;
	
	private ProfesionOficioValidator profesionOficioValidator;
	
	public ProfesionOficioController() {
		this.profesionOficioValidator = new ProfesionOficioValidator();
	}
	
	public Usuario getUsuario() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		
		return usuarioService.findUserByUsername(userDetails.getUsername());
	}
	
	public List<Modulo> getModulos() {
		
		return moduloService.getAllModuloByRol(getUsuario().getRol().getId());
		
	}
	
	@RequestMapping(value = "/profesion-oficio/index", method = RequestMethod.GET)
	public ModelAndView profesionOficio() {
		
		ModelAndView mav = new ModelAndView();
		
		List<ProfesionOficio> listProfesionOficio= profesionService.getAllProfesionOficio();
		
		mav.setViewName("profesion_oficio/index");
		mav.addObject("profesionOficioList", listProfesionOficio);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
	@RequestMapping(value = "/profesion-oficio/add", method = RequestMethod.GET)
	public ModelAndView addProfesionOficio() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("profesion_oficio/add");
		mav.addObject("ProfesionOficio", new ProfesionOficio());
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
	@RequestMapping(value = "/profesion-oficio/add", method = RequestMethod.POST)
	public ModelAndView addProfesionOficio(
			@ModelAttribute("ProfesionOficio") ProfesionOficio u,
			BindingResult result,
			SessionStatus status,
			final RedirectAttributes redirectAttributes
 			) {
		
		this.profesionOficioValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("profesion_oficio/add");
			mav.addObject("ProfesionOficio", u);
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
			
			return mav;
		}
		
		profesionService.add(u);
		redirectAttributes.addFlashAttribute("messageSuccess", "La profesión u oficio se agregó exitosamente.");
		return new ModelAndView("redirect:/profesion-oficio/index.html");
	}
	
	@RequestMapping(value = "/profesion-oficio/edit", method = RequestMethod.GET)
	public ModelAndView editProfesionOficio(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		
		ProfesionOficio profesionOficio = profesionService.getProfesionOficio(id);
		
		mav.setViewName("profesion_oficio/edit");
		mav.addObject("ProfesionOficio", profesionOficio);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
	@RequestMapping(value = "/profesion-oficio/edit", method = RequestMethod.POST)
	public ModelAndView editProfesionOficio(
			@ModelAttribute("ProfesionOficio") ProfesionOficio u,
			BindingResult result,
			SessionStatus status,
			HttpServletRequest request,
			final RedirectAttributes redirectAttributes
 			) {
		
		this.profesionOficioValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("profesion_oficio/edit");
			mav.addObject("ProfesionOficio", u);
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
			
			return mav;
		}
		
		profesionService.edit(u);
		redirectAttributes.addFlashAttribute("messageSuccess", "La profesión u oficio se editó exitosamente.");
		return new ModelAndView("redirect:/profesion-oficio/index.html");
	}
	
	@RequestMapping(value = "/profesion-oficio/delete", method = RequestMethod.GET)
	public ModelAndView deleteProfesionOficio(HttpServletRequest request,
			final RedirectAttributes redirectAttributes) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		profesionService.delete(id);
		redirectAttributes.addFlashAttribute("messageSuccess", "La profesión u oficio se eliminó exitosamente.");
		return new ModelAndView("redirect:/profesion-oficio/index.html");
	}

}
