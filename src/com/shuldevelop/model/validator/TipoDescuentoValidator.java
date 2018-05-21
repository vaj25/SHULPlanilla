package com.shuldevelop.model.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shuldevelop.model.TipoDescuento;

public class TipoDescuentoValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {

		return TipoDescuento.class.isAssignableFrom(arg0);

	}

	@Override
	public void validate(Object arg0, Errors arg1) {

		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "tipo",
				"required.desde", "El tipo de descuento es obligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "taza",
				"required.hasta", "La taza es obligatoria.");

		TipoDescuento tipoDescuento = (TipoDescuento) arg0;

		if ( tipoDescuento.getTaza() < 0 ) {
			arg1.rejectValue("taza", "taza.incorrect",
					"La taza debe ser mayor que cero.");
		}

	}

}
