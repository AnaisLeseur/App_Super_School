<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles/bootstrap.min.css">
	
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles/FormEJ.css">
</head>
<body>

	<jsp:include page="/Fragments/Header.jsp" />
	
	<h1><fmt:message key="24"/></h1>
	
	<form:form modelAttribute="enseigneJointureEditCommand" method="POST" action="${pageContext.request.contextPath}/enseigneJointure/updateEJ">

<div class="form-row">
	<form:label class="LabelForm" path="enseignantEJ.identifiant"><fmt:message key="21"/></form:label>
	<form:select class="SelectForm" path="enseignantEJ.identifiant">
		<form:option value="0" label="--- Select ---" />
		<form:options items="${attribut_listeEnseignants}"
			itemValue="identifiant" itemLabel="nom" />
	</form:select>
</div>

<div class="form-row">
	<form:label class="LabelForm" path="matiereEJ.idMatiere"><fmt:message key="22"/></form:label>
	<form:select class="SelectForm" path="matiereEJ.idMatiere">
		<form:option value="0" label="--- Select ---" />
		<form:options items="${attribut_listeMatieres}" itemValue="idMatiere"
			itemLabel="libelle" />
	</form:select>
 </div>
 
 <div class="form-row">
	<form:label class="LabelForm" path="promotionEJ.idPromotion"><fmt:message key="23"/></form:label>
	<form:select class="SelectForm" path="promotionEJ.idPromotion">
		<form:option value="0" label="--- Select ---" />
		<form:options items="${attribut_listePromotions}"
			itemValue="idPromotion" itemLabel="libelle" />
	</form:select>
</div>

	<form:hidden path="idEnseigneJointure"/>
	<input id="inputSubmit" type="submit" class="btn btn-primary" value="Modifier">
	<form:errors path="*" />
	
	</form:form>
	
	<jsp:include page="/Fragments/footer.jsp"></jsp:include>
	
</body>
</html>