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
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles/bootstrap.min.css">
	
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles/seeAide.css">
</head>
<body>

<jsp:include page="/Fragments/Header.jsp"/>

<h1 id="TitreSeeAide">Aide : ${aideSeeCommand.titre }</h1>

<br/>

<div id="contenuSeeAide">${aideSeeCommand.contenu }</div>

<jsp:include page="/Fragments/footer.jsp" />

	<script
		src="${pageContext.request.contextPath}/assets/scripts/jquery-3.4.1.js" type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/assets/scripts/bootstrap.min.js" type="text/javascript"></script>
	
</body>
</html>