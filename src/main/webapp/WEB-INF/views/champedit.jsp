<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="true" %>
<html>
<head>
	<title>Edit Champion - ${champion.displayName}</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css"/>">
</head>

<body>
<h1>Edit Champion - ${champion.displayName}</h1>

<spring:url value="/" var="url"/>
<a href="${url}">---Back---</a>
 
<table>
<tr><td colspan="6">SELECTED ITEMS</td></tr>
<tr><td>
<c:forEach var="item" items="${champion.selectedItems}">
	<div style="position: relative; float: left;" >
	<spring:url value="/${champion.name}/item/${item.name}/delete" var="url"/>
	<a href="${url}"><img src="<c:url value="/resources/icon/item/${item.name}"/>.gif" alt="<c:out value="${item.displayName}"/>"/></a>
	</div>
</c:forEach>
</td></tr>

<tr><td colspan="6">AVAILABLE ITEMS</td></tr>
<tr><td>
<c:forEach var="item" items="${champion.availableItems}" varStatus="count">
<c:if test="${count.index%6==0}"><div style="clear: left;" ></c:if>
<div style="position: relative; float: left;" >
	<spring:url value="/${champion.name}/item/${item.name}/add" var="url"/>
	<a href="${url}">
	<img src="<c:url value="/resources/icon/item/${item.name}"/>.gif" alt="<c:out value="${item.displayName}"/>"/>
	</a>
	</div>
	<c:if test="${(count.index+1)%6==0 && count.index!=1}"></div></c:if>
</c:forEach>
</td></tr>
</table>

<div id="tab-container" class="tab-container">
<ul class='item-tabs'>
	<li class='tab'><a href="#defense-tab">Defense</a></li>
	<li class='tab'><a href="#attack-tab">Attack</a></li>
	<li class='tab'><a href="#magic-tab">Magic</a></li>
	<li class='tab'><a href="#movement-tab">Movement</a></li>
	<li class='tab'><a href="#consumables-tab">Consumables</a></li>
</ul>
	<div id="defense-tab">Defense</div>
	<div id="attack-tab">Attack</div>
	<div id="magic-tab">Magic</div>
	<div id="movement-tab">Movement</div>
	<div id="consumables-tab">Consumables</div>
</div>


<br>
<spring:url value="/" var="url"/>
<a href="${url}">---Back---</a>

<script type="text/javascript" src="<c:url value="/resources/js/jquery.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.tinysort.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.easytabs.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/sort.js"/>"></script>
</body>
</html>