<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%-- taglibs core des jsp --%>
 <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
      <%-- taglibs core des jsp --%>
      
       
      <%-- taglibs core des jsp --%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<span th:text="#{lang.change}"></span>:
<select id="locales">
    <option value=""></option>
    <option value="en" th:text="#{lang.eng}"></option>
    <option value="fr" th:text="#{lang.fr}"></option>
</select>

<h1><spring:message code="greeting" text="default"/></h1>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">
</script>
<script type="text/javascript">
$(document).ready(function() {
    $("#locales").change(function () {
        var selectedOption = $('#locales').val();
        if (selectedOption != ''){
            window.location.replace('international?lang=' + selectedOption);
        }
    });
});
</script>
</body>
</html>