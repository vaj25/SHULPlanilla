package com.shuldevelop.DAO.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.NivelEstructuraDAO;
import com.shuldevelop.model.NivelEstructura;
@Service
public class NivelEstructuraDAOImpl implements NivelEstructuraDAO {
	@Autowired
	private SessionFactory session;
	@Override
	public void add(NivelEstructura nivelestructura) {
		session.getCurrentSession().save(nivelestructura);

	}

	@Override
	public void edit(NivelEstructura nivelestructura) {
		session.getCurrentSession().update(nivelestructura);

	}

	@Override
	public void delete(int idNivelEstructura) {
		session.getCurrentSession().delete(getNivelEstructura(idNivelEstructura));

	}

	@Override
	public NivelEstructura getNivelEstructura(int idNivelEstructura) {
		return (NivelEstructura)session.getCurrentSession().get(NivelEstructura.class, idNivelEstructura);
	}

	@Override
	public List<NivelEstructura> getAllNivelEstructura() {
		Query<NivelEstructura> query = session.getCurrentSession()
				.createQuery("from NIVEL_ESTRUCTURA",NivelEstructura.class);
		
		List<NivelEstructura> allNivelEstructura = query.getResultList();
		return allNivelEstructura;
	}

}
