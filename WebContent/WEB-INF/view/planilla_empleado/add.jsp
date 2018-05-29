
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
		<div class="ui raised very padded text container segment">
			<div class="ui large breadcrumb">
				<a class="section" href="<c:url value="/planilla-empleado/index.html" />">Atras</a>
			</div>
			<br><br>
			<div>
				<form:form method="post" modelAttribute="PlanillaEmpleado" cssClass="ui form">

					<h4 class="ui dividing header">Nuevo planilla para empleado</h4>

					<form:errors path="*" element="div" cssClass="alert" />
					<div class="field">
						<form:label path="idEmpleado">Empleado: </form:label>
						<form:input path="idEmpleado" />
						<form:errors path="idEmpleado" />
					</div>

					<div class="field">
						<form:label path="idTipoDescuento">Tipo descuento: </form:label>
						<form:input path="idTipoDescuento" type="number" min="0" value="0" />
						<form:errors path="idTipoDescuento" />
					</div>

					<button class="ui primary button" type="submit">Guardar</button>
					<button class="ui button" type="reset" >Limpiar</button>
				</form:form>
			</div>
		</div>
	</div>

	<c:import url="../layouts/footer.jsp"></c:import>
</body>
</html>