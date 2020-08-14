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

<jsp:include page="/Fragments/Header.jsp"/>

<h1><fmt:message key="27"/> : ${promotionBindEtudiant.libelle}</h1>

	<form:form method="POST" modelAttribute="promotionBindEtudiant"
		action="${pageContext.request.contextPath}/promotion/bindEtudiantsToPromotion">

		<table class="table table-striped table-bordered table-hover">

			<thead class="thead-blue">
				<tr>
					<th scope="col">ID <fmt:message key="17"/></th>
					<th scope="col"><fmt:message key="28"/></th>

					<th scope="col"><fmt:message key="29"/></th>
				</tr>

			</thead>

			<tbody>

				<c:forEach items="${liste_Etudiant}" var="etudiant">
					<tr>
						<td>${etudiant.identifiant}</td>
						<td>${etudiant.nom} ${etudiant.prenom}</td>

						<td><form:checkbox path="listeEtudiants"
								value="${etudiant.identifiant}" /></td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
		
		<form:hidden path="idPromotion" />
		<form:hidden path="libelle" />
		
		<input id="InputSubmit" type="submit" class="btn btn-primary"
			value="Attribuer Etudiant(s)" />

	</form:form>
	
	<jsp:include page="/Fragments/footer.jsp" />
	
</body>
</html>