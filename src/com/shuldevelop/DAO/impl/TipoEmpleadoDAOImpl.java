package com.shuldevelop.DAO.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.TipoEmpleadoDAO;

import com.shuldevelop.model.TipoEmpleado;

@Service
public class TipoEmpleadoDAOImpl implements TipoEmpleadoDAO{
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(TipoEmpleado tipoEmpleado) {
		
		session.getCurrentSession().saveOrUpdate(tipoEmpleado);

	}

	@Override
	public void edit(TipoEmpleado tipoEmpleado) {
		
		session.getCurrentSession().saveOrUpdate(tipoEmpleado);

	}

	@Override
	public void delete(int idTipoEmpleado) {
		
		session.getCurrentSession().delete(getTipoEmpleado(idTipoEmpleado));

	}

	@Override
	public TipoEmpleado getTipoEmpleado(int idTipoEmpleado) {

		return (TipoEmpleado) session.getCurrentSession().get(TipoEmpleado.class, idTipoEmpleado);

		
	}

	@Override
	public List<TipoEmpleado> getAllTipoEmpleado() {
		Query<TipoEmpleado> query = session.getCurrentSession().
				createQuery("from TIPO_EMPLEADO", TipoEmpleado.class);
		
		List<TipoEmpleado> getAllTipoEmpleado = query.getResultList();
		
		return getAllTipoEmpleado;
		
	}
	
}
