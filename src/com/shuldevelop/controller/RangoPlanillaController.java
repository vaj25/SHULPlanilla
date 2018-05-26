package com.shuldevelop.controller;

import javax.servlet.http.HttpServletRequest;

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
import com.shuldevelop.model.RangoPlanillaId;
import com.shuldevelop.service.PlanillaEmpleadoService;
import com.shuldevelop.service.RangoComisionService;
import com.shuldevelop.service.RangoPlanillaService;

@Controller
public class RangoPlanillaController {

	@Autowired
	private RangoPlanillaService rangoPlanillaService;

	@Autowired
	private PlanillaEmpleadoService planillaEmpleadoService;
	
	@Autowired
	private RangoComisionService rangoComisionService;
	
	@RequestMapping(value = "/rango-planilla/index", method = RequestMethod.GET)
	public ModelAndView rangoComision(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		
		int idPlanilla = Integer.parseInt(request.getParameter("id_planilla"));
		
		int idRango = 1;
		
		RangoPlanilla rangoPlanilla = rangoPlanillaService.getRangoPlanillaByPlanilla(idPlanilla);
		
		RangoPlanillaId rangoPlanillaId = new RangoPlanillaId();
		
		if (rangoPlanilla == null) {

			rangoPlanilla = new RangoPlanilla();
			
			rangoPlanillaId.setPlanillaEmpleado(planillaEmpleadoService.getPlanillaEmpleado(idPlanilla));
			
			rangoPlanillaId.setRangoComision(rangoComisionService.getRangoComision(idRango));
			
			rangoPlanilla.setId(rangoPlanillaId);
			
		} else {
			
			rangoPlanillaId = rangoPlanilla.getId();
		}
		
		mav.setViewName("rango_planilla/index");
		mav.addObject("RangoPlanilla", rangoPlanilla);
		mav.addObject("RangoPlanillaId", rangoPlanillaId);
		
		return mav;
		
	}
	
	@RequestMapping(value = "/rango-planilla/index", method = RequestMethod.POST)
	public ModelAndView rangoComision(
			@ModelAttribute("RangoPlanilla") RangoPlanilla u,
			BindingResult result,
			SessionStatus status
			) {
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			RangoPlanillaId rangoPlanillaId = new RangoPlanillaId();
			
			rangoPlanillaId.setPlanillaEmpleado(planillaEmpleadoService.getPlanillaEmpleado( u.getPlanillaEmpleado().getId() ));
			rangoPlanillaId.setRangoComision(rangoComisionService.getRangoComision( u.getRangoComision().getId() ));
			
			u.setId(rangoPlanillaId);
			
			mav.setViewName("rango_planilla/index");
			mav.addObject("RangoPlanilla", u);
			
			return mav;
		}
		
		u.setPlanillaEmpleado(
			planillaEmpleadoService.getPlanillaEmpleado(u.getPlanillaEmpleado().getId())
		);
		
		u.setRangoComision(
			rangoComisionService.getRangoComision(u.getRangoComision().getId())
		);
		
		rangoPlanillaService.add(u);
		
		return new ModelAndView("redirect:/planilla-empleado/index.html");
		
	}
	
	@RequestMapping(value = "/rango-planilla/delete", method = RequestMethod.GET)
	public ModelAndView deleteIngresoPlanilla(HttpServletRequest request) {
		
		int idPlanilla = Integer.parseInt(request.getParameter("id_planilla"));
		int idRango = Integer.parseInt(request.getParameter("id_rango"));
		
		RangoComision rangoComision = rangoComisionService.getRangoComision(idRango);
		
		PlanillaEmpleado planillaEmpleado = planillaEmpleadoService.getPlanillaEmpleado(idPlanilla);
		
		RangoPlanillaId rangoPlanillaId = new RangoPlanillaId(planillaEmpleado, rangoComision);
		
		rangoPlanillaService.delete(rangoPlanillaId);
		
		return new ModelAndView("redirect:/planilla-empleado/index.html");
	}
		
}
