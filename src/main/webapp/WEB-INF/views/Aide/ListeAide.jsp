<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    
    <link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles/bootstrap.min.css">
	
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles/Liste.css" >
</head>
<body>

<jsp:include page="/Fragments/Header.jsp"/>



	<h1 id="TitreListe">Aide</h1>

	<table class="table table-striped table-bordered table-hover">

		<thead class="thead-blue">

<sec:authorize access="hasRole('ROLE_Admin')">
			<tr>
				<th id="Ajout" colspan="6"><a
					href="${pageContext.request.contextPath}/aide/add-aide-form"><img
						id="LogoAjout"  src="${pageContext.request.contextPath}/assets/images/AjoutFichier.png"><span>Ajouter
							Aide</span></a></th>
			</tr>
</sec:authorize>

			<tr>
				<th scope="col">ID</th>
				<th scope="col">Titre</th>				
				<th scope="col">Consulter</th>
				<sec:authorize access="hasRole('ROLE_Admin')">
					<th scope="col">Modifier</th>
					<th scope="col">Supprimer</th>
				</sec:authorize>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${attribut_liste_aide}" var="aide">
				<tr>
					<td>${aide.aideId}</td>
					<td>${aide.titre}</td>

					<td><a
						href="${pageContext.request.contextPath}/aide/see-aide/${aide.aideId }"><img
							src="${pageContext.request.contextPath}/assets/images/search.svg"></a></td>
					<sec:authorize access="hasRole('ROLE_Admin')">
						<td><a
							href="${pageContext.request.contextPath}/aide/update-aide-form/${aide.aideId}"><img
								src="${pageContext.request.contextPath}/assets/images/pencil.svg"></a></td>
						<td><a
							href="${pageContext.request.contextPath}/aide/delete/${aide.aideId }"><img
								src="${pageContext.request.contextPath}/assets/images/trash.svg"></a></td>
					</sec:authorize>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<jsp:include page="/Fragments/footer.jsp" />

	<script
		src="${pageContext.request.contextPath}/assets/scripts/jquery-3.4.1.js" type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/assets/scripts/bootstrap.min.js" type="text/javascript"></script>


	
</body>
</html>