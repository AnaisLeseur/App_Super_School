<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- ajout de la taglib de spring mvc form --%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
    
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><fmt:message key="14"/></title>
	
	<!-- style css pour la validation -->

	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles/FormEtudiant.css">

</head>
<body>

<c:choose>
<c:when test="${param.lang =='fr'}">
	<fmt:setBundle basename="messages_fr"/>
</c:when>
<c:when test="${param.lang =='en'}">
	<fmt:setBundle basename="messages_en"/>
</c:when>
<c:otherwise>
	<fmt:setBundle basename="messages"/>
</c:otherwise>
</c:choose>

	<!--  HEADER -->
	<jsp:include page="/Fragments/Header.jsp"/>
	
		
		<div id="TitreForm">
			<h1><fmt:message key="15"/></h1>
	    </div>
    
     
         	<form:form enctype="multipart/form-data"  
         				modelAttribute="matiereCommand" 
         				method="POST" 
         				action="${pageContext.request.contextPath}/matiere/add">
         
		         <%-- affichage des erreurs --%>
		         <form:errors path="*" cssClass="erreurs_validation" element="div"/>

           			 <div style="width: 80%;margin: auto;">
            			<div class="form-row">
			                <div class="form-group col-md-5">
				                 <form:label path="libelle"><fmt:message key="11"/></form:label>
				                 <form:input path="libelle" type="text" class="form-control" required="true"
				                            pattern="[A-Z][A-Za-z -]+"/>
				                 <form:errors path="libelle" cssStyle="color : green; font-style: italic;"/>
			                </div>
         			     </div>
 
                  		<input  id="inputSubmit" type="submit" class="btn btn-primary" value="Ajouter">
               		</div>  
			
			<br/>
         	</form:form>
         	
         	          
       <!--  FOOTER  -->  
       <jsp:include page="/Fragments/footer.jsp" />
    
    <!-- SCRIPTS  -->
    <script src="${pageContext.request.contextPath}/assets/scripts/jquery-3.4.1.js"></script>
    <script src="${pageContext.request.contextPath}/assets/scripts/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/scripts/FormEtudiant.js"></script>

</body>
</html>