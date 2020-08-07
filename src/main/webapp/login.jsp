<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%-- taglibs core des jsp --%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
 
  <%-- taglibs s de spring security --%>
 <%@taglib prefix="s" uri="http://www.springframework.org/security/tags" %>   


<!DOCTYPE html>
<html 	xmlns:h="http://java.sun.com/jsf/html"
		xmlns:f="http://java.sun.com/jsf/core"
		xmlns:b="http://bootsfaces.net/ui">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Authentification</title>


	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles/perso.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles/bootstrap.css">
	

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body>

	<!-- Header -->
	<!-- A FAIRE -->
	<a href="${pageContext.request.contextPath}/index.jsp">Retour à la page d'accueil</a>

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
<!-- 
	<c:url value="login" var="loginUrl"/>
	
	   <form action="${loginUrl}" method="post">
		<table>
			<tr>
				<td>Identifiant : </td>
				<td> <input type="text" name="identifiant"> </td>
			</tr>
			<tr>
				<td>Mot de passe : </td>
				<td> <input type="text" name="motDePasse" > </td>
			</tr>
			<tr>
				<td colspan="2"> <input type="submit" value="Se connecter"> | <input type="reset" value="Reset"> </td>
			</tr>
		</table>
	</form>
 -->	
	<!--  Affichage lien vers la page d'accueil  -->
	<!--  =====================================  -->
	<c:if test="${not empty param.logout_message}">
		<a href="${pageContext.request.contextPath}/index.jsp">
			Retour à la page d'accueil
		</a>
	</c:if>
	
<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->

    <!-- Icon -->
    <div class="fadeIn first">
      <img src="./assets/images/Login.png" id="icon" alt="User Icon" />
    </div>
<c:url value="login" var="loginUrl"/>
    <!-- Login Form -->
    <form action="${loginUrl}" method="post">
      <input type="text" id="login" class="fadeIn second" name="identifiant" placeholder="identifiant">
      <input type="text" id="password" class="fadeIn third" name="motDePasse" placeholder="password">
      <input type="submit" class="fadeIn fourth" value="Se connecter">
    </form>

  </div>
</div>

	
	<!-- footer -->
	<jsp:include page="Fragments/footer.jsp"></jsp:include>

</body>
</html>