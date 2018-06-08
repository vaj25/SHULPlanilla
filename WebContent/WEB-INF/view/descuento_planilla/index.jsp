<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Descuentos</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/semantic.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/application.css" />
</head>
<body>

	<c:import url="../layouts/menu.jsp"></c:import>
	<div class="container">
		<div class="ui raised very padded text container segment">
			<div class="ui large breadcrumb">
				<a class="section" href="<c:url value="/planilla-empleado/index.html?id=${idPl}"/>">Atras</a>
			</div>
			<br><br>
			<div>
				<c:url var="post_url" value="/descuento-planilla/index.html" />
				<form:form method="post" modelAttribute="DescuentoPlanilla" cssClass="ui form"
					action="${post_url}">

					<h4 class="ui dividing header">Gestionar descuentos de ${planillaEmpleado.getEmpleado()}</h4>

					<form:errors path="*" element="div" cssClass="alert" />

					<div class="field">
						<form:label path="id.tipoDescuento.id">Tipo de Descuento: </form:label>
						<form:select path="id.tipoDescuento.id">
                			<form:option value="0" label="Seleccione el tipo descuento"/>
                			<form:options items="${tipoDescuentoList}" itemValue="id" />
            			</form:select>
						<form:errors path="id.tipoDescuento" />
					</div>

					<form:hidden path = "id.planillaEmpleado.id" value = "${planillaEmpleado.getId()}"/>

					<div class="field">
						<form:label path="monto">Monto: </form:label>
						<form:input path="monto" type="number" min="0" step=".01" />
						<form:errors path="monto" />
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
							<th>Tipo de Descuento</th>
							<th>Monto</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${descuentoPlanillaList}" var="descuentoPlanilla">
							<tr>
								<td>
									<c:out value="${descuentoPlanilla.getTipoDescuento()}"></c:out>
								</td>
								<td>
									<fmt:formatNumber minFractionDigits="2" type="currency"
										currencySymbol="$"
										value="${descuentoPlanilla.getMonto()}" />
								</td>
								<td>
									<div class="ui mini circular icon button" data-tooltip="Editar" data-inverted="">
										<a href="<c:url value="/descuento-planilla/index.html?
											id=${descuentoPlanilla.getPlanillaEmpleado().getId()}
											&id_pl=${descuentoPlanilla.getPlanillaEmpleado().getPlanilla().getId()}
											&idi=${descuentoPlanilla.getTipoDescuento().getId()}" />">
											<i class="large edit icon"></i>
										</a>
									</div>
									<div class="ui mini circular icon button" data-tooltip="Eliminar" data-inverted="">
										<a href="<c:url value="/descuento-planilla/delete.html?
											id_planilla=${descuentoPlanilla.getPlanillaEmpleado().getId()}
											&id_pl=${descuentoPlanilla.getPlanillaEmpleado().getPlanilla().getId()}
											&id_descuento=${descuentoPlanilla.getTipoDescuento().getId()}" />">
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
