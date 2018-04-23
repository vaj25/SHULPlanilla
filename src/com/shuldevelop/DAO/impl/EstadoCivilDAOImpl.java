package com.shuldevelop.DAO.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.EstadoCivilDAO;
import com.shuldevelop.model.EstadoCivil;

@Service
public class EstadoCivilDAOImpl implements EstadoCivilDAO {
	
	@Autowired
	private SessionFactory session;

	@Override
	public void add(EstadoCivil estadoCivil) {
		
		session.getCurrentSession().save(estadoCivil);

	}

	@Override
	public void edit(EstadoCivil estadoCivil) {
		
		session.getCurrentSession().update(estadoCivil);

	}

	@Override
	public void delete(int idEstadoCivil) {
		
		session.getCurrentSession().delete(getEstadoCivil(idEstadoCivil));

	}

	@Override
	public EstadoCivil getEstadoCivil(int idEstadoCivil) {
		
		return (EstadoCivil) session.getCurrentSession().get(EstadoCivil.class, idEstadoCivil);
		
	}

	@Override
	public List<EstadoCivil> getAllEstadoCivil() {
		
		Query<EstadoCivil> query = session.getCurrentSession().
				createQuery("from ESTADO_CIVIL", EstadoCivil.class);
		
		List<EstadoCivil> allEstadoCivil = query.getResultList();
		
		return allEstadoCivil;
		
	}

}
