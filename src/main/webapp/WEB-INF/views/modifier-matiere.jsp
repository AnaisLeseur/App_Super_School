<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<<<<<<< HEAD
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
=======
<!DOCTYPE html>
>>>>>>> 477750f94da984b31404d8fc5b17d4c07e7d3be0
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Modification de la matière</title>
	
	<!-- feuille de style -->
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
<<<<<<< HEAD
<jsp:include page="/Fragments/Header.jsp"/>
<div id="TitreForm">
    <h1><fmt:message key="formmodifmat"/></h1>
    </div>
    
   
         <%--
         > modelAttribute = le nom  de l'objet de commande definit dans la methode afficherFormulaireAjout du controlleur
         
         > à la soumission du formulaire : invocation de la méthode "modifierEmployerBdd"
                                           "EmplpoerController" avec une requete HTTP en post et l'url "/employes/add"
           
         
          --%>
         <form:form enctype="multipart/form-data" modelAttribute="matiereModifCommand" method="POST" 
         action="${pageContext.request.contextPath}/matiere/update">
         
        
         
         <!-- recup de l'id de l'employe a modifier dans un champs caché-->
         <tr>
         <td>
=======

	<!-- HEADER -->
	<jsp:include page="/Fragments/Header.jsp"/>
	
    <h1 id="TitreForm">Formulaire de modification d'une matiere</h1>

        <form:form enctype="multipart/form-data" 
        		modelAttribute="matiereModifCommand" 
        		method="POST" 
        		action="${pageContext.request.contextPath}/matiere/update"> 
     
         <!-- recup de l'id de la matiere a modifier dans un champs caché-->
>>>>>>> 477750f94da984b31404d8fc5b17d4c07e7d3be0
         <form:hidden path="idMatiere"/>
       
            
           <div style="width: 80%;margin: auto;">
            <div class="form-row">
                <div class="form-group col-md-5">
                 <form:label path="libelle"><fmt:message key="11"/></form:label>
                  <form:input path="libelle" type="text" class="form-control" required="true"
                            pattern="[A-Z][A-Za-z -]+"/>
                  <form:errors path="libelle" cssStyle="color : green; font-style: italic;"/>
                   </div>
               
              </div>
             
              <input id="inputSubmit" type="submit" class="btn btn-primary" value="Modifier">
 		
 		</div>
              
         
         </form:form>
  
	
	<!--  Footer  -->
	<jsp:include page="/Fragments/footer.jsp" />
	

</body>
</html>