<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%-- taglibs core des jsp --%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
 
  <%-- taglibs s de spring security --%>
 <%@taglib prefix="s" uri="http://www.springframework.org/security/tags" %>   


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Authentification</title>
</head>
<body>


	<!--  AFFICHAGE des MSG d'ERREURS  -->
	<!--  ===========================  -->
	<!--  en cas d'echec d'authentification -->
	<c:if test="${not empty param.error}">
		<font style="color: red; font-style: italic;">
			Erreur d'authentification. Identifiant ou MdP invalide !!!
			<b>Raison</b> : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</font>
	
	</c:if>


	<!--  FORMULAIRE D'AUTHENTIFICATION  -->
	<!--  =============================  -->
	<!--  l'url '/login' effectuant l'authentification à la sousmission du formulaire -->
	
	<c:url value="login" var="loginUrl"/>
	
	   <form action="${loginUrl}" method="post">
		<table>
			<tr>
				<td>Identifiant : </td>
				<td> <input type="text" name="identifiant"> </td>
			</tr>
			<tr>
				<td>Mot de passe : </td>
				<td> <input type="text" name="motDePasse"> </td>
			</tr>
			<tr>
				<td colspan="2"> <input type="submit" value="Se connecter"> | <input type="reset" value="Reset"> </td>
			</tr>
		</table>
	</form>

	<!--  Affichage lien vers la page d'accueil  -->
	<!--  =====================================  -->
	<c:if test="${not empty param.logout_message}">
		<a href="${pageContext.request.contextPath}/index.jsp">
			Retour à la page d'accueil
		</a>
	</c:if>
	



</body>
</html>