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
		<div class="ui raised very padded text container segment">
			<div class="ui large breadcrumb">
				<a class="section" href="<c:url value="/rol/index.html" />">Atras</a>
			</div>
			<br><br>
			<div>
				<c:url var="post_url" value="/rol-modulo-permiso/index.html" />
				<form:form method="post" modelAttribute="RolModuloPermiso" cssClass="ui form"
					action="${post_url}">
					
					<h4 class="ui dividing header">Gestionar permiso de <c:out value="${rol.getNombre()}"></c:out> </h4>
					
					<form:errors path="*" element="div" cssClass="alert" />
					
					<div class="field">
						<form:label path="modulo.id">Modulo: </form:label>
						<form:select path="modulo.id" cssClass="ui dropdown">
                			<form:option value="0" label="Seleccione el modulo"/>
                			<form:options items="${moduloList}" itemValue="id" />
            			</form:select>
						<form:errors path="modulo.id" />
					</div>
					
					<form:hidden path = "rol.id" value = "${rol.getId()}"/>
					
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
		
					<button class="ui primary button" type="submit">Guardar</button>
					<button class="ui button" type="reset" >Limpiar</button>
				</form:form>
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
		
		
	</div>
	
	<c:import url="../layouts/footer.jsp"></c:import>
	
</body>
</html>