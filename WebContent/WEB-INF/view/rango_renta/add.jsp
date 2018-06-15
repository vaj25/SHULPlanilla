
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Tipo de Documento Identidad</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/semantic.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/application.css" />
</head>
<body>
	<c:import url="../layouts/menu.jsp"></c:import>
	<div class="container">
		<div class="ui raised very padded text container segment">
			<div class="ui large breadcrumb">
				<a class="section" href="<c:url value="/rango-renta/index.html" />">Atras</a>
			</div>
			<br><br>
			<div>
				<form:form method="post" modelAttribute="RangoRenta" cssClass="ui form">

					<h4 class="ui dividing header">Nuevo Rango  de Renta</h4>

					<div class="field">
						<form:label path="desde">Monto minimo: </form:label>
						<form:input path="desde" type="number" min="0" value="0" step=".01" />
						<form:errors path="desde" />
					</div>

					<div class="field">
						<form:label path="hasta">Monto máximo: </form:label>
						<form:input path="hasta" type="number" min="0" value="0" step=".01" />
						<form:errors path="hasta" />
					</div>

					<div class="field">
						<form:label path="periodo">Periodo: </form:label>
						<form:input type="number" path="periodo" />
						<form:errors path="periodo" />
					</div>

					<div class="field">
						<form:label path="cuota">Cuota fija: </form:label>
						<form:input path="cuota" type="number" min="0" value="0" step=".01" />
						<form:errors path="cuota" />
					</div>

					<div class="field">
						<form:label path="taza">Taza: </form:label>
						<form:input path="taza" type="number" min="0" value="0" step=".01" />
						<form:errors path="taza" />
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
