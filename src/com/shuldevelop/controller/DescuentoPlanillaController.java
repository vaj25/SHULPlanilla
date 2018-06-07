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

import com.shuldevelop.model.DescuentoPlanilla;
import com.shuldevelop.model.DescuentoPlanillaId;
import com.shuldevelop.model.PlanillaEmpleado;
import com.shuldevelop.model.TipoDescuento;
import com.shuldevelop.model.validator.DescuentoPlanillaValidator;
import com.shuldevelop.service.DescuentoPlanillaService;
import com.shuldevelop.service.PlanillaEmpleadoService;
import com.shuldevelop.service.TipoDescuentoService;

@Controller
public class DescuentoPlanillaController {

	@Autowired
	private DescuentoPlanillaService descuentoPlanillaService;

	@Autowired
	private PlanillaEmpleadoService planillaEmpleadoService;

	@Autowired
	private TipoDescuentoService tipoDescuentoService;

	private DescuentoPlanillaValidator descuentoPlanillaValidator;

	public DescuentoPlanillaController() {
		this.descuentoPlanillaValidator = new DescuentoPlanillaValidator();
	}

	@RequestMapping(value = "/descuento-planilla/index", method = RequestMethod.GET)
	public ModelAndView descuentoPlanilla(HttpServletRequest request) {

		if ( request.getParameter("id") != null ) {

			ModelAndView mav = new ModelAndView();

			int id = Integer.parseInt(request.getParameter("id"));
			int idPl = Integer.parseInt(request.getParameter("id_pl"));

			DescuentoPlanilla descuentoPlanilla = new DescuentoPlanilla();

			if (request.getParameter("idi") != null) {
				int idi = Integer.parseInt(request.getParameter("idi"));

				DescuentoPlanillaId descuentoPlanillaId = new DescuentoPlanillaId();

				descuentoPlanillaId.setPlanillaEmpleado( planillaEmpleadoService.getPlanillaEmpleado(id) );
				descuentoPlanillaId.setTipoDescuento( tipoDescuentoService.getTipoDescuento(idi) );

				descuentoPlanilla = descuentoPlanillaService.getDescuentoPlanilla(descuentoPlanillaId);

				System.out.println(descuentoPlanilla.getMonto());
			}

			PlanillaEmpleado planillaEmpleado = planillaEmpleadoService.getPlanillaEmpleado(id);
			List<TipoDescuento> listTipoDescuento = tipoDescuentoService.getAllTipoDescuento();
			List<DescuentoPlanilla> listDescuentoPlanilla = descuentoPlanillaService.getAllDescuentoPlanillaByPlanilla(id);


			mav.setViewName("descuento_planilla/index");
			mav.addObject("DescuentoPlanilla", descuentoPlanilla);
			mav.addObject("tipoDescuentoList", listTipoDescuento);
			mav.addObject("planillaEmpleado", planillaEmpleado);
			mav.addObject("descuentoPlanillaList", listDescuentoPlanilla);
			mav.addObject("idPl", idPl);

			return mav;

		}

		return new ModelAndView("redirect:/welcome.html");

	}

	@RequestMapping(value = "/descuento-planilla/index", method = RequestMethod.POST)
	public ModelAndView descuentoPlanilla(
			@ModelAttribute("DescuentoPlanilla") DescuentoPlanilla u,
			BindingResult result,
			SessionStatus status
			) {

		descuentoPlanillaValidator.validate(u, result);

		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView();

			PlanillaEmpleado planillaEmpleado = planillaEmpleadoService.getPlanillaEmpleado( u.getPlanillaEmpleado().getId() );
			List<TipoDescuento> listTipoDescuento = tipoDescuentoService.getAllTipoDescuento();
			List<DescuentoPlanilla> listDescuentoPlanilla = descuentoPlanillaService.getAllDescuentoPlanillaByPlanilla(u.getPlanillaEmpleado().getId());

			mav.setViewName("descuento_planilla/index");
			mav.addObject("DescuentoPlanilla", u);
			mav.addObject("tipoDescuentoList", listTipoDescuento);
			mav.addObject("planillaEmpleado", planillaEmpleado);
			mav.addObject("descuentoPlanillaList", listDescuentoPlanilla);

			return mav;
		}

		u.setPlanillaEmpleado(
			planillaEmpleadoService.getPlanillaEmpleado(u.getPlanillaEmpleado().getId())
		);

		u.setTipoDescuento(
			tipoDescuentoService.getTipoDescuento(u.getTipoDescuento().getId())
		);

		descuentoPlanillaService.add(u);

		return new ModelAndView("redirect:/descuento-planilla/index.html?id="+u.getPlanillaEmpleado().getId());

	}

	@RequestMapping(value = "/descuento-planilla/delete", method = RequestMethod.GET)
	public ModelAndView deleteDescuentoPlanilla(HttpServletRequest request) {

		int idPlanilla = Integer.parseInt(request.getParameter("id_planilla"));
		int idDescuento = Integer.parseInt(request.getParameter("id_descuento"));

		TipoDescuento tipoDescuento = tipoDescuentoService.getTipoDescuento(idDescuento);

		PlanillaEmpleado planillaEmpleado = planillaEmpleadoService.getPlanillaEmpleado(idPlanilla);

		DescuentoPlanillaId descuentoPlanillaId = new DescuentoPlanillaId(planillaEmpleado, tipoDescuento);

		descuentoPlanillaService.delete(descuentoPlanillaId);

		return new ModelAndView("redirect:/descuento-planilla/index.html?id="+idPlanilla);
	}

}
