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
<title>View Property</title>
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
	<br />
	<div class="container">
		<h2>Property Details</h2>
		<br />
		<div id="viewProperty" modelAttribute="p">
		<table class="table table-striped">
			<thead><th>Attribute</th><th>Value</th></thead>
			<tbody>
				<tr>
					<td><strong>Property ID</strong></td> <td> ${p.id}</td>
				</tr>
				<tr>
					<td><strong>Insurance Type</strong> </td><td> ${p.insuranceType}</td>
				</tr>
				<tr>
					<td><strong>Property Type</strong></td><td> ${p.propertyType}</td>
				</tr>
				<tr>
					<td><strong>Building Sqft</strong> </td><td>${p.buildingSqft}</td>
				</tr>
				<tr>
					<td><strong>Building Type</strong> </td><td>${p.buildingType}</td>
				</tr>
				<tr>
					<td><strong>Building Storeys</strong> </td><td> ${p.buildingStoreys}</td>
				</tr>
				<tr>
					<td><strong>Building Age</strong></td><td> ${p.buildingAge}</td>
				</tr>
				<tr>
					<td><strong>Property Value</strong></td><td>; ${p.propertyValue}</td>
				</tr>
				<tr>
					<td><strong>Cost Of The Asset</strong></td><td> ${p.costOfTheAsset}</td>
				</tr>
				<tr>
					<td><strong>Salvage Value</strong></td><td> ${p.salvageValue}</td>
				</tr>
				<tr>
					<td><strong>Useful Life Of The Asset</strong> </td><td> ${p.usefulLifeOfTheAsset}</td>
				</tr>
			</tbody>
			
			</table>		
		</div>
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>