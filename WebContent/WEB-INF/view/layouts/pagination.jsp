<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<c:set var='PAGEBLOCK' value="6" />
<c:set var="totalPage" value="${ ((totalCount - 1) / perPage) }" />
<fmt:formatNumber var="totalPage"  value="${totalPage + (totalPage % 1 == 0 ? 0 : 0.5)}" maxFractionDigits="0" pattern="######"/>

<c:set var="currentPage" value="${param.page}" />
<c:set var="firstPage" value="1" />
<c:set var="lastPage" value="${totalPage}" />

<fmt:formatNumber var="factorPage"  value="${( totalPage - currentPage - (PAGEBLOCK / 2) )}" maxFractionDigits="0" pattern="######"/>
<c:set var="factorPage" value="${factorPage}" />

<c:if test="${totalPage > PAGEBLOCK}">
	<c:choose>
	    <c:when test="${factorPage le 0}">
	       	<c:set var="firstPage" value="${( totalPage - PAGEBLOCK )}" />
	       	<c:set var="lastPage" value="${totalPage}" />
	    </c:when>
	    <c:when test="${factorPage ge ( totalPage - PAGEBLOCK )}">
	       	<c:set var="firstPage" value="1" />
	       	<c:set var="lastPage" value="${PAGEBLOCK}" />
	    </c:when>
		<c:otherwise>
			<c:set var="firstPage" value="${ (currentPage - (PAGEBLOCK / 2) ) }" />
			<c:set var="lastPage" value="${ (currentPage + (PAGEBLOCK / 2) - 1 ) }" />
	    </c:otherwise>
	</c:choose>
</c:if>

<div class="ui right floated pagination menu">
    <c:if test="${currentPage gt firstPage}">
    	<a class="item" href="${url}${simbol}page=${currentPage - 1}">
			<i class="left chevron icon"></i>
		</a>
    </c:if>             
    <c:forEach begin="${firstPage}" end="${lastPage}" step="1" varStatus="status">
       	<c:choose>
       		<c:when test="${currentPage eq status.index - 1}">
              	<a class="item disabled">${status.index}</a>
           	</c:when>
            <c:otherwise>
               	<a class="item" href="${url}${simbol}page=${status.index-1}">${status.index}</a>
            </c:otherwise>
        </c:choose>
	</c:forEach>
    <c:if test="${lastPage lt totalPage}">
      	<a class="item" href="${url}${simbol}page=${currentPage+1}">
			<i class="right chevron icon"></i>
		</a>
    </c:if>
</div>