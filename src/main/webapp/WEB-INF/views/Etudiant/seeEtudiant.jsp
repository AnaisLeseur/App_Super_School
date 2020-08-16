<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


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
<sec:authorize access="hasRole('ROLE_Admin')">	
	<div id="ModifierEtudiant">
		<a
			href="${pageContext.request.contextPath}/etudiants/update-etudiant-form/${etudiantSeeCommand.identifiant }">
			Modifier <img
			src="${pageContext.request.contextPath}/assets/images/arrow-counterclockwise.svg">
		</a>
	</div>
</sec:authorize>

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

			<div class="infosEtudiant">

			<h2>Adresse :</h2>
		<sec:authorize access="hasRole('ROLE_Admin')">		
			<c:if
				test="${empty etudiantSeeCommand.adresse.rue and empty etudiantSeeCommand.adresse.ville and empty etudiantSeeCommand.adresse.codePostal }">
				<a class="LinkRougeNull"
					href="${pageContext.request.contextPath}/etudiants/update-etudiant-form/${etudiantSeeCommand.identifiant}">
					Aucune adresse liée, veuillez ajouter une adresse </a>
			</c:if>
		</sec:authorize>
		
			<c:if
				test="${empty etudiantSeeCommand.adresse.rue and empty etudiantSeeCommand.adresse.ville and empty etudiantSeeCommand.adresse.codePostal }">
				<p class="LinkRougeNull">
					Aucune adresse liée, veuillez contacter l'adminstrateur pour completer les informations </p>
			</c:if>
	

			<c:if test="${not empty etudiantSeeCommand.adresse }">
				<p style="margin-bottom: 0px;">${etudiantSeeCommand.adresse.rue}</p>
				<p style="margin-top: 0px;">${etudiantSeeCommand.adresse.codePostal} ${etudiantSeeCommand.adresse.ville}</p>
			</c:if>
			
			</div>

		</div>

	</div>

	<br />

	<div style="margin: auto;display: inline-flex;width: 100%;">


		<div class="col-md-6" >

			<h1>Promotions :</h1>


			<c:if test="${ empty etudiantSeeCommand.listePromotions}">
				<a class="LinkRougeNull"
					href="${pageContext.request.contextPath}/etudiant/linkPromotion/${etudiantSeeCommand.identifiant}">Aucune
					promotion associée</a>
			</c:if>

			<c:if test="${not empty etudiantSeeCommand.listePromotions}">


				<table class="table table-striped table-bordered table-hover">

					<thead class="thead-blue">
						<tr>
							<th scope="col">Id Promotion</th>
							<th scope="col">Libelle</th>
							<sec:authorize access="hasRole('ROLE_Admin')">
								<th scope="col">Retirer</th>
							</sec:authorize>
						</tr>

					</thead>

					<tbody>

						<c:forEach items="${etudiantSeeCommand.listePromotions}" var="pro">
							<tr>
								<td>${pro.idPromotion}</td>
								<td>${pro.libelle}</td>

								<sec:authorize access="hasRole('ROLE_Admin')">
								<td><a
									href="${pageContext.request.contextPath}/etudiants/deletePromotion?idPromo=${pro.idPromotion}&idEtudiant=${etudiantSeeCommand.identifiant}">
										<img
										src="${pageContext.request.contextPath}/assets/images/x.svg">
									</a>
								</td>
								</sec:authorize>
							</tr>

						</c:forEach>
        <sec:authorize access="hasRole('ROLE_Admin')">
						<tr>
							<td colspan="3"><a
								href="${pageContext.request.contextPath}/etudiant/linkPromotion/${etudiantSeeCommand.identifiant}">Ajouter
									Promotion</a></td>
						</tr>
		</sec:authorize>

					</tbody>

				</table>

			</c:if>

		</div>

		<div class="col-md-6" >

			<h1>Cours :</h1>

			<c:if test="${ empty etudiantSeeCommand.listeEtudiantCours}">
				<a class="LinkRougeNull"
					href="${pageContext.request.contextPath}/etudiant/linkEtudiantCours/${etudiantSeeCommand.identifiant}">Aucun
					cours associé</a>
			</c:if>

			<c:if test="${not empty etudiantSeeCommand.listeEtudiantCours}">

				<table class="table table-striped table-bordered table-hover">

					<thead class="thead-blue">

						<tr>
							<th scope="col">Id Cours</th>
							<th scope="col">Libelle</th>
							<th scope="col">Appel</th>
							
							
						<sec:authorize access="hasRole('ROLE_Etudiant')">	
							<th scope="col">Voir les informations du cours</th>
						</sec:authorize>
						
  						<sec:authorize access="hasAnyRole('ROLE_Admin', 'ROLE_Enseignant')">
							<th scope="col">Editer Appel</th>
							<th scope="col">Supprimer</th>
						</sec:authorize>

						</tr>

					</thead>

					<tbody>
						
						<c:forEach items="${etudiantSeeCommand.listeEtudiantCours}"
							var="etudiantCours">
							<tr>
								<td>${etudiantCours.coursEC.idCours}</td>
								<td>${etudiantCours.coursEC.libelle}</td>

	
								<td>
									<c:choose>
										<c:when test="${etudiantCours.absence}">Présent</c:when>
										<c:when test="${empty etudiantCours.absence}">-</c:when>
										<c:otherwise>Absent</c:otherwise>
									</c:choose>
								</td>
								
								
								<sec:authorize access="hasRole('ROLE_Etudiant')">	
									<td>
										<a href="${pageContext.request.contextPath}/cours/see-cours/${etudiantCours.coursEC.idCours}"><img
											src="${pageContext.request.contextPath}/assets/images/search.svg">
										</a>
									</td>
								</sec:authorize>
								
								
								<sec:authorize access="hasAnyRole('ROLE_Admin', 'ROLE_Enseignant')">
								<td><a
									href="${pageContext.request.contextPath}/etudiants/edit-form-EtudiantCours/${etudiantCours.idEtudiantCours}">
										<img
										src="${pageContext.request.contextPath}/assets/images/pencil.svg">
								</a></td>
								
								
								<td><a
									href="${pageContext.request.contextPath}/etudiants/deleteEtudiantCours?idEtudiantCours=${etudiantCours.idEtudiantCours}&idEtudiant=${etudiantSeeCommand.identifiant}">
										<img
										src="${pageContext.request.contextPath}/assets/images/x.svg">
								</a></td>
								</sec:authorize>
							</tr>
							
						</c:forEach>
			<sec:authorize access="hasRole('ROLE_Admin')">		
						<tr>
							<td colspan="5"><a
								href="${pageContext.request.contextPath}/etudiant/linkEtudiantCours/${etudiantSeeCommand.identifiant}">Ajouter
									Cours</a></td>
						</tr>
			</sec:authorize>	
					</tbody>

				</table>

			</c:if>
		</div>

		
	</div>


	<jsp:include page="/Fragments/footer.jsp" />

</body>
</html>