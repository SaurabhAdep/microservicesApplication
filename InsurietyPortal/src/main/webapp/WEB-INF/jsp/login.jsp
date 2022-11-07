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
    <title>Login</title>
    
    <link href="css/login.css" rel="stylesheet" type="text/css">


     <style>
     body {
    background-image: linear-gradient(to right top, #da1786, #c92b9b, #b23bad, #954abc, #7255c6, #9355c2, #ae56bc, #c559b5, #f86792, #ff8c74, #ffb868, #ebe37d);}
      .cfooter{
        position:absolute;
        bottom:0;
        width:100%;
      }
      @keyframes moveInLeft {
          0%{
              opacity: 0;
              transform: translateX(-20rem);
          }
          80%{
              transform: translateX(0rem);
          }
          100%{
              opacity:1;
              transform: translate(0);
          }
       }
       .uName{
         animation:moveInLeft 1s;
       }
       @keyframes moveInRight {
          0%{
              opacity: 0;
              transform: translateX(20rem);
          }
          80%{
              transform: translateX(0rem);
          }
          100%{
              opacity:1;
              transform: translate(0);
          }
       }
       .pwd{
         animation:moveInRight 1s;
       }
       @keyframes comeFromBottom {
    0%{
        opacity: 0;
        transform: translateY(20rem);
    }
    100%{
        opacity:1;
        transform: translate(0);
    }
 }
       .btn{
         animation:comeFromBottom 1s ease-in .1s;
         animation-fill-mode:backwards;
         
       }
       .btn::active{
         transform:translateY(-1rem);
          transition: all .4s;
       }
    </style>
</head>
<body>
    
    <nav class="navbar navbar-expand-lg">
        <a class="navbar-brand text-white" href="/home">Policy Administration System</a>
    </nav>
    <div class="text-center">
    
<main class="form-signin">
  <form:form name="menuItemForm" modelAttribute="loginModel" method="post"  action="login">
    <img class="mb-4" src="images/login.png" alt="" width="72" height="57">
    <h1 class="h3 mb-3 fw-normal">Please Log in</h1>

    <div class="form-floating mb-3 uName">
      <form:input path="userName" class="form-control" id="floatingInput" placeholder="Username" required="required" />
      <%-- <label for="floatingInput">Email address</label> --%>
    </div>
    <div class="form-floating">
      <form:errors path="userName" />
      <%-- <label for="floatingInput">Email address</label> --%>
    </div>
    <div class="form-floating mb-3 pwd">
      <form:input path="password" type="password" class="form-control" id="floatingPassword" placeholder="Password" required="required" />
      <%-- <label for="floatingPassword">Password</label> --%>
    </div>
   <div class="form-floating">
      <form:errors path="password" />
      <%-- <label for="floatingPassword">Password</label> --%>
    </div>
    <div class="checkbox mb-3">
        <div class="text-danger">${status}</div>
    </div>

    <button class="w-100 btn btn-lg btn-primary" type="submit">Login</button>
  </form:form>
</main>


    
  </div>
    <%@ include file="footer.jsp"%>
   
</body>
</html>