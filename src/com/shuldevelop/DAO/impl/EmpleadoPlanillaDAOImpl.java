package com.shuldevelop.DAO.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.EmpleadoPlanillaDAO;
import com.shuldevelop.model.EmpleadoPlanilla;
import com.shuldevelop.model.RangoPlanilla;

@Service
public class EmpleadoPlanillaDAOImpl implements EmpleadoPlanillaDAO {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(EmpleadoPlanilla empleadoPlanilla) {
		
		session.getCurrentSession().saveOrUpdate(empleadoPlanilla);

	}

	@Override
	public void edit(EmpleadoPlanilla empleadoPlanilla) {
		
		session.getCurrentSession().saveOrUpdate(empleadoPlanilla);

	}

	@Override
	public void delete(int idEmpleadoPlanilla) {
		
		session.getCurrentSession().delete(getEmpleadoPlanilla(idEmpleadoPlanilla));

	}

	@Override
	public EmpleadoPlanilla getEmpleadoPlanilla(int idEmpleadoPlanilla) {
		
		return (EmpleadoPlanilla) session.getCurrentSession().get(EmpleadoPlanilla.class, idEmpleadoPlanilla);
		
	}

	@Override
	public List<EmpleadoPlanilla> getAllEmpleadoPlanilla() {
		
		Query<EmpleadoPlanilla> query = session.getCurrentSession().
				createQuery("from PLANILLA_EMPLEADO", EmpleadoPlanilla.class);
		List<EmpleadoPlanilla> allEmpleadoPlanilla = query.getResultList();
		
		return allEmpleadoPlanilla;
		
	}

}
