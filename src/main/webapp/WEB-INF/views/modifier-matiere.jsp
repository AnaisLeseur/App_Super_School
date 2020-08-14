<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
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

	<!-- HEADER -->
	<jsp:include page="/Fragments/Header.jsp"/>
	
    <h1 id="TitreForm">Formulaire de modification d'une matiere</h1>

        <form:form enctype="multipart/form-data" 
        		modelAttribute="matiereModifCommand" 
        		method="POST" 
        		action="${pageContext.request.contextPath}/matiere/update"> 
     
         <!-- recup de l'id de la matiere a modifier dans un champs caché-->
         <form:hidden path="idMatiere"/>
       
            
           <div style="width: 80%;margin: auto;">
            <div class="form-row">
                <div class="form-group col-md-5">
                 <form:label path="libelle">Libelle : </form:label>
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