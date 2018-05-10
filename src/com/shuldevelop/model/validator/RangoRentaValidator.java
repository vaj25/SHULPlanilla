package com.shuldevelop.model.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shuldevelop.model.RangoRenta;

public class RangoRentaValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {

		return RangoRenta.class.isAssignableFrom(arg0);

	}

	@Override
	public void validate(Object arg0, Errors arg1) {

		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "desde",
				"required.desde", "El limite inicial es obligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "hasta",
				"required.hasta", "El limite final es obligatorio.");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "periodo",
				"required.desde", "El periodo es obligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "cuota",
				"required.hasta", "La cuota fija es obligatoria.");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "taza",
				"required.hasta", "La taza impositiva es obligatoria.");


		RangoRenta rangoRenta = (RangoRenta) arg0;

		if ( rangoRenta.getDesde() < 0 ) {
			arg1.rejectValue("desde", "desde.incorrect",
					"El limite inicial debe ser mayor que cero.");
		}

		if ( rangoRenta.getDesde() < 0 ) {
			arg1.rejectValue("hasta", "hasta.incorrect",
					"El limite final debe ser mayor que cero.");
		}

		if ( rangoRenta.getPeriodo() < 0 ) {
			arg1.rejectValue("periodo", "periodo.incorrect",
					"El periodo debe ser mayor que cero.");
		}

		if ( rangoRenta.getCuota() < 0 ) {
			arg1.rejectValue("cuota", "cuota.incorrect",
					"La cuota debe ser mayor que cero.");
		}

		if ( rangoRenta.getTaza() < 0 ) {
			arg1.rejectValue("taza", "taza.incorrect",
					"La taza debe ser mayor que cero.");
		}


	}

}
