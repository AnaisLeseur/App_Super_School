<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles/bootstrap.min.css">
	
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles/Liste.css" >
</head>
<body>

<jsp:include page="/Fragments/Header.jsp"/>




	<h1 id="TitreListe">Liste des étudiants</h1>


	<%-- 
	 <c:choose>
    <c:when test="${sessionScope.test eq 'test1'}">
    	<c:url value="Fragments/Test1.jsp" var="test"/>
       <jsp:include page="/Fragments/Test1.jsp"/>
    </c:when>
    
</c:choose>
--%>


	<table class="table table-striped table-bordered table-hover">

		<thead class="thead-blue">

			<tr>
				<th id="Ajout" colspan="8"><a
					href="${pageContext.request.contextPath}/etudiants/add-etudiant-form"><img
						id="LogoAjout"  src="${pageContext.request.contextPath}/assets/images/person-plus.svg"><span>Ajouter
							Etudiant</span></a></th>
			</tr>

			<tr>
				<th scope="col">ID</th>
				<th scope="col">Nom</th>
				<th scope="col">Prenom</th>
				<th scope="col">Email</th>
				<th scope="col">Date de Naissance</th>

				<th scope="col">Consulter</th>
				<th scope="col">Modifier</th>
				<th scope="col">Supprimer</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${attribut_listeEtudiants}" var="et">
				<tr>
					<td>${et.identifiant }</td>
					<td>${et.nom }</td>
					<td>${et.prenom }</td>
					<td>${et.email }</td>
					<td>${et.dateNaissance }</td>

					<td><a
						href="${pageContext.request.contextPath}/etudiant/see-etudiant/${et.identifiant }"><img
							src="${pageContext.request.contextPath}/assets/images/search.svg"></a></td>
					<td><a
						href="${pageContext.request.contextPath}/etudiants/update-etudiant-form/${et.identifiant }"><img
							src="${pageContext.request.contextPath}/assets/images/pencil.svg"></a></td>
					<td><a
						href="${pageContext.request.contextPath}/etudiants/delete/${et.identifiant }"><img
							src="${pageContext.request.contextPath}/assets/images/trash.svg"></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<script
		src="${pageContext.request.contextPath}/assets/scripts/jquery-3.4.1.js" type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/assets/scripts/bootstrap.min.js" type="text/javascript"></script>



</body>
</html>