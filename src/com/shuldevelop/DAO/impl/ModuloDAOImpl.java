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
	public List<Modulo> getAllModuloParent() {
		
		Query<Modulo> query = session.getCurrentSession()
				.createQuery("from MODULO WHERE dependencia = null", Modulo.class);
		
		List<Modulo> allModulo = query.getResultList();
		return allModulo;
		
	}
	
	@Override
	public List<Modulo> getAllModuloByRol(int idRol) {
		
		Query<Modulo> query = session.getCurrentSession()
				.createQuery("SELECT a FROM MODULO a " + 
						"JOIN ROL_MODULO_PERMISO b ON b.modulo = a.id " +
						"WHERE a.dependencia = NULL "+
						"AND b.rol.id = :id_rol", Modulo.class)
				.setParameter("id_rol", idRol);
		
		List<Modulo> allModulo = query.getResultList();
		
		List<Modulo> modulos = null;
		
		for (Modulo modulo : allModulo) {
			
			Query<Modulo> query1 = session.getCurrentSession()
					.createQuery("SELECT a FROM MODULO a " + 
							"JOIN ROL_MODULO_PERMISO b ON b.modulo = a.id " +
							"WHERE a.dependencia.id = :mod "+
							"AND b.rol.id = :id_rol " +
							"group by a.id, a.nombre, a.descripcion, a.orden, a.dependencia, a.url, a.icono, a.opciones"
							, Modulo.class)
					.setParameter("mod", modulo.getId())
					.setParameter("id_rol", idRol);
			
			modulos = query1.getResultList();
			
			modulo.setModulos(modulos);
			
		}
		
		return allModulo;
		
	}

}
