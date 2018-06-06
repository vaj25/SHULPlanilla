package com.shuldevelop.service;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.shuldevelop.model.BitacoraLogin;
import com.shuldevelop.model.TipoLogin;
import com.shuldevelop.model.Usuario;

@Component("customAuthenticationFailureHandler")
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	
	@Autowired
	private BitacoraLoginService bitacoraLoginService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, 
			HttpServletResponse response, AuthenticationException exception) 
			throws IOException, ServletException {
		
	  super.onAuthenticationFailure(request, response, exception);
	  
	  String accountId = request.getParameter("username"); 
		
	  Usuario usuario =  usuarioService.findUserByUsername(accountId);
	  
	  if(exception.getClass().isAssignableFrom(BadCredentialsException.class)) {
		  try {
			  bitacoraLoginService.add(new BitacoraLogin(
					  new Date(),
					  TipoLogin.BADCREDENTIAL,
					  usuario
			  ));  
		  } catch (Exception e) {
			// TODO: handle exception
		  }
		  
		  setDefaultFailureUrl("/login.html?error=credential");
	    
	  } else if (exception.getClass().isAssignableFrom(DisabledException.class)) {
		  try {
			  bitacoraLoginService.add(new BitacoraLogin(
					  new Date(),
					  TipoLogin.DISABLE,
					  usuario
			  ));
			} catch (Exception e) {
				// TODO: handle exception
			}
		  
		  setDefaultFailureUrl("/login.html?error=disable");
		  
	  }
	  
	}
	
}
