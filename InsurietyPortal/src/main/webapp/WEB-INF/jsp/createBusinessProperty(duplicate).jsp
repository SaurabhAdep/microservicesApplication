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
<link href="css/login.css" rel="stylesheet" type="text/css">
<title>Creeate Business Property</title>
<style>
</style>
</head>
<body>

	<%@ include file="navbar.jsp"%>
	
	<div class="form-signin">
		<h1> Create Property</h1>
		<div id="createProperty">
			<form:form class="form-center" name="createBusinessPropertyForm" method="post"
				modelAttribute="businessPropertyRequest" action="/createProperty">
				<form:hidden path="id"/>
				<div class="form-group-name mywidth">
					<form:input class="form-control" type="number" placeholder="Enter Consumer Id" path="consumerId" id="consumerId" required="required" />
					<form:errors path="consumerId"></form:errors>
				</div>
				<br/>
				<div class="form-group-name mywidth">
					<%-- <form:input class="form-control" path="insuranceType" placeholder="Enter Insurance Type" id="insuranceType"
						required="required" /> --%>
						<form:label path="insuranceType">choose Insurance Type</form:label>
        				<form:select path="insuranceType" class="form-control">
                            <form:option path="Pay Back" value="Pay Back">Pay Back</form:option>
                            <form:option path="Fire" value="Fire">Fire</form:option>
                            <form:option path="Replacement" value="Replacement">Replacement</form:option>
							<form:option path="Burglary" value="Burglary">Burglary</form:option>
                            <form:option path="All Risks" value="All Risks">Fire</form:option>
                            <form:option path="Natural Disaster" value="Natural Disaster">Natural Disaster</form:option>
        				</form:select>
					<form:errors path="insuranceType"></form:errors>
				</div>
				<br/>
				<div class="form-group-name mywidth">
					<%-- <form:input class="form-control" path="propertyType" placeholder="Enter Property Type" id="propertyType"
						required="required" /> --%>

					<form:label path="propertyType">choose property Type</form:label>
        				<form:select path="propertyType" class="form-control">
                            <form:option path="Factory Equipment" value="Factory Equipment">Factory Equipment</form:option>
                            <form:option path="Building" value="Building">Building</form:option>
                            <form:option path="Property in Transit" value="Property in Transit">Property in Transit</form:option>
        				</form:select>
					<form:errors path="propertyType"></form:errors>
				</div>
				<br/>
				<div class="form-group-name">
					<form:input class="form-control" path="buildingSqft" placeholder="Enter Building Sqft" id="buildingSqft"
						required="required" />
					<form:errors path="buildingSqft"></form:errors>
				</div>
				<br/>
				<div class="form-group-name">
					<%-- <form:input class="form-control" path="buildingType" placeholder="Enter Building Type" id="buildingType"
						required="required" /> --%>
						<form:label path="buildingType">choose Building Type</form:label>
        				<form:select path="buildingType" class="form-control">
                            <form:option path="Owner" value="Owner">Owner</form:option>
                            <form:option path="Rented" value="Rented">Building</form:option>
                           
        				</form:select>
					<form:errors path="buildingType"></form:errors>
				</div>
				<br/>
				<div class="form-group-name">
					<form:input class="form-control" path="buildingStoreys" placeholder="Enter Building Storeys" id="buildingStoreys"
						required="required" />
					<form:errors path="buildingStoreys"></form:errors>
				</div>
				<br/>
				<div class="form-group-name">
					<form:input class="form-control" type="number" path="buildingAge" placeholder="Enter Building Age" id="buildingAge" required="required" />
					<form:errors path="buildingAge"></form:errors>
				</div>
				<br/>
				<div class="form-group-name">
					<form:input class="form-control" type="number" path="costOfTheAsset" placeholder="Enter Cost Of The Asset" id="costOfTheAsset"
						required="required" />
					<form:errors path="costOfTheAsset"></form:errors>
				</div>
				<br/>
				<div class="form-group-name">
					<form:input class="form-control" type="number" path="salvageValue" placeholder="Enter Salvage Value" id="salvageValue"
						required="required" />
					<form:errors path="salvageValue"></form:errors>
				</div>
				<br/>
				<div class="form-group-name">
					<form:input class="form-control" type="number" path="usefulLifeOfTheAsset" placeholder="Enter Useful Life Of The Asset" id="usefulLifeOfTheAsset"
						required="required" />
					<form:errors path="usefulLifeOfTheAsset"></form:errors>
				</div>
				<br>
				<div class="form-group-name">
					<input class="btn btn-primary" type="submit" value="Create"  id="submit-button">
				</div>
				<!-- <form:button value="submit" id="submit-button" >submit</form:button> -->
			</form:form>
		</div>
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