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
import com.shuldevelop.model.Permiso;
import com.shuldevelop.model.Rol;
import com.shuldevelop.model.RolModuloPermiso;
import com.shuldevelop.model.Usuario;
import com.shuldevelop.model.validator.RolValidator;
import com.shuldevelop.service.ModuloService;
import com.shuldevelop.service.PermisoService;
import com.shuldevelop.service.RolModuloPermisoService;
import com.shuldevelop.service.RolService;
import com.shuldevelop.service.UsuarioService;

@Controller
public class RolController {

	@Autowired
	private RolService rolService;
	
	@Autowired
	private RolModuloPermisoService rolModuloPermisoService;
	
	@Autowired
	private ModuloService moduloService;
	
	@Autowired
	private PermisoService permisoService;
	
	@Autowired
	private UsuarioService usuarioService;
		
	private RolValidator rolValidator;
		
	public RolController() {
		rolValidator = new RolValidator();
	}
	
	public Usuario getUsuario() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		
		return usuarioService.findUserByUsername(userDetails.getUsername());
	}
	
	public List<Modulo> getModulos() {
		
		return moduloService.getAllModuloByRol(getUsuario().getRol().getId());
		
	}

	@RequestMapping(value = "/rol/index", method = RequestMethod.GET)
	public ModelAndView rol() {
		
		ModelAndView mav = new ModelAndView();
		
		List<Rol> listRol = rolService.getAllRol();
		
		mav.setViewName("rol/index");
		mav.addObject("rolList", listRol);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
	@RequestMapping(value = "/rol/add", method = RequestMethod.GET)
	public ModelAndView addRol() {
		
		ModelAndView mav = new ModelAndView();
		
		List<Modulo> listModulo = moduloService.getAllModulo();
		
		mav.setViewName("rol/add");
		mav.addObject("Rol", new Rol());
		mav.addObject("moduloList", listModulo);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
	@RequestMapping(value = "/rol/add", method = RequestMethod.POST)
	public ModelAndView addRol(
			@ModelAttribute("Rol") Rol u,
			BindingResult result,
			SessionStatus status,
			HttpServletRequest request,
			final RedirectAttributes redirectAttributes
 			) {
		
		this.rolValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			List<Modulo> listModulo = moduloService.getAllModulo();
			
			mav.setViewName("rol/add");
			mav.addObject("Rol", u);
			mav.addObject("moduloList", listModulo);
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
			
			return mav;
		}
			
		rolService.add(u);
		
		Modulo modulo;
		Permiso permiso;
		RolModuloPermiso rolModuloPermiso;
		
		String[] modulos = request.getParameterValues("modulos");
		String[] permisos = request.getParameterValues("data-permisos");
	
		if (modulos != null && permisos != null) {

			int j = 0;
			
			for (String id : modulos) {
				
				modulo = moduloService.getModulo(Integer.parseInt(id));
				
				String[] aPermiso = permisos[j].split(",");
				aPermiso[0] = "0";
				
				for (String i : aPermiso) {
					
					if (i != "0") {
						
						rolModuloPermiso = new RolModuloPermiso();
						
						permiso = permisoService.getPermiso( Integer.parseInt(i) );
						
						rolModuloPermiso.setModulo(modulo);
						rolModuloPermiso.setPermiso(permiso);
						rolModuloPermiso.setRol(u);
						rolModuloPermiso.setEstado(true);
						
						rolModuloPermisoService.add(rolModuloPermiso);
						
					}
					
				}
			
				j++;
				
			}
			
		}
		
		redirectAttributes.addFlashAttribute("messageSuccess", "El rol ha sido agregado exitosamente.");
		
		return new ModelAndView("redirect:/rol/index.html");
	}
	
	@RequestMapping(value = "/rol/edit", method = RequestMethod.GET)
	public ModelAndView editRol(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Rol rol = rolService.getRol(id);
		
		mav.setViewName("rol/edit");
		mav.addObject("Rol", rol);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
	@RequestMapping(value = "/rol/edit", method = RequestMethod.POST)
	public ModelAndView editRol(
			@ModelAttribute("Rol") Rol u,
			BindingResult result,
			SessionStatus status,
			HttpServletRequest request,
			final RedirectAttributes redirectAttributes
 			) {
		
		this.rolValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("rol/edit");
			mav.addObject("rol", u);
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
			
			return mav;
		}
		
		rolService.edit(u);
		
		redirectAttributes.addFlashAttribute("messageSuccess", "El rol ha sido editado exitosamente.");
		
		return new ModelAndView("redirect:/rol/index.html");
	}
	
	@RequestMapping(value = "/rol/delete", method = RequestMethod.GET)
	public ModelAndView deleteRol(
			HttpServletRequest request,
			final RedirectAttributes redirectAttributes
			) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		try {

			rolService.delete(id);
			redirectAttributes.addFlashAttribute("messageSuccess", "El rol ha sido eliminado exitosamente.");
			
		} catch (Exception e) {
						
			redirectAttributes.addFlashAttribute("messageError", "El rol posee dependencia no se puede eliminar.");
			
		}
		
		return new ModelAndView("redirect:/rol/index.html");
	}
	
}
