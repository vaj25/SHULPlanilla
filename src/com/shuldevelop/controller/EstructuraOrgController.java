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

import com.shuldevelop.model.EstructuraOrg;
import com.shuldevelop.model.NivelEstructura;
import com.shuldevelop.model.UnidadOrganizacional;
import com.shuldevelop.service.EstructuraOrgService;
import com.shuldevelop.service.NivelEstructuraService;
import com.shuldevelop.service.UnidadOrganizacionalService;

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
	
	private  EstructuraOrgValidator estructuraOrgValidator;

	public  EstructuraOrgController() {
		this.estructuraOrgValidator = new  EstructuraOrgValidator();
	}
	
	@RequestMapping(value = "/estructura-org/index", method = RequestMethod.GET)
	public ModelAndView estructuraOrg() {
		
		ModelAndView mav = new ModelAndView();
		
		List<EstructuraOrg> listEstructuraOrg= estructuraOrgService.getAllEstructuraOrg();


		mav.setViewName("estructura_org/index");
		mav.addObject("estructuraOrgList", listEstructuraOrg);
		mav.addObject("mensaje", null);

		
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
				
		return new ModelAndView("redirect:/estructura-org/index.html");
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
				
		return new ModelAndView("redirect:/estructura-org/index.html");
	}
	
	
	@RequestMapping(value = "/estructura-org/delete", method = RequestMethod.GET)
	public ModelAndView deleteCentroCosto(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		int idEstructuraOrg = Integer.parseInt(request.getParameter("id"));

		List<EstructuraOrg> listEstEstructuraOrg= estEstructuraOrgService.getAllEstructuraOrg();
		EstructuraOrg estructuraOrg = estructuraOrgService.getEstructuraOrg(idEstructuraOrg);

		if(estructuraOrg.getEstEstructuraOrg()==null) {	
			
			if(listEstEstructuraOrg!=null) {
				
				if(listEstEstructuraOrg.size()==1) {
					estructuraOrgService.delete(idEstructuraOrg);
					return new ModelAndView("redirect:/estructura-org/index.html");					
				}else {
					System.out.println(listEstEstructuraOrg);
					
					List<EstructuraOrg> listEstructuraOrg= estructuraOrgService.getAllEstructuraOrg();
					mav.setViewName("estructura_org/index_delete");
					mav.addObject("estructuraOrgList", listEstructuraOrg);
					mav.addObject("mensaje", "!Puede que alguna estructura organizativa dependa de la estructura que intenta borrar! ");
					return mav;
										
				}
					
			}else {
				estructuraOrgService.delete(idEstructuraOrg);
				return new ModelAndView("redirect:/estructura-org/index.html");
			}

			
		}else {
			estructuraOrgService.delete(idEstructuraOrg);
			return new ModelAndView("redirect:/estructura-org/index.html");
		}
	

	}
	
	
}
