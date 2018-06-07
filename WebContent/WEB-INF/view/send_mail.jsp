
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Enviar mensaje</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/semantic.min.css" />
	<style>
		body > .grid {
			height: 100%;
		}
    
		.column {
			max-width: 750px;
		}
		
		.container-message {
			position: absolute;
			width: 600px;
			margin: 1em 28%;
		}
	</style>
</head>
<body>

	<div class="ui middle aligned centered grid">	
		<div class="column">
			
			<div class="ui large breadcrumb">
				<a class="section" href="<c:url value="/login.html" />">Atras</a>
			</div>
			
			<form method="post" class="ui form">
				<div class="ui error message"></div>
				<div class="ui stacked secondary segment">
					<div class="field">
						<label>De: </label>
						<input type="email" name="from" placeholder="Remitente">			
					</div>

					<div class="field">
						<label>Asunto: </label>
						<input type="text" name="subject" placeholder="Asunto">
					</div>
					
					<div class="field">
    					<label>Mensaje:</label>
    					<textarea name="text" rows="5"></textarea>
  					</div>
					
					<button class="ui fluid large blue button" type="submit">Enviar</button>
				</div>
			</form>
			
		</div>
	</div>
	<script src="${pageContext.request.contextPath}/assets/javascript/jquery-1.11.3.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/javascript/semantic.min.js"></script>
	<script type="text/javascript">
		
		$('.ui.form').form({
			
			on: 'blur',
			fields: {
				from: {
					identifier: 'from',
					rules: [
						{
							type: 'empty',
							prompt: 'Por favor, el remitente es obligatorio.'
						}
					]
				},
				text: {
					identifier: 'text',
					rules: [
						{					
							type: 'empty',
							prompt: 'Por favor, el cuerpo del mensaje es obligatorio.'
						}
					]
				},
			}
			
		});
	</script>
</body>
</html>