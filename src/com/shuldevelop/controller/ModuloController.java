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
import com.shuldevelop.model.validator.ModuloValidator;
import com.shuldevelop.service.ModuloService;

@Controller
public class ModuloController {

	@Autowired
	private ModuloService moduloService;
	
	private ModuloValidator moduloValidator;
	
	public ModuloController() {
		this.moduloValidator = new ModuloValidator();
	}

	@RequestMapping(value = "/modulo/index", method = RequestMethod.GET)
	public ModelAndView modulo() {
		
		ModelAndView mav = new ModelAndView();
		
		List<Modulo> listModulo = moduloService.getAllModulo();
		
		mav.setViewName("modulo/index");
		mav.addObject("moduloList", listModulo);
		
		return mav;
	}
	
	@RequestMapping(value = "/modulo/add", method = RequestMethod.GET)
	public ModelAndView addModulo() {
		
		ModelAndView mav = new ModelAndView();
		
		List<Modulo> listModulo = moduloService.getAllModuloParent();
		
		mav.setViewName("modulo/add");
		mav.addObject("Modulo", new Modulo());
		mav.addObject("moduloList", listModulo);
		
		return mav;
	}
	
	@RequestMapping(value = "/modulo/add", method = RequestMethod.POST)
	public ModelAndView addModulo(
			@ModelAttribute("Modulo") Modulo u,
			BindingResult result,
			SessionStatus status
 			) {
		
		this.moduloValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			List<Modulo> listModulo = moduloService.getAllModuloParent();
			
			mav.setViewName("modulo/add");
			mav.addObject("Modulo", u);
			mav.addObject("moduloList", listModulo);
			
			return mav;
		}
		
		u.setDependencia( moduloService.getModulo( u.getDependencia().getId() ) );
		
		moduloService.add(u);
		
		return new ModelAndView("redirect:/modulo/index.html");
	}
	
	@RequestMapping(value = "/modulo/edit", method = RequestMethod.GET)
	public ModelAndView editModulo(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		
		Modulo modulo = moduloService.getModulo(id);
		
		List<Modulo> listModulo = moduloService.getAllModuloParent();
		
		mav.setViewName("modulo/edit");
		mav.addObject("Modulo", modulo);
		mav.addObject("moduloList", listModulo);
		
		return mav;
	}
	
	@RequestMapping(value = "/modulo/edit", method = RequestMethod.POST)
	public ModelAndView editModulo(
			@ModelAttribute("Modulo") Modulo u,
			BindingResult result,
			SessionStatus status,
			HttpServletRequest request
 			) {
		
		this.moduloValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			List<Modulo> listModulo = moduloService.getAllModuloParent();
			
			mav.setViewName("modulo/edit");
			mav.addObject("Modulo", u);
			mav.addObject("moduloList", listModulo);
			
			return mav;
		}
		
		u.setDependencia( moduloService.getModulo( u.getDependencia().getId() ) );
		
		moduloService.edit(u);
		
		return new ModelAndView("redirect:/modulo/index.html");
	}
	
	@RequestMapping(value = "/modulo/delete", method = RequestMethod.GET)
	public ModelAndView deletePuesto(HttpServletRequest request) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		moduloService.delete(id);
		
		return new ModelAndView("redirect:/modulo/index.html");
	}
	
}
