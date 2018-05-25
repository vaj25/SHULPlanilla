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

import com.shuldevelop.model.IngresoPlanilla;
import com.shuldevelop.model.PlanillaEmpleado;
import com.shuldevelop.model.TipoIngreso;
import com.shuldevelop.service.IngresoPlanillaService;
import com.shuldevelop.service.PlanillaEmpleadoService;
import com.shuldevelop.service.TipoIngresoService;

@Controller
public class IngresoPlanillaTestController {
	
	@Autowired
	private IngresoPlanillaService ingresoPlanillaService;

	@Autowired
	private PlanillaEmpleadoService planillaEmpleadoService;
	
	@Autowired
	private TipoIngresoService tipoIngresoService;
	
	@RequestMapping(value = "/ingreso-planilla/add", method = RequestMethod.GET)
	public ModelAndView addIngresoPlanilla() {
		
		ModelAndView mav = new ModelAndView();
		
		List<PlanillaEmpleado> listPlanillaEmpleado = planillaEmpleadoService.getAllPlanillaEmpleado();
		List<TipoIngreso> listTipoIngreso = tipoIngresoService.getAllTipoIngreso();
		
		mav.setViewName("test/add_ingreso_planilla");
		mav.addObject("IngresoPlanilla", new IngresoPlanilla());
		mav.addObject("planillaEmpleadoList", listPlanillaEmpleado);
		mav.addObject("tipoIngresoList", listTipoIngreso);
		
		return mav;
		
	}
	
	@RequestMapping(value = "/ingreso-planilla/add", method = RequestMethod.POST)
	public ModelAndView addIngresoPlanilla(
			@ModelAttribute("IngresoPlanilla") IngresoPlanilla u,
			BindingResult result,
			SessionStatus status
			) {
				
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			List<PlanillaEmpleado> listPlanillaEmpleado = planillaEmpleadoService.getAllPlanillaEmpleado();
			List<TipoIngreso> listTipoIngreso = tipoIngresoService.getAllTipoIngreso();
			
			mav.setViewName("test/add_ingreso_planilla");
			mav.addObject("IngresoPlanilla", new IngresoPlanilla());
			mav.addObject("planillaEmpleadoList", listPlanillaEmpleado);
			mav.addObject("tipoIngresoList", listTipoIngreso);
			
			return mav;
		}
		
		u.setPlanillaEmpleado(
			planillaEmpleadoService.getPlanillaEmpleado(u.getPlanillaEmpleado().getId())
		);
		
		u.setTipoIngreso(
			tipoIngresoService.getTipoIngreso(u.getTipoIngreso().getId())
		);
		
		ingresoPlanillaService.add(u);
		
		return new ModelAndView("redirect:/welcome.html");
		
	}


}
