package com.shuldevelop.model.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shuldevelop.model.RangoComision;

public class RangoComisionValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		
		return RangoComision.class.isAssignableFrom(arg0);
		
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "desde", 
				"required.desde", "El valor desde es obligatorio.");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "hasta", 
				"required.hasta", "El valor hasta es obligatorio.");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "tasa", 
				"required.tasa", "La tasa es obligatorio.");
		
		RangoComision rangoComision = (RangoComision) arg0;
		
		if (rangoComision.getTipoIngreso().getId() == 0) {
			arg1.rejectValue("tipoIngreso", "tipoIngreso.incorrect", 
					"El tipoIngreso es obligatorio.");
		}
		
		if ( rangoComision.getDesde() < 0 ) {
			arg1.rejectValue("desde", "desde.incorrect", 
					"El valor desde tiene que ser positivo.");
		}
		
		if ( rangoComision.getHasta() < 0 ) {
			arg1.rejectValue("hasta", "hasta.incorrect", 
					"El valor hasta tiene que ser positivo.");
		}
		
		if ( rangoComision.getTasa() < 0 ) {
			arg1.rejectValue("tasa", "tasa.incorrect", 
					"La tasa tiene que ser positivo.");
		}

	}

}
