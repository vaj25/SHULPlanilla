package com.shuldevelop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
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
import com.shuldevelop.service.ModuloService;
import com.shuldevelop.service.PermisoService;
import com.shuldevelop.service.RolModuloPermisoService;
import com.shuldevelop.service.RolService;
import com.shuldevelop.service.UsuarioService;

@Controller
public class RolModuloPermisoController {

	@Autowired
	private RolModuloPermisoService rolModuloPermisoService;
	
	@Autowired
	private RolService rolService;
	
	@Autowired
	private ModuloService moduloService;
	
	@Autowired
	private PermisoService permisoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	private static final int LIMITITEMSPERPAGE = 10;

	public RolModuloPermisoController() {	
	}
	
	public Usuario getUsuario() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		
		return usuarioService.findUserByUsername(userDetails.getUsername());
	}
	
	public List<Modulo> getModulos() {
		
		return moduloService.getAllModuloByRol(getUsuario().getRol().getId());
		
	}
	
	@RequestMapping(value = "/rol-modulo-permiso/index", method = RequestMethod.GET)
	public ModelAndView rolModuloPermiso(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		
		int idRol = Integer.parseInt(request.getParameter("id"));
		
		int page = 0;
		
		if ( request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		List<RolModuloPermiso> listRolModuloPermiso = rolModuloPermisoService
				.getAllRolModuloPermisoByRol(idRol, page, LIMITITEMSPERPAGE);
		
		List<Modulo> listModulo = moduloService.getAllModulo();
		
		Rol rol = rolService.getRol(idRol);
		
		mav.setViewName("rol_modulo_permiso/index");
		mav.addObject("RolModuloPermiso", new RolModuloPermiso());
		mav.addObject("rol", rol);
		mav.addObject("rolModuloPermisoList", listRolModuloPermiso);
		mav.addObject("moduloList", listModulo);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		mav.addObject("totalCount", rolModuloPermisoService.getCountRolModuloPermisoByRol(idRol));
		mav.addObject("perPage", LIMITITEMSPERPAGE);
		
		return mav;
		
	}
	
	@RequestMapping(value = "/rol-modulo-permiso/index", method = RequestMethod.POST)
	public ModelAndView addRolModuloPermiso(
			SessionStatus status,
			HttpServletRequest request,
			final RedirectAttributes redirectAttributes
 			) {
		
		int idRol = Integer.parseInt(request.getParameter("id"));
		
		Rol u = rolService.getRol(idRol);
		
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
			
			rolModuloPermiso.setModulo(modulo);
			rolModuloPermiso.setPermiso(permiso);
			rolModuloPermiso.setRol(rol);
			rolModuloPermiso.setEstado(true);
			
			rolModuloPermisoService.add(rolModuloPermiso);		
		}
		
		redirectAttributes.addFlashAttribute("messageSuccess", "El permiso ha sido agregado exitosamente.");
		
		return new ModelAndView("redirect:/rol-modulo-permiso/index.html").addObject("id", idRol);
	}
	
	@RequestMapping(value = "/rol-modulo-permiso/disable", method = RequestMethod.GET)
	public ModelAndView rolModuloPermisoDisable(
			HttpServletRequest request,
			final RedirectAttributes redirectAttributes
			) {
		
		int idPermiso = Integer.parseInt(request.getParameter("id"));
		
		RolModuloPermiso permiso = rolModuloPermisoService.getRolModuloPermiso(idPermiso);
		permiso.setEstado(false);
		
		rolModuloPermisoService.edit(permiso);
		
		redirectAttributes.addFlashAttribute("messageSuccess", "El permiso ha sido deshabilitado exitosamente.");
		
		return new ModelAndView("redirect:/rol-modulo-permiso/index.html").addObject("id", permiso.getRol().getId());
		
	}
	
	@RequestMapping(value = "/rol-modulo-permiso/enable", method = RequestMethod.GET)
	public ModelAndView rolModuloPermisoEnable(
			HttpServletRequest request,
			final RedirectAttributes redirectAttributes
			) {
		
		int idPermiso = Integer.parseInt(request.getParameter("id"));
		
		RolModuloPermiso permiso = rolModuloPermisoService.getRolModuloPermiso(idPermiso);
		permiso.setEstado(true);
		
		rolModuloPermisoService.edit(permiso);
		
		redirectAttributes.addFlashAttribute("messageSuccess", "El permito ha sido habilitado exitosamente.");
		
		return new ModelAndView("redirect:/rol-modulo-permiso/index.html").addObject("id", permiso.getRol().getId());
		
	}
	
	@RequestMapping(value = "/rol-modulo-permiso/delete", method = RequestMethod.GET)
	public ModelAndView rolModuloPermisoDelete(
			HttpServletRequest request,
			final RedirectAttributes redirectAttributes
			) {
		
		int idPermiso = Integer.parseInt(request.getParameter("id"));
		
		RolModuloPermiso permiso = rolModuloPermisoService.getRolModuloPermiso(idPermiso);
		
		try {
			
			rolModuloPermisoService.delete(permiso.getId());
			redirectAttributes.addFlashAttribute("messageSuccess", "El permiso ha sido eliminado exitosamente.");
			
		} catch (Exception e) {
						
			redirectAttributes.addFlashAttribute("messageError", "El permiso no ha podido ser eliminado.");
			
		}
		
		return new ModelAndView("redirect:/rol-modulo-permiso/index.html").addObject("id", permiso.getRol().getId());
		
	}
	
}
