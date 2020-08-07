<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/index.jsp">Retour à la page d'accueil</a>
<h1>
		<u>Liste des cours</u>
	</h1>

<table border="1" width="60%">

		<tr>
			<td colspan="5" align="right">
			<%--> au click sur le lien : envoie d'une requete http en get vers la méthode 'afficherFormulaireAjout()' --%>
			<a style="background-color: lightBlue;"
				href="${pageContext.request.contextPath}/cours/add-cours-form">
					Ajout d'un cours </a></td>
		</tr>


		<tr>
			<th>IdCours</th>
			<th>Libelle</th>
			<th>Description</th>
			<th>Durée</th>
			<th>Date</th>
			<th>FkEtudiant</th>
			<th>FkMatiere</th>

			<th>Modifier</th>
		<th>Eliminer</th>
</tr>
		<!-- données de la table
    -->
		<c:forEach items="${attribut_liste_cours}" var="cou">
			<tr>
				<td>${cou.idCours}</td>
				<td>${cou.libelle}</td>
				<td>${cou.description}</td>
				<td>${cou.duree}</td>
				<td>${cou.date}</td>
				<td>${cou.fkEtudiant}</td>
				<td>${cou.fkMatiere}</td>
				
 

<!-- au click sur le lien : envoie d'ue requete HTTP en Get vers la méthode "afficherFormulaireModification()" 
passage d'un param de requete nommé idemploye ayant la valeur de l'id de l'employe à modifier
 -->
				<td>
				<a href="${pageContext.request.contextPath}/cours/update-cours-form?idcours=${cou.idCours}">
						modifier
						</a>
						</td>
				<!-- suppression -->
				<td>
					<!-- au click sur le lien : envoie d'une requete http get vers la méthode supprimer -->
					<a
					href="${pageContext.request.contextPath}/cours/delete/${cou.idCours}">
						supprimer</a>
				</td>


			</tr>

		</c:forEach>

		</table>

</body>
</html>