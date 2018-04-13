
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/loginAction.html" method="post">
		<label>Username: </label>
		<input type="text" name="username">
		<br/>
		<label>Password: </label>
		<input type="password" name="password">
		<br/>
		<button type="submit">Login</button>
	</form>
</body>
</html>