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
    <title>Home</title>
    <style>
        body {
        background-image: linear-gradient(to right top, #da1786, #c92b9b, #b23bad, #954abc, #7255c6, #5969d4, #397ade, #0089e3, #00a5ec, #00bfec, #3ad6e7, #7debe3);
        color:white;
    }
    a{
        color:white;
    }
     .navbar-toggler { 
         border: 4px solid white;
         border-radius: 0.5rem;
    } 
    /* .cfooter{
        bottom:0;
        position:absolute;
        width:100%;
      } */
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
    animation: enlarge 1.7s;
}
    </style>
</head>
<body>
    
    <%@ include file="navbar.jsp"%>
    <div class="container-fluid h-100">
    <div class="row">
        <div class="col-12 col-sm-12 mt-4 col-md-10 offset-md-1 col-lg-4 offset-lg-1">
                <h2 class="form__title text-uppercase">Policy Administration</h2>
                <p class="form__subtitle text-justify mt-4">We offers Business insurance that protects businesses from losses due to events that may occur during the normal course of business. There are many types of insurance it provides for businesses including coverage for property damage, legal liability and employee-related risks.</p>
                <a href="viewConsumerBusiness" ><button class="form__button">Explore</button></a>
        </div>
        <div class="col-12 col-sm-12  col-md-10 offset-md-1 col-lg-6 offset-lg-1">
            <div class="container mt-5 shadow">
                <img src="images/laptop.png" width="100%" class="mt-5 home-image" style="position: relative;right: 10%;">
            </div>
        </div>
    </div>
</div>
    <%@ include file="footer.jsp"%>
   
</body>
</html>