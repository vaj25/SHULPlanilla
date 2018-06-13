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
import com.shuldevelop.model.Municipio;
import com.shuldevelop.model.Usuario;
import com.shuldevelop.model.Zona;
import com.shuldevelop.model.validator.MunicipioValidator;
import com.shuldevelop.service.DepartamentoService;
import com.shuldevelop.service.ModuloService;
import com.shuldevelop.service.MunicipioService;
import com.shuldevelop.service.UsuarioService;

@Controller
public class MunicipioController {
	@Autowired
	private MunicipioService municipioService;
	
	@Autowired
	private DepartamentoService departamentoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ModuloService moduloService;
	
	private MunicipioValidator municipioValidator;
	
	private MunicipioController() {
		this.municipioValidator = new MunicipioValidator();
	}
	
	public Usuario getUsuario() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		
		return usuarioService.findUserByUsername(userDetails.getUsername());
	}
	
	public List<Modulo> getModulos() {
		
		return moduloService.getAllModuloByRol(getUsuario().getRol().getId());
		
	}
	
	
	@RequestMapping(value = "/municipio/index", method = RequestMethod.GET)
	public ModelAndView municipio() {
		ModelAndView mav = new ModelAndView();
		
		List<Municipio> listMunicipio = municipioService.getAllMunicipio();
		mav.setViewName("municipio/index");
		mav.addObject("municipioList", listMunicipio);
		
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
	@RequestMapping(value = "/municipio/add", method = RequestMethod.GET)
	public ModelAndView addMunicipio() {
		ModelAndView mav = new ModelAndView();
		List<Departamento> listDepartamento = departamentoService.getAllDepartamento();
		mav.setViewName("municipio/add");
		mav.addObject("Municipio", new Municipio());
		mav.addObject("departamentoList", listDepartamento);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
	@RequestMapping(value = "/municipio/add", method = RequestMethod.POST)
	public ModelAndView addMunicipio(
			@ModelAttribute("Municipio") Municipio u,
			BindingResult result,
			SessionStatus status,
			final RedirectAttributes redirectAttributes
			) {
		this.municipioValidator.validate(u, result);
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			List<Departamento> listDepartamento = departamentoService.getAllDepartamento();
			mav.setViewName("municipio/add");
			mav.addObject("Municipio", u);
			mav.addObject("departamentoList", listDepartamento);
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
			
			return mav;
		}
		municipioService.add(u);
		redirectAttributes.addFlashAttribute("messageSuccess", "La profesión u oficio se agregó exitosamente.");
		return new ModelAndView("redirect:/municipio/index.html");
		
	}
	
	@RequestMapping(value = "/municipio/edit", method = RequestMethod.GET)
	public ModelAndView editMunicipio(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		List<Departamento> listDepartamento = departamentoService.getAllDepartamento();
		Municipio municipio = municipioService.getMunicipio(id);
		mav.setViewName("municipio/edit");
		
		mav.addObject("Municipio", municipio);
		mav.addObject("departamentoList", listDepartamento);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
	@RequestMapping(value = "/municipio/edit", method = RequestMethod.POST)
	public ModelAndView editMunicipio(
			@ModelAttribute("Municipio") Municipio u,
			BindingResult result,
			SessionStatus status,
			final RedirectAttributes redirectAttributes
			) {
		this.municipioValidator.validate(u, result);
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			List<Departamento> listDepartamento = departamentoService.getAllDepartamento();
			mav.setViewName("municipio/edit");
			mav.addObject("Municipio", u);
			mav.addObject("departamentoList", listDepartamento);
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
			
			return mav;
		}
		municipioService.add(u);
		redirectAttributes.addFlashAttribute("messageSuccess", "La profesión u oficio se agregó exitosamente.");
		return new ModelAndView("redirect:/municipio/index.html");
		
	}
	
	@RequestMapping(value = "/municipio/delete", method = RequestMethod.GET)
	public ModelAndView deleteMunicipio(HttpServletRequest request,
			final RedirectAttributes redirectAttributes) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		municipioService.delete(id);
		redirectAttributes.addFlashAttribute("messageSuccess", "La profesión u oficio se eliminó exitosamente.");
		return new ModelAndView("redirect:/municipio/index.html");
	}
	
	
	
}
