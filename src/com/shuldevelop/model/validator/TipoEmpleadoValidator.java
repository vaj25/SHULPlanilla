package com.shuldevelop.model.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shuldevelop.model.TipoEmpleado;

public class TipoEmpleadoValidator  implements Validator{
	
	public boolean supports(Class<?> arg0) {
		
		return TipoEmpleado.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "tipo_empleado", 
				"required.tipo_empleado", "El Tipo Empleado es obligatorio.");

	}
	
}
