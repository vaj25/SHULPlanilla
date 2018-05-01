package com.shuldevelop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.shuldevelop.model.Departamento;
import com.shuldevelop.model.Direccion;
import com.shuldevelop.model.Municipio;
import com.shuldevelop.model.Zona;
import com.shuldevelop.service.DepartamentoService;
import com.shuldevelop.service.DireccionService;
import com.shuldevelop.service.MunicipioService;
import com.shuldevelop.service.ZonaService;

@Controller
public class DireccionTestController {
	
	@Autowired
	private DireccionService direccionService;
	
	@Autowired
	private ZonaService zonaService;
	
	@Autowired
	private DepartamentoService departamentoService;
	
	@Autowired
	private MunicipioService municipioService;
	
	@RequestMapping(value = "/direccion/add", method = RequestMethod.GET)
	public ModelAndView addDireccion() {
		
		ModelAndView mav = new ModelAndView();
		
		List<Zona> listZona = zonaService.getAllZona();
		List<Departamento> listDepartamento = departamentoService.getAllDepartamento();
		List<Municipio> listMunicipio = municipioService.getAllMunicipio();
		
		mav.setViewName("test/add_direccion");
		mav.addObject("Direccion", new Direccion());
		mav.addObject("zonaList", listZona);
		mav.addObject("departamentoList", listDepartamento);
		mav.addObject("municipioList", listMunicipio);	
		
		return mav;
	}
	
	@RequestMapping(value = "/direccion/add", method = RequestMethod.POST)
	public ModelAndView addDireccion(
			@ModelAttribute("Direccion") Direccion u,
			BindingResult result,
			SessionStatus status
 			) {
//		
//		this.puestoValidator.validate(u, result);
//		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			List<Zona> listZona = zonaService.getAllZona();
			List<Departamento> listDepartamento = departamentoService.getAllDepartamento();
			List<Municipio> listMunicipio = municipioService.getAllMunicipio();
			
			mav.setViewName("test/add_direccion");
			mav.addObject("Direccion", u);
			mav.addObject("zonaList", listZona);
			mav.addObject("departamentoList", listDepartamento);
			mav.addObject("municipioList", listMunicipio);	
			
			return mav;
		}
		
		u.getMunicipio().setNombre(municipioService.getMunicipio(u.getMunicipio().getId()).getNombre());
		
		direccionService.add(u);
		
		return new ModelAndView("redirect:/welcome.html");
	}
	
	 @RequestMapping(value = "/direccion/getDepartamentoZona", method = RequestMethod.GET, produces = "application/json")
	 @ResponseBody
	 public String getDepartamentoZona(@RequestParam int idZona) {

		 List<Departamento> list = departamentoService.findDepartamentoByZona(idZona);
		 		 
		 return new Gson().toJson(list);
		 
	 }
	 
	 @RequestMapping(value = "/direccion/getMunicipioDepartamento", method = RequestMethod.GET, produces = "application/json")
	 @ResponseBody
	 public String getMunicipioDepartamento(@RequestParam int idDepartamento) {

		 List<Municipio> list = municipioService.findMunicipioByDepartamento(idDepartamento);
		 		 
		 return new Gson().toJson(list);
		 
	 }
	
}
