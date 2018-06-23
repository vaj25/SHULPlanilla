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
import com.shuldevelop.model.RangoComision;
import com.shuldevelop.model.TipoIngreso;
import com.shuldevelop.model.Usuario;
import com.shuldevelop.model.validator.RangoComisionValidator;
import com.shuldevelop.service.ModuloService;
import com.shuldevelop.service.RangoComisionService;
import com.shuldevelop.service.TipoIngresoService;
import com.shuldevelop.service.UsuarioService;

@Controller
public class RangoComisionController {

	@Autowired
	private RangoComisionService rangoComisionService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ModuloService moduloService;

	@Autowired
	private TipoIngresoService tipoIngresoService;
	
	
	private RangoComisionValidator rangoComisionValidator;
	
	public RangoComisionController() {
		this.rangoComisionValidator = new RangoComisionValidator();
	}

	public Usuario getUsuario() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		
		return usuarioService.findUserByUsername(userDetails.getUsername());
	}
	
	public List<Modulo> getModulos() {
		
		return moduloService.getAllModuloByRol(getUsuario().getRol().getId());
		
	}
	
	@RequestMapping(value = "/rango-comision/index", method = RequestMethod.GET)
	public ModelAndView rangoComision() {
		
		ModelAndView mav = new ModelAndView();
		
		List<RangoComision> listRangoComision = rangoComisionService.getAllRangoComision();
		List<TipoIngreso> listTipoIngreso = tipoIngresoService.getAllTipoIngreso();
		
		mav.setViewName("rango_comision/index");
		mav.addObject("rangoComisionList", listRangoComision);
		mav.addObject("tipoIngresoList", listTipoIngreso);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
	@RequestMapping(value = "/rango-comision/add", method = RequestMethod.GET)
	public ModelAndView addRangoComision() {
		
		ModelAndView mav = new ModelAndView();
		List<TipoIngreso> listTipoIngreso = tipoIngresoService.getAllTipoIngreso();

		
		mav.setViewName("rango_comision/add");
		mav.addObject("RangoComision", new RangoComision());
		mav.addObject("tipoIngresoList", listTipoIngreso);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
			
		return mav;
	}
	
	@RequestMapping(value = "/rango-comision/add", method = RequestMethod.POST)
	public ModelAndView addRangoComision(
			@ModelAttribute("RangoComision") RangoComision u,
			BindingResult result,
			SessionStatus status,
			final RedirectAttributes redirectAttributes
 			) {
		
		this.rangoComisionValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("rango_comision/add");
			mav.addObject("RangoComision", u);
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
			
			return mav;
		}
		
		rangoComisionService.add(u);
		redirectAttributes.addFlashAttribute("messageSuccess", "El Rango de la Comisión se agregó exitosamente.");
		return new ModelAndView("redirect:/rango-comision/index.html");
	}
	
	@RequestMapping(value = "/rango-comision/edit", method = RequestMethod.GET)
	public ModelAndView editRangoComision(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		
		RangoComision rangoComision = rangoComisionService.getRangoComision(id);
		List<TipoIngreso> listTipoIngreso = tipoIngresoService.getAllTipoIngreso();

		
		mav.setViewName("rango_comision/edit");
		mav.addObject("RangoComision", rangoComision);
		mav.addObject("tipoIngresoList", listTipoIngreso);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
	@RequestMapping(value = "/rango-comision/edit", method = RequestMethod.POST)
	public ModelAndView editRangoComision(
			@ModelAttribute("RangoComision") RangoComision u,
			BindingResult result,
			SessionStatus status,
			HttpServletRequest request,
			final RedirectAttributes redirectAttributes
 			) {
		
		this.rangoComisionValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			
			mav.setViewName("rango_comision/edit");
			mav.addObject("RangoComision", u);
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
			
			return mav;
		}
		
		rangoComisionService.edit(u);
		redirectAttributes.addFlashAttribute("messageSuccess", "El Rango de la Comisión se editó exitosamente.");
		return new ModelAndView("redirect:/rango-comision/index.html");
	}
	
	@RequestMapping(value = "/rango-comision/delete", method = RequestMethod.GET)
	public ModelAndView deleteRangoComision(HttpServletRequest request,
			final RedirectAttributes redirectAttributes) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		rangoComisionService.delete(id);
		redirectAttributes.addFlashAttribute("messageSuccess", "El Rango de la Comisión se eliminó exitosamente.");
		return new ModelAndView("redirect:/rango-comision/index.html");
	}
	
}
