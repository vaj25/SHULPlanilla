<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Permisos</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/semantic.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/application.css" />
</head>
<body>
	
	<c:import url="../layouts/menu.jsp"></c:import>
	<div class="container">
	
		<c:choose>
				<c:when test="${messageSuccess != null}" >
					<div class="ui positive message">
						<div class="header">¡Exito!</div>
						<p>${messageSuccess}</p>
					</div>
				</c:when>
				<c:when test="${messageError != null}">
					<div class="ui negative message">
						<div class="header">¡Error!</div>
						<p>${messageError}</p>
					</div>
				</c:when>
			</c:choose>
		
		<div class="ui raised very padded text container segment">
		
			<div class="ui large breadcrumb">
				<a class="section" href="<c:url value="/rol/index.html" />">Atras</a>
			</div>
			<br><br>
			<div>
				<form method="post" class="ui form">
					
					<h4 class="ui dividing header">Permisos</h4>

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
					
				</form>
			</div>
		</div>
		
		<div class="ui container">
			<div>
				<table class="ui single line table">
					<thead>
						<tr>
							<th>Numero</th>
							<th>Modulo</th>
							<th>Permiso</th>
							<th>Acciones</th>
						</tr>				
					</thead>
					<tbody>
					
						<c:forEach items="${rolModuloPermisoList}" var="rolModuloPermiso">
							<tr>
								<td>
									<c:out value="${rolModuloPermiso.getId()}"></c:out>
								</td>
								<td>
									<c:out value="${rolModuloPermiso.getModulo()}"></c:out>
								</td>
								<td>
									<c:out value="${rolModuloPermiso.getPermiso()}"></c:out>
								</td>
								<td>
									<c:choose>
										<c:when test = "${rolModuloPermiso.getEstado() }" >
											<div class="ui mini circular icon button" data-tooltip="Inabilitar" data-inverted="">
												<a href="<c:url value="/rol-modulo-permiso/disable.html?
													id=${rolModuloPermiso.getId()}" />">
													<i class="large minus circle icon"></i>
												</a>
											</div>
										</c:when>
										<c:otherwise >
											<div class="ui mini circular icon button" data-tooltip="Habilitar" data-inverted="">
												<a href="<c:url value="/rol-modulo-permiso/enable.html?
													id=${rolModuloPermiso.getId()}" />">
													<i class="large plus circle icon"></i>
												</a>
											</div>
										</c:otherwise>
									</c:choose>
									<div class="ui mini circular icon button" data-tooltip="Eliminar" data-inverted="">
										<a href="<c:url value="/rol-modulo-permiso/delete.html?
											id=${rolModuloPermiso.getId()}" />">
											<i class="large erase icon"></i>
										</a>
									</div>
								</td>
							</tr>					
						</c:forEach>
						
					</tbody>
				</table>
			</div>
		</div>
		
		<c:set var="url" value="${pageContext.request.contextPath}/rol-modulo-permiso/index.html?id=${param.id}" scope="request"></c:set>
		<c:set var="simbol" value="&" scope="request"></c:set>
		<c:set value="${totalCount}" var="totalCount" scope="request" ></c:set>
		<c:set value="${perPage}" var="perPage" scope="request" ></c:set>
		<c:if test="${totalCount > perPage}">
			<c:import url="../layouts/pagination.jsp"></c:import>		
		</c:if>
	
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