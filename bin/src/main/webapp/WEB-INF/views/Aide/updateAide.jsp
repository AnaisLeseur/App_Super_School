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
</head>
<body>

<form:form modelAttribute="aideModifCommand" method="POST" action="${pageContext.request.contextPath}/aide/update">

	<form:label path="titre">Titre</form:label>
	<form:input type="text" path="titre"/>
	<br/>
	
	<form:label path="contenu">Editez le contenu de la page d'aide</form:label>
	<br/>
 	<form:textarea id="summernote" path="contenu"></form:textarea>
 	<input id="inputSubmit" type="submit" class="btn btn-primary" value="Ajouter Aide"/>
</form:form>

<script>
    $(document).ready(function() {
        $('#summernote').summernote();
    });
  </script>
</body>
</html>