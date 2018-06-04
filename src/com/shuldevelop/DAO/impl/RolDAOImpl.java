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
	public void add(Rol rol) {
		
		session.getCurrentSession().saveOrUpdate(rol);
		
	}

	@Override
	public void edit(Rol rol) {
		
		session.getCurrentSession().saveOrUpdate(rol);
		
	}

	@Override
	public void delete(int idRol) {
		
		session.getCurrentSession().delete( getRol(idRol) );
		
	}
	
	@Override
	public boolean hasRolModuloPermiso(int idRol) {
		
		Query<Long> query = session.getCurrentSession()
				.createQuery("SELECT count(a) FROM ROL a " + 
						"JOIN ROL_MODULO_PERMISO b ON b.rol = a.id " +
						"WHERE a.id = :id_rol ", Long.class)
				.setParameter("id_rol", idRol);
		
		Long count = query.uniqueResult();
		
		if ( count > 0 ) {
			return true;
		}
		
		return false;
		
	}
	
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
