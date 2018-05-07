package com.shuldevelop.DAO.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.RangoComisionDAO;
import com.shuldevelop.model.RangoComision;

@Service
public class RangoComisionDAOImpl implements RangoComisionDAO {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(RangoComision rangoComision) {
		
		session.getCurrentSession().saveOrUpdate(rangoComision);

	}

	@Override
	public void edit(RangoComision rangoComision) {
		
		session.getCurrentSession().saveOrUpdate(rangoComision);

	}

	@Override
	public void delete(int idRangoComision) {
		
		session.getCurrentSession().delete(idRangoComision);

	}

	@Override
	public RangoComision getRangoComision(int idRangoComision) {
		
		return session.getCurrentSession().get(RangoComision.class, idRangoComision);
		
	}

	@Override
	public List<RangoComision> getAllRangoComision() {
		
		Query<RangoComision> query = session.getCurrentSession().
				createQuery("from RANGO_COMISION", RangoComision.class);
		List<RangoComision> allRangoComision = query.getResultList();
		
		return allRangoComision;
		
	}

}
