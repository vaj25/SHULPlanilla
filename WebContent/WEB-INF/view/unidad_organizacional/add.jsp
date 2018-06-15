<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Unidad Organizacional</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/semantic.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/application.css" />
</head>
<body>
	<c:import url="../layouts/menu.jsp"></c:import>
	<div class="container">
		<div class="ui raised very padded text container segment">
			<div class="ui large breadcrumb">
				<a class="section" href="<c:url value="/unidad-organizacional/index.html" />">Atras</a>
			</div>
			<br><br>
			<div>
				<form:form method="post" modelAttribute="UnidadOrganizacional" cssClass="ui form">
					
					<h4 class="ui dividing header">Nueva Unidad Organizacional</h4>
					
					<div class="field">
						<form:label path="unidad_org">Nombre Unidad Organizacional: </form:label>
						<form:input path="unidad_org" />
						<form:errors path="unidad_org" />
					</div>
					<div class="field">
						<form:label path="direccion">Direccion: </form:label>
						<form:input path="direccion" />
						<form:errors path="direccion" />
					</div>
					<div class="field">
						<form:label path="representante">Representante: </form:label>
						<form:input path="representante" />
						<form:errors path="representante" />
					</div>
					<div class="field">
						<form:label path="nit">NIT: </form:label>
						<form:input path="nit" />
						<form:errors path="nit" />
					</div>
					<div class="field">
						<form:label path="nic">NIC: </form:label>
						<form:input path="nic" tyep="number" />
						<form:errors path="nic" />
					</div>
					<div class="field">
						<form:label path="telefono">Telefono: </form:label>
						<form:input path="telefono" />
						<form:errors path="telefono" />
					</div>
					<div class="field">
						<form:label path="email_pers">Email: </form:label>
						<form:input path="email_pers" />
						<form:errors path="email_pers" />
					</div>
					<div class="field">
						<form:label path="site_web">Sitio Web: </form:label>
						<form:input path="site_web" />
						<form:errors path="site_web" />
					</div>
									
					<button class="ui primary button" type="submit">Guardar</button>
					<button class="ui button" type="reset" >Limpiar</button>
				</form:form>
			</div>
		</div>
	</div>
	
	<c:import url="../layouts/footer.jsp"></c:import>
</body>
</html>