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
    </head>
    <body>
        <div class = "full-screen-container">
            <div class = "login-container">
                <h1 class = "login-title">Make your order</h1>
                	<c:if test = "${show eq false}">
                		<form class = "form" action = "MakeOrderServlet.do" method = "post">
                		<div class = "input-group">
                			<label for = "restaurant-option">Choose a restaurant</label>
                			<div id = "restaurant-select">
                				<select name = "restaurant-option">
                				<option value = "Select...">Select...</option>
                				<c:forEach var = "restaurant" items = "${restaurantList}">
                					<option value = "${restaurant.name}">${restaurant.name}</option>
                				</c:forEach>
                			</select>
                			</div>
                		</div>
                		<input class = "login-button" type = "submit" value = "Choose">
                	</form>
                	</c:if>
                	<c:if test = "${show eq true}">
                		<form class = "form" action = "AddOrderServlet.do" method = "post">
                			<div class = "input-group">
                				<h2 class = "login-title"> Select your dishes</h2>
                				<c:forEach var = "dish" items = "${dishList}">
                					<div class = "category-container">
                						<label for = "${dish.name}" class = "features-text">${dish.name}, ${dish.price}€</label>
                						<input type = "checkbox" value = "${dish.id}" name = "selectedDish">
                					</div>
                				</c:forEach>
                			</div>
                			<input class = "login-button" type = "submit" value = "Make order">
                		</form>
                	</c:if>
                <p class = error>${requestScope.error}</p>
            </div>
        </div>
    </body>
</html>