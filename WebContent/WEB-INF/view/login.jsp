
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
	
</body>
</html>