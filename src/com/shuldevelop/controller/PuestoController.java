package com.shuldevelop.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.shuldevelop.service.NivelPuestoService;
import com.shuldevelop.service.PuestoService;

@Controller
public class PuestoController {

	@Autowired
	private PuestoService puestoService;
	
	@Autowired
	private NivelPuestoService nivelPuestoService;

	public PuestoController() {
	}
	
	@RequestMapping(value = "/puesto/index", method = RequestMethod.GET)
	public ModelAndView puesto() {
		
		ModelAndView mav = new ModelAndView();
		
//		List<Puesto> listPuesto = puestoService.getAllPuesto();
		List<Puesto> listPuesto = new ArrayList<Puesto>();
		
		listPuesto.add(puestoService.getPuesto(1));
		
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
		
//		this.tipoPuestoValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			List<NivelPuesto> listTipoPuesto = nivelPuestoService.getAllTipoPuesto();
			
			mav.setViewName("puesto/add");
			mav.addObject("Puesto", u);
			mav.addObject("tipoPuestoList", listTipoPuesto);
			
			
			return mav;
		}
		
		u.getNivelPuesto().setSalario(nivelPuestoService.getTipoPuesto(u.getNivelPuesto().getId()).getSalario());
		u.getNivelPuesto().setNumeroNivel(nivelPuestoService.getTipoPuesto(u.getNivelPuesto().getId()).getNumeroNivel());
		
		puestoService.add(u);
		
		return new ModelAndView("redirect:/puesto/index.html");
	}
	
}
