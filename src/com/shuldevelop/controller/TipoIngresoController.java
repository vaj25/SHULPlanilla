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
import com.shuldevelop.model.TipoIngreso;
import com.shuldevelop.model.Usuario;
import com.shuldevelop.model.validator.TipoIngresoValidator;
import com.shuldevelop.service.ModuloService;
import com.shuldevelop.service.TipoIngresoService;
import com.shuldevelop.service.UsuarioService;

@Controller
public class TipoIngresoController {

	@Autowired
	private TipoIngresoService tipoIngresoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ModuloService moduloService;
	
	private TipoIngresoValidator tipoIngresoValidator;
	
	public TipoIngresoController() {
		this.tipoIngresoValidator = new TipoIngresoValidator();
	}
	
	public Usuario getUsuario() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		
		return usuarioService.findUserByUsername(userDetails.getUsername());
	}
	
	public List<Modulo> getModulos() {
		
		return moduloService.getAllModuloByRol(getUsuario().getRol().getId());
		
	}
	
	@RequestMapping(value = "/tipo-ingreso/index", method = RequestMethod.GET)
	public ModelAndView tipoIngreso() {
		
		ModelAndView mav = new ModelAndView();
		
		List<TipoIngreso> listTipoIngreso = tipoIngresoService.getAllTipoIngreso();
		
		mav.setViewName("tipo_ingreso/index");
		mav.addObject("tipoIngresonList", listTipoIngreso);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
	@RequestMapping(value = "/tipo-ingreso/add", method = RequestMethod.GET)
	public ModelAndView addTipoIngreso() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("tipo_ingreso/add");
		mav.addObject("TipoIngreso", new TipoIngreso());
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
	@RequestMapping(value = "/tipo-ingreso/add", method = RequestMethod.POST)
	public ModelAndView addTipoIngreso(
			@ModelAttribute("TipoIngreso") TipoIngreso u,
			BindingResult result,
			SessionStatus status,
			final RedirectAttributes redirectAttributes
 			) {
		
		this.tipoIngresoValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("tipo_ingreso/add");
			mav.addObject("TipoIngreso", u);
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
			
			return mav;
		}
		
		tipoIngresoService.add(u);
		redirectAttributes.addFlashAttribute("messageSuccess", "El Tipo de Ingreso se agregó exitosamente.");
		return new ModelAndView("redirect:/tipo-ingreso/index.html");
	}
	
	@RequestMapping(value = "/tipo-ingreso/edit", method = RequestMethod.GET)
	public ModelAndView editTipoIngreso(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		
		TipoIngreso tipoIngreso = tipoIngresoService.getTipoIngreso(id);
		
		mav.setViewName("tipo_ingreso/edit");
		mav.addObject("TipoIngreso", tipoIngreso);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
	@RequestMapping(value = "/tipo-ingreso/edit", method = RequestMethod.POST)
	public ModelAndView editTipoIngreso(
			@ModelAttribute("TipoIngreso") TipoIngreso u,
			BindingResult result,
			SessionStatus status,
			HttpServletRequest request,
			final RedirectAttributes redirectAttributes
 			) {
		
		this.tipoIngresoValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
						
			mav.setViewName("tipo_ingreso/edit");
			mav.addObject("TipoIngreso", u);
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
			
			return mav;
		}
		
		tipoIngresoService.edit(u);
		redirectAttributes.addFlashAttribute("messageSuccess", "El Tipo de Ingreso se editó exitosamente.");
		return new ModelAndView("redirect:/tipo-ingreso/index.html");
	}
	
	@RequestMapping(value = "/tipo-ingreso/delete", method = RequestMethod.GET)
	public ModelAndView deleteTipoIngreso(HttpServletRequest request,
			final RedirectAttributes redirectAttributes) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		tipoIngresoService.delete(id);
		redirectAttributes.addFlashAttribute("messageSuccess", "El Tipo de Ingreso se eliminó exitosamente.");
		return new ModelAndView("redirect:/tipo-ingreso/index.html");
	}
	
}
