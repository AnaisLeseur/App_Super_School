<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>

    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
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

<c:choose>
<c:when test="${param.lang == 'fr'}">
	<fmt:setBundle basename="messages_fr"/>
</c:when>
<c:when test="${param.lang == 'en'}">
	<fmt:setBundle basename="messages_en"/>
</c:when>
<c:otherwise>
	<fmt:setBundle basename="messages"/>
</c:otherwise>
</c:choose>

<jsp:include page="/Fragments/Header.jsp"/>
<div id="TitreForm"><h1><fmt:message key="formmodifpro"/>: ${promotionModifCommand.libelle }</h1>
    </div>

    
   
         <form:form enctype="multipart/form-data" modelAttribute="promotionModifCommand" method="POST" 
         action="${pageContext.request.contextPath}/promotion/update">
         
         <form:hidden path="idPromotion"/>

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