
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
	
	<c:set value="${user}" var="Usuario" scope="request" ></c:set>

	<c:import url="../layouts/menu.jsp"></c:import>
	<div class="container">
		<div>
			<form:form method="post" modelAttribute="Usuario" cssClass="ui raised very padded text container segment form">
				
				<div class="ui large breadcrumb">
					<a class="section" href="<c:url value="/usuario/index.html" />">Atras</a>
				</div>
				
				<h4 class="ui dividing header">Nuevo Usuario</h4>
				
				<form:errors path="*" element="div" cssClass="alert" />					
				<div class="field">
					<form:label path="username">Nombre del Usuario: </form:label>
					<form:input path="username" />
					<form:errors path="username" />
				</div>
				
				<div class="field">
					<form:label path="password">Contraseña: </form:label>
					<form:input type="password" path="password" />
					<form:errors path="password" />
				</div>
					
				<div class="field">
					<label>Confirmar Password: </label>
					<input type="password" name="confirmPassword" placeholder="Confitmar password">
				</div>
					
				<div class="field">
					<form:label path="rol.id">Rol: </form:label>
					<form:select path="rol.id" cssClass="ui fluid search dropdown">
        	   			<form:option value="0" label="Seleccione un rol"/>
              			<form:options items="${rolList}" itemValue="id" />
            		</form:select>
					<form:errors path="rol" />
				</div>
				
				<div class="field">
					<form:label path="empleado.id">Empleado: </form:label>
					<form:select path="empleado.id" cssClass="ui fluid search dropdown">
        	   			<form:option value="0" label="Seleccione un empleado"/>
              			<form:options items="${empleadoList}" itemValue="id" />
            		</form:select>
					<form:errors path="empleado" />
				</div>
					
				<form:hidden path="estado" value="1"/>
									
				<button class="ui primary button" type="submit">Guardar</button>
				<button class="ui button" type="reset" >Limpiar</button>
				<div class="ui error message"></div>
			</form:form>
		</div>
	</div>
	
	<c:import url="../layouts/footer.jsp"></c:import>
	<script src="${pageContext.request.contextPath}/assets/javascript/validation/password-validate.js"></script>
</body>
</html>