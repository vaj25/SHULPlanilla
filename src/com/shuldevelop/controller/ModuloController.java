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
import com.shuldevelop.model.validator.ModuloValidator;
import com.shuldevelop.service.ModuloService;
import com.shuldevelop.service.UsuarioService;

@Controller
public class ModuloController {

	@Autowired
	private ModuloService moduloService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	private ModuloValidator moduloValidator;
	
	public ModuloController() {
		this.moduloValidator = new ModuloValidator();
	}
	
	public Usuario getUsuario() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		
		return usuarioService.findUserByUsername(userDetails.getUsername());
	}
	
	public List<Modulo> getModulos() {
		
		return moduloService.getAllModuloByRol(getUsuario().getRol().getId());
		
	}

	@RequestMapping(value = "/modulo/index", method = RequestMethod.GET)
	public ModelAndView modulo() {
		
		ModelAndView mav = new ModelAndView();
		
		List<Modulo> listModulo = moduloService.getAllModulo();
		
		mav.setViewName("modulo/index");
		mav.addObject("moduloList", listModulo);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
	@RequestMapping(value = "/modulo/add", method = RequestMethod.GET)
	public ModelAndView addModulo() {
		
		ModelAndView mav = new ModelAndView();
		
		List<Modulo> listModulo = moduloService.getAllModuloParent();
		
		mav.setViewName("modulo/add");
		mav.addObject("Modulo", new Modulo());
		mav.addObject("moduloList", listModulo);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
	@RequestMapping(value = "/modulo/add", method = RequestMethod.POST)
	public ModelAndView addModulo(
			@ModelAttribute("Modulo") Modulo u,
			BindingResult result,
			SessionStatus status,
			final RedirectAttributes redirectAttributes
 			) {
		
		this.moduloValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			List<Modulo> listModulo = moduloService.getAllModuloParent();
			
			mav.setViewName("modulo/add");
			mav.addObject("Modulo", u);
			mav.addObject("moduloList", listModulo);
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
			
			return mav;
		}
		
		u.setDependencia( moduloService.getModulo( u.getDependencia().getId() ) );
		
		moduloService.add(u);
		
		redirectAttributes.addFlashAttribute("messageSuccess", "El modulo ha sido agregado exitosamente.");
		
		return new ModelAndView("redirect:/modulo/index.html");
	}
	
	@RequestMapping(value = "/modulo/edit", method = RequestMethod.GET)
	public ModelAndView editModulo(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		
		Modulo modulo = moduloService.getModulo(id);
		
		List<Modulo> listModulo = moduloService.getAllModuloParent();
		
		mav.setViewName("modulo/edit");
		mav.addObject("Modulo", modulo);
		mav.addObject("moduloList", listModulo);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
	@RequestMapping(value = "/modulo/edit", method = RequestMethod.POST)
	public ModelAndView editModulo(
			@ModelAttribute("Modulo") Modulo u,
			BindingResult result,
			SessionStatus status,
			HttpServletRequest request,
			final RedirectAttributes redirectAttributes
 			) {
		
		this.moduloValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			List<Modulo> listModulo = moduloService.getAllModuloParent();
			
			mav.setViewName("modulo/edit");
			mav.addObject("Modulo", u);
			mav.addObject("moduloList", listModulo);
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
			
			return mav;
		}
		
		u.setDependencia( moduloService.getModulo( u.getDependencia().getId() ) );
		
		moduloService.edit(u);
		
		redirectAttributes.addFlashAttribute("messageSuccess", "El modulo ha sido editado exitosamente.");
		
		return new ModelAndView("redirect:/modulo/index.html");
	}
	
	@RequestMapping(value = "/modulo/delete", method = RequestMethod.GET)
	public ModelAndView deletePuesto(
			HttpServletRequest request,
			final RedirectAttributes redirectAttributes) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Modulo modulo = moduloService.getModulo(id);
		
		if ( modulo.getModulos().size() > 0 || moduloService.hasModuloRolPermiso( modulo.getId() )) {
			
			redirectAttributes.addFlashAttribute("messageError", "El modulo posee dependencia no se puede eliminar.");
			
		} else {
			
			moduloService.delete(id);
			redirectAttributes.addFlashAttribute("messageSuccess", "El modulo ha sido eliminado exitosamente.");
			
		}
		
		return new ModelAndView("redirect:/modulo/index.html");
	}
	
}
