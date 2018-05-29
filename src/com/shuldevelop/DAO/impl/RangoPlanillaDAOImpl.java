package com.shuldevelop.DAO.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.RangoPlanillaDAO;
import com.shuldevelop.model.RangoPlanilla;
import com.shuldevelop.model.RangoPlanillaId;

@Service
public class RangoPlanillaDAOImpl implements RangoPlanillaDAO {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(RangoPlanilla rangoPlanilla) {
				
		session.getCurrentSession().saveOrUpdate(rangoPlanilla);
		
	}

	@Override
	public void edit(RangoPlanilla rangoPlanilla) {
		
		session.getCurrentSession().saveOrUpdate(rangoPlanilla);
		
	}

	@Override
	public void deleteRangoPlanilla(RangoPlanillaId id) {
		
		session.getCurrentSession().delete(getRangoPlanilla(id));
		
	}

	@Override
	public RangoPlanilla getRangoPlanilla(RangoPlanillaId id) {
		
		return (RangoPlanilla) session.getCurrentSession().get(RangoPlanilla.class, id);
		
	}

	@Override
	public List<RangoPlanilla> getAllRangoPlanilla() {
		
		Query<RangoPlanilla> query = session.getCurrentSession().
				createQuery("from RANGO_PLANILLA", RangoPlanilla.class);
		List<RangoPlanilla> allRangoPlanilla = query.getResultList();
		
		return allRangoPlanilla;
		
	}

	@Override
	public RangoPlanilla getRangoPlanillaByPlanilla(int idPlanillaEmpleado) {
		
		return (RangoPlanilla) session.getCurrentSession().createQuery(
				"from RANGO_PLANILLA where id_planilla_empleado = :idPlanillaEmpleado")
				.setParameter("idPlanillaEmpleado", idPlanillaEmpleado)
				.uniqueResult();
		
	}
	
}
