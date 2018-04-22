package com.shuldevelop.DAO.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.NivelPuestoDAO;
import com.shuldevelop.model.NivelPuesto;

@Service
public class NivelPuestoDAOImpl implements NivelPuestoDAO {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(NivelPuesto tipoPuesto) {
		
		session.getCurrentSession().save(tipoPuesto);

	}

	@Override
	public void edit(NivelPuesto tipoPuesto) {
		
		session.getCurrentSession().update(tipoPuesto);

	}

	@Override
	public void delete(int idTipoPuesto) {

		session.getCurrentSession().delete(getTipoPuesto(idTipoPuesto));

	}

	@Override
	public NivelPuesto getTipoPuesto(int idTipoPuesto) {
		
		return (NivelPuesto) session.getCurrentSession().get(NivelPuesto.class, idTipoPuesto);
		
	}

	@Override
	public List<NivelPuesto> getAllTipoPuesto() {
		
		Query<NivelPuesto> query = session.getCurrentSession().
				createQuery("from NIVEL_PUESTO", NivelPuesto.class);
		
		List<NivelPuesto> allTipoPuesto = query.getResultList();
		
		return allTipoPuesto;
		
	}

}
