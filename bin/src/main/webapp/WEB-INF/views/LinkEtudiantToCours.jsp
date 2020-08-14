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
	href="${pageContext.request.contextPath}/assets/styles/Link.css">
	


</head>
<body>

<jsp:include page="/Fragments/Header.jsp"/>

<h1>Attribution d'étudiant au cours ${coursBindEtudiantCours.libelle}</h1>

	<form:form method="POST" modelAttribute="coursBindEtudiantCours"
		action="${pageContext.request.contextPath}/cours/bindEtudiantToCours">

		<table class="table table-striped table-bordered table-hover">

			<thead class="thead-blue">
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Etudiant</th>

					<th scope="col">Attribuer</th>
				</tr>

			</thead>

			<tbody>

				<c:forEach items="${liste_Etudiants}" var="etudiant">
					<tr>
						<td>${etudiant.identifiant}</td>
						<td>${etudiant.nom} ${etudiant.prenom}</td>

						<td><form:checkbox path="listeEtudiantsCours"
								value="${coursBindEtudiantCours.idCours}-${etudiant.identifiant}" /></td>
					</tr>

				</c:forEach>
			</tbody>
		</table>

		<input id="InputSubmit" type="submit" class="btn btn-primary"
			value="Attribuer Etudiant" />

	</form:form>
	
	<jsp:include page="/Fragments/footer.jsp" />
	
</body>
</html>