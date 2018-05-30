package com.shuldevelop.DAO.impl;


import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.CentroDeptoDAO;
import com.shuldevelop.model.CentroDepto;
import com.shuldevelop.model.CentroDeptoPK;

@Service
public class CentroDeptoDAOImpl implements CentroDeptoDAO {
	
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(CentroDepto centroDepto) {
		// TODO Auto-generated method stub
		
		session.getCurrentSession().saveOrUpdate(centroDepto);

	}

	@Override
	public void edit(CentroDepto centroDepto) {
		// TODO Auto-generated method stub
		
		session.getCurrentSession().saveOrUpdate(centroDepto);


	}

	@Override
	public void delete(CentroDeptoPK id_centro_depto) {
		// TODO Auto-generated method stub
		
		session.getCurrentSession().delete(getCentroDepto(id_centro_depto));


	}

	@Override
	public CentroDepto getCentroDepto(CentroDeptoPK id_centro_depto) {
		// TODO Auto-generated method stub
		
		return (CentroDepto) session.getCurrentSession().get(CentroDepto.class, id_centro_depto);

	}

	@Override
	public List<CentroDepto> getAllCentroDepto() {
		// TODO Auto-generated method stub
		Query<CentroDepto> query = session.getCurrentSession().
				createQuery("from CENTRO_DEPTO", CentroDepto.class);
		
		List<CentroDepto> getAllCentroDepto = query.getResultList();
		
		return getAllCentroDepto;
	}

}
