package com.shuldevelop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.shuldevelop.model.PlanillaEmpleado;
import com.shuldevelop.model.RangoComision;
import com.shuldevelop.model.RangoPlanilla;
import com.shuldevelop.service.PlanillaEmpleadoService;
import com.shuldevelop.service.RangoComisionService;
import com.shuldevelop.service.RangoPlanillaService;

@Controller
public class RangoPlanillaTestController {

	@Autowired
	private RangoPlanillaService rangoPlanillaService;

	@Autowired
	private PlanillaEmpleadoService planillaEmpleadoService;
	
	@Autowired
	private RangoComisionService rangoComisionService;
	
	@RequestMapping(value = "/rango-planilla/add", method = RequestMethod.GET)
	public ModelAndView addRangoComision() {
		
		ModelAndView mav = new ModelAndView();
		
		List<PlanillaEmpleado> listPlanillaEmpleado = planillaEmpleadoService.getAllPlanillaEmpleado();
		List<RangoComision> listRangoComision = rangoComisionService.getAllRangoComision();
		
		mav.setViewName("test/add_rango_planilla");
		mav.addObject("RangoPlanilla", new RangoPlanilla());
		mav.addObject("planillaEmpleadoList", listPlanillaEmpleado);
		mav.addObject("rangoComisionList", listRangoComision);
		
		return mav;
		
	}
	
	@RequestMapping(value = "/rango-planilla/add", method = RequestMethod.POST)
	public ModelAndView addRangoComision(
			@ModelAttribute("RangoPlanilla") RangoPlanilla u,
			BindingResult result,
			SessionStatus status
			) {
				
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			List<PlanillaEmpleado> listPlanillaEmpleado = planillaEmpleadoService.getAllPlanillaEmpleado();
			List<RangoComision> listRangoComision = rangoComisionService.getAllRangoComision();
			
			mav.setViewName("test/add_rango_planilla");
			mav.addObject("RangoPlanilla", u);
			mav.addObject("planillaEmpleadoList", listPlanillaEmpleado);
			mav.addObject("rangoComisionList", listRangoComision);
			
			return mav;
		}
		
		u.setPlanillaEmpleado(
			planillaEmpleadoService.getPlanillaEmpleado(u.getPlanillaEmpleado().getId())
		);
		
		u.setRangoComision(
			rangoComisionService.getRangoComision(u.getRangoComision().getId())
		);
		
		rangoPlanillaService.add(u);
		
		return new ModelAndView("redirect:/welcome.html");
		
	}
	
	
}
