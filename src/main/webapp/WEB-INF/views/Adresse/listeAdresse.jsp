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
<h1>Liste des adresses</h1>
	 
	 <table border="1" width="60%">
	 <tr>
	 	<td colspan="6" align="right">
	 		<a style="background-color: lightblue;" href="${pageContext.request.contextPath}/adresses/add-adresse-form">
	 			Ajout d'une adresse
	 		</a>
	 	</td>
	 </tr>
	 	<tr>
	 		<th>ID</th>
	 		<th>Rue</th>
	 		<th>Code Postal</th>
	 		<th>Ville</th>
	 		
	 		<th>Modifier</th>
	 		<th>Supprimer</th>
	 	</tr>
	 	
	 	<c:forEach items="${attribut_listeAdresses}" var="ad">
	 	<tr>
	 		<td>${ad.idAdresse }</td>
	 		<td>${ad.rue }</td>
	 		<td>${ad.codePostal }</td>
	 		<td>${ad.ville }</td>
	 		
	 		<td><a href="${pageContext.request.contextPath}/adresses/update-adresse-form/${ad.idAdresse }">modifier</a></td>
	 		<td><a href="${pageContext.request.contextPath}/adresses/delete/${ad.idAdresse }">supprimer</a></td>
	 	</tr>
	 	</c:forEach>
	 </table>

</body>
</html>