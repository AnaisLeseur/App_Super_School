<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles/bootstrap.min.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles/Liste.css">
	
</head>
<body>

<jsp:include page="/Fragments/Header.jsp"/>
 <h1>Promotions : ${promotionSeeCommand.libelle}</h1>

<div class="col-md-11" style="margin: auto;">


        <div class="col-md-5" style="float: left;">

           

<c:if  test="${ empty promotionSeeCommand.listeEtudiants}">
		<a class="LinkRougeNull" href="${pageContext.request.contextPath}/promotion/linkEtudiant/${promotionSeeCommand.idPromotion}">Aucun étudiant associé</a>
	</c:if>
	
	<c:if  test="${not empty promotionSeeCommand.listeEtudiants}">
	
	
	<table class="table table-striped table-bordered table-hover">

		<thead class="thead-blue">
			<tr>
				<th scope="col">Id Etudiant</th>
				<th scope="col">Nom</th>
				<th scope="col">Retirer</th>
			</tr>

		</thead>

		<tbody>

			<c:forEach items="${promotionSeeCommand.listeEtudiants}" var="etudiant">
				<tr>
					<td>${etudiant.identifiant}</td>
					<td>${etudiant.nom} ${etudiant.prenom}</td>
					
					<td>
						<a href="${pageContext.request.contextPath}/promotions/deleteEtudiant?idPromo=${promotionSeeCommand.idPromotion}&idEtudiant=${etudiant.identifiant}">
							<img src="${pageContext.request.contextPath}/assets/images/x.svg">
						</a> 
					</td>
				</tr>

			</c:forEach>
			
			<tr>
				<td colspan="3">
					<a href="${pageContext.request.contextPath}/promotion/linkEtudiant/${promotionSeeCommand.idPromotion}">Ajouter Etudiant</a>
				</td>
			</tr>
			
		</tbody>

	</table>
	
	</c:if>
	
	</div>
	
	
	
	<%-- 
	
	
	
	<div class="col-md-5" style="float: right;">

            <h1>Cours :</h1>

		<a class="LinkRougeNull" href="${pageContext.request.contextPath}/etudiant/linkPromotion/${etudiantSeeCommand.identifiant}">Aucun cours associé</a>



            <table class="table table-striped table-bordered table-hover">

                <thead class="thead-blue">

                    <tr>
                        <th scope="col">Id Promotion</th>
                        <th scope="col">Libelle</th>
                    </tr>

                </thead>

                <tbody>

                    <c:forEach items="${etudiantSeeCommand.listePromotions}" var="pro">
                        <tr>
                            <td>${pro.idPromotion}</td>
                            <td>${pro.libelle}</td>
                        </tr>

                    </c:forEach>
                </tbody>

            </table>


        </div>
        --%>
         <br/>
         <br/>
         <br/>
         <br/>
         <br/>
         <br/>
    </div>
    
    <br/>
    
    <jsp:include page="/Fragments/footer.jsp" />
	
</body>
</html>