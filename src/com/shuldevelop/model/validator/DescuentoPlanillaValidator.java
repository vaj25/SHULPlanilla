package com.shuldevelop.model.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shuldevelop.model.DescuentoPlanilla;

public class DescuentoPlanillaValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {

		return DescuentoPlanilla.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {

		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "monto",
				"required.monto", "El monto es obligatorio.");

		DescuentoPlanilla descuentoPlanilla = (DescuentoPlanilla) arg0;

		if (descuentoPlanilla.getTipoDescuento().getId() == 0) {
			arg1.rejectValue("id.tipoDescuento", "id.tipoDescuento.incorrect",
					"El tipo de descuento es obligatorio.");
		}

		if (descuentoPlanilla.getMonto() <= 0) {
			arg1.rejectValue("monto", "monto.incorrect",
					"El monto tiene que ser mayor a 0.");
		}

	}

}
