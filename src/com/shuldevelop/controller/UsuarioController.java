package com.shuldevelop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shuldevelop.model.Modulo;
import com.shuldevelop.model.Rol;
import com.shuldevelop.model.Usuario;
import com.shuldevelop.model.validator.UsuarioValidator;
import com.shuldevelop.service.ModuloService;
import com.shuldevelop.service.RolService;
import com.shuldevelop.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private RolService rolService;
	
	@Autowired
	private ModuloService moduloService;
	
	private UsuarioValidator usuarioValidator;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UsuarioController() {
		this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
		this.usuarioValidator = new UsuarioValidator();
	}

	public Usuario getUsuario() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		
		return usuarioService.findUserByUsername(userDetails.getUsername());
	}
	
	public List<Modulo> getModulos() {
		
		return moduloService.getAllModuloByRol(getUsuario().getRol().getId());
		
	}

	@RequestMapping(value = "/usuario/index", method = RequestMethod.GET)
	public ModelAndView usuario() {
		
		ModelAndView mav = new ModelAndView();
		
		List<Usuario> ListUsuario = usuarioService.getAllUsuario();
		
		mav.setViewName("usuario/index");
		mav.addObject("usuarioList", ListUsuario);
		mav.addObject("user", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
	@RequestMapping(value = "/usuario/add", method = RequestMethod.GET)
	public ModelAndView addUsuario() {
		
		ModelAndView mav = new ModelAndView();
		
		List<Rol> ListRol = rolService.getAllRol();
		
		mav.setViewName("usuario/add");
		mav.addObject("Usuario", new Usuario());
		mav.addObject("rolList", ListRol);
		mav.addObject("user", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
	@RequestMapping(value = "/usuario/add", method = RequestMethod.POST)
	public ModelAndView addUsuario(
			@ModelAttribute("Usuario") Usuario u,
			BindingResult result,
			SessionStatus status,
			final RedirectAttributes redirectAttributes) {
		
		usuarioValidator.validate(u, result);
		
		if (result.hasErrors()) {
			
			ModelAndView mav = new ModelAndView();
			
			List<Rol> ListRol = rolService.getAllRol();
			
			mav.setViewName("usuario/add");
			mav.addObject("Usuario", u);
			mav.addObject("rolList", ListRol);
			mav.addObject("user", getUsuario());
			mav.addObject("modulos", getModulos());
			
			return mav;
			
		}
		
		u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
		u.setEstado(1);
		
		usuarioService.add(u);
		
		redirectAttributes.addFlashAttribute("messageSuccess", "El usuario ha sido agregado exitosamente.");
		
		return new ModelAndView("redirect:/usuario/index.html");
	}
	
	@RequestMapping(value = "/usuario/edit", method = RequestMethod.GET)
	public ModelAndView editUsuario(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		
		List<Rol> ListRol = rolService.getAllRol();
		
		Usuario usuario = usuarioService.getUsuario(Integer.parseInt(request.getParameter("id")));
		
		mav.setViewName("usuario/edit");
		mav.addObject("Usuario", usuario);
		mav.addObject("rolList", ListRol);
		mav.addObject("user", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
	@RequestMapping(value = "/usuario/edit", method = RequestMethod.POST)
	public ModelAndView editUsuario(
			@ModelAttribute("Usuario") Usuario u,
			BindingResult result,
			SessionStatus status,
			final RedirectAttributes redirectAttributes) {
		
		usuarioValidator.validate(u, result);
		
		if (result.hasErrors()) {
			
			ModelAndView mav = new ModelAndView();
			
			List<Rol> ListRol = rolService.getAllRol();
			
			mav.setViewName("usuario/edit");
			mav.addObject("Usuario", u);
			mav.addObject("rolList", ListRol);
			mav.addObject("user", getUsuario());
			mav.addObject("modulos", getModulos());
			
			return mav;			
			
		}
		
		usuarioService.edit(u);
		
		redirectAttributes.addFlashAttribute("messageSuccess", "El usuario ha sido editado exitosamente.");
		
		return new ModelAndView("redirect:/usuario/index.html");
		
	}
	
	@RequestMapping(value = "/usuario/edit-pass", method = RequestMethod.POST)
	public ModelAndView editPasswordUsuario(
			SessionStatus status,
			HttpServletRequest request,
			final RedirectAttributes redirectAttributes) {
				
		Usuario usuario = usuarioService.getUsuario(Integer.parseInt(request.getParameter("id")));
		
		usuario.setPassword(bCryptPasswordEncoder.encode( request.getParameter("password") ));
		usuarioService.edit(usuario);
		
		redirectAttributes.addFlashAttribute("messageSuccess", "La password ha sido cambiada exitosamente.");
				
		return new ModelAndView("redirect:/usuario/index.html");
		
	}
	
	@RequestMapping(value = "/usuario/edit-pass", method = RequestMethod.GET)
	public ModelAndView editPasswordUsuario(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		
		Usuario usuario = usuarioService.getUsuario(Integer.parseInt(request.getParameter("id")));
		
		mav.setViewName("usuario/edit_pass");
		mav.addObject("Usuario", usuario);
		mav.addObject("user", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
		
	}
	
	@RequestMapping(value = "/usuario/delete", method = RequestMethod.GET)
	public ModelAndView deleteUsuario(
			HttpServletRequest request,
			final RedirectAttributes redirectAttributes) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		usuarioService.delete(id);
		
		redirectAttributes.addFlashAttribute("messageSuccess", "El usuario ha sido elimnado exitosamente.");
		
		return new ModelAndView("redirect:/usuario/index.html");
	}
	
	@RequestMapping(value = "/usuario/inactivate", method = RequestMethod.GET)
	public ModelAndView inactivateUsuario(
			HttpServletRequest request,
			final RedirectAttributes redirectAttributes) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Usuario usuario = usuarioService.getUsuario(id);
		
		usuario.setEstado(2);
		
		usuarioService.edit(usuario);
		
		redirectAttributes.addFlashAttribute("messageSuccess", "El usuario ha sido inactivado exitosamente.");
		
		return new ModelAndView("redirect:/usuario/index.html");
	}
	
	@RequestMapping(value = "/usuario/activate", method = RequestMethod.GET)
	public ModelAndView activateUsuario(
			HttpServletRequest request,
			final RedirectAttributes redirectAttributes) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Usuario usuario = usuarioService.getUsuario(id);
		
		usuario.setEstado(1);
		
		usuarioService.edit(usuario);
		
		redirectAttributes.addFlashAttribute("messageSuccess", "El usuario ha sido activado exitosamente.");
		
		return new ModelAndView("redirect:/usuario/index.html");
	}
	
	@RequestMapping(value = "/usuario/enable", method = RequestMethod.GET)
	public ModelAndView enableUsuario(
			HttpServletRequest request,
			final RedirectAttributes redirectAttributes) {
		
		ModelAndView mav = new ModelAndView();
		
		Usuario usuario = usuarioService.getUsuario(Integer.parseInt(request.getParameter("id")));
		
		mav.setViewName("usuario/enable_user");
		mav.addObject("Usuario", usuario);
		mav.addObject("user", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
	@RequestMapping(value = "/usuario/enable", method = RequestMethod.POST)
	public ModelAndView enableUsuario(
			SessionStatus status,
			HttpServletRequest request,
			final RedirectAttributes redirectAttributes) {
		
		Usuario usuario = usuarioService.getUsuario(Integer.parseInt(request.getParameter("id")));
		
		usuario.setPassword(bCryptPasswordEncoder.encode( request.getParameter("password") ));
		usuario.setEstado(1);
		
		usuarioService.edit(usuario);
		
		redirectAttributes.addFlashAttribute("messageSuccess", "El usuario ha sido desbloqueado exitosamente.");
				
		return new ModelAndView("redirect:/usuario/index.html");
	}
	
	@RequestMapping(value = "/usuario/disable", method = RequestMethod.GET)
	public ModelAndView disableUsuario(
			HttpServletRequest request,
			final RedirectAttributes redirectAttributes) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Usuario usuario = usuarioService.getUsuario(id);
		
		usuario.setEstado(3);
		
		usuarioService.edit(usuario);
		
		redirectAttributes.addFlashAttribute("messageSuccess", "El usuario ha sido bloqueado exitosamente.");
		
		return new ModelAndView("redirect:/login.html");
	}
	
	@RequestMapping(value = "/usuario/edit-user", method = RequestMethod.GET)
	public ModelAndView editUsuarioLoggedIn(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		
		List<Rol> ListRol = rolService.getAllRol();
		
		Usuario usuario = usuarioService.getUsuario(Integer.parseInt(request.getParameter("id")));
		
		mav.setViewName("usuario/edit_user");
		mav.addObject("Usuario", usuario);
		mav.addObject("rolList", ListRol);
		mav.addObject("user", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
	@RequestMapping(value = "/usuario/edit-user", method = RequestMethod.POST)
	public ModelAndView editUsuarioLoggedIn(
			@ModelAttribute("Usuario") Usuario u,
			BindingResult result,
			SessionStatus status,
			final RedirectAttributes redirectAttributes) {
		
		usuarioValidator.validate(u, result);
		
		if (result.hasErrors()) {
			
			ModelAndView mav = new ModelAndView();
			
			List<Rol> ListRol = rolService.getAllRol();
			
			mav.setViewName("usuario/edit_user");
			mav.addObject("Usuario", u);
			mav.addObject("rolList", ListRol);
			mav.addObject("user", getUsuario());
			mav.addObject("modulos", getModulos());
			
			return mav;	
			
		}
		
		usuarioService.edit(u);
		
		redirectAttributes.addFlashAttribute("messageSuccess", "El usuario ha sido editado exitosamente.");
		
		return new ModelAndView("redirect:/welcome.html");
		
	}

	@RequestMapping(value = "/usuario/edit-pass-user", method = RequestMethod.POST)
	public ModelAndView editPasswordLoggedIn(
			SessionStatus status,
			HttpServletRequest request,
			final RedirectAttributes redirectAttributes) {

		Usuario usuario = usuarioService.getUsuario(getUsuario().getId());
		
		if ( bCryptPasswordEncoder.matches(request.getParameter("currentPassword"), usuario.getPassword()) ) {
			usuario.setPassword(bCryptPasswordEncoder.encode( request.getParameter("password") ));
			usuarioService.edit(usuario);
			
			redirectAttributes.addFlashAttribute("messageSuccess", "La password ha sido cambiada exitosamente.");
					
			return new ModelAndView("redirect:/welcome.html");
		}
		
		return new ModelAndView("redirect:/usuario/edit-pass-user.html").addObject("id", request.getParameter("id"));
		
	}
	
	@RequestMapping(value = "/usuario/edit-pass-user", method = RequestMethod.GET)
	public ModelAndView editPasswordLoggedIn() {
		
		ModelAndView mav = new ModelAndView();
		
		Usuario usuario = usuarioService.getUsuario(getUsuario().getId());
		
		mav.setViewName("usuario/edit_pass_user");
		mav.addObject("Usuario", usuario);
		mav.addObject("user", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
		
	}
	
}
