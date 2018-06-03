
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Empleados</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/semantic.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/application.css" />
</head>
<body>
 
	<c:import url="../layouts/menu.jsp"></c:import>
	<div class="container">
		<div class="ui container">
			<div>
				<a class="ui positive button" href="<c:url value="/empleado/add.html" />">Agregar</a>
			</div>
			
			<br>
			
			  
			  <c:forEach items="${mensaje}" var="empleado">
			 <div class="ui red message">
			  <div class="header">
			    ¡ERROR!
			  </div>
			  <p>"${mensaje}"</p>
			</div>
			</c:forEach>
			
			<div style="width:1300x;overflow-x: scroll;">
				<table class="ui single line table">
					<thead>
						<tr>
							<th>Número</th>
							<th>Primer Nombre</th>
							<th>Segundo Nombre</th>
							<th>Primer Apellido</th>
							<th>Segundo Apellido</th>
							<th>Apellido Casada</th>
							<th>Fecha de nacimiento</th>
							<th>Genero</th>
							<th>Fecha de ingreso</th>
							<th>NIT</th>
							<th>ISSS</th>
							<th>NUP</th>
							<th>Tipo Documento Identidad</th>
							<th>Documento de Identidad</th>
							<th>Email</th>
							<th>Email Inst</th>
							<th>Colonia</th>
							<th>Avenida</th>
							<th>Num Calle</th>
							<th>Num Casa</th>
							<th>Pasaje</th>
							<th>Poligono</th>
							<th>Municipio</th>
							<th>Departamento</th>
							<th>Zona</th>
							<th>Jefe</th>
							<th>Estado Civil</th>
							<th>Profesion o Oficio</th>
							
							
						</tr>				
					</thead>
					<tbody>
					
						<c:forEach items="${empleadoList}" var="empleado">
							<tr>
								<td>
									<c:out value="${empleado.getId()}"></c:out>
								</td>
								<td>
									<c:out value="${empleado.getPrimer_nombre()}"></c:out>
								</td>
								<td>
									<c:out value="${empleado.getSegundo_nombre()}"></c:out>
								</td>
								<td>
									<c:out value="${empleado.getPrimer_apellido()}"></c:out>
								</td>
								<td>
									<c:out value="${empleado.getSegundo_apellido()}"></c:out>
								</td>
								<td>
									<c:out value="${empleado.getApellido_casada()}"></c:out>
								</td>
								<td>
									
									<fmt:formatDate pattern = "dd-MM-yyyy" value = "${empleado.getFecha_nacimiento()}" />
									
								</td>
								<td>
									<c:out value="${empleado.getGenero().getGenero()}"></c:out>
								</td>
								<td>
									<fmt:formatDate pattern = "dd-MM-yyyy" value = "${empleado.getFecha_ingreso()}" />
								</td>
								<td>
									<c:out value="${empleado.getNit()}"></c:out>
								</td>
								<td>
									<c:out value="${empleado.getIsss()}"></c:out>
								</td>
								<td>
									<c:out value="${empleado.getNup()}"></c:out>
								</td>
								<td>
									<c:out value="${empleado.getTipoDocIdentidad().getTipo()}"></c:out>
								</td>
								<td>
									<c:out value="${empleado.getDoc_identidad()}"></c:out>
								</td>
								<td>
									<c:out value="${empleado.getEmail_pers()}"></c:out>
								</td>
								<td>
									<c:out value="${empleado.getEmail_inst()}"></c:out>
								</td>
								<td>
									<c:out value="${empleado.getDireccion().getColonia()}"></c:out>			
								</td>
								<td>									
									<c:out value="${empleado.getDireccion().getAvenida()}"></c:out>									
								</td>
								<td>
									<c:out value="${empleado.getDireccion().getNumCalle()}"></c:out>
								</td>
								<td>									
									<c:out value="${empleado.getDireccion().getNumCasa()}"></c:out>									
								</td>
								<td>						
									<c:out value="${empleado.getDireccion().getPasaje()}"></c:out>									
								</td>
								<td>								
									<c:out value="${empleado.getDireccion().getPoligono()}"></c:out>
								</td>
								<td>
									<c:out value="${empleado.getDireccion().getMunicipio().getNombre()}"></c:out>
								</td>
								<td>
									<c:out value="${empleado.getDireccion().getMunicipio().getDepartamento().getNombre()}"></c:out>
								</td>
								<td>
									<c:out value="${empleado.getDireccion().getMunicipio().getDepartamento().getZona().getZona()}"></c:out>
								</td>
								<td>
									<c:out value="${empleado.getJefe().getPrimer_nombre()}"></c:out>
									<c:out value="${empleado.getJefe().getPrimer_apellido()}"></c:out>
									
								</td>
								<td>
									<c:out value="${empleado.getEstadoCivil().getEstadoCivil()}"></c:out>
								</td>
								<td>
									<c:out value="${empleado.getProfesionOficio().getProfesion_oficio()}"></c:out>
								</td>
								<td>
									<div class="ui mini circular icon button" data-tooltip="Editar" data-inverted="">
										<a href="<c:url value="/empleado/edit.html?id=${empleado.getId()}" />">
											<i class="large edit icon"></i>
										</a>
									</div>
									<div class="ui mini circular icon button" data-tooltip="Eliminar" data-inverted="">
										<a href="<c:url value="/empleado/delete.html?id=${empleado.getId()}" />">
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