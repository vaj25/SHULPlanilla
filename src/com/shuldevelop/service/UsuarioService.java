package com.shuldevelop.service;

import com.shuldevelop.model.Usuario;

public interface UsuarioService {

	Usuario findUserByUsername (String username);
	
}
