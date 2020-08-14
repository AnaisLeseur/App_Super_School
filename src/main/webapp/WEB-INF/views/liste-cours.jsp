<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- ajout de la taglib de spring mvc form --%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Liste des cours</title>
	
	<!--  feuille de style -->
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
	
	<!-- HEADER -->
	<jsp:include page="/Fragments/Header.jsp" />


	<h1 id="TitreListe"><fmt:message key="listecours"/></h1>
 
	 <div class="card shadow mb-4">           
       <div class="card-body">
         <div class="table-responsive">
           <table class="table table-bordered" id="dataTable" width="80%" cellspacing="0">
             <thead class="thead-blue">
               	<tr>
					<th id="Ajout" colspan="11">
						<a href="${pageContext.request.contextPath}/cours/add-cours-form">
							<img id="LogoAjout"
								src="${pageContext.request.contextPath}/assets/images/AjoutFichier.png">
									<span><fmt:message key="33"/></span>
						</a>
					</th>
				</tr>
			
				<tr>
					<th scope="col">ID</th>
					<th scope="col"><fmt:message key="11"/></th>
					<th scope="col">Date</th>
					<th scope="col"><fmt:message key="22"/></th>
					<th scope="col"><fmt:message key="23"/></th>
	                
	                <th scope="col"><fmt:message key="con"/></th>
	                <th scope="col"><fmt:message key="modif"/></th>
	                <th scope="col"><fmt:message key="ae"/></th>
	                <th scope="col"><fmt:message key="ap"/></th>
					<th scope="col"><fmt:message key="am"/></th>
					<th scope="col"><fmt:message key="supp"/></th>
					
				</tr>

		</thead>
		
		<!-- données de la table -->
		<tbody>
			<c:forEach items="${attribut_liste_cours}" var="cou">
				<tr>
					<td>${cou.idCours}</td>
					<td>${cou.libelle}</td>
					<td>${cou.date}</td>
					<td>${cou.matiere.libelle}</td>
					<td>${cou.promotion.libelle}</td>
					
					<td>
						<a href="${pageContext.request.contextPath}/cours/see-cours/${cou.idCours }"><img
							src="${pageContext.request.contextPath}/assets/images/search.svg">
						</a>
					</td>
					
					<!-- Modifier -->
					
					<td>
						<a href="${pageContext.request.contextPath}/cours/update-cours-form?idcours=${cou.idCours }">
							<img src="${pageContext.request.contextPath}/assets/images/pencil.svg">
						</a>
					</td>
					
					<td>
						<a href="${pageContext.request.contextPath}/cours/linkEtudiantCours/${cou.idCours}">
							<img src="${pageContext.request.contextPath}/assets/images/person-plus.svg">
						</a>
					</td>
					

					<!-- lier cours à une PROMOTION avec liste déroulante -->
					<td>  
						<form:form action="${pageContext.request.contextPath}/promotion/bindPromotionToCours" modelAttribute="coursBindPromo" method="POST"> 
	 						<form:select path="promotion.idPromotion">
								  <form:option value="0" label="--- Select ---" />
								  <form:options items="${liste_Promotion}" itemValue="idPromotion" itemLabel="libelle" />
					      	</form:select>
					      	<form:hidden path="idCours" value="${cou.idCours }" />
					      	<input type="submit" value="Attribuer" style="padding: 5px 10px 5px 10px"/>
                        </form:form>
   
					</td>
					
					<!-- lier cours à une matiere -->
					<td>  
						<form:form action="${pageContext.request.contextPath}/cours/linkToMatiere" modelAttribute="attribut-cours" method="POST"> 
	 						<form:select path="matiere.idMatiere">
								  <form:option value="0" label="--- Select ---" />
								  <form:options items="${attribut_listeMatiereBddPourAssos}" itemValue="idMatiere" itemLabel="libelle" />
					      	</form:select>
					      	<form:hidden path="idCours" value="${cou.idCours }" />
					      	<input type="submit" value="Attribuer" style="padding: 5px 10px 5px 10px" />
                        </form:form>
					</td>
					
					<!-- suppression -->
					<td>
						<!-- au click sur le lien : envoie d'une requete http get vers la méthode supprimer -->
						<a href="${pageContext.request.contextPath}/cours/delete/${cou.idCours}">
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
  
  	<!-- footer -->
	<jsp:include page="/Fragments/footer.jsp"></jsp:include> 
	
	
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