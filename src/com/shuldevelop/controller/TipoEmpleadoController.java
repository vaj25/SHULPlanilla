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

import com.shuldevelop.model.TipoEmpleado;
import com.shuldevelop.model.Genero;
import com.shuldevelop.model.Modulo;
import com.shuldevelop.model.NivelPuesto;
import com.shuldevelop.model.Usuario;
import com.shuldevelop.model.validator.TipoEmpleadoValidator;
import com.shuldevelop.service.TipoEmpleadoService;
import com.shuldevelop.service.ModuloService;
import com.shuldevelop.service.UsuarioService;

@Controller
public class TipoEmpleadoController {

	@Autowired
	private TipoEmpleadoService tipoEmpleadoService;
	
	private TipoEmpleadoValidator tipoEmpleadoValidator;

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ModuloService moduloService;

	public  TipoEmpleadoController() {
		this.tipoEmpleadoValidator = new  TipoEmpleadoValidator();
	}	
	
	public Usuario getUsuario() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		
		return usuarioService.findUserByUsername(userDetails.getUsername());
	}
	
	public List<Modulo> getModulos() {
		
		return moduloService.getAllModuloByRol(getUsuario().getRol().getId());
		
	}	
	
	
	@RequestMapping(value = "/tipo-empleado/index", method = RequestMethod.GET)
	public ModelAndView tipoEmpleado() {
		
		ModelAndView mav = new ModelAndView();
		
		List<TipoEmpleado> listTipoEmpleado= tipoEmpleadoService.getAllTipoEmpleado();
		
		mav.setViewName("tipo_empleado/index");
		mav.addObject("tipoEmpleadoList", listTipoEmpleado);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	@RequestMapping(value = "/tipo-empleado/add", method = RequestMethod.GET)
	public ModelAndView addTipoEmpleado() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("tipo_empleado/add");
		mav.addObject("TipoEmpleado", new TipoEmpleado());
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
	@RequestMapping(value = "/tipo-empleado/add", method = RequestMethod.POST)
	public ModelAndView addTipoEmpleado(
			@ModelAttribute("TipoEmpleado") TipoEmpleado u,
			BindingResult result,
			SessionStatus status,
			final RedirectAttributes redirectAttributes
 			) {
		
		this.tipoEmpleadoValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("tipo_empleado/add");
			mav.addObject("TipoEmpleado", u);
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
			
			return mav;
		}
		
		tipoEmpleadoService.add(u);
		redirectAttributes.addFlashAttribute("messageSuccess", "El Tipo de Empleado se agregó exitosamente.");
		return new ModelAndView("redirect:/tipo-empleado/index.html");
	}
	
	@RequestMapping(value = "/tipo-empleado/edit", method = RequestMethod.GET)
	public ModelAndView editTipoEmpleado(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		
		TipoEmpleado tipoEmpleado = tipoEmpleadoService.getTipoEmpleado(id);
		
		mav.setViewName("tipo_empleado/edit");
		mav.addObject("TipoEmpleado", tipoEmpleado);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
	@RequestMapping(value = "/tipo-empleado/edit", method = RequestMethod.POST)
	public ModelAndView editTipoEmpleado(
			@ModelAttribute("TipoEmpleado") TipoEmpleado u,
			BindingResult result,
			SessionStatus status,
			HttpServletRequest request,
			final RedirectAttributes redirectAttributes
 			) {
		
		this.tipoEmpleadoValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("tipo_empleado/edit");
			mav.addObject("TipoEmpleado", u);
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
			
			return mav;
		}
		
		tipoEmpleadoService.edit(u);
		redirectAttributes.addFlashAttribute("messageSuccess", "El Tipo Empleado se editó exitosamente.");
		return new ModelAndView("redirect:/tipo-empleado/index.html");
	}
	
	@RequestMapping(value = "/tipo-empleado/delete", method = RequestMethod.GET)
	public ModelAndView deleteTipoEmpleado(
			HttpServletRequest request,
			final RedirectAttributes redirectAttributes) {
		
			int id = Integer.parseInt(request.getParameter("id"));
			
			tipoEmpleadoService.delete(id);
			redirectAttributes.addFlashAttribute("messageSuccess", "El Tipo Empleado se eliminó exitosamente.");
			return new ModelAndView("redirect:/tipo-empleado/index.html");
	}
	
}
