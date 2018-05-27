package com.shuldevelop.DAO.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.UnidadOrganizacionalDAO;
import com.shuldevelop.model.UnidadOrganizacional;
@Service
public class UnidadOrganizacionalDAOImpl implements UnidadOrganizacionalDAO {
	@Autowired
	private SessionFactory session;
	@Override
	public void add(UnidadOrganizacional unidadorganizacional) {
		session.getCurrentSession().save(unidadorganizacional);

	}

	@Override
	public void edit(UnidadOrganizacional unidadorganizacional) {
		session.getCurrentSession().update(unidadorganizacional);

	}

	@Override
	public void delete(int idUnidadOrganizacional) {
		session.getCurrentSession().delete(getUnidadOrganizacional(idUnidadOrganizacional));

	}

	@Override
	public UnidadOrganizacional getUnidadOrganizacional(int idUnidadOrganizacional) {
		return (UnidadOrganizacional)session.getCurrentSession().get(UnidadOrganizacional.class, idUnidadOrganizacional);
	}

	@Override
	public List<UnidadOrganizacional> getAllUnidadOrganizacional() {
		Query<UnidadOrganizacional> query = session.getCurrentSession()
				.createQuery("from UNIDAD_ORGANIZACIONAL",UnidadOrganizacional.class);
		
		List<UnidadOrganizacional> allUnidadOrganizacional = query.getResultList();
		return allUnidadOrganizacional;
	}

}
