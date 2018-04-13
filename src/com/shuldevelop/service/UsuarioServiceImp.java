package com.shuldevelop.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuldevelop.DAO.UsuarioDAO;
import com.shuldevelop.model.Usuario;

@Service("userService")
@Transactional
public class UsuarioServiceImp implements UsuarioService {
	
	@Autowired
    private UsuarioDAO userDao;
	
	@Override
	public Usuario findUserByUsername(String username) {
		
		return userDao.findUserByUsername(username);
	}

}
