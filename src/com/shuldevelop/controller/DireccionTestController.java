package com.shuldevelop.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.shuldevelop.model.Departamento;
import com.shuldevelop.model.Direccion;
import com.shuldevelop.model.Modulo;
import com.shuldevelop.model.Municipio;
import com.shuldevelop.model.Usuario;
import com.shuldevelop.model.Zona;
import com.shuldevelop.service.DepartamentoService;
import com.shuldevelop.service.DireccionService;
import com.shuldevelop.service.ModuloService;
import com.shuldevelop.service.MunicipioService;
import com.shuldevelop.service.UsuarioService;
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
	private UsuarioService usuarioService;
	
	@Autowired
	private ModuloService moduloService;
	
	@Autowired
	private MunicipioService municipioService;
	
	public Usuario getUsuario() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		
		return usuarioService.findUserByUsername(userDetails.getUsername());
	}
	
	public List<Modulo> getModulos() {
		
		return moduloService.getAllModuloByRol(getUsuario().getRol().getId());
		
	}
	
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
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		return mav;
	}
	
	@RequestMapping(value = "/direccion/add", method = RequestMethod.POST)
	public ModelAndView addDireccion(
			@ModelAttribute("Direccion") Direccion u,
			BindingResult result,
			SessionStatus status,
			final RedirectAttributes redirectAttributes
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
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());	
			
			return mav;
		}
		
		u.getMunicipio().setNombre(municipioService.getMunicipio(u.getMunicipio().getId()).getNombre());
		
		direccionService.add(u);
		redirectAttributes.addFlashAttribute("messageSuccess", "La Dirección se agregó exitosamente.");
		
		return new ModelAndView("redirect:/welcome.html");
	}
	
	 @RequestMapping(value = "/direccion/getDepartamentoZona", method = RequestMethod.GET)
	 @ResponseBody
	 public String getDepartamentoZona(@RequestParam int idZona) {

		 List<Departamento> list = departamentoService.findDepartamentoByZona(idZona);
		 		 
		 return new Gson().toJson(list);
		 
	 }
	 
	 @RequestMapping(value = "/direccion/getMunicipioDepartamento", method = RequestMethod.GET)
	 @ResponseBody
	 public String getMunicipioDepartamento(@RequestParam int idDepartamento,
				final RedirectAttributes redirectAttributes) {

		 List<Municipio> list = municipioService.findMunicipioByDepartamento(idDepartamento);
		 		 
		 return new Gson().toJson(list);
		 
	 }
	
}
