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


	<%--
			-> traitement des données envoyées par le controller 'AdministrateurController' 
				et la methode 'recupererListeAdministrateursBdd'
				
				==> les données : model.addAttribute("attribut_liste_admins", listeAdminsBdd);
	 --%>
	 
	 <h2><u>Liste des administrateurs</u></h2>
	 
	 <table border="1" width="60%">
	 
	 	<!--  Ajout d'un admin -->
	 	<tr>
	 		<td colspan="6" align="right">
	 			<%-- 
	 				au click sur le lien =>
	 					-> envoi d'une rqt http en get vers la methode "afficherFormAjoutAdmin()" 
	 						méth associée/mappé sur l'url : '/administrateurs/add-admin-form'
	 			
	 			 --%>
	 			<a style="background-color: lightblue;" href="${pageContext.request.contextPath}/administrateurs/add-admin-form">
	 				Ajouter un administrateur
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
		 <c:forEach items="${attribut_liste_admins}" var="admin">
		 	<tr>
		 		<td>${admin.identifiant }</td>
		 		<td>${admin.motDePasse }</td>
		 		<td>${admin.nom }</td>
		 		<td>${admin.prenom } </td>
		 		<td>${admin.email }</td>
		 		

		 		<!-- Colonne pour la modification de l'admin -->
		 			<!--  au click sur le lien: 
		 				-> envoi d'une rqt Http Get vers la methode "afficherFormModificationAdmin" 
		 				-> passage d'un param de rqt nommé 'idAdmin' 
		 			-->
		 		<td><a href="${pageContext.request.contextPath}/administrateurs/update-admin-form?idAdmin=${admin.identifiant }">Modifier</a></td>

		 			
		 		<!-- Colonne pour la suppression de l'admin -->

		 		<!--  au click sur le lien: 
		 				-> envoi d'une rqt Http Get vers la methode "supprimerAdminBdd" 
		 		-->
				<td><a href="${pageContext.request.contextPath}/administrateurs/delete/${admin.identifiant }">Supprimer</a></td>
		 		
		 	</tr>
		 </c:forEach>
		 
	 </table>

</body>
</html>