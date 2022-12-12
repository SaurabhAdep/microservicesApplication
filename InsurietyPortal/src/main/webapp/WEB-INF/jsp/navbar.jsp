<nav class="navbar navbar-expand-lg navbar-white" >
  <a class="navbar-brand font-weight-bold" href="/home">Policy Administration System</a>
  <button class="navbar-toggler text-white navbar-dark font-weight-bold" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link font-weight-bold" href="/home">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle font-weight-bold" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Consumer Bussiness
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="/createConsumerBusiness">Create Bussiness</a>
          <a class="dropdown-item" href="/viewConsumerBusiness">View Bussiness</a>
          <a class="dropdown-item" href="/updateConsumerBusiness">Update Bussiness</a>
        </div>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle font-weight-bold" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Bussiness Property
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="/createBusinessProperty">Create Property</a>
          <a class="dropdown-item" href="/viewBusinessProperty">View Property</a>
          
        </div>
      </li>
       <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle font-weight-bold" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Quote
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="/quote">View Quotes</a>
        </div>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle font-weight-bold" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Policy
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <%-- <a class="dropdown-item" href="/createPolicy">Create Policy</a> --%>
          <a class="dropdown-item" href="/createPolicy">create Policy</a>
          <a class="dropdown-item" href="/issuePolicy">Issue Policy</a>
           <a class="dropdown-item" href="/viewExistingPolicy">view Policy status</a>
        </div>
      </li>
      <%-- <li>
      <% if(${user} == null){%>
        <a class="nav-link" href="/logout">LogOut</a>
      <% } else { %>
        <a class="nav-link" href="/logout">Login</a>
      <% } %>
      </li> --%>
      <li class="nav-item">
          <a class="nav-link font-weight-bold" href="/logout">LogOut</a> 
      </li>
       <%-- <li class="nav-item">
        <a class="nav-link" href="/login">Login</a>
      </li> --%>
       <%-- <li class="nav-item">
        <c:if test="${login }">
                <a class="nav-link" href="/logout">LogOut</a>
      </c:if> 
      </li> --%>
      <%--</li>
      <li class="nav-item">
        <a class="nav-link" href="#">Pricing</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#">Disabled</a>
      </li> --%>
      <%-- <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Dropdown link
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Another action</a>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
      </li> --%>
    </ul>
  </div>
</nav>