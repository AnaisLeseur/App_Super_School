<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%-- taglibs core des jsp --%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
 
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- style CSS  -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles/bootstrap.min.css">
	
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles/Liste.css" >
	
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles/perso.css">
	
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles/Header.css">

</head>
<body>

<!-- Header -->

<div class="containerTop">
        <img id="imageTopBrand" src="${pageContext.request.contextPath}/assets/images/LogoCerveau.jpg">
        <h1 id="TitreApp">SuperSchool</h1>

        <a href=""><img id="drapeauFrance" src="${pageContext.request.contextPath}/assets/images/FlagFrance.png" ></a>
        <a href=""><img id="drapeauUK" src="${pageContext.request.contextPath}/assets/images/FlagUK.png" ></a>
        
    </div>


    <div id="separation">
        <img id="userLogo" src="${pageContext.request.contextPath}/assets/images/User.png" >
        <p id="userInfos">Bienvenue sur notre site </p>
    </div>
    
      <nav class="navbar navbar-expand-lg navbar-light bg-light">


        <div class="container d-flex flex-column flex-md-row justify-content-between">
                <a class="nav-link " style="float: left" href="${pageContext.request.contextPath}/login.jsp" >
                    Se connecter
                </a>
        </div>
    </nav>
	
		<!--  AFFICHAGE d'un MSG de déconnexion  -->
	<!--  =================================  -->
	<c:if test="${not empty param.logout_message}">
		<font style="color: green; font-style: italic;">
			Vous êtes déconnecté !!!
		</font>
	</c:if>
	
	
	
<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel" 
		style="margin-left:100px; margin-top:50px; margin-right:0px;">
  <ol class="carousel-indicators" >
    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
  </ol>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="${pageContext.request.contextPath}/assets/images/etablissement.jpg" class="d-block w-100" alt="...">
      <div class="carousel-caption">
      <h5>Une école</h5>
   	  </div>
    </div>	
    <div class="carousel-item">
      <img src="${pageContext.request.contextPath}/assets/images/chapeau.jpg" class="d-block w-100" alt="...">
    <div class="carousel-caption">
      <h5>Un diplôme</h5>
   	</div>
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>

<br/>

	<a href="${pageContext.request.contextPath}/matiere/liste">To Matiere</a>
	<br />
	<br />

	<a href="${pageContext.request.contextPath}/etudiant/liste">To
		Etudiant</a>

	<br />
	<br />
	<a href="${pageContext.request.contextPath}/aide/liste">To
		Aide</a>

	<br />
	<br />
	<a href="${pageContext.request.contextPath}/adresse/liste">To
		Adresse</a>

	<br />
	<br />

	<a href="${pageContext.request.contextPath}/administrateurs/liste">Administateur</a>

	<br />
	<br />

	<a href="${pageContext.request.contextPath}/cours/liste">To Cours</a>

	<br />
	<br />

	<a href="${pageContext.request.contextPath}/enseignants/liste">Enseignants</a>
	
	<br/>
	<br/>
	<a href="${pageContext.request.contextPath}/promotion/liste">Promotion</a>
	
	<br/>
	<br/>
	<a href="${pageContext.request.contextPath}/indexAide.jsp">Aide</a>
	


<script
		src="${pageContext.request.contextPath}/assets/js/jquery-3.4.1.min.js" type="text/javascript"></script>
<script
		src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js" type="text/javascript"></script>
<script
		src="${pageContext.request.contextPath}/assets/js/util.js" type="text/javascript"></script>


</body>
</html>