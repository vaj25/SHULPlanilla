package com.shuldevelop.model.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shuldevelop.model.Puesto;

public class PuestoValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		
		return Puesto.class.isAssignableFrom(arg0);
		
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "nombre", 
				"required.nombre", "El nombre del puesto es obligatorio.");
		
		Puesto puesto = (Puesto) arg0;
		
		if (puesto.getNivelPuesto().getId() == 0) {
			arg1.rejectValue("nivelPuesto", "nivelPuesto.incorrect", 
					"El nivel del puesto es obligatorio.");
		}

	}

}
