package com.shuldevelop.DAO.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.IngresoPlanillaDAO;
import com.shuldevelop.model.IngresoPlanilla;
import com.shuldevelop.model.IngresoPlanillaId;

@Service
public class IngresoPlanillaDAOImpl implements IngresoPlanillaDAO {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(IngresoPlanilla ingresoPlanilla) {
		
		session.getCurrentSession().saveOrUpdate(ingresoPlanilla);

	}

	@Override
	public void edit(IngresoPlanilla ingresoPlanilla) {
		
		session.getCurrentSession().saveOrUpdate(ingresoPlanilla);

	}

	@Override
	public void delete(IngresoPlanillaId idIngresoPlanilla) {

		session.getCurrentSession().delete(getIngresoPlanilla(idIngresoPlanilla));

	}

	@Override
	public IngresoPlanilla getIngresoPlanilla(IngresoPlanillaId idIngresoPlanilla) {
		
		return (IngresoPlanilla) session.getCurrentSession().get(IngresoPlanilla.class, idIngresoPlanilla);
		
	}

	@Override
	public List<IngresoPlanilla> getAllIngresoPlanilla() {
		
		Query<IngresoPlanilla> query = session.getCurrentSession().
				createQuery("from INGRESO_PLANILLA", IngresoPlanilla.class);
		List<IngresoPlanilla> allIngresoPlanilla = query.getResultList();
		
		return allIngresoPlanilla;
		
	}

	@Override
	public List<IngresoPlanilla> getAllIngresoPlanillaByPlanilla(int idEmpleadoPlanilla) {
		
		Query<IngresoPlanilla> query = session.getCurrentSession().
				createQuery("from INGRESO_PLANILLA where id_planilla_empleado = :idEmpleadoPlanilla",
						IngresoPlanilla.class).setParameter("idEmpleadoPlanilla", idEmpleadoPlanilla);
		List<IngresoPlanilla> allIngresoPlanilla = query.getResultList();
		
		return allIngresoPlanilla;
		
	}

}
