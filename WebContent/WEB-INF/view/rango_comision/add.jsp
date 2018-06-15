<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
		<div class="ui raised very padded text container segment">
			<div class="ui large breadcrumb">
				<a class="section" href="<c:url value="/rango-comision/index.html" />">Atras</a>
			</div>
			<br><br>
			<div>
				<form:form method="post" modelAttribute="RangoComision" cssClass="ui form">
					
					<h4 class="ui dividing header">Nuevo Rango Comisión</h4>
					
					<div class="field">
						<form:label path="desde">Desde: </form:label>
						<form:input path="desde" type="number" min="0" value="0" step=".01" />
						<form:errors path="desde" />
					</div>
					
					<div class="field">
						<form:label path="hasta">Hasta: </form:label>
						<form:input path="hasta" type="number" min="0" value="0" step=".01" />
						<form:errors path="hasta" />
					</div>
					
					<div class="field">
						<form:label path="tasa">Tasa: </form:label>
						<form:input path="tasa" type="number" min="0.1" step="0.1" value="0" max="1" />
						<form:errors path="tasa" />
					</div>
					
					<div class="field">
						<form:label path="tipoIngreso.id">Tipo de ingreso: </form:label>
						<form:select path="tipoIngreso.id">
                			<form:option value="0" label="Seleccione el tipo de ingreso"/>
                			<form:options items="${tipoIngresoList}" itemValue="id" />
            			</form:select>
						<form:errors path="tipoIngreso" />
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