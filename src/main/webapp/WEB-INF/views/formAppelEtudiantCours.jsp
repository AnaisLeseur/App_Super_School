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
    <title>Gestion des Absences</title>
    
    <!--  feuilles de styles  -->
	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles/bootstrap.min.css">

	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles/Liste.css">
	
	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles/Link.css">
	

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
	
	
	<h1 id="TitreIdCours">Gestion des absences pour le cours N°${AppelEtudiantCommand.idCours }</h1>

	<form:form method="POST" modelAttribute="AppelEtudiantCommand"
		action="${pageContext.request.contextPath}/cours/AppelEtudiantsFromCours">

		<table class="table table-striped table-bordered table-hover">

			<thead class="thead-blue">

						<tr>
							<th scope="col">ID</th>
							<th scope="col">Etudiant</th>
							<th scope="col">Appel <br/> (Présent = coché)</th>
							<th scope="col">Motif</th>
						</tr>

					</thead>

					<tbody>

				<c:forEach items="${AppelEtudiantCommand.listeEtudiantsCours}" var="etudiantCours">
					<tr>
						<td>${etudiantCours.etudiantEC.identifiant}</td>
						<td>${etudiantCours.etudiantEC.nom} ${etudiantCours.etudiantEC.prenom}</td>
						
						<form:hidden path="listeEtudiantsCours" value="${etudiantCours.idEtudiantCours}" />
						
						<td>
							<input type="hidden" name="checkboxAbsence" value="0"><input type="checkbox" onclick="this.previousSibling.value=1-this.previousSibling.value">
						</td>
						
						<td><textarea class="form-control" name="motif" ></textarea></td>
						<%--solution : <input type="hidden" name="checkboxName" value="0"><input type="checkbox" onclick="this.previousSibling.value=1-this.previousSibling.value"> --%>
					</tr>
					
				</c:forEach>
								
			</tbody>
		</table>

		<input id="InputSubmit" type="submit" class="btn btn-primary"
			value="Terminer l'appel" />

	</form:form>

	<br/>
	
	<!--  FOOTER -->
	<jsp:include page="/Fragments/footer.jsp" />
	
</body>
</html>