<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang = "es">
    <head>
        <meta charset = "UTF-8">
        <title>Just Eat</title>
        <link rel = "stylesheet" href = "${pageContext.request.contextPath}/css/general.css">
        <link rel = "stylesheet" href = "${pageContext.request.contextPath}/css/login.css">
    </head>
    <body>
        <div class = "full-screen-container">
            <div class = "login-container">
                <h1 class = "login-title">Add new orders</h1>
                
                <p class = error>${requestScope.error}</p>
            </div>
        </div>
    </body>
</html>