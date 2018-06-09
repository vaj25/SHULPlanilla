package com.shuldevelop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shuldevelop.model.Departamento;
import com.shuldevelop.model.Empleado;
import com.shuldevelop.model.EstadoCivil;
import com.shuldevelop.model.Genero;
import com.shuldevelop.model.Municipio;
import com.shuldevelop.model.Modulo;
import com.shuldevelop.model.PlanillaEmpleado;
import com.shuldevelop.model.ProfesionOficio;
import com.shuldevelop.model.TipoDocIdentidad;
import com.shuldevelop.model.Zona;
import com.shuldevelop.service.EmpleadoService;
import com.shuldevelop.model.Usuario;
import com.shuldevelop.service.ModuloService;
import com.shuldevelop.service.PlanillaEmpleadoService;
import com.shuldevelop.service.UsuarioService;

@Controller
public class PlanillaEmpleadoController {

	@Autowired
	private PlanillaEmpleadoService planillaEmpleadoService;
	@Autowired
	
	private EmpleadoService empleadoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ModuloService moduloService;
	
	public Usuario getUsuario() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		
		return usuarioService.findUserByUsername(userDetails.getUsername());
	}
	
	public List<Modulo> getModulos() {
		
		return moduloService.getAllModuloByRol(getUsuario().getRol().getId());
		
	}
	
	@RequestMapping(value = "/planilla-empleado/index", method = RequestMethod.GET)
	public ModelAndView planillaEmpleado(@RequestParam("id") int idPlanilla) {
		ModelAndView mav = new ModelAndView();

		List<PlanillaEmpleado> listPlanillaEmpleado = planillaEmpleadoService.getAllPlanillaEmpleado(idPlanilla);
		
		mav.setViewName("planilla_empleado/index");
		mav.addObject("planillaEmpleadoList", listPlanillaEmpleado);
		mav.addObject("idPl", idPlanilla);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
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
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
	@RequestMapping(value = "/planilla-empleado/add", method = RequestMethod.POST)
	public ModelAndView addPlanillaEmpleado(
			@ModelAttribute("PlanillaEmpleado") PlanillaEmpleado u,
			BindingResult result,
			SessionStatus status,
			final RedirectAttributes redirectAttributes
 			) {
		
//		this.tipoDocIdentidadValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("planilla_empleado/add");
			mav.addObject("PlanillaEmpleado", u);
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
			
			return mav;
		}
		
		planillaEmpleadoService.add(u);
		redirectAttributes.addFlashAttribute("messageSuccess", "Planilla Empleado se agregó exitosamente.");
		return new ModelAndView("redirect:/planilla-empleado/index.html");
	}
	
	@RequestMapping(value = "/planilla-empleado/edit", method = RequestMethod.GET)
	public ModelAndView editPlanillaEmpleado(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		
		PlanillaEmpleado planillaEmpleado = planillaEmpleadoService.getPlanillaEmpleado(id);
		
		mav.setViewName("planilla_empleado/edit");
		mav.addObject("PlanillaEmpleado", planillaEmpleado);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
	@RequestMapping(value = "/planilla-empleado/edit", method = RequestMethod.POST)
	public ModelAndView editPlanillaEmpleado(
			@ModelAttribute("PlanillaEmpleado") PlanillaEmpleado u,
			BindingResult result,
			SessionStatus status,
			HttpServletRequest request,
			final RedirectAttributes redirectAttributes
 			) {
		
//		this.tipoDocIdentidadValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("planilla_empleado/edit");
			mav.addObject("PlanillaEmpleado", u);
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
			
			return mav;
		}
		
		planillaEmpleadoService.edit(u);
		redirectAttributes.addFlashAttribute("messageSuccess", "Planilla Empleado se editó exitosamente.");
		return new ModelAndView("redirect:/planilla-empleado/index.html");
	}
	
	@RequestMapping(value = "/planilla-empleado/delete", method = RequestMethod.GET)
	public ModelAndView deletePlanillaEmpleado(HttpServletRequest request,
			final RedirectAttributes redirectAttributes) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		planillaEmpleadoService.delete(id);
		redirectAttributes.addFlashAttribute("messageSuccess", "Planilla Empleado se eliminó exitosamente.");
		return new ModelAndView("redirect:/planilla-empleado/index.html");
	}
	
}
