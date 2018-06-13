<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Municipio</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/semantic.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/application.css" />
</head>
<body>
	<c:import url="../layouts/menu.jsp"></c:import>
	<div class="container">
		<div class="ui raised very padded text container segment">
			<div class="ui large breadcrumb">
				<a class="section" href="<c:url value="/municipio/index.html" />">Atras</a>
			</div>
			<br><br>
			<div>
				<form:form method="post" modelAttribute="Municipio" cssClass="ui form">
					
					<h4 class="ui dividing header">Nuevo Municipio</h4>
					
					<form:errors path="*" element="div" cssClass="alert" />
					<div class="field">
						<form:label path="nombre">Nombre Municipio: </form:label>
						<form:input path="nombre" />
						<form:errors path="nombre" />
					</div>
					<div class="field">
						<form:label path="departamento.id"></form:label>
						<form:select path="departamento.id" class="ui fluid dropdown">
                		<form:option value="0" label="Departamento"/>
                		<form:options items="${departamentoList}" itemValue="id" />
            			</form:select>
						<form:errors path="departamento.id" />
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