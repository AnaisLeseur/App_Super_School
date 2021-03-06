<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- ajout de la taglib de spring mvc form --%>
<%@taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles/FormEtudiant.css">

<style type="text/css">
.erreurs_validation{color: red; 
font-style: italic; 
border: 1px dotted red; 
margin: 15px;}

</style>
</head>
<body>

<jsp:include page="/Fragments/Header.jsp"/>

<h1 id="TitreForm">Formulaire d'ajout d'un Etudiant</h1>

	
	<form:form enctype="multipart/form-data" modelAttribute="etudiantAddCommand" method="POST"
        action="${pageContext.request.contextPath}/etudiant/add">
        <div style="width: 80%;margin: auto;">
            <div class="form-row">
                <div class="form-group col-md-5">
                    <form:label path="nom">Nom</form:label>
                        <form:input type="text" class="form-control" path="nom" required="true"
                            pattern="[A-Z][A-Za-z -]+"/>
                </div>
                <div class="form-group col-md-2"></div>
                <div class="form-group col-md-5">
                    <form:label path="prenom">Prénom</form:label>
                        <form:input type="text" class="form-control" path="prenom" required="true"
                            pattern="[A-Z][A-Za-z -]+"/>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-5">
                    <form:label path="email">Email</form:label>
                        <form:input type="text" class="form-control" path="email" required="true"/>
                </div>
                <div class="form-group col-md-2"></div>
                <div class="form-group col-md-5">
                    <form:label path="motDePasse">Mot de Passe</form:label>
                    <form:input id="champPassword" type="password" class="form-control" path="motDePasse"
                            required="true"/>
                    <a onclick="changeTypeInput(event)" href="#" style="color: #4db3e9 ;">Afficher/Masquer</a>
                </div>
            </div>

            <form:label path="dateNaissance">Date de Naissance : </form:label>
            <form:input id="contrainteDate" type="date" path="dateNaissance" max="" required="true" />
            <form:errors path="dateNaissance" cssStyle="color : green; font-style: italic;" />

            <form:label id="inputFile" path="uploadedPhoto">Photo : </form:label>
            <form:input  type="file" accept=".png, .jpg, .jpeg, .svg" path="uploadedPhoto" required="true" />

            <div id="adresseForm">Adresse (optionnelle)</div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <form:label path="adresse.rue">Rue</form:label>
                        <form:input type="text" class="form-control" path="adresse.rue" pattern="[0-9]{1,3}[ ][A-Za-z' -]+"/>
                </div>
                <div class="form-group col-md-4">
                    <form:label path="adresse.ville">Ville</form:label>
                        <form:input type="text" class="form-control" path="adresse.ville" patern="[A-Z][A-Za-z' -]+"/>
                        
                </div>
                <div class="form-group col-md-2">
                    <form:label path="adresse.codePostal">Code Postal</form:label>
                        <form:input type="text" class="form-control" path="adresse.codePostal" pattern="[0-9]{5}"/>
                </div>
            </div>

            <input id="inputSubmit" type="submit" class="btn btn-primary" value="Ajouter Etudiant"/>
        </div>
    </form:form>
	
	<jsp:include page="/Fragments/footer.jsp" />
	
    <script src="${pageContext.request.contextPath}/assets/scripts/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/scripts/FormEtudiant.js"></script>

</body>
</html>