<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<div class="ui inverted tiny menu">
  <div class="right menu">
    <div class="ui dropdown item">
      <c:out value="${requestScope.Usuario.getUsername()}" /> <i class="dropdown icon"></i>
      <div class="menu">
        <a class="item" href="<c:url value="/usuario/edit-pass-user.html" />" ><i class="key icon"></i> Cambiar contraseña</a>
        <a class="item" href="<c:url value="/logout.html" />" ><i class="sign out alternate icon"></i> Cerrar Sesión</a>
      </div>
    </div>
    <div class="active blue item" id="date">
    </div>
  </div>
</div>

<nav class="ui vertical inverted sticky accordion menu fixed top">
    <div class="item">
	    <div class="header">
	         SHULPlanilla
	    </div>
    </div>
    <div class="item">
    	<a href="<c:url value="/welcome.html" />">Inicio</a>
    </div>
    
    <c:forEach items="${requestScope.modulos}" var="modulo" >
    	<div class="item">
	    	<div class="title">
	    		<c:out value="${modulo.getNombre()}"></c:out>
		    	<i class="dropdown icon"></i>
	    	</div>
	    	
	    	<div class="content">
	    		<c:forEach items="${modulo.getModulos()}" var="modu" >
	    		
	    			<a class="item" href="<c:url value="/${modu.getUrl()}" />">
	    				${modu.getNombre()}
	    			</a>
	    		
	    		</c:forEach>
	    	</div>
    	
    	</div>
    </c:forEach>
    
</nav>