<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%-- ajout de la taglib de spring mvc form --%>
<%@taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Formulaire d'ajout d'une adresse</h1>



	<form:form modelAttribute="adresseAddCommand" method="POST" action="${pageContext.request.contextPath}/adresse/add">
	
		<table width="60%">
			
			
			<tr>
				<td><form:label path="rue">Rue</form:label></td>
				<td><form:input path="rue"/> </td>
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
					<input type="submit" value="Ajouter">
				</td>
			</tr>
		
		</table>
	
	</form:form>

</body>
</html>