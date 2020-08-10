<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<title>Information sur un enseignant</title>
	<!--  feuille de style -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles/perso.css">
</head>
<body>
	
	<!--  header -->
	<jsp:include page="/Fragments/Header.jsp"/>

	<h1 style="margin-left:50px; margin-top:50px ">Enseignant N°${enseignantVoirCommand.identifiant }</h1>
	<div class="card mb-10" style="max-width: 60%; margin-left:100px" >
		<div class="row no-gutters">
			<div class="col-md-8">
				<div class="card-body">
					<h5 class="card-title">
						<span id=span-nom>${enseignantVoirCommand.nom }</span> <span
							id=span-prenom>${enseignantVoirCommand.prenom }</span>
					</h5>
					<div class="card-text">
						<ul class="list-group list-group-flush">
							<li class="list-group-item">Email : ${enseignantVoirCommand.email }</li>
						</ul>
       				</div>
					
        <c:if test="${enseignantVoirCommand.adresse==null }">
        	<p class="card-text">
				<small class="text-muted"><a href="">Aucune adresse liée ...</a></small>
			</p>
        </c:if>
      </div>
    </div>
  </div>
</div>

	<!-- footer -->
	<jsp:include page="/Fragments/footer.jsp"></jsp:include>

</html>