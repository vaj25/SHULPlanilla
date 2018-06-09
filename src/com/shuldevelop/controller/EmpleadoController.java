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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shuldevelop.model.Departamento;
import com.shuldevelop.model.Empleado;
import com.shuldevelop.model.EstadoCivil;
import com.shuldevelop.model.Genero;
import com.shuldevelop.model.Municipio;
import com.shuldevelop.model.ProfesionOficio;
import com.shuldevelop.model.TipoDocIdentidad;
import com.shuldevelop.model.Zona;
import com.shuldevelop.model.validator.EmpleadoValidator;
import com.shuldevelop.service.DepartamentoService;
import com.shuldevelop.service.DireccionService;
import com.shuldevelop.service.EmpleadoService;
import com.shuldevelop.service.EstadoCivilService;
import com.shuldevelop.service.GeneroService;
import com.shuldevelop.service.MunicipioService;
import com.shuldevelop.service.ProfesionOficioService;
import com.shuldevelop.service.TipoDocIdentidadService;
import com.shuldevelop.service.ZonaService;

@Controller
public class EmpleadoController {
	@Autowired
	private EmpleadoService empleadoService;
	@Autowired
	private DireccionService direccionService;
	@Autowired
	private ZonaService zonaService;
	@Autowired
	private DepartamentoService departamentoService;
	@Autowired
	private MunicipioService municipioService;
	@Autowired
	private EstadoCivilService estadoCivilService;
	@Autowired
	private GeneroService generoService;
	@Autowired
	private TipoDocIdentidadService tipoDocIdentidadService;
	@Autowired
	private ProfesionOficioService profesionOficioService;
	
	private EmpleadoValidator empleadoValidator;
	
	public EmpleadoController() {
		this.empleadoValidator = new EmpleadoValidator();
	}
	
	@RequestMapping(value = "/empleado/index", method = RequestMethod.GET)
	public ModelAndView empleado() {
		ModelAndView mav = new ModelAndView();
		
		List<Empleado> listEmpleado = empleadoService.getAllEmpleado();
		mav.setViewName("empleado/index");
		mav.addObject("empleadoList",listEmpleado);
		return mav;
		
	}
	
	@RequestMapping(value = "/empleado/add", method = RequestMethod.GET)
	public ModelAndView addEmpleado() {
		
		ModelAndView mav = new ModelAndView();
		List<Empleado> ListEmpleado = empleadoService.getAllEmpleado();
		List<Genero> ListGenero = generoService.getAllGenero();
		List<EstadoCivil> ListEstadoCivil = estadoCivilService.getAllEstadoCivil();
		List<TipoDocIdentidad> ListTipoDocIdentidad = tipoDocIdentidadService.getAllTipoDocIdentidad();
		List<ProfesionOficio> ListProfesionOficio = profesionOficioService.getAllProfesionOficio();
		List<Departamento> ListDepartamento = departamentoService.getAllDepartamento();
		List<Zona> ListZona = zonaService.getAllZona();
		List<Municipio> ListMunicipio = municipioService.getAllMunicipio();
		
		mav.setViewName("empleado/add");
		mav.addObject("Empleado", new Empleado());
		mav.addObject("empleadoList", ListEmpleado);
		mav.addObject("generoList", ListGenero);
		mav.addObject("estadoCivilList", ListEstadoCivil);
		mav.addObject("tipoDocIdentidadList",ListTipoDocIdentidad);
		mav.addObject("profesionOficioList", ListProfesionOficio);
		mav.addObject("departamentoList", ListDepartamento);
		mav.addObject("municipioList", ListMunicipio);
		mav.addObject("zonaList", ListZona);
		
		return mav;
	}
	
	@RequestMapping(value = "/empleado/add", method = RequestMethod.POST)
	public ModelAndView addEmpleado(
			@ModelAttribute("Empleado") Empleado u,
			BindingResult result,
			SessionStatus status
			) {
		this.empleadoValidator.validate(u, result);
		
		if(result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			List<Empleado> ListEmpleado = empleadoService.getAllEmpleado();
			List<Genero> ListGenero = generoService.getAllGenero();
			List<EstadoCivil> ListEstadoCivil = estadoCivilService.getAllEstadoCivil();
			List<TipoDocIdentidad> ListTipoDocIdentidad = tipoDocIdentidadService.getAllTipoDocIdentidad();
			List<ProfesionOficio> ListProfesionOficio = profesionOficioService.getAllProfesionOficio();
			List<Departamento> ListDepartamento = departamentoService.getAllDepartamento();
			List<Zona> ListZona = zonaService.getAllZona();
			List<Municipio> ListMunicipio = municipioService.getAllMunicipio();
			
			mav.setViewName("empleado/add");
			mav.addObject("Empleado", u);
			mav.addObject("empleadoList", ListEmpleado);
			mav.addObject("generoList", ListGenero);
			mav.addObject("estadoCivilList", ListEstadoCivil);
			mav.addObject("tipoDocIdentidadList",ListTipoDocIdentidad);
			mav.addObject("profesionOficioList", ListProfesionOficio);
			mav.addObject("departamentoList", ListDepartamento);
			mav.addObject("municipioList", ListMunicipio);
			mav.addObject("zonaList", ListZona);
			return mav;
		}
		
		List<Empleado> empDui=empleadoService.getDui(u.getDoc_identidad());
		List<Empleado> Empemail=empleadoService.getEmpEmail(u.getEmail_pers());
		List<Empleado> empNit=empleadoService.getNit(u.getNit());
		List<Empleado> empIsss=empleadoService.getIsss(u.getIsss());
		List<Empleado> empNup=empleadoService.getNup(u.getNup());
		List<Empleado> insEmail=empleadoService.getInsEmail(u.getEmail_inst());
		
		if(empDui.size()==0 && Empemail.size()==0 && empNit.size()==0 && empIsss.size()==0 
				&& empNup.size()==0 && insEmail.size()==0 ) {
			u.setEstado(1);
			empleadoService.add(u);
			return new ModelAndView("redirect:/empleado/index.html");
			
		}
		
		else {
			
			
			ModelAndView mav = new ModelAndView();
			List<Empleado> ListEmpleado = empleadoService.getAllEmpleado();
			List<Genero> ListGenero = generoService.getAllGenero();
			List<EstadoCivil> ListEstadoCivil = estadoCivilService.getAllEstadoCivil();
			List<TipoDocIdentidad> ListTipoDocIdentidad = tipoDocIdentidadService.getAllTipoDocIdentidad();
			List<ProfesionOficio> ListProfesionOficio = profesionOficioService.getAllProfesionOficio();
			List<Departamento> ListDepartamento = departamentoService.getAllDepartamento();
			List<Zona> ListZona = zonaService.getAllZona();
			List<Municipio> ListMunicipio = municipioService.getAllMunicipio();
			
			
			
			
			mav.setViewName("empleado/add");
			mav.addObject("Empleado", u);
			mav.addObject("empleadoList", ListEmpleado);
			mav.addObject("generoList", ListGenero);
			mav.addObject("estadoCivilList", ListEstadoCivil);
			mav.addObject("tipoDocIdentidadList",ListTipoDocIdentidad);
			mav.addObject("profesionOficioList", ListProfesionOficio);
			mav.addObject("departamentoList", ListDepartamento);
			mav.addObject("municipioList", ListMunicipio);
			mav.addObject("zonaList", ListZona);
			mav.addObject("mensaje0", "mensaje");
			if(empDui.size()==1) {
				mav.addObject("mensaje", "!Error Dui duplicado!");
			}
			if(Empemail.size()==1) {
				mav.addObject("mensaje1", "Error email ya existe");
			}
			if(empNit.size()==1) {
				mav.addObject("mensaje2", "Error NIT duplicado");
			}
			if(empIsss.size()==1) {
				mav.addObject("mensaje3", "Error No. de Isss Duplicado");
			}
			if(empNup.size()==1) {
				mav.addObject("mensaje4", "Error NUP Duplicado");
			}
			if(insEmail.size()==1) {
				mav.addObject("mensaje5", "Error email institucional duplicado");
			}
			return mav;
		}
		
		
	}
	
	@RequestMapping(value = "/empleado/edit", method = RequestMethod.GET)
	public ModelAndView editEmpleado(HttpServletRequest request) {
	
	ModelAndView mav = new ModelAndView();
	List<Empleado> ListEmpleado = empleadoService.getAllEmpleado();
	List<Genero> ListGenero = generoService.getAllGenero();
	List<EstadoCivil> ListEstadoCivil = estadoCivilService.getAllEstadoCivil();
	List<TipoDocIdentidad> ListTipoDocIdentidad = tipoDocIdentidadService.getAllTipoDocIdentidad();
	List<ProfesionOficio> ListProfesionOficio = profesionOficioService.getAllProfesionOficio();
	List<Departamento> ListDepartamento = departamentoService.getAllDepartamento();
	List<Zona> ListZona = zonaService.getAllZona();
	List<Municipio> ListMunicipio = municipioService.getAllMunicipio();
	
	int idEmpleado = Integer.parseInt(request.getParameter("id"));
	Empleado empleado = empleadoService.getEmpleado(idEmpleado);
	mav.setViewName("empleado/edit");
	mav.addObject("Empleado", empleado);
	mav.addObject("empleadoList", ListEmpleado);
	mav.addObject("generoList", ListGenero);
	mav.addObject("estadoCivilList", ListEstadoCivil);
	mav.addObject("tipoDocIdentidadList",ListTipoDocIdentidad);
	mav.addObject("profesionOficioList", ListProfesionOficio);
	mav.addObject("departamentoList", ListDepartamento);
	mav.addObject("municipioList", ListMunicipio);
	mav.addObject("zonaList", ListZona);
	return mav;
	}
	
	@RequestMapping(value = "/empleado/edit", method = RequestMethod.POST)
	public ModelAndView editEmpleado(
			@ModelAttribute("Empleado") Empleado u,
			BindingResult result,
			SessionStatus status,
			HttpServletRequest request
			) {
		this.empleadoValidator.validate(u, result);
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			List<Empleado> ListEmpleado = empleadoService.getAllEmpleado();
			List<Genero> ListGenero = generoService.getAllGenero();
			List<EstadoCivil> ListEstadoCivil = estadoCivilService.getAllEstadoCivil();
			List<TipoDocIdentidad> ListTipoDocIdentidad = tipoDocIdentidadService.getAllTipoDocIdentidad();
			List<ProfesionOficio> ListProfesionOficio = profesionOficioService.getAllProfesionOficio();
			List<Departamento> ListDepartamento = departamentoService.getAllDepartamento();
			List<Zona> ListZona = zonaService.getAllZona();
			List<Municipio> ListMunicipio = municipioService.getAllMunicipio();
			mav.setViewName("empleado/edit");
			mav.addObject("Empleado", u);
			mav.addObject("empleadoList", ListEmpleado);
			mav.addObject("generoList", ListGenero);
			mav.addObject("estadoCivilList", ListEstadoCivil);
			mav.addObject("tipoDocIdentidadList",ListTipoDocIdentidad);
			mav.addObject("profesionOficioList", ListProfesionOficio);
			mav.addObject("departamentoList", ListDepartamento);
			mav.addObject("municipioList", ListMunicipio);
			mav.addObject("zonaList", ListZona);
			return mav;
		}
		empleadoService.edit(u);
		return new ModelAndView("redirect:/empleado/index.html");
	}
	
	@RequestMapping(value = "/empleado/delete", method = RequestMethod.GET)
	public ModelAndView deleteEmpleado(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		List<Empleado> ListSub = empleadoService.getAllSub(id);
		
		if(ListSub.size()==0) {
			
			empleadoService.delete(id);
			return new ModelAndView("redirect:/empleado/index.html");
		}
		else {
			
			List<Empleado> listEmpleado = empleadoService.getAllEmpleado();
			mav.setViewName("empleado/index");
			mav.addObject("empleadoList",listEmpleado);
			mav.addObject("mensaje", "!Error no es posible Eliminar este Empleado ! ");
			return mav;
			
			
		}
		
		
		
	}
	
	@RequestMapping(value = "/empleado/inactivate", method = RequestMethod.GET)
	public ModelAndView inactivateEmpleado(
			HttpServletRequest request,
			final RedirectAttributes redirectAttributes) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Empleado empleado = empleadoService.getEmpleado(id);
		empleado.setEstado(2);
		empleadoService.edit(empleado);
		redirectAttributes.addFlashAttribute("messageSuccess", "El empleado ha sido inactivado exitosamente.");
		return new ModelAndView("redirect:/empleado/index.html");
	}
	
	@RequestMapping(value = "/empleado/activate", method = RequestMethod.GET)
	public ModelAndView activateEmpleado(
			HttpServletRequest request,
			final RedirectAttributes redirectAttributes) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Empleado empleado = empleadoService.getEmpleado(id);
		empleado.setEstado(1);
		empleadoService.edit(empleado);
		redirectAttributes.addFlashAttribute("messageSuccess", "El empleado ha sido activado exitosamente.");
		return new ModelAndView("redirect:/empleado/index.html");
	}
	
	
	
}
