package com.shuldevelop.service;

import java.util.List;

import com.shuldevelop.model.PlanillaEmpleado;

public interface PlanillaEmpleadoService {

	public void add(PlanillaEmpleado planillaEmpleado);
	
	public void edit(PlanillaEmpleado planillaEmpleado);
	
	public void delete(int idPlanillaEmpleado);
	
	public PlanillaEmpleado getPlanillaEmpleado(int idPlanillaEmpleado);
	
	public List<PlanillaEmpleado> getAllPlanillaEmpleado();
	
}
