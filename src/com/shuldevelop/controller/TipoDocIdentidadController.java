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
import com.shuldevelop.model.TipoDocIdentidad;
import com.shuldevelop.model.Usuario;
import com.shuldevelop.model.validator.TipoDocIdentidadValidator;
import com.shuldevelop.service.ModuloService;
import com.shuldevelop.service.TipoDocIdentidadService;
import com.shuldevelop.service.UsuarioService;

@Controller
public class TipoDocIdentidadController {
	
	@Autowired
	private TipoDocIdentidadService tipoDocIdentidadService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ModuloService moduloService;
	
	private TipoDocIdentidadValidator tipoDocIdentidadValidator;
		
	public TipoDocIdentidadController() {
		this.tipoDocIdentidadValidator = new TipoDocIdentidadValidator();
	}
	
	public Usuario getUsuario() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		
		return usuarioService.findUserByUsername(userDetails.getUsername());
	}
	
	public List<Modulo> getModulos() {
		
		return moduloService.getAllModuloByRol(getUsuario().getRol().getId());
		
	}

	@RequestMapping(value = "/tipo-doc-identidad/index", method = RequestMethod.GET)
	public ModelAndView tipoDocIdentidad() {
		
		ModelAndView mav = new ModelAndView();
		
		List<TipoDocIdentidad> listTipoDocIdentidad = tipoDocIdentidadService.getAllTipoDocIdentidad();
		
		mav.setViewName("tipo_doc_identidad/index");
		mav.addObject("tipoDocIdentidadList", listTipoDocIdentidad);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
	@RequestMapping(value = "/tipo-doc-identidad/add", method = RequestMethod.GET)
	public ModelAndView addTipoDocIdentidad() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("tipo_doc_identidad/add");
		mav.addObject("TipoDocIdentidad", new TipoDocIdentidad());
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
	@RequestMapping(value = "/tipo-doc-identidad/add", method = RequestMethod.POST)
	public ModelAndView addTipoDocIdentidad(
			@ModelAttribute("TipoDocIdentidad") TipoDocIdentidad u,
			BindingResult result,
			SessionStatus status,
			final RedirectAttributes redirectAttributes
 			) {
		
		this.tipoDocIdentidadValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("tipo_doc_identidad/add");
			mav.addObject("TipoDocIdentidad", u);
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
			
			return mav;
		}
		
		tipoDocIdentidadService.add(u);
		redirectAttributes.addFlashAttribute("messageSuccess", "El Tipo de Documento de Identidad se agregó exitosamente.");
		return new ModelAndView("redirect:/tipo-doc-identidad/index.html");
	}
	
	@RequestMapping(value = "/tipo-doc-identidad/edit", method = RequestMethod.GET)
	public ModelAndView editTipoDocIdentidad(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		
		TipoDocIdentidad tipoDocIdentidad = tipoDocIdentidadService.getTipoDocIdentidad(id);
		
		mav.setViewName("tipo_doc_identidad/edit");
		mav.addObject("TipoDocIdentidad", tipoDocIdentidad);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
	@RequestMapping(value = "/tipo-doc-identidad/edit", method = RequestMethod.POST)
	public ModelAndView editTipoDocIdentidad(
			@ModelAttribute("TipoDocIdentidad") TipoDocIdentidad u,
			BindingResult result,
			SessionStatus status,
			HttpServletRequest request,
			final RedirectAttributes redirectAttributes
 			) {
		
		this.tipoDocIdentidadValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("tipo_doc_identidad/edit");
			mav.addObject("TipoDocIdentidad", u);
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
			
			return mav;
		}
		
		tipoDocIdentidadService.edit(u);
		redirectAttributes.addFlashAttribute("messageSuccess", "El Tipo de Documento de Identidad se editó exitosamente.");		
		return new ModelAndView("redirect:/tipo-doc-identidad/index.html");
	}
	
	@RequestMapping(value = "/tipo-doc-identidad/delete", method = RequestMethod.GET)
	public ModelAndView deleteTipoDocIdentidad(HttpServletRequest request,
			final RedirectAttributes redirectAttributes) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		tipoDocIdentidadService.delete(id);
		redirectAttributes.addFlashAttribute("messageSuccess", "El Tipo de Documento de Identidad se eliminó exitosamente.");
		return new ModelAndView("redirect:/tipo-doc-identidad/index.html");
	}
	
}
