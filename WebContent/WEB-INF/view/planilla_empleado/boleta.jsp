<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Impresión Boleta</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/semantic.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/application.css" />
</head>
<body onload="window.print()">

	<h1 style="text-align: center" >Boleta de Pago</h1>
	
	<table class="ui celled padded small table" >
		<thead>		
			<tr>
				<th colspan="6" >Datos de la empresa</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>Nombre</th>
				<th>NIT</th>
				<th>NIC</th>
				<th>Representante</th>
				<th>Teléfono</th>
				<th>Dirección</th>
			</tr>
			<tr>
				<td> <c:out value="${org}" /> </td>
				<td> <c:out value="${org.getNit()}" /> </td>
				<td> <c:out value="${org.getNic()}" /> </td>
				<td> <c:out value="${org.getRepresentante()}" /> </td>
				<td> <c:out value="${org.getTelefono()}" /> </td>
				<td> <c:out value="${org.getDireccion()}" /> </td>
			</tr>
		</tbody>
	</table>
	
	<table class="ui celled padded small table">
		<thead>		
			<tr>
				<th colspan="6" >Datos del Trabajador</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>Código</th>
				<th>Nombres</th>
				<th>Apellido</th>
				<th>NIT</th>
				<th>Fecha Nacimiento</th>
				<th>Dirección</th>
			</tr>
			<tr>
				<td> <c:out value="${empleado.getEmpleado().getId()}" /> </td>
				<td>
					<c:out value="${empleado.getEmpleado().getPrimer_nombre()}" />
					<c:out value=" " />
					<c:out value="${empleado.getEmpleado().getSegundo_nombre()}" />
				</td>
				<td>
					<c:out value="${empleado.getEmpleado().getPrimer_apellido()}" />
					<c:out value=" " />
					<c:out value="${empleado.getEmpleado().getSegundo_apellido()}" />
				</td>
				<td> <c:out value="${empleado.getEmpleado().getNit() }" /> </td>
				<td> <fmt:formatDate type = "date" value = "${empleado.getEmpleado().getFecha_nacimiento()}" /> </td>
				<td> <c:out value="${empleado.getEmpleado().getDireccion() }" /> </td>
			</tr>
		</tbody>
	</table>
	
	<table class="ui celled padded small table" >
		<thead>		
			<tr>
				<th colspan="5" >Datos del Trabajador Vinculados a la relación laboral</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>Cargo</th>
				<th>Tipo de Empleado</th>
				<th>Profesión</th>
				<th>Fecha Ingreso</th>
			</tr>
			<tr>
				<td> <c:out value="${info.getPuesto().getNombre() }" /> </td>
				<td> <c:out value="${info.getTipoEmpleado().getTipo_empleado() }" /> </td>
				<td> <c:out value="${empleado.getEmpleado().getProfesionOficio() }" /> </td>
				<td> <fmt:formatDate type = "date" value="${empleado.getEmpleado().getFecha_ingreso() }" /> </td>
			</tr>
		</tbody>
	</table>
	<div>
		<c:set var="mondes" value="${0}" />
		<c:set var="moning" value="${0}" />

		<table class="ui celled padded small table" >
			<thead>		
				<tr>
					<th colspan="2" >Ingresos</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ingresos}" var="ingreso" >
					<tr>
						<td> <c:out value="${ingreso.getId().getTipoIngreso().getTipoIngreso()}" /> </td>
						<td> $<c:out value="${ingreso.getMonto()}" /> </td>
					</tr>
					<c:set var="monto" value="${ingreso.getMonto()}" />
					<c:set var="moning" value="${ moning + monto }" ></c:set>
				</c:forEach>
			</tbody>
		</table>
		
		<table class="ui celled padded small table" >
			<thead>		
				<tr>
					<th colspan="2" >Descuentos</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${descuentos}" var="descuento" >
					<tr>
						<td> <c:out value="${descuento.getId().getTipoDescuento().getTipo()}" /> </td>
						<td> $<c:out value="${descuento.getMonto()}" /> </td>
					</tr>
					<c:set var="monto" value="${descuento.getMonto()}" />
					<c:set var="mondes" value="${ mondes + monto }" ></c:set>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<table class="ui celled padded small table" >
		<tr>
			<td> Total a Pagar: </td>
			<td> $ <c:out value="${info.getSalario() + ( moning ) }" /> </td>
		</tr>
	</table>
	
</body>
</html>