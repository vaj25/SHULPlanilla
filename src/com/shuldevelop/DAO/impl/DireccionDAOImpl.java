package com.shuldevelop.DAO.impl;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.DireccionDAO;
import com.shuldevelop.model.Direccion;

@Service
public class DireccionDAOImpl implements DireccionDAO {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(Direccion direccion) {
		
		session.getCurrentSession().saveOrUpdate(direccion);

	}

	@Override
	public void edit(Direccion direccion) {
		
		session.getCurrentSession().saveOrUpdate(direccion);

	}

	@Override
	public void delete(int idDireccion) {
		
		session.getCurrentSession().delete(getDireccion(idDireccion));

	}

	@Override
	public Direccion getDireccion(int idDireccion) {
		
		return (Direccion) session.getCurrentSession().get(Direccion.class, idDireccion);
		
	}

	@Override
	public List<Direccion> getAllDireccion() {
		
		Query<Direccion> query = session.getCurrentSession().
				createQuery("from DIRECCION", Direccion.class);
		List<Direccion> allDireccion = query.getResultList();
		
		return allDireccion;
	}

}
