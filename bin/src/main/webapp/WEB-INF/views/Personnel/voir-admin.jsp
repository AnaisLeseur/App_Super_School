<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<title>Information sur un administrateur</title>
	
	<!--  feuille de style -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles/perso.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles/SeeEtudiant.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles/Liste.css">
	
</head>
<body>
	
	<!--  header -->
	<jsp:include page="/Fragments/Header.jsp"/>

	<h1 id="TitreIdEtudiant">Administrateur N°${adminVoirCommand.identifiant }</h1>

	<div id="ModifierEtudiant">
		<a href="${pageContext.request.contextPath}/administrateurs/update-admin-form?idAdmin=${adminVoirCommand.identifiant }">
			Modifier 
			<img src="${pageContext.request.contextPath}/assets/images/arrow-counterclockwise.svg">
		</a>
	</div>
	
	<br/>
	<br/>
	
	<div id="DivInfosAdmin" >
			<div class="col-md-8">
					<h5 class="card-title">
						<span id=span-nom>${adminVoirCommand.nom }</span> <span
							id=span-prenom>${adminVoirCommand.prenom }</span>
					</h5>
					<div class="card-text">
						<ul class="list-group list-group-flush">
							<li class="list-group-item">Email : ${adminVoirCommand.email }</li>
						</ul>
       				</div>
					
        	<div class="Adresse">Adresse :</div>

			<c:if
				test="${empty adminVoirCommand.adresse.rue and empty adminVoirCommand.adresse.ville and empty adminVoirCommand.adresse.codePostal }">
				<a class="LinkRougeNull" href="${pageContext.request.contextPath}/administrateurs/update-admin-form?idAdmin=${adminVoirCommand.identifiant }">
					Aucune adresse liée, veuillez ajouter une adresse
				</a>
			</c:if>

			<c:if test="${not empty adminVoirCommand.adresse }">
				<div id="infosAdresse">${adminVoirCommand.adresse.rue}
					${adminVoirCommand.adresse.ville}
					${adminVoirCommand.adresse.codePostal}</div>
			</c:if>

		</div>
      </div>



	<!-- footer -->
	<jsp:include page="/Fragments/footer.jsp"></jsp:include>

</body>
</html>