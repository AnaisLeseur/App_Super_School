<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles/bootstrap.min.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles/Liste.css">
	
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles/Header.css">

</head>
<body>

<jsp:include page="/Fragments/Header.jsp"/>


	<form:form method="POST" modelAttribute="etudiantBindPromo"
		action="${pageContext.request.contextPath}/promotion/bindPromotionToEtudiant">

		<table class="table table-striped table-bordered table-hover">

			<thead class="thead-blue">
				<tr>
					<th scope="col">Id Promotion</th>
					<th scope="col">Libelle</th>

					<th scope="col">Attribuer</th>
				</tr>

			</thead>

			<tbody>

				<c:forEach items="${liste_Promotion}" var="promotion">
					<tr>
						<td>${promotion.idPromotion}</td>
						<td>${promotion.libelle}</td>

						<td><form:checkbox path="listePromotions"
								value="${promotion.idPromotion}" /></td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
		
		<form:hidden path="identifiant" />
		<form:hidden path="motDePasse" />
		<form:hidden path="nom" />
		<form:hidden path="prenom" />
		<form:hidden path="email" />

		<form:hidden path="adresse.idAdresse" />
		<form:hidden path="adresse.rue" />
		<form:hidden path="adresse.ville" />
		<form:hidden path="adresse.codePostal" />

		<form:hidden path="dateNaissance" />
		<form:hidden path="photo" />


		<input type="submit" class="btn btn-primary"
			value="Attribuer Promotion(s)" />

	</form:form>
	
	<jsp:include page="/Fragments/footer.jsp" />

</body>
</html>