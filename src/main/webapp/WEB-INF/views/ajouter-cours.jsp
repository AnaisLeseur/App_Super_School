<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%-- ajout de la taglib de spring mvc form --%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- stylecss pour la validation -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles/FormEtudiant.css">
<style type="text/css">
.erreurs_validation {
	color: red;
	font-style: italic;
	border: 1px dotted red;
	margin: 15px;
}
</style>
</head>
<body>
<jsp:include page="/Fragments/Header.jsp"/>
<div id="TitreForm">
		<h1>Formulaire d'un cours � ajouter</h1>
	</div>


	
		<%--
         > modelAttribute = le nom  de l'objet de commande definit dans la methode afficherFormulaireAjout du controlleur
         
         > � la soumission du formulaire : invocation de la m�thode "ajouterEmployerBdd"
                                           "EmplpoerController" avec une requete HTTP en post et l'url "/employes/add"
           
         
          --%>
		<form:form enctype="multipart/form-data" modelAttribute="coursCommand" method="POST"
			action="${pageContext.request.contextPath}/cours/add">


			<%-- affichage des erreurs --%>
			<form:errors path="*" cssClass="erreurs_validation" element="div" />

 <div style="width: 80%;margin: auto;">
            <div class="form-row">
                <div class="form-group col-md-5">
			
					<form:label path="libelle">Libelle : </form:label>
					<form:input path="libelle" type="text" class="form-control" required="true"
                            pattern="[A-Z][A-Za-z -]+"/>
					<form:errors path="libelle"
							cssStyle="color : red; font-style: italic;" />

				</div>

				<div class="form-group col-md-2"></div>
                <div class="form-group col-md-5">
                <form:label path="description">Description : </form:label>
					
					<form:input path="description" type="text" class="form-control" required="true"
                            pattern="[A-Z][A-Za-z -]+" />
					<form:errors path="description"
							cssStyle="color : red; font-style: italic;" />

				</div>
				</div>
				<br><br><br>
 <div class="form-row">
                <div class="form-group col-md-5">
				<form:label path="duree">duree : </form:label>
					
					<form:input path="duree"  class="form-control" required="true"/>
					<form:errors path="duree"
							cssStyle="color : red; font-style: italic;" />
				</div>
				
				 <div class="form-group col-md-2"></div>
                <div class="form-group col-md-5">
				<form:label path="date">Date: </form:label>
            <form:input id="contrainteDate" type="date" path="date" max="" required="true" />
            <form:errors path="date" cssStyle="color : green; font-style: italic;" />

				</div>
				</div>
				<br><br><br>
				
					<input id="inputSubmit" type="submit" class="btn btn-primary" value="Ajouter">
				


			</div>

		</form:form>
 <script src="${pageContext.request.contextPath}/assets/scripts/jquery-3.4.1.js"></script>
    <script src="${pageContext.request.contextPath}/assets/scripts/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/scripts/FormEtudiant.js"></script>	

</body>
</html>