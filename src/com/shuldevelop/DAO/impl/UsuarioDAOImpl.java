package com.shuldevelop.DAO.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shuldevelop.DAO.AbstractDao;
import com.shuldevelop.DAO.UsuarioDAO;
import com.shuldevelop.model.Usuario;

@Service("UsuarioDAO")
public class UsuarioDAOImpl extends AbstractDao<Integer, Usuario> implements UsuarioDAO {
	
	@Override
	@Transactional
	public Usuario findUserByUsername(String username) {
		
		Session session = getSession();
		
		return (Usuario) session.createQuery(
				"from Usuario where username = :username and estado=true")
				.setParameter("username", username)
				.uniqueResult();
		
	}

}
