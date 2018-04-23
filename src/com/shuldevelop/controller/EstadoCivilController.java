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

import com.shuldevelop.model.EstadoCivil;
import com.shuldevelop.model.validator.EstadoCivilValidator;
import com.shuldevelop.service.EstadoCivilService;

@Controller
public class EstadoCivilController {
	
	@Autowired
	private EstadoCivilService estadoCivilService;
	
	private EstadoCivilValidator estadoCivilValidator;
		
	public EstadoCivilController() {
		this.estadoCivilValidator = new EstadoCivilValidator();
	}

	@RequestMapping(value = "/estado-civil/index", method = RequestMethod.GET)
	public ModelAndView estadoCivil() {
		
		ModelAndView mav = new ModelAndView();
		
		List<EstadoCivil> listEstadoCivil = estadoCivilService.getAllEstadoCivil();
		
		mav.setViewName("estado_civil/index");
		mav.addObject("estadoCivilList", listEstadoCivil);
		
		return mav;
	}
	
	@RequestMapping(value = "/estado-civil/add", method = RequestMethod.GET)
	public ModelAndView addEstadoCivil() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("estado_civil/add");
		mav.addObject("EstadoCivil", new EstadoCivil());
		
		return mav;
	}
	
	@RequestMapping(value = "/estado-civil/add", method = RequestMethod.POST)
	public ModelAndView addEstadoCivil(
			@ModelAttribute("EstadoCivil") EstadoCivil u,
			BindingResult result,
			SessionStatus status
 			) {
		
		this.estadoCivilValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("estado_civil/add");
			mav.addObject("EstadoCivil", new EstadoCivil());
			
			return mav;
		}
		
		estadoCivilService.add(u);
		
		return new ModelAndView("redirect:/estado-civil/index.html");
	}
	
	@RequestMapping(value = "/estado-civil/edit", method = RequestMethod.GET)
	public ModelAndView editEstadoCivil(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		
		EstadoCivil estadoCivil = estadoCivilService.getEstadoCivil(id);
		
		mav.setViewName("estado_civil/edit");
		mav.addObject("EstadoCivil", estadoCivil);
		
		return mav;
	}
	
	@RequestMapping(value = "/estado-civil/edit", method = RequestMethod.POST)
	public ModelAndView editEstadoCivil(
			@ModelAttribute("EstadoCivil") EstadoCivil u,
			BindingResult result,
			SessionStatus status,
			HttpServletRequest request
 			) {
		
		this.estadoCivilValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			int id = Integer.parseInt(request.getParameter("id"));
			
			EstadoCivil estadoCivil = estadoCivilService.getEstadoCivil(id);
			
			mav.setViewName("estado_civil/edit");
			mav.addObject("EstadoCivil", estadoCivil);
			
			return mav;
		}
		
		estadoCivilService.edit(u);
		
		return new ModelAndView("redirect:/estado-civil/index.html");
	}
	
	@RequestMapping(value = "/estado-civil/delete", method = RequestMethod.GET)
	public ModelAndView deleteEstadoCivil(HttpServletRequest request) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		estadoCivilService.delete(id);
		
		return new ModelAndView("redirect:/estado-civil/index.html");
	}
	
}
