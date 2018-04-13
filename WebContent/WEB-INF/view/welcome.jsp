
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
	<c:import url="layouts/menu.jsp"></c:import>
	<div class="container">
		<h1 align="center">Bienvenido a SHULPlanilla</h1>
	</div>
	<c:import url="layouts/footer.jsp"></c:import>
</body>
</html>