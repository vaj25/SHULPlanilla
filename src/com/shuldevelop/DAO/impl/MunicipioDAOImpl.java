package com.shuldevelop.DAO.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.MunicipioDAO;
import com.shuldevelop.model.Municipio;

@Service
public class MunicipioDAOImpl implements MunicipioDAO {
	
	@Autowired
	private SessionFactory session;

	@Override
	public Municipio getMunicipio(int idMunicipio) {
		
		return (Municipio) session.getCurrentSession().get(Municipio.class, idMunicipio);
	}

	@Override
	public List<Municipio> getAllMunicipio() {
		
		Query<Municipio> query = session.getCurrentSession().
				createQuery("from MUNICIPIO", Municipio.class);
		
		List<Municipio> allMunicipio = query.getResultList();
		
		return allMunicipio;
	}

	@Override
	public List<Municipio> findMunicipioByDepartamento(int idDepartamento) {
		
		Query<Municipio> query = session.getCurrentSession().
				createQuery("from MUNICIPIO where id_departamento = :idDepartamento", Municipio.class)
				.setParameter("idDepartamento", idDepartamento);
		
		List<Municipio> allMunicipio = query.getResultList();
		
		return allMunicipio;
	}

}
