package com.shuldevelop.DAO.impl;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.EstructuraOrgDAO;
import com.shuldevelop.model.EstructuraOrg;


@Service
public class EstructuraOrgDAOImpl implements EstructuraOrgDAO{

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(EstructuraOrg estructuraOrg) {
		// TODO Auto-generated method stub
		
		session.getCurrentSession().saveOrUpdate(estructuraOrg);

	}

	@Override
	public void edit(EstructuraOrg estructuraOrg) {
		// TODO Auto-generated method stub
		
		session.getCurrentSession().saveOrUpdate(estructuraOrg);


	}

	@Override
	public void delete(int id_estructura_org) {
		// TODO Auto-generated method stub
		
		session.getCurrentSession().delete(getEstructuraOrg(id_estructura_org));


	}

	@Override
	public EstructuraOrg getEstructuraOrg(int id_estructura_org) {
		// TODO Auto-generated method stub
		
		return (EstructuraOrg) session.getCurrentSession().get(EstructuraOrg.class, id_estructura_org);

	}

	@Override
	public List<EstructuraOrg> getAllEstructuraOrg() {
		// TODO Auto-generated method stub
		Query<EstructuraOrg> query = session.getCurrentSession().
				createQuery("from ESTRUCTURA_ORG", EstructuraOrg.class);
		
		List<EstructuraOrg> getAllEstructuraOrg = query.getResultList();
		
		return getAllEstructuraOrg;
	}
	
	
	@Override
	public List<EstructuraOrg> getDeptoEstructuraOrg() {
		// TODO Auto-generated method stub
		Query<EstructuraOrg> query = session.getCurrentSession().
				createQuery("from ESTRUCTURA_ORG where ID_NIVEL_ESTRUCTURA = 1", EstructuraOrg.class);
		
		List<EstructuraOrg> getAllEstructuraOrg = query.getResultList();
		System.out.println(query.getResultList());
		
		return getAllEstructuraOrg;
	}

	@Override
	public List<EstructuraOrg> getNivelEstructuraOrg() {
		// TODO Auto-generated method stub
		Query<EstructuraOrg> query = session.getCurrentSession().
				createQuery("from ESTRUCTURA_ORG", EstructuraOrg.class);
		
		List<EstructuraOrg> getAllEstructuraOrg = query.getResultList();
				
		return getAllEstructuraOrg;
	}
	
	@Override
	public List<EstructuraOrg> getListEstEstructuraOrg(int id_estructura_org) {
		// TODO Auto-generated method stub
		Query<EstructuraOrg> query = session.getCurrentSession().
				createQuery("from ESTRUCTURA_ORG where EST_ID_ESTRUCTURA_ORG = :ID_ESTRUCTURA_ORG", EstructuraOrg.class)
				.setParameter("ID_ESTRUCTURA_ORG", id_estructura_org);
		
		List<EstructuraOrg> ListEstEstructuraOrg = query.getResultList();
		return ListEstEstructuraOrg;
	}	
	
}
