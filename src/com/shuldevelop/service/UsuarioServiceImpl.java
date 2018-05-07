package com.shuldevelop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.UsuarioDAO;
import com.shuldevelop.model.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
    private UsuarioDAO userDao;
	
	@Override
	public Usuario findUserByUsername(String username) {
	
		return userDao.findUserByUsername(username);
	}

	@Override
	public void add(Usuario usuario) {
		
		userDao.add(usuario);
		
	}

	@Override
	public void edit(Usuario usuario) {
		
		userDao.edit(usuario);
		
	}

	@Override
	public void delete(int idUsuario) {
		
		userDao.delete(idUsuario);
		
	}

	@Override
	public Usuario getUsuario(int idUsuario) {
		
		return userDao.getUsuario(idUsuario);
		
	}

	@Override
	public List<Usuario> getAllUsuario() {
		
		return userDao.getAllUsuario();
		
	}

}
