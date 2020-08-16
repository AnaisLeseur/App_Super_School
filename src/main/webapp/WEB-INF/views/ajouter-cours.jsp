<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- ajout de la taglib de spring mvc form --%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Ajout d'un cours</title>

	<!-- stylecss pour la validation -->
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
	
	<%--
        > modelAttribute = le nom  de l'objet de commande definit dans la methode afficherFormulaireAjout du controlleur
        
        > ï¿½ la soumission du formulaire : invocation de la mï¿½thode "ajouterEmployerBdd"
                                          "EmplpoerController" avec une requete HTTP en post et l'url "/employes/add"
          
        
         --%>
		<h1 id="TitreForm"><fmt:message key="10"/></h1>

		<br/>

		<form:form enctype="multipart/form-data" 
					modelAttribute="coursCommand" 
					method="POST"
					action="${pageContext.request.contextPath}/cours/add">

			<%-- affichage des erreurs --%>
			<form:errors path="*" cssClass="erreurs_validation" element="div" />

 			<div style="width: 80%;margin: auto;">
    	        <div class="form-row">
               		<div class="form-group col-md-5">
			
						<form:label path="libelle"><fmt:message key="11"/> </form:label>
						<form:input path="libelle" type="text" class="form-control" required="true"
	                            pattern="[A-Z][A-Za-z -]+"/>
						<form:errors path="libelle"
								cssStyle="color : red; font-style: italic;" />

					</div>

				<div class="form-group col-md-2"></div>
                
                <div class="form-group col-md-5">
                	<form:label path="description">Description : </form:label>
					
					<form:textarea path="description" type="text" class="form-control" required="true"
                            pattern="[A-Z][A-Za-z -]+" />
					<form:errors path="description"
							cssStyle="color : red; font-style: italic;" />

				</div>
			</div>
			
			<br>
			
 			<div class="form-row">
                <div class="form-group col-md-5">
					<form:label path="duree"><fmt:message key="12"/>: </form:label>
					
					<form:input path="duree"  class="form-control" required="true"/>
					<form:errors path="duree"
							cssStyle="color : red; font-style: italic;" />
				</div>
				
				<div class="form-group col-md-2"></div>
                <div class="form-group col-md-5">
					<form:label path="date">Date: </form:label><br>
           			<form:input id="contrainteDate" type="date" path="date" 
           						min="" required="true" />
           			<form:errors path="date" cssStyle="color : green; font-style: italic;" />

				</div>	
			</div>
			
			
			
			<form:label id="inputFile" path="listeUploadedExercice">Exercice(s) : </form:label>
            <form:input  type="file" accept=".pdf" path="listeUploadedExercice" multiple="true"/>
			
			<br>
			
			<input id="inputSubmit" type="submit" class="btn btn-primary" value="<fmt:message key="13"/>">

		</div>
	</form:form>
 	
 	<!-- footer -->
	<jsp:include page="/Fragments/footer.jsp"></jsp:include> 
	
 	<!-- script -->
 	<script src="${pageContext.request.contextPath}/assets/scripts/jquery-3.4.1.js"></script>
    <script src="${pageContext.request.contextPath}/assets/scripts/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/scripts/FormCours.js"></script>	

</body>
</html>