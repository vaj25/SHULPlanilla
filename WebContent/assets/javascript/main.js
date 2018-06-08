/**
 * 
 */
var months = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Augosto", "Septiembre", "Octubre", "Noviembre", "Diciemmbre"];
var days = ["Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"];
var baseurl = "http://localhost:8080/SHULPlanilla";

$(document).ready(function () {
	
	var w = $(window).width();
	if(w < 1000) {
		$('#colapse').click(function() {
			$('nav').toggle();
		});
		
		$('footer > div').removeClass('grid');
	}
	
	$('.ui.dropdown').dropdown();
	
	$('.ui.checkbox').checkbox();
	
	$('.ui.accordion').accordion();

	var date = new Date();
	
	$('#date').html( days[date.getDay()] + ' ' + date.getDate() + ' ' + months[date.getMonth()] + ' de ' + date.getFullYear());
	
	$("#zonaid").change(function() {
		
		$("#zonaid option:selected").each(function() {
			if ($(this).val() != 0) {
				$.ajax({
					type: 'get',
			        url: baseurl + "/direccion/getDepartamentoZona.html?idZona=" + $(this).val(),
			        contentType: 'application/json',
			        success: function(response) {
			        	
			        	var data = JSON.parse(response);
			        	
			        	$('#departamentoid').empty();
			        	$('#departamentoid').append('<option value="0">Seleccione un Departamento</option>')
			        	
			        	for (var i=0; i < data.length; i++) {
			        		$('#departamentoid').append('<option value="'+ data[i].id +'">' + data[i].nombre + '</option>')
			        	}
			        	
			        	$("#departamentoid").change(function() {
			    			
			    			$("#departamentoid option:selected").each(function() {
			    				if ($(this).val() != 0) {
			    					$.ajax({
			    						type: 'get',
			    				        url: baseurl + "/direccion/getMunicipioDepartamento.html?idDepartamento=" + $(this).val(),
			    				        contentType: 'application/json',
			    				        success: function(response) {
			    				        	
			    				        	$('#municipioid').empty();
			    				        	$('#municipioid').append('<option value="0">Seleccione un Municipio</option>')
			    				        	
			    				        	var data = JSON.parse(response);
			    				        	
			    				        	for (var i=0; i < data.length; i++) {
			    				        		$('.municipioid').append('<option value="'+ data[i].id +'">' + data[i].nombre + '</option>')
			    				        	}        	
			    				        },
			    				    });
			    				}
			    			});
			    		});
			        	
			        },
			    });
			}
		});
	});
});
