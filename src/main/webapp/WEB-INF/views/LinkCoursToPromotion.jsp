<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!--  ajout de la taglib de spring mvc 'form' -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	
</head>
<body>

<jsp:include page="/Fragments/Header.jsp"/>

<<<<<<< HEAD
 <h1><fmt:message key="25"/></h1>
=======

 <h1 id="TitreListe">Choisir les cours de la promotion N° ${promotionBindCours.idPromotion }:  ${promotionBindCours.libelle }  </h1>
>>>>>>> 477750f94da984b31404d8fc5b17d4c07e7d3be0
 <br/>

	<form:form method="POST" modelAttribute="promotionBindCours"
		action="${pageContext.request.contextPath}/promotion/bindCoursToPromotion">

		<table class="table table-striped table-bordered table-hover">

			<thead class="thead-blue">
				<tr>
<<<<<<< HEAD
					<th scope="col">ID Cours</th>
					<th scope="col"><fmt:message key="11"/></th>

=======
					<th scope="col">Identifiant du Cours</th>
					<th scope="col">Libelle</th>
>>>>>>> 477750f94da984b31404d8fc5b17d4c07e7d3be0
					<th scope="col">Description</th>
					<th scope="col"><fmt:message key="12"/></th>
					<th scope="col">Date</th>
					<th scope="col"><fmt:message key="26"/></th>
					
				</tr>

			</thead>

			<tbody>

				<c:forEach items="${liste_Cours}" var="cours">
					<tr>
						<td>${cours.idCours}</td>
						<td>${cours.libelle}</td>
                        <td>${cours.description}</td>
                        <td>${cours.duree}</td>
                        <td>${cours.date}</td>
						<td>
							<form:checkbox path="listeCours"
								value="${cours.idCours}" />
							
						</td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
		
		<form:hidden path="idPromotion" />
		<form:hidden path="libelle" />
		
		<button id="inputSubmitBtn" class="btn btn-primary" type="submit">Attribuer Cours</button>

	</form:form>
	
	<jsp:include page="/Fragments/footer.jsp" />
	
</body>
</html>