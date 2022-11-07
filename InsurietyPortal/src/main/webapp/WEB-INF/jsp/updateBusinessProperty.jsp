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
<script src="js/validation.js" > </script>
<link href="css/createProperty.css" rel="stylesheet" type="text/css">
<link href="css/login.css" rel="stylesheet" type="text/css">
<title>Update Business Property</title>
<style>
</style>
</head>
<body>

	<%@ include file="navbar.jsp"%>
	<h3 class="form-signin"> Update Property</h3>
	<div class="row" style="margin: 5px 5pc;">	
	
		<div id="createProperty">
			<form:form  name="createBusinessPropertyForm" method="post"
				modelAttribute="businessPropertyRequest" action="/updateProperty" onsubmit="return validateBusinessForm()">
				<div class="row">
				<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12" style="padding: 10px;">
				<div class="form-group-name">
					<form:label clas="control-label"  path="consumerId">Consumer Id</form:label>
					<br />
					<form:input class="form-control"  type="number" placeholder="consumerid" path="consumerId" name="consumerId" id="consumerId" readOnly="readonly" />
					<form:errors path="consumerId"></form:errors>
				</div>
				</div>
				<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12" style="padding: 10px;">
				<div class="form-group-name">
					<form:label clas="control-label" path="id">Property Id</form:label>
					<br />
					<form:input class="form-control" type="number" placeholder="id" path="id" name="id" id="id" readOnly="readonly"/>
					<form:errors path="id"></form:errors>
				</div>
				</div>
				<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12" style="padding: 10px;">
				<div class="form-group-name">
					<%-- <form:label path="insuranceType">Insurance Type</form:label>
					<br />
					<form:input class="form-control" path="insuranceType" id="insuranceType"
						required="required" /> --%>
						<form:label path="insuranceType">choose Insurance Type</form:label>
        				<form:select path="insuranceType" class="form-control" name="insuranceType">
                            <form:option path="Pay Back" value="Pay Back">Pay Back</form:option>
                            <form:option path="Fire" value="Fire">Fire</form:option>
                            <form:option path="Replacement" value="Replacement">Replacement</form:option>
							<form:option path="Burglary" value="Burglary">Burglary</form:option>
                            <form:option path="All Risks" value="All Risks">All Risks</form:option>
                            <form:option path="Natural Disaster" value="Natural Disaster">Natural Disaster</form:option>
        				</form:select>
					<form:errors path="insuranceType"></form:errors>
				</div>
				</div>
				<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12" style="padding: 10px;">
				<div class="form-group-name">
					<%-- <form:label path="propertyType">Property Type</form:label>
					<br />
					<form:input class="form-control" path="propertyType" id="propertyType"
						required="required" /> --%>
						<form:label path="propertyType">choose property Type</form:label>
        				<form:select path="propertyType" class="form-control" name="propertyType">
                            <form:option path="Factory Equipment" value="Factory Equipment">Factory Equipment</form:option>
                            <form:option path="Building" value="Building">Building</form:option>
                            <form:option path="Property in Transit" value="Property in Transit">Property in Transit</form:option>
        				</form:select>
					<form:errors path="propertyType"></form:errors>
				</div>
				</div>
				<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12" style="padding: 10px;">
				<div class="form-group-name">
					<form:label path="buildingSqft">Building Sqft</form:label>
					<br />
					<form:input class="form-control" path="buildingSqft" name="buildingSqft" id="buildingSqft"
						required="required" />
					<form:errors path="buildingSqft"></form:errors>
				</div>
				</div>
				<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12" style="padding: 10px;">
				<div class="form-group-name">
					<%-- <form:label path="buildingType">Building Type</form:label>
					<br />
					<form:input class="form-control" path="buildingType" id="buildingType"
						required="required" /> --%>
						<form:label path="buildingType">choose Building Type</form:label>
        				<form:select path="buildingType" name="buildingType" class="form-control">
                            <form:option path="Owner" value="Owner">Owner</form:option>
                            <form:option path="Rented" value="Rented">Rented</form:option>
                           
        				</form:select>
					<form:errors path="buildingType"></form:errors>
				</div>
				</div>
				<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12" style="padding: 10px;">
				<div class="form-group-name">
					<form:label path="buildingStoreys">Building Storeys</form:label>
					<br />
					<form:input class="form-control" name="buildingStoreys" path="buildingStoreys" id="buildingStoreys"
						required="required" />
					<form:errors path="buildingStoreys"></form:errors>
				</div>
				</div>
				<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12" style="padding: 10px;">
				<div class="form-group-name">
					<form:label path="buildingAge">Building Age</form:label>
					<br />
					<form:input class="form-control" type="number" path="buildingAge" name="buildingAge" id="buildingAge" required="required" />
					<form:errors path="buildingAge"></form:errors>
				</div>
				</div>
				<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12" style="padding: 10px;">
				<div class="form-group-name">
					<form:label path="costOfTheAsset">Cost Of The Asset</form:label>
					<br />
					<form:input class="form-control" type="number" path="costOfTheAsset" name="costOfTheAsset" id="costOfTheAsset"
						required="required" />
					<form:errors path="costOfTheAsset"></form:errors>
				</div>
				</div>
				<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12" style="padding: 10px;">
				<div class="form-group-name">
					<form:label path="salvageValue">Salvage Value</form:label>
					<br />
					<form:input class="form-control" type="number" path="salvageValue" name="salvageValue" id="salvageValue"
						required="required" />
					<form:errors path="salvageValue"></form:errors>
				</div>
				</div>
				<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12" style="padding: 10px;">
				<div class="form-group-name">
					<form:label path="usefulLifeOfTheAsset">Useful Life Of The Asset</form:label>
					<br />
					<form:input class="form-control" type="number" path="usefulLifeOfTheAsset" name="usefulLifeOfTheAsset" id="usefulLifeOfTheAsset"
						required="required" />
					<form:errors path="usefulLifeOfTheAsset"></form:errors>
				</div>
				</div>
				
				</div>
				<br />
				<div class="row" style="float:right;">
				<div class="form-group-name">
					<input class="btn btn-primary " type="submit" value="Update" id="submit-button">
				</div>
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