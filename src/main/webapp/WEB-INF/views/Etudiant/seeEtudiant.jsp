<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles/bootstrap.min.css">
	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles/SeeEtudiant.css" >
</head>
<body>
<jsp:include page="/Fragments/Header.jsp"/>


    <h1 id="TitreIdEtudiant">Etudiant N°${etudiantSeeCommand.identifiant }</h1>
    
    <div id="ModifierEtudiant"> <a href="${pageContext.request.contextPath}/etudiants/update-etudiant-form/${etudiantSeeCommand.identifiant }"> Modifier <img  src="${pageContext.request.contextPath}/assets/images/arrow-counterclockwise.svg" ></a></div>
    
        <div id="DivInfosEtudiant">
        

            <img id="PhotoEtudiant" src="${pageContext.request.contextPath}/assets/images/photos/${etudiantSeeCommand.photo }" >

            <div>
                <div class="infosEtudiant">
                    <h2>Identité : </h2>
                    <p><span>${etudiantSeeCommand.nom }</span> ${etudiantSeeCommand.prenom }</p>
                </div>

                <div class="infosEtudiant">
                    <h2>Email : </h2>
                    <p>${etudiantSeeCommand.email }</p>
                </div>

                <div class="infosEtudiant">
                    <h2>Date de Naissance : </h2>
                    <p>${etudiantSeeCommand.dateNaissance }</p>
                </div>
                
                <div class="Adresse">Adresse :</div>
                
                <c:if test="${empty etudiantSeeCommand.adresse.rue and empty etudiantSeeCommand.adresse.ville and empty etudiantSeeCommand.adresse.codePostal }">
                	<a class="Adresse" href="${pageContext.request.contextPath}/etudiants/update-etudiant-form/${etudiantSeeCommand.identifiant}">Aucune adresse liée, veuillez ajouter une adresse</a>
				</c:if>
                
				<c:if test="${not empty etudiantSeeCommand.adresse }">
                	<div id="infosAdresse">${etudiantSeeCommand.adresse.rue} ${etudiantSeeCommand.adresse.ville} ${etudiantSeeCommand.adresse.codePostal}</div>
				</c:if>
				
				
				
				
				<%--<div >Promotions :</div>
                
                <c:if test="${empty etudiantSeeCommand.listePromotions}">
                	<a class="Adresse" href="${pageContext.request.contextPath}/etudiants/update-etudiant-form/${etudiantSeeCommand.identifiant}">Aucune adresse liée, veuillez ajouter une adresse</a>
				</c:if>
				<c:otherwise>
				<p>if marche pas</p>
				</c:otherwise>
                
				<c:if test="${not empty etudiantSeeCommand.adresse }">
                	<div id="infosAdresse">${etudiantSeeCommand.adresse.rue} ${etudiantSeeCommand.adresse.ville} ${etudiantSeeCommand.adresse.codePostal}</div>
				</c:if>
				 --%>
            </div>

        </div>

</body>
</html>