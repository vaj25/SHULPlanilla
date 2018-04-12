package com.shulplanilla.DAO.Impl;

import org.hibernate.SessionFactory;

import com.shuldevelop.model.Usuario;
import com.shulplanilla.DAO.UsuarioDAO;

public class UsuarioDAOImpl implements UsuarioDAO {

	private SessionFactory sessionFactory;
	
	@Override
	public Usuario findUserByUsername(String username) {
		
		return (Usuario) sessionFactory.getCurrentSession().createQuery(
				"from Usuario where username = :username and estado=true")
				.setParameter("username", username)
				.uniqueResult();
	}

}
