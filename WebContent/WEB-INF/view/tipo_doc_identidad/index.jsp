
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
			<span> <a href="<c:url value="add-tipo-doc-identidad.html" />">Agregar</a> </span>
		</div>
		
		<div>
			<table>
				<thead>
					<tr>
						<th>Número</th>
						<th>Típo</th>
						<th>Acciones</th>
					</tr>				
				</thead>
				<tbody>
				
					<c:forEach items="${tipoDocIdentidadList}" var="tipoDocIdentidad">
						<tr>
							<td>
								<c:out value="${tipoDocIdentidad.getId()}"></c:out>
							</td>
							<td>
								<c:out value="${tipoDocIdentidad.getTipo()}"></c:out>
							</td>
							<td>
								<a href="<c:url value="edit-tipo-doc-identidad.html" />">Editar</a>
								<a href="<c:url value="delete-tipo-doc-identidad.html" />">Eliminar</a>
							</td>
						</tr>					
					</c:forEach>
					
				</tbody>
			</table>
		</div>
	</div>
	
</body>
</html>