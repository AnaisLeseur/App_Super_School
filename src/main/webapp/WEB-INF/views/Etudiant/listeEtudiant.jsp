<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Liste des étudiants</h1>
	 
	 <table border="1" width="60%">
	 <tr>
	 	<td colspan="9" align="right">
	 		<a style="background-color: lightblue;" href="${pageContext.request.contextPath}/etudiants/add-etudiant-form">
	 			Ajout d'un étudiant
	 		</a>
	 	</td>
	 </tr>
	 	<tr>
	 		<th>ID</th>
	 		<th>Mot De Passe</th>
	 		<th>Nom</th>
	 		<th>Prenom</th>
	 		<th>Email</th>
	 		<th>Photo</th>
	 		<th>dateNaissance</th>
	 		
	 		<th>Modifier</th>
	 		<th>Supprimer</th>
	 	</tr>
	 	
	 	<c:forEach items="${attribut_listeEtudiants}" var="et">
	 	<tr>
	 		<td>${et.identifiant }</td>
	 		<td>${et.motDePasse }</td>
	 		<td>${et.nom }</td>
	 		<td>${et.prenom } €</td>
	 		<td>${et.email }</td>
	 		<td>${et.photo }</td>
	 		<td>${et.dateNaissance }</td>
	 		
	 		<td><a href="${pageContext.request.contextPath}/etudiants/update-etudiant-form/${et.identifiant }">modifier</a></td>
	 		<td><a href="${pageContext.request.contextPath}/etudiants/delete/${et.identifiant }">supprimer</a></td>
	 	</tr>
	 	</c:forEach>
	 </table>

</body>
</html>