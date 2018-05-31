package com.shuldevelop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shuldevelop.model.Usuario;
import com.shuldevelop.service.UsuarioService;

@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService {	
	
	@Autowired(required=true)
	private UsuarioService userService;
	
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario user = userService.findUserByUsername(username);
		UserBuilder builder = null;
		
		if (user != null) {
			
			builder = org.springframework.security.core.userdetails.User.withUsername(username);
			builder.disabled( (user.getEstado() == 1) ? false : true);
			builder.password(user.getPassword());
			builder.authorities(user.getRol().getNombreRol());
			
		} else {
			
			throw new UsernameNotFoundException("Usuario no encontrado.");
			
		}
		
		return builder.build();
	}

}
