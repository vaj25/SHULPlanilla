
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Unidad Organizacional</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/semantic.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/application.css" />
</head>
<body>
	<c:import url="../layouts/menu.jsp"></c:import>
	<div class="container">
		<div class="ui container">
			<div>
				<a class="ui positive button" href="<c:url value="/unidad-organizacional/add.html" />">Agregar</a>
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
					<div class="ui negative message">
						<div class="header">¡Error!</div>
						<p>${messageError}</p>
					</div>
				</c:when>
			</c:choose>			
			<div>
				<table class="ui single line table">
					<thead>
						<tr>
							<th>Número</th>
							<th>Unidad Organizacional</th>
							<th>Direccion</th>
							<th>Representante</th>
							<th>NIT</th>
							<th>NIC</th>
							<th>Telefono</th>
							<th>Email</th>
							<th>Sitio Web</th>
							<th>Acciones</th>
						</tr>				
					</thead>
					<tbody>
					
						<c:forEach items="${unidadOrganizacionalList}" var="unidadOrganizacional">
							<tr>
								<td>
									<c:out value="${unidadOrganizacional.getId()}"></c:out>
								</td>
								<td>
									<c:out value="${unidadOrganizacional.getUnidad_org()}"></c:out>
								</td>
								<td>
									<c:out value="${unidadOrganizacional.getDireccion()}"></c:out>
								</td>
								<td>
									<c:out value="${unidadOrganizacional.getRepresentante()}"></c:out>
								</td>
								<td>
									<c:out value="${unidadOrganizacional.getNit()}"></c:out>
								</td>
								<td>
									<c:out value="${unidadOrganizacional.getNic()}"></c:out>
								</td>
								<td>
									<c:out value="${unidadOrganizacional.getTelefono()}"></c:out>
								</td>
								<td>
									<c:out value="${unidadOrganizacional.getEmail_pers()}"></c:out>
								</td>
								<td>
									<c:out value="${unidadOrganizacional.getSite_web()}"></c:out>
								</td>
								<td>
									<div class="ui mini circular icon button" data-tooltip="Editar" data-inverted="">
										<a href="<c:url value="/unidad-organizacional/edit.html?id=${unidadOrganizacional.getId()}" />">
											<i class="large edit icon"></i>
										</a>
									</div>
									<div class="ui mini circular icon button" data-tooltip="Eliminar" data-inverted="">
										<a href="<c:url value="/unidad-organizacional/delete.html?id=${unidadOrganizacional.getId()}" />">
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