<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%-- ajout de la taglib de spring mvc form --%>
<%@taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.erreurs_validation{color: red; 
font-style: italic; 
border: 1px dotted red; 
margin: 15px;}

</style>
</head>
<body>

<h1>Formulaire d'ajout d'un �tudiant</h1>



	<form:form modelAttribute="etudiantAddCommand" method="POST" action="${pageContext.request.contextPath}/etudiant/add">
	<%-- affichage des erreurs --%>
         <form:errors path="*" cssClass="erreurs_validation" element="div"/>
         
		<table width="60%">
			
			
			<tr>
				<td><form:label path="motDePasse">MDP</form:label></td>
				<td><form:input type="password"  path="motDePasse"/> </td>
	<td> <form:errors path="motDePasse" cssStyle="color : green; font-style: italic;"/>  </td>
				
			</tr>
			
			<tr>
				<td><form:label path="nom">Nom</form:label></td>
				<td><form:input path="nom"/> </td>
				<td> <form:errors path="nom" cssStyle="color : green; font-style: italic;"/>  </td>
			</tr>
			
			<tr>
				<td><form:label path="prenom">Prenom</form:label></td>
				<td><form:input path="prenom"/></td>
	<td> <form:errors path="prenom" cssStyle="color : green; font-style: italic;"/>  </td>
				
			</tr>
			
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input type="email" path="email"/></td>
				<td> <form:errors path="email" cssStyle="color : green; font-style: italic;"/>  </td>
			</tr>
			
			<tr>
				<td><form:label path="uploadedPhoto">Photo</form:label></td>
				<td><form:input type="file"  path="uploadedPhoto"/></td>
				 
			</tr>
			
			 
			<tr>
				<td><form:label path="dateNaissance">Date de Naissance</form:label></td>
				<td><form:input type="date" path="dateNaissance"/></td>
				<td> <form:errors path="dateNaissance" cssStyle="color : green; font-style: italic;"/>  </td>
			</tr>
			 
			<tr>
				<td colspan="2">
					<input type="submit" value="Ajouter">
				</td>
			</tr>
		
		</table>
	
	</form:form>

</body>
</html>