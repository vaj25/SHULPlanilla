
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Genero</title>
</head>
<body>
	<div>
		<div>
			<a href="<c:url value="/genero.html" />">Atras</a>
		</div>
		<div>
			<form:form method="post" modelAttribute="Genero">
				
				<form:errors path="*" element="div" cssClass="alert" />
				
				<form:label path="genero">Genero: </form:label>
				<form:input path="genero" />
				<form:errors path="genero" />
				
				<br/>
				
				<button type="submit">Guardar</button>
			</form:form>
		</div>
	</div>
</body>
</html>