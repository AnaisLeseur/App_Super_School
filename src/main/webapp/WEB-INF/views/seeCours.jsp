<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Voir les détails du cours</title>
    
    <!--  Feuille de style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles/seeCours.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles/Liste.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles/perso.css">
	
</head>
<body>

	<!--  HEADER -->
	<jsp:include page="/Fragments/Header.jsp" />


	<h1 id="TitreIdCours">Cours N°${coursSeeCommand.idCours }</h1>
	<sec:authorize access="hasAnyRole('ROLE_Admin', 'ROLE_Enseignant')">
		<div id="ModifierCours">
			<a href="${pageContext.request.contextPath}/cours/update-cours-form?idcours=${coursSeeCommand.idCours }">
				Modifier 
				<img src="${pageContext.request.contextPath}/assets/images/arrow-counterclockwise.svg">
			</a>
		</div>
	</sec:authorize>
	
		<div id="DivInfosCours">

        <div class="infosCours" style="float: right; width: 50%;">
            <h2>Description :</h2>
            <p>
                ${coursSeeCommand.description }
            </p>
        </div>
        
        <div class="infosCours">
            <h2>Libelle :</h2>
            <p>
                <span>${coursSeeCommand.libelle }</span>
            </p>
        </div>
           
        <div class="infosCours" >
			<h2>Date du Cours :</h2>
			<p>${coursSeeCommand.date }</p>
		</div>

		<div class="infosCours">
			<h2>Durée (min):</h2>
			<p>${coursSeeCommand.duree } min</p>
		</div>

        <div class="infosCours" >
			<h2>Matière :</h2>
                <p>${coursSeeCommand.matiere.libelle}</p>
                <sec:authorize access="hasAnyRole('ROLE_Admin', 'ROLE_Enseignant')">
                <c:if test="${empty coursSeeCommand.matiere }">
					<a class="LinkRougeNull"
						href="${pageContext.request.contextPath}/cours/liste">
						Aucune matière liée, veuillez ajouter une matière </a>
				</c:if>
				</sec:authorize>
		</div>
			
		<div class="infosCours">
			<h2>Promotion :</h2>
                <p>${coursSeeCommand.promotion.libelle}</p>
                <sec:authorize access="hasAnyRole('ROLE_Admin', 'ROLE_Enseignant')">
                <c:if test="${empty coursSeeCommand.promotion }">
					<a class="LinkRougeNull"
						href="${pageContext.request.contextPath}/cours/liste">
						Aucune promotion liée, veuillez ajouter une promotion </a>
				</c:if>
				</sec:authorize>
		</div>

	</div>

	<br />

	<sec:authorize access="hasAnyRole('ROLE_Admin', 'ROLE_Enseignant')">
	<div class="col-md-11" style="margin: auto;height:auto;display:block">

		<h1>Etudiant(s) inscrits:</h1>
		<br />
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
							<th scope="col">Retirer l'étudiant du cours</th>

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
									href="${pageContext.request.contextPath}/cours/deleteEtudiantCours?idEtudiantCours=${etudiantCours.idEtudiantCours}&idCours=${coursSeeCommand.idCours}">
										<img
										src="${pageContext.request.contextPath}/assets/images/x.svg">
								</a></td>
								
							</tr>
							
						</c:forEach>
						
						<tr>
							<td colspan="5"> 
								<a href="${pageContext.request.contextPath}/cours/edit-form-EtudiantCours/${coursSeeCommand.idCours}">
										<img
										src="${pageContext.request.contextPath}/assets/images/pencil.svg">
								
								Remplir la feuille de présence
								</a>
							</td>
						</tr>
					</tbody>

				</table>

			</c:if>

	</div>
	
	</sec:authorize>
	
	<!--  FOOTER -->
	<jsp:include page="/Fragments/footer.jsp" />
	
</body>
</html>