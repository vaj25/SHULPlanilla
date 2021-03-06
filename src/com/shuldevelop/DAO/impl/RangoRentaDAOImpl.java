package com.shuldevelop.DAO.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.RangoRentaDAO;
import com.shuldevelop.model.RangoRenta;

@Service
public class RangoRentaDAOImpl implements RangoRentaDAO {

	@Autowired
	private SessionFactory session;

	@Override
	public void add(RangoRenta rangoRenta) {
		session.getCurrentSession().saveOrUpdate(rangoRenta);  
	}
	
	public void up(RangoRenta rangoRenta) {
        @SuppressWarnings("deprecation")
		Query query = session.getCurrentSession().createSQLQuery("CALL actualizarRangoRenta(:idRR)")
      		  .addEntity(RangoRenta.class)
      		  .setParameter("idRR",rangoRenta.getId());
        query.executeUpdate();
	}

	@Override
	public void edit(RangoRenta rangoRenta) {

		session.getCurrentSession().saveOrUpdate(rangoRenta);

	}

	@Override
	public void delete(int idRangoRenta) {
		RangoRenta rangoRenta = new RangoRenta();
		rangoRenta.setId(idRangoRenta);
		session.getCurrentSession().delete(rangoRenta);

	}

	@Override
	public RangoRenta getRangoRenta(int idRangoRenta) {

		return session.getCurrentSession().get(RangoRenta.class, idRangoRenta);

	}

	@Override
	public List<RangoRenta> getAllRangoRenta() {

		Query<RangoRenta> query = session.getCurrentSession().
				createQuery("from RANGO_RENTA", RangoRenta.class);
		List<RangoRenta> allRangoRenta = query.getResultList();

		return allRangoRenta;

	}

}
