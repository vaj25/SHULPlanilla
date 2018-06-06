
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/semantic.min.css" />
	<style>
		body > .grid {
			height: 100%;
		}
    
		.column {
			max-width: 450px;
		}
	</style>
</head>
<body>

	<c:choose>
		<c:when test="${param.error == 'disable'}" >
			<div class="ui compact floating negative message">
				<i class="close icon"></i>
				<div class="header">¡Error!</div>
				<p>
					Lo sentimos su usuario ha sido bloqueado, por favor envie un mensaje al
					administrador haciendo click <a>aquí</a>.
				</p>
			</div>
		</c:when>
		<c:when test="${param.error == 'credential'}">
			<div class="ui inline cookie nag">
				<i class="close icon"></i>
				<div class="title">¡Error!</div>
				<p>
					Lo sentimos sus credenciales son incorrectas.
				</p>
			</div>
		</c:when>
		<c:when test="${param.error == 'default'}">
			<div class="ui compact center aligned grid negative message">
				<i class="close icon"></i>
				<div class="header">¡Error!</div>
				<p>
					Lo sentimos ha ocurrido un error en la trasacción.
				</p>
			</div>
		</c:when>
	</c:choose>
	
	<div class="ui middle aligned center aligned grid">	
		<div class="column">
			
			<form action="${pageContext.request.contextPath}/loginAction.html" method="post" class="ui form">
				<div class="ui stacked secondary segment">
					<div class="field">
						<label>Username: </label>
						<input type="text" name="username" placeholder="username">			
					</div>

					<div class="field">
						<label>Password: </label>
						<input type="password" name="password" placeholder="password">
					</div>
					
					<button class="ui fluid large blue button" type="submit">Login</button>
				</div>
			</form>
			
		</div>
	</div>
	<script src="${pageContext.request.contextPath}/assets/javascript/jquery-1.11.3.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/javascript/semantic.min.js"></script>
	<script type="text/javascript">
		$('.message .close')
		  .on('click', function() {
		    $(this)
		      .closest('.message')
		      .transition('fade')
		    ;
		  })
		;
		
		$('.cookie.nag')
		  .nag('show')
		;
	</script>
</body>
</html>