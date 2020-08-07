<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>

<form method="POST"
        action="${pageContext.request.contextPath}/etudiant/testcb">
        
        <table border="1" width="60%">

		<tr>
			<td colspan="2" align="right">
			<a style="background-color: lightBlue;"
				href="${pageContext.request.contextPath}/etudiant/testcb">
					Test checkbox </a></td>
		</tr>


		<tr>
			<th>Id</th>
			<th>Checkbox</th>



</tr>
    
			<tr>
				<td>1</td>
				<td><input type="checkbox"  name="test"  value="1" /></td>
				
			</tr>
			
			<tr>
				<td>2</td>
				<td><input type="checkbox"  name="test"  value="2" /></td>
				
			</tr>
			
			<tr>
				<td>3</td>
				<td><input type="checkbox"  name="test"  value="3" /></td>
				
			</tr>

		</table>
        
         <input  type="submit" class="btn btn-primary" value="Test Checkbox"/>
        </form>
	
</body>