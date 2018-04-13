
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tipo de Documento Identidad</title>
</head>
<body>
	<div>
		<div>
			<a href="<c:url value="/tipo-doc-identidad.html" />">Atras</a>
		</div>
		<div>
			<form method="post">
				<label>Tipo: </label>
				<input type="text" name="tipo" />
				
				<br/>
				
				<button type="submit">Guardar</button>
			</form>
		</div>
	</div>
</body>
</html>