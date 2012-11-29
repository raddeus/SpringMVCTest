<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="true" %>

<html>
<c:set var="base">${pageContext.request.requestURL}</c:set>
<c:set var="baseURL" value="${fn:replace(base, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<spring:url value="${baseURL}/${champion.name}/delete2" var="urlAdd"/>
<spring:url value="${baseURL}/${champion.name}/available-div" var="urlDiv"/>
<spring:url value="${baseURL}/resources/icon/champion/${champion.name}.png" var="urlImg"/>
<spring:url value="${baseURL}/${champion.name}/item2" var="urlItemDiv"/>
<div class="champion-icon" champ-name="${champion.name}" url="${urlAdd}" div-url="${urlDiv}" item-div-url="${urlItemDiv}">
	<img src="<c:url value="/resources/icon/champion/${champion.name}"/>.png" class="show-items"/>
	<div class="delete-champ">Delete</div>
</div>
</html>
