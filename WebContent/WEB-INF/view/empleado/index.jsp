
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Empleados</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/semantic.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/application.css" />
</head>
<body>
 
	<c:import url="../layouts/menu.jsp"></c:import>
	<div class="container">
		<div class="ui container">
			<div>
				<a class="ui positive button" href="<c:url value="/empleado/add.html" />">Agregar</a>
			</div>
			
			<br>
			
			  
			  <c:forEach items="${mensaje}" var="empleado">
			 <div class="ui red message">
			  <div class="header">
			    ¡ERROR!
			  </div>
			  <p>"${mensaje}"</p>
			</div>
			</c:forEach>
			
			<div style="width:1300x;overflow-x: scroll;">
				<table class="ui single line table">
					<thead>
						<tr>
							<th>Número</th>
							<th>Nombre</th>
							
							
							
							
							
							
							<th>Fecha de ingreso</th>
							<th>NIT</th>
							<th>ISSS</th>
							<th>NUP</th>
							
							<th>Doc. Identidad</th>
							<th>Email</th>
							
							
							
							
							
							
							
							
							
							
							<th>Jefe</th>
							
							<th>Profesion</th>
							<th>Estado</th>
							<th>Acciones</th>
							
							
						</tr>				
					</thead>
					<tbody>
					
						<c:forEach items="${empleadoList}" var="empleado">
							<tr>
								<td>
									<c:out value="${empleado.getId()}"></c:out>
								</td>
								<td>
									<c:out value="${empleado.getPrimer_nombre()}"></c:out>
									
									<c:out value="${empleado.getPrimer_apellido()}"></c:out>
								</td>
								
								
								
								
								
								
								<td>
									<fmt:formatDate pattern = "dd-MM-yyyy" value = "${empleado.getFecha_ingreso()}" />
								</td>
								<td>
									<c:out value="${empleado.getNit()}"></c:out>
								</td>
								<td>
									<c:out value="${empleado.getIsss()}"></c:out>
								</td>
								<td>
									<c:out value="${empleado.getNup()}"></c:out>
								</td>
								
								<td>
									<c:out value="${empleado.getDoc_identidad()}"></c:out>
								</td>
								<td>
									<c:out value="${empleado.getEmail_pers()}"></c:out>
								</td>
								
								
								
								
								
								
								
								
								
								
								<td>
									<c:out value="${empleado.getJefe().getPrimer_nombre()}"></c:out>
									<c:out value="${empleado.getJefe().getPrimer_apellido()}"></c:out>
									
								</td>
								
								<td>
									<c:out value="${empleado.getProfesionOficio().getProfesion_oficio()}"></c:out>
								</td>
								<td>
									<c:choose>
										<c:when test = "${empleado.getEstado() == 1 }" >
											Activo
										</c:when>
										<c:when test = "${empleado.getEstado() == 2 }" >
											Inactivo
										</c:when>
										<c:when test = "${empleado.getEstado() == 3 }" >
											Bloqueado
										</c:when>
									</c:choose>
								</td>
								<td>
									<c:choose>
										<c:when test = "${empleado.getEstado() == 1 }" >
											<div class="ui mini circular icon button" data-tooltip="Desactivar" data-inverted="">
												<a href="<c:url value="/empleado/inactivate.html?id=${empleado.getId()}" />">
													<i class="large lock icon"></i>
												</a>
											</div>
										</c:when>
										<c:when test = "${empleado.getEstado() == 2 }" >
											<div class="ui mini circular icon button" data-tooltip="Activar" data-inverted="">
												<a href="<c:url value="/empleado/activate.html?id=${empleado.getId()}" />">
													<i class="large unlock icon"></i>
												</a>
											</div>
										</c:when>
										<c:when test = "${empleado.getEstado() == 3 }" >
											<div class="ui mini circular icon button" data-tooltip="Activar" data-inverted="">
												<a href="<c:url value="/empleado/enable.html?id=${empleado.getId()}" />">
													<i class="large unlock alternate icon"></i>
												</a>
											</div>
										</c:when>
									</c:choose>
									<div class="ui mini circular icon button" data-tooltip="Información Laboral" data-inverted="">
										<a href="<c:url value="/info-laboral/add.html?id=${empleado.getId()}" />">
											<i class="large id card outline icon"></i>
										</a>
									</div>
									<div class="ui mini circular icon button" data-tooltip="Editar" data-inverted="">
										<a href="<c:url value="/empleado/edit.html?id=${empleado.getId()}" />">
											<i class="large edit icon"></i>
										</a>
									</div>
									<div class="ui mini circular icon button" data-tooltip="Eliminar" data-inverted="">
										<a href="<c:url value="/empleado/delete.html?id=${empleado.getId()}" />">
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