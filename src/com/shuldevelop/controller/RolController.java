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
import com.shuldevelop.model.validator.RolValidator;
import com.shuldevelop.service.ModuloService;
import com.shuldevelop.service.PermisoService;
import com.shuldevelop.service.RolModuloPermisoService;
import com.shuldevelop.service.RolService;

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
	
	private RolValidator rolValidator;
		
	public RolController() {
		rolValidator = new RolValidator();
	}

	@RequestMapping(value = "/rol/index", method = RequestMethod.GET)
	public ModelAndView rol() {
		
		ModelAndView mav = new ModelAndView();
		
		List<Rol> listRol = rolService.getAllRol();
		
		mav.setViewName("rol/index");
		mav.addObject("rolList", listRol);
		
		return mav;
	}
	
	@RequestMapping(value = "/rol/add", method = RequestMethod.GET)
	public ModelAndView addRol() {
		
		ModelAndView mav = new ModelAndView();
		
		List<Modulo> listModulo = moduloService.getAllModulo();
		
		mav.setViewName("rol/add");
		mav.addObject("Rol", new Rol());
		mav.addObject("moduloList", listModulo);
		
		return mav;
	}
	
	@RequestMapping(value = "/rol/add", method = RequestMethod.POST)
	public ModelAndView addRol(
			@ModelAttribute("Rol") Rol u,
			BindingResult result,
			SessionStatus status,
			HttpServletRequest request
 			) {
		
		this.rolValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			List<Modulo> listModulo = moduloService.getAllModulo();
			
			mav.setViewName("rol/add");
			mav.addObject("Rol", u);
			mav.addObject("moduloList", listModulo);
			
			return mav;
		}
			
		rolService.add(u);
		
		Modulo modulo;
		Permiso permiso;
		RolModuloPermiso rolModuloPermiso;
		
		String[] modulos = request.getParameterValues("modulos");
		
		for (String id : modulos) {
			
			modulo = moduloService.getModulo(Integer.parseInt(id));
			
			for (int i = 1; i <= 4; i++) {
				
				rolModuloPermiso = new RolModuloPermiso();
				
				permiso = permisoService.getPermiso(i);
				
				rolModuloPermiso.setModulo(modulo);
				rolModuloPermiso.setPermiso(permiso);
				rolModuloPermiso.setRol(u);
				rolModuloPermiso.setEstado(true);
				
				rolModuloPermisoService.add(rolModuloPermiso);

			}
			
		}
		
		return new ModelAndView("redirect:/rol/index.html");
	}
	
	@RequestMapping(value = "/rol/edit", method = RequestMethod.GET)
	public ModelAndView editRol(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Rol rol = rolService.getRol(id);
		
		mav.setViewName("rol/edit");
		mav.addObject("Rol", rol);
		
		return mav;
	}
	
	@RequestMapping(value = "/rol/edit", method = RequestMethod.POST)
	public ModelAndView editRol(
			@ModelAttribute("Rol") Rol u,
			BindingResult result,
			SessionStatus status,
			HttpServletRequest request
 			) {
		
		this.rolValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("rol/edit");
			mav.addObject("rol", u);
			
			return mav;
		}
		
		rolService.edit(u);
		
		return new ModelAndView("redirect:/rol/index.html");
	}
	
	@RequestMapping(value = "/rol/delete", method = RequestMethod.GET)
	public ModelAndView deleteRol(HttpServletRequest request) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		rolService.delete(id);
		
		return new ModelAndView("redirect:/rol/index.html");
	}
	
}
