package com.shuldevelop.DAO.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.EmpleadoDAO;
import com.shuldevelop.model.Empleado;
@Service
public class EmpleadoDAOImpl implements EmpleadoDAO {
	@Autowired
	private SessionFactory session;
	@Override
	public void add(Empleado empleado) {
		session.getCurrentSession().save(empleado);

	}

	@Override
	public void edit(Empleado empleado) {
		session.getCurrentSession().update(empleado);

	}

	@Override
	public void delete(int idEmpleado) {
		session.getCurrentSession().delete(getEmpleado(idEmpleado));

	}

	@Override
	public Empleado getEmpleado(int idEmpleado) {
		return (Empleado)session.getCurrentSession().get(Empleado.class, idEmpleado);
	}

	@Override
	public List<Empleado> getAllEmpleado() {
		Query<Empleado> query = session.getCurrentSession()
				.createQuery("from Empleado",Empleado.class);
		
		List<Empleado> allEmpleado = query.getResultList();
		return allEmpleado;
	}
	
	@Override
	public List<Empleado> getAllSub(int idEmpleado){
		Query<Empleado> query = session.getCurrentSession()
				.createQuery("from Empleado where emp_id_empleado = :idEmpleado",Empleado.class)
				.setParameter("idEmpleado", idEmpleado);
		List<Empleado> allSub = query.getResultList();
		return allSub;
	}

}
