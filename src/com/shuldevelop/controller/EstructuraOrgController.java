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

import com.shuldevelop.model.EstructuraOrg;
import com.shuldevelop.service.EstructuraOrgService;

@Controller
public class EstructuraOrgController {

	@Autowired
	private EstructuraOrgService EstructuraOrgService;
	
	@RequestMapping(value = "/estructura-org/index", method = RequestMethod.GET)
	public ModelAndView estructuraOrg() {
		
		ModelAndView mav = new ModelAndView();
		
		List<EstructuraOrg> listEstructuraOrg= EstructuraOrgService.getAllEstructuraOrg();
		
		mav.setViewName("estructura-org/index");
		mav.addObject("estructuraOrgList", listEstructuraOrg);
		
		return mav;
	}
	
	@RequestMapping(value = "/estructura-org/add", method = RequestMethod.GET)
	public ModelAndView addCentroCosto() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("estructura-org/add");
		mav.addObject("EstructuraOrg", new EstructuraOrg());
		
		return mav;
	}
	
	@RequestMapping(value = "/estructura-org/add", method = RequestMethod.POST)
	public ModelAndView addEstructuraOrg(
			@ModelAttribute("EstructuraOrg") EstructuraOrg u,
			BindingResult result,
			SessionStatus status
 			) {
		
		//this.centroCostoValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("estructura-org/add");
			mav.addObject("EstructuraOrg", u);
			
			return mav;
		}
		
		EstructuraOrgService.add(u);
		
		return new ModelAndView("redirect:/estructura-org/index.html");
	}
	
	@RequestMapping(value = "/estructura-org/edit", method = RequestMethod.GET)
	public ModelAndView editCentroCosto(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		
		EstructuraOrg estructuraOrg = EstructuraOrgService.getEstructuraOrg(id);
		
		mav.setViewName("estructura-org/edit");
		mav.addObject("EstructuraOrg", estructuraOrg);
		
		return mav;
	}
	
	@RequestMapping(value = "/estructura-org/edit", method = RequestMethod.POST)
	public ModelAndView editCentroCosto(
			@ModelAttribute("EstructuraOrg") EstructuraOrg u,
			BindingResult result,
			SessionStatus status,
			HttpServletRequest request
 			) {
		
		//this.centroCostoValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
				
			mav.setViewName("estructura-org/edit");
			mav.addObject("EstructuraOrg", u);
			
			return mav;
		}
		
		EstructuraOrgService.edit(u);
		
		return new ModelAndView("redirect:/estructuraOrg/index.html");
	}
	
	
	@RequestMapping(value = "/estructura-org/delete", method = RequestMethod.GET)
	public ModelAndView deleteCentroCosto(HttpServletRequest request) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		EstructuraOrgService.delete(id);
		
		return new ModelAndView("redirect:/estructura-org/index.html");
	}
	
	
}
