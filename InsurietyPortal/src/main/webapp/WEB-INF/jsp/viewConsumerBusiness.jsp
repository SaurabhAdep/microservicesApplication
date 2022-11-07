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
                            <form:form name="menuItemForm" modelAttribute="ConsumerBusinessResponse" method="post" action="viewConsumerBusiness">
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
                                            <th scope="row">first Name</th>
                                            <td>${consumerDetails.firstName}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">last Name</th>
                                            <td>${consumerDetails.lastName}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">dob</th>
                                            <td>${consumerDetails.dob}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">business Name</th>
                                            <td>${consumerDetails.businessName}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">pan Details</th>
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
                                            <th scope="row">agent Name</th>
                                            <td>${consumerDetails.agentName}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">agent ID</th>
                                            <td>${consumerDetails.agentID}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">business ID</th>
                                            <td>${consumerDetails.businessID}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">business Category</th>
                                            <td>${consumerDetails.businessCategory}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">business Overview</th>
                                            <td>${consumerDetails.businessOverview}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">business Type</th>
                                            <td>${consumerDetails.businessType}</td>
                                        </tr>
                                         <tr>
                                            <th scope="row">business Turnover</th>
                                            <td>${consumerDetails.businessTurnover}</td>
                                        </tr>
                                         <tr>
                                            <th scope="row">capital Invested</th>
                                            <td>${consumerDetails.capitalInvested}</td>
                                        </tr>
                                         <tr>
                                            <th scope="row">total Employees</th>
                                            <td>${consumerDetails.totalEmployees}</td>
                                        </tr>
                                         <tr>
                                            <th scope="row">business Value</th>
                                            <td>${consumerDetails.businessValue}</td>
                                        </tr>
                                         <tr>
                                            <th scope="row">business Age</th>
                                            <td>${consumerDetails.businessAge}</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>

                        </div>
                        <%@ include file="footer.jsp"%>

                    </body>

                    </html>