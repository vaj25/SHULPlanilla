
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Usuario</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/semantic.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/application.css" />
</head>
<body>
	<c:import url="../layouts/menu.jsp"></c:import>
	<div class="container">
		<div class="ui raised very padded text container segment">
			<div class="ui large breadcrumb">
				<a class="section" href="<c:url value="/usuario/index.html" />">Atras</a>
			</div>
			<br><br>
			<div>
				<form method="post" class="ui form">
					
					<div class="field">
						<label>Nueva Password: </label>
						<input type="password" name="password" placeholder="password">
					</div>
					
					<div class="field">
						<label>Confirmar Password: </label>
						<input type="password" name="confirmPassword" placeholder="Confitmar password">
					</div>
					
					<div class="field">
						<div class="ui checkbox">
							<input type="checkbox" name="notificar" value="1" tabindex="0" class="hidden">
							<label>Notificar por correo electronico al usuario. </label>
						</div>
					</div>

					<button class="ui primary button" type="submit">Guardar</button>
					<button class="ui button" type="reset" >Limpiar</button>
				</form>
			</div>
		</div>
	</div>
	
	<c:import url="../layouts/footer.jsp"></c:import>
</body>
</html>