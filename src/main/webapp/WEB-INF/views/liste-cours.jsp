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
	

	<jsp:include page="/Fragments/Header.jsp" />

	<h1 id="TitreListe">
		<u>Liste des cours</u>
	</h1>

	 <div class="card shadow mb-4">
            
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="80%" cellspacing="0">
                  <thead class="thead-blue">
               <tr>
				<th id="Ajout" colspan="7"><a
					href="${pageContext.request.contextPath}/cours/add-cours-form"><img
						id="LogoAjout"  src="${pageContext.request.contextPath}/assets/images/AjoutFichier.png"><span>Ajouter
							Cours</span></a></th>
			</tr>
			


			<tr>
				<th scope="col">IdCours</th>
				<th scope="col">Libelle</th>
				<th scope="col">Description</th>
				<th scope="col">Dur�e</th>
				<th scope="col">Date</th>
			

                
				<th scope="col">Modifier</th>
				<th scope="col">Eliminer</th>
			</tr>

		</thead>
		<!-- donn�es de la table
    -->
		<tbody>
			<c:forEach items="${attribut_liste_cours}" var="cou">
				<tr>
					<td>${cou.idCours}</td>
					<td>${cou.libelle}</td>
					<td>${cou.description}</td>
					<td>${cou.duree}</td>
					<td>${cou.date}</td>




					<!-- au click sur le lien : envoie d'ue requete HTTP en Get vers la m�thode "afficherFormulaireModification()" 
passage d'un param de requete nomm� idemploye ayant la valeur de l'id de l'employe � modifier
 -->
					<td><a
						href="${pageContext.request.contextPath}/cours/update-cours-form?idcours=${cou.idCours}">
							<img
							src="${pageContext.request.contextPath}/assets/images/pencil.svg"></a></td>
					<!-- suppression -->
					<td>
						<!-- au click sur le lien : envoie d'une requete http get vers la m�thode supprimer -->
						<a
						href="${pageContext.request.contextPath}/cours/delete/${cou.idCours}">
							<img
							src="${pageContext.request.contextPath}/assets/images/trash.svg"></a>
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