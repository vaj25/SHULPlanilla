package com.shuldevelop.DAO.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.GeneroDAO;
import com.shuldevelop.model.Genero;

@Service
public class GeneroDAOImpl implements GeneroDAO {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(Genero genero) {
		
		session.getCurrentSession().save(genero);

	}

	@Override
	public void edit(Genero genero) {
		
		session.getCurrentSession().update(genero);

	}

	@Override
	public void delete(int idGenero) {
		
		session.getCurrentSession().delete(getGenero(idGenero));

	}

	@Override
	public Genero getGenero(int idGenero) {

		return (Genero) session.getCurrentSession().get(Genero.class, idGenero);

		
	}

	@Override
	public List<Genero> getAllGenero() {
		Query<Genero> query = session.getCurrentSession().
				createQuery("from GENERO", Genero.class);
		
		List<Genero> getAllGenero = query.getResultList();
		
		return getAllGenero;
		
	}

}
