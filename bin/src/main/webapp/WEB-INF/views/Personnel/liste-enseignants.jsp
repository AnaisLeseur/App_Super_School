<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des  enseignants</title>


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles/bootstrap.min.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles/Liste.css">
	
	<link rel="stylesheet" 
	href="${pageContext.request.contextPath}/assets/styles/perso.css">
	
	<!-- script du tricheur -->
	
	<link href="${pageContext.request.contextPath}/assets/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/assets/css/sb-admin-2.min.css" rel="stylesheet">

  <!-- Custom styles for this page -->
  <link href="${pageContext.request.contextPath}/assets/css/dataTables.bootstrap4.min.css" rel="stylesheet">
	
	
</head>
<body>

	<!-- Header -->


	<jsp:include page="/Fragments/Header.jsp" />


	<%--
			-> traitement des données envoyées par le controller 'EnseignantController' 
				et la methode 'recupererListeEnseignantsBdd'
				
				==> les données : model.addAttribute("attribut_liste_enseignants", listeEnseignantsBdd);
	 --%>
	 
	 <h1 id="TitreListe">Liste des enseignants </h1>
	 	 
	 <div class="card shadow mb-4">
            
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="80%" cellspacing="0">
                  <thead class="thead-blue">
               <tr>
				<th id="Ajout" colspan="8">
					<a href="${pageContext.request.contextPath}/enseignants/add-enseignant-form"><img
						id="LogoAjout"  src="${pageContext.request.contextPath}/assets/images/person-plus.svg">
						<span>Ajouter un enseignant</span>
					</a>
				</th>
			</tr>

			<tr>
				<th scope="col">ID</th>
				<th scope="col">Nom</th>
				<th scope="col">Prenom</th>
				<th scope="col">Email</th>

				<th scope="col">Consulter</th>
				<th scope="col">Modifier</th>
				<th scope="col">Supprimer</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${attribut_liste_enseignants}" var="enseignant">
				<tr>
		 		<td>${enseignant.identifiant }</td>
		 		<td>${enseignant.nom }</td>
		 		<td>${enseignant.prenom } </td>
		 		<td>${enseignant.email }</td>

					<td>
						<a href="${pageContext.request.contextPath}/enseignants/see-enseignant/${enseignant.identifiant }">
							<img src="${pageContext.request.contextPath}/assets/images/search.svg">
						</a>
					</td>
					<td>
						<a href="${pageContext.request.contextPath}/enseignants/update-enseignant-form?idEnseignant=${enseignant.identifiant }">
							<img src="${pageContext.request.contextPath}/assets/images/pencil.svg">
						</a>
					</td>
					<td>
						<a href="${pageContext.request.contextPath}/enseignants/delete/${enseignant.identifiant }">
							<img src="${pageContext.request.contextPath}/assets/images/trash.svg">
						</a>
					</td>
				</tr>
			</c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>

	<!-- script thomas -->
	<script
		src="${pageContext.request.contextPath}/assets/scripts/jquery-3.4.1.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/assets/scripts/bootstrap.min.js"
		type="text/javascript"></script>
		<!-- script pour tricher -->
			 <!-- Bootstrap core JavaScript-->
  <script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/assets/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="${pageContext.request.contextPath}/assets/js/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="${pageContext.request.contextPath}/assets/js/sb-admin-2.min.js"></script>

  <!-- Page level plugins -->
  <script src="${pageContext.request.contextPath}/assets/js/jquery.dataTables.min.js"></script>
  <script src="${pageContext.request.contextPath}/assets/js/dataTables.bootstrap4.min.js"></script>

  <!-- Page level custom scripts -->
  <script src="${pageContext.request.contextPath}/assets/js/datatables-demo.js"></script>
	<!-- footer -->
	<jsp:include page="/Fragments/footer.jsp"></jsp:include> 

</body>
</html>