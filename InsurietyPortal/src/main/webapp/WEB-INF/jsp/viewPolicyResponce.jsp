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

                            </style>
                    </head>

                    <body>

                        <%@ include file="navbar.jsp"%>
                        <div class="text-center">
                            <%-- <main class="form-signin">
                            <form:form name="menuItemForm" modelAttribute="viewPolicyResponse" method="post" action="viewConsumerBusiness">
                                <h1 class="h3 mb-3 fw-normal">Please Enter Details</h1>
                                <div class="form-floating mb-4">
                                        <form:input path="consumerID" type="number" class="form-control" id="floatingInput" placeholder="ConsumerID" required="required" />      
                                </div>
                                <button class="w-100 btn btn-lg btn-primary " type="submit">search</button>
                            </form:form>
                            </main> --%>
                            <div class="details-signin">
                                <h1 class="h3 mb-3 fw-normal">Policy Details</h1>
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
                                            <td>${PolicyDetailsResponse.consumerId}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Policy Id</th>
                                            <td>${PolicyDetailsResponse.policyId}</td>
                                        </tr>
                                        <%-- <tr>
                                            <th scope="row">Property Type</th>
                                            <td>${PolicyDetailsResponse.property_type}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Consumer Type</th>
                                            <td>${PolicyDetailsResponse.consumer_type}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Tenure</th>
                                            <td>${PolicyDetailsResponse.tenure}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Business Value</th>
                                            <td>${PolicyDetailsResponse.business_value}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Property Value</th>
                                            <td>${PolicyDetailsResponse.property_value}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Base Location</th>
                                            <td>${PolicyDetailsResponse.base_location}</td>
                                        </tr> --%>
                                        <%-- <tr>
                                            <th scope="row">Type</th>
                                            <td>${PolicyDetailsResponse.type}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Business Id</th>
                                            <td>${PolicyDetailsResponse.businessid}</td>
                                        </tr> --%>
                                        <tr>
                                            <th scope="row">Payment Details</th>
                                            <td>${PolicyDetailsResponse.paymentDetails}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Acceptance Status</th>
                                            <td>${PolicyDetailsResponse.acceptanceStatus}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Policy Status</th>
                                            <td>${PolicyDetailsResponse.policyStatus}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Effective Date</th>
                                            <td>${PolicyDetailsResponse.effectiveDate}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Covered Sum</th>
                                            <td>${PolicyDetailsResponse.coveredSum}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Duration</th>
                                            <td>${PolicyDetailsResponse.duration}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Accepted Quote</th>
                                            <td>${PolicyDetailsResponse.acceptedQuote}</td>
                                        </tr>
                                        
                                        
                                    </tbody>
                                </table>
                            </div>

                        </div>
                        <%@ include file="footer.jsp"%>

                    </body>

                    </html>