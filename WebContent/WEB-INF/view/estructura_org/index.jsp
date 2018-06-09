
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Estructura Organizativa</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/semantic.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/application.css" />
</head>
<body>
	<c:import url="../layouts/menu.jsp"></c:import>
	<div class="container">
		<div class="ui container">
			<div>
				<a class="ui positive button" href="<c:url value="/estructura-org/add.html" />">Agregar</a>
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
				<table class="ui single line table">
					<thead>
						<tr>
							<th>Id</th>
							<th>Unidad Organizacional</th>
							<th>Nivel Estructura</th>
							<th>Nombre</th>
							<th>Estructura Organizativa</th>
							<th>Acciones</th>

						</tr>				
					</thead>
					<tbody>
						<c:forEach items="${estructuraOrgList}" var="estructuraOrg">
							<tr>
								<td>
									<c:out value="${estructuraOrg.getId()}"></c:out>
								</td>
								<td>
									<c:out value="${estructuraOrg.unidadOrganizacional.getUnidad_org()}"></c:out>
								</td>
								<td>
									<c:out value="${estructuraOrg.nivelEstructura.getNombre_nivel()}"></c:out>
								</td>
								<td>
									<c:out value="${estructuraOrg.getNombre()}"></c:out>
								</td>
								<td>
									<c:out value="${estructuraOrg.estEstructuraOrg.getNombre()}"></c:out>
								</td>
							    <td>									
									<div class="ui mini circular icon button" data-tooltip="Editar" data-inverted="">
										<a href="<c:url value="/estructura-org/edit.html?id=${estructuraOrg.getId()}"/>">
											<i class="large edit icon"></i>
										</a>
									</div>
									<div class="ui mini circular icon button" data-tooltip="Eliminar" data-inverted="">
										<a href="<c:url value="/estructura-org/delete.html?id=${estructuraOrg.getId()}"/>">
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