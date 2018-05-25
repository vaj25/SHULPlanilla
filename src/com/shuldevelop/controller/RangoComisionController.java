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

import com.shuldevelop.model.RangoComision;
import com.shuldevelop.model.validator.RangoComisionValidator;
import com.shuldevelop.service.RangoComisionService;

@Controller
public class RangoComisionController {

	@Autowired
	private RangoComisionService rangoComisionService;
	
	private RangoComisionValidator rangoComisionValidator;
	
	public RangoComisionController() {
		this.rangoComisionValidator = new RangoComisionValidator();
	}

	@RequestMapping(value = "/rango-comision/index", method = RequestMethod.GET)
	public ModelAndView rangoComision() {
		
		ModelAndView mav = new ModelAndView();
		
		List<RangoComision> listRangoComision = rangoComisionService.getAllRangoComision();
		
		mav.setViewName("rango_comision/index");
		mav.addObject("rangoComisionList", listRangoComision);
		
		return mav;
	}
	
	@RequestMapping(value = "/rango-comision/add", method = RequestMethod.GET)
	public ModelAndView addRangoComision() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("rango_comision/add");
		mav.addObject("RangoComision", new RangoComision());
		
		return mav;
	}
	
	@RequestMapping(value = "/rango-comision/add", method = RequestMethod.POST)
	public ModelAndView addRangoComision(
			@ModelAttribute("RangoComision") RangoComision u,
			BindingResult result,
			SessionStatus status
 			) {
		
		this.rangoComisionValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("rango_comision/add");
			mav.addObject("RangoComision", u);
			
			return mav;
		}
		
		rangoComisionService.add(u);
		
		return new ModelAndView("redirect:/rango-comision/index.html");
	}
	
	@RequestMapping(value = "/rango-comision/edit", method = RequestMethod.GET)
	public ModelAndView editRangoComision(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		
		RangoComision rangoComision = rangoComisionService.getRangoComision(id);
		
		mav.setViewName("rango_comision/edit");
		mav.addObject("RangoComision", rangoComision);
		
		return mav;
	}
	
	@RequestMapping(value = "/rango-comision/edit", method = RequestMethod.POST)
	public ModelAndView editRangoComision(
			@ModelAttribute("RangoComision") RangoComision u,
			BindingResult result,
			SessionStatus status,
			HttpServletRequest request
 			) {
		
		this.rangoComisionValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
						
			mav.setViewName("rango_comision/edit");
			mav.addObject("RangoComision", u);
			
			return mav;
		}
		
		rangoComisionService.edit(u);
		
		return new ModelAndView("redirect:/rango-comision/index.html");
	}
	
	@RequestMapping(value = "/rango-comision/delete", method = RequestMethod.GET)
	public ModelAndView deleteRangoComision(HttpServletRequest request) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		rangoComisionService.delete(id);
		
		return new ModelAndView("redirect:/rango-comision/index.html");
	}
	
}
