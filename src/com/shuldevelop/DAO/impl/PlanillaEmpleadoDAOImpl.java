package com.shuldevelop.DAO.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.PlanillaEmpleadoDAO;
import com.shuldevelop.model.PlanillaEmpleado;

@Service
public class PlanillaEmpleadoDAOImpl implements PlanillaEmpleadoDAO {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(PlanillaEmpleado planillaEmpleado) {
		
		session.getCurrentSession().saveOrUpdate(planillaEmpleado);

	}

	@Override
	public void edit(PlanillaEmpleado planillaEmpleado) {
		
		session.getCurrentSession().saveOrUpdate(planillaEmpleado);

	}

	@Override
	public void delete(int idPlanillaEmpleado) {
		
		session.getCurrentSession().delete(getPlanillaEmpleado(idPlanillaEmpleado));

	}

	@Override
	public PlanillaEmpleado getPlanillaEmpleado(int idPlanillaEmpleado) {
		
		return (PlanillaEmpleado) session.getCurrentSession().get(PlanillaEmpleado.class, idPlanillaEmpleado);
		
	}

	@Override
	public List<PlanillaEmpleado> getAllPlanillaEmpleado(int idPlanilla) {

		Query<PlanillaEmpleado> query = session.getCurrentSession().
				createQuery("from PLANILLA_EMPLEADO WHERE id_planilla="+idPlanilla, PlanillaEmpleado.class);
		List<PlanillaEmpleado> allPlanillaEmpleado = query.getResultList();
		return allPlanillaEmpleado;
		
	}

}
