<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
        <%-- ajout de la taglib de spring mvc form --%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- stylecss pour la validation -->

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
<div id="TitreForm"><h1>Formulaire d'une matiere à ajouter</h1>
    </div>
    
     
         <form:form enctype="multipart/form-data"  modelAttribute="matiereCommand" method="POST" 
         action="${pageContext.request.contextPath}/matiere/add">
         
         
         <%-- affichage des erreurs --%>
         <form:errors path="*" cssClass="erreurs_validation" element="div"/>
         
         
              
              
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
              
                  <input  id="inputSubmit" type="submit" class="btn btn-primary" value="Ajouter">
                 
              
              
        
         
         </form:form>
    
     <script src="${pageContext.request.contextPath}/assets/scripts/jquery-3.4.1.js"></script>
    <script src="${pageContext.request.contextPath}/assets/scripts/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/scripts/FormEtudiant.js"></script>

</body>
</html>