
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Nivel de Puesto</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/semantic.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/application.css" />
</head>
<body>
	<c:set value="${Usuario}" var="usuario" scope="request" ></c:set> 
	<c:set value="${modulos}" var="modulos" scope="request" ></c:set>
	
	<c:import url="../layouts/menu.jsp"></c:import>
	<div class="container">
		<div class="ui raised very padded text container segment">
			<div class="ui large breadcrumb">
				<a class="section" href="<c:url value="/nivel-puesto/index.html" />">Atras</a>
			</div>
			<br><br>
			<div>
				<form:form method="post" modelAttribute="TipoPuesto" cssClass="ui form">
					
					<h4 class="ui dividing header">Nuevo Nivel de Puesto</h4>
					
					<form:errors path="*" element="div" cssClass="alert" />
					<div class="field">
						<form:label path="numeroNivel">Número Nivel: </form:label>
						<form:input type="number" path="numeroNivel" />
						<form:errors path="numeroNivel" />
					</div>
					
					<div class="field">
						<form:label path="salarioMinimo">Salario Mínimo: </form:label>
						<form:input path="salarioMinimo" type="number" min="0" value="0" step=".01" />
						<form:errors path="salarioMinimo" />
					</div>
					
					<div class="field">
						<form:label path="salarioMaximo">Salario Máximo: </form:label>
						<form:input path="salarioMaximo" type="number" min="0" value="0" step=".01" />
						<form:errors path="salarioMaximo" />
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