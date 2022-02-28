<%@page import="com.fasterxml.jackson.annotation.JacksonInject.Value"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/resources/css/css.css"/>" rel="stylesheet" type="text/css">
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
         <script type="text/javascript" src="<c:url value="/resources/js/main.js"/>"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js">
        <title>Login</title>
    </head>
    <body>
      <select name="cars" id="cars">
    <option value="volvo">Volvo</option>
    <option value="saab">Saab</option>
    <option value="opel">Opel</option>
    <option value="audi">Audi</option>
  </select>
       <h1 class="ha">Login page</h1>
	<div class="container">
	<div class="row">
	 <div class="col-sm-4">
      <h3>Column 1</h3>
      <p>Lorem ipsum dolor..</p>
    </div>
	 <div class="col-sm-5">
	 <button type="submit" onclick="sendFile()">Login</button>
	<c:forEach items="${h}" var="h">
				<c:choose>
				    <c:when test="${h.viTriCot==0}">
				   	 <c:choose>
				         <c:when test = "${h.viTriHang=='A'}">
				         <div>
				            <input type="checkbox" id="scales" name="scales" value="${h.id}"><label>${ h.viTriHang}${ h.viTriCot}</label>
						    
				         </c:when>
				         
				         <c:otherwise>
				            </div>
				             <div>
						    <input type="checkbox" id="scales" name="scales" value="${h.id}"><label>${ h.viTriHang}${ h.viTriCot}</label>
						   
				         </c:otherwise>
				      </c:choose>
		
				    </c:when>    
				    <c:otherwise>
				   <input type="checkbox" id="scales" name="scales" value="${h.id}"><label>${h.viTriHang}${ h.viTriCot}</label>
				    </c:otherwise>
			</c:choose> 
	
	</c:forEach>
	
    </body>
</html>
