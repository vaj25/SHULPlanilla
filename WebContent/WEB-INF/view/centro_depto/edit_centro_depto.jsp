<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Centro de Costo</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/semantic.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/application.css" />
</head>
<body>
	
	<c:import url="../layouts/menu.jsp"></c:import>
	<div class="container">
		<div class="ui raised very padded text container segment">
			<div class="ui large breadcrumb">
				<a class="section" href="<c:url value="/centro-depto/index.html" />">Atras</a>
			</div>
			<br><br>
			<div>
				<c:url var="post_url" value="/centro-depto/edit.html" />
				<form:form method="post" modelAttribute="CentroDepto" cssClass="ui form"
					action="${post_url}">
					
					<h4 class="ui dividing header">Editar Centro de Costo</h4>
					
					<form:errors path="*" element="div" cssClass="alert" />

					<div class="field">
						<form:label path="id.estructuraOrg.id">Estructura Organizativa: </form:label>
						<form:select path="id.estructuraOrg.id">
                			<form:option value="0" label="Seleccione la planilla empleado"/>
                			<form:options items="${estructuraOrgList}" itemValue="id" />
            			</form:select>
						<form:errors path="id.estructuraOrg.id" />
					</div>
					
					<div class="field">
						<form:label path="id.centroCosto.monto">Monto: </form:label>
						<form:input path="id.centroCosto.monto" type="number" min="0" step=".01" />
						<form:errors path="id.centroCosto.monto" />
					</div>

					<div class="field">
						<form:label path="id.centroCosto.periodicidad">Periodicidad: </form:label>
						<form:input path="id.centroCosto.periodicidad" type="text"/>
						<form:errors path="id.centroCosto.periodicidad" />
					</div>

					<div class="field">
						<form:label path="anio">Año: </form:label>
						<form:input path="anio" type="text"/>
						<form:errors path="anio" />
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