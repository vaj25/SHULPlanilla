package com.shuldevelop.model.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shuldevelop.model.EstadoCivil;

public class EstadoCivilValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> arg0) {
		
		return EstadoCivil.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "estadoCivil", 
				"required.estadoCivil", "El estado civil es obligatorio.");

	}

}
