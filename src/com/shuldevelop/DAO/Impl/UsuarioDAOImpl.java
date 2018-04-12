package com.shuldevelop.DAO.Impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shuldevelop.DAO.UsuarioDAO;
import com.shuldevelop.model.Usuario;

@Service(value="UsuarioDAO")
public class UsuarioDAOImpl implements UsuarioDAO {

	@Autowired(required=true)
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public Usuario findUserByUsername(String username) {
		
		return (Usuario) sessionFactory.getCurrentSession().createQuery(
				"from Usuario where username = :username and estado=true")
				.setParameter("username", username)
				.uniqueResult();
	}

}
