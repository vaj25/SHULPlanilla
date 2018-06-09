
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Modulo</title>
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
				<a class="ui positive button" href="<c:url value="/modulo/add.html" />">Agregar</a>
			</div>
			
			<br>
			<c:choose>
				<c:when test="${messageSuccess != null}" >
					<div class="ui positive message">
						<div class="header">¡Exito!</div>
						<p>${messageSuccess}</p>
					</div>
				</c:when>
				<c:when test="${messageError != null}">
					<div class="ui positive message">
						<div class="header">¡Error!</div>
						<p>${messageError}</p>
					</div>
				</c:when>
			</c:choose>
			<div>
				<table class="ui padded table">
					<thead>
						<tr>
							<th>Número</th>
							<th>Nombre</th>
							<th>Descripción</th>
							<th>Orden</th>
							<th>URL</th>
							<th>Icono</th>
							<th>Opciones</th>
							<th>Dependecia</th>
							<th>Acciones</th>
						</tr>				
					</thead>
					<tbody>
						
						<c:forEach items="${moduloList}" var="modulo">
							<tr>
								<td>
									<c:out value="${modulo.getId()}"></c:out>
								</td>
								<td>
									<c:out value="${modulo.getNombre()}"></c:out>
								</td>
								<td>
									<c:out value="${modulo.getDescripcion()}"></c:out>
								</td>
								<td>
									<c:out value="${modulo.getOrden()}"></c:out>
								</td>
								<td>
									<c:out value="${modulo.getUrl()}"></c:out>
								</td>
								<td>
									<c:out value="${modulo.getIcono()}"></c:out>
								</td>
								<td>
									<c:out value="${modulo.getOpciones()}"></c:out>
								</td>
								<td>
									<c:out value="${modulo.getDependencia()}"></c:out>
								</td>
								<td>
									<div class="ui mini circular icon button" data-tooltip="Editar" data-inverted="">
										<a href="<c:url value="/modulo/edit.html?id=${modulo.getId()}" />">
											<i class="large edit icon"></i>
										</a>
									</div>
									<div class="ui mini circular icon button" data-tooltip="Eliminar" data-inverted="">
										<a href="<c:url value="/modulo/delete.html?id=${modulo.getId()}" />">
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