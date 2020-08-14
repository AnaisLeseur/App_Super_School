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
<br/>

 <h1><fmt:message key="32"/> ${idCours} </h1>
 <br/>

	<form:form method="POST" modelAttribute="coursBindPromo"
		action="${pageContext.request.contextPath}/promotion/bindPromotionToCours">

		<table class="table table-striped table-bordered table-hover">

			<thead class="thead-blue">
				<tr>
					<th scope="col">Id <fmt:message key="23"/></th>
					<th scope="col"><fmt:message key="11"/></th>

					<th scope="col"><fmt:message key="29"/></th>
				</tr>

			</thead>

			<tbody>

				<c:forEach items="${liste_Promotion}" var="promotion">
					<tr>
						<td>${promotion.idPromotion}</td>
						<td>${promotion.libelle}</td>

						<td>
						
						<form:checkbox path="promotion"
								value="${promotion.idPromotion}" />
								
						</td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
		
		<form:hidden path="idCours" />


		<input type="submit" class="btn btn-primary"
			value="Attribuer Promotion(s)" />

	</form:form>
	
	<jsp:include page="/Fragments/footer.jsp" />

</body>
</html>