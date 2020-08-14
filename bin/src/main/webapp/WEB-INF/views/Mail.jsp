<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles/bootstrap.min.css">

</head>
<body>

	<h1 id="TitreForm">Formulaire d'envoie de mail</h1>

	
	<form:form modelAttribute="mailToSend" method="POST" action="${pageContext.request.contextPath}/mail/send">

        <div style="width: 80%;margin: auto;">
        
            <div class="form-row">
                <div class="form-group col-md-5">
                    <form:label path="Subject">Objet du mail</form:label>
                        <form:input type="text" class="form-control" id="exampleFormControlInput1" required="true" path="Subject"/>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-5">
                    <form:label path="content">Contenu du mail</form:label>
                        <form:textarea type="text" class="form-control" id="exampleFormControlTextarea1" rows="3" required="true" path="content"/>
                </div>
            </div>

            <input id="inputSubmit" type="submit" class="btn btn-primary" value="Envoyer email"/>
        </div>
    </form:form>

</body>
</html>