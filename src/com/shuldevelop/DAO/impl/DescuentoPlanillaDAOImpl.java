package com.shuldevelop.DAO.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.DescuentoPlanillaDAO;
import com.shuldevelop.model.DescuentoPlanilla;
import com.shuldevelop.model.DescuentoPlanillaId;

@Service
public class DescuentoPlanillaDAOImpl implements DescuentoPlanillaDAO {

	@Autowired
	private SessionFactory session;

	@Override
	public void add(DescuentoPlanilla descuentoPlanilla) {

		session.getCurrentSession().saveOrUpdate(descuentoPlanilla);

	}

	@Override
	public void edit(DescuentoPlanilla descuentoPlanilla) {

		session.getCurrentSession().saveOrUpdate(descuentoPlanilla);

	}

	@Override
	public void delete(DescuentoPlanillaId idDescuentoPlanilla) {

		session.getCurrentSession().delete(getDescuentoPlanilla(idDescuentoPlanilla));

	}

	@Override
	public DescuentoPlanilla getDescuentoPlanilla(DescuentoPlanillaId idDescuentoPlanilla) {

		return (DescuentoPlanilla) session.getCurrentSession().get(DescuentoPlanilla.class, idDescuentoPlanilla);

	}

	@Override
	public List<DescuentoPlanilla> getAllDescuentoPlanilla() {

		Query<DescuentoPlanilla> query = session.getCurrentSession().
				createQuery("from DESCUENTO_PLANILLA", DescuentoPlanilla.class);
		List<DescuentoPlanilla> allDescuentoPlanilla = query.getResultList();

		return allDescuentoPlanilla;

	}

	@Override
	public List<DescuentoPlanilla> getAllDescuentoPlanillaByPlanilla(int idEmpleadoPlanilla) {

		Query<DescuentoPlanilla> query = session.getCurrentSession().
				createQuery("from DESCUENTO_PLANILLA where id_planilla_empleado = :idEmpleadoPlanilla",
						DescuentoPlanilla.class).setParameter("idEmpleadoPlanilla", idEmpleadoPlanilla);
		List<DescuentoPlanilla> allDescuentoPlanilla = query.getResultList();

		return allDescuentoPlanilla;

	}

}
