package com.shuldevelop.model.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shuldevelop.model.ProfesionOficio;


public class ProfesionOficioValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return ProfesionOficio.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "profesion_oficio", 
				"required.profesion_oficio", "La profesion es obligatoria.");

	}

}
