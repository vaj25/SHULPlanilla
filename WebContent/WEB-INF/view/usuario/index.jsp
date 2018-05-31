<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Gestionar Usuarios</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/semantic.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/application.css" />
</head>
<body>
<c:import url="../layouts/menu.jsp"></c:import>
	<div class="container">
		<div class="ui container">
			<div>
				<a class="ui positive button" href="<c:url value="/usuario/add.html" />">Agregar</a>
			</div>
			
			<br>
			
			<div>
				<table class="ui single line table">
					<thead>
						<tr>
							<th>Número</th>
							<th>Usuario</th>
							<th>Emleado</th>
							<th>Rol</th>
							<th>Estado</th>
							<th>Acciones</th>
						</tr>				
					</thead>
					<tbody>
					
						<c:forEach items="${usuarioList}" var="usuario">
							<tr>
								<td>
									<c:out value="${usuario.getId()}"></c:out>
								</td>
								<td>
									<c:out value="${usuario.getUsername()}"></c:out>
								</td>
								<td>
									<c:out value="${usuario.getEstado()}"></c:out>
								</td>
								<td>
									<c:out value="${usuario.getRol().getNombreRol()}"></c:out>
								</td>
								<td>
									<c:choose>
										<c:when test = "${usuario.getEstado() == 1 }" >
											Activo
										</c:when>
										<c:when test = "${usuario.getEstado() == 2 }" >
											Inactivo
										</c:when>
										<c:when test = "${usuario.getEstado() == 3 }" >
											Bloqueado
										</c:when>
									</c:choose>
								</td>
								<td>
									<c:choose>
										<c:when test = "${usuario.getEstado() == 1 }" >
											<div class="ui mini circular icon button" data-tooltip="Desactivar" data-inverted="">
												<a href="<c:url value="/usuario/inactivate.html?id=${usuario.getId()}" />">
													<i class="large lock icon"></i>
												</a>
											</div>
										</c:when>
										<c:when test = "${usuario.getEstado() == 2 }" >
											<div class="ui mini circular icon button" data-tooltip="Activar" data-inverted="">
												<a href="<c:url value="/usuario/activate.html?id=${usuario.getId()}" />">
													<i class="large unlock icon"></i>
												</a>
											</div>
										</c:when>
										<c:when test = "${usuario.getEstado() == 3 }" >
											<div class="ui mini circular icon button" data-tooltip="Activar" data-inverted="">
												<a href="<c:url value="/usuario/enable.html?id=${usuario.getId()}" />">
													<i class="large unlock alternate icon"></i>
												</a>
											</div>
										</c:when>
									</c:choose>
									<div class="ui mini circular icon button" data-tooltip="Cambiar contraseña" data-inverted="">
										<a href="<c:url value="/usuario/edit-pass.html?id=${usuario.getId()}" />">
											<i class="large key icon"></i>
										</a>
									</div>
									<div class="ui mini circular icon button" data-tooltip="Editar" data-inverted="">
										<a href="<c:url value="/usuario/edit.html?id=${usuario.getId()}" />">
											<i class="large edit icon"></i>
										</a>
									</div>
									<div class="ui mini circular icon button" data-tooltip="Eliminar" data-inverted="">
										<a href="<c:url value="/usuario/delete.html?id=${usuario.getId()}" />">
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