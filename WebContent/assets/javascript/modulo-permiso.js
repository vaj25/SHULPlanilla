/**
 * 
 */
$('#modulos')
	  .dropdown({
		onAdd(addedValue, addedText, $addedChoice) {
	    	$('.loger.modal')
	        	.modal('show');
	    	
			$('.approve').click(function () {
				
				if ( $("#data-permisos > #" + addedValue).length == 0 ) {					
					var searchIDs = $("input[name='permisos']:checkbox:checked").map(function(){
					      return $(this).val();
					}).get();
					
					$("#data-permisos").append($("<option></option>")
							.attr('id', addedValue)
							.attr('value', addedValue + "," + searchIDs)
							.attr('selected', 'selected')
							.text( addedText ));
				}
				
			});
			
			$('.cancel').click(function () {
				$("#modulos option[value='"+ addedText +"']").remove();
			});
			
			$("input[name='permisos']:checkbox:checked").removeAttr('checked');
			
	    },
	    onRemove(removedValue, removedText, $removedChoice) {
	    	$("#data-permisos > #" + removedValue).remove();
	    }
	  });