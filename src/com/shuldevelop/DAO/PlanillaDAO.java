package com.shuldevelop.DAO;

import java.util.List;

import com.shuldevelop.model.Planilla;

public interface PlanillaDAO {

	public void add(Planilla planilla);

	public void edit(Planilla planilla);

	public void updateDates(Planilla planilla);

	public void delete(int idPlanilla);

	public Planilla getPlanilla(int idPlanilla);

	public List<Planilla> getAllPlanilla();

}
