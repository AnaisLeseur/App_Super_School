<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    
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

<jsp:include page="/Fragments/Header.jsp" />


	<h1 id="TitreListe"><fmt:message key="20"/></h1>
 
	 <div class="card shadow mb-4">           
       <div class="card-body">
         <div class="table-responsive">
           <table class="table table-bordered" id="dataTable" width="80%" cellspacing="0">
             <thead class="thead-blue">
			
				<tr>
					<th scope="col">ID</th>
					<th scope="col"><fmt:message key="21"/></th>
					<th scope="col"><fmt:message key="22"/></th>
					<th scope="col"><fmt:message key="23"/></th>
	                
					<th scope="col"><fmt:message key="modif"/></th>
					<th scope="col"><fmt:message key="supp"/></th>
					
				</tr>

		</thead>
		
		<!-- données de la table -->
		<tbody>
		<form:form modelAttribute="enseigneJointureCommand" method="POST" 
			action="${pageContext.request.contextPath}/enseigneJointure/addEnseigneJointure">
		<tr>
					<td>-</td>
					<td>
						<form:select path="enseignantEJ.identifiant">
							<form:option value="0" label="--- Select ---" />
							<form:options items="${attribut_listeEnseignants}" itemValue="identifiant" itemLabel="nom" />
					    </form:select>
					</td>
					<td>
						<form:select path="matiereEJ.idMatiere">
							<form:option value="0" label="--- Select ---" />
							<form:options items="${attribut_listeMatieres}" itemValue="idMatiere" itemLabel="libelle" />
					    </form:select>
					</td>
					<td>
						<form:select path="promotionEJ.idPromotion">
							<form:option value="0" label="--- Select ---" />
							<form:options items="${attribut_listePromotions}" itemValue="idPromotion" itemLabel="libelle" />
					    </form:select>
					</td>
					<td colspan="2"> <input type="submit" value="Lier"><form:errors path="*"/> </td>
				</tr>
		</form:form>
		
		
			<c:forEach items="${attribut_listeEnseigneJointures}" var="ej">
				<tr>
					<td>${ej.idEnseigneJointure}</td>
					<td>${ej.enseignantEJ.nom} ${ej.enseignantEJ.prenom}</td>
					<td>${ej.matiereEJ.libelle}</td>
					<td>${ej.promotionEJ.libelle}</td>					

					<!--  modification du cours -->
					<td>
						<a href="${pageContext.request.contextPath}/enseigneJointure/update-enseigneJointure-form/${ej.idEnseigneJointure}">
							<img src="${pageContext.request.contextPath}/assets/images/pencil.svg">
						</a>
					</td>
					
					<!-- suppression -->
					<td>
						<!-- au click sur le lien : envoie d'une requete http get vers la méthode supprimer -->
						<a href="${pageContext.request.contextPath}/enseigneJointure/delete/${ej.idEnseigneJointure}">
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