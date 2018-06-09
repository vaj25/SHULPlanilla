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

import com.shuldevelop.model.Modulo;
import com.shuldevelop.model.PlanillaEmpleado;
import com.shuldevelop.model.RangoComision;
import com.shuldevelop.model.RangoPlanilla;
import com.shuldevelop.model.RangoPlanillaId;
import com.shuldevelop.model.Usuario;
import com.shuldevelop.model.validator.RangoPlanillaValidator;
import com.shuldevelop.service.ModuloService;
import com.shuldevelop.service.PlanillaEmpleadoService;
import com.shuldevelop.service.RangoComisionService;
import com.shuldevelop.service.RangoPlanillaService;
import com.shuldevelop.service.UsuarioService;

@Controller
public class RangoPlanillaController {

	@Autowired
	private RangoPlanillaService rangoPlanillaService;

	@Autowired
	private PlanillaEmpleadoService planillaEmpleadoService;
	
	@Autowired
	private RangoComisionService rangoComisionService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ModuloService moduloService;
	
	private RangoPlanillaValidator rangoPlanillaValidator;
		
	public RangoPlanillaController() {
		this.rangoPlanillaValidator = new RangoPlanillaValidator();
	}
	
	public Usuario getUsuario() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		
		return usuarioService.findUserByUsername(userDetails.getUsername());
	}
	
	public List<Modulo> getModulos() {
		
		return moduloService.getAllModuloByRol(getUsuario().getRol().getId());
		
	}

	@RequestMapping(value = "/rango-planilla/index", method = RequestMethod.GET)
	public ModelAndView rangoComision(HttpServletRequest request,
			final RedirectAttributes redirectAttributes) {
		
		ModelAndView mav = new ModelAndView();
		
		int idPlanilla = Integer.parseInt(request.getParameter("id_planilla"));
		
		int idPl = Integer.parseInt(request.getParameter("id_pl"));
		
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
		mav.addObject("idPl", idPl);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
		
	}
	
	@RequestMapping(value = "/rango-planilla/index", method = RequestMethod.POST)
	public ModelAndView rangoComision(
			@ModelAttribute("RangoPlanilla") RangoPlanilla u,
			BindingResult result,
			SessionStatus status,
			final RedirectAttributes redirectAttributes
			) {
		
		rangoPlanillaValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			RangoPlanillaId rangoPlanillaId = new RangoPlanillaId();
			
			rangoPlanillaId.setPlanillaEmpleado(planillaEmpleadoService.getPlanillaEmpleado( u.getPlanillaEmpleado().getId() ));
			rangoPlanillaId.setRangoComision(rangoComisionService.getRangoComision( u.getRangoComision().getId() ));
			
			u.setId(rangoPlanillaId);
			
			mav.setViewName("rango_planilla/index");
			mav.addObject("RangoPlanilla", u);
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
			
			return mav;
		}
		
		if ( rangoPlanillaService.getRangoPlanilla(u.getId()) != null ) {
			rangoPlanillaService.delete(u.getId());
		}		
		
		u.setPlanillaEmpleado(
			planillaEmpleadoService.getPlanillaEmpleado(u.getPlanillaEmpleado().getId())
		);
		
		u.setRangoComision(
			rangoComisionService.getRangoComisionByVenta(u.getVenta())
		);
		
		rangoPlanillaService.add(u);
		redirectAttributes.addFlashAttribute("messageSuccess", "El Rango de la Planilla se agregó exitosamente.");
		return new ModelAndView("redirect:/planilla-empleado/index.html");
		
	}
	
	@RequestMapping(value = "/rango-planilla/delete", method = RequestMethod.GET)
	public ModelAndView deleteIngresoPlanilla(HttpServletRequest request,
			final RedirectAttributes redirectAttributes) {
		
		int idPlanilla = Integer.parseInt(request.getParameter("id_planilla"));
		int idRango = Integer.parseInt(request.getParameter("id_rango"));
		
		RangoComision rangoComision = rangoComisionService.getRangoComision(idRango);
		
		PlanillaEmpleado planillaEmpleado = planillaEmpleadoService.getPlanillaEmpleado(idPlanilla);
		
		RangoPlanillaId rangoPlanillaId = new RangoPlanillaId(planillaEmpleado, rangoComision);
		
		rangoPlanillaService.delete(rangoPlanillaId);
		redirectAttributes.addFlashAttribute("messageSuccess", "El Rango de la Planilla se eliminó exitosamente.");

		return new ModelAndView("redirect:/planilla-empleado/index.html");
	}
		
}
