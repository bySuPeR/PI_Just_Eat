<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang = es>
    <head>
        <meta charset = "UTF-8">
        <title>Just Eat</title>
        <link rel = "stylesheet" href = "css/general.css">
        <link rel = "stylesheet" href = "css/search.css">
    </head>
    <body>
        <div class = "full-screen-container">
            <div class = "main-page-container">
            	<a class = "pages-link" id = "account-link" href = "<c:url value = 'UpdateUserServlet.do'/>">Account</a>
                <a class = "pages-link" id = "my-restaurants-link" href = "<c:url value = 'MyRestaurantsServlet.do'/>">My Rests.</a>
                <div class = "pic-container">
                	<div class = "search-input-container">
                        <h1>Search for our best restaurants!</h1>
                        <form class = "form" action = "SearchServlet.do" method = "post">
                            <input type = "text">
                            <input type = "button" value = "Search!">
                        </form>
                    </div>
                </div>
                <div class="titulo-categorias">
                    <h2>OUR BEST OFFERS</h2>
                    <h4>Search for your closest restaurant and enjoy at home</h4>
                </div>
                <div class = "categories-list">
                	<form action = "Servlet.do" method = "post">
                		<c:forEach var = "category" items = "${categoryList}">
                			<input type = "button" class = "single-category" value = "${category.name}">
                		</c:forEach>
                	</form>
                </div>
                <div class = "restaurant-grid-container">
                	<c:forEach var = "restaurant" items = "${restaurantList}">
                		<div class = "single-restaurant">
                        	<a href = "RestaurantDetailsServlet.do?id=${restaurant.id}"><img src = "images/canteria.jpg" class = "restaurant-photo"></a>
                        	<h3>${restaurant.name}</h3>
                    	</div>
                	</c:forEach>
                </div>
            </div>
        </div>
    </body>
</html>