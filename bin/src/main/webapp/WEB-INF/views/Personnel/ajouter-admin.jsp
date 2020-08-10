<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <!--  ajout de la taglib de spring mvc 'form' -->
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
       

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>



	
		
	<a href="${pageContext.request.contextPath}/index.jsp">Retour à la page d'accueil</a>

	


	
	<br/><br/>
	
	<div align="center">
		<h2>Formulaire d'ajout d'un administrateur</h2>
	</div>

	<br/>
	
	<div align="center">
		
		<!-- 
				> modelAttribute : le nom de l'objet de commande defini dans la methode 'afficherFormAjoutAdmin' de 'AdministrateurController'
			
				> a la sousmission du formulaire => invocation de la meth 'ajouterAdminBdd' de 'AdministrateurController' avec une rqt http en POST 
		
		 -->
		<form:form 	modelAttribute="adminCommand" 
					method="POST" 
					action="${pageContext.request.contextPath}/administrateurs/add">
					
				<%-- affichage des tous les msg d'erreur  --%>
				<form:errors path="*" cssClass="erreurs_validation" element="div"/>
					
					
					
			<table width="60%">
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
						<input type="submit" value="Ajouter">
					</td>
				</tr>		
			
			
			</table>

		</form:form>
	</div>


</body>
</html>