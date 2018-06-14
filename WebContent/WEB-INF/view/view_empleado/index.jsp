<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Buscar Empleados</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/semantic.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/application.css" />
</head>
<body>
	
	<c:import url="../layouts/menu.jsp"></c:import>
	<div class="container">
		<div class="ui container">
			
			<c:choose>
				<c:when test="${messageSuccess != null}" >
					<div class="ui positive message">
						<div class="header">¡Exito!</div>
						<p>${messageSuccess}</p>
					</div>
				</c:when>
				<c:when test="${messageError != null}">
					<div class="ui negative message">
						<div class="header">¡Error!</div>
						<p>${messageError}</p>
					</div>
				</c:when>
			</c:choose>
			
			<div>
				<a class="ui positive button" href="<c:url value="/empleados/index.html" />">Regresar</a>
			</div>
			
			<br>
			
			<div style="width:100%;overflow-x: scroll;">
				<table class="ui single line table">
					<thead>
						<tr>
							<th>Número</th>
							<th>Empleado</th>
							<th>Genero</th>
							<th>Estado Civil</th>
							<th>Fecha de Nacimiento</th>
							<th>ISSS</th>
							<th>NIT</th>
							<th>NUP</th>
							<th>Fecha Ingreso</th>
							<th>Tipo de Empleado</th>
							<th>Oficio</th>
							<th>Nivel de Puesto</th>
							<th>Centro de Costo</th>
							<th>Estructura Organizacional</th>
							<th>Salario</th>
							<th>Nombre de Jefe</th>
						</tr>
					</thead>
					<tbody>
					
						<c:forEach items="${listEmpleado}" var="empleado">
							<tr>
								<td>
									<c:out value="${empleado.getIdEmpleado()}"></c:out>
								</td>
								<td>
									<c:out value="${empleado.getNombres()}"></c:out>
								</td>
								<td>
									<c:out value="${empleado.getGenero()}"></c:out>
								</td>
								<td>
									<c:out value="${empleado.getEstadoCivil()}"></c:out>
								</td>
								<td>
									<c:out value="${empleado.getFechaNacimiento()}"></c:out>
								</td>
								<td>
									<c:out value="${empleado.getIsss()}"></c:out>
								</td>
								<td>
									<c:out value="${empleado.getNit()}"></c:out>
								</td>
								<td>
									<c:out value="${empleado.getNup()}"></c:out>
								</td>
								<td>
									<c:out value="${empleado.getFechaIngreso()}"></c:out>
								</td>
								<td>
									<c:out value="${empleado.getTipoEmpleado()}"></c:out>
								</td>
								<td>
									<c:out value="${empleado.getOficio()}"></c:out>
								</td>
								<td>
									<c:out value="${empleado.getNivelPuesto()}"></c:out>
								</td>
								<td>
									<c:out value="${empleado.getCentroCosto()}"></c:out>
								</td>
								<td>
									<c:out value="${empleado.getNombreEstOrg()}"></c:out>
								</td>
								<td>
									$<c:out value="${empleado.getSalario()}"></c:out>
								</td>
								<td>
									<c:out value="${empleado.getNombreJefe()}"></c:out>
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