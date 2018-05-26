
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Venta del empleado</title>
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
				<c:url var="post_url" value="/rango-planilla/index.html" />
				<form:form method="post" modelAttribute="RangoPlanilla" cssClass="ui form"
					action="${post_url}">

					<h4 class="ui dividing header">Venta para xxx</h4>

					<form:errors path="*" element="div" cssClass="alert" />
					<div class="field">
						<form:label path="venta">Venta: </form:label>
						<form:input path="venta" type="number" min="0" step=".01" />
						<form:errors path="venta" />
					</div>
					
					<form:hidden path = "id.planillaEmpleado.id" value = "${RangoPlanilla.getPlanillaEmpleado().getId()}"/>
					<form:hidden path = "id.rangoComision.id" value = "${RangoPlanilla.getRangoComision().getId()}"/>

					<button class="ui primary button" type="submit">Guardar</button>
					<button class="ui button" type="reset" >Limpiar</button>
					<a class="negative ui button" href="<c:url value="/rango-planilla/delete.html?
						id_planilla=${RangoPlanilla.getPlanillaEmpleado().getId()}&
						id_rango=${RangoPlanilla.getRangoComision().getId()}" />">Eliminar</a>
				</form:form>
			</div>
		</div>
	</div>

	<c:import url="../layouts/footer.jsp"></c:import>
</body>
</html>
