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
import com.shuldevelop.model.ProfesionOficio;
import com.shuldevelop.model.validator.ProfesionOficioValidator;
import com.shuldevelop.service.ProfesionOficioService;

@Controller
public class ProfesionOficioController {
	@Autowired
	private ProfesionOficioService profesionService;
	
	private ProfesionOficioValidator profesionOficioValidator;
	
	public ProfesionOficioController() {
		this.profesionOficioValidator = new ProfesionOficioValidator();
	}
	
	@RequestMapping(value = "/profesion-oficio/index", method = RequestMethod.GET)
	public ModelAndView profesionOficio() {
		
		ModelAndView mav = new ModelAndView();
		
		List<ProfesionOficio> listProfesionOficio= profesionService.getAllProfesionOficio();
		
		mav.setViewName("profesion_oficio/index");
		mav.addObject("profesionOficioList", listProfesionOficio);
		
		return mav;
	}
	
	@RequestMapping(value = "/profesion-oficio/add", method = RequestMethod.GET)
	public ModelAndView addProfesionOficio() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("profesion_oficio/add");
		mav.addObject("ProfesionOficio", new ProfesionOficio());
		
		return mav;
	}
	
	@RequestMapping(value = "/profesion-oficio/add", method = RequestMethod.POST)
	public ModelAndView addProfesionOficio(
			@ModelAttribute("ProfesionOficio") ProfesionOficio u,
			BindingResult result,
			SessionStatus status
 			) {
		
		this.profesionOficioValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("profesion_oficio/add");
			mav.addObject("ProfesionOficio", u);
			
			return mav;
		}
		
		profesionService.add(u);
		
		return new ModelAndView("redirect:/profesion-oficio/index.html");
	}
	
	@RequestMapping(value = "/profesion-oficio/edit", method = RequestMethod.GET)
	public ModelAndView editProfesionOficio(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		
		ProfesionOficio profesionOficio = profesionService.getProfesionOficio(id);
		
		mav.setViewName("profesion_oficio/edit");
		mav.addObject("ProfesionOficio", profesionOficio);
		
		return mav;
	}
	
	@RequestMapping(value = "/profesion-oficio/edit", method = RequestMethod.POST)
	public ModelAndView editProfesionOficio(
			@ModelAttribute("ProfesionOficio") ProfesionOficio u,
			BindingResult result,
			SessionStatus status,
			HttpServletRequest request
 			) {
		
		this.profesionOficioValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("profesion_oficio/edit");
			mav.addObject("ProfesionOficio", u);
			
			return mav;
		}
		
		profesionService.edit(u);
		
		return new ModelAndView("redirect:/profesion-oficio/index.html");
	}
	
	@RequestMapping(value = "/profesion-oficio/delete", method = RequestMethod.GET)
	public ModelAndView deleteProfesionOficio(HttpServletRequest request) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		profesionService.delete(id);
		
		return new ModelAndView("redirect:/profesion-oficio/index.html");
	}

}
