package com.shuldevelop.DAO.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.PuestoDAO;
import com.shuldevelop.model.Puesto;

@Service
@Transactional
public class PuestoDAOImpl implements PuestoDAO {

	@Autowired
	private SessionFactory session;
	
	
	public void add(Puesto puesto) {
		
		session.getCurrentSession().save(puesto);
		
	}

	
	public void edit(Puesto puesto) {
		
		session.getCurrentSession().update(puesto);
		
	}

	
	public void delete(int idPuesto) {
		
		session.getCurrentSession().delete(getPuesto(idPuesto));
		
	}
	
	public boolean hasPuestoEmpleado(int idPuesto) {
		
		return false;
	}

	
	public Puesto getPuesto(int idPuesto) {
		
		return (Puesto) session.getCurrentSession().get(Puesto.class, idPuesto);
		
	}

	
	public List<Puesto> getAllPuesto() {
		
        Query<Puesto> query = session.getCurrentSession().
        		createQuery("from PUESTO", Puesto.class);
        List<Puesto> puestoList = query.list();

        return puestoList;
		
	}

}
