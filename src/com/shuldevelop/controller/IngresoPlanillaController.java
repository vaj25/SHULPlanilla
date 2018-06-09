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
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shuldevelop.model.IngresoPlanilla;
import com.shuldevelop.model.IngresoPlanillaId;
import com.shuldevelop.model.Modulo;
import com.shuldevelop.model.PlanillaEmpleado;
import com.shuldevelop.model.TipoIngreso;
import com.shuldevelop.model.Usuario;
import com.shuldevelop.model.validator.IngresoPlanillaValidator;
import com.shuldevelop.service.IngresoPlanillaService;
import com.shuldevelop.service.ModuloService;
import com.shuldevelop.service.PlanillaEmpleadoService;
import com.shuldevelop.service.TipoIngresoService;
import com.shuldevelop.service.UsuarioService;

@Controller
public class IngresoPlanillaController {
	
	@Autowired
	private IngresoPlanillaService ingresoPlanillaService;

	@Autowired
	private PlanillaEmpleadoService planillaEmpleadoService;
	
	@Autowired
	private TipoIngresoService tipoIngresoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ModuloService moduloService;
	
	private IngresoPlanillaValidator ingresoPlanillaValidator;
	
	public IngresoPlanillaController() {
		this.ingresoPlanillaValidator = new IngresoPlanillaValidator();
	}
	
	public Usuario getUsuario() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		
		return usuarioService.findUserByUsername(userDetails.getUsername());
	}
	
	public List<Modulo> getModulos() {
		
		return moduloService.getAllModuloByRol(getUsuario().getRol().getId());
		
	}

	@RequestMapping(value = "/ingreso-planilla/index", method = RequestMethod.GET)
	public ModelAndView ingresoPlanilla(HttpServletRequest request) {
		
		if ( request.getParameter("id") != null ) {
			
			ModelAndView mav = new ModelAndView();
			
			int id = Integer.parseInt(request.getParameter("id"));
			int idPl = Integer.parseInt(request.getParameter("id_pl"));
			
			IngresoPlanilla ingresoPlanilla = new IngresoPlanilla();		
			
			if (request.getParameter("idi") != null) {
				int idi = Integer.parseInt(request.getParameter("idi"));
				
				IngresoPlanillaId ingresoPlanillaId = new IngresoPlanillaId();
				
				ingresoPlanillaId.setPlanillaEmpleado( planillaEmpleadoService.getPlanillaEmpleado(id) );
				ingresoPlanillaId.setTipoIngreso( tipoIngresoService.getTipoIngreso(idi) );
				
				ingresoPlanilla = ingresoPlanillaService.getIngresoPlanilla(ingresoPlanillaId);
				
				System.out.println(ingresoPlanilla.getMonto());
			}
			
			PlanillaEmpleado planillaEmpleado = planillaEmpleadoService.getPlanillaEmpleado(id);
			List<TipoIngreso> listTipoIngreso = tipoIngresoService.getAllTipoIngreso();
			List<IngresoPlanilla> listIngresoPlanilla = ingresoPlanillaService.getAllIngresoPlanillaByPlanilla(id);
			
			
			mav.setViewName("ingreso_planilla/index");
			mav.addObject("IngresoPlanilla", ingresoPlanilla);
			mav.addObject("tipoIngresoList", listTipoIngreso);
			mav.addObject("planillaEmpleado", planillaEmpleado);
			mav.addObject("ingresoPlanillaList", listIngresoPlanilla);
			mav.addObject("idPl", idPl);
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
			
			return mav;
			
		}
		
		return new ModelAndView("redirect:/welcome.html");
		
	}
	
	@RequestMapping(value = "/ingreso-planilla/index", method = RequestMethod.POST)
	public ModelAndView ingresoPlanilla(
			@ModelAttribute("IngresoPlanilla") IngresoPlanilla u,
			BindingResult result,
			SessionStatus status,
			final RedirectAttributes redirectAttributes
			) {
				
		ingresoPlanillaValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			PlanillaEmpleado planillaEmpleado = planillaEmpleadoService.getPlanillaEmpleado( u.getPlanillaEmpleado().getId() );
			List<TipoIngreso> listTipoIngreso = tipoIngresoService.getAllTipoIngreso();
			List<IngresoPlanilla> listIngresoPlanilla = ingresoPlanillaService.getAllIngresoPlanillaByPlanilla(u.getPlanillaEmpleado().getId());
			
			mav.setViewName("ingreso_planilla/index");
			mav.addObject("IngresoPlanilla", u);
			mav.addObject("tipoIngresoList", listTipoIngreso);
			mav.addObject("planillaEmpleado", planillaEmpleado);
			mav.addObject("ingresoPlanillaList", listIngresoPlanilla);
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
			
			return mav;
		}
		
		u.setPlanillaEmpleado(
			planillaEmpleadoService.getPlanillaEmpleado(u.getPlanillaEmpleado().getId())
		);
		
		u.setTipoIngreso(
			tipoIngresoService.getTipoIngreso(u.getTipoIngreso().getId())
		);
		
		ingresoPlanillaService.add(u);
		redirectAttributes.addFlashAttribute("messageSuccess", "La Planilla se agregó exitosamente.");
		return new ModelAndView("redirect:/ingreso-planilla/index.html?id="+u.getPlanillaEmpleado().getId());
		
	}
	
	@RequestMapping(value = "/ingreso-planilla/delete", method = RequestMethod.GET)
	public ModelAndView deleteIngresoPlanilla(HttpServletRequest request,
			final RedirectAttributes redirectAttributes) {
		
		int idPlanilla = Integer.parseInt(request.getParameter("id_planilla"));
		int idIngreso = Integer.parseInt(request.getParameter("id_ingreso"));
		
		TipoIngreso tipoIngreso = tipoIngresoService.getTipoIngreso(idIngreso);
		
		PlanillaEmpleado planillaEmpleado = planillaEmpleadoService.getPlanillaEmpleado(idPlanilla);
		
		IngresoPlanillaId ingresoPlanillaId = new IngresoPlanillaId(planillaEmpleado, tipoIngreso);
		
		ingresoPlanillaService.delete(ingresoPlanillaId);
		redirectAttributes.addFlashAttribute("messageSuccess", "La Planilla se eliminó exitosamente.");
		return new ModelAndView("redirect:/ingreso-planilla/index.html?id="+idPlanilla);
	}

}
