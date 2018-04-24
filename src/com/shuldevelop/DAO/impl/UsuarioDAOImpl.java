
package com.shuldevelop.DAO.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.UsuarioDAO;
import com.shuldevelop.model.Usuario;

@Service
public class UsuarioDAOImpl implements UsuarioDAO {
	
	@Autowired
	private SessionFactory session;
	
	@Override
	public Usuario findUserByUsername(String username) {
		
		return (Usuario) session.getCurrentSession().createQuery(
				"from Usuario where username = :username and estado=true")
				.setParameter("username", username)
				.uniqueResult();
		
	}

}
