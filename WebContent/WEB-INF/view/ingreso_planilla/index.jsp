<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ingresos</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/semantic.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/application.css" />
</head>
<body>
	
	<c:import url="../layouts/menu.jsp"></c:import>
	<div class="container">
		<div class="ui raised very padded text container segment">
			<div class="ui large breadcrumb">
				<a class="section" href="<c:url value="/planilla-empleado/index.html" />">Atras</a>
			</div>
			<br><br>
			<div>
				<c:url var="post_url" value="/ingreso-planilla/index.html" />
				<form:form method="post" modelAttribute="IngresoPlanilla" cssClass="ui form"
					action="${post_url}">
					
					<h4 class="ui dividing header">Gestionar ingresos de xxxx</h4>
					
					<form:errors path="*" element="div" cssClass="alert" />
					
					<div class="field">
						<form:label path="id.tipoIngreso.id">Tipo de Ingreso: </form:label>
						<form:select path="id.tipoIngreso.id">
                			<form:option value="0" label="Seleccione el tipo ingreso"/>
                			<form:options items="${tipoIngresoList}" itemValue="id" />
            			</form:select>
						<form:errors path="id.tipoIngreso" />
					</div>
					
					<form:hidden path = "id.planillaEmpleado.id" value = "${planillaEmpleado.getId()}"/>
					
					<div class="field">
						<form:label path="monto">Monto: </form:label>
						<form:input path="monto" type="number" min="0" step=".01" />
						<form:errors path="monto" />
					</div>
		
					<button class="ui primary button" type="submit">Guardar</button>
					<button class="ui button" type="reset" >Limpiar</button>
				</form:form>
			</div>
		</div>
		
		<div class="ui container">
			<div>
				<table class="ui single line table">
					<thead>
						<tr>
							<th>Tipo de ingreso</th>
							<th>Monto</th>
							<th>Acciones</th>
						</tr>				
					</thead>
					<tbody>
					
						<c:forEach items="${ingresoPlanillaList}" var="ingresoPlanilla">
							<tr>
								<td>
									<c:out value="${ingresoPlanilla.getTipoIngreso().getTipoIngreso()}"></c:out>
								</td>
								<td>
									<fmt:formatNumber minFractionDigits="2" type="currency" 
										currencySymbol="$"
										value="${ingresoPlanilla.getMonto()}" />
								</td>
								<td>
									<div class="ui mini circular icon button" data-tooltip="Editar" data-inverted="">
										<a href="<c:url value="/ingreso-planilla/index.html?
											id=${ingresoPlanilla.getPlanillaEmpleado().getId()}
											&idi=${ingresoPlanilla.getTipoIngreso().getId()}" />">
											<i class="large edit icon"></i>
										</a>
									</div>
									<div class="ui mini circular icon button" data-tooltip="Eliminar" data-inverted="">
										<a href="<c:url value="/ingreso-planilla/delete.html?
											id_planilla=${ingresoPlanilla.getPlanillaEmpleado().getId()}
											&id_ingreso=${ingresoPlanilla.getTipoIngreso().getId()}" />">
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