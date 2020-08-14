<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles/FormEtudiant.css">
</head>
<body>

	<jsp:include page="/Fragments/Header.jsp" />
	<div id="TitreForm">
		<h1>Formulaire de modification d'un cours</h1>
	</div>


	<form:form enctype="multipart/form-data"
		modelAttribute="coursModifCommand" method="POST"
		action="${pageContext.request.contextPath}/cours/update">



		<!-- recup de l'id de l'employe a modifier dans un champs caché-->
		
			<td><form:hidden path="idCours" /></td>
		



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

					<form:input path="description" type="text" class="form-control"
						required="true" pattern="[A-Z][A-Za-z -]+" />
					<form:errors path="description"
						cssStyle="color : red; font-style: italic;" />

				</div>
			</div>
			<br> <br> <br>
			<div class="form-row">
				<div class="form-group col-md-5">
					<form:label path="duree">Durée : </form:label>

					<form:input path="duree" class="form-control" required="true" />
					<form:errors path="duree"
						cssStyle="color : red; font-style: italic;" />
				</div>

				<div class="form-group col-md-2"></div>
				<div class="form-group col-md-5">
					<form:label path="date">Date : </form:label>
					<form:input id="contrainteDate" min="" path="date" type="date"
						required="true" />
					<form:errors path="date"
						cssStyle="color : green; font-style: italic;" />

				</div>
			</div>
			<br> <br> <br> <input id="inputSubmit" type="submit"
				class="btn btn-primary" value="Modifier">
		</div>
	</form:form>
	<script
		src="${pageContext.request.contextPath}/assets/scripts/jquery-3.4.1.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/scripts/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/scripts/FormCours.js"></script>
</body>
</html>