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
    
     <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
  
 <link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles/FormAide.css">
	
		<link rel="stylesheet" 
	href="${pageContext.request.contextPath}/assets/styles/perso.css">
</head>
<body>

<jsp:include page="/Fragments/Header.jsp"/>

<h1>Ajout d'une aide</h1>

<div id="contenuForm">

<form:form modelAttribute="aideAddCommand" method="POST" action="${pageContext.request.contextPath}/aide/add">

	<form:label path="titre">Titre : </form:label>
	<form:input class="form-control" type="text" path="titre"/>
	
	<br/> <br/>
	
	<form:label path="contenu">Editez votre contenu :</form:label>
 	<form:textarea id="summernote" path="contenu"></form:textarea>
 	<input id="inputSubmit" type="submit" class="btn btn-primary" value="Ajouter Aide"/>
</form:form>
</div>
<script>
    $(document).ready(function() {
        $('#summernote').summernote();
    });
  </script>
  
  <jsp:include page="/Fragments/footer.jsp" />
	
</body>
</html>