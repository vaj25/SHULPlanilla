package com.shuldevelop.DAO;

import org.springframework.stereotype.Service;

import com.shuldevelop.model.Usuario;

@Service("UsuarioDAO")
public interface UsuarioDAO {
	
	Usuario findUserByUsername (String username);

}
