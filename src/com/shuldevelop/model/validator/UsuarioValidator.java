package com.shuldevelop.model.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shuldevelop.model.Usuario;

public class UsuarioValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		
		return Usuario.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "username", 
				"required.username", "El nombre de usuario es obligatorio.");

		Usuario usuario = (Usuario) arg0;
		
		if (usuario.getRol().getId() == 0) {
			arg1.rejectValue("rol", "rol.incorrect", 
					"El rol es obligatorio.");
		}
		
	}

}
