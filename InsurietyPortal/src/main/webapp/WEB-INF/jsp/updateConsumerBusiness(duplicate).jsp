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
    <title>Home</title>
    <link href="css/login.css" rel="stylesheet" type="text/css">
    <style>
        body {
        background-image: linear-gradient(to right top, #da1786, #c92b9b, #b23bad, #954abc, #7255c6, #5969d4, #397ade, #0089e3, #00a5ec, #00bfec, #3ad6e7, #7debe3);
        color:white;
    }
    a{
        color:white;
    }
    </style>
</head>
<body>
    
    <%@ include file="navbar.jsp"%>
   <div class="text-center">
                            <main class="form-signin">
                            <form:form name="menuItemForm" modelAttribute="ConsumerBusinessResponse" method="post" action="getDetails">
                                <h1 class="h3 mb-3 fw-normal">Please Enter Details</h1>
                                <div class="form-floating mb-4">
                                        <form:input path="consumerID" type="number" class="form-control" id="floatingInput" placeholder="ConsumerID" required="required" />      
                                </div>
                                <button class="w-100 btn btn-lg btn-primary " type="submit">search</button>
                            </form:form>
                            </main>
                            <main class="">
  <form:form name="menuItemForm" modelAttribute="ConsumerBusinessRequest" method="post"  action="/createConsumerBusiness">
    <%-- <img class="mb-4" src="images/login.png" alt="" width="72" height="57"> --%>
    <h1 class="h3 mb-3 fw-normal">Please Modify Details</h1>

    <div class="row p-2">
      <div class="col-md-6">

      <form:input path="consumerId" type="hidden"  class="form-control" id="floatingInput" placeholder="Enter First Name" required="required" />
      

    <div class="form-floating mt-4">
      <%-- <form:label path="firstName">Enter First Name </form:label> --%>
      <form:input path="firstName" class="form-control" id="floatingInput" placeholder="Enter First Name" required="required" />
      <form:errors path="firstName" />
    </div>
    <div class="form-floating mt-4">
      <form:input path="lastName" class="form-control" id="floatingPassword" placeholder="Enter Last Name" required="required" />
      <form:errors path="lastName" />    
    </div>
    <div class="form-floating mt-4">
      <form:input path="dob" type="date" class="form-control" id="floatingPassword" required="required" />
      <form:errors path="dob" />    
    </div>
    <div class="form-floating mt-4">
      <form:input path="businessName"  class="form-control" id="floatingPassword" placeholder="Enter business Name" required="required" />
      <form:errors path="businessName" />    
    </div>
    <div class="form-floating mt-4">
      <form:input path="panDetails" class="form-control" id="floatingPassword" placeholder="Enter pan Details" required="required" />
      <form:errors path="panDetails" />    
    
    <div class="form-floating mt-4">
      <form:input path="email"  class="form-control" id="floatingPassword" placeholder="Enter email" required="required" />
      <form:errors path="email" />    
    </div>
    <div class="form-floating mt-4">
      <form:input path="phone" class="form-control" id="floatingPassword" placeholder="Enter phone" required="required" />
      <form:errors path="phone" />    
    </div>
    <div class="form-floating mt-4">
      <form:input path="website" class="form-control" id="floatingPassword" placeholder="Enter website" required="required" />
      <form:errors path="website" />    
    </div>
    <div class="form-floating mt-4">
      <form:input path="businessOverview" class="form-control" id="floatingPassword" placeholder="Enter businessOverview" required="required" />
      <form:errors path="businessOverview" />    
    </div>
    </div>
    </div>
      <div class="col-md-6">
    <div class="form-floating mt-4 col-md-10">
      <form:input path="validity" class="form-control" id="floatingPassword" placeholder="Enter validity" required="required" />
      <form:errors path="validity" />    
    </div>
    <div class="form-floating mt-4 col-md-10">
      <form:input path="agentName" class="form-control" id="floatingPassword" placeholder="Enter agentName" required="required" />
      <form:errors path="agentName" />    
    </div>
    <div class="form-floating mt-4">
      <form:input path="agentID" type="number" class="form-control" id="floatingPassword" placeholder="Enter agentID" required="required" />
      <form:errors path="agentID" />    
    </div>
    <div class="form-floating mt-4">
      <form:input path="businessCategory" class="form-control" id="floatingPassword" placeholder="Enter business Category" required="required" />
      <form:errors path="businessCategory" />    
    </div>
    <div class="form-floating mt-4">
      <form:input path="businessType" class="form-control" id="floatingPassword" placeholder="Enter business Type" required="required" />
      <form:errors path="businessType" />    
    </div>
    <div class="form-floating mt-4">
      <form:input path="businessTurnover" type="number" class="form-control" id="floatingPassword" placeholder="Enter business Turnover" required="required" />
      <form:errors path="lastName" />    
    </div>
    <div class="form-floating mt-4">
      <form:input path="capitalInvested" type="number" class="form-control" id="floatingPassword" placeholder="Enter capital Invested" required="required" />
      <form:errors path="capitalInvested" />    
    </div>
    <div class="form-floating mt-4">
      <form:input path="totalEmployees" type="number" class="form-control" id="floatingPassword" placeholder="Enter total Employees" required="required" />
      <form:errors path="totalEmployees" />    
    </div>
    <div class="form-floating mt-4">
      <form:input path="businessAge" type="number" class="form-control" id="floatingPassword" placeholder="Enter business Age" required="required" />
      <form:errors path="businessAge" />    
    </div>
       </div>
    </div>
    


    

    <button class="w-100 btn btn-lg btn-primary mt-4" type="submit">Update Details</button>
  </form:form>
</main>


    

    </div>
    <%@ include file="footer.jsp"%>
   
</body>
</html>