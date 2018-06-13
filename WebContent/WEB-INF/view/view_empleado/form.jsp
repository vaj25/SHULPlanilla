<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Permisos</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/semantic.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/application.css" />
</head>
<body>
	
	<c:import url="../layouts/menu.jsp"></c:import>
	<div class="container">
	
		<c:choose>
			<c:when test="${messageSuccess != null}" >
				<div class="ui positive message">
					<div class="header">¡Exito!</div>
					<p>${messageSuccess}</p>
				</div>
			</c:when>
			<c:when test="${messageError != null}" >
				<div class="ui negative message">
					<div class="header">¡Error!</div>
					<p>${messageError}</p>
				</div>
			</c:when>
		</c:choose>
		
		<div class="ui raised very padded text container segment">
		
			<div>
				<form method="post" class="ui form">
					
					<h4 class="ui dividing header">Buscar Empleados</h4>
					
					<button id="plus" type="button" class="ui blue icon button">
						<i class="icon plus"></i>
					</button>
					
					<br><br>
								
					<div id="container">
						<div id="cont-search" style="width:50%;">
							<div class="ui right action left icon input">
								<i class="icon search"></i>
		  						<input type="text" name="search0" placeholder="Search">
								<select name="select0" class="ui dropdown">
									  <option value="">Buscar por</option>
									  <option value="idEmpleado">Código de empleado</option>
									  <option value="nit">NIT</option>
									  <option value="doc_identidad">DUI</option>
									  <option value="nombres">Nombre o Apellido</option>
									  <option value="fechaNacimiento">Fecha de nacimiento</option>
								</select>
		  						<button type="button" class="ui icon button">
		  							<i class="icon minus" data-container="cont-search" data-value="select0,search0"></i>
								</button>
							</div>
							
							<br><br>
						</div>
					</div>
					
					<div id="send" style="display:none;">
						<input type="checkbox" name="input" value="select0,search0" checked />
					</div>
					
					<div>
						<button class="ui primary button" type="submit">Buscar</button>
					</div>
					
				</form>
			</div>
		</div>
		
	</div>
	<c:import url="../layouts/footer.jsp"></c:import>
	<script type="text/javascript">
	
		var i = 1;	
	
		$('.ui.dropdown').dropdown();
		
		$('#plus').click(function() {
						
			var div = $('#cont-search').clone()
			div.attr('id', 'cont-search'+i );
			div.children().children().children('select').attr('name', 'select'+i);
			div.children().children('input').attr('name', 'search'+i);
			div.children().children().children('.minus')
				.attr('data-container', 'cont-search'+i)
				.attr('data-value', 'select'+i+',search'+1);
			div.appendTo( '#container' );
			
			$('#send').append(
					$("<input type='checkbox' name='input' value='select"+i+",search"+i+"' checked />")
			);
			
			$('.ui.dropdown').dropdown();
			
			$('.minus').click(function() {
				var id = $(this).attr('data-container');
				$('#'+id).remove();
				
				$(':input[value="'+$(this).attr('data-value')+'"]').remove();
			});
			
			i++;
			
		});
		
		$('.minus').click(function() {
			var id = $(this).attr('data-container');
			$('#'+id).remove();
			
			$(':input[value="'+$(this).attr('data-value')+'"]').remove();
		});
		
	</script>
</body>
</html>