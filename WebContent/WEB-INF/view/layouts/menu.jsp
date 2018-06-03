
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<div class="ui inverted tiny menu">
  <div class="right menu">
    <div class="ui dropdown item">
      <c:out value="${requestScope.usuario.getUsername()}" /> <i class="dropdown icon"></i>
      <div class="menu">
        <!-- a class="item">Editar usuario</a -->
        <a class="item" href="<c:url value="/usuario/edit-pass-user.html" />" ><i class="key icon"></i> Cambiar contraseña</a>
        <a class="item" href="<c:url value="/logout.html" />" ><i class="sign out alternate icon"></i> Cerrar Sesión</a>
      </div>
    </div>
    <div class="active blue item" id="date">
    </div>
  </div>
</div>

<nav class="ui vertical inverted sticky menu fixed top">
    <div class="item">
	    <div class="header">
	         SHULPlanilla
	    </div>
    </div>
    <div class="item">
    	<a href="<c:url value="/welcome.html" />">Inicio</a>
    </div>
    <div class="item">
    	<div class="header">Gestionar Empleados</div>
    	<div class="menu">
    		<a class="item" href="<c:url value="/centro-depto/index.html" />">Centro de Costo</a>
    		<a class="item" href="<c:url value="/estructura-org/index.html" />">Estructura Organizativa</a>
    		<a class="item" href="<c:url value="/genero/index.html" />">Genero</a>
    		<a class="item" href="<c:url value="/tipo-doc-identidad/index.html" />">Tipo Doc Identidad</a>
    		<a class="item" href="<c:url value="/estado-civil/index.html" />">Estado Civil</a>
    		
    	</div>
    </div>
    <div class="item">
        <div class="header">Gestionar Planilla</div>
        <div class="menu">
          <a class="item" href="<c:url value="/rango-renta/index.html" />">Rangos de Renta</a>
          <a class="item" href="<c:url value="/tipo-descuento/index.html" />">Tipos de Descuento</a>
        </div>
    </div>
    <div class="item">
    	<div class="header">Administración</div>
    	<div class="menu">
    		<a class="item">Usuarios</a>
    	</div>
    </div>
</nav>
