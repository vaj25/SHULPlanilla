package com.shuldevelop.model.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shuldevelop.model.TipoDocIdentidad;

public class TipoDocIdentidadValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> arg0) {
		
		return TipoDocIdentidad.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "tipo", 
				"required.tipo", "El tipo de documento identidad es obligatorio.");

	}

}
