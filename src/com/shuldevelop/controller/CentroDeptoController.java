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
import com.shuldevelop.model.validator.CentroDeptoValidator;
import com.shuldevelop.model.CentroCosto;
import com.shuldevelop.model.CentroDepto;
import com.shuldevelop.model.CentroDeptoPK;
import com.shuldevelop.service.EstructuraOrgService;
import com.shuldevelop.service.CentroCostoService;
import com.shuldevelop.service.CentroDeptoService;

@Controller
public class CentroDeptoController {

	@Autowired
	private CentroDeptoService centroDeptoService;

	@Autowired
	private EstructuraOrgService estructuraOrgService;
	
	@Autowired
	private CentroCostoService centroCostoService;
	
	private  CentroDeptoValidator centroDeptoValidator;
	
	public  CentroDeptoController() {
		this.centroDeptoValidator = new  CentroDeptoValidator();
	}
	
	@RequestMapping(value = "/centro-depto/index", method = RequestMethod.GET)
	public ModelAndView centroDepto() {
		
		ModelAndView mav = new ModelAndView();
		
		List<CentroDepto> listCentroDepto= centroDeptoService.getAllCentroDepto();
		List<EstructuraOrg> listEstructuraOrg = estructuraOrgService.getDeptoEstructuraOrg();
		List<CentroCosto> listCentroCosto = centroCostoService.getAllCentroCosto();

		
		mav.setViewName("centro_depto/index");
		mav.addObject("centroDeptoList", listCentroDepto);
		mav.addObject("estructuraOrgList", listEstructuraOrg);
		mav.addObject("centroCostoList", listCentroCosto);
		
		
		return mav;
	}
	
	@RequestMapping(value = "/centro-depto/add", method = RequestMethod.GET)
	public ModelAndView addCentroDepto() {
		
		ModelAndView mav = new ModelAndView();
		
		List<EstructuraOrg> listEstructuraOrg = estructuraOrgService.getDeptoEstructuraOrg();
		List<CentroCosto> listCentroCosto = centroCostoService.getAllCentroCosto();
		
		mav.setViewName("centro_depto/add_centro_depto");
		mav.addObject("CentroDepto", new CentroDepto());
		mav.addObject("estructuraOrgList", listEstructuraOrg);
		mav.addObject("centroCostoList", listCentroCosto);
		
		return mav;
			
	}
	
	@RequestMapping(value = "/centro-depto/add", method = RequestMethod.POST)
	public ModelAndView addCentroDepto(
			@ModelAttribute("CentroDepto") CentroDepto u,
			BindingResult result,
			SessionStatus status
			) {
		
		this.centroDeptoValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			List<EstructuraOrg> listEstructuraOrg = estructuraOrgService.getDeptoEstructuraOrg();
			
			mav.setViewName("centro_depto/add_centro_depto");
			mav.addObject("CentroDepto", u);
			mav.addObject("estructuraOrgList", listEstructuraOrg);
				
			return mav;
		}
		
		u.setEstructuraOrg(
			estructuraOrgService.getEstructuraOrg(u.getEstructuraOrg().getId())
		);

		centroCostoService.add(u.getCentroCosto());
		centroDeptoService.add(u);
				
		
		return new ModelAndView("redirect:/welcome.html");
		
	}
	
	@RequestMapping(value = "/centro-depto/edit", method = RequestMethod.GET)
	public ModelAndView editCentroDept(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		CentroDepto centroDepto = new CentroDepto();
		
		int idEstructura = Integer.parseInt(request.getParameter("id"));
		int idCentroCosto = Integer.parseInt(request.getParameter("id2"));
		
		EstructuraOrg estructuraOrg = estructuraOrgService.getEstructuraOrg(idEstructura);
		CentroCosto centroCosto = centroCostoService.getCentroCosto(idCentroCosto);
		
		List<EstructuraOrg> listEstructuraOrg = estructuraOrgService.getAllEstructuraOrg();
		
		CentroDeptoPK centroDeptoPK = new CentroDeptoPK();
		centroDeptoPK.setCentroCosto(centroCosto);	
		centroDeptoPK.setEstructuraOrg(estructuraOrg);
		centroDepto = centroDeptoService.getCentroDepto(centroDeptoPK); 
		
		mav.addObject("estructuraOrgList", listEstructuraOrg);
	
		mav.setViewName("centro_depto/edit_centro_depto");
		mav.addObject("CentroDepto", centroDepto);

		return mav;
			
	}
	
	@RequestMapping(value = "/centro-depto/edit", method = RequestMethod.POST)
	public ModelAndView editCentroDepto(
			@ModelAttribute("CentroDepto") CentroDepto u,
			BindingResult result,
			SessionStatus status
			) {
		
			this.centroDeptoValidator.validate(u, result);		
			if (result.hasErrors()) {
				ModelAndView mav = new ModelAndView();
				
				List<EstructuraOrg> listEstructuraOrg = estructuraOrgService.getDeptoEstructuraOrg();
				List<CentroCosto> listCentroCosto = centroCostoService.getAllCentroCosto();
				
				mav.setViewName("centro_depto/add_centro_depto");
				mav.addObject("CentroDepto", u);
				mav.addObject("estructuraOrgList", listEstructuraOrg);
				mav.addObject("centroCostoList", listCentroCosto);
					
				return mav;
			}
		
			u.setEstructuraOrg(
				estructuraOrgService.getEstructuraOrg(u.getEstructuraOrg().getId())
			);

			centroCostoService.add(u.getCentroCosto());
			centroDeptoService.add(u);
			
			return new ModelAndView("redirect:/centro-depto/index.html");
		
	}
	
	@RequestMapping(value = "/centro-depto/delete", method = RequestMethod.GET)
	public ModelAndView deleteCentroDepto(HttpServletRequest request) {
		
		int idEstructura = Integer.parseInt(request.getParameter("id"));
		int idCentroCosto = Integer.parseInt(request.getParameter("id2"));
		
		EstructuraOrg estructuraOrg = estructuraOrgService.getEstructuraOrg(idEstructura);
		CentroCosto centroCosto = centroCostoService.getCentroCosto(idCentroCosto);
		
		CentroDeptoPK centroDeptoPK = new CentroDeptoPK();

		centroDeptoPK.setCentroCosto(centroCosto);	
		centroDeptoPK.setEstructuraOrg(estructuraOrg);
		centroDeptoService.delete(centroDeptoPK);
		centroCostoService.delete(idCentroCosto);

		
		return new ModelAndView("redirect:/centro-depto/index.html");	
	}
	
	
	
}
