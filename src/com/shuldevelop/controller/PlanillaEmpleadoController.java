package com.shuldevelop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.shuldevelop.model.Departamento;
import com.shuldevelop.model.Empleado;
import com.shuldevelop.model.EstadoCivil;
import com.shuldevelop.model.Genero;
import com.shuldevelop.model.Municipio;
import com.shuldevelop.model.PlanillaEmpleado;
import com.shuldevelop.model.ProfesionOficio;
import com.shuldevelop.model.TipoDocIdentidad;
import com.shuldevelop.model.Zona;
import com.shuldevelop.service.EmpleadoService;
import com.shuldevelop.service.PlanillaEmpleadoService;

@Controller
public class PlanillaEmpleadoController {

	@Autowired
	private PlanillaEmpleadoService planillaEmpleadoService;
	@Autowired
	
	private EmpleadoService empleadoService;
	
	@RequestMapping(value = "/planilla-empleado/index", method = RequestMethod.GET)
	public ModelAndView planillaEmpleado(@RequestParam("id") int idPlanilla) {
		ModelAndView mav = new ModelAndView();

		List<PlanillaEmpleado> listPlanillaEmpleado = planillaEmpleadoService.getAllPlanillaEmpleado(idPlanilla);
		
		mav.setViewName("planilla_empleado/index");
		mav.addObject("planillaEmpleadoList", listPlanillaEmpleado);
		mav.addObject("idPl", idPlanilla);
		
		return mav;
	}
	
	@RequestMapping(value = "/planilla-empleado/add", method = RequestMethod.GET)
	public ModelAndView addPlanillaEmpleado(@RequestParam("id") int idPlanilla) {
		
		ModelAndView mav = new ModelAndView();	

		List<Empleado> ListEmpleado = empleadoService.getAllEmpleado();	

		mav.addObject("empleadoList", ListEmpleado);		
		mav.setViewName("planilla_empleado/add");
		mav.addObject("PlanillaEmpleado", new PlanillaEmpleado());
		mav.addObject("idPl", idPlanilla);
		
		return mav;
	}
	
	@RequestMapping(value = "/planilla-empleado/add", method = RequestMethod.POST)
	public ModelAndView addPlanillaEmpleado(
			@ModelAttribute("PlanillaEmpleado") PlanillaEmpleado u,
			BindingResult result,
			SessionStatus status
 			) {
		
//		this.tipoDocIdentidadValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("planilla_empleado/add");
			mav.addObject("PlanillaEmpleado", u);
			
			return mav;
		}
		
		planillaEmpleadoService.add(u);
		
		return new ModelAndView("redirect:/planilla-empleado/index.html");
	}
	
	@RequestMapping(value = "/planilla-empleado/edit", method = RequestMethod.GET)
	public ModelAndView editPlanillaEmpleado(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		
		PlanillaEmpleado planillaEmpleado = planillaEmpleadoService.getPlanillaEmpleado(id);
		
		mav.setViewName("planilla_empleado/edit");
		mav.addObject("PlanillaEmpleado", planillaEmpleado);
		
		return mav;
	}
	
	@RequestMapping(value = "/planilla-empleado/edit", method = RequestMethod.POST)
	public ModelAndView editPlanillaEmpleado(
			@ModelAttribute("PlanillaEmpleado") PlanillaEmpleado u,
			BindingResult result,
			SessionStatus status,
			HttpServletRequest request
 			) {
		
//		this.tipoDocIdentidadValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("planilla_empleado/edit");
			mav.addObject("PlanillaEmpleado", u);
			
			return mav;
		}
		
		planillaEmpleadoService.edit(u);
		
		return new ModelAndView("redirect:/planilla-empleado/index.html");
	}
	
	@RequestMapping(value = "/planilla-empleado/delete", method = RequestMethod.GET)
	public ModelAndView deletePlanillaEmpleado(HttpServletRequest request) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		planillaEmpleadoService.delete(id);
		
		return new ModelAndView("redirect:/planilla-empleado/index.html");
	}
	
}
