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

import com.shuldevelop.model.TipoDocIdentidad;
import com.shuldevelop.model.validator.TipoDocIdentidadValidator;
import com.shuldevelop.service.TipoDocIdentidadService;

@Controller
public class TipoDocIdentidadController {
	
	@Autowired
	private TipoDocIdentidadService tipoDocIdentidadService;
	
	private TipoDocIdentidadValidator tipoDocIdentidadValidator;
		
	public TipoDocIdentidadController() {
		this.tipoDocIdentidadValidator = new TipoDocIdentidadValidator();
	}

	@RequestMapping(value = "/tipo-doc-identidad", method = RequestMethod.GET)
	public ModelAndView tipoDocIdentidad() {
		
		ModelAndView mav = new ModelAndView();
		
		List<TipoDocIdentidad> listTipoDocIdentidad = tipoDocIdentidadService.getAllTipoDocIdentidad();
		
		mav.setViewName("tipo_doc_identidad/index");
		mav.addObject("tipoDocIdentidadList", listTipoDocIdentidad);
		
		return mav;
	}
	
	@RequestMapping(value = "/add-tipo-doc-identidad", method = RequestMethod.GET)
	public ModelAndView addTipoDocIdentidad() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("tipo_doc_identidad/add");
		mav.addObject("TipoDocIdentidad", new TipoDocIdentidad());
		
		return mav;
	}
	
	@RequestMapping(value = "/add-tipo-doc-identidad", method = RequestMethod.POST)
	public ModelAndView addTipoDocIdentidad(
			@ModelAttribute("TipoDocIdentidad") TipoDocIdentidad u,
			BindingResult result,
			SessionStatus status
 			) {
		
		this.tipoDocIdentidadValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("tipo_doc_identidad/add");
			mav.addObject("TipoDocIdentidad", new TipoDocIdentidad());
			
			return mav;
		}
		
		tipoDocIdentidadService.add(u);
		
		return new ModelAndView("redirect:/tipo-doc-identidad.html");
	}
	
	@RequestMapping(value = "/edit-tipo-doc-identidad", method = RequestMethod.GET)
	public ModelAndView editTipoDocIdentidad(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		
		TipoDocIdentidad tipoDocIdentidad = tipoDocIdentidadService.getTipoDocIdentidad(id);
		
		mav.setViewName("tipo_doc_identidad/edit");
		mav.addObject("TipoDocIdentidad", tipoDocIdentidad);
		
		return mav;
	}
	
	@RequestMapping(value = "/edit-tipo-doc-identidad", method = RequestMethod.POST)
	public ModelAndView editTipoDocIdentidad(
			@ModelAttribute("TipoDocIdentidad") TipoDocIdentidad u,
			BindingResult result,
			SessionStatus status,
			HttpServletRequest request
 			) {
		
		this.tipoDocIdentidadValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			int id = Integer.parseInt(request.getParameter("id"));
			
			TipoDocIdentidad tipoDocIdentidad = tipoDocIdentidadService.getTipoDocIdentidad(id);
			
			mav.setViewName("tipo_doc_identidad/edit");
			mav.addObject("TipoDocIdentidad", tipoDocIdentidad);
			
			return mav;
		}
		
		tipoDocIdentidadService.edit(u);
		
		return new ModelAndView("redirect:/tipo-doc-identidad.html");
	}
	
	@RequestMapping(value = "/delete-tipo-doc-identidad", method = RequestMethod.GET)
	public ModelAndView deleteTipoDocIdentidad(HttpServletRequest request) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		tipoDocIdentidadService.delete(id);
		
		return new ModelAndView("redirect:/tipo-doc-identidad.html");
	}
	
}
