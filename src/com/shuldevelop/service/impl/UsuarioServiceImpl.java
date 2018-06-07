package com.shuldevelop.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.UsuarioDAO;
import com.shuldevelop.model.Usuario;
import com.shuldevelop.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
    private UsuarioDAO userDao;
	
	@Transactional
	public Usuario findUserByUsername(String username) {
	
		return userDao.findUserByUsername(username);
	}

	@Transactional
	public void add(Usuario usuario) {
		
		userDao.add(usuario);
		
	}

	@Transactional
	public void edit(Usuario usuario) {
		
		userDao.edit(usuario);
		
	}

	@Transactional
	public void delete(int idUsuario) {
		
		userDao.delete(idUsuario);
		
	}

	@Transactional
	public Usuario getUsuario(int idUsuario) {
		
		return userDao.getUsuario(idUsuario);
		
	}
	
	@Transactional
	public Usuario getUsuarioAdmin() {
		
		return userDao.getUsuarioAdmin();
		
	}

	@Transactional
	public List<Usuario> getAllUsuario() {
		
		return userDao.getAllUsuario();
		
	}

}
