<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>

	<form:form modelAttribute="etudiantCoursEditCommand" method="POST" action="/etudiant/editEtudiantCours">
		<form:input type="textarea" path="motif"/>
		<form:checkbox path="absence"/>
		
		<input type="submit" value="Editer absence">
	
	</form:form>
	
</body>
</html>