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
		<u>Liste des promotions</u>
	</h1>
	
	<table border="1" width="60%">

		<tr>
			<td colspan="5" align="right">
			<%--> au click sur le lien : envoie d'une requete http en get vers la méthode 'afficherFormulaireAjout()' --%>
			<a style="background-color: lightBlue;"
				href="${pageContext.request.contextPath}/promotion/add-promotion-form">
					Ajout d'une promotion </a></td>
		</tr>


		<tr>
			<th>Id Promotion</th>
			<th>Libelle</th>
			
			

			<th>Modifier</th>
		<th>Eliminer</th>
</tr>
		<!-- données de la table
    -->
		<c:forEach items="${attribut_liste_promotion}" var="pro">
			<tr>
				<td>${pro.idPromotion}</td>
				<td>${pro.libelle}</td>
			 
				
 

<!-- au click sur le lien : envoie d'ue requete HTTP en Get vers la méthode "afficherFormulaireModification()" 
passage d'un param de requete nommé idemploye ayant la valeur de l'id de l'employe à modifier
 -->
				<td>
				<a href="${pageContext.request.contextPath}/promotion/update-promotion-form?idpromotion=${pro.idPromotion}">
						modifier
						</a>
						</td>
				<!-- suppression -->
				<td>
					<!-- au click sur le lien : envoie d'une requete http get vers la méthode supprimer -->
					<a
					href="${pageContext.request.contextPath}/promotion/delete/${pro.idPromotion}">
						supprimer</a>
				</td>


			</tr>

		</c:forEach>

		</table>


</body>
</html>