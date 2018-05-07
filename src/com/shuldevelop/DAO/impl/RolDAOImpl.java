package com.shuldevelop.DAO.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.RolDAO;
import com.shuldevelop.model.Rol;

@Service
public class RolDAOImpl implements RolDAO {
	
	@Autowired
	private SessionFactory session;

	@Override
	public Rol getRol(int idRol) {
		
		return session.getCurrentSession().get(Rol.class, idRol);
		
	}

	@Override
	public List<Rol> getAllRol() {
		
		Query<Rol> query = session.getCurrentSession().
				createQuery("from ROL", Rol.class);
		List<Rol> allRol = query.getResultList();
		
		return allRol;
		
	}

}
