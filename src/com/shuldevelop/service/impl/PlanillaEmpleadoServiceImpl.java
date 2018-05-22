package com.shuldevelop.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.PlanillaEmpleadoDAO;
import com.shuldevelop.model.PlanillaEmpleado;
import com.shuldevelop.service.PlanillaEmpleadoService;

@Service
public class PlanillaEmpleadoServiceImpl implements PlanillaEmpleadoService {

	@Autowired
	private PlanillaEmpleadoDAO planillaEmpleadoDAO;
	
	@Transactional
	public void add(PlanillaEmpleado planillaEmpleado) {
		
		planillaEmpleadoDAO.add(planillaEmpleado);

	}

	@Transactional
	public void edit(PlanillaEmpleado planillaEmpleado) {
		
		planillaEmpleadoDAO.edit(planillaEmpleado);

	}

	@Transactional
	public void delete(int idPlanillaEmpleado) {

		planillaEmpleadoDAO.delete(idPlanillaEmpleado);

	}

	@Transactional
	public PlanillaEmpleado getPlanillaEmpleado(int idPlanillaEmpleado) {

		return planillaEmpleadoDAO.getPlanillaEmpleado(idPlanillaEmpleado);
		
	}

	@Transactional
	public List<PlanillaEmpleado> getAllPlanillaEmpleado() {
		
		return planillaEmpleadoDAO.getAllPlanillaEmpleado();
		
	}

}
