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
<title>Erreur 403</title>
</head>
<body>

	<br/>	<br/>
	<h1>HTTP Status 403 - Access Denied</h1>
	
	
	<s:authorize access="hasAnyRole('ROLE_Etudiant', 'ROLE_Enseignant')">
	
		<h2>Désolé... Tu ne peux pas voir cette page !!!</h2>
		 
		
		<br/>
		<br/>  
			<h4>
			Connexion : 
				<a href="${pageContext.request.contextPath}/login.jsp">Se connecter</a>
		
		</h4>
		
		<br/>
		<br/>  
		
		<h4> 
			Retour à la page d'accueil : 
				<a href="${pageContext.request.contextPath}/index.jsp">Ici</a>
		
		</h4>
	 </s:authorize>
	

</body>
</html>