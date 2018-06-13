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

import com.shuldevelop.model.Departamento;
import com.shuldevelop.model.Modulo;
import com.shuldevelop.model.Usuario;
import com.shuldevelop.model.Zona;
import com.shuldevelop.model.validator.DepartamentoValidator;
import com.shuldevelop.service.DepartamentoService;
import com.shuldevelop.service.ModuloService;
import com.shuldevelop.service.UsuarioService;
import com.shuldevelop.service.ZonaService;

@Controller
public class DepartamentoController {
	@Autowired
	private DepartamentoService departamentoService;
	
	@Autowired
	private ZonaService zonaService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ModuloService moduloService;
	
	private DepartamentoValidator departamentoValidator;
	
	private DepartamentoController() {
		this.departamentoValidator = new DepartamentoValidator();
	}
	
	public Usuario getUsuario() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		
		return usuarioService.findUserByUsername(userDetails.getUsername());
	}
	
	public List<Modulo> getModulos() {
		
		return moduloService.getAllModuloByRol(getUsuario().getRol().getId());
		
	}
	
	@RequestMapping(value = "/departamento/index", method = RequestMethod.GET)
	public ModelAndView departamento() {
		ModelAndView mav = new ModelAndView();
		
		List<Departamento> listDepartamento = departamentoService.getAllDepartamento();
		mav.setViewName("departamento/index");
		mav.addObject("departamentoList", listDepartamento);
		
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
	@RequestMapping(value = "/departamento/add", method = RequestMethod.GET)
	public ModelAndView addDepartamento() {
		ModelAndView mav = new ModelAndView();
		List<Zona> listZona = zonaService.getAllZona();
		mav.setViewName("departamento/add");
		mav.addObject("Departamento", new Departamento());
		mav.addObject("zonaList", listZona);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
	@RequestMapping(value = "/departamento/add", method = RequestMethod.POST)
	public ModelAndView addDepartamento(
			@ModelAttribute("Departamento") Departamento u,
			BindingResult result,
			SessionStatus status,
			final RedirectAttributes redirectAttributes
			) {
		this.departamentoValidator.validate(u, result);
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			List<Zona> listZona = zonaService.getAllZona();
			mav.setViewName("departamento/add");
			mav.addObject("Departamento", u);
			mav.addObject("zonaList", listZona);
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
			
			return mav;
		}
		departamentoService.add(u);
		redirectAttributes.addFlashAttribute("messageSuccess", "La profesión u oficio se agregó exitosamente.");
		return new ModelAndView("redirect:/departamento/index.html");
		
	}
	
	@RequestMapping(value = "/departamento/edit", method = RequestMethod.GET)
	public ModelAndView editDepartamento(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		List<Zona> listZona = zonaService.getAllZona();
		Departamento departamento = departamentoService.getDepartamento(id);
		mav.setViewName("departamento/edit");
		
		mav.addObject("Departamento", departamento);
		mav.addObject("zonaList", listZona);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	

	@RequestMapping(value = "/departamento/edit", method = RequestMethod.POST)
	public ModelAndView editDepartamento(
			@ModelAttribute("Departamento") Departamento u,
			BindingResult result,
			SessionStatus status,
			final RedirectAttributes redirectAttributes
			) {
		this.departamentoValidator.validate(u, result);
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			List<Zona> listZona = zonaService.getAllZona();
			mav.setViewName("departamento/edit");
			mav.addObject("Departamento", u);
			mav.addObject("zonaList", listZona);
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
			
			return mav;
		}
		departamentoService.edit(u);
		redirectAttributes.addFlashAttribute("messageSuccess", "La profesión u oficio se agregó exitosamente.");
		return new ModelAndView("redirect:/departamento/index.html");
		
	}
	
	
	@RequestMapping(value = "/departamento/delete", method = RequestMethod.GET)
	public ModelAndView deleteDepartamento(HttpServletRequest request,
			final RedirectAttributes redirectAttributes) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		departamentoService.delete(id);
		redirectAttributes.addFlashAttribute("messageSuccess", "La profesión u oficio se eliminó exitosamente.");
		return new ModelAndView("redirect:/departamento/index.html");
	}

	
}
	

