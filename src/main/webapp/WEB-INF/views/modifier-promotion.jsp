<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<div id="TitreForm"><h1>Formulaire de modification d'une promotion</h1>
    </div>
    
   
         <form:form enctype="multipart/form-data" modelAttribute="promotionModifCommand" method="POST" 
         action="${pageContext.request.contextPath}/promotion/update">
         
        
         
         <!-- recup de l'id de l'employe a modifier dans un champs caché-->
         <tr>
         <td>
         <form:hidden path="idPromotion"/>
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