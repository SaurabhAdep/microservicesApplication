<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
<%-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> --%>
<link href="css/createProperty.css" rel="stylesheet" type="text/css">
<title>Update Business Property</title>
<link href="css/login.css" rel="stylesheet" type="text/css">
<style>
        body {
        background-image: linear-gradient(to right top, #da1786, #c92b9b, #b23bad, #954abc, #7255c6, #5969d4, #397ade, #0089e3, #00a5ec, #00bfec, #3ad6e7, #7debe3);
		color: white;
	}
    </style>
</head>
<body>

	<%@ include file="navbar.jsp"%>
	<div class="form-signin">
		<h2>Enter Details </h2>
		<div id="createProperty" class="mt-4">
			<form:form class="form-center" name="createBusinessPropertyForm" method="post"
				modelAttribute="viewPropertyRequest" action="/viewPropertyAll">
				<div class="form-group-name">
					<form:label clas="control-label" type="number" path="consumerId">Enter Consumer Id</form:label>
					<br />
					<form:input class="form-control"  placeholder="consumerid" path="consumerId" name="consumerId" id="consumerId" required="required" />
					<form:errors path="consumerId"></form:errors>
				</div>
				<%-- <div class="form-group-name">
					<form:label clas="control-label" path="propertyId">Property Id</form:label>
					<br />
					<form:input class="form-control" size="25" placeholder="propertyId" name="propertyId" path="propertyId" id="propertyId" required="required" />
					<form:errors path="propertyId"></form:errors>
				</div> --%>
				<br>
				<div class="form-group-name">
					<input class="btn btn-primary " type="submit" value="View Property" id="submit-button">
				</div>
				<!-- <form:button value="submit" id="submit-button" >submit</form:button> -->
			</form:form>
		</div>
		<br>
	</div>
	<div class="text-center">
                                <h1 class="h3 mb-3 fw-normal">Property Details</h1>
                                <table class="table table-striped table-responsive">
                                    <thead>
                                        <tr>
                                            <th scope="col">id</th>
                                            <th scope="col">insuranceType</th>
											<th scope="col">propertyType</th>
                                            <th scope="col">buildingSqft</th>
											<th scope="col">buildingType</th>
                                            <th scope="col">buildingStoreys</th>
											<th scope="col">buildingAge</th>
                                            <th scope="col">propertyValue</th>
											<th scope="col">costOfTheAsset</th>
                                            <th scope="col">salvageValue</th>
											<th scope="col">usefulLifeOfTheAsset</th>
                                            <th scope="col">Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${property}" var="property">
                                                <tr>
                                                    <td>${property.id}</td>
                                                    <td>${property.insuranceType}</td>
                                                    <td>${property.propertyType}</td>
                                                    <td>${property.buildingSqft}</td>
                                                    <td>${property.buildingType}</td>
													<td>${property.buildingStoreys}</td>
                                                    <td>${property.buildingAge}</td>
                                                    <td>${property.propertyValue}</td>
                                                    <td>${property.costOfTheAsset}</td>
													<td>${property.salvageValue}</td>
                                                    <td>${property.usefulLifeOfTheAsset}</td>
                                                    <td><a href="updateBusinessProperty?consumerId=${consumerId}&propertyId=${property.id}"> Update </a></td>
                                                </tr>
                                            </c:forEach>
									</tbody>
								</table>
	</div>

	<%-- <div class="details-category">
		<form:label path="category" class="detials-label-name">Category</form:label>
		<br />
		<form:select path="category" id="field-category">
			<form:option path="Main Course" value="Main Course">Main Course</form:option>
			<form:option path="Starters" value="Starters">Starters</form:option>
			<form:option path="Dessert" value="Dessert">Dessert</form:option>
			<form:option path="Drinks" value="Drinks">Drinks</form:option>
		</form:select>
	</div> --%>
	<%@ include file="footer.jsp"%>

</body>
</html>