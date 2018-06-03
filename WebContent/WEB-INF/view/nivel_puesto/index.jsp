
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Tipo de Puesto</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/semantic.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/application.css" />
</head>
<body>
	<c:set value="${Usuario}" var="usuario" scope="request" ></c:set> 
	<c:set value="${modulos}" var="modulos" scope="request" ></c:set>

	<c:import url="../layouts/menu.jsp"></c:import>
	<div class="container">
		<div class="ui container">
			<div>
				<a class="ui positive button" href="<c:url value="/nivel-puesto/add.html" />">Agregar</a>
			</div>
			
			<br>
			
			<div>
				<table class="ui single line table">
					<thead>
						<tr>
							<th>Número</th>
							<th>Número Tipo</th>
							<th>Salario Minimo</th>
							<th>Salario Maximo</th>
							<th>Acciones</th>
						</tr>				
					</thead>
					<tbody>
					
						<c:forEach items="${tipoPuestoList}" var="tipoPuesto">
							<tr>
								<td>
									<c:out value="${tipoPuesto.getId()}"></c:out>
								</td>
								<td>
									<c:out value="${tipoPuesto.getNumeroNivel()}"></c:out>
								</td>
								<td>
									<fmt:formatNumber minFractionDigits="2" type="currency" 
										currencySymbol="$"
										value="${tipoPuesto.getSalarioMinimo()}" />
								</td>
								<td>
									<fmt:formatNumber minFractionDigits="2" type="currency" 
										currencySymbol="$"
										value="${tipoPuesto.getSalarioMaximo()}" />
								</td>
								<td>
									<div class="ui mini circular icon button" data-tooltip="Editar" data-inverted="">
										<a href="<c:url value="/nivel-puesto/edit.html?id=${tipoPuesto.getId()}" />">
											<i class="large edit icon"></i>
										</a>
									</div>
									<div class="ui mini circular icon button" data-tooltip="Eliminar" data-inverted="">
										<a href="<c:url value="/nivel-puesto/delete.html?id=${tipoPuesto.getId()}" />">
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