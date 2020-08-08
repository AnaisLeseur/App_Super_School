<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles/FormEtudiant.css">
</head>
<body>

<jsp:include page="/Fragments/Header.jsp"/>
<div id="TitreForm">
    <h1>Formulaire de modification d'un cours</h1>
    </div>
    
   
         <form:form enctype="multipart/form-data" modelAttribute="coursModifCommand" method="POST" 
         action="${pageContext.request.contextPath}/cours/update">
         
         
         
         <!-- recup de l'id de l'employe a modifier dans un champs caché-->
         <tr>
         <td>
         <form:hidden path="idCours"/>
         </td>
         </tr>
         
               <form:label path="idCours">Id Cours : </form:label> 
                  <form:input path="idCours"/> 
                   <form:errors path="idCours" cssStyle="color : green; font-style: italic;"/> 
              
              <div style="width: 80%;margin: auto;">
            <div class="form-row">
                <div class="form-group col-md-5">
			
					<form:label path="libelle">Libelle : </form:label>
					<form:input path="libelle" type="text" class="form-control" required="true"
                            pattern="[A-Z][A-Za-z -]+"/>
					<form:errors path="libelle"
							cssStyle="color : red; font-style: italic;" />

				</div>

				<div class="form-group col-md-2"></div>
                <div class="form-group col-md-5">
                <form:label path="description">Description : </form:label>
					
					<form:input path="description" type="text" class="form-control" required="true"
                            pattern="[A-Z][A-Za-z -]+" />
					<form:errors path="description"
							cssStyle="color : red; font-style: italic;" />

				</div>
				</div>
				<br><br><br>
 <div class="form-row">
                <div class="form-group col-md-5">
				<form:label path="duree">duree : </form:label>
					
					<form:input path="duree"  class="form-control" required="true"/>
					<form:errors path="duree"
							cssStyle="color : red; font-style: italic;" />
				</div>
				
				 <div class="form-group col-md-2"></div>
                <div class="form-group col-md-5">
					<form:label path="date">Date : </form:label>			
					<form:input path="date" type="date"  required="true"/>
					<form:errors path="date"
							cssStyle="color : green; font-style: italic;" />

				</div>
				</div>
				<br><br><br>
<div class="form-row">
				<div class="form-group col-md-5">
				<form:label path="fkEtudiant">Fk Etudiant : </form:label>
					<form:input path="fkEtudiant" required="true"/><form:errors path="fkEtudiant"
							cssStyle="color : blue; font-style: italic;" />
</div>

				<div class="form-group col-md-2"></div>
                <div class="form-group col-md-5">
					<form:label path="fkMatiere">Fk Matiere : </form:label>
					<form:input path="fkMatiere" required="true" /><form:errors path="fkMatiere"
							cssStyle="color : blue; font-style: italic;" />

				</div>
				
				</div>
              
                 <input id="inputSubmit" type="submit" class="btn btn-primary" value="Modifier">
                
              
              
         
         
         </form:form>
   <script src="${pageContext.request.contextPath}/assets/scripts/jquery-3.4.1.js"></script>
    <script src="${pageContext.request.contextPath}/assets/scripts/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/scripts/FormEtudiant.js"></script>
</body>
</html>