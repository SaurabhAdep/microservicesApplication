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
                            <title>View Consumer Business</title>
                            <script src="js/validation.js" > </script>
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
  
    
<main class="row" style="margin: 5px 5pc;">
  <form:form name="consumerBusiness" modelAttribute="ConsumerBusinessRequest" method="post"  action="/createConsumerBusiness" onsubmit="return validateForm()">
    <%-- <img class="mb-4" src="images/login.png" alt="" width="72" height="57"> --%>
    <h1 class="h3 mb-3 fw-normal form-signin">Please Enter Details</h1>
      <form:input path="consumerId" type="hidden" value="100" class="form-control" id="floatingInput" placeholder="Enter First Name" required="required" />
      
    <div class="row">
    <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12" style="padding: 10px;">
    <div class="form-floating mt-4">
     <form:label path="firstName" class="font-weight-bold">Enter First Name : </form:label>
      <form:input path="firstName" name="firstName" size="30" class="form-control" id="floatingInput" placeholder="Enter First Name" required="required" />
      <form:errors path="firstName" id="firstNameError"/>
    </div>
    </div>
    <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12" style="padding: 10px;">
    <div class="form-floating mt-4">
     <form:label path="lastName" class="font-weight-bold">Enter Last Name : </form:label>
      <form:input path="lastName" name="lastName" class="form-control" id="floatingPassword" placeholder="Enter Last Name" required="required" />
      <form:errors path="lastName" />    
    </div>
    </div>
    <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12" style="padding: 10px;">
    <div class="form-floating mt-4">
    <form:label path="dob" class="font-weight-bold">Enter Date of Birth : </form:label>
      <form:input path="dob" name="dob" type="date" class="form-control" id="floatingPassword" required="required" />
      <form:errors path="dob" />    
    </div>
    </div>
    <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12" style="padding: 10px;">
    <div class="form-floating mt-4">
    <form:label path="businessName" class="font-weight-bold">Enter BusinessName : </form:label>
      <form:input path="businessName" name="businessName"  class="form-control" id="floatingPassword" placeholder="Enter business Name" required="required" />
      <form:errors path="businessName" />    
    </div>
    </div>
    <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12" style="padding: 10px;">
    <div class="form-floating mt-4">
     <form:label path="panDetails" class="font-weight-bold">Enter Pan Details : </form:label>
      <form:input path="panDetails" name="panDetails" class="form-control" id="floatingPassword" placeholder="Enter pan Details" required="required" />
      <form:errors path="panDetails" />    
    </div>
    </div>
    <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12" style="padding: 10px;">
    <div class="form-floating mt-4">
    <form:label path="email" class="font-weight-bold">Enter email : </form:label>
      <form:input path="email" name="email"  class="form-control" id="floatingPassword" placeholder="Enter email" required="required" />
      <form:errors path="email" />    
    </div>
    </div>
    <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12" style="padding: 10px;">
    <div class="form-floating mt-4">
    <form:label path="phone" class="font-weight-bold">Enter Phone : </form:label>
      <form:input path="phone" name="phone" class="form-control" id="floatingPassword" placeholder="Enter phone" required="required" />
      <form:errors path="phone" />    
    </div>
    </div>
    <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12" style="padding: 10px;">
    <div class="form-floating mt-4">
    <form:label path="website" class="font-weight-bold">Enter Website : </form:label>
      <form:input path="website" name="website" class="form-control" id="floatingPassword" placeholder="Enter website" required="required" />
      <form:errors path="website" />    
    </div>
    </div>
    <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12" style="padding: 10px;">
    <div class="form-floating mt-4">
    <form:label path="businessOverview" class="font-weight-bold">Enter BusinessOverview : </form:label>
      <form:input path="businessOverview" name="businessOverview" class="form-control" id="floatingPassword" placeholder="Enter businessOverview" required="required" />
      <form:errors path="businessOverview" />    
    </div>
    </div>
    <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12" style="padding: 10px;">
    <div class="form-floating mt-4">
    <form:label path="validity" class="font-weight-bold">Enter Validity : </form:label>
      <form:input path="validity" name="validity" class="form-control" id="floatingPassword" placeholder="Enter validity" required="required" />
      <form:errors path="validity" />    
    </div>
    </div>
    <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12" style="padding: 10px;">
    <div class="form-floating mt-4">
    <form:label path="agentName" class="font-weight-bold">Enter Agent Name : </form:label>
      <form:input path="agentName" name="agentName" class="form-control" id="floatingPassword" placeholder="Enter agentName" required="required" />
      <form:errors path="agentName" />    
    </div>
    </div>
    <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12" style="padding: 10px;">
    <div class="form-floating mt-4">
    <form:label path="agentID" class="font-weight-bold">Enter AgentID : </form:label>
      <form:input path="agentID" name="agentID" type="number" class="form-control" id="floatingPassword" placeholder="Enter agentID" required="required" />
      <form:errors path="agentID" />    
    </div>
    </div>
    <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12" style="padding: 10px;">
    <div class="form-floating mt-4">
    <form:label path="businessCategory" class="font-weight-bold">Enter Business Category : </form:label>
      <form:input path="businessCategory" name="businessCategory" class="form-control" id="floatingPassword" placeholder="Enter business Category" required="required" />
      <form:errors path="businessCategory" />    
    </div>
    </div>
    <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12" style="padding: 10px;">
    <div class="form-floating mt-4">
    <form:label path="businessType" class="font-weight-bold">Enter Business Type : </form:label>
      <form:input path="businessType" name="businessType" class="form-control" id="floatingPassword" placeholder="Enter business Type e.g., Rented, Owner" required="required" />
      <form:errors path="businessType" />    
    </div>
    </div>
    <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12" style="padding: 10px;">
    <div class="form-floating mt-4">
    <form:label path="businessTurnover" class="font-weight-bold">Enter Business Turnover : </form:label>
      <form:input path="businessTurnover" name="businessTurnover" type="number" class="form-control" id="floatingPassword" placeholder="Enter business Turnover" required="required" />
      <form:errors path="lastName" />    
    </div>
    </div>
    <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12" style="padding: 10px;">
    <div class="form-floating mt-4">
    <form:label path="capitalInvested" class="font-weight-bold">Enter Capital Invested : </form:label>
      <form:input path="capitalInvested" name="capitalInvested" type="number" class="form-control" id="floatingPassword" placeholder="Enter capital Invested" required="required" />
      <form:errors path="capitalInvested" />    
    </div>
    </div>
    <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12" style="padding: 10px;">
    <div class="form-floating mt-4">
    <form:label path="totalEmployees" class="font-weight-bold">Enter Total Employees : </form:label>
      <form:input path="totalEmployees" name="totalEmployees" type="number" class="form-control" id="floatingPassword" placeholder="Enter total Employees" required="required" />
      <form:errors path="totalEmployees" />    
    </div>
    </div>
    <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12" style="padding: 10px;">
    <div class="form-floating mt-4">
    <form:label path="businessAge" class="font-weight-bold">Enter Business Age : </form:label>
      <form:input path="businessAge" name="businessAge" type="number" class="form-control" id="floatingPassword" placeholder="Enter business Age" required="required" />
      <form:errors path="businessAge" />    
    </div>
    </div>
       
    
    </div>


    
  <div class="row" style="float:right">
    <button class=" btn btn-lg btn-primary mt-4" type="submit">Submit Details</button>
  </div>
  </form:form>
</main>


    
  </div>

                        <%-- <div class="text-center">
                            <main class="form-signin">
                            <form:form name="menuItemForm" modelAttribute="Consumer" method="post" action="viewConsumerBusiness">
                                <h1 class="h3 mb-3 fw-normal">Please Enter Details</h1>
                                <div class="form-floating mb-4">
                                        <form:input path="consumerID" type="number" class="form-control" id="floatingInput" placeholder="ConsumerID" required="required" />      
                                </div>
                                <button class="w-100 btn btn-lg btn-primary " type="submit">search</button>
                            </form:form>
                            </main>
                            <div class="details-signin">
                                <h1 class="h3 mb-3 fw-normal">Consumer Details</h1>
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th scope="col">Title</th>
                                            <th scope="col">Detail</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th scope="row">Consumer Id</th>
                                            <td>${consumerDetails.consumerID}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">firstName</th>
                                            <td>${consumerDetails.firstName}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">lastName</th>
                                            <td>${consumerDetails.lastName}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">dob</th>
                                            <td>${consumerDetails.dob}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">businessName</th>
                                            <td>${consumerDetails.businessName}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">panDetails</th>
                                            <td>${consumerDetails.panDetails}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">email</th>
                                            <td>${consumerDetails.email}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">phone</th>
                                            <td>${consumerDetails.phone}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">website</th>
                                            <td>${consumerDetails.website}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">validity</th>
                                            <td>${consumerDetails.validity}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">agentName</th>
                                            <td>${consumerDetails.agentName}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">agentID</th>
                                            <td>${consumerDetails.agentID}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">businessID</th>
                                            <td>${consumerDetails.businessID}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">businessCategory</th>
                                            <td>${consumerDetails.businessCategory}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">businessOverview</th>
                                            <td>${consumerDetails.businessOverview}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">businessType</th>
                                            <td>${consumerDetails.businessType}</td>
                                        </tr>
                                         <tr>
                                            <th scope="row">capitalInvested</th>
                                            <td>${consumerDetails.businessTurnover}</td>
                                        </tr>
                                         <tr>
                                            <th scope="row">capitalInvested</th>
                                            <td>${consumerDetails.capitalInvested}</td>
                                        </tr>
                                         <tr>
                                            <th scope="row">totalEmployees</th>
                                            <td>${consumerDetails.totalEmployees}</td>
                                        </tr>
                                         <tr>
                                            <th scope="row">businessValue</th>
                                            <td>${consumerDetails.businessValue}</td>
                                        </tr>
                                         <tr>
                                            <th scope="row">businessAge</th>
                                            <td>${consumerDetails.businessAge}</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>

                        </div>--%>
                        <%@ include file="footer.jsp"%> 

                    </body>

                    </html>