/**
 * 
 */
var months = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Augosto", "Septiembre", "Octubre", "Noviembre", "Diciemmbre"];
var days = ["Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"];
var baseurl = "http://localhost:8080/SHULPlanilla";

$(document).ready(function () {
	
	$('.ui.dropdown').dropdown();
	
	$('.ui.checkbox').checkbox();
	
	var date = new Date();
	
	$('#date').html( days[date.getDay()] + ' ' + date.getDate() + ' ' + months[date.getMonth()] + ' de ' + date.getFullYear());
	
	$("#zonaid").change(function() {
		
		$("#zonaid option:selected").each(function() {
			if ($(this).val() != 0) {
				$.ajax({
					type: 'get',
			        url: baseurl + "/direccion/getDepartamentoZona.html?idZona=" + $(this).val(),
			        contentType: 'application/json',
			        success: function(data) {
			        	
			        	for (var i=0, len=data.length; i < len; i++) {
			        		$('#departamentoid').append('<option value="'+ data[i].id +'">' + data[i].nombre + '</option>')
			        	}
			        	
			        	$("#departamentoid").change(function() {
			    			
			    			$("#departamentoid option:selected").each(function() {
			    				if ($(this).val() != 0) {
			    					$.ajax({
			    						type: 'get',
			    				        url: baseurl + "/direccion/getMunicipioDepartamento.html?idDepartamento=" + $(this).val(),
			    				        contentType: 'application/json',
			    				        success: function(data) {
			    				        	
			    				        	for (var i=0, len=data.length; i < len; i++) {
			    				        		$('.municipioid').append('<option value="'+ data[i].id +'">' + data[i].nombre + '</option>')
			    				        	}      	
			    				        	$('.ui.dropdown')
			    				        	  .dropdown()
			    				        	;	        	
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
