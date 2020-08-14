<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%-- taglibs core des jsp --%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
 
  <%-- taglibs s de spring security --%>
 <%@taglib prefix="s" uri="http://www.springframework.org/security/tags" %>   
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
 
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<br/>
	
	<%-- Affichage de l'identifiant et des roles des users --%>
	<div style="width: 300px">
	
		<%-- affichage de l'identifiant de l'utilisateur --%>
		<h3>
			<fmt:message key="accueil"/> <s:authentication property="name"/>
		</h3>
		<br/>
		<%-- affichage des roles du user --%>
		<s:authentication property="authorities" var="authorites"/>
			<ul>
				<c:forEach items="${authorites}" var="auth">
					<li>${auth.authority}</li>
				</c:forEach>
			</ul>
	</div>

</body>
</html>