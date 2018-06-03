<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Empleado</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/semantic.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/application.css" />
	
	
</head>
<body>
	<c:import url="../layouts/menu.jsp"></c:import>
	<div class="container">
		<div class="ui raised very padded text container segment">
			<div class="ui large breadcrumb">
				<a class="section" href="<c:url value="/empleado/index.html" />">Atras</a>
			</div>
			<br><br>
			<div>
				<form:form method="post" modelAttribute="Empleado" cssClass="ui form">
					
					<h4 class="ui dividing header">Nuevo Empleado</h4>
					
					<form:errors path="*" element="div" cssClass="alert" />
					<div class="field">
						<form:label path="primer_nombre">Primer Nombre: </form:label>
						<form:input path="primer_nombre" />
						<form:errors path="primer_nombre" />
					</div>
					<div class="field">
						<form:label path="segundo_nombre">Segundo Nombre: </form:label>
						<form:input path="segundo_nombre" />
						<form:errors path="segundo_nombre" />
					</div>
					<div class="field">
						<form:label path="primer_apellido">Primer Apellido: </form:label>
						<form:input path="primer_apellido" />
						<form:errors path="primer_apellido" />
					</div>
					<div class="field">
						<form:label path="segundo_apellido">Segundo Apellido: </form:label>
						<form:input path="segundo_apellido" />
						<form:errors path="segundo_apellido" />
					</div>
					<div class="field">
						<form:label path="apellido_casada">Apellido Casada: </form:label>
						<form:input path="apellido_casada" />
						<form:errors path="apellido_casada" />
					</div>
					<div class="field">
						<form:label path="fecha_nacimiento">Fecha Nacimiento: </form:label>
						<form:input type="date" path="fecha_nacimiento" />
						<form:errors path="fecha_nacimiento" />
					</div>
					<div class="field">
						<form:label path="fecha_ingreso">Fecha Ingreso: </form:label>
						<form:input type="date" path="fecha_ingreso" />
						<form:errors path="fecha_ingreso" />
					</div>
					<div class="field">
						<form:label path="nit">NIT: </form:label>
						<form:input path="nit" />
						<form:errors path="nit" />
					</div>
					<div class="field">
						<form:label path="isss">ISSS: </form:label>
						<form:input path="isss" />
						<form:errors path="isss" />
					</div>
					<div class="field">
						<form:label path="nup">NUP: </form:label>
						<form:input path="nup" />
						<form:errors path="nup" />
					</div>
					<div class="field">
						<form:label path="doc_identidad">Documento Identidad: </form:label>
						<form:input path="doc_identidad" />
						<form:errors path="doc_identidad" />
					</div>
					<div class="field">
						<form:label path="email_pers">email: </form:label>
						<form:input path="email_pers" />
						<form:errors path="email_pers" />
					</div>
					<div class="field">
						<form:label path="email_inst">Email inst: </form:label>
						<form:input path="email_inst" />
						<form:errors path="email_inst" />
					</div>
					
					<div class="field">
						<form:label path="direccion.numCasa">Numero Casa</form:label>
						<form:input path="direccion.numCasa" />
						<form:errors path="direccion.numCasa" />
					</div>
					
					<div class="field">
						<form:label path="direccion.numCalle">Numero Calle</form:label>
						<form:input path="direccion.numCalle" />
						<form:errors path="direccion.numCalle" />
					</div>
					<div class="field">
						<form:label path="direccion.colonia">Colonia</form:label>
						<form:input path="direccion.colonia" />
						<form:errors path="direccion.colonia" />
					</div>
					<div class="field">
						<form:label path="direccion.avenida">Avenida</form:label>
						<form:input path="direccion.avenida" />
						<form:errors path="direccion.avenida" />
					</div>
					<div class="field">
						<form:label path="direccion.poligono">Poligono</form:label>
						<form:input path="direccion.poligono" />
						<form:errors path="direccion.poligono" />
					</div>
					<div class="field">
						<form:label path="direccion.pasaje">Pasaje</form:label>
						<form:input path="direccion.pasaje" />
						<form:errors path="direccion.pasaje" />
					</div>
					<div class="field">
						<form:label path="direccion.municipio.id">Municipio: </form:label>
						<form:select path="direccion.municipio.id">
                			<form:option value="0" label="Seleccione el Municipio"/>
                			<form:options items="${municipioList}" itemValue="id" />
            			</form:select>
						<form:errors path="direccion.municipio.id" />
					</div>
					<div class="field">
						<form:label path="estadoCivil.id">Estado Civil: </form:label>
						<form:select path="estadoCivil.id">
                			<form:option value="0" label="Seleccione el Estado Civil"/>
                			<form:options items="${estadoCivilList}" itemValue="id" />
            			</form:select>
						<form:errors path="estadoCivil.id" />
					</div>
					<div class="field">
						<form:label path="genero.id">Genero: </form:label>
						<form:select path="genero.id">
                			<form:option value="0" label="Seleccione el genero"/>
                			<form:options items="${generoList}" itemValue="id" />
            			</form:select>
						<form:errors path="genero.id" />
					</div>
					<div class="field">
						<form:label path="tipoDocIdentidad.id">Tipo Documento Identidad: </form:label>
						<form:select path="tipoDocIdentidad.id">
                			<form:option value="0" label="Seleccione el tipo de documento"/>
                			<form:options items="${tipoDocIdentidadList}" itemValue="id" />
            			</form:select>
						<form:errors path="tipoDocIdentidad.id" />
					</div>
					
					<div class="field">
						<form:label path="profesionOficio.id">Profesion o Oficio: </form:label>
						<form:select path="profesionOficio.id">
                			<form:option value="0" label="Seleccione la profesion"/>
                			<form:options items="${profesionOficioList}" itemValue="id" />
            			</form:select>
						<form:errors path="profesionOficio.id" />
					</div>
					<div class="field">
						<form:label path="jefe.id">Jefe: </form:label>
						<form:select path="jefe.id">
                			<form:option value="0" label="Seleccione el jefe"/>
                			<form:options items="${empleadoList}" itemValue="id" />
            			</form:select>
						<form:errors path="jefe" />
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

