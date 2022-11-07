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
    <title>View Policy</title>
    <style>
    .cfooter{
        bottom:0;
        position:absolute;
        width:100%;
      }
       @keyframes enlarge {
    0%{
        opacity: 0;
    }
    50%{
        opacity: 0;
        transform: scale(0.5,0.5)
    }
    100%{
        opacity:1;
        transform: scale(1,1);
    }
}
.home-image{
    animation: enlarge 1.5s ;
}
        
    </style>
</head>
<body>
 <%@ include file="navbar.jsp"%>
 <div class="container-fluid">
    <div class="row">
	<div
		class="col-12 col-sm-12 mt-4 col-md-8 offset-md-1 col-lg-4 offset-lg-1">
    <!-- header section starts here  -->
    <header id="viewPolicy" class="viewPolicy">
        <div class="create-policy-container">
            <div id="center-header" class="center-header">
                <h3 id="page-title">View Policy</h3>
            </div>
        </div>
    </header>
    <main id="create-policy-page-content">
        <div class= "container" style="overflow-x: auto;">
            <div class="space"></div>
            <table class="menu-table" id="menu-table">
                <%-- <caption class= "table-caption text-center">view Policy</caption> --%>
                <tbody id="menu-table-body">
			
				<form:form name="viewPolicy" modelAttribute="viewPolicy" method="post"  action="GetPolicyDetails">
                <tr class="form-group-name">
                    <td><form:label path="consumerId">Consumer ID:</form:label></td>
                    <td><form:input path="consumerId" type="number" id="consumerid" required="required"/></td>
                    <td><form:errors path="consumerId" ></form:errors></td>
                </tr>
                <tr class="form-group-name">
         
                        <td><form:label path="propertyId" type="text" class="detials-label" >Property ID:</form:label><br/></td>
                        <td><form:input path="propertyId" type="number" required="required"/></td>
                        <td><form:errors path="propertyId" ></form:errors></td>
                    </tr>
		        <%-- <tr><td><a href="GetPolicyDetails?consumerId=${viewPolicy.consumerId}&propertyId=${viewPolicy.propertyId}"><button>Get Policy</button></a></td></tr> --%>

                <tr class="form-group-name">
         
                        <td><form:label path="policeId" type="text" class="detials-label" >Policy ID:</form:label><br/></td>
                        <td><form:select name="category" path="policeId">    
                        <c:forEach  items="${policies}" var="category">        
                            <option value="${category}">${category}</option>    
                        </c:forEach>
                        </form:select>
                        </td>
                    <td><form:errors path="policeId" ></form:errors></td>
                </tr>
                <tr class="form-group-name">
         
                        <td colspan="2"><div class="text-danger">${policStatus}</div></td>
                        
                </tr>
                <tr><td><input type="submit" value="View Policy" id="submit-button" /></td></tr>
                
		
		</form:form>
                </tbody>
            </table>
    </main>
    </div>
	<div
		class="col-12 col-sm-12  col-md-8 offset-md-1 col-lg-6 offset-lg-1">
		<div class="container mt-5 shadow">
			<img src="images/laptop.png" width="50%" class="mt-2 home-image"
				style="position: relative; right: 10%;">
		</div>
	</div>
	</div>
	</div>
    <%@ include file="footer.jsp"%>
</body>


</html>