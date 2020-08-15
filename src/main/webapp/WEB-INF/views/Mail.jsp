<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles/bootstrap.min.css">

</head>
<body>

<c:choose>
<c:when test="${param.lang == 'fr'}">
	<fmt:setBundle basename="messages_fr"/>
</c:when>
<c:when test="${param.lang == 'en'}">
	<fmt:setBundle basename="messages_en"/>
</c:when>
<c:otherwise>
	<fmt:setBundle basename="messages"/>
</c:otherwise>
</c:choose>
	
	
	<form:form modelAttribute="mailToSend" method="POST" action="${pageContext.request.contextPath}/mail/send">

        <div style="width: 80%;margin: auto;">
        
        	<div class="form-row">
                <div class="form-group col-md-5">
                    <label for="AdresseReception"><fmt:message key="adresserecep"/></label>
                        <input type="text" class="form-control" id="AdresseReception" value="superschoolinti@gmail.com" readonly="readonly"/>
                </div>
            </div>
        
        	<div class="form-row">
                <div class="form-group col-md-5">
                    <label for="AdresseReception"><fmt:message key="adresseem"/></label>
                        <input type="text" class="form-control" id="AdresseEmission" value="superschoolinti@gmail.com" readonly="readonly"/>
                </div>
            </div>
        
            <div class="form-row">
                <div class="form-group col-md-5">
                    <form:label path="Subject"><fmt:message key="objmail"/></form:label>
                        <form:input type="text" class="form-control" id="exampleFormControlInput1" required="true" path="Subject"/>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-5">
                    <form:label path="content"><fmt:message key="contmail"/></form:label>
                        <form:textarea type="text" class="form-control" id="exampleFormControlTextarea1" rows="3" required="true" path="content"/>
                </div>
            </div>

            <input id="inputSubmit" type="submit" class="btn btn-primary" value="Envoyer email"/>
        </div>
    </form:form>

</body>
</html>