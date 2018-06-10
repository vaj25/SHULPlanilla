package com.shuldevelop.model.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shuldevelop.model.CentroDepto;

public class CentroDeptoValidator  implements Validator  {

	public boolean supports(Class<?> arg0) {
		
		return CentroDepto.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "id.centroCosto.monto", 
				"required.id.centroCosto.monto", "El Monto es obligatorio.");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "id.centroCosto.periodicidad", 
				"required.id.centroCosto.periodicidad", "El periodo es obligatorio.");
		
		CentroDepto centroDepto	 = (CentroDepto) arg0;

		
		if ( centroDepto.getEstructuraOrg().getId()== 0 ) {
			arg1.rejectValue("id.estructuraOrg.id", "id.estructuraOrg.id.incorrect", 
					"Seleccione una Estructura Organizativa.");
		}
		if ( centroDepto.getAnio() <= 0 ) {
			arg1.rejectValue("anio", "anio.incorrect", 
					"El año tiene que ser positivo.");
		}		
		if ( centroDepto.getCentroCosto().getMonto() <= 0 ) {
			arg1.rejectValue("id.centroCosto.monto", "id.centroCosto.monto.incorrect", 
					"El Monto tiene que ser positivo.");
		}
		if ( centroDepto.getCentroCosto().getPeriodicidad().length() > 4  ) {
			arg1.rejectValue("id.centroCosto.periodicidad", "id.centroCosto.periodicidad.incorrect", 
					"La periodicidad no puede sobrepasar los 4 carácteres.");
		}
	
	}
	
}
