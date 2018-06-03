package com.shuldevelop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.shuldevelop.model.Modulo;
import com.shuldevelop.model.Permiso;
import com.shuldevelop.model.Rol;
import com.shuldevelop.model.RolModuloPermiso;
import com.shuldevelop.service.ModuloService;
import com.shuldevelop.service.PermisoService;
import com.shuldevelop.service.RolModuloPermisoService;
import com.shuldevelop.service.RolService;

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

	public RolModuloPermisoController() {
	}
	
	@RequestMapping(value = "/rol-modulo-permiso/index", method = RequestMethod.GET)
	public ModelAndView rolModuloPermiso(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		
		int idRol = Integer.parseInt(request.getParameter("id"));
		
		List<RolModuloPermiso> listRolModuloPermiso = rolModuloPermisoService.getAllRolModuloPermisoByRol(idRol);
		
		List<Modulo> listModulo = moduloService.getAllModulo();
		
		Rol rol = rolService.getRol(idRol);
		
		mav.setViewName("rol_modulo_permiso/index");
		mav.addObject("RolModuloPermiso", new RolModuloPermiso());
		mav.addObject("rol", rol);
		mav.addObject("rolModuloPermisoList", listRolModuloPermiso);
		mav.addObject("moduloList", listModulo);
		
		return mav;
		
	}
	
	@RequestMapping(value = "/rol-modulo-permiso/index", method = RequestMethod.POST)
	public ModelAndView addRolModuloPermiso(
			@ModelAttribute("RolModuloPermiso") RolModuloPermiso u,
			BindingResult result,
			SessionStatus status,
			HttpServletRequest request
 			) {
		
//		this.rolValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			Rol rol = rolService.getRol(u.getRol().getId());
			
			List<RolModuloPermiso> listRolModuloPermiso = rolModuloPermisoService.getAllRolModuloPermisoByRol(rol.getId());
			
			List<Modulo> listModulo = moduloService.getAllModulo();
			
			
			mav.setViewName("rol_modulo_permiso/index");
			mav.addObject("RolModuloPermiso", u);
			mav.addObject("rol", rol);
			mav.addObject("rolModuloPermisoList", listRolModuloPermiso);
			mav.addObject("moduloList", listModulo);
			
			return mav;
		}
		
		String[] permisos = request.getParameterValues("permisos");
		
		RolModuloPermiso rolModuloPermiso;
		Permiso permiso;
		
		Modulo modulo = moduloService.getModulo( u.getModulo().getId() );
		Rol rol = rolService.getRol(u.getRol().getId());
		
		for (String id : permisos) {
			
			permiso = permisoService.getPermiso(Integer.parseInt(id));
			
			rolModuloPermiso = new RolModuloPermiso();
			
			rolModuloPermiso.setModulo(modulo);
			rolModuloPermiso.setPermiso(permiso);
			rolModuloPermiso.setRol(rol);
			rolModuloPermiso.setEstado(true);
			
			rolModuloPermisoService.add(rolModuloPermiso);		
		}
		
		
		return new ModelAndView("redirect:/rol-modulo-permiso/index.html").addObject("id", u.getRol().getId());
	}
	
	@RequestMapping(value = "/rol-modulo-permiso/disable", method = RequestMethod.GET)
	public ModelAndView rolModuloPermisoDisable(HttpServletRequest request) {
		
		int idPermiso = Integer.parseInt(request.getParameter("id"));
		
		RolModuloPermiso permiso = rolModuloPermisoService.getRolModuloPermiso(idPermiso);
		permiso.setEstado(false);
		
		rolModuloPermisoService.edit(permiso);
		
		return new ModelAndView("redirect:/rol-modulo-permiso/index.html").addObject("id", permiso.getRol().getId());
		
	}
	
	@RequestMapping(value = "/rol-modulo-permiso/enable", method = RequestMethod.GET)
	public ModelAndView rolModuloPermisoEnable(HttpServletRequest request) {
		
		int idPermiso = Integer.parseInt(request.getParameter("id"));
		
		RolModuloPermiso permiso = rolModuloPermisoService.getRolModuloPermiso(idPermiso);
		permiso.setEstado(true);
		
		rolModuloPermisoService.edit(permiso);
		
		return new ModelAndView("redirect:/rol-modulo-permiso/index.html").addObject("id", permiso.getRol().getId());
		
	}
	
	@RequestMapping(value = "/rol-modulo-permiso/delete", method = RequestMethod.GET)
	public ModelAndView rolModuloPermisoDelete(HttpServletRequest request) {
		
		int idPermiso = Integer.parseInt(request.getParameter("id"));
		
		RolModuloPermiso permiso = rolModuloPermisoService.getRolModuloPermiso(idPermiso);
		rolModuloPermisoService.delete(permiso.getId());
		
		return new ModelAndView("redirect:/rol-modulo-permiso/index.html").addObject("id", permiso.getRol().getId());
		
	}
	
}
