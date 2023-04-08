<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang = "es">
    <head>
        <meta charset = "UTF-8">
        <title>Just Eat</title>
        <link rel = "stylesheet" href = "css/general.css">
        <link rel = "stylesheet" href = "css/login.css">
        <link rel = "stylesheet" href = "css/update-restaurant.css">
        <link rel = "stylesheet" href = "css/update-dishes.css">
    </head>
    <body>
        <div class = "full-screen-container">
            <div class = "login-container">
                <h1 class = "login-title">This is what you asked</h1>
                <c:forEach var = "dish" items = "${dishList}">
                	<div class = "order-container">
                		<h3>${dish.name}</h3>
                		<h3>${dish.description}</h3>
                		<h2>${dish.price}€</h2>
                	</div>
                </c:forEach>
                <a class = "delete-link" href = "<c:url value = "MyOrdersServlet.do"/>">Go back to My Orders</a>
            </div>
        </div>
    </body>
</html>