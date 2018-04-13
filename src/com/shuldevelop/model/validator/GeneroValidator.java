package com.shuldevelop.model.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shuldevelop.model.Genero;


public class GeneroValidator implements Validator {

	public boolean supports(Class<?> arg0) {
		
		return Genero.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "genero", 
				"required.genero", "El Genero es obligatorio.");

	}
	
}
