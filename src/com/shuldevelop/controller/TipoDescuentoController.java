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
import com.shuldevelop.model.TipoDescuento;
import com.shuldevelop.model.Usuario;
import com.shuldevelop.model.validator.TipoDescuentoValidator;
import com.shuldevelop.service.ModuloService;
import com.shuldevelop.service.TipoDescuentoService;
import com.shuldevelop.service.UsuarioService;

@Controller
public class TipoDescuentoController {

	@Autowired
	private TipoDescuentoService tipoDescuentoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ModuloService moduloService;

	private TipoDescuentoValidator tipoDescuentoValidator;

	public TipoDescuentoController() {
		this.tipoDescuentoValidator = new TipoDescuentoValidator();
	}

	public Usuario getUsuario() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		
		return usuarioService.findUserByUsername(userDetails.getUsername());
	}
	
	public List<Modulo> getModulos() {
		
		return moduloService.getAllModuloByRol(getUsuario().getRol().getId());
		
	}
	
	@RequestMapping(value = "/tipo-descuento/index", method = RequestMethod.GET)
	public ModelAndView tipoDescuento() {

		ModelAndView mav = new ModelAndView();

		List<TipoDescuento> listTipoDescuento = tipoDescuentoService.getAllTipoDescuento();

		mav.setViewName("tipo_descuento/index");
		mav.addObject("tipoDescuentoList", listTipoDescuento);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());

		return mav;
	}

	@RequestMapping(value = "/tipo-descuento/add", method = RequestMethod.GET)
	public ModelAndView addTipoDescuento() {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("tipo_descuento/add");
		mav.addObject("TipoDescuento", new TipoDescuento());
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());

		return mav;
	}

	@RequestMapping(value = "/tipo-descuento/add", method = RequestMethod.POST)
	public ModelAndView addTipoDescuento(
			@ModelAttribute("TipoDescuento") TipoDescuento u,
			BindingResult result,
			SessionStatus status,
			final RedirectAttributes redirectAttributes
 			) {

		this.tipoDescuentoValidator.validate(u, result);

		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();

			mav.setViewName("tipo_descuento/add");
			mav.addObject("TipoDescuento", u);
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());

			return mav;
		}

		tipoDescuentoService.add(u);
		redirectAttributes.addFlashAttribute("messageSuccess", "El Tipo de Descuento se agregó exitosamente.");
		return new ModelAndView("redirect:/tipo-descuento/index.html");
	}

	@RequestMapping(value = "/tipo-descuento/edit", method = RequestMethod.GET)
	public ModelAndView editTipoDescuento(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));

		TipoDescuento tipoDescuento = tipoDescuentoService.getTipoDescuento(id);

		mav.setViewName("tipo_descuento/edit");
		mav.addObject("TipoDescuento", tipoDescuento);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());

		return mav;
	}

	@RequestMapping(value = "/tipo-descuento/edit", method = RequestMethod.POST)
	public ModelAndView editTipoDescuento(
			@ModelAttribute("TipoDescuento") TipoDescuento u,
			BindingResult result,
			SessionStatus status,
			HttpServletRequest request,
			final RedirectAttributes redirectAttributes
 			) {

		this.tipoDescuentoValidator.validate(u, result);

		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();

			mav.setViewName("tipo_descuento/edit");
			mav.addObject("TipoDescuento", u);
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());

			return mav;
		}

		tipoDescuentoService.edit(u);
		redirectAttributes.addFlashAttribute("messageSuccess", "El Tipo de Descuento se editó exitosamente.");
		return new ModelAndView("redirect:/tipo-descuento/index.html");
	}

	@RequestMapping(value = "/tipo-descuento/delete", method = RequestMethod.GET)
	public ModelAndView deleteTipoDescuento(HttpServletRequest request,
			final RedirectAttributes redirectAttributes) {

		int id = Integer.parseInt(request.getParameter("id"));

		tipoDescuentoService.delete(id);
		redirectAttributes.addFlashAttribute("messageSuccess", "El Tipo de Descuento se eliminó exitosamente.");
		return new ModelAndView("redirect:/tipo-descuento/index.html");
	}

}
