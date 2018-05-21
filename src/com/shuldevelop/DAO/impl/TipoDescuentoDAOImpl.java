package com.shuldevelop.DAO.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.TipoDescuentoDAO;
import com.shuldevelop.model.TipoDescuento;

@Service
public class TipoDescuentoDAOImpl implements TipoDescuentoDAO {

	@Autowired
	private SessionFactory session;

	@Override
	public void add(TipoDescuento tipoDescuento) {

		session.getCurrentSession().saveOrUpdate(tipoDescuento);

	}

	@Override
	public void edit(TipoDescuento tipoDescuento) {

		session.getCurrentSession().saveOrUpdate(tipoDescuento);

	}

	@Override
	public void delete(int idTipoDescuento) {
		TipoDescuento tipoDescuento = new TipoDescuento();
		tipoDescuento.setId(idTipoDescuento);
		session.getCurrentSession().delete(tipoDescuento);

	}

	@Override
	public TipoDescuento getTipoDescuento(int idTipoDescuento) {

		return session.getCurrentSession().get(TipoDescuento.class, idTipoDescuento);

	}

	@Override
	public List<TipoDescuento> getAllTipoDescuento() {

		Query<TipoDescuento> query = session.getCurrentSession().
				createQuery("from TIPO_DESCUENTO", TipoDescuento.class);
		List<TipoDescuento> allTipoDescuento = query.getResultList();

		return allTipoDescuento;

	}

}
