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

import com.shuldevelop.model.Modulo;
import com.shuldevelop.model.Planilla;
import com.shuldevelop.model.Usuario;
import com.shuldevelop.service.ModuloService;
//import com.shuldevelop.model.validator.PlanillaValidator;
import com.shuldevelop.service.PlanillaService;
import com.shuldevelop.service.UsuarioService;

@Controller
public class PlanillaController {

	@Autowired
	private PlanillaService planillaService;

	/*private PlanillaValidator planillaValidator;

	public PlanillaController() {
		this.planillaValidator = new PlanillaValidator();
	}*/
	
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
	
	@RequestMapping(value = "/planilla-planilla/index", method = RequestMethod.GET)
	public ModelAndView planilla() {

		ModelAndView mav = new ModelAndView();

		List<Planilla> listPlanilla = planillaService.getAllPlanilla();

		mav.setViewName("planilla_planilla/index");
		mav.addObject("planillaList", listPlanilla);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());

		return mav;
	}

	@RequestMapping(value = "/planilla-planilla/add", method = RequestMethod.GET)
	public ModelAndView addPlanilla() {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("planilla_planilla/add");
		mav.addObject("Planilla", new Planilla());
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());

		return mav;
	}

	@RequestMapping(value = "/planilla-planilla/add", method = RequestMethod.POST)
	public ModelAndView addPlanilla(
			@ModelAttribute("Planilla") Planilla u,
			BindingResult result,
			SessionStatus status
 			) {

		/*this.planillaValidator.validate(u, result);

		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();

			mav.setViewName("planilla_planilla/add");
			mav.addObject("Planilla", u);

			return mav;
		}*/

		planillaService.add(u);
		planillaService.updateDates(u);

		return new ModelAndView("redirect:/planilla-planilla/index.html");
	}

	@RequestMapping(value = "/planilla-planilla/edit", method = RequestMethod.GET)
	public ModelAndView editPlanilla(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));

		Planilla planilla = planillaService.getPlanilla(id);

		mav.setViewName("planilla_planilla/edit");
		mav.addObject("Planilla", planilla);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());

		return mav;
	}

	@RequestMapping(value = "/planilla-planilla/edit", method = RequestMethod.POST)
	public ModelAndView editPlanilla(
			@ModelAttribute("Planilla") Planilla u,
			BindingResult result,
			SessionStatus status,
			HttpServletRequest request
 			) {

		/*this.planillaValidator.validate(u, result);

		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();

			mav.setViewName("planilla_planilla/edit");
			mav.addObject("Planilla", u);

			return mav;
		}*/

		planillaService.edit(u);

		return new ModelAndView("redirect:/planilla-planilla/index.html");
	}

	@RequestMapping(value = "/planilla-planilla/delete", method = RequestMethod.GET)
	public ModelAndView deletePlanilla(HttpServletRequest request) {

		int id = Integer.parseInt(request.getParameter("id"));

		planillaService.delete(id);

		return new ModelAndView("redirect:/planilla-planilla/index.html");
	}

}
