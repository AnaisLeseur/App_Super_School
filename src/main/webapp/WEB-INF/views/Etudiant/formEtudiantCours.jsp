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
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles/bootstrap.min.css">
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles/Link.css">
    
</head>
<body>

<jsp:include page="/Fragments/Header.jsp"/>


<h1>Appel pour le cours : ${etudiantCoursEditCommand.coursEC.libelle}</h1>

<div style="width: 90%;margin: auto;">

	<h2>${etudiantCoursEditCommand.etudiantEC.nom} ${etudiantCoursEditCommand.etudiantEC.prenom}</h2>
	
	<form:form modelAttribute="etudiantCoursEditCommand" method="POST" action="${pageContext.request.contextPath}/etudiant/editEtudiantCours">
		
		<form:label style="margin-bottom:0" path="absence">Présence au cours : </form:label>
		<form:checkbox  class="form-control" path="absence" style="width:30%;"/> 

		<form:label path="motif">Motif de l'absence : </form:label>
		<form:textarea style="margin-bottom:2rem" class="form-control" path="motif"/>
		
		<form:hidden path="idEtudiantCours"/>
		
		<input id="InputSubmit" type="submit" class="btn btn-primary" value="Editer absence">
	
	</form:form>
</div>
	
		<jsp:include page="/Fragments/footer.jsp" />
	
	 <script src="${pageContext.request.contextPath}/assets/scripts/jquery-3.4.1.js"></script>
    <script src="${pageContext.request.contextPath}/assets/scripts/bootstrap.min.js"></script>
</body>
</html>