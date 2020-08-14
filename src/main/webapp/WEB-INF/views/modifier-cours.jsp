<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modification du cours</title>

	<!--  feuille de style -->
	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles/bootstrap.min.css">
	
	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles/FormEtudiant.css">

</head>
<body>

	<!-- Header  -->
	<jsp:include page="/Fragments/Header.jsp" />
	
	<h1 id="TitreForm">Formulaire pour la modification du cours N° ${coursModifCommand.idCours } </h1>

	<br/>

	<form:form enctype="multipart/form-data"
		modelAttribute="coursModifCommand" method="POST"
		action="${pageContext.request.contextPath}/cours/update">

		<!-- recup de l'id de l'employe a modifier dans un champs caché-->
		<form:hidden path="idCours" />

		<div style="width: 80%; margin: auto;">
			<div class="form-row">
				<div class="form-group col-md-5">

					<form:label path="libelle">Libelle : </form:label>
					<form:input path="libelle" type="text" class="form-control"
						required="true" pattern="[A-Z][A-Za-z -]+" />
					<form:errors path="libelle"
						cssStyle="color : red; font-style: italic;" />

				</div>

				<div class="form-group col-md-2"></div>
				<div class="form-group col-md-5">
					<form:label path="description">Description : </form:label>

					<form:textarea path="description" type="text" class="form-control"
						required="true" pattern="[A-Z][A-Za-z -]+" />
					<form:errors path="description"
						cssStyle="color : red; font-style: italic;" />

				</div>
			</div>
			
			<br> 
			
			<div class="form-row">
				<div class="form-group col-md-5">
					<form:label path="duree">Durée : </form:label>

					<form:input path="duree" class="form-control" required="true" />
					<form:errors path="duree"
						cssStyle="color : red; font-style: italic;" />
				</div>

				<div class="form-group col-md-2"></div>
				<div class="form-group col-md-5">
					<form:label path="date">Date : </form:label><br>
					<form:input id="contrainteDate" min="" path="date" type="date"
						required="true" />
					<form:errors path="date"
						cssStyle="color : green; font-style: italic;" />

				</div>
			</div>
			<br> 
			<input id="inputSubmit" type="submit"
				class="btn btn-primary" value="Modifier">
		</div>
	</form:form>
	
	<!--  FOOTER -->
	<jsp:include page="/Fragments/footer.jsp" />
	
	<!--  SCRIPT -->
	<script
		src="${pageContext.request.contextPath}/assets/scripts/jquery-3.4.1.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/scripts/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/scripts/FormCours.js"></script>
</body>
</html>