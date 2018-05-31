
<%@taglib prefix="cj" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<nav class="ui vertical inverted sticky menu fixed top">
    <div class="item">
	    <div class="header">
	         SHULPlanilla
	    </div>
    </div>
    <div class="item">
    	<a href="<cj:url value="/welcome.html" />">Inicio</a>
    </div>
    <div class="item">
    	<div class="header">Gestionar Empleados</div>
    	<div class="menu">
    		<a class="item" href="<cj:url value="/centro-depto/index.html" />">Centro de Costo</a>
    		<a class="item" href="<cj:url value="/tipo-doc-identidad/index.html" />">Tipo Doc Identidad</a>
    		<a class="item" href="<cj:url value="/estado-civil/index.html" />">Estado Civil</a>
    		<a class="item" href="<cj:url value="/genero/index.html" />">Genero</a>
    	</div>
    </div>
    <div class="item">
        <div class="header">Gestionar Planilla</div>
        <div class="menu">
          <a class="item" href="<cj:url value="/rango-renta/index.html" />">Rangos de Renta</a>
          <a class="item" href="<cj:url value="/tipo-descuento/index.html" />">Tipos de Descuento</a>
        </div>
    </div>
    <div class="item">
    	<div class="header">Administración</div>
    	<div class="menu">
    		<a class="item">Usuarios</a>
    	</div>
    </div>
    <div class="item">
    	<div class="header">Anonimus</div>
    	<div class="menu">
    		<a class="item">Editar usuario</a>
    		<a class="item" href="<cj:url value="/logout.html" />" >Cerrar Sesión</a>
    	</div>
    </div>
</nav>
