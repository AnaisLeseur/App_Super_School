<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles/bootstrap.min.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles/Liste.css">
</head>
<body>

	<jsp:include page="/Fragments/Header.jsp" />

	<h1 id="TitreListe">
		<u>Liste des promotions</u>
	</h1>

	<table class="table table-striped table-bordered table-hover">

		<thead class="thead-blue">

			<tr>
				<th id="Ajout" colspan="8"><a
					href="${pageContext.request.contextPath}/promotion/add-promotion-form"><img
						id="LogoAjout"
						src="${pageContext.request.contextPath}/assets/images/AjoutFichier.png"><span>Ajouter
							Promotion</span></a></th>
			</tr>


			<tr>
				<th scope="col">Id Promotion</th>
				<th scope="col">Libelle</th>



				<th scope="col">Modifier</th>
				<th scope="col">Eliminer</th>
			</tr>

		</thead>
		<!-- données de la table
    -->
		<tbody>

			<c:forEach items="${attribut_liste_promotion}" var="pro">
				<tr>
					<td>${pro.idPromotion}</td>
					<td>${pro.libelle}</td>




					<!-- au click sur le lien : envoie d'ue requete HTTP en Get vers la méthode "afficherFormulaireModification()" 
passage d'un param de requete nommé idemploye ayant la valeur de l'id de l'employe à modifier
 -->
					<td><a
						href="${pageContext.request.contextPath}/promotion/update-promotion-form?idpromotion=${pro.idPromotion}">
							<img
							src="${pageContext.request.contextPath}/assets/images/pencil.svg">
					</a></td>
					<!-- suppression -->
					<td>
						<!-- au click sur le lien : envoie d'une requete http get vers la méthode supprimer -->
						<a
						href="${pageContext.request.contextPath}/promotion/delete/${pro.idPromotion}">
							<img
							src="${pageContext.request.contextPath}/assets/images/trash.svg">
					</a>
					</td>


				</tr>

			</c:forEach>
		</tbody>

	</table>
	<script
		src="${pageContext.request.contextPath}/assets/scripts/jquery-3.4.1.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/assets/scripts/bootstrap.min.js"
		type="text/javascript"></script>



</body>
</html>