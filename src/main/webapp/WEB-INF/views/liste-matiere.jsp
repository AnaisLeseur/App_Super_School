<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Liste des matières</title>
	
	<!--  Feuilles de styles  -->
	
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

<body id="page-top">

	<!--  HEADER  -->
	<jsp:include page="/Fragments/Header.jsp" />


	<h1 id="TitreListe">
		Liste des matières
	</h1>
  
       <div class="card shadow mb-4">
            
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="80%" cellspacing="0">
                  <thead class="thead-blue">
                  	<tr>
						<th id="Ajout" colspan="8">
							<a href="${pageContext.request.contextPath}/matiere/add-matiere-form">
								<img id="LogoAjout"
									src="${pageContext.request.contextPath}/assets/images/AjoutFichier.png" 
									width="5%">
									<span>Ajouter Matiere</span>
							</a>
						</th>
					</tr>
                    <tr>
						<th>Identifiant</th>
						<th>Libelle</th>

						<th>Modifier</th>
						<th>Supprimer</th>
						<th>Voir les cours liés à la matière</th>
				
					</tr>
                  </thead>
                  
                  <tbody>
                    <c:forEach items="${attribut_liste_matiere}" var="mat">
						<tr>
							<td>${mat.idMatiere}</td>
							<td>${mat.libelle}</td>

							<!-- au click sur le lien : envoie d'ue requete HTTP en Get vers la méthode "afficherFormulaireModification()" 
								passage d'un param de requete nommé idmatière ayant la valeur de l'id de la matière à modifier
		 					-->
							<td>
								<a href="${pageContext.request.contextPath}/matiere/update-matiere-form?idmatiere=${mat.idMatiere}">
									<img src="${pageContext.request.contextPath}/assets/images/pencil.svg">
								</a>
							</td>
					
							<!-- suppression -->
							<td>
								<!-- au click sur le lien : envoie d'une requete http get vers la méthode supprimer -->
								<a href="${pageContext.request.contextPath}/matiere/delete/${mat.idMatiere}">
									<img src="${pageContext.request.contextPath}/assets/images/trash.svg">
								</a>
							</td>

							<!-- cours liés à la matière -->
							<td>
								<!-- au click sur le lien : envoie d'une requete http get vers la méthode MatiereLinkedCours -->
								<a href="${pageContext.request.contextPath}/matiere/coursLinked/${mat.idMatiere}">
									<img src="${pageContext.request.contextPath}/assets/images/info-circle.svg">
								</a>
							</td>
						</tr>

					</c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
          
       <!--  FOOTER  -->  
       <jsp:include page="/Fragments/footer.jsp" />
          	
          	
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

</body>
</html>