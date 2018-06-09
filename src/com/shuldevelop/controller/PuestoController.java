
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
import com.shuldevelop.model.NivelPuesto;
import com.shuldevelop.model.Puesto;
import com.shuldevelop.model.Usuario;
import com.shuldevelop.model.validator.PuestoValidator;
import com.shuldevelop.service.ModuloService;
import com.shuldevelop.service.NivelPuestoService;
import com.shuldevelop.service.PuestoService;
import com.shuldevelop.service.UsuarioService;

@Controller
public class PuestoController {

	@Autowired
	private PuestoService puestoService;
	
	@Autowired
	private NivelPuestoService nivelPuestoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ModuloService moduloService;
	
	private PuestoValidator puestoValidator;

	public PuestoController() {
		puestoValidator = new PuestoValidator();
	}
	
	public Usuario getUsuario() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		
		return usuarioService.findUserByUsername(userDetails.getUsername());
	}
	
	public List<Modulo> getModulos() {
		
		return moduloService.getAllModuloByRol(getUsuario().getRol().getId());
		
	}
	
	@RequestMapping(value = "/puesto/index", method = RequestMethod.GET)
	public ModelAndView puesto() {
		
		ModelAndView mav = new ModelAndView();
		
		List<Puesto> listPuesto = puestoService.getAllPuesto();
		
		mav.setViewName("puesto/index");
		mav.addObject("puestoList", listPuesto);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
	@RequestMapping(value = "/puesto/add", method = RequestMethod.GET)
	public ModelAndView addPuesto() {
		
		ModelAndView mav = new ModelAndView();
		
		List<NivelPuesto> listTipoPuesto = nivelPuestoService.getAllTipoPuesto();
		
		mav.setViewName("puesto/add");
		mav.addObject("Puesto", new Puesto());
		mav.addObject("tipoPuestoList", listTipoPuesto);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		
		return mav;
	}
	
	@RequestMapping(value = "/puesto/add", method = RequestMethod.POST)
	public ModelAndView addPuesto(
			@ModelAttribute("Puesto") Puesto u,
			BindingResult result,
			SessionStatus status,
			final RedirectAttributes redirectAttributes
 			) {
		
		this.puestoValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			List<NivelPuesto> listTipoPuesto = nivelPuestoService.getAllTipoPuesto();
			
			mav.setViewName("puesto/add");
			mav.addObject("Puesto", u);
			mav.addObject("tipoPuestoList", listTipoPuesto);
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
			
			
			return mav;
		}
		
		u.getNivelPuesto().setSalarioMinimo(nivelPuestoService.getTipoPuesto(
				u.getNivelPuesto().getId()).getSalarioMinimo());
		u.getNivelPuesto().setSalarioMaximo(nivelPuestoService.getTipoPuesto(
				u.getNivelPuesto().getId()).getSalarioMaximo());
		u.getNivelPuesto().setNumeroNivel(nivelPuestoService.getTipoPuesto(
				u.getNivelPuesto().getId()).getNumeroNivel());
		
		puestoService.add(u);
		
		redirectAttributes.addFlashAttribute("messageSuccess", "El puesto ha sido agregado exitosamente.");
		
		return new ModelAndView("redirect:/puesto/index.html");
	}
	
	@RequestMapping(value = "/puesto/edit", method = RequestMethod.GET)
	public ModelAndView editPuesto(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		
		Puesto puesto = puestoService.getPuesto(id);
		
		List<NivelPuesto> listTipoPuesto = nivelPuestoService.getAllTipoPuesto();
		
		mav.setViewName("puesto/edit");
		mav.addObject("Puesto", puesto);
		mav.addObject("tipoPuestoList", listTipoPuesto);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
	@RequestMapping(value = "/puesto/edit", method = RequestMethod.POST)
	public ModelAndView editPuesto(
			@ModelAttribute("Puesto") Puesto u,
			BindingResult result,
			SessionStatus status,
			HttpServletRequest request,
			final RedirectAttributes redirectAttributes
 			) {
		
		this.puestoValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			List<NivelPuesto> listTipoPuesto = nivelPuestoService.getAllTipoPuesto();
			
			mav.setViewName("nivel_puesto/edit");
			mav.addObject("Puesto", u);
			mav.addObject("tipoPuestoList", listTipoPuesto);
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
			
			return mav;
		}
		
		redirectAttributes.addFlashAttribute("messageSuccess", "El puesto ha sido editado exitosamente.");
		
		puestoService.edit(u);
		redirectAttributes.addFlashAttribute("messageSuccess", "El Puesto se editó exitosamente.");
		return new ModelAndView("redirect:/puesto/index.html");
	}
	
	@RequestMapping(value = "/puesto/delete", method = RequestMethod.GET)
	public ModelAndView deletePuesto(
			HttpServletRequest request,
			final RedirectAttributes redirectAttributes
			) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			
			puestoService.delete(id);
			redirectAttributes.addFlashAttribute("messageSuccess", "El puesto ha sido eliminado exitosamente.");
			
		} catch (Exception e) {
						
			redirectAttributes.addFlashAttribute("messageError", "El puesto posee dependencia no se puede eliminar.");
			
		}
				
		return new ModelAndView("redirect:/puesto/index.html");
	}
	
	
}
