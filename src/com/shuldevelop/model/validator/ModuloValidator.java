package com.shuldevelop.model.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shuldevelop.model.Modulo;

public class ModuloValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		
		return Modulo.class.isAssignableFrom(arg0);
		
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "nombre", 
				"required.nombre", "El nombre del modulo es obligatorio.");
		
		Modulo modulo = (Modulo) arg0;
		
		if (modulo.getOrden() == 0) {
			arg1.rejectValue("orden", "orden.incorrect", 
					"El orden es obligatorio.");
		}
		
		if (modulo.getOpciones() == 0) {
			arg1.rejectValue("opciones", "opciones.incorrect", 
					"Las opciones son obligatorias.");
		}

	}

}
