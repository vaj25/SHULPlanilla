package com.shuldevelop.DAO.impl;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.ZonaDAO;
import com.shuldevelop.model.Zona;

@Service
public class ZonaDAOImpl implements ZonaDAO {

	@Autowired
	private SessionFactory session;
	
	@Override
	public Zona getZona(int idZona) {
		
		return (Zona) session.getCurrentSession().get(Zona.class, idZona);
	}

	@Override
	public List<Zona> getAllZona() {

		Query<Zona> query = session.getCurrentSession().
				createQuery("from ZONA", Zona.class);
		
		List<Zona> allZona = query.getResultList();
		
		return allZona;
	}
	
	@Override
	public void add(Zona zona) {
		session.getCurrentSession().save(zona);
	}
	
	@Override
	public void edit(Zona zona) {
		session.getCurrentSession().update(zona);
	}
	
	@Override
	public void delete(int idZona) {
		session.getCurrentSession().delete(getZona(idZona));
	}

}
