<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>

	<h1 id="TitreForm">Formulaire d'envoie de mail</h1>

	
	<form method="POST" action="${pageContext.request.contextPath}/mail/send">

        <div style="width: 80%;margin: auto;">
            <div class="form-row">
                <div class="form-group col-md-5">
                    <label for="fromMail">Votre mail</label>
                        <input type="text" class="form-control" required="true" id="fromMail"/>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-5">
                    <label for="sujetMail">Objet du mail</label>
                        <input type="text" class="form-control" required="true" id="sujetMail"/>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-5">
                    <label for="contentMail">Contenu du mail</label>
                        <input type="text" class="form-control" required="true" id="contentMail"/>
                </div>
            </div>

            <input id="inputSubmit" type="submit" class="btn btn-primary" value="Envoyer email"/>
        </div>
    </form>

</body>
</html>