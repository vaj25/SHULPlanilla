package com.shuldevelop.model.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shuldevelop.model.CentroCosto;


public class CentroCostoValidator implements Validator {
	
	public boolean supports(Class<?> arg0) {
		
		return CentroCosto.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "monto", 
				"required.monto", "El Monto es obligatorio.");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "periocidad", 
				"required.periocidad", "El periodo es obligatorio.");
		
		CentroCosto centroCosto = (CentroCosto) arg0;

		if ( centroCosto.getMonto() < 0 ) {
			arg1.rejectValue("numeroNivel", "numeroNivel.incorrect", 
					"El número nivel tiene que ser positivo.");
		}		

	}

}
