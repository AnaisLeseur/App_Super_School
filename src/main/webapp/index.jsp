<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- taglibs core des jsp --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>

<!--  ajout de la taglib de spring mvc 'form' -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Document</title>

<!-- style CSS  -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles/bootstrap.min.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles/Liste.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles/perso.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles/Header.css">

</head>
<body>

<!-- Header -->

<c:choose>
<c:when test="${param.lang == 'fr'}">
	<fmt:setBundle basename="messages_fr"/>
</c:when>
<c:when test="${param.lang == 'en'}">
	<fmt:setBundle basename="messages_en"/>
</c:when>
<c:otherwise>
	<fmt:setBundle basename="messages"/>
</c:otherwise>
</c:choose>

<div class="containerTop">
        <img id="imageTopBrand" src="${pageContext.request.contextPath}/assets/images/LogoCerveau.jpg">
        <h1 id="TitreApp">SuperSchool</h1>
        <h2> </h2>

        <a href="?lang=fr"><img id="drapeauFrance" src="${pageContext.request.contextPath}/assets/images/FlagFrance.png" ></a>
        <a href="?lang=en"><img id="drapeauUK" src="${pageContext.request.contextPath}/assets/images/FlagUK.png" ></a>
        
    </div>


    <div id="separation">
        <img id="userLogo" src="${pageContext.request.contextPath}/assets/images/User.png" >
        <p id="userInfos" style="color: black;">
        <fmt:message key="accueil"/>
        </p>
    </div>
    
      <nav class="navbar navbar-expand-lg navbar-light bg-light">


        <div class="container d-flex flex-column flex-md-row justify-content-between">
                <a class="nav-link " style="float: left" href="${pageContext.request.contextPath}/login.jsp" >
                    <fmt:message key="Seconnecter"/>
                </a>
        </div>
    </nav>
	
		<!--  AFFICHAGE d'un MSG de déconnexion  -->
	<!--  =================================  -->
	<c:if test="${not empty param.logout_message}">
		<font style="color: green; font-style: italic;">
                    <fmt:message key="Sedeconnecter"/>
		</font>
	</c:if>
	
	
	
<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel" 
		style="margin-left:0px; margin-top:0px; margin-right:0px;">
  <ol class="carousel-indicators" >
    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
  </ol>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="${pageContext.request.contextPath}/assets/images/etablissement.jpg" class="d-block w-100" alt="..." height="800px">
      <div class="carousel-caption">
      <h5><fmt:message key="ecole"/></h5>
      <small>
<fmt:message key="1"/>
      </small>
   	  </div>
    </div>	
    <div class="carousel-item">
      <img src="${pageContext.request.contextPath}/assets/images/chapeau2.jpg" class="d-block w-100" alt="..." height="800px">
    <div class="carousel-caption">
      <h5><fmt:message key="2"/></h5>
   	<small>
      	<fmt:message key="3"/>
      </small>
   	</div>
    </div>
    <div class="carousel-item">
      <img src="${pageContext.request.contextPath}/assets/images/salle-pause.jpg" class="d-block w-100" alt="..." height="800px">
    <div class="carousel-caption">
      <h5><fmt:message key="4"/></h5>
   	<small>
      	<fmt:message key="5"/>
     </small>
   	</div>
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only"><fmt:message key="6"/></span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only"><fmt:message key="7"/></span>
  </a>
</div>




	<br />

	<div class="container marketing">

		<!-- Three columns of text below the carousel -->
		<div class="row">
			<div class="col-lg-4">
				<svg class="bd-placeholder-img rounded-circle" width="140"
					height="140" xmlns="http://www.w3.org/2000/svg"
					preserveAspectRatio="xMidYMid slice" focusable="false" role="img"
					aria-label="Placeholder: 140x140">
					<rect width="100%" height="100%" fill="#e8362c" /></svg>
				<h2>Rentrée 2020</h2>
				<p>Vous êtes admis dans l'une de nos formations ? Procédez à
					votre inscription administrative du 8 au 24 juillet puis du 17 août
					au 11 septembre. Cette année, la procédure est intégralement
					dématérialisée. Mode d'emploi.</p>
			</div>
			<!-- /.col-lg-4 -->
			<div class="col-lg-4">
				<svg class="bd-placeholder-img rounded-circle" width="140"
					height="140" xmlns="http://www.w3.org/2000/svg"
					preserveAspectRatio="xMidYMid slice" focusable="false" role="img"
					aria-label="Placeholder: 140x140">
					<rect width="100%" height="100%" fill="#363636" /></svg>
				<h2>COVID-19</h2>
				<p>L’université de Franche-Comté a débloqué un fond d’urgence
					pour accompagner et soutenir ses étudiants en difficultés.
					Plusieurs dispositifs d’aides sont mis en place, en partenariat
					avec le Crous Bourgogne-Franche-Comté et les associations
					étudiantes.</p>
			</div>
			<!-- /.col-lg-4 -->
			<div class="col-lg-4">
				<svg class="bd-placeholder-img rounded-circle" width="140"
					height="140" xmlns="http://www.w3.org/2000/svg"
					preserveAspectRatio="xMidYMid slice" focusable="false" role="img"
					aria-label="Placeholder: 140x140">
					<rect width="100%" height="100%" fill="#2b73b3" /></svg>
				<h2>Appel à projets</h2>
				<p>Le service Sciences arts et culture de l’université de
					Franche-Comté lance un appel à projets à destination d’artistes et
					d’intervenants professionnels pour encadrer des ateliers de
					pratiques artistiques universitaires pour l’année 2020-2021.
					Ateliers à destination des étudiants, amateurs, en dehors de leur
					formation universitaire.</p>
			</div>
			<!-- /.col-lg-4 -->
		</div>
		<!-- /.row -->


		<!-- START THE FEATURETTES -->

		<hr class="featurette-divider">

		<div class="row featurette">
			<div class="col-md-7">
				<h2 class="featurette-heading">
					Premier festival du GIF scientifique : <span class="text-muted">lancement
						d'un concours pour chercheurs et grand public</span>
				</h2>
				<p class="lead">Du 1er au 7 juillet, La FABRIKÀ de l’université
					de Franche-Comté organise son premier Festival du GIF scientifique
					sur Facebook pour découvrir la science du GIF (Graphics Interchange
					Format) et la science dans les GIFs. Dans ce cadre, elle invite
					chercheurs et grand public à participer en amont à un concours, en
					créant leurs propres images animées. Les productions seront
					présentées durant le festival. À vos marques, prêts…gifez !</p>
			</div>
			<div class="col-md-5">
				<img
					src="${pageContext.request.contextPath}/assets/images/festival_gif.jpg"
					style="width: 500px; height: 350px;">
			</div>
		</div>

		<hr class="featurette-divider">

		<div class="row featurette">
			<div class="col-md-7 order-md-2">
				<h2 class="featurette-heading">Au Centre de Linguistique
					Appliquée, deux offres à distance pour s’adapter aux nouveaux
					besoins en français langue étrangère (FLE)</h2>
				<p class="lead">En réponse aux contraintes de confinement liées
					à la crise sanitaire mondiale, le Centre de Linguistique Appliquée
					(CLA) de l'Université de Franche-Comté a mis en place un dispositif
					d’enseignement à distance pour assurer au quotidien la continuité
					pédagogique et le maintien du lien social avec la communauté de ses
					étudiant.e.s internationaux. Tous les enseignements permettant la
					validation du semestre, l’octroi de crédits ECTS (Système européen
					de transfert et d’accumulation de crédits) et les cours de
					préparation aux certifications sont ainsi assurés.</p>
			</div>
			<div class="col-md-5 order-md-1">
				<img
					src="${pageContext.request.contextPath}/assets/images/newsletter-avril.jpg"
					style="width: 400px; height: 300px;">
			</div>
		</div>

		<hr class="featurette-divider">

		<!-- /END THE FEATURETTES -->

	</div>
	<!-- /.container -->

	<br />
	<br />
	<br />
	<br />
	<br />
	<br />

	<a href="${pageContext.request.contextPath}/matiere/liste">To
		Matiere</a>

	<br />
	<br />

	<a href="${pageContext.request.contextPath}/etudiant/liste">To
		Etudiant</a>

	<br />
	<br />
	<a href="${pageContext.request.contextPath}/aide/liste">To Aide</a>

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

	<br />
	<br />
	<a href="${pageContext.request.contextPath}/promotion/liste">Promotion</a>

	<br />
	<br />
	<a href="${pageContext.request.contextPath}/aide/liste">Aide</a>

	<br />
	<br />
	<a href="${pageContext.request.contextPath}/international.jsp">Inter</a>

	<jsp:include page="/Fragments/footer.jsp" />

	<script
		src="${pageContext.request.contextPath}/assets/js/jquery-3.4.1.min.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/assets/js/util.js"
		type="text/javascript"></script>



</body>
</html>