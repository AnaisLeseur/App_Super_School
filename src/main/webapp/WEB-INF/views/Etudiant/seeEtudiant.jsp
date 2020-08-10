<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles/SeeEtudiant.css">
	
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles/Liste.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles/perso.css">
</head>

<body>
	<jsp:include page="/Fragments/Header.jsp" />


	<h1 id="TitreIdEtudiant">Etudiant
		N°${etudiantSeeCommand.identifiant }</h1>

	<div id="ModifierEtudiant">
		<a
			href="${pageContext.request.contextPath}/etudiants/update-etudiant-form/${etudiantSeeCommand.identifiant }">
			Modifier <img
			src="${pageContext.request.contextPath}/assets/images/arrow-counterclockwise.svg">
		</a>
	</div>

	<div id="DivInfosEtudiant">


		<img id="PhotoEtudiant"
			src="${pageContext.request.contextPath}/assets/images/photos/${etudiantSeeCommand.photo }">

		<div>
			<div class="infosEtudiant">
				<h2>Identité :</h2>
				<p>
					<span>${etudiantSeeCommand.nom }</span> ${etudiantSeeCommand.prenom }
				</p>
			</div>

			<div class="infosEtudiant">
				<h2>Email :</h2>
				<p>${etudiantSeeCommand.email }</p>
			</div>

			<div class="infosEtudiant">
				<h2>Date de Naissance :</h2>
				<p>${etudiantSeeCommand.dateNaissance }</p>
			</div>

			<div class="Adresse">Adresse :</div>

			<c:if
				test="${empty etudiantSeeCommand.adresse.rue and empty etudiantSeeCommand.adresse.ville and empty etudiantSeeCommand.adresse.codePostal }">
				<a class="LinkRougeNull"
					href="${pageContext.request.contextPath}/etudiants/update-etudiant-form/${etudiantSeeCommand.identifiant}">Aucune
					adresse liée, veuillez ajouter une adresse</a>
			</c:if>

			<c:if test="${not empty etudiantSeeCommand.adresse }">
				<div id="infosAdresse">${etudiantSeeCommand.adresse.rue}
					${etudiantSeeCommand.adresse.ville}
					${etudiantSeeCommand.adresse.codePostal}</div>
			</c:if>

		</div>

	</div>


	<div class="col-md-11" style="margin: auto;">


        <div class="col-md-5" style="float: left;">

            <h1>Promotions :</h1>
	
	
	<c:if  test="${ empty etudiantSeeCommand.listePromotions}">
		<a class="LinkRougeNull" href="${pageContext.request.contextPath}/etudiant/linkPromotion/${etudiantSeeCommand.identifiant}">Aucune promotion associée</a>
	</c:if>
	
	
	<c:if  test="${not empty etudiantSeeCommand.listePromotions}">
	
	
	<table class="table table-striped table-bordered table-hover">

		<thead class="thead-blue">

			<tr>
				<th scope="col">Id Promotion</th>
				<th scope="col">Libelle</th>
				
				<th scope="col">Retirer</th>
			</tr>

		</thead>

		<tbody>

			<c:forEach items="${etudiantSeeCommand.listePromotions}" var="pro">
				<tr>
					<td>${pro.idPromotion}</td>
					<td>${pro.libelle}</td>
					
					<td><a
						href="${pageContext.request.contextPath}/etudiants/deletePromotion?idPromo=${pro.idPromotion}&idEtudiant=${etudiantSeeCommand.identifiant}"><img
							src="${pageContext.request.contextPath}/assets/images/x.svg"></a> </td>
				</tr>

			</c:forEach>
			
			<tr>
				<td colspan="3">
					<a href="${pageContext.request.contextPath}/etudiant/linkPromotion/${etudiantSeeCommand.identifiant}">Ajouter Promotion</a>
				</td>
			</tr>
			
		</tbody>

	</table>
	
	</c:if>
	
	</div>
	
	<div class="col-md-5" style="float: right;">

            <h1>Cours :</h1>

            <a class="LinkRougeNull" href="${pageContext.request.contextPath}/etudiant/linkPromotion/${etudiantSeeCommand.identifiant}">Aucune
                promotion associé</a>


            <table class="table table-striped table-bordered table-hover">

                <thead class="thead-blue">

                    <tr>
                        <th scope="col">Id Promotion</th>
                        <th scope="col">Libelle</th>
                    </tr>

                </thead>

                <tbody>

                    <c:forEach items="${etudiantSeeCommand.listePromotions}" var="pro">
                        <tr>
                            <td>${pro.idPromotion}</td>
                            <td>${pro.libelle}</td>
                        </tr>

                    </c:forEach>
                </tbody>

            </table>


        </div>
    </div>
    
    <jsp:include page="/Fragments/footer.jsp" />

</body>
</html>