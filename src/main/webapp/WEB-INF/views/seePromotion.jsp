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
    <title>Document</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles/bootstrap.min.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles/Liste.css">
	
	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles/seePromotion.css">
	
</head>
<body>

<jsp:include page="/Fragments/Header.jsp"/>
 <h1>Promotion : ${promotionSeeCommand.libelle}</h1>
 
 <a style="margin-left: 5rem;" href="${pageContext.request.contextPath}/enseigneJointure/liste/${promotionSeeCommand.idPromotion}/P">Gérer les associations Matière/Enseignant</a>


	<br/><br/>
           
	<div style="margin: auto;display: inline-flex;width: 100%;">
	
	<div class="col-md-6" >
	
	<h3>Liste des etudiants de la promo:</h3>
		
	<c:if  test="${ empty promotionSeeCommand.listeEtudiants}">
		<a class="LinkRougeNull" href="${pageContext.request.contextPath}/promotion/linkEtudiant/${promotionSeeCommand.idPromotion}">Aucun étudiant associé</a>
	</c:if>
	
	<c:if  test="${not empty promotionSeeCommand.listeEtudiants}">
	
	
	<table class="table table-striped table-bordered table-hover">

		<thead class="thead-blue">
			<tr>
				<th scope="col">Id Etudiant</th>
				<th scope="col">Nom</th>
				<sec:authorize access="hasRole('ROLE_Admin')">
				<th scope="col">Retirer</th>
				</sec:authorize>
			</tr>

		</thead>

		<tbody>

			<c:forEach items="${promotionSeeCommand.listeEtudiants}" var="etudiant">
				<tr>
					<td>${etudiant.identifiant}</td>
					<td>${etudiant.nom} ${etudiant.prenom}</td>
					<sec:authorize access="hasRole('ROLE_Admin')">
					<td>
						<a href="${pageContext.request.contextPath}/promotions/deleteEtudiant?idPromo=${promotionSeeCommand.idPromotion}&idEtudiant=${etudiant.identifiant}">
							<img src="${pageContext.request.contextPath}/assets/images/x.svg">
						</a> 
					</td>
					</sec:authorize>
				</tr>

			</c:forEach>
			
			<sec:authorize access="hasRole('ROLE_Admin')">
			<tr>
				<td colspan="3">
					<a href="${pageContext.request.contextPath}/promotion/linkEtudiant/${promotionSeeCommand.idPromotion}">Ajouter Etudiant</a>
				</td>
			</tr>
			</sec:authorize>
			
		</tbody>

	</table>
	
	</c:if>
	</div>
	
	<div class="col-md-6" >

	<h3>Liste des cours de la promo:</h3>
	
	<c:if  test="${ empty promotionSeeCommand.listeCours}">
	<a class="LinkRougeNull" href="${pageContext.request.contextPath}/promotion/linkCours/${promotionSeeCommand.idPromotion}"">Aucun cours associé</a>
	</c:if>
	
	<c:if test="${not empty promotionSeeCommand.listeCours}">
	
	<table class="table table-striped table-bordered table-hover">

		<thead class="thead-blue">
			<tr>
				<th scope="col">Id Cours</th>
				<th scope="col">Libelle</th>
				<th scope="col">Description</th>
				<th scope="col">Duree</th>
				<th scope="col">Date</th>
				<th scope="col">Retirer</th>
			</tr>

		</thead>

		<tbody>


			<c:forEach items="${promotionSeeCommand.listeCours}" var="cours">
				<tr>
					<td>${cours.idCours}</td>
					<td>${cours.libelle}</td>
					<td>${cours.description}</td>
					<td>${cours.duree}</td>
					<td>${cours.date}</td>
					<td>
						<a href="${pageContext.request.contextPath}/promotions/deleteCours?idPromo=${promotionSeeCommand.idPromotion}&idCours=${cours.idCours}">
							<img src="${pageContext.request.contextPath}/assets/images/x.svg">
						</a> 
					</td>
					
					
				</tr>

			</c:forEach>
			
				<tr>
					<td colspan="6">
						<a href="${pageContext.request.contextPath}/promotion/linkCours/${promotionSeeCommand.idPromotion}">Ajouter un cours</a>
					</td>
				</tr>
				
		</tbody>

	</table>
	
	</c:if>
	
	</div>
	

	
	</div>
    
    <br/>
    
    <jsp:include page="/Fragments/footer.jsp" />
	
</body>
</html>