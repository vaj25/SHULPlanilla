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

import com.shuldevelop.model.NivelEstructura;
import com.shuldevelop.model.validator.NivelEstructuraValidator;
import com.shuldevelop.service.NivelEstructuraService;

@Controller
public class NivelEstructuraController {
	@Autowired
	private NivelEstructuraService nivelEstructuraService;
	private NivelEstructuraValidator nivelEstructuraValidator;
	
	public NivelEstructuraController() {
		this.nivelEstructuraValidator = new NivelEstructuraValidator();
	}
	
	@RequestMapping(value = "/nivel-estructura/index", method = RequestMethod.GET)
	public ModelAndView nivelEstructura() {
		ModelAndView mav  = new ModelAndView();
		
		List<NivelEstructura> listNivelEstructura = nivelEstructuraService.getAllNivelEstructura();
		
		mav.setViewName("nivel_estructura/index");
		mav.addObject("nivelEstructuraList", listNivelEstructura);
		return mav;
	}
	
	
	@RequestMapping(value = "/nivel-estructura/add", method = RequestMethod.GET)
	public ModelAndView addNivelEstructura() {
		ModelAndView mav  = new ModelAndView();
		
		mav.setViewName("nivel_estructura/add");
		mav.addObject("NivelEstructura", new NivelEstructura());
		return mav;
	}
	
	@RequestMapping(value = "/nivel-estructura/add", method = RequestMethod.POST)
	public ModelAndView addNivelEstructura(
			@ModelAttribute("NivelEstructura") NivelEstructura u,
			BindingResult result,
			SessionStatus status
			) {
		
		this.nivelEstructuraValidator.validate(u,result);
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("nivel_estructura/add");
			mav.addObject("NivelEstructura", u);
			
			return mav;
		}
		
		nivelEstructuraService.add(u);
		return new ModelAndView("redirect:/nivel-estructura/index.html");
	}
	
	@RequestMapping(value = "/nivel-estructura/edit", method = RequestMethod.GET)
		public ModelAndView editNivelEstructura(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		
		NivelEstructura nivelEstructura = nivelEstructuraService.getNivelEstructura(id);
		mav.setViewName("nivel_estructura/edit");
		mav.addObject("NivelEstructura", nivelEstructura);
		
		return mav;
	}
	
	@RequestMapping(value = "/nivel-estructura/edit", method = RequestMethod.POST)
	public ModelAndView editNivelEstructura(
			@ModelAttribute("NivelEstructura") NivelEstructura u,
			BindingResult result,
			SessionStatus status,
			HttpServletRequest request
			) {
		
		this.nivelEstructuraValidator.validate(u,result);
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("nivel_estructura/edit");
			mav.addObject("NivelEstructura", u);
			
			return mav;
		}
		nivelEstructuraService.edit(u);
		return new ModelAndView("redirect:/nivel-estructura/index.html");
	}
	
	@RequestMapping(value = "/nivel-estructura/delete", method = RequestMethod.GET)
	public ModelAndView deleteNivelEstructura(HttpServletRequest request) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		nivelEstructuraService.delete(id);
		return new ModelAndView("redirect:/nivel-estructura/index.html");
	}
	
	
}
