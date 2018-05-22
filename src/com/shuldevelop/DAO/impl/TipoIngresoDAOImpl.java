package com.shuldevelop.DAO.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.TipoIngresoDAO;
import com.shuldevelop.model.TipoIngreso;

@Service
public class TipoIngresoDAOImpl implements TipoIngresoDAO {
	
	@Autowired
	private SessionFactory session;

	@Override
	public void add(TipoIngreso tipoIngreso) {
		
		session.getCurrentSession().saveOrUpdate(tipoIngreso);

	}

	@Override
	public void edit(TipoIngreso tipoIngreso) {
		
		session.getCurrentSession().saveOrUpdate(tipoIngreso);

	}

	@Override
	public void delete(int idTipoIngreso) {
		
		session.getCurrentSession().delete(getTipoIngreso(idTipoIngreso));

	}

	@Override
	public TipoIngreso getTipoIngreso(int idTipoIngreso) {
		
		return (TipoIngreso) session.getCurrentSession().get(TipoIngreso.class, idTipoIngreso);
		
	}

	@Override
	public List<TipoIngreso> getAllTipoIngreso() {
		
		Query<TipoIngreso> query = session.getCurrentSession().
				createQuery("from TIPO_INGRESO", TipoIngreso.class);
		List<TipoIngreso> allTipoIngreso = query.getResultList();
		
		return allTipoIngreso;
		
	}

}
