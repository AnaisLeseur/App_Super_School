<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- ajout de la taglib de spring mvc form --%>
<%@taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Formulaire d'ajout d'un étudiant</h1>



	<form:form modelAttribute="etudiantAddCommand" method="POST" action="${pageContext.request.contextPath}/etudiant/add">
	
		<table width="60%">
			
			
			<tr>
				<td><form:label path="motDePasse">MDP</form:label></td>
				<td><form:input type="password"  path="motDePasse"/> </td>
			</tr>
			
			<tr>
				<td><form:label path="nom">Nom</form:label></td>
				<td><form:input path="nom"/> </td>
			</tr>
			
			<tr>
				<td><form:label path="prenom">Prenom</form:label></td>
				<td><form:input path="prenom"/></td>
			</tr>
			
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input type="email" path="email"/></td>
			</tr>
			
			<tr>
				<td><form:label path="photo">Photo</form:label></td>
				<td><form:input path="photo"/></td>
			</tr>
			<%--
			<tr>
				<td><form:label path="uploadedPhoto">Photo</form:label></td>
				<td><form:input type="file"  path="uploadedPhoto"/></td>
				enctype="multipart/form-data" 
			</tr>
			 --%>
			<tr>
				<td><form:label path="dateNaissance">Date de Naissance</form:label></td>
				<td><form:input type="date" path="dateNaissance"/></td>
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