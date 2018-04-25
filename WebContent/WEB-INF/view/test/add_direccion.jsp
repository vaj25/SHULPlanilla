
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Direccion</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/semantic.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/application.css" />
</head>
<body>
	<c:import url="../layouts/menu.jsp"></c:import>
	<div class="container">
		<div class="ui raised very padded text container segment">
			<div class="ui large breadcrumb">
				<a class="section" href="<c:url value="/welcome.html" />">Atras</a>
			</div>
			<br><br>
			<div>
				<form:form method="post" modelAttribute="Direccion" cssClass="ui form">
					
					<h4 class="ui dividing header">Nuevo Direccion</h4>
					
					<form:errors path="*" element="div" cssClass="alert" />
					<div class="field">
						<form:label path="numCasa">Numero de casa: </form:label>
						<form:input path="numCasa" />
						<form:errors path="numCasa" />
					</div>
					
					<div class="field">
						<form:label path="colonia">Colonia: </form:label>
						<form:input path="colonia" />
						<form:errors path="colonia" />
					</div>
					
					<div class="field">
						<form:label path="avenida">Avenida: </form:label>
						<form:input path="avenida" />
						<form:errors path="avenida" />
					</div>
					
					<div class="field">
						<form:label path="poligono">Poligono: </form:label>
						<form:input path="poligono" />
						<form:errors path="poligono" />
					</div>
					
					<div class="field">
						<form:label path="pasaje">Pasaje: </form:label>
						<form:input path="pasaje" />
						<form:errors path="pasaje" />
					</div>
					
					<div class="field">
						<form:label path="municipio.id">Municipio: </form:label>
						<form:select path="municipio.id">
                			<form:option value="0" label="Seleccione un Municipio"/>
                			<form:options items="${municipioList}" itemValue="id" />
            			</form:select>
						<form:errors path="municipio" />
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