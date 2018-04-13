package com.shuldevelop.DAO;

import com.shuldevelop.model.Usuario;

public interface UsuarioDAO {
	
	Usuario findUserByUsername (String username);

}
