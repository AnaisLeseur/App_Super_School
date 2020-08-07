<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/index.jsp">Retour à la page d'accueil</a>
<div align="center">
    <h1>Formulaire de modification d'un cours</h1>
    </div>
    
    <div align="center">
         <%--
         > modelAttribute = le nom  de l'objet de commande definit dans la methode afficherFormulaireAjout du controlleur
         
         > à la soumission du formulaire : invocation de la méthode "modifierEmployerBdd"
                                           "EmplpoerController" avec une requete HTTP en post et l'url "/employes/add"
           
         
          --%>
         <form:form modelAttribute="coursModifCommand" method="POST" 
         action="${pageContext.request.contextPath}/cours/update">
         
         <table width="60%">
         
         <!-- recup de l'id de l'employe a modifier dans un champs caché-->
         <tr>
         <td>
         <form:hidden path="idCours"/>
         </td>
         </tr>
         
               <tr>
                  <td> <form:label path="idCours">Id Cours : </form:label> </td>
                  <td> <form:input path="idCours"/> </td>
                  <td> <form:errors path="idCours" cssStyle="color : green; font-style: italic;"/>  </td>
              </tr>
              
              <tr>
					<td><form:label path="libelle">libelle : </form:label></td>
					<td><form:input path="libelle" /></td>
					<td><form:errors path="libelle"
							cssStyle="color : green; font-style: italic;" /></td>

				</tr>

				<tr>
					<td><form:label path="description">description : </form:label>
					</td>
					<td><form:input path="description" /></td>
					<td><form:errors path="description"
							cssStyle="color : green; font-style: italic;" /></td>

				</tr>

				<tr>
					<td><form:label path="duree">duree : </form:label>
					</td>
					<td><form:input path="duree" /></td>
					<td><form:errors path="duree"
							cssStyle="color : green; font-style: italic;" /></td>

				</tr>
				<tr>
					<td><form:label path="date">date : </form:label>
					</td>
					<td><form:input path="date" /></td>
					<td><form:errors path="date"
							cssStyle="color : green; font-style: italic;" /></td>

				</tr>

				<tr>
					<td><form:label path="fkEtudiant">Fk Etudiant : </form:label>
					</td>
					<td><form:input path="fkEtudiant" /></td>
					<td><form:errors path="fkEtudiant"
							cssStyle="color : blue; font-style: italic;" /></td>

				</tr>

				<tr>
					<td><form:label path="fkMatiere">Fk Matiere : </form:label></td>
					<td><form:input path="fkMatiere" /></td>
					<td><form:errors path="fkMatiere"
							cssStyle="color : blue; font-style: italic;" /></td>

				</tr>
              
              <tr>
                 <td>
                  <input type="submit" value="Modifier">
                 </td>
              </tr>
              
              
         </table>
         
         </form:form>
    </div>
</body>
</html>