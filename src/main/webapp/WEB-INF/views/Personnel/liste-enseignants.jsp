<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des  enseignants</title>


<!-- style CSS  -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles/bootstrap.min.css">

<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles/Liste.css">


	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles/perso.css">
	

</head>
<body>

	<!-- Header -->

	<jsp:include page="/Fragments/Header.jsp" />


	<%--
			-> traitement des données envoyées par le controller 'EnseignantController' 
				et la methode 'recupererListeEnseignantsBdd'
				
				==> les données : model.addAttribute("attribut_liste_enseignants", listeEnseignantsBdd);
	 --%>

	<h1 id="TitreListe">
		<u>Liste des enseignants</u>
	</h1>

	

	 
	 <h1 id="TitreListe">Liste des enseignants </h1>
	 	 

	<table class="table table-striped table-bordered table-hover">

		<thead class="thead-blue">

			<tr>

				<th id="Ajout" colspan="8"><a
					href="${pageContext.request.contextPath}/enseignants/add-enseignant-form"><img
						id="LogoAjout"
						src="${pageContext.request.contextPath}/assets/images/AjoutFichier.png">
						<span>Ajouter un enseignant</span></a></th>
			</tr>


			

			<tr>
				<th scope="col">ID</th>
<th scope="col">Mot De Passe</th>
				<th scope="col">Nom</th>
				<th scope="col">Prenom</th>
				<th scope="col">Email</th>


				<th scope="col">Consulter</th>

				<th scope="col">Modifier</th>
				<th scope="col">Supprimer</th>
			</tr>
		</thead>

		<!--  données de la table -->
		<tbody>
		<c:forEach items="${attribut_liste_enseignants}" var="enseignant">
			<tr>
				<td>${enseignant.identifiant }</td>
				<td>${enseignant.motDePasse }</td>
				<td>${enseignant.nom }</td>
				<td>${enseignant.prenom }</td>
				<td>${enseignant.email }</td>


				<!-- Colonne pour la modification de l'enseignant -->
				<!--  au click sur le lien: 
		 				-> envoi d'une rqt Http Get vers la methode "afficherFormModificationEnseignant" 
		 				-> passage d'un param de rqt nommé 'idEnseignant' 
		 			-->
				<td><a
					href="${pageContext.request.contextPath}/enseignants/update-enseignant-form?idEnseignant=${enseignant.identifiant }">Modifier</a></td>


				<!-- Colonne pour la suppression de l'enseignant -->

				<!--  au click sur le lien: 
		 				-> envoi d'une rqt Http Get vers la methode "supprimerEnseignantBdd" 
		 		-->
				<td><a
					href="${pageContext.request.contextPath}/enseignants/delete/${enseignant.identifiant }">Supprimer</a></td>


		<tbody>
			<c:forEach items="${attribut_liste_enseignants}" var="enseignant">
				<tr>
		 		<td>${enseignant.identifiant }</td>
		 		<td>${enseignant.nom }</td>
		 		<td>${enseignant.prenom } </td>
		 		<td>${enseignant.email }</td>

					<td>
						<a href="${pageContext.request.contextPath}/enseignants/see-enseignant/${enseignant.identifiant }">
							<img src="${pageContext.request.contextPath}/assets/images/search.svg">
						</a>
					</td>
					<td>
						<a href="${pageContext.request.contextPath}/enseignants/update-enseignant-form?idEnseignant=${enseignant.identifiant }">
							<img src="${pageContext.request.contextPath}/assets/images/pencil.svg">
						</a>
					</td>
					<td>
						<a href="${pageContext.request.contextPath}/enseignants/delete/${enseignant.identifiant }">
							<img src="${pageContext.request.contextPath}/assets/images/trash.svg">
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
		
	</table>

	<script
		src="${pageContext.request.contextPath}/assets/scripts/jquery-3.4.1.js" type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/assets/scripts/bootstrap.min.js" type="text/javascript"></script>

	
	<!-- footer -->
	<jsp:include page="/Fragments/footer.jsp"></jsp:include> 


			</tr>
		</c:forEach>
		</tbody>
		</table>
</body>


<script
	src="${pageContext.request.contextPath}/assets/scripts/jquery-3.4.1.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/assets/scripts/bootstrap.min.js"
	type="text/javascript"></script>

</html>