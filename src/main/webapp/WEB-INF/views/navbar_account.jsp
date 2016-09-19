<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="http://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <link href="http://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  
  
<!-- Loading Bootstrap -->
<link href="resources/css/custom.css" rel="stylesheet">
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<title>FairShare</title>
<script>
      function initMap() {
        var mapDiv = document.getElementById('map');
        var map = new google.maps.Map(mapDiv, {
            center: {lat: 35.2270869, lng: -80.84312669999997},
            zoom: 12,
            scrollwheel:false,
            draggable:false,
            mapTypeId:google.maps.MapTypeId.ROADMAP
        });
      }
    </script>
    <script async defer
        src="https://maps.googleapis.com/maps/api/js?key= AIzaSyAU8iweKixyCXF6dvgRjQvCGgKBRg3-OJU &callback=initMap">
    </script>

</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">
<section>
<form id="logoutForm" method="post" action="${contextPath }/logout">
	<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
</form>
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fliud">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#myPage">Logo</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
      	<li><a href="${contextPath }/dashboard">Dashboard</a>
      	</li>
      	<li class="dropdown">
          <a href="#" class="dropdown-toggle " data-toggle="dropdown" role="button" >Dropdown 
          <span class="caret"></span></a>
          <ul class="dropdown-menu dashboard-dropdown">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
        <li><a href="#about">About</a></li>
        <li><a href="#contact">Contact</a></li>
        <li><a href=<c:url value="/logout"  />>Log Out</a></li>
      </ul>
    </div>
  </div>
</nav>
</section>