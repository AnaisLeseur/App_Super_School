<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!--  ajout de la taglib de spring mvc 'form' -->
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
   
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html

	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:b="http://bootsfaces.net/ui"
	xmlns:p="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core">
	
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/index.jsp">Retour à la page d'accueil</a>

	<br/><br/>
	
	<div align="center">
		<h2>Formulaire de modification d'un enseignant</h2>
	</div>

	<br/>
	
	<div align="center">
		
		<!-- 
				> modelAttribute : le nom de l'objet de commande defini dans la methode 'afficherFormModificationEnseignant' de 'EnseignantController'
			
				> a la sousmission du formulaire => invocation de la meth 'modifierEnseignantBdd' de 'EnseignantController' avec une rqt http en POST 
		
		 -->
		<form:form 	modelAttribute="enseignantModifCommand" 
					method="POST" 
					action="${pageContext.request.contextPath}/enseignants/update">
					
			<%-- affichage des tous les msg d'erreur  --%>
			<form:errors path="*" cssClass="erreurs_validation" element="div"/>
					
			<table width="60%">
			
				<!--  Récup de l'id de l'enseignant à modifier dans un champ caché  -->
				<tr>
					<td> <form:hidden path="identifiant"/> </td>
				</tr>
				
				<tr>
					<td><form:label path="nom">Nom :</form:label> </td>
					<td><form:input path="nom"/> </td>
					<td> <form:errors path="nom" cssStyle="	color: red; font-style: italic;" /> </td>
				</tr>			
			
				<tr>
					<td><form:label path="prenom">Prenom :</form:label></td>
					<td><form:input path="prenom"/></td>
					<td> <form:errors path="prenom" cssStyle="	color: red; font-style: italic;" /> </td>
				</tr>			
			
				<tr>
					<td><form:label path="email">Email : </form:label></td>
					<td><form:input path="email"/></td>
					<td> <form:errors path="email" cssStyle="	color: red; font-style: italic;" /> </td>
				</tr>

				<tr>
					<td><form:label path="motDePasse">MDP :</form:label></td>
					<td><form:input type="password" required="true" path="motDePasse"/> </td>
					<td> <form:errors path="motDePasse" cssStyle="	color: red; font-style: italic;" /> </td>
				</tr>
					
				
				<tr>
					<td colspan="3">
						<input type="submit" value="Modifier">
					</td>
				</tr>		
			
			
			</table>

		</form:form>
	</div>
	

</body>
</html>