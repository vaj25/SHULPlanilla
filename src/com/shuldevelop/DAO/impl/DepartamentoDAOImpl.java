package com.shuldevelop.DAO.impl;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.DepartamentoDAO;
import com.shuldevelop.model.Departamento;

@Service
public class DepartamentoDAOImpl implements DepartamentoDAO {

	@Autowired
	private SessionFactory session;
	
	@Override
	public Departamento getDepartamento(int idDepartamento) {
		
		return (Departamento) session.getCurrentSession().get(Departamento.class, idDepartamento);
	}

	@Override
	public List<Departamento> getAllDepartamento() {
		
		Query<Departamento> query = session.getCurrentSession().
				createQuery("from DEPARTAMENTO", Departamento.class);
		
		List<Departamento> allDepartamento = query.getResultList();
		
		return allDepartamento;
	}

	@Override
	public List<Departamento> findDepartamentoByZona(int idZona) {
		
		Query<Departamento> query = session.getCurrentSession().
				createQuery("from DEPARTAMENTO where id_est_territorial = :id_zona", Departamento.class)
				.setParameter("id_zona", idZona);;
		
		List<Departamento> allDepartamento = query.getResultList();
		
		return allDepartamento;
	}

}
