<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="true" %>
<html>
<head>
	<title>Edit Champion - ${champion.displayName}</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/tabs.css"/>">
</head>

<body>
<h1>JS TEST</h1>

<div id="tab-container-main">
 <ul>
  <li class="selected-tab-main"><a href="#defense-tab" class="selected-tab-main">Defense</a></li>
  <li class=""><a href="#attack-tab" class="">Attack</a></li>
  <li class=""><a href="#magic-tab" class="">Magic</a></li>
  <li class=""><a href="#movement-tab" class="">Movement</a></li>
  <li class=""><a href="#consumables-tab" class="">Consumables</a></li>
 </ul>
 <div class="panel-container-main" style="">
  <div id="defense-tab" style="display: block;" class="displayed-main">


   <div id="tab-container-sub1">
 <ul>
  <li class="selected-tab-sub"><a href="#defense-tab" class="selected-tab-sub">Defense</a></li>
  <li class=""><a href="#attack-tab" class="">Attack</a></li>
  <li class=""><a href="#magic-tab" class="">Magic</a></li>
  <li class=""><a href="#movement-tab" class="">Movement</a></li>
  <li class=""><a href="#consumables-tab" class="">Consumables</a></li>
 </ul>
 <div class="panel-container-sub" style="">
  <div id="defense-tab" style="display: block;" class="displayed-sub">
   <h2>Defense</h2>
  </div>
  <div id="attack-tab" style="display: none;" class="">
   <h2>Attack</h2>
  </div>
    <div id="magic-tab" style="display: none;" class="">
   <h2>Magic</h2>
  </div>
    <div id="movement-tab" style="display: none;" class="">
   <h2>Movement</h2>
  </div>
    <div id="consumables-tab" style="display: none;" class="">
   <h2>Consumables</h2>
  </div>
 </div>
</div>



  </div>
  <div id="attack-tab" style="display: none;" class="">
   <h2>Attack</h2>
  </div>
    <div id="magic-tab" style="display: none;" class="">
    
    
   <div id="tab-container-sub2">
 <ul>
  <li class="selected-tab-sub"><a href="#defense-tab" class="selected-tab-sub">Defense</a></li>
  <li class=""><a href="#attack-tab" class="">Attack</a></li>
  <li class=""><a href="#magic-tab" class="">Magic</a></li>
  <li class=""><a href="#movement-tab" class="">Movement</a></li>
  <li class=""><a href="#consumables-tab" class="">Consumables</a></li>
 </ul>
 <div class="panel-container-sub" style="">
  <div id="defense-tab" style="display: block;" class="displayed-sub">
   <h2>Defense</h2>
  </div>
  <div id="attack-tab" style="display: none;" class="">
   <h2>Attack</h2>
  </div>
    <div id="magic-tab" style="display: none;" class="">
   <h2>Magic</h2>
  </div>
    <div id="movement-tab" style="display: none;" class="">
   <h2>Movement</h2>
  </div>
    <div id="consumables-tab" style="display: none;" class="">
   <h2>Consumables</h2>
  </div>
 </div>
</div>


  </div>
    <div id="movement-tab" style="display: none;" class="">
   <h2>Movement</h2>
  </div>
    <div id="consumables-tab" style="display: none;" class="">
   <h2>Consumables</h2>
  </div>
 </div>
</div>

<script type="text/javascript" src="<c:url value="/resources/js/jquery.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.easytabs.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/tabs.js"/>"></script>
</body>
</html>