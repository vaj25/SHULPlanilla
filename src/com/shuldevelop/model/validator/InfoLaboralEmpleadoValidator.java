package com.shuldevelop.model.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shuldevelop.model.InfoLaboralEmpleado;

public class InfoLaboralEmpleadoValidator  implements Validator{
	@Override
	public boolean supports(Class<?> arg0) {
		
		return InfoLaboralEmpleado.class.isAssignableFrom(arg0);
	}
	
	@Override
	public void validate(Object arg0, Errors arg1) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "salario", 
				"required.salario", "El Salario es obligatorio.");

		InfoLaboralEmpleado infoLaboralEmpleado = (InfoLaboralEmpleado) arg0;

		if ( infoLaboralEmpleado.getSalario() < 0 ) {
			arg1.rejectValue("salario", "salario.incorrect", 
					"El Salario tiene que ser positivo.");
		}		

		if ( infoLaboralEmpleado.getSalario() < 300 ) {
			arg1.rejectValue("salario", "salario.incorrect", 
					"El Salario tiene que ser mayor al Salario Minimo ($300).");
		}	
		
		if ( infoLaboralEmpleado.getEmpleado().getId() == 0 ) {
			arg1.rejectValue("empleado.id", "empleado.incorrect", 
					"Seleccione un Empleado.");
		}
		if ( infoLaboralEmpleado.getTipoEmpleado().getId()== 0 ) {
			arg1.rejectValue("tipoEmpleado.id", "tipoEmpleado.incorrect", 
					"Seleccione un Tipo Empleado.");
		}
		if ( infoLaboralEmpleado.getEstructuraOrg().getId()== 0 ) {
			arg1.rejectValue("estructuraOrg.id", "estructuraOrg.incorrect", 
					"Seleccione una Estructura Organizativa.");
		}
		if ( infoLaboralEmpleado.getPuesto().getId()== 0 ) {
			arg1.rejectValue("puesto.id", "puesto.incorrect", 
					"Seleccione un Puesto.");
		}
	}
}
