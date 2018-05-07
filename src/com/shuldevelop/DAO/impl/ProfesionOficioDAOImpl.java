package com.shuldevelop.DAO.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.ProfesionOficioDAO;
import com.shuldevelop.model.ProfesionOficio;

@Service
public class ProfesionOficioDAOImpl implements ProfesionOficioDAO {
	@Autowired
	private SessionFactory session;

	@Override
	public void add(ProfesionOficio profesionOficio) {
		session.getCurrentSession().save(profesionOficio);

	}

	@Override
	public void edit(ProfesionOficio profesionOficio) {
		session.getCurrentSession().update(profesionOficio);

	}

	@Override
	public void delete(int idProfesionOficio) {
		session.getCurrentSession().delete(getProfesionOficio(idProfesionOficio));

	}

	@Override
	public ProfesionOficio getProfesionOficio(int idProfesionOficio) {
		return (ProfesionOficio)session.getCurrentSession().get(ProfesionOficio.class, idProfesionOficio);
	}

	@Override
	public List<ProfesionOficio> getAllProfesionOficio() {
		Query<ProfesionOficio> query = session.getCurrentSession().
				createQuery("from PROFESION_OFICIO", ProfesionOficio.class);
		
		List<ProfesionOficio> allProfesionOficio = query.getResultList();
		return allProfesionOficio;
	}

}
