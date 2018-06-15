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

import com.shuldevelop.model.DescuentoPlanilla;
import com.shuldevelop.model.Empleado;
import com.shuldevelop.model.InfoLaboralEmpleado;
import com.shuldevelop.model.IngresoPlanilla;
import com.shuldevelop.model.Modulo;
import com.shuldevelop.model.PlanillaEmpleado;
import com.shuldevelop.model.UnidadOrganizacional;
import com.shuldevelop.service.DescuentoPlanillaService;
import com.shuldevelop.service.EmpleadoService;
import com.shuldevelop.service.InfoLaboralEmpleadoService;
import com.shuldevelop.service.IngresoPlanillaService;
import com.shuldevelop.model.Usuario;
import com.shuldevelop.service.ModuloService;
import com.shuldevelop.service.PlanillaEmpleadoService;
import com.shuldevelop.service.UnidadOrganizacionalService;
import com.shuldevelop.service.UsuarioService;

@Controller
public class PlanillaEmpleadoController {

	@Autowired
	private PlanillaEmpleadoService planillaEmpleadoService;
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@Autowired
	private UnidadOrganizacionalService unidadOrganizacionalService;
	
	@Autowired
	private InfoLaboralEmpleadoService infoLaboralEmpleadoService;
	
	@Autowired
	private IngresoPlanillaService ingresoPlanillaService;
	
	@Autowired
	private DescuentoPlanillaService descuentoPlanillaService;
	
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
	
	@RequestMapping(value = "/planilla-empleado/boleta", method = RequestMethod.GET)
	public ModelAndView boletaPlanillaEmpleado(HttpServletRequest request,
			final RedirectAttributes redirectAttributes) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		PlanillaEmpleado planillaEmpleado = planillaEmpleadoService.getPlanillaEmpleado(id);
		
		UnidadOrganizacional org = unidadOrganizacionalService.getUnidadOrganizacional(1);
		
		InfoLaboralEmpleado info = infoLaboralEmpleadoService.getInfobyIdEmpleado( planillaEmpleado.getEmpleado().getId() );
		
		List<IngresoPlanilla> ingresos = ingresoPlanillaService.getAllIngresoPlanillaByPlanilla( planillaEmpleado.getId() );
		
		List<DescuentoPlanilla> descuentos = descuentoPlanillaService.getAllDescuentoPlanillaByPlanilla( planillaEmpleado.getId() );
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("planilla_empleado/boleta");
		mav.addObject("empleado", planillaEmpleado);
		mav.addObject("org", org);
		mav.addObject("info", info);
		mav.addObject("ingresos", ingresos);
		mav.addObject("descuentos", descuentos);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
}
