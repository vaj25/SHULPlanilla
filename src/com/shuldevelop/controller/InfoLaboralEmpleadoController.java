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

import com.shuldevelop.model.InfoLaboralEmpleado;
import com.shuldevelop.model.TipoEmpleado;
import com.shuldevelop.model.UnidadOrganizacional;
import com.shuldevelop.model.EstructuraOrg;
import com.shuldevelop.model.Puesto;
import com.shuldevelop.model.Empleado;
import com.shuldevelop.model.Usuario;
import com.shuldevelop.model.Modulo;
import com.shuldevelop.model.NivelEstructura;
import com.shuldevelop.service.InfoLaboralEmpleadoService;
import com.shuldevelop.service.TipoEmpleadoService;
import com.shuldevelop.service.EstructuraOrgService;
import com.shuldevelop.service.PuestoService;
import com.shuldevelop.service.EmpleadoService;
import com.shuldevelop.service.UsuarioService;
import com.shuldevelop.service.ModuloService;

import com.shuldevelop.model.validator.InfoLaboralEmpleadoValidator;

@Controller
public class InfoLaboralEmpleadoController {
	
	@Autowired
	private InfoLaboralEmpleadoService infoLaboralEmpleadoService;
	
	@Autowired
	private TipoEmpleadoService tipoEmpleadoService;
	
	@Autowired
	private EstructuraOrgService estructuraOrgService;

	@Autowired
	private PuestoService puestoService;

	@Autowired
	private EmpleadoService empleadoService;	
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ModuloService moduloService;
	
	private  InfoLaboralEmpleadoValidator infoLaboralEmpleadoValidator;

	public  InfoLaboralEmpleadoController() {
		this.infoLaboralEmpleadoValidator = new  InfoLaboralEmpleadoValidator();
	}
	
	
	public Usuario getUsuario() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		
		return usuarioService.findUserByUsername(userDetails.getUsername());
	}
	
	public List<Modulo> getModulos() {
		
		return moduloService.getAllModuloByRol(getUsuario().getRol().getId());
		
	}
	
	
	@RequestMapping(value = "/info-laboral/index", method = RequestMethod.GET)
	public ModelAndView infoLaboralEmpleado() {
		
		ModelAndView mav = new ModelAndView();
		
		List<InfoLaboralEmpleado> listInfoLaboralEmpleado= infoLaboralEmpleadoService.getAllInfoLaboralEmpleado();
		List<TipoEmpleado> listTipoEmpleado= tipoEmpleadoService.getAllTipoEmpleado();
		List<EstructuraOrg> listEstructuraOrg= estructuraOrgService.getAllEstructuraOrg();
		List<Puesto> listPuesto= puestoService.getAllPuesto();
		List<Empleado> listEmpleado= empleadoService.getAllEmpleado();


		mav.setViewName("info_laboral_empleado/index");
		mav.addObject("infoLaboralEmpleadoList", listInfoLaboralEmpleado);
		mav.addObject("tipoEmpleadoList", listTipoEmpleado);
		mav.addObject("estructuraOrgList", listEstructuraOrg);
		mav.addObject("puestoList", listPuesto);		
		mav.addObject("empleadoList", listEmpleado);
		mav.addObject("mensaje", null);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());

		
		return mav;
	}
		
	@RequestMapping(value = "/info-laboral/add", method = RequestMethod.GET)
	public ModelAndView addInfoLaboralEmpleado(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		
		int idEmpleado = Integer.parseInt(request.getParameter("id"));
		InfoLaboralEmpleado infoLaboralEmpleado = null;
		infoLaboralEmpleado = infoLaboralEmpleadoService.getInfobyIdEmpleado(idEmpleado);
		
		if(infoLaboralEmpleado != null) {
			List<TipoEmpleado> listTipoEmpleado= tipoEmpleadoService.getAllTipoEmpleado();
			List<EstructuraOrg> listEstructuraOrg= estructuraOrgService.getAllEstructuraOrg();
			List<Puesto> listPuesto= puestoService.getAllPuesto();
			List<Empleado> listEmpleado= empleadoService.getOneEmpleado(idEmpleado);


			mav.setViewName("info_laboral_empleado/add");
			mav.addObject("InfoLaboralEmpleado", infoLaboralEmpleado);
			mav.addObject("tipoEmpleadoList", listTipoEmpleado);
			mav.addObject("estructuraOrgList", listEstructuraOrg);
			mav.addObject("puestoList", listPuesto);		
			mav.addObject("empleadoList", listEmpleado);
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
			
			
			return mav;
		}else {
		
		List<TipoEmpleado> listTipoEmpleado= tipoEmpleadoService.getAllTipoEmpleado();
		List<EstructuraOrg> listEstructuraOrg= estructuraOrgService.getAllEstructuraOrg();
		List<Puesto> listPuesto= puestoService.getAllPuesto();
		List<Empleado> listEmpleado= empleadoService.getOneEmpleado(idEmpleado);


		mav.setViewName("info_laboral_empleado/add");
		mav.addObject("InfoLaboralEmpleado", new InfoLaboralEmpleado());
		mav.addObject("tipoEmpleadoList", listTipoEmpleado);
		mav.addObject("estructuraOrgList", listEstructuraOrg);
		mav.addObject("puestoList", listPuesto);		
		mav.addObject("empleadoList", listEmpleado);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		
		return mav;
		}
	}
	
	@RequestMapping(value = "/info-laboral/add", method = RequestMethod.POST)
	public ModelAndView addInfoLaboralEmpleado(
			@ModelAttribute("InfoLaboralEmpleado") InfoLaboralEmpleado u,
			BindingResult result,
			SessionStatus status,
			final RedirectAttributes redirectAttributes
 			) {
		this.infoLaboralEmpleadoValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			List<TipoEmpleado> listTipoEmpleado= tipoEmpleadoService.getAllTipoEmpleado();
			List<EstructuraOrg> listEstructuraOrg= estructuraOrgService.getAllEstructuraOrg();
			List<Puesto> listPuesto= puestoService.getAllPuesto();
			List<Empleado> listEmpleado= empleadoService.getAllEmpleado();


			mav.setViewName("info_laboral_empleado/add");
			mav.addObject("InfoLaboralEmpleado", u);
			mav.addObject("tipoEmpleadoList", listTipoEmpleado);
			mav.addObject("estructuraOrgList", listEstructuraOrg);
			mav.addObject("puestoList", listPuesto);		
			mav.addObject("empleadoList", listEmpleado);
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
			
			return mav;
		}
		
		u.setEmpleado(empleadoService.getEmpleado(u.getEmpleado().getId()));
		u.setPuesto(puestoService.getPuesto(u.getPuesto().getId()));
		u.setEstructuraOrg(estructuraOrgService.getEstructuraOrg(u.getEstructuraOrg().getId()));
		u.setTipoEmpleado(tipoEmpleadoService.getTipoEmpleado(u.getTipoEmpleado().getId()));

		if (u.getSalario() < u.getPuesto().getNivelPuesto().getSalarioMinimo() || u.getSalario() > u.getPuesto().getNivelPuesto().getSalarioMaximo()) {
			ModelAndView mav = new ModelAndView();
			List<TipoEmpleado> listTipoEmpleado= tipoEmpleadoService.getAllTipoEmpleado();
			List<EstructuraOrg> listEstructuraOrg= estructuraOrgService.getAllEstructuraOrg();
			List<Puesto> listPuesto= puestoService.getAllPuesto();
			List<Empleado> listEmpleado= empleadoService.getAllEmpleado();


			mav.setViewName("info_laboral_empleado/add");
			mav.addObject("infoLaboralEmpleado", u);
			mav.addObject("tipoEmpleadoList", listTipoEmpleado);
			mav.addObject("estructuraOrgList", listEstructuraOrg);
			mav.addObject("puestoList", listPuesto);		
			mav.addObject("empleadoList", listEmpleado);
			mav.addObject("messageError", "El Salario debe de estar dentro del rango $"+u.getPuesto().getNivelPuesto().getSalarioMinimo()+" y $"+ u.getPuesto().getNivelPuesto().getSalarioMaximo()+" perteneciente al puesto "+u.getPuesto());
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
			
			return mav;
		}

		infoLaboralEmpleadoService.add(u);
		redirectAttributes.addFlashAttribute("messageSuccess", "La información del Empleado se agregó exitosamente.");
		return new ModelAndView("redirect:/empleado/index.html");
	}
	
	
	
	@RequestMapping(value = "/info-laboral/edit", method = RequestMethod.GET)
	public ModelAndView editInfoELaboralEmpleado(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();

		int idInfoLaboralEmpleado = Integer.parseInt(request.getParameter("id"));
		InfoLaboralEmpleado infoLaboralEmpleado = infoLaboralEmpleadoService.getInfoLaboralEmpleado(idInfoLaboralEmpleado);

		List<InfoLaboralEmpleado> listInfoLaboralEmpleado= infoLaboralEmpleadoService.getAllInfoLaboralEmpleado();
		List<TipoEmpleado> listTipoEmpleado= tipoEmpleadoService.getAllTipoEmpleado();
		List<EstructuraOrg> listEstructuraOrg= estructuraOrgService.getAllEstructuraOrg();
		List<Puesto> listPuesto= puestoService.getAllPuesto();
		List<Empleado> listEmpleado= empleadoService.getAllEmpleado();


		mav.setViewName("info_laboral_empleado/edit");
		mav.addObject("infoLaboralEmpleado", infoLaboralEmpleado);
		mav.addObject("infoLaboralEmpleadoList", listInfoLaboralEmpleado);
		mav.addObject("tipoEmpleadoList", listTipoEmpleado);
		mav.addObject("estructuraOrgList", listEstructuraOrg);
		mav.addObject("puestoList", listPuesto);		
		mav.addObject("empleadoList", listEmpleado);
		mav.addObject("mensaje", null);
		mav.addObject("Usuario", getUsuario());
		mav.addObject("modulos", getModulos());
		
		
		return mav;
	}
	
	@RequestMapping(value = "/info-laboral/edit", method = RequestMethod.POST)
	public ModelAndView editInfoELaboralEmpleado(
			@ModelAttribute("InfoLaboralEmpleado") InfoLaboralEmpleado u,
			BindingResult result,
			SessionStatus status,
			HttpServletRequest request,
			final RedirectAttributes redirectAttributes
 			) {
		
		
		this.infoLaboralEmpleadoValidator.validate(u, result);
		
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			
			List<InfoLaboralEmpleado> listInfoLaboralEmpleado= infoLaboralEmpleadoService.getAllInfoLaboralEmpleado();
			List<TipoEmpleado> listTipoEmpleado= tipoEmpleadoService.getAllTipoEmpleado();
			List<EstructuraOrg> listEstructuraOrg= estructuraOrgService.getAllEstructuraOrg();
			List<Puesto> listPuesto= puestoService.getAllPuesto();
			List<Empleado> listEmpleado= empleadoService.getAllEmpleado();


			mav.setViewName("info_laboral_empleado/edit");
			mav.addObject("infoLaboralEmpleado", u);
			mav.addObject("infoLaboralEmpleadoList", listInfoLaboralEmpleado);
			mav.addObject("tipoEmpleadoList", listTipoEmpleado);
			mav.addObject("estructuraOrgList", listEstructuraOrg);
			mav.addObject("puestoList", listPuesto);		
			mav.addObject("empleadoList", listEmpleado);
			mav.addObject("mensaje", null);
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
			
			return mav;
		}
		
		u.setPuesto(puestoService.getPuesto(u.getPuesto().getId()));

		if (u.getSalario() < u.getPuesto().getNivelPuesto().getSalarioMinimo() || u.getSalario() > u.getPuesto().getNivelPuesto().getSalarioMaximo()) {
			ModelAndView mav = new ModelAndView();
			
			List<InfoLaboralEmpleado> listInfoLaboralEmpleado= infoLaboralEmpleadoService.getAllInfoLaboralEmpleado();
			List<TipoEmpleado> listTipoEmpleado= tipoEmpleadoService.getAllTipoEmpleado();
			List<EstructuraOrg> listEstructuraOrg= estructuraOrgService.getAllEstructuraOrg();
			List<Puesto> listPuesto= puestoService.getAllPuesto();
			List<Empleado> listEmpleado= empleadoService.getAllEmpleado();


			mav.setViewName("info_laboral_empleado/add");
			mav.addObject("infoLaboralEmpleado", u);
			mav.addObject("infoLaboralEmpleadoList", listInfoLaboralEmpleado);
			mav.addObject("tipoEmpleadoList", listTipoEmpleado);
			mav.addObject("estructuraOrgList", listEstructuraOrg);
			mav.addObject("puestoList", listPuesto);		
			mav.addObject("empleadoList", listEmpleado);
			mav.addObject("messageError", "El Salario debe de estar dentro del rango $"+u.getPuesto().getNivelPuesto().getSalarioMinimo()+" y $"+ u.getPuesto().getNivelPuesto().getSalarioMaximo()+" perteneciente al puesto "+u.getPuesto());
			mav.addObject("Usuario", getUsuario());
			mav.addObject("modulos", getModulos());
			
			return mav;
		}
	
		infoLaboralEmpleadoService.edit(u);
		redirectAttributes.addFlashAttribute("messageSuccess", "La información del Empleado se editó exitosamente.");
		return new ModelAndView("redirect:/info-laboral/index.html");
	}
	
	@RequestMapping(value = "/info-laboral/delete", method = RequestMethod.GET)
	public ModelAndView deleteEstadoCivil(HttpServletRequest request,
			final RedirectAttributes redirectAttributes) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		infoLaboralEmpleadoService.delete(id);
		redirectAttributes.addFlashAttribute("messageSuccess", "La Informacion Laboral se eliminó exitosamente.");
		return new ModelAndView("redirect:/info-laboral/index.html");
	}
}
