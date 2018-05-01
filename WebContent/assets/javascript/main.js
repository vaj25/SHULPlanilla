/**
 * 
 */

baseurl = "http://localhost:8080/SHULPlanilla";

$(document).ready(function () {
	
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
