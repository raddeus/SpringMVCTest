<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="true" %>

<!DOCTYPE html>
<html>
<head>
	<title>Choose your Champions</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css"/>">
</head>
<body>
<c:set var="base">${pageContext.request.requestURL}</c:set>
<c:set var="baseURL" value="${fn:replace(base, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<div id="itemDiv" class="item-selector">TEST ITEM DIV TEST TEST TEST TEST</div>
<div style="position: relative; float: left; width: 100%; margin-left: auto; clear: left; margin-right: auto;">
<h1>Choose Champions</h1>
<spring:url value="/build.jar" var="url"/>
<a href="${url}">---Build---</a>
</div>

<div class="champion-container" id="selected-champs">
<h2>SELECTED CHAMPS</h2>
<c:forEach var="champion" items="${user.selectedChamps}" varStatus="count">
	<spring:url value="${baseURL}/${champion.name}/selected-div" var="url"/>
	<div class="load-div" href="${url}" style="display: none;">
	</div>
</c:forEach>
</div>


<div class="champion-container" id="available-champs">
<h2>AVAILABLE CHAMPS</h2>
<div>
<input type="text" id="search">
</div><br/>
<c:forEach var="champion" items="${user.availableChamps}" varStatus="count">
	<spring:url value="${baseURL}/${champion.name}/available-div" var="url"/>
	<div class="load-div" href="${url}" style="display: none;">
	</div>
</c:forEach>

</div>


<div style="position: relative; float: left; clear: left; padding-bottom: 30px;">
<spring:url value="/build.jar" var="url"/>
<a href="${url}">---Build---</a>
</div>

<script type="text/javascript" src="<c:url value="/resources/js/jquery.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.tinysort.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/sort.js"/>"></script>
</body>
</html>
