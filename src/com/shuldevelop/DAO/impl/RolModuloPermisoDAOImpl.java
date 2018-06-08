package com.shuldevelop.DAO.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.RolModuloPermisoDAO;
import com.shuldevelop.model.RolModuloPermiso;

@Service
public class RolModuloPermisoDAOImpl implements RolModuloPermisoDAO {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(RolModuloPermiso rolModuloPermiso) {
		
		session.getCurrentSession().saveOrUpdate(rolModuloPermiso);

	}

	@Override
	public void edit(RolModuloPermiso rolModuloPermiso) {
		
		session.getCurrentSession().saveOrUpdate(rolModuloPermiso);

	}

	@Override
	public void delete(int idRolModuloPermiso) {
		
		session.getCurrentSession().delete(getRolModuloPermiso(idRolModuloPermiso));

	}
	
	@Override
	public int getCountRolModuloPermisoByRol(int idRol) {
		
		Query<Long> query = session.getCurrentSession()
				.createQuery("SELECT count(id) FROM ROL_MODULO_PERMISO WHERE id_rol = :id_rol", Long.class)
				.setParameter("id_rol", idRol);
				
		int countRolModuloPermiso =  (int) (long) query.uniqueResult();
		
		return countRolModuloPermiso;
		
	}

	@Override
	public RolModuloPermiso getRolModuloPermiso(int idRolModuloPermiso) {
		
		return (RolModuloPermiso) session.getCurrentSession().get(RolModuloPermiso.class, idRolModuloPermiso);
		
	}
	
	@Override
	public List<RolModuloPermiso> getAllRolModuloPermisoByRol(int idRol, int page, int perPage) {
		
		Query<RolModuloPermiso> query = session.getCurrentSession()
				.createQuery("from ROL_MODULO_PERMISO WHERE id_rol = :id_rol", RolModuloPermiso.class)
				.setParameter("id_rol", idRol);
		
		query.setMaxResults(perPage);
	    query.setFirstResult(page * perPage);
				
		List<RolModuloPermiso> allRolModuloPermiso = query.getResultList();
		return allRolModuloPermiso;
		
	}

}
