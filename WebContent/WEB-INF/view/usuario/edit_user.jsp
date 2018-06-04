
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
		<div class="ui raised very padded text container segment">
			<div class="ui large breadcrumb">
				<a class="section" href="<c:url value="/usuario/index.html" />">Atras</a>
			</div>
			<br><br>
			<div>
				<form:form method="post" modelAttribute="Usuario" cssClass="ui form">
					
					<h4 class="ui dividing header">Editar Usuario</h4>
					
					<form:errors path="*" element="div" cssClass="alert" />					
					<div class="field">
						<form:label path="username">Nombre del Usuario: </form:label>
						<form:input path="username" />
						<form:errors path="username" />
					</div>
										
					<div class="field">
						<form:label path="rol.id">Nivel de Puesto: </form:label>
						<form:select path="rol.id">
                			<form:option value="0" label="Seleccione un nivel de puesto"/>
                			<form:options items="${rolList}" itemValue="id" />
            			</form:select>
						<form:errors path="rol" />
					</div>
					
					<form:hidden path="password" value="${rol.password}"/>
					<form:hidden path="estado" value="${rol.estado}"/>
									
					<button class="ui primary button" type="submit">Guardar</button>
					<button class="ui button" type="reset" >Limpiar</button>
				</form:form>
			</div>
		</div>
	</div>
	
	<c:import url="../layouts/footer.jsp"></c:import>
</body>
</html>