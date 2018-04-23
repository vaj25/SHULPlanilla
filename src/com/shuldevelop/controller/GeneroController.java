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

import com.shuldevelop.model.Genero;
import com.shuldevelop.model.validator.GeneroValidator;
import com.shuldevelop.service.GeneroService;

@Controller
public class GeneroController {
	
	@Autowired
	private GeneroService generoService;
	
	private  GeneroValidator generoValidator;
		
	public  GeneroController() {
		this.generoValidator = new  GeneroValidator();
	}
	
	@RequestMapping(value = "/genero/index", method = RequestMethod.GET)
	public ModelAndView tipoDocIdentidad() {
		
		ModelAndView mav = new ModelAndView();
		
		List<Genero> listGenero= generoService.getAllGenero();
		
		mav.setViewName("genero/index");
		mav.addObject("generoList", listGenero);
		
		return mav;
	}

	@RequestMapping(value = "/genero/add", method = RequestMethod.GET)
	public ModelAndView addGenero() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("genero/add");
		mav.addObject("Genero", new Genero());
		
		return mav;
	}
	
	@RequestMapping(value = "/genero/add", method = RequestMethod.POST)
	public ModelAndView addGenero(
			@ModelAttribute("Genero") Genero u,
			BindingResult result,
			SessionStatus status
 			) {
		
		this.generoValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("genero/add");
			mav.addObject("Genero", new Genero());
			
			return mav;
		}
		
		generoService.add(u);
		
		return new ModelAndView("redirect:/genero/index.html");
	}
	
	@RequestMapping(value = "/genero/edit", method = RequestMethod.GET)
	public ModelAndView editGenero(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		
		Genero genero = generoService.getGenero(id);
		
		mav.setViewName("genero/edit");
		mav.addObject("Genero", genero);
		
		return mav;
	}
	
	@RequestMapping(value = "/genero/edit", method = RequestMethod.POST)
	public ModelAndView editGenero(
			@ModelAttribute("Genero") Genero u,
			BindingResult result,
			SessionStatus status,
			HttpServletRequest request
 			) {
		
		this.generoValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			int id = Integer.parseInt(request.getParameter("id"));
			
			Genero genero = generoService.getGenero(id);
			
			mav.setViewName("genero/edit");
			mav.addObject("Genero", genero);
			
			return mav;
		}
		
		generoService.edit(u);
		
		return new ModelAndView("redirect:/genero/index.html");
	}
	
	
	@RequestMapping(value = "/genero/delete", method = RequestMethod.GET)
	public ModelAndView deleteGenero(HttpServletRequest request) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		generoService.delete(id);
		
		return new ModelAndView("redirect:/genero/index.html");
	}
	
	
}
