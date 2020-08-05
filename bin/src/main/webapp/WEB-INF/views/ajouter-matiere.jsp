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
<style type="text/css">
.erreurs_validation{color: red; 
font-style: italic; 
border: 1px dotted red; 
margin: 15px;}

</style>
</head>
<body>

<div align="center">
    <h1>Formulaire d'une matiere à ajouter</h1>
    </div>
    
     <div align="center">
         <%--
         > modelAttribute = le nom  de l'objet de commande definit dans la methode afficherFormulaireAjout du controlleur
         
         > à la soumission du formulaire : invocation de la méthode "ajouterEmployerBdd"
                                           "EmplpoerController" avec une requete HTTP en post et l'url "/employes/add"
           
         
          --%>
         <form:form modelAttribute="matiereCommand" method="POST" 
         action="${pageContext.request.contextPath}/matiere/add">
         
         
         <%-- affichage des erreurs --%>
         <form:errors path="*" cssClass="erreurs_validation" element="div"/>
         
         <table width="60%">
              
              
              <tr>
                  <td> <form:label path="libelle">libelle : </form:label> </td>
                  <td> <form:input path="libelle"/> </td>
               <td> <form:errors path="libelle" cssStyle="color : green; font-style: italic;"/>  </td>
                  
              </tr>
              
              <tr>
                  <td> <form:label path="FkEnseignant">FkEnseignant : </form:label> </td>
                  <td> <form:input path="FkEnseignant"/> </td>
                  <td> <form:errors path="FkEnseignant" cssStyle="color : blue; font-style: italic;"/>  </td>
                  
              </tr>
              
              <tr>
                 <td>
                  <input type="submit" value="Ajouter">
                 </td>
              </tr>
              
              
         </table>
         
         </form:form>
    </div>
    

</body>
</html>