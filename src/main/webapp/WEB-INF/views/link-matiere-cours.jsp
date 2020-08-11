<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
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
		Liste des cours associés à la matière selectionnée: 
	</h1>

		<table class="table table-striped table-bordered table-hover">

			<thead class="thead-blue">
				<tr>
					<th scope="col">Identifiant du cours</th>
					<th scope="col">Libelle</th>
				</tr>

			</thead>

			<tbody>

				<c:forEach items="${listeCoursAssocMatiere}" var="cours">
					<tr>
						<td>${cours.identifiant}</td>
						<td>${cours.libelle}</td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
		
	
	<jsp:include page="/Fragments/footer.jsp" />


</body>
</html>