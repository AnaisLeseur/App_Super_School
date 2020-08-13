<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

		<div>
			<div class="infosEtudiant">
				<h2>Libelle :</h2>
				<p>
					<span>${coursSeeCommand.libelle }</span>
				</p>
			</div>

			<div class="infosEtudiant">
				<h2>Email :</h2>
				<p>${coursSeeCommand.duree }</p>
			</div>

			<div class="infosEtudiant">
				<h2>Date du Cours :</h2>
				<p>${coursSeeCommand.date }</p>
			</div>

			<div class="Adresse">Matiere :</div>

			<c:if
				test="${empty coursSeeCommand.matiere }">
				<a class="LinkRougeNull"
					href="#">
					Aucune adresse liée, veuillez ajouter une adresse </a>
			</c:if>

			<c:if test="${not empty etudiantSeeCommand.adresse }">
				<div id="infosAdresse">${coursSeeCommand.matiere.libelle}</div>
			</c:if>

		</div>

	</div>

	<br />

	<div class="col-md-11" style="margin: auto;height:auto;display:block">

			<h1>Etudiant :</h1>

			<c:if test="${ empty coursSeeCommand.listeEtudiantsCours}">
				<a class="LinkRougeNull"
					href="${pageContext.request.contextPath}/cours/linkEtudiantCours/${coursSeeCommand.idCours}">Aucun
					étudiant associé</a>
			</c:if>

			<c:if test="${not empty coursSeeCommand.listeEtudiantsCours}">

				<table class="table table-striped table-bordered table-hover">

					<thead class="thead-blue">

						<tr>
							<th scope="col">ID</th>
							<th scope="col">Etudiant</th>

							<th scope="col">Appel</th>
							<th scope="col">Motif</th>
							
							<th scope="col">Supprimer</th>

						</tr>

					</thead>

					<tbody>
						
						<c:forEach items="${coursSeeCommand.listeEtudiantsCours}"
							var="etudiantCours">
							<tr>
								<td>${etudiantCours.etudiantEC.identifiant}</td>
								<td>${etudiantCours.etudiantEC.nom} ${etudiantCours.etudiantEC.prenom}</td>

								<td>
									<c:choose>
										<c:when test="${etudiantCours.absence}">Présent</c:when>
										<c:when test="${empty etudiantCours.absence}">-</c:when>
										<c:otherwise>Absent</c:otherwise>
									</c:choose>
								</td>
								
								
								<td>${etudiantCours.motif}</td>
								
								<td><a
									href="${pageContext.request.contextPath}/etudiants/deleteEtudiantCours?idEtudiantCours=${etudiantCours.idEtudiantCours}&idEtudiant=${etudiantSeeCommand.identifiant}">
										<img
										src="${pageContext.request.contextPath}/assets/images/x.svg">
								</a></td>
								
							</tr>
							
						</c:forEach>
						
						<tr>
							<td colspan="5"><a
									href="${pageContext.request.contextPath}/cours/edit-form-EtudiantCours/${coursSeeCommand.idCours}">
										<img
										src="${pageContext.request.contextPath}/assets/images/pencil.svg">
								</a></td>
						</tr>
					</tbody>

				</table>

			</c:if>
		

		
	</div>
	
</body>
</html>