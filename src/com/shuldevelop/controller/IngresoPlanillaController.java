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

import com.shuldevelop.model.IngresoPlanilla;
import com.shuldevelop.model.IngresoPlanillaId;
import com.shuldevelop.model.PlanillaEmpleado;
import com.shuldevelop.model.TipoIngreso;
import com.shuldevelop.service.IngresoPlanillaService;
import com.shuldevelop.service.PlanillaEmpleadoService;
import com.shuldevelop.service.TipoIngresoService;

@Controller
public class IngresoPlanillaController {
	
	@Autowired
	private IngresoPlanillaService ingresoPlanillaService;

	@Autowired
	private PlanillaEmpleadoService planillaEmpleadoService;
	
	@Autowired
	private TipoIngresoService tipoIngresoService;
	
	@RequestMapping(value = "/ingreso-planilla/index", method = RequestMethod.GET)
	public ModelAndView ingresoPlanilla(HttpServletRequest request) {
		
		if ( request.getParameter("id") != null ) {
			
			ModelAndView mav = new ModelAndView();
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			IngresoPlanilla ingresoPlanilla = new IngresoPlanilla();
			
//			if (request.getParameter("idi") != null && !request.getParameter("idi").isEmpty()) {
//				
//				int idi = Integer.parseInt(request.getParameter("idi"));
//				
//				IngresoPlanillaId ingresoPlanillaId = new IngresoPlanillaId();
//				
//				ingresoPlanillaId.setPlanillaEmpleado( planillaEmpleadoService.getPlanillaEmpleado(id) );
//				ingresoPlanillaId.setTipoIngreso( tipoIngresoService.getTipoIngreso(idi) );
//				
//				ingresoPlanilla = ingresoPlanillaService.getIngresoPlanilla(ingresoPlanillaId);
//			}
			
			PlanillaEmpleado planillaEmpleado = planillaEmpleadoService.getPlanillaEmpleado(id);
			List<PlanillaEmpleado> listPlanillaEmpleado = planillaEmpleadoService.getAllPlanillaEmpleado();
			List<TipoIngreso> listTipoIngreso = tipoIngresoService.getAllTipoIngreso();
			List<IngresoPlanilla> listIngresoPlanilla = ingresoPlanillaService.getAllIngresoPlanilla();
			
			
			mav.setViewName("ingreso_planilla/index");
			mav.addObject("IngresoPlanilla", ingresoPlanilla);
			mav.addObject("tipoIngresoList", listTipoIngreso);
			mav.addObject("planillaEmpleado", planillaEmpleado);
			mav.addObject("ingresoPlanillaList", listIngresoPlanilla);
			mav.addObject("planillaEmpleadoList", listPlanillaEmpleado);
			
			
			return mav;
			
		}
		
		return new ModelAndView("redirect:/welcome.html");
		
	}
	
	@RequestMapping(value = "/ingreso-planilla/index", method = RequestMethod.POST)
	public ModelAndView ingresoPlanilla(
			@ModelAttribute("IngresoPlanilla") IngresoPlanilla u,
			BindingResult result,
			SessionStatus status
			) {
				
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			PlanillaEmpleado planillaEmpleado = planillaEmpleadoService.getPlanillaEmpleado( u.getPlanillaEmpleado().getId() );
			List<TipoIngreso> listTipoIngreso = tipoIngresoService.getAllTipoIngreso();
			List<IngresoPlanilla> listIngresoPlanilla = ingresoPlanillaService.getAllIngresoPlanilla();
			
			mav.setViewName("ingreso_planilla/index");
			mav.addObject("IngresoPlanilla", u);
			mav.addObject("tipoIngresoList", listTipoIngreso);
			mav.addObject("planillaEmpleado", planillaEmpleado);
			mav.addObject("ingresoPlanillaList", listIngresoPlanilla);
			
			return mav;
		}
		
		u.setPlanillaEmpleado(
			planillaEmpleadoService.getPlanillaEmpleado(u.getPlanillaEmpleado().getId())
		);
		
		u.setTipoIngreso(
			tipoIngresoService.getTipoIngreso(u.getTipoIngreso().getId())
		);
		
		ingresoPlanillaService.add(u);
		
		return new ModelAndView("redirect:/ingreso-planilla/index.html");
		
	}


}
