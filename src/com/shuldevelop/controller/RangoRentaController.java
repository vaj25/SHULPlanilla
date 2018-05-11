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

import com.shuldevelop.model.RangoRenta;
import com.shuldevelop.model.validator.RangoRentaValidator;
import com.shuldevelop.service.RangoRentaService;

@Controller
public class RangoRentaController {

	@Autowired
	private RangoRentaService rangoRentaService;

	private RangoRentaValidator rangoRentaValidator;

	public RangoRentaController() {
		this.rangoRentaValidator = new RangoRentaValidator();
	}

	@RequestMapping(value = "/rango-renta/index", method = RequestMethod.GET)
	public ModelAndView rangoRenta() {

		ModelAndView mav = new ModelAndView();

		List<RangoRenta> listRangoRenta = rangoRentaService.getAllRangoRenta();

		mav.setViewName("rango_renta/index");
		mav.addObject("rangoRentaList", listRangoRenta);

		return mav;
	}

	@RequestMapping(value = "/rango-renta/add", method = RequestMethod.GET)
	public ModelAndView addRangoRenta() {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("rango_renta/add");
		mav.addObject("RangoRenta", new RangoRenta());

		return mav;
	}

	@RequestMapping(value = "/rango-renta/add", method = RequestMethod.POST)
	public ModelAndView addRangoRenta(
			@ModelAttribute("RangoRenta") RangoRenta u,
			BindingResult result,
			SessionStatus status
 			) {

		this.rangoRentaValidator.validate(u, result);

		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();

			mav.setViewName("rango_renta/add");
			mav.addObject("RangoRenta", u);

			return mav;
		}

		rangoRentaService.add(u);

		return new ModelAndView("redirect:/rango-renta/index.html");
	}

	@RequestMapping(value = "/rango-renta/edit", method = RequestMethod.GET)
	public ModelAndView editRangoRenta(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));

		RangoRenta rangoRenta = rangoRentaService.getRangoRenta(id);

		mav.setViewName("rango_renta/edit");
		mav.addObject("RangoRenta", rangoRenta);

		return mav;
	}

	@RequestMapping(value = "/rango-renta/edit", method = RequestMethod.POST)
	public ModelAndView editRangoRenta(
			@ModelAttribute("RangoRenta") RangoRenta u,
			BindingResult result,
			SessionStatus status,
			HttpServletRequest request
 			) {

		this.rangoRentaValidator.validate(u, result);

		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();

			mav.setViewName("rango_renta/edit");
			mav.addObject("RangoRenta", u);

			return mav;
		}

		rangoRentaService.edit(u);

		return new ModelAndView("redirect:/rango-renta/index.html");
	}

	@RequestMapping(value = "/rango-renta/delete", method = RequestMethod.GET)
	public ModelAndView deleteRangoRenta(HttpServletRequest request) {

		int id = Integer.parseInt(request.getParameter("id"));

		rangoRentaService.delete(id);

		return new ModelAndView("redirect:/rango-renta/index.html");
	}

}
