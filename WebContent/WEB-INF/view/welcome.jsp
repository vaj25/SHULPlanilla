
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome SHULPlanilla</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/semantic.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/application.css" />
</head>
<body>
	<c:set value="${Usuario}" var="usuario" scope="request" ></c:set> 
	<c:set value="${modulos}" var="modulos" scope="request" ></c:set>
	<c:import url="layouts/menu.jsp"></c:import>
	<div class="container">
		<h1 align="center">Bienvenido a SHULPlanilla</h1>
		<h2 align="center"><c:out value="${usuario.getUsername() }"></c:out> </h2>
	</div>
	<c:import url="layouts/footer.jsp"></c:import>
</body>
</html>