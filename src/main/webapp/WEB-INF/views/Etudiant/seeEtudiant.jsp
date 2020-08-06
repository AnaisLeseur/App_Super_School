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
</head>
<body>
	<h1>Etudiant N°${etudiantSeeCommand.identifiant }</h1>
	<div class="card mb-10" style="max-width: 75%">
		<div class="row no-gutters">
			<div class="col-md-4">
				<img
					src="${pageContext.request.contextPath}/assets/images/photos/${etudiantSeeCommand.photo }"
					class="card-img">
			</div>
			<div class="col-md-8">
				<div class="card-body">
					<h5 class="card-title">
						<span id=span-nom>${etudiantSeeCommand.nom }</span> <span
							id=span-prenom>${etudiantSeeCommand.prenom }</span>
					</h5>
					<div class="card-text">
						<ul class="list-group list-group-flush">
							<li class="list-group-item">Email : ${etudiantSeeCommand.email }</li>
							<li class="list-group-item">Mot de Passe : ${etudiantSeeCommand.motDePasse }</li>
  							<li class="list-group-item">Date de Naissance : ${etudiantSeeCommand.dateNaissance }</li>
						</ul>
       				</div>
					
        <c:if test="${etudiantSeeCommand.adresse==null }">
        	<p class="card-text">
				<small class="text-muted"><a href="">Aucune adresse liée ...</a></small>
			</p>
        </c:if>
      </div>
    </div>
  </div>
</div>

<table border="1" width="60%">
	 <tr>
	 	<td colspan="9" align="right">
	 		<a style="background-color: lightblue;"
				href="${pageContext.request.contextPath}/etudiants/add-etudiant-form">
	 			Ajout d'un étudiant
	 		</a>
	 	</td>
	 </tr>
	 	<tr>
	 		<th>ID</th>
	 		<th>Nom</th>
	 		<th>Prenom</th>
	 		<th>Email</th>
	 		<th>dateNaissance</th>
	 		
	 		<th>Consulter</th>
	 		<th>Modifier</th>
	 		<th>Supprimer</th>
	 	</tr>
	 	
	 	<tr>
	 		<td>${etudiantSeeCommand.identifiant }</td>
	 		<td>${etudiantSeeCommand.nom }</td>
	 		<td>${etudiantSeeCommand.prenom }</td>
	 		<td>${etudiantSeeCommand.email }</td>
	 		<td>${etudiantSeeCommand.dateNaissance }</td>
	 		
	 		
	 	</tr>
	 </table>

</body>
</html>