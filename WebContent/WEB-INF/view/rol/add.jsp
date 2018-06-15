
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Rol</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/semantic.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/application.css" />
</head>
<body>
	<c:import url="../layouts/menu.jsp"></c:import>
	<div class="container">
		<div class="ui raised very padded text container segment">
			<div class="ui large breadcrumb">
				<a class="section" href="<c:url value="/rol/index.html" />">Atras</a>
			</div>
			<br><br>
			<div>
				<form:form method="post" modelAttribute="Rol" cssClass="ui form">
				
					<h4 class="ui dividing header">Nuevo Rol</h4>
										
					<div class="field">
						<form:label path="nombre">Nombre: </form:label>
						<form:input path="nombre" />
						<form:errors path="nombre" />
					</div>
					
					<div class="field">
						<form:label path="descripcion">Descripción: </form:label>
						<form:textarea path="descripcion" rows="5" />
						<form:errors path="descripcion" />
					</div>
					
					<div class="field">
						<label>Modulos: </label>
						<select multiple name="modulos" id="modulos" class="ui selection dropdown">
                			<c:forEach var="modulo" items="${moduloList}">
                				<option value="${modulo.getId()}">${modulo}</option>
                			</c:forEach>
						</select>
					</div>
					
					<select style="display:none;" id="data-permisos" name="data-permisos" multiple></select>
					
					<button class="ui primary button" type="submit">Guardar</button>
					<button class="ui button" type="reset" >Limpiar</button>
				</form:form>
			</div>
		</div>
	</div>
	
	<div class="ui loger modal">
		<div class="header">Header</div>
		<div class="scrolling content">
			<div class="grouped fields">
				<label>Permisos: </label>
							
				<div class="field">
					<div class="ui checkbox">
		      			<input type="checkbox" name="permisos" value="1" class="hidden">  						
		      			<label>Leer</label>
		   			</div>
	   			</div>
	   			<div class="field">
		   			<div class="ui checkbox">
		      			<input type="checkbox" name="permisos" value="2" class="hidden">
		      			<label>Insertar</label>
		   			</div>
	   			</div>
	   			<div class="field">
		   			<div class="ui checkbox">
		      			<input type="checkbox" name="permisos" value="3" class="hidden">   						
		      			<label>Actualizar</label>
		   			</div>
	   			</div>
	   			<div class="field">
		   			<div class="ui checkbox">
		      			<input type="checkbox" name="permisos" value="4" class="hidden">
		      			<label>Elimnar</label>
		   			</div>
	   			</div>
			</div>
			
			<br><br>	
	    
		    <div class="actions">
			    <div class="ui approve primary button">Aceptar</div>
			    <div class="ui cancel negative button">Cancelar</div>
		  	</div>
	  	</div>
	</div>
	
	<c:import url="../layouts/footer.jsp"></c:import>
	<script src="${pageContext.request.contextPath}/assets/javascript/modulo-permiso.js"></script>
</body>
</html>