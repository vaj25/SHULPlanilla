
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Planilla</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/semantic.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/application.css" />
</head>
<body>
	<c:import url="../layouts/menu.jsp"></c:import>
	<div class="container">
		<div class="ui container">
			<div>
				<a class="ui positive button" href="<c:url value="/planilla-planilla/add.html" />">Agregar</a>				
			</div>

			<br>

			<div>
				<table class="ui single line table">
					<thead>
						<tr>
							<th>Id</th>
							<th>Fecha inicio</th>
              				<th>Fecha Fin</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${planillaList}" var="planilla">
							<tr>
								<td>
									<c:out value="${planilla.getId()}"></c:out>
								</td>
								<td>
									<c:out value="${planilla.formatearFecha(planilla.getFechaInicio())}"></c:out>
								</td>
				                <td>
				                  	<c:out value="${planilla.formatearFecha(planilla.getFechaFin())}"></c:out>
				                  	
				                </td>
								<td>
									<c:choose>
										<c:when test = "${!planilla.getEstado() }" >
											<div class="ui mini circular icon button" data-tooltip="Descontar en Centro de Costo" data-inverted="">
												<a href="<c:url value="/planilla-planilla/enable.html?
													id=${planilla.getId()}" />">
													<i class="large arrow down icon"></i>
												</a>
											</div>
										</c:when>
									</c:choose>
									<div class="ui mini circular icon button" data-tooltip="Eliminar" data-inverted="">
										<a href="<c:url value="/planilla-planilla/delete.html?id=${planilla.getId()}" />">
											<i class="large erase icon"></i>
										</a>
									</div>
									<div class="ui mini circular icon button" data-tooltip="Empleados" data-inverted="">
										<a href="<c:url value="/planilla-empleado/index.html?id=${planilla.getId()}" />">
											<i class="large calculator icon"></i>
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
