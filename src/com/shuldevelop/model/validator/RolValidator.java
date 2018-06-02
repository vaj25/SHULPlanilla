package com.shuldevelop.model.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shuldevelop.model.Rol;

public class RolValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		
		return Rol.class.isAssignableFrom(arg0);
		
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "nombre", 
				"required.nombre", "El nombre del rol es obligatorio.");

	}

}
