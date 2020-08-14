<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<<<<<<< HEAD
        <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
        
=======
>>>>>>> 477750f94da984b31404d8fc5b17d4c07e7d3be0
    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Modification d'une promotion</title>
	
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
<div id="TitreForm"><h1><fmt:message key="formmodifpro"/></h1>
    </div>
=======

	<!--  HEADER -->
	<jsp:include page="/Fragments/Header.jsp"/>
	
	<h1 id="TitreForm">Formulaire de modification de la promotion: ${promotionModifCommand.libelle }</h1>
>>>>>>> 477750f94da984b31404d8fc5b17d4c07e7d3be0
    
   
         <form:form enctype="multipart/form-data" modelAttribute="promotionModifCommand" method="POST" 
         action="${pageContext.request.contextPath}/promotion/update">
         
         <form:hidden path="idPromotion"/>

           <div style="width: 80%;margin: auto;">
            <div class="form-row">
                <div class="form-group col-md-5"> 
<<<<<<< HEAD
            <form:label path="libelle"><fmt:message key="11"/></form:label> 
=======
         		  <form:label path="libelle">Libelle : </form:label> 
>>>>>>> 477750f94da984b31404d8fc5b17d4c07e7d3be0
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