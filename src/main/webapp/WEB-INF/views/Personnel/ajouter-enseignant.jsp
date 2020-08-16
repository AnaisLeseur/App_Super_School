<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
 <!--  ajout de la taglib de spring mvc 'form' -->
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
 
<!DOCTYPE html>
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Ajout d'un enseignant</title>

	<!-- feuilles de styles -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles/FormEtudiant.css">


</head>
<body>

	<!-- Header -->
	<jsp:include page="/Fragments/Header.jsp"/>


	<h1 id="TitreForm">Formulaire d'ajout d'un enseignant</h1>
	
	<%-- affichage des tous les msg d'erreur  --%>
	<form:errors path="*" cssClass="erreurs_validation" element="div"/>

	
		<form:form 	modelAttribute="enseignantCommand" 
					method="POST" 
					action="${pageContext.request.contextPath}/enseignants/add">
					
        <div style="width: 80%; margin: auto;">
            <div class="form-row">
                <div class="form-group col-md-5">
                    <form:label path="nom">Nom</form:label>
                        <form:input type="text" class="form-control" path="nom" required="true"
                            		pattern="[A-Z][A-Za-z -]+" placeholder="Nom"/>
                </div>
                
                <div class="form-group col-md-8"></div>
                
                <div class="form-group col-md-5">
                    <form:label path="prenom">Prénom</form:label>
                        <form:input type="text" class="form-control" path="prenom" required="true"
                            		pattern="[A-Z][A-Za-z -]+" placeholder="Prenom"/>
                </div>
                
                <div class="form-group col-md-8"></div>

                <div class="form-group col-md-5">
                    <form:label path="email">Email</form:label>
                        <form:input type="text" class="form-control" path="email" required="true"
                       				 placeholder="email@mail.com" />
                </div>

                <div class="form-group col-md-8"></div>
                
                <div class="form-group col-md-5">
                    <form:label path="motDePasse">Mot de Passe</form:label>
                    <form:input id="champPassword" type="password" class="form-control" path="motDePasse"
                           		 required="true" placeholder="Mot de Passe"/>
                    <a onclick="changeTypeInput(event)" href="#" style="color: #4db3e9 ;">Afficher/Masquer</a>
                </div>
            </div>

          	<br/> 
          	
            <div id="adresseForm">Adresse (optionnelle)</div>
            <div class="form-row">
                <div class="form-group col-md-5">
                    <form:label path="adresse.rue">Rue</form:label>
                        <form:input type="text" class="form-control" path="adresse.rue" 
                        			pattern="[0-9]{1,3}[ ][A-Za-z' -]+" placeholder="123 rue de la republique" />
                </div>
                
                <div class="form-group col-md-8"></div>
                
                <div class="form-group col-md-5">
                    <form:label path="adresse.codePostal">Code Postal</form:label>
                        <form:input type="text" class="form-control" path="adresse.codePostal" 
                        			pattern="[0-9]{5}" placeholder="12345"/>
                </div>
                
                <div class="form-group col-md-8"></div>
                
                <div class="form-group col-md-5">
                    <form:label path="adresse.ville">Ville</form:label>
                        <form:input type="text" class="form-control" path="adresse.ville" 
                        			patern="[A-Z][A-Za-z' -]+" placeholder="Ville"/>
                        
                </div>
               
            </div>

            <button id="inputSubmit" class="btn btn-primary" type="submit" style="width: auto;">Ajouter l'Enseignant</button>
        </div>
    </form:form>
	
	
	<!--  Footer  -->
	<jsp:include page="/Fragments/footer.jsp" />
	
	
	<!--  Script JS -->
	<script src="${pageContext.request.contextPath}/assets/scripts/jquery-3.4.1.js"></script>
    <script src="${pageContext.request.contextPath}/assets/scripts/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/scripts/FormEtudiant.js"></script>


</body>
</html>