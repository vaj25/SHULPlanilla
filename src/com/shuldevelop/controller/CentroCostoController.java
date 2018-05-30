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

import com.shuldevelop.model.CentroCosto;
import com.shuldevelop.model.validator.CentroCostoValidator;
import com.shuldevelop.service.CentroCostoService;

@Controller
public class CentroCostoController {

	@Autowired
	private CentroCostoService centroCostoService;
	
	@RequestMapping(value = "/centro-costo1/index", method = RequestMethod.GET)
	public ModelAndView centroCosto() {
		
		ModelAndView mav = new ModelAndView();
		
		List<CentroCosto> listCentroCosto= centroCostoService.getAllCentroCosto();
		
		mav.setViewName("centro_costo/index");
		mav.addObject("centroCostoList", listCentroCosto);
		
		return mav;
	}
	
	@RequestMapping(value = "/centro-costo1/add", method = RequestMethod.GET)
	public ModelAndView addCentroCosto() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("centro_costo/add");
		mav.addObject("CentroCosto", new CentroCosto());
		
		return mav;
	}
	
	@RequestMapping(value = "/centro-costo1/add", method = RequestMethod.POST)
	public ModelAndView addCentoCosto(
			@ModelAttribute("CentroCosto") CentroCosto u,
			BindingResult result,
			SessionStatus status
 			) {
		
		//this.centroCostoValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("centro_costo/add");
			mav.addObject("CentroCosto", u);
			
			return mav;
		}
		
		centroCostoService.add(u);
		
		return new ModelAndView("redirect:/centro-costo/index.html");
	}
	
	@RequestMapping(value = "/centro-costo1/edit", method = RequestMethod.GET)
	public ModelAndView editCentroCosto(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		
		CentroCosto centroCosto = centroCostoService.getCentroCosto(id);
		
		mav.setViewName("centro_costo/edit");
		mav.addObject("CentroCosto", centroCosto);
		
		return mav;
	}
	
	@RequestMapping(value = "/centro-costo1/edit", method = RequestMethod.POST)
	public ModelAndView editCentroCosto(
			@ModelAttribute("CentroCosto") CentroCosto u,
			BindingResult result,
			SessionStatus status,
			HttpServletRequest request
 			) {
		
		//this.centroCostoValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
				
			mav.setViewName("centro_costo/edit");
			mav.addObject("CentroCosto", u);
			
			return mav;
		}
		
		centroCostoService.edit(u);
		
		return new ModelAndView("redirect:/centroCosto/index.html");
	}
	
	
	@RequestMapping(value = "/centro-costo/delete", method = RequestMethod.GET)
	public ModelAndView deleteCentroCosto(HttpServletRequest request) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		centroCostoService.delete(id);
		
		return new ModelAndView("redirect:/centro-costo/index.html");
	}
	
	
	
}
