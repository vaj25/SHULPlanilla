<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Centro Costo</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/semantic.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/application.css" />
</head>
<body>
	
	<c:import url="../layouts/menu.jsp"></c:import>
	<div class="container">
		<div class="ui raised very padded text container segment">
			<div class="ui large breadcrumb">
				<a class="section" href="<c:url value="/centro-costo/index.html" />">Atras</a>
			</div>
			<br><br>
			<div>
				<form:form method="post" modelAttribute="CentroDepto" cssClass="ui form">
					
					<h4 class="ui dividing header">Nuevo Centro de Costo</h4>
					
					<div class="field">
						<form:label path="id.estructuraOrg.id">Estructura Organizativa: </form:label>
						<form:select path="id.estructuraOrg.id">
                			<form:option value="0" label="Seleccione la Estructura Organizativa"/>
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
						<form:select path="id.centroCosto.periodicidad">
                			<form:option value="15" label="Quincenal"/>
                			<form:option value="30" label="Mensual"/>
            			</form:select>
						<form:errors path="id.centroCosto.periodicidad" />
					</div>
					
					<div class="field">
						<form:label path="anio">Año	: </form:label>
						<form:input path="anio" type="number"/>
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