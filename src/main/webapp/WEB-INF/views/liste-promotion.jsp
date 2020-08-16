<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>


<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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


	<!--  HEADER  -->
	<jsp:include page="/Fragments/Header.jsp" />

	<h1 id="TitreListe">

		<u><fmt:message key="listepro"/></u>
	</h1>

	 <div class="card shadow mb-4">
            
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="80%" cellspacing="0">
                  <thead class="thead-blue">
                  
     <sec:authorize access="hasRole('ROLE_Admin')">       
           <tr>
				<th id="Ajout" colspan="8"><a
					href="${pageContext.request.contextPath}/promotion/add-promotion-form"><img
						id="LogoAjout"
						src="${pageContext.request.contextPath}/assets/images/AjoutFichier.png"><span>Ajouter
							Promotion</span></a></th>
			</tr>
	</sec:authorize>


			<tr>
				<th scope="col">Id <fmt:message key="23"/></th>
				<th scope="col"><fmt:message key="11"/></th>


				<th scope="col"><fmt:message key="con"/></th>
				<th scope="col"><fmt:message key="modif"/></th>
				<th scope="col"><fmt:message key="liercours"/></th>
				<th scope="col"><fmt:message key="supp"/></th>
			</tr>
                  </thead>

                  
             <!--  Body de la table -->
             <tbody>
                <c:forEach items="${attribut_liste_promotion}" var="pro">
				<tr>
					<td>${pro.idPromotion}</td>
					<td>${pro.libelle}</td>

					<!--  lien pour voir les details de la promo -->
					<td>
						<a href="${pageContext.request.contextPath}/promotion/see-promotion/${pro.idPromotion}">
							<img src="${pageContext.request.contextPath}/assets/images/search.svg">
						</a>
					</td>

					<!-- lien pour modifier la promo -->
					<td>
						<a href="${pageContext.request.contextPath}/promotion/update-promotion-form?idpromotion=${pro.idPromotion}">
							<img
							src="${pageContext.request.contextPath}/assets/images/pencil.svg">
						</a>
					</td>
					
					<!-- Lien pour lier la promo à un/des cours -->
					<td>
						<!-- au click sur le lien : envoie d'une requete http get vers la méthode  -->
						<a href="${pageContext.request.contextPath}/promotion/linkCours/${pro.idPromotion}">
							<img src="${pageContext.request.contextPath}/assets/images/info-circle.svg">
						</a>
					</td>
	
					<!-- lien pour supprimer la promo -->
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