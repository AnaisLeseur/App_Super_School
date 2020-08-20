<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<title>Information sur un enseignant</title>
	
	<!--  feuille de style -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles/perso.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles/SeeEtudiant.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles/Liste.css">
	
</head>
<body>


	
	<!--  header -->
	<jsp:include page="/Fragments/Header.jsp"/>

	<h1 id="TitreIdEtudiant">Enseignant N°${enseignantVoirCommand.identifiant }</h1>
	
	<div id="ModifierEtudiant">
		<a href="${pageContext.request.contextPath}/enseignants/update-enseignant-form?idEnseignant=${enseignantVoirCommand.identifiant }">
			Modifier 
			<img src="${pageContext.request.contextPath}/assets/images/arrow-counterclockwise.svg">
		</a>
	</div>
	
	<br/>
	<br/>
	
		<div id="DivInfosAdmin" >
			<div class="col-md-8">
					<h5 class="card-title">
						<span id=span-nom>${enseignantVoirCommand.nom }</span> <span
							id=span-prenom>${enseignantVoirCommand.prenom }</span>
					</h5>
					<div class="card-text">
						<ul class="list-group list-group-flush">
							<li class="list-group-item">Email : ${enseignantVoirCommand.email }</li>
						</ul>
       				</div>
					
		
		<div class="card-text">
			<h2 style="color: black;">Adresse :</h2>
			<br/>
			<c:if
				test="${empty enseignantVoirCommand.adresse.rue and empty enseignantVoirCommand.adresse.ville and empty enseignantVoirCommand.adresse.codePostal }">
				<a class="LinkRougeNull" href="${pageContext.request.contextPath}/enseignants/update-enseignant-form?idEnseignant=${enseignantVoirCommand.identifiant }">
					Aucune adresse liée, veuillez ajouter une adresse
				</a>
			</c:if>

			<c:if test="${not empty enseignantVoirCommand.adresse }">
				
				
				<p style="margin-bottom: 0px; margin-left: 20px;">${enseignantVoirCommand.adresse.rue}</p>
				<p style="margin-top: 0px; margin-left: 20px;">${enseignantVoirCommand.adresse.codePostal} ${enseignantVoirCommand.adresse.ville}</p>
			</c:if>

		</div>

      </div>
    </div>
    
    <br/>
    <div style="margin: auto;width: 95%;">

			<h3 style="margin-top: 2rem;">Vos enseignements (Associations matière/promotion) :</h3>

			<br/>

			<c:if test="${ empty enseignantVoirCommand.listeEnseigneJointureEns}">
				<a class="LinkRougeNull"
					href="${pageContext.request.contextPath}/enseigneJointure/liste/${enseignantVoirCommand.identifiant}/E">Aucune
					promotion ou matière associée</a>
			</c:if>

			<c:if test="${not empty enseignantVoirCommand.listeEnseigneJointureEns}">
				<a 	href="${pageContext.request.contextPath}/enseigneJointure/liste/${enseignantVoirCommand.identifiant}/E" style="margin-left: 6rem;">Gerer les 
				associations avec promotion ou matière</a>
				 <br/>
				
				<table class="table table-striped table-bordered table-hover" style="padding-top: 1.5rem;">

					<thead class="thead-blue"> 
						<tr>
							<th scope="col">Cours pour la promotion:</th>
							<th scope="col">Matiere:</th>
						</tr>

					</thead>

					<tbody>

						<c:forEach items="${enseignantVoirCommand.listeEnseigneJointureEns}" var="ej">
							<tr>
								<td>${ej.promotionEJ.libelle}</td>
								<td>${ej.matiereEJ.libelle}</td>
							</tr>

						</c:forEach>

					</tbody>

				</table>

			</c:if>

		</div>


	<!-- footer -->
	<jsp:include page="/Fragments/footer.jsp"></jsp:include>

</html>