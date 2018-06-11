package com.shuldevelop.DAO.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.EmpleadoDAO;
import com.shuldevelop.model.Empleado;
@Service
public class EmpleadoDAOImpl implements EmpleadoDAO {
	@Autowired
	private SessionFactory session;
	@Override
	public void add(Empleado empleado) {
		session.getCurrentSession().save(empleado);

	}

	@Override
	public void edit(Empleado empleado) {
		session.getCurrentSession().update(empleado);

	}

	@Override
	public void delete(int idEmpleado) {
		session.getCurrentSession().delete(getEmpleado(idEmpleado));

	}

	@Override
	public Empleado getEmpleado(int idEmpleado) {
		return (Empleado)session.getCurrentSession().get(Empleado.class, idEmpleado);
	}

	@Override
	public List<Empleado> getAllEmpleado() {
		Query<Empleado> query = session.getCurrentSession()
				.createQuery("from Empleado",Empleado.class);
		
		List<Empleado> allEmpleado = query.getResultList();
		return allEmpleado;
	}
	
	@Override
	public List<Empleado> getAllSub(int idEmpleado){
		Query<Empleado> query = session.getCurrentSession()
				.createQuery("from Empleado where emp_id_empleado = :idEmpleado",Empleado.class)
				.setParameter("idEmpleado", idEmpleado);
		List<Empleado> allSub = query.getResultList();
		return allSub;
	}
	
	@Override
	public List<Empleado> getDui(String dui) {
		Query<Empleado> query = session.getCurrentSession()
				.createQuery("from Empleado where doc_identidad = :dui",Empleado.class)
				.setParameter("dui", dui);
		List<Empleado> alldui = query.getResultList();
		return alldui;
	}
	
	@Override
	public List<Empleado> getNit(String Nnit){
		Query<Empleado> query = session.getCurrentSession()
				.createQuery("from Empleado where nit = :Nnit",Empleado.class)
				.setParameter("Nnit", Nnit);
		List<Empleado> allnit = query.getResultList();
		return allnit;
	}
	
	@Override
	public List<Empleado> getIsss(int Nisss){
		Query<Empleado> query = session.getCurrentSession()
				.createQuery("from Empleado where isss = :Nisss",Empleado.class)
				.setParameter("Nisss", Nisss);
		List<Empleado> allisss = query.getResultList();
		return allisss;
	}
	
	@Override
	public List<Empleado> getNup(long Nnup){
		Query<Empleado> query = session.getCurrentSession()
				.createQuery("from Empleado where nup = :Nnup",Empleado.class)
				.setParameter("Nnup", Nnup);
		List<Empleado> allnup = query.getResultList();
		return allnup;
	}
	
	@Override
	public List<Empleado> getEmpEmail(String emailEmp){
		Query<Empleado> query = session.getCurrentSession()
				.createQuery("from Empleado where email_pers = :emailEmp",Empleado.class)
				.setParameter("emailEmp", emailEmp);
		List<Empleado> allEmail = query.getResultList();
		return allEmail;
	}
	
	@Override
	public List<Empleado> getInsEmail(String emailInst){
		Query<Empleado> query = session.getCurrentSession()
				.createQuery("from Empleado where email_inst = :emailInst",Empleado.class)
				.setParameter("emailInst", emailInst);
		List<Empleado> allEmailIns = query.getResultList();
		return allEmailIns;
	}
	
	@Override
	public List<Empleado> getOneEmpleado(int idEmpleado) {
		Query<Empleado> query = session.getCurrentSession()
				.createQuery("from Empleado where id_empleado= :idEmpleado",Empleado.class)
				.setParameter("idEmpleado", idEmpleado);
		
		List<Empleado> OneEmpleado = query.getResultList();
		return OneEmpleado;
	}
}
