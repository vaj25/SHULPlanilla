
package com.shuldevelop.DAO.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
				"from USUARIO where username = :username")
				.setParameter("username", username)
				.uniqueResult();
		
	}

	@Override
	public void add(Usuario usuario) {
		
		session.getCurrentSession().saveOrUpdate(usuario);
		
	}

	@Override
	public void edit(Usuario usuario) {
		
		session.getCurrentSession().saveOrUpdate(usuario);
		
	}

	@Override
	public void delete(int idUsuario) {
		
		session.getCurrentSession().delete(getUsuario(idUsuario));
		
	}

	@Override
	public Usuario getUsuario(int idUsuario) {
		
		return session.getCurrentSession().get(Usuario.class, idUsuario);
		
	}

	@Override
	public List<Usuario> getAllUsuario() {
		
		Query<Usuario> query = session.getCurrentSession().
				createQuery("from USUARIO", Usuario.class);
		
		List<Usuario> allUsuario = query.getResultList();
		
		return allUsuario;
		
	}

}
