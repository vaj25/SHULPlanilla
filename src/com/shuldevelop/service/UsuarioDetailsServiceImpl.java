package com.shuldevelop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shuldevelop.DAO.UsuarioDAO;
import com.shuldevelop.model.Usuario;

@Service("userDetailsService")
public class UsuarioDetailsServiceImpl implements UserDetailsService {

	@Autowired(required=true)
	private UsuarioDAO userDao;
	
	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Usuario user = userDao.findUserByUsername(username);
		UserBuilder builder = null;
		
		if (user != null) {
			
			builder = org.springframework.security.core.userdetails.User.withUsername(username);
			builder.disabled(!user.isEstado());
			builder.password(user.getPassword());
			builder.authorities(user.getRol().getNombreRol());
			
		} else {
			
			throw new UsernameNotFoundException("Usuario no encontrado.");
			
		}
		
		return builder.build();
	}

}
