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

import com.shuldevelop.model.NivelPuesto;
import com.shuldevelop.model.validator.NivelPuestoValidator;
import com.shuldevelop.service.NivelPuestoService;

@Controller
public class NivelPuestoController {
	
	@Autowired
	private NivelPuestoService tipoPuestoService;
	
	private NivelPuestoValidator tipoPuestoValidator;

	public NivelPuestoController() {
		this.tipoPuestoValidator = new NivelPuestoValidator();
	}
	
	@RequestMapping(value = "/nivel-puesto/index", method = RequestMethod.GET)
	public ModelAndView tipoPuesto() {
		
		ModelAndView mav = new ModelAndView();
		
		List<NivelPuesto> listTipoPuesto = tipoPuestoService.getAllTipoPuesto();
		
		mav.setViewName("nivel_puesto/index");
		mav.addObject("tipoPuestoList", listTipoPuesto);
		
		return mav;
	}
	
	@RequestMapping(value = "/nivel-puesto/add", method = RequestMethod.GET)
	public ModelAndView addTipoPuesto() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("nivel_puesto/add");
		mav.addObject("TipoPuesto", new NivelPuesto());
		
		return mav;
	}
	
	@RequestMapping(value = "/nivel-puesto/add", method = RequestMethod.POST)
	public ModelAndView addTipoPuesto(
			@ModelAttribute("TipoPuesto") NivelPuesto u,
			BindingResult result,
			SessionStatus status
 			) {
		
		this.tipoPuestoValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("nivel_puesto/add");
			mav.addObject("TipoPuesto", new NivelPuesto());
			
			return mav;
		}
		
		tipoPuestoService.add(u);
		
		return new ModelAndView("redirect:/nivel-puesto/index.html");
	}
	
	@RequestMapping(value = "/nivel-puesto/edit", method = RequestMethod.GET)
	public ModelAndView editTipoPuesto(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		
		NivelPuesto tipoPuesto = tipoPuestoService.getTipoPuesto(id);
		
		mav.setViewName("nivel_puesto/edit");
		mav.addObject("TipoPuesto", tipoPuesto);
		
		return mav;
	}
	
	@RequestMapping(value = "/nivel-puesto/edit", method = RequestMethod.POST)
	public ModelAndView editTipoPuesto(
			@ModelAttribute("TipoPuesto") NivelPuesto u,
			BindingResult result,
			SessionStatus status,
			HttpServletRequest request
 			) {
		
		this.tipoPuestoValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			int id = Integer.parseInt(request.getParameter("id"));
			
			NivelPuesto tipoPuesto = tipoPuestoService.getTipoPuesto(id);
			
			mav.setViewName("nivel_puesto/edit");
			mav.addObject("TipoPuesto", tipoPuesto);
			
			return mav;
		}
		
		tipoPuestoService.edit(u);
		
		return new ModelAndView("redirect:/nivel-puesto/index.html");
	}
	
	@RequestMapping(value = "/nivel-puesto/delete", method = RequestMethod.GET)
	public ModelAndView deleteTipoPuesto(HttpServletRequest request) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		tipoPuestoService.delete(id);
		
		return new ModelAndView("redirect:/nivel-puesto/index.html");
	}

}
