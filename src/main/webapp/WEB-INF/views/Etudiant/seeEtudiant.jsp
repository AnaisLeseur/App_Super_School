<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

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
	 		<th>Nom</th>
	 		<th>Prenom</th>
	 		<th>Email</th>
	 		<th>dateNaissance</th>
	 		
	 		<th>Consulter</th>
	 		<th>Modifier</th>
	 		<th>Supprimer</th>
	 	</tr>
	 	
	 	<tr>
	 		<td>${etudiantSeeCommand.identifiant }</td>
	 		<td>${etudiantSeeCommand.nom }</td>
	 		<td>${etudiantSeeCommand.prenom }</td>
	 		<td>${etudiantSeeCommand.email }</td>
	 		<td>${etudiantSeeCommand.dateNaissance }</td>
	 		
	 		
	 	</tr>
	 </table>

</body>
</html>