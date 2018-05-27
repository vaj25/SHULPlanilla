package com.shuldevelop.model.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shuldevelop.model.RangoPlanilla;

public class RangoPlanillaValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		
		return RangoPlanilla.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "venta", 
				"required.venta", "El valor venta es obligatorio.");
		
		RangoPlanilla rangoPlanilla = (RangoPlanilla) arg0;
		
		if ( rangoPlanilla.getVenta() <= 0 ) {
			arg1.rejectValue("venta", "desde.incorrect", 
					"El valor venta tiene que ser mayor a cero.");
		}

	}

}
