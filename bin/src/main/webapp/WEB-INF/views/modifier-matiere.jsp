<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
<div id="TitreForm">
    <h1>Formulaire de modification d'une matiere</h1>
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
         <form:hidden path="idMatiere"/>
         </td>
         </tr>
         
            
             <div style="width: 80%;margin: auto;">
            <div class="form-row">
                <div class="form-group col-md-5">
                 <form:label path="libelle">Libelle : </form:label>
                  <form:input path="libelle" type="text" class="form-control" required="true"
                            pattern="[A-Z][A-Za-z -]+"/>
                  <form:errors path="libelle" cssStyle="color : green; font-style: italic;"/>
                   </div>

				<div class="form-group col-md-2"></div>
                <div class="form-group col-md-5">
              <form:label path="FkEnseignant">FkEnseignant : </form:label> 
               <form:input path="FkEnseignant" type="text" class="form-control" required="true"/> 
                <form:errors path="FkEnseignant" cssStyle="color : blue; font-style: italic;"/>  
              </div>
              </div>
              </div>
              
              <tr>
                 <td>
                  <input id="inputSubmit" type="submit" class="btn btn-primary" value="Modifier">
                 </td>
              </tr>
              
              
       
         
         </form:form>
  


</body>
</html>