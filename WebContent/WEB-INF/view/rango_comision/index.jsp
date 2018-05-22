<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Rango Comisión</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/semantic.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/application.css" />
</head>
<body>
	
	<c:import url="../layouts/menu.jsp"></c:import>
	<div class="container">
		<div class="ui container">
			<div>
				<a class="ui positive button" href="<c:url value="/rango-comision/add.html" />">Agregar</a>
			</div>
			
			<br>
			
			<div>
				<table class="ui single line table">
					<thead>
						<tr>
							<th>Número</th>
							<th>Desde</th>
							<th>Hasta</th>
							<th>Tasa</th>
							<th>Acciones</th>
						</tr>				
					</thead>
					<tbody>
					
						<c:forEach items="${rangoComisionList}" var="rangoComision">
							<tr>
								<td>
									<c:out value="${rangoComision.getId()}"></c:out>
								</td>
								<td>
									<fmt:formatNumber minFractionDigits="2" type="currency" 
										currencySymbol="$"
										value="${rangoComision.getDesde()}" />
								</td>
								<td>
									<fmt:formatNumber minFractionDigits="2" type="currency" 
										currencySymbol="$"
										value="${rangoComision.getHasta()}" />
								</td>
								<td>
									<fmt:formatNumber minFractionDigits="2" type="percent"
										value="${rangoComision.getTasa()}" />
								</td>
								<td>
									<div class="ui mini circular icon button" data-tooltip="Editar" data-inverted="">
										<a href="<c:url value="/rango-comision/edit.html?id=${rangoComision.getId()}" />">
											<i class="large edit icon"></i>
										</a>
									</div>
									<div class="ui mini circular icon button" data-tooltip="Eliminar" data-inverted="">
										<a href="<c:url value="/rango-comision/delete.html?id=${rangoComision.getId()}" />">
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