package com.shuldevelop.DAO.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.ModuloDAO;
import com.shuldevelop.model.Modulo;

@Service
public class ModuloDAOImpl implements ModuloDAO {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(Modulo modulo) {
		
		session.getCurrentSession().saveOrUpdate(modulo);

	}

	@Override
	public void edit(Modulo modulo) {
		
		session.getCurrentSession().saveOrUpdate(modulo);

	}

	@Override
	public void delete(int idModulo) {

		session.getCurrentSession().delete(getModulo(idModulo));

	}

	@Override
	public Modulo getModulo(int idModulo) {
		
		return (Modulo) session.getCurrentSession().get(Modulo.class, idModulo);
		
	}

	@Override
	public List<Modulo> getAllModulo() {
		
		Query<Modulo> query = session.getCurrentSession()
				.createQuery("from MODULO", Modulo.class);
		
		List<Modulo> allModulo = query.getResultList();
		return allModulo;
		
	}

	@Override
	public List<Modulo> getAllModuloByRol(int idRol) {
		
		Query<Modulo> query = session.getCurrentSession()
				.createQuery("from MODULO", Modulo.class);
		
		List<Modulo> allModulo = query.getResultList();
		return allModulo;
		
	}

}
