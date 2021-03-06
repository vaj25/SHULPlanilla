<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Información Laboral</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/semantic.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/application.css" />

</head>
<body>
	<c:import url="../layouts/menu.jsp"></c:import>
	<div class="container">
		<div class="ui raised very padded text container segment">
			<div class="ui large breadcrumb">
				<a class="section" href="<c:url value="/info-laboral/index.html" />">Atras</a>
			</div>
			<br>
			<c:choose>
				<c:when test="${messageSuccess != null}" >
					<div class="ui positive message">
						<div class="header">¡Exito!</div>
						<p>${messageSuccess}</p>
					</div>
				</c:when>
				<c:when test="${messageError != null}">
					<div class="ui negative message">
						<div class="header">¡Error!</div>
						<p>${messageError}</p>
					</div>
				</c:when>
			</c:choose>	
			<div>
				<form:form method="post" modelAttribute="InfoLaboralEmpleado" cssClass="ui form">
					
					<h4 class="ui dividing header">Nueva Información Laboral</h4>			
					
					<div class="field">
						<form:label path="empleado.id">Empleado: </form:label>
						<form:select path="empleado.id">
                			<form:options items="${empleadoList}" itemValue="id" />	
            			</form:select>
						<form:errors path="empleado.id"/>
						
					</div>
					
					<div class="field">
						<form:label path="tipoEmpleado.id">Tipo de Empleado: </form:label>
						<form:select path="tipoEmpleado.id">
                			<form:option value="0" label="Seleccione el Tipo de Empleado"/>
                			<form:options items="${tipoEmpleadoList}" itemValue="id" />
            			</form:select>
						<form:errors path="tipoEmpleado.id" />
					</div>
	
					<div class="field">
						<form:label path="estructuraOrg.id">Estructura Organizativa: </form:label>
						<form:select path="estructuraOrg.id">
                			<form:option value="0" label="Seleccione la estructura organizativa"/>
                			<form:options items="${estructuraOrgList}" itemValue="id" />
            			</form:select>
						<form:errors path="estructuraOrg.id" />
					</div>	
					
					<div class="field">
						<form:label path="puesto.id">Puesto: </form:label>
						<form:select path="puesto.id">
                			<form:option value="0" label="Seleccione el Puesto"/>
                			<form:options items="${puestoList}" itemValue="id" />
            			</form:select>
						<form:errors path="puesto.id" />
					</div>	
					
					<div class="field">
						<form:label path="salario">Salario: </form:label>
						<form:input path="salario"  type="number" min="0" step=".01"/>
						<form:errors path="salario" />
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