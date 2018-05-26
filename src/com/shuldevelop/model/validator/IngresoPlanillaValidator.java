package com.shuldevelop.model.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shuldevelop.model.IngresoPlanilla;

public class IngresoPlanillaValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		
		return IngresoPlanilla.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "monto", 
				"required.monto", "El monto es obligatorio.");
		
		IngresoPlanilla ingresoPlanilla = (IngresoPlanilla) arg0;
		
		if (ingresoPlanilla.getTipoIngreso().getId() == 0) {
			arg1.rejectValue("id.tipoIngreso", "id.tipoIngreso.incorrect", 
					"El tipo de ingreso es obligatorio.");
		}
		
		if (ingresoPlanilla.getMonto() <= 0) {
			arg1.rejectValue("monto", "monto.incorrect", 
					"El monto tiene que ser mayor a 0.");
		}

	}

}
