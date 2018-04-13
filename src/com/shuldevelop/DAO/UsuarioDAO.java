package com.shuldevelop.DAO;

import org.springframework.stereotype.Service;

import com.shuldevelop.model.Usuario;

public interface UsuarioDAO {
	
	Usuario findUserByUsername (String username);

}
