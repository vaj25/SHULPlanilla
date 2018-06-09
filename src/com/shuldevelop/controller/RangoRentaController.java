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

import com.shuldevelop.model.Modulo;
import com.shuldevelop.model.RangoRenta;
import com.shuldevelop.model.Usuario;
import com.shuldevelop.model.validator.RangoRentaValidator;
import com.shuldevelop.service.ModuloService;
import com.shuldevelop.service.RangoRentaService;
import com.shuldevelop.service.UsuarioService;

@Controller
public class RangoRentaController {

	@Autowired
	private RangoRentaService rangoRentaService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ModuloService moduloService;

	private RangoRentaValidator rangoRentaValidator;

	public RangoRentaController() {
		this.rangoRentaValidator = new RangoRentaValidator();
	}

	public Usuario getUsuario() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		
		return usuarioService.findUserByUsername(userDetails.getUsername());
	}
	
	public List<Modulo> getModulos() {
		
		return moduloService.getAllModuloByRol(getUsuario().getRol().getId());
		
	}
	
	@RequestMapping(value = "/rango-renta/index", method = RequestMethod.GET)
	public ModelAndView rangoRenta() {

		ModelAndView mav = new ModelAndView();

		List<RangoRenta> listRangoRenta = rangoRentaService.getAllRangoRenta();

		mav.setViewName("rango_renta/index");
		mav.addObject("rangoRentaList", listRangoRenta);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());

		return mav;
	}

	@RequestMapping(value = "/rango-renta/add", method = RequestMethod.GET)
	public ModelAndView addRangoRenta() {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("rango_renta/add");
		mav.addObject("RangoRenta", new RangoRenta());
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());

		return mav;
	}

	@RequestMapping(value = "/rango-renta/add", method = RequestMethod.POST)
	public ModelAndView addRangoRenta(
			@ModelAttribute("RangoRenta") RangoRenta u,
			BindingResult result,
			SessionStatus status,
			final RedirectAttributes redirectAttributes
 			) {

		this.rangoRentaValidator.validate(u, result);

		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();

			mav.setViewName("rango_renta/add");
			mav.addObject("RangoRenta", u);
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());

			return mav;
		}

		rangoRentaService.add(u);
		rangoRentaService.up(u);
		redirectAttributes.addFlashAttribute("messageSuccess", "El Rango de la Renta se agregó exitosamente.");

		return new ModelAndView("redirect:/rango-renta/index.html");
	}

	@RequestMapping(value = "/rango-renta/edit", method = RequestMethod.GET)
	public ModelAndView editRangoRenta(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));

		RangoRenta rangoRenta = rangoRentaService.getRangoRenta(id);

		mav.setViewName("rango_renta/edit");
		mav.addObject("RangoRenta", rangoRenta);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());

		return mav;
	}

	@RequestMapping(value = "/rango-renta/edit", method = RequestMethod.POST)
	public ModelAndView editRangoRenta(
			@ModelAttribute("RangoRenta") RangoRenta u,
			BindingResult result,
			SessionStatus status,
			HttpServletRequest request,
			final RedirectAttributes redirectAttributes
 			) {

		this.rangoRentaValidator.validate(u, result);

		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();

			mav.setViewName("rango_renta/edit");
			mav.addObject("RangoRenta", u);
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());

			return mav;
		}

		rangoRentaService.edit(u);
		redirectAttributes.addFlashAttribute("messageSuccess", "El Rango de la Renta se editó exitosamente.");
		return new ModelAndView("redirect:/rango-renta/index.html");
	}

	@RequestMapping(value = "/rango-renta/delete", method = RequestMethod.GET)
	public ModelAndView deleteRangoRenta(HttpServletRequest request,
			final RedirectAttributes redirectAttributes) {

		int id = Integer.parseInt(request.getParameter("id"));

		rangoRentaService.delete(id);
		redirectAttributes.addFlashAttribute("messageSuccess", "El Rango de la Renta se eliminó exitosamente.");
		return new ModelAndView("redirect:/rango-renta/index.html");
	}

}
