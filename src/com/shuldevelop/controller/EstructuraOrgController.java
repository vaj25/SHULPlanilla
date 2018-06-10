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

import com.shuldevelop.model.EstructuraOrg;
import com.shuldevelop.model.Modulo;
import com.shuldevelop.model.NivelEstructura;
import com.shuldevelop.model.UnidadOrganizacional;
import com.shuldevelop.model.Usuario;
import com.shuldevelop.service.EstructuraOrgService;
import com.shuldevelop.service.ModuloService;
import com.shuldevelop.service.NivelEstructuraService;
import com.shuldevelop.service.UnidadOrganizacionalService;
import com.shuldevelop.service.UsuarioService;
import com.shuldevelop.model.validator.EstructuraOrgValidator;

@Controller
public class EstructuraOrgController {

	@Autowired
	private EstructuraOrgService estructuraOrgService;
	
	@Autowired
	private NivelEstructuraService nivelEstructuraService;
	
	@Autowired
	private UnidadOrganizacionalService unidadOrganizacionalService;

	@Autowired
	private EstructuraOrgService estEstructuraOrgService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ModuloService moduloService;
	
	private  EstructuraOrgValidator estructuraOrgValidator;

	public  EstructuraOrgController() {
		this.estructuraOrgValidator = new  EstructuraOrgValidator();
	}
	
	public Usuario getUsuario() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		
		return usuarioService.findUserByUsername(userDetails.getUsername());
	}
	
	public List<Modulo> getModulos() {
		
		return moduloService.getAllModuloByRol(getUsuario().getRol().getId());
		
	}
	
	@RequestMapping(value = "/estructura-org/index", method = RequestMethod.GET)
	public ModelAndView estructuraOrg() {
		
		ModelAndView mav = new ModelAndView();
		
		List<EstructuraOrg> listEstructuraOrg= estructuraOrgService.getAllEstructuraOrg();


		mav.setViewName("estructura_org/index");
		mav.addObject("estructuraOrgList", listEstructuraOrg);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());

		
		return mav;
	}
	
	@RequestMapping(value = "/estructura-org/add", method = RequestMethod.GET)
	public ModelAndView addCentroCosto() {
		
		ModelAndView mav = new ModelAndView();
		
		List<NivelEstructura> listNivelEstructura= nivelEstructuraService.getAllNivelEstructura();
		List<UnidadOrganizacional> listUnidadOrganizacional= unidadOrganizacionalService.getAllUnidadOrganizacional();
		List<EstructuraOrg> listEstEstructuraOrg= estructuraOrgService.getNivelEstructuraOrg();
		
		
		mav.setViewName("estructura_org/add");
		mav.addObject("EstructuraOrg", new EstructuraOrg());
		mav.addObject("unidadOrganizacionalList", listUnidadOrganizacional);
		mav.addObject("nivelEstructuraList", listNivelEstructura);
		mav.addObject("estEstructuraOrgList", listEstEstructuraOrg);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		
		return mav;
	}	
	
	@RequestMapping(value = "/estructura-org/add", method = RequestMethod.POST)
	public ModelAndView addEstructuraOrg(
			@ModelAttribute("EstructuraOrg") EstructuraOrg u,
			BindingResult result,
			SessionStatus status
 			) {
		
		
		this.estructuraOrgValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			List<NivelEstructura> listNivelEstructura= nivelEstructuraService.getAllNivelEstructura();
			List<UnidadOrganizacional> listUnidadOrganizacional= unidadOrganizacionalService.getAllUnidadOrganizacional();
			List<EstructuraOrg> listEstEstructuraOrg= estructuraOrgService.getNivelEstructuraOrg();
			
			mav.setViewName("estructura_org/add");
			mav.addObject("EstructuraOrg", u);
			mav.addObject("unidadOrganizacionalList", listUnidadOrganizacional);
			mav.addObject("nivelEstructuraList", listNivelEstructura);
			mav.addObject("estEstructuraOrgList", listEstEstructuraOrg);
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
			
			return mav;
		}
		
		u.setNivelEstructura(
			nivelEstructuraService.getNivelEstructura(u.getNivelEstructura().getId())
		);
		u.setUnidadOrganizacional(
			unidadOrganizacionalService.getUnidadOrganizacional(u.getUnidadOrganizacional().getId())
		);
		u.setEstEstructuraOrg(
			estEstructuraOrgService.getEstructuraOrg(u.getEstEstructuraOrg().getId())
		);		
		estructuraOrgService.add(u);
		ModelAndView mav = new ModelAndView();		
		List<EstructuraOrg> listEstructuraOrg= estructuraOrgService.getAllEstructuraOrg();
		mav.setViewName("estructura_org/index");
		mav.addObject("estructuraOrgList", listEstructuraOrg);
		mav.addObject("messageSuccess", "La Estructura Organizativa se ingresó correctamente ");	
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());	
		return mav;
	}
	
	@RequestMapping(value = "/estructura-org/edit", method = RequestMethod.GET)
	public ModelAndView editCentroCosto(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		//EstructuraOrg estructuraOrg = new EstructuraOrg();

		int idEstructuraOrg = Integer.parseInt(request.getParameter("id"));
		EstructuraOrg estructuraOrg = estructuraOrgService.getEstructuraOrg(idEstructuraOrg);
		
		List<NivelEstructura> listNivelEstructura= nivelEstructuraService.getAllNivelEstructura();
		List<UnidadOrganizacional> listUnidadOrganizacional= unidadOrganizacionalService.getAllUnidadOrganizacional();
		List<EstructuraOrg> listEstEstructuraOrg= estructuraOrgService.getNivelEstructuraOrg();

		mav.setViewName("estructura_org/add");
		mav.addObject("EstructuraOrg", estructuraOrg);
		mav.addObject("unidadOrganizacionalList", listUnidadOrganizacional);
		mav.addObject("nivelEstructuraList", listNivelEstructura);
		mav.addObject("estEstructuraOrgList", listEstEstructuraOrg);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
			
		return mav;		
		
	}
	
	@RequestMapping(value = "/estructura-org/edit", method = RequestMethod.POST)
	public ModelAndView editCentroCosto(
			@ModelAttribute("EstructuraOrg") EstructuraOrg u,
			BindingResult result,
			SessionStatus status,
			HttpServletRequest request
 			) {
				
		this.estructuraOrgValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			List<NivelEstructura> listNivelEstructura= nivelEstructuraService.getAllNivelEstructura();
			List<UnidadOrganizacional> listUnidadOrganizacional= unidadOrganizacionalService.getAllUnidadOrganizacional();
			List<EstructuraOrg> listEstEstructuraOrg= estructuraOrgService.getNivelEstructuraOrg();
			
			mav.setViewName("estructura_org/add");
			mav.addObject("EstructuraOrg", u);
			mav.addObject("unidadOrganizacionalList", listUnidadOrganizacional);
			mav.addObject("nivelEstructuraList", listNivelEstructura);
			mav.addObject("estEstructuraOrgList", listEstEstructuraOrg);
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
				
			return mav;
		}
		
		u.setNivelEstructura(
			nivelEstructuraService.getNivelEstructura(u.getNivelEstructura().getId())
		);
		u.setUnidadOrganizacional(
			unidadOrganizacionalService.getUnidadOrganizacional(u.getUnidadOrganizacional().getId())
		);
		u.setEstEstructuraOrg(
			estEstructuraOrgService.getEstructuraOrg(u.getEstEstructuraOrg().getId())
		);		
		estructuraOrgService.add(u);
				
		ModelAndView mav = new ModelAndView();		
		List<EstructuraOrg> listEstructuraOrg= estructuraOrgService.getAllEstructuraOrg();
		mav.setViewName("estructura_org/index");
		mav.addObject("estructuraOrgList", listEstructuraOrg);
		mav.addObject("messageSuccess", "La Estructura Organizativa se editó correctamente ");		
		return mav;
	}
	
	
	@RequestMapping(value = "/estructura-org/delete", method = RequestMethod.GET)
	public ModelAndView deleteCentroCosto(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		int idEstructuraOrg = Integer.parseInt(request.getParameter("id"));
		List<EstructuraOrg> listEstEstructuraOrg= estEstructuraOrgService.getListEstEstructuraOrg(idEstructuraOrg);
		
		if(listEstEstructuraOrg.size()==0) {
			estructuraOrgService.delete(idEstructuraOrg);
			List<EstructuraOrg> listEstructuraOrg= estructuraOrgService.getAllEstructuraOrg();
			mav.setViewName("estructura_org/index");
			mav.addObject("estructuraOrgList", listEstructuraOrg);
			mav.addObject("messageSuccess", "!La Estructura Organizativa se ha borrado correctamente! ");
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
			return mav;
		}else {
			List<EstructuraOrg> listEstructuraOrg= estructuraOrgService.getAllEstructuraOrg();
			mav.setViewName("estructura_org/index");
			mav.addObject("estructuraOrgList", listEstructuraOrg);
			mav.addObject("messageError", "!Puede que alguna Estructura Organizativa dependa de la estructura que intenta borrar! ");
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
			return mav;
		}	

		
	}
	
	
}
