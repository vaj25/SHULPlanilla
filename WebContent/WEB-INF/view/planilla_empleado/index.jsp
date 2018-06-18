<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
				<a class="ui positive button" href="<c:url value="/planilla-empleado/add.html?id=${idPl}" />">Agregar</a>
				<a class="section" href="<c:url value="/planilla-planilla/index.html" />">Atras</a>
			</div>

			<br>

			<div>
				<table class="ui single line table">
					<thead>
						<tr>
							<th>Número</th>
							<th>Empleado</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${planillaEmpleadoList}" var="planilla">
							<tr>
								<td>
									<c:out value="${planilla.getId()}"></c:out>
								</td>
								<td>
									<c:out value="${planilla.getEmpleado()}"></c:out>
								</td>
								<td>
									<div class="ui mini circular icon button" data-tooltip="Venta" data-inverted="">
										<a href="<c:url value="/rango-planilla/index.html?id_planilla=${planilla.getId()}
										&id_pl=${idPl}"/>">
											<i class="large shopping cart icon"></i>
										</a>
									</div>
									<div class="ui mini circular icon button" data-tooltip="Gestionar Ingresos" data-inverted="">
										<a href="<c:url value="/ingreso-planilla/index.html?id=${planilla.getId()}&id_pl=${idPl}" />">
											<i class="large dollar sign icon"></i>
										</a>
									</div>
									<div class="ui mini circular icon button" data-tooltip="Gestionar Descuentos" data-inverted="">
										<a href="<c:url value="/descuento-planilla/index.html?id=${planilla.getId()}&id_pl=${idPl}" />">
											<i class="large percent icon"></i>
										</a>
									</div>
									<c:choose>
										<c:when test = "${!planilla.getEstado() }" >
											<div class="ui mini circular icon button" data-tooltip="Aplicar Descuentos" data-inverted="">
												<a href="<c:url value="/planilla-empleado/enable.html?
													id=${planilla.getId()}" />">
													<i class="large arrow down icon"></i>
												</a>
											</div>
										</c:when>
									</c:choose>
									<div class="ui mini circular icon button" data-tooltip="Imprimir Boleta" data-inverted="">
										<a target="_blank" href="<c:url value="/planilla-empleado/boleta.html?id=${planilla.getId()}" />">
											<i class="large address card outline icon"></i>
										</a>
									</div>
									<div class="ui mini circular icon button" data-tooltip="Editar" data-inverted="">
										<a href="<c:url value="/planilla-empleado/edit.html?id=${planilla.getId()}&id_pl=${idPl}" />">
											<i class="large edit icon"></i>
										</a>
									</div>
									<div class="ui mini circular icon button" data-tooltip="Eliminar" data-inverted="">
										<a href="<c:url value="/planilla-empleado/delete.html?id=${planilla.getId()}&id_pl=${idPl}" />">
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
