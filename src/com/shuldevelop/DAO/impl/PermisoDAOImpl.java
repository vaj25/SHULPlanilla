package com.shuldevelop.DAO.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.PermisoDAO;
import com.shuldevelop.model.Permiso;

@Service
public class PermisoDAOImpl implements PermisoDAO {

	@Autowired
	private SessionFactory session;
	
	@Override
	public Permiso getPermiso(int idPermiso) {
		
		return (Permiso) session.getCurrentSession().get(Permiso.class, idPermiso);
		
	}

}
