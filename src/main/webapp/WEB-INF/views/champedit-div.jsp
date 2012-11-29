<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="true" %>
<html>
<div class="close-window">Close</div>
<h1>Edit Champion - ${champion.displayName}</h1>
<div class="container-header">SELECTED ITEMS</div>
<div class="item-container" id="selected-items">
<c:forEach var="item" items="${champion.items}">
	<spring:url value="/${champion.name}/item/${item.name}/delete2" var="url"/>
	<spring:url value="/item/${item.name}/available-item-div" var="divUrl"/>
	<div class="item-icon" id="${item.name}" request-url="${url}" item-name="${item.name}" div-url="${divUrl}" selected="${item.selected}">
	<img src="<c:url value="/resources/icon/item/${item.name}"/>.gif" alt="<c:out value="${item.displayName}"/>"/>
	</div>
</c:forEach>
</div>
<div class="container-header">AVAILABLE ITEMS</div>
<div class="item-container" id="available-items">
<c:forEach var="item" items="${champion.items}" varStatus="count">
	<spring:url value="/${champion.name}/item/${item.name}/add2" var="url"/>
	<spring:url value="/item/${item.name}/selected-item-div" var="divUrl"/>
	<div class="item-icon" request-url="${url}" id="${item.name}" item-name="${item.name}" div-url="${divUrl}" selected="${item.selected}">
		<img src="<c:url value="/resources/icon/item/${item.name}"/>.gif" alt="<c:out value="${item.displayName}"/>"/>
	</div>
</c:forEach>
</div>
</html>