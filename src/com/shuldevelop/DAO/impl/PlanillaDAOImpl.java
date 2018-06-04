package com.shuldevelop.DAO.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.PlanillaDAO;
import com.shuldevelop.model.Planilla;

@Service
public class PlanillaDAOImpl implements PlanillaDAO {

	@Autowired
	private SessionFactory session;

	@Override
	public void add(Planilla planilla) {

		session.getCurrentSession().saveOrUpdate(planilla);

	}

	public void updateDates(Planilla planilla) {
				@SuppressWarnings("deprecation")
		Query query = session.getCurrentSession().createSQLQuery("CALL actualizarPlanilla(:id_planilla)")
						.addEntity(Planilla.class)
						.setParameter("id_planilla",planilla.getId());
				query.executeUpdate();
	}

	@Override
	public void edit(Planilla planilla) {

		session.getCurrentSession().saveOrUpdate(planilla);

	}

	@Override
	public void delete(int idPlanilla) {
		Planilla planilla = new Planilla();
		planilla.setId(idPlanilla);
		session.getCurrentSession().delete(planilla);

	}

	@Override
	public Planilla getPlanilla(int idPlanilla) {

		return session.getCurrentSession().get(Planilla.class, idPlanilla);

	}

	@Override
	public List<Planilla> getAllPlanilla() {

		Query<Planilla> query = session.getCurrentSession().
				createQuery("from PLANILLA", Planilla.class);
		List<Planilla> allPlanilla = query.getResultList();

		return allPlanilla;

	}

}
