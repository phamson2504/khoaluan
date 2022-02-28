<%-- 
    Document   : person-form
    Created on : Jun 23, 2021, 9:39:44 AM
    Author     : Admin
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
    <head>
    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/resources/css/css.css"/>" rel="stylesheet" type="text/css">
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
   		<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  		<script type="text/javascript" src="<c:url value="/resources/js/date.js"/>"></script>
  		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
  		
        <title>Date</title>
     <script type="text/javascript">
     var number = "${hn}";
     $( function() {
    	    $( "#datepicker" ).datepicker({
    	    	 onSelect: function(dateText) {
    	    	        alert(document.getElementById("datepicker").value);
    	    	    }
    	    })
    	    
    	  } );
     </script>
    </head>
    <body>
     <form method="post">
      <div class="form-group"> <!-- Date input -->
        <label class="control-label" for="date">Date</label>
        <input class="form-control" id="date" name="date" placeholder="MM/DD/YYY" type="text"/>
      </div>
      <div class="form-group"> <!-- Submit button -->
        <button class="btn btn-primary " name="submit" type="submit">Submit</button>
      </div>
     </form>
   <p>Date: <input type="text" id="datepicker"></p>
		<select id="cars">
		  <option value="volvo">Volvo</option>
		  <option value="saab">Saab</option>
		  <option value="vw">VW</option>
		  <option value="audi" selected>Audi</option>
		</select>
    	<input type="hidden" value="${hn}" id="hn">
     	<ul class="nav nav-tabs" id="nava">
 
 		</ul>
 		<div class="container" id=contain>
  		</div>
 		 <button type="submit" onclick="sendFile()">Login</button>
    </body>
</html>
