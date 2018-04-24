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
import com.shuldevelop.model.Puesto;
import com.shuldevelop.model.validator.PuestoValidator;
import com.shuldevelop.service.NivelPuestoService;
import com.shuldevelop.service.PuestoService;

@Controller
public class PuestoController {

	@Autowired
	private PuestoService puestoService;
	
	@Autowired
	private NivelPuestoService nivelPuestoService;
	
	private PuestoValidator puestoValidator;

	public PuestoController() {
		puestoValidator = new PuestoValidator();
	}
	
	@RequestMapping(value = "/puesto/index", method = RequestMethod.GET)
	public ModelAndView puesto() {
		
		ModelAndView mav = new ModelAndView();
		
		List<Puesto> listPuesto = puestoService.getAllPuesto();
		
		mav.setViewName("puesto/index");
		mav.addObject("puestoList", listPuesto);
		
		return mav;
	}
	
	@RequestMapping(value = "/puesto/add", method = RequestMethod.GET)
	public ModelAndView addPuesto() {
		
		ModelAndView mav = new ModelAndView();
		
		List<NivelPuesto> listTipoPuesto = nivelPuestoService.getAllTipoPuesto();
		
		mav.setViewName("puesto/add");
		mav.addObject("Puesto", new Puesto());
		mav.addObject("tipoPuestoList", listTipoPuesto);
		
		
		return mav;
	}
	
	@RequestMapping(value = "/puesto/add", method = RequestMethod.POST)
	public ModelAndView addPuesto(
			@ModelAttribute("Puesto") Puesto u,
			BindingResult result,
			SessionStatus status
 			) {
		
		this.puestoValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			List<NivelPuesto> listTipoPuesto = nivelPuestoService.getAllTipoPuesto();
			
			mav.setViewName("puesto/add");
			mav.addObject("Puesto", u);
			mav.addObject("tipoPuestoList", listTipoPuesto);
			
			
			return mav;
		}
		
		u.getNivelPuesto().setSalario(nivelPuestoService.getTipoPuesto(
				u.getNivelPuesto().getId()).getSalario());
		u.getNivelPuesto().setNumeroNivel(nivelPuestoService.getTipoPuesto(
				u.getNivelPuesto().getId()).getNumeroNivel());
		
		puestoService.add(u);
		
		return new ModelAndView("redirect:/puesto/index.html");
	}
	
	@RequestMapping(value = "/puesto/edit", method = RequestMethod.GET)
	public ModelAndView editPuesto(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		
		Puesto puesto = puestoService.getPuesto(id);
		
		List<NivelPuesto> listTipoPuesto = nivelPuestoService.getAllTipoPuesto();
		
		mav.setViewName("puesto/edit");
		mav.addObject("Puesto", puesto);
		mav.addObject("tipoPuestoList", listTipoPuesto);
		
		return mav;
	}
	
	@RequestMapping(value = "/puesto/edit", method = RequestMethod.POST)
	public ModelAndView editPuesto(
			@ModelAttribute("Puesto") Puesto u,
			BindingResult result,
			SessionStatus status,
			HttpServletRequest request
 			) {
		
		this.puestoValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			List<NivelPuesto> listTipoPuesto = nivelPuestoService.getAllTipoPuesto();
			
			mav.setViewName("nivel_puesto/edit");
			mav.addObject("Puesto", u);
			mav.addObject("tipoPuestoList", listTipoPuesto);
			
			return mav;
		}
		
		puestoService.edit(u);
		
		return new ModelAndView("redirect:/puesto/index.html");
	}
	
	@RequestMapping(value = "/puesto/delete", method = RequestMethod.GET)
	public ModelAndView deletePuesto(HttpServletRequest request) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		puestoService.delete(id);
		
		return new ModelAndView("redirect:/puesto/index.html");
	}
	
	
}
