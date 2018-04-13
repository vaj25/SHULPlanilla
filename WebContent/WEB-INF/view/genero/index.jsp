
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Genero</title>
</head>
<body>
	<div>
		<div>
			<span> <a href="<c:url value="add-genero.html" />">Agregar</a> </span>
		</div>
		
		<div>
			<table>
				<thead>
					<tr>
						<th>Número</th>
						<th>Genero</th>
						<th>Acciones</th>
					</tr>				
				</thead>
				<tbody>
				
					<c:forEach items="${generoList}" var="genero">
						<tr>
							<td>
								<c:out value="${genero.getId()}"></c:out>
							</td>
							<td>
								<c:out value="${genero.getGenero()}"></c:out>
							</td>
							<td>
								<a href="<c:url value="edit-genero.html?id=${genero.getId()}" />">Editar</a>
								<a href="<c:url value="delete-genero.html?id=${genero.getId()}" />">Eliminar</a>
							</td>
						</tr>					
					</c:forEach>
					
				</tbody>
			</table>
		</div>
	</div>
	
</body>
</html>