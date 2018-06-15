package com.shuldevelop.DAO.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.InfoLaboralEmpleadoDAO;
import com.shuldevelop.model.InfoLaboralEmpleado;

@Service
public class InfoLaboralEmpleadoDAOImpl implements InfoLaboralEmpleadoDAO {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(InfoLaboralEmpleado infoLaboralEmpleado) {
		// TODO Auto-generated method stub
		
		session.getCurrentSession().save(infoLaboralEmpleado);

	}

	@Override
	public void edit(InfoLaboralEmpleado infoLaboralEmpleado) {
		// TODO Auto-generated method stub
		
		session.getCurrentSession().update(infoLaboralEmpleado);


	}

	@Override
	public void delete(int id_info_laboral_empleado) {
		// TODO Auto-generated method stub
		
		session.getCurrentSession().delete(getInfoLaboralEmpleado(id_info_laboral_empleado));


	}

	@Override
	public InfoLaboralEmpleado getInfoLaboralEmpleado(int id_info_laboral_empleado) {
		// TODO Auto-generated method stub
		
		return (InfoLaboralEmpleado) session.getCurrentSession().get(InfoLaboralEmpleado.class, id_info_laboral_empleado);

	}
	
	@Override
	public List<InfoLaboralEmpleado> getAllInfoLaboralEmpleado() {
		// TODO Auto-generated method stub
		Query<InfoLaboralEmpleado> query = session.getCurrentSession().
				createQuery("from INFO_LABORAL_EMPLEADO", InfoLaboralEmpleado.class);
		
		List<InfoLaboralEmpleado> getAllInfoLaboralEmpleado = query.getResultList();
		
		return getAllInfoLaboralEmpleado;
	}
	
	@Override
	public InfoLaboralEmpleado getInfobyIdEmpleado(int idEmpleado) {
		// TODO Auto-generated method stub
		try {
			Query<InfoLaboralEmpleado> query = session.getCurrentSession().
					createQuery("from INFO_LABORAL_EMPLEADO where id = "
							+ "(select max(id) from  INFO_LABORAL_EMPLEADO "
							+ "where id_empleado = :idEmpleado)", InfoLaboralEmpleado.class)
					.setParameter("idEmpleado", idEmpleado);
			
			InfoLaboralEmpleado getInfoLaboralEmpleado = query.getSingleResult();
			
			return getInfoLaboralEmpleado;
		}
		catch(Exception e) {
			InfoLaboralEmpleado getInfoLaboralEmpleado = null;
			return getInfoLaboralEmpleado;
		}
	}
}
