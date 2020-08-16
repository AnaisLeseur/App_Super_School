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


 <h1 id="TitreListe"><fmt:message key="25"/> ${promotionBindCours.idPromotion }:  ${promotionBindCours.libelle }  </h1>

 <br/>

	<form:form method="POST" modelAttribute="promotionBindCours"
		action="${pageContext.request.contextPath}/promotion/bindCoursToPromotion">

		<table class="table table-striped table-bordered table-hover">

			<thead class="thead-blue">
				<tr>
					<th scope="col">Identifiant du Cours</th>
					<th scope="col"><fmt:message key="11"/></th>
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
		
		<button id="inputSubmitBtn" class="btn btn-primary" type="submit" style="width: auto;">Attribuer Cours</button>

	</form:form>
	
	<jsp:include page="/Fragments/footer.jsp" />
	
</body>
</html>