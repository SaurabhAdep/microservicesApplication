<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <%-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> --%>
    <link href="css/login.css" rel="stylesheet" type="text/css">
    <title>Quotes</title>
    <style>
        
    </style>
    <link href="css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
    
    <%@ include file="navbar.jsp"%>
    <div class="text-center">
    
<main class="form-signin">
  <form:form name="menuItemForm" modelAttribute="quote" method="post"  action="/quote">
    <h1 class="h3 mb-3 fw-normal mt-4">Views Quotes</h1>

    <div class="form-floating mt-4">
        <form:label path="businessValue">Enter business Value</form:label>
      <form:input path="businessValue" type="number" class="form-control" id="floatingInput" placeholder="business Value" required="required" />
    </div>
    <div class="form-floating mt-4">
     <form:label path="propertyValue">Enter Property Value</form:label>
      <form:input path="propertyValue" type="number" class="form-control" id="floatingPassword" placeholder="Property Value" required="required" />
    </div>
    <div class="form-floating mt-4">
     <form:label path="propertyType">choose property Type</form:label>
        <form:select path="propertyType" class="form-control">
                            <form:option path="Factory Equipment" value="Factory Equipment">Factory Equipment</form:option>
                            <form:option path="Building" value="Building">Building</form:option>
                            <form:option path="Property in Transit" value="Property in Transit">Property in Transit</form:option>
        </form:select>
    </div>

    <button class="w-100 btn btn-lg btn-primary mt-4" type="submit">submit</button>
  </form:form>
</main>
<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column mt-4">
        <main class="px-3 text-justify text-center text-danger">
            <div class="text-white">${quoteStatus}</div>
        </main>
    </div>

    
  </div>
    <%@ include file="footer.jsp"%>
   
</body>
</html>