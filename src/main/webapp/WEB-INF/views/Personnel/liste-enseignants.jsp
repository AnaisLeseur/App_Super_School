<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/index.jsp">Retour à la page d'accueil</a>



	<%--
			-> traitement des données envoyées par le controller 'EnseignantController' 
				et la methode 'recupererListeEnseignantsBdd'
				
				==> les données : model.addAttribute("attribut_liste_enseignants", listeEnseignantsBdd);
	 --%>
	 
	 <h2><u>Liste des enseignants</u></h2>
	 
	 <table border="1" width="60%">
	 
	 	<!--  Ajout d'un enseignant -->
	 	<tr>
	 		<td colspan="7" align="right">
	 			<%-- 
	 				au click sur le lien =>
	 					-> envoi d'une rqt http en get vers la methode "afficherFormAjoutEnseignant()" 
	 						méth associée/mappé sur l'url : '/enseignants/add-enseignant-form'
	 			
	 			 --%>
	 			<a style="background-color: lightblue;" href="${pageContext.request.contextPath}/enseignants/add-enseignant-form">
	 				Ajouter un enseignant
	 			</a>
	 		</td>
	 	</tr>
	 
		 <tr>
		 	<th>ID</th>
	 		<th>Mot De Passe</th>
	 		<th>Nom</th>
	 		<th>Prenom</th>
	 		<th>Email</th>
	 		
	 		<th>Modifier</th>
	 		<th>Supprimer</th>
		 </tr>
		 
		 <!--  données de la table -->
		 <c:forEach items="${attribut_liste_enseignants}" var="enseignant">
		 	<tr>
		 		<td>${enseignant.identifiant }</td>
		 		<td>${enseignant.motDePasse }</td>
		 		<td>${enseignant.nom }</td>
		 		<td>${enseignant.prenom } </td>
		 		<td>${enseignant.email }</td>
		 		

		 		<!-- Colonne pour la modification de l'enseignant -->
		 			<!--  au click sur le lien: 
		 				-> envoi d'une rqt Http Get vers la methode "afficherFormModificationEnseignant" 
		 				-> passage d'un param de rqt nommé 'idEnseignant' 
		 			-->
		 		<td><a href="${pageContext.request.contextPath}/enseignants/update-enseignant-form?idEnseignant=${enseignant.identifiant }">Modifier</a></td>

		 			
		 		<!-- Colonne pour la suppression de l'enseignant -->

		 		<!--  au click sur le lien: 
		 				-> envoi d'une rqt Http Get vers la methode "supprimerEnseignantBdd" 
		 		-->
				<td><a href="${pageContext.request.contextPath}/enseignants/delete/${enseignant.identifiant }">Supprimer</a></td>
		 		
		 	</tr>
		 </c:forEach>
		 
	 </table>


</body>
</html>