package com.shuldevelop.service;

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

}
