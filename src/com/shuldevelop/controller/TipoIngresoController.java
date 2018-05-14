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

import com.shuldevelop.model.TipoIngreso;
import com.shuldevelop.service.TipoIngresoService;

@Controller
public class TipoIngresoController {

	@Autowired
	private TipoIngresoService tipoIngresoService;
	
	@RequestMapping(value = "/tipo-ingreso/index", method = RequestMethod.GET)
	public ModelAndView tipoIngreso() {
		
		ModelAndView mav = new ModelAndView();
		
		List<TipoIngreso> listTipoIngreso = tipoIngresoService.getAllTipoIngreso();
		
		mav.setViewName("tipo_ingreso/index");
		mav.addObject("tipoIngresonList", listTipoIngreso);
		
		return mav;
	}
	
	@RequestMapping(value = "/tipo-ingreso/add", method = RequestMethod.GET)
	public ModelAndView addTipoIngreso() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("tipo_ingreso/add");
		mav.addObject("TipoIngreso", new TipoIngreso());
		
		return mav;
	}
	
	@RequestMapping(value = "/tipo-ingreso/add", method = RequestMethod.POST)
	public ModelAndView addTipoIngreso(
			@ModelAttribute("TipoIngreso") TipoIngreso u,
			BindingResult result,
			SessionStatus status
 			) {
		
//		this.tipoPuestoValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("tipo_ingreso/add");
			mav.addObject("TipoIngreso", u);
			
			return mav;
		}
		
		tipoIngresoService.add(u);
		
		return new ModelAndView("redirect:/tipo-ingreso/index.html");
	}
	
	@RequestMapping(value = "/tipo-ingreso/edit", method = RequestMethod.GET)
	public ModelAndView editTipoIngreso(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		
		TipoIngreso tipoIngreso = tipoIngresoService.getTipoIngreso(id);
		
		mav.setViewName("tipo_ingreso/edit");
		mav.addObject("TipoIngreso", tipoIngreso);
		
		return mav;
	}
	
	@RequestMapping(value = "/tipo-ingreso/edit", method = RequestMethod.POST)
	public ModelAndView editTipoIngreso(
			@ModelAttribute("TipoIngreso") TipoIngreso u,
			BindingResult result,
			SessionStatus status,
			HttpServletRequest request
 			) {
		
//		this.tipoPuestoValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
						
			mav.setViewName("tipo_ingreso/edit");
			mav.addObject("TipoIngreso", u);
			
			return mav;
		}
		
		tipoIngresoService.edit(u);
		
		return new ModelAndView("redirect:/tipo-ingreso/index.html");
	}
	
	@RequestMapping(value = "/tipo-ingreso/delete", method = RequestMethod.GET)
	public ModelAndView deleteTipoIngreso(HttpServletRequest request) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		tipoIngresoService.delete(id);
		
		return new ModelAndView("redirect:/rtipo-ingreso/index.html");
	}
	
}
