package com.shuldevelop.DAO.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.TipoDocIdentidadDAO;
import com.shuldevelop.model.TipoDocIdentidad;

@Service
public class TipoDocIdentidadDAOImpl implements TipoDocIdentidadDAO {
	
	@Autowired
	private SessionFactory session;

	@Override
	public void add(TipoDocIdentidad tipoDocIdentidad) {
		
		session.getCurrentSession().save(tipoDocIdentidad);

	}

	@Override
	public void edit(TipoDocIdentidad tipoDocIdentidad) {
		
		session.getCurrentSession().update(tipoDocIdentidad);

	}

	@Override
	public void delete(int idTipoDocIdentidad) {
		
		session.getCurrentSession().delete(getTipoDocIdentidad(idTipoDocIdentidad));

	}

	@Override
	public TipoDocIdentidad getTipoDocIdentidad(int idTipoDocIdentidad) {
		
		return (TipoDocIdentidad) session.getCurrentSession().get(TipoDocIdentidad.class, idTipoDocIdentidad);
		
	}

	@Override
	public List<TipoDocIdentidad> getAllTipoDocIdentidad() {
		
		Query<TipoDocIdentidad> query = session.getCurrentSession().
				createQuery("from TIPO_DOC_IDENTIDAD", TipoDocIdentidad.class);
		
		List<TipoDocIdentidad> allTipoDocIdentidad = query.getResultList();
		
		return allTipoDocIdentidad;
		
	}

}
