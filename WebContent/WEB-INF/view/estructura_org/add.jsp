<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Estructura Organizativa</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/semantic.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/application.css" />
</head>
<body>
	<c:import url="../layouts/menu.jsp"></c:import>
	<div class="container">
		<div class="ui raised very padded text container segment">
			<div class="ui large breadcrumb">
				<a class="section" href="<c:url value="/estructura-org/index.html" />">Atras</a>
			</div>
			<br><br>
			<div>
				<form:form method="post" modelAttribute="EstructuraOrg" cssClass="ui form">
					
					<h4 class="ui dividing header">Nueva Estructura Organizativa</h4>
									
					<div class="field">
						<form:label path="unidadOrganizacional.id">Unidad Organizacional: </form:label>
						<form:select path="unidadOrganizacional.id">
                			<form:option value="0" label="Seleccione la unidad organizacional"/>
                			<form:options items="${unidadOrganizacionalList}" itemValue="id" />
            			</form:select>
						<form:errors path="unidadOrganizacional.id" />
						
					</div>
					
					<div class="field">
						<form:label path="nivelEstructura.id">Nivel Estructura: </form:label>
						<form:select path="nivelEstructura.id">
                			<form:option value="0" label="Seleccione el nivel de la estructura"/>
                			<form:options items="${nivelEstructuraList}" itemValue="id" />
            			</form:select>
						<form:errors path="nivelEstructura.id" />
					</div>
	
					<div class="field">
						<form:label path="estEstructuraOrg.id">Estructura Organizativa: </form:label>
						<form:select path="estEstructuraOrg.id">
                			<form:option value="0" label="Seleccione la estructura organizativa"/>
                			<form:options items="${estEstructuraOrgList}" itemValue="id" />
            			</form:select>
						<form:errors path="estEstructuraOrg.id" />
					</div>	
					
					<div class="field">
						<form:label path="nombre">Nombre: </form:label>
						<form:input path="nombre" type="text"/>
						<form:errors path="nombre" />
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