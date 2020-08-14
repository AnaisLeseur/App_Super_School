<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
 
    
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<title>Insert title here</title>
	
    <link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles/bootstrap.min.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles/Liste.css">
	
	
</head>

<body>


<jsp:include page="/Fragments/Header.jsp"/>


	<h1 id="TitreListe">
		<fmt:message key="31"/>
	</h1>

		<table class="table table-striped table-bordered table-hover">

			<thead class="thead-blue">
				<tr>
					<th scope="col">ID <fmt:message key="cours"/></th>
					<th scope="col"><fmt:message key="11"/></th>
					<th scope="col">Description</th>
					<th scope="col"><fmt:message key="12"/></th>
					<th scope="col">Date</th>
					<th scope="col"><fmt:message key="23"/></th>
				</tr>

			</thead>

			<tbody>

				<c:forEach items="${listeCoursAssocMatiere}" var="cours">
					<tr>
						<td>${cours.idCours}</td>
						<td>${cours.libelle}</td>
						<td>${cours.description}</td>
						<td>${cours.duree}</td>
						<td>${cours.date}</td>
						<td> <!--  ${cours.promotion} --></td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
		
	
	<jsp:include page="/Fragments/footer.jsp" />


</body>
</html>