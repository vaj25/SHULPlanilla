
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Modulo</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/semantic.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/application.css" />
	<style>
		.actions .approve {
			margin: 0.5em;
		}
	</style>
</head>
<body>
	<c:import url="../layouts/menu.jsp"></c:import>
	<div class="container">
		<div class="ui raised very padded text container segment">
			<div class="ui large breadcrumb">
				<a class="section" href="<c:url value="/modulo/index.html" />">Atras</a>
			</div>
			<br><br>
			<div>
				<form:form method="post" modelAttribute="Modulo" cssClass="ui form">
				
					<h4 class="ui dividing header">Editar Modulo</h4>
					
					<form:errors path="*" element="div" cssClass="alert" />
					
					<div class="field">
						<form:label path="nombre">Nombre: </form:label>
						<form:input path="nombre" />
						<form:errors path="nombre" />
					</div>
					
					<div class="field">
						<form:label path="descripcion">Descripción: </form:label>
						<form:textarea path="descripcion" rows="5" cols="10" />
						<form:errors path="descripcion" />
					</div>
					
					<div class="field">
						<form:label path="orden">Orden: </form:label>
						<form:input path="orden" type="number" min="0" step="1" />
						<form:errors path="orden" />
					</div>
					
					<div class="field">
						<form:label path="url">URL: </form:label>
						<form:input path="url" />
						<form:errors path="url" />
					</div>
					
					<div class="field">
						<form:label path="icono">Icono: </form:label>
						<form:input path="icono" />
						<form:errors path="icono" />
					</div>
					
					<div class="field">
						<form:label path="opciones">Opciones: </form:label>
						<form:select path="opciones" cssClass="ui dropdown">
                			<form:option value="0" label="Seleccione las opciones"/>
                			<form:option value="1" label="1 - Leer"/>
                			<form:option value="2" label="2 - Leer / Insertar"/>
                			<form:option value="3" label="3 - Leer / Insertar / Actualizar"/>
                			<form:option value="4" label="4 - Leer / Insertar / Actualizar / Eliminar"/>
            			</form:select>
						<form:errors path="opciones" />
					</div>
					
					<div class="field">
						<form:label path="dependencia.id">Dependencia: </form:label>
						<form:select path="dependencia.id" cssClass="ui dropdown">
                			<form:option value="0" label="Seleccione un dependencia"/>
                			<form:options items="${moduloList}" itemValue="id" />
            			</form:select>
						<form:errors path="dependencia" />
					</div>
					
					<button class="ui primary button" type="submit">Guardar</button>
					<button class="ui button" type="reset" >Limpiar</button>
				</form:form>
			</div>
		</div>
	</div>
	
	<c:import url="modal.jsp"></c:import>
	
	<c:import url="../layouts/footer.jsp"></c:import>
	
	<script type="text/javascript">
		$('#icono').click(function() {
			$('.loger.modal')
				.modal('show');			
		});
		
		$('.approve').click(function () {
			
			$('#icono').val(($(this).children('i').attr('class')));
			
		});
	</script>

</body>
</html>