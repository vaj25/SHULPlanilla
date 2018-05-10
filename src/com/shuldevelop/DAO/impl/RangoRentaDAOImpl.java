package com.shuldevelop.DAO.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.RangoRentaDAO;
import com.shuldevelop.model.RangoRenta;

@Service
public class RangoRentaDAOImpl implements RangoRentaDAO {

	@Autowired
	private SessionFactory session;

	@Override
	public void add(RangoRenta rangoRenta) {

		session.getCurrentSession().saveOrUpdate(rangoRenta);

	}

	@Override
	public void edit(RangoRenta rangoRenta) {

		session.getCurrentSession().saveOrUpdate(rangoRenta);

	}

	@Override
	public void delete(int idRangoRenta) {

		session.getCurrentSession().delete(idRangoRenta);

	}

	@Override
	public RangoRenta getRangoRenta(int idRangoRenta) {

		return session.getCurrentSession().get(RangoRenta.class, idRangoRenta);

	}

	@Override
	public List<RangoRenta> getAllRangoRenta() {

		Query<RangoRenta> query = session.getCurrentSession().
				createQuery("from RANGO_RENTA", RangoRenta.class);
		List<RangoRenta> allRangoRenta = query.getResultList();

		return allRangoRenta;

	}

}
