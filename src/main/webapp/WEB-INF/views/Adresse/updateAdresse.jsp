<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Formulaire d'ajout d'une adresse</h1>



	<form:form modelAttribute="adresseUpdateCommand" method="POST" action="${pageContext.request.contextPath}/adresse/update">
	
		<table width="60%">
			
			<tr>
				<td> <form:hidden path="idAdresse"/> </td>
			</tr>
			
			<tr>
				<td><form:label path="rue">Rue</form:label></td>
				<td><form:input type="text"  path="rue"/> </td>
			</tr>
			
			<tr>
				<td><form:label path="codePostal">codePostal</form:label></td>
				<td><form:input path="codePostal"/> </td>
			</tr>
			
			<tr>
				<td><form:label path="ville">ville</form:label></td>
				<td><form:input path="ville"/></td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="submit" value="Modifier">
				</td>
			</tr>
		
		</table>
	
	</form:form>

</body>
</html>