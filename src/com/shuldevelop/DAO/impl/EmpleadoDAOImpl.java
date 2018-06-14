package com.shuldevelop.DAO.impl;

import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.EmpleadoDAO;
import com.shuldevelop.model.Empleado;
import com.shuldevelop.model.EmpleadoView;

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
	public List<EmpleadoView> getViewEmpleado(Hashtable<String, String> listParameter) {
		
		int i = 0;
		
		String consulta = "from EmpleadoView";
		
		for (Entry<String, String> entry : listParameter.entrySet() ) {
			
			if ( entry.getValue() != "" ) {
				if (i > 0) {
					consulta += " OR ";
				} else {
					consulta += " WHERE ";
				}
				
				if ( entry.getKey() == "idEmpleado" ) {
					
					consulta += entry.getKey() + " = :" + entry.getKey() + i;
					
				} else {
					
					consulta += entry.getKey() + " LIKE :" + entry.getKey() + i;
					
				}
				i++;
			}		
		}
		
		Query<EmpleadoView> query = session.getCurrentSession()
				.createQuery(consulta, EmpleadoView.class);
		
		int j = 0;
		
		for (Entry<String, String> entry : listParameter.entrySet() ) {
				
			if ( entry.getValue() != "" ) {
			
				if ( entry.getKey() == "idEmpleado" ) {
					
					query.setParameter( entry.getKey() + j , entry.getValue());
					
				} else {
	
					query.setParameter( entry.getKey() + j , "%" + entry.getValue() + "%");
					
				}
				j++;			
			}			
		}
				
		List<EmpleadoView> allEmpleado = query.getResultList();
		return allEmpleado;
		
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
