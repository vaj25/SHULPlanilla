package com.shuldevelop.DAO.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.CentroCostoDAO;
import com.shuldevelop.model.CentroCosto;


@Service
public class CentroCostoDAOImpl implements CentroCostoDAO {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(CentroCosto centroCosto) {
		// TODO Auto-generated method stub
		
		session.getCurrentSession().saveOrUpdate(centroCosto);

	}

	@Override
	public void edit(CentroCosto centroCosto) {
		// TODO Auto-generated method stub
		
		session.getCurrentSession().saveOrUpdate(centroCosto);


	}

	@Override
	public void delete(int id_centro_costo) {
		// TODO Auto-generated method stub
		
		session.getCurrentSession().delete(getCentroCosto(id_centro_costo));


	}

	@Override
	public CentroCosto getCentroCosto(int id_centro_costo) {
		// TODO Auto-generated method stub
		
		return (CentroCosto) session.getCurrentSession().get(CentroCosto.class, id_centro_costo);

	}

	@Override
	public List<CentroCosto> getAllCentroCosto() {
		// TODO Auto-generated method stub
		Query<CentroCosto> query = session.getCurrentSession().
				createQuery("from CENTRO_COSTO", CentroCosto.class);
		
		List<CentroCosto> getAllCentroCosto = query.getResultList();
		
		return getAllCentroCosto;
	}

}
