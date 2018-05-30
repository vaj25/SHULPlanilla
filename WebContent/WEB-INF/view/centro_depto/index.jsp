
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Centro de Costo</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/semantic.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/application.css" />
</head>
<body>
	<c:import url="../layouts/menu.jsp"></c:import>
	<div class="container">
		<div class="ui container">
			<div>
				<a class="ui positive button" href="<c:url value="/centro-depto/add.html" />">Agregar</a>
			</div>
			
			<br>
			
			<div>
				<table class="ui single line table">
					<thead>
						<tr>
							<th>Número</th>
							<th>Estructura</th>
							<th>Monto</th>
							<th>Periodicidad</th>
							<th>año</th>
						</tr>				
					</thead>
					<tbody>
					<script>
						//alert("${centroDeptoList}");
					</script>
						<c:forEach items="${centroDeptoList}" var="centroDepto">
							<tr>
								<td>
									<c:out value="${centroDepto.getId()}"></c:out>
								</td>
								<td>
									<c:out value="${centroDepto.getMonto()}"></c:out>
								</td>
								<td>
									<c:out value="${centroDepto.getPeriodicidad()}"></c:out>
								</td>
								<c:forEach items="${centroDeptoList}" var="genero">
									<tr>
										<td>
											<c:out value="${centroDepto.getAnio()}"></c:out>
										</td>
									</tr>					
								</c:forEach>															
							    <td>									
									<div class="ui mini circular icon button" data-tooltip="Editar" data-inverted="">
										<a href="<c:url value="/genero/edit.html?id=${genero.getId()}" />">
											<i class="large edit icon"></i>
										</a>
									</div>
									<div class="ui mini circular icon button" data-tooltip="Eliminar" data-inverted="">
										<a href="<c:url value="/genero/delete.html?id=${genero.getId()}" />">
											<i class="large erase icon"></i>
										</a>
									</div>
								</td>
							</tr>					
						</c:forEach>
						
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
	<c:import url="../layouts/footer.jsp"></c:import>
</body>
</html>