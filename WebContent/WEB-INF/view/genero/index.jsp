
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Genero</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/semantic.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/application.css" />
</head>
<body>
	<c:import url="../layouts/menu.jsp"></c:import>
	<div class="container">
		<div class="ui container">
			<div>
				<a class="ui positive button" href="<c:url value="add-genero.html" />">Agregar</a>
			</div>
			
			<br>
			
			<div>
				<table class="ui single line table">
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
									<div class="ui mini circular icon button" data-tooltip="Editar" data-inverted="">
										<a href="<c:url value="edit-genero.html?id=${genero.getId()}" />">
											<i class="large edit icon"></i>
										</a>
									</div>
									<div class="ui mini circular icon button" data-tooltip="Eliminar" data-inverted="">
										<a href="<c:url value="delete-genero.html?id=${genero.getId()}" />">
											<i class="large erase icon"></i>
										</a>
									</div>
								</td>
							</tr>					
						</c:forEach>
						
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
	<c:import url="../layouts/footer.jsp"></c:import>
</body>
</html>