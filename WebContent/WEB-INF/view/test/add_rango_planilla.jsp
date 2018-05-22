<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Rango Comision</title>
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
				<form:form method="post" modelAttribute="RangoPlanilla" cssClass="ui form">
					
					<h4 class="ui dividing header">Nuevo Rango Planilla</h4>
					
					<form:errors path="*" element="div" cssClass="alert" />
					
					<div class="field">
						<form:label path="id.planillaEmpleado.id">planilla empleado: </form:label>
						<form:select path="id.planillaEmpleado.id">
                			<form:option value="0" label="Seleccione la planilla empleado"/>
                			<form:options items="${planillaEmpleadoList}" itemValue="id" />
            			</form:select>
						<form:errors path="id.planillaEmpleado.id" />
					</div>
					
					<div class="field">
						<form:label path="id.rangoComision.id">rango comision: </form:label>
						<form:select path="id.rangoComision.id">
                			<form:option value="0" label="Seleccione el rango comision"/>
                			<form:options items="${rangoComisionList}" itemValue="id" />
            			</form:select>
						<form:errors path="id.rangoComision.id" />
					</div>
					
					<div class="field">
						<form:label path="venta">Venta: </form:label>
						<form:input path="venta" type="number" min="0" value="0" step=".01" />
						<form:errors path="venta" />
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