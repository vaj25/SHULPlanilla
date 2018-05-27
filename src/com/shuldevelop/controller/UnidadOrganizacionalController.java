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

import com.shuldevelop.model.UnidadOrganizacional;
import com.shuldevelop.model.validator.UnidadOrganizacionalValidator;
import com.shuldevelop.service.UnidadOrganizacionalService;

@Controller
public class UnidadOrganizacionalController {
	@Autowired
	private UnidadOrganizacionalService unidadOrganizacionalService;
	private UnidadOrganizacionalValidator unidadOrganizacionalValidator;
	
	public UnidadOrganizacionalController() {
		this.unidadOrganizacionalValidator = new UnidadOrganizacionalValidator();
	}
	
	@RequestMapping(value = "/unidad-organizacional/index", method = RequestMethod.GET)
	public ModelAndView unidadOrganizacional() {
		ModelAndView mav = new ModelAndView();
		List<UnidadOrganizacional> listUnidadOrganizacional = unidadOrganizacionalService.getAllUnidadOrganizacional();
		mav.setViewName("unidad_organizacional/index");
		mav.addObject("unidadOrganizacionalList",listUnidadOrganizacional);
		return mav;
	}
	
	@RequestMapping(value = "/unidad-organizacional/add", method = RequestMethod.GET)
	public ModelAndView addUnidadOrganizacional() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("unidad_organizacional/add");
		mav.addObject("UnidadOrganizacional", new UnidadOrganizacional());
		return mav;
	}
	
	@RequestMapping(value = "/unidad-organizacional/add", method = RequestMethod.POST)
	public ModelAndView addUnidadOrganizacional(@ModelAttribute("UnidadOrganizacional") UnidadOrganizacional u,
			BindingResult result,
			SessionStatus status) {
		
		this.unidadOrganizacionalValidator.validate(u, result);
		if(result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("unidad_organizacional/add");
			mav.addObject("UnidadOrganizacional", u);
			
			return mav;
		}
		unidadOrganizacionalService.add(u);
		return new ModelAndView("redirect:/unidad-organizacional/index.html");
	}
	
	@RequestMapping(value = "/unidad-organizacional/edit", method = RequestMethod.GET)
	public ModelAndView editUnidadOrganizacional(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		UnidadOrganizacional unidadOrganizacional = unidadOrganizacionalService.getUnidadOrganizacional(id);
		mav.setViewName("unidad_organizacional/edit");
		mav.addObject("UnidadOrganizacional", unidadOrganizacional);
		return mav;
	}
	
	@RequestMapping(value = "/unidad-organizacional/edit", method = RequestMethod.POST)
	public ModelAndView editUnidadOrganizacional(
			@ModelAttribute("UnidadOrganizacional") UnidadOrganizacional u,
			BindingResult result,
			SessionStatus status,
			HttpServletRequest request
			) {
		this.unidadOrganizacionalValidator.validate(u, result);
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("unidad_organizacional/edit");
			mav.addObject("UnidadOrganizacional", u);
			
			return mav;
		}
		unidadOrganizacionalService.edit(u);
		return new ModelAndView("redirect:/unidad-organizacional/index.html");
	}
	
	@RequestMapping(value = "/unidad-organizacional/delete", method = RequestMethod.GET)
	public ModelAndView deleteUnidadOrganizacional(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		unidadOrganizacionalService.delete(id);
		return new ModelAndView("redirect:/unidad-organizacional/index.html");
	}
	
		
	
}
