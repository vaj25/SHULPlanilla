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

import com.shuldevelop.model.TipoDescuento;
import com.shuldevelop.model.validator.TipoDescuentoValidator;
import com.shuldevelop.service.TipoDescuentoService;

@Controller
public class TipoDescuentoController {

	@Autowired
	private TipoDescuentoService tipoDescuentoService;

	private TipoDescuentoValidator tipoDescuentoValidator;

	public TipoDescuentoController() {
		this.tipoDescuentoValidator = new TipoDescuentoValidator();
	}

	@RequestMapping(value = "/tipo-descuento/index", method = RequestMethod.GET)
	public ModelAndView tipoDescuento() {

		ModelAndView mav = new ModelAndView();

		List<TipoDescuento> listTipoDescuento = tipoDescuentoService.getAllTipoDescuento();

		mav.setViewName("tipo_descuento/index");
		mav.addObject("tipoDescuentoList", listTipoDescuento);

		return mav;
	}

	@RequestMapping(value = "/tipo-descuento/add", method = RequestMethod.GET)
	public ModelAndView addTipoDescuento() {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("tipo_descuento/add");
		mav.addObject("TipoDescuento", new TipoDescuento());

		return mav;
	}

	@RequestMapping(value = "/tipo-descuento/add", method = RequestMethod.POST)
	public ModelAndView addTipoDescuento(
			@ModelAttribute("TipoDescuento") TipoDescuento u,
			BindingResult result,
			SessionStatus status
 			) {

		this.tipoDescuentoValidator.validate(u, result);

		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();

			mav.setViewName("tipo_descuento/add");
			mav.addObject("TipoDescuento", u);

			return mav;
		}

		tipoDescuentoService.add(u);

		return new ModelAndView("redirect:/tipo-descuento/index.html");
	}

	@RequestMapping(value = "/tipo-descuento/edit", method = RequestMethod.GET)
	public ModelAndView editTipoDescuento(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));

		TipoDescuento tipoDescuento = tipoDescuentoService.getTipoDescuento(id);

		mav.setViewName("tipo_descuento/edit");
		mav.addObject("TipoDescuento", tipoDescuento);

		return mav;
	}

	@RequestMapping(value = "/tipo-descuento/edit", method = RequestMethod.POST)
	public ModelAndView editTipoDescuento(
			@ModelAttribute("TipoDescuento") TipoDescuento u,
			BindingResult result,
			SessionStatus status,
			HttpServletRequest request
 			) {

		this.tipoDescuentoValidator.validate(u, result);

		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();

			mav.setViewName("tipo_descuento/edit");
			mav.addObject("TipoDescuento", u);

			return mav;
		}

		tipoDescuentoService.edit(u);

		return new ModelAndView("redirect:/tipo-descuento/index.html");
	}

	@RequestMapping(value = "/tipo-descuento/delete", method = RequestMethod.GET)
	public ModelAndView deleteTipoDescuento(HttpServletRequest request) {

		int id = Integer.parseInt(request.getParameter("id"));

		tipoDescuentoService.delete(id);

		return new ModelAndView("redirect:/tipo-descuento/index.html");
	}

}
