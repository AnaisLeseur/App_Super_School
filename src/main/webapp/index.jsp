<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%-- taglibs core des jsp --%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
 
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Test</h1>
	
		<!--  AFFICHAGE d'un MSG de déconnexion  -->
	<!--  =================================  -->
	<c:if test="${not empty param.logout_message}">
		<font style="color: green; font-style: italic;">
			Vous êtes déconnecté !!!
		</font>
	</c:if>
	
	<a href="<c:url value='login.jsp' />">Se connecter</a>
	

	<a href="${pageContext.request.contextPath}/matiere/liste">To Cours</a>


	<a href="${pageContext.request.contextPath}/etudiant/liste">To Etudiant</a>
	<a href="${pageContext.request.contextPath}/adresse/liste">To Adresse</a>
	
	<br/>
	<br/>
	
	<a href="${pageContext.request.contextPath}/administrateurs/liste">Administateur</a>
	
	<br/>
	<br/>

	<a href="${pageContext.request.contextPath}/cours/liste">To Cours</a>

	<br/>
	<br/>

	<a href="${pageContext.request.contextPath}/enseignants/liste">Enseignants</a>
	
	<br/>
	<br/>
	<a href="${pageContext.request.contextPath}/promotion/liste">Promotion</a>





</body>
</html>