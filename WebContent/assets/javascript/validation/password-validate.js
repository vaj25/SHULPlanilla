/**
 * 
 */

$('.ui.form').form({
	
	on: 'blur',
	fields: {
		password: {
			identifier: 'password',
			rules: [
				{					
					type: 'empty',
					prompt: 'Por favor, introducir una password.'
				},
				{
					type: 'minLength[8]',
					prompt: 'La contraseña como minimo debe tener 8 caracteres.'
				},
				{
					type: 'regExp',
					value: /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])([A-Za-z]){1}([A-Za-z\d$@$!%*?&]|[^ ]){7,15}$/,
					prompt: 'La password no es segura. Debe de contener por lo menos:'+
							'<ul>'+
							'<li> Letras mayusculas </li>' +
							'<li> Simbolos especiales </li>'+
							'<li> Números </li>'+
							'<li>E iniciar con letra.</li></ul>'
				}
			]
		},
		confirmPassword: {
			identifier: 'confirmPassword',
			rules: [
				{
					type: 'empty',
					prompt: 'Por favor, confime la password.'
				},
				{
					identifier : 'confirmPassword',
			        type       : 'match[password]',
			        prompt     : 'Por faver verifique la password.'
				}
			]
		},
		currentPassword: {
			identifier: 'currentPassword',
			rules: [
				{
					type: 'empty',
					prompt: 'Por favor, introduzca la password actual.'
				}
			]
		},
	}
	
});