<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang = es>
    <head>
        <meta charset = "UTF-8">
        <title>Just Eat</title>
        <link rel = "stylesheet" href = "css/general.css">
        <link rel = "stylesheet" href = "css/res_details.css">
    </head>
    <body>
        <div class = "full-screen-container">
            <div class = "main-page-container">
            	<img src = "images/${restaurant.restaurantPic}" class = "restaurant-pic">
				<div class = "restaurant-container">	
					<h1 class = "restaurant-text">${restaurant.name}
						<span class = "number-value" id = "grade-average">${restaurant.gradesAverage}</span>
					</h1>
					<h1 class = "restaurant-text">${restaurant.contactEmail}</h1>
					<h1 class = "restaurant-text">${restaurant.telephone}</h1>
					<h1 class = "restaurant-text">${restaurant.address}, ${restaurant.city}</h1>
					<c:forEach var = "category" items = "${categoryList}">
						<span class = "restaurant-text">${category.name} </span>
					</c:forEach>
					<h4 class = "restaurant-text">Prices: (min: ${restaurant.minPrice}€, max: ${restaurant.maxPrice}€)</h4>
					<h1 class = "restaurant-text" id = "bike-parking-lot">Has bike parking lot?
						<span class = "restaurant-text">
							<c:if test = "${restaurant.bikeFriendly eq 1}">
								Yes!
							</c:if>
							<c:if test = "${restaurant.bikeFriendly eq 0}">
								Sorry, no :(
							</c:if>
						</span>
					</h1>
					<c:if test = "${restaurant.available eq 1}">
						<h1 class = "restaurant-text" id = "take-orders">We take orders!</h1>
					</c:if>
					<c:if test = "${restaurant.available eq 0}">
						<h1 class = "restaurant-text">Sorry, no orders now</h1>
					</c:if>
					
					
					
			<form method="post" action="?">
				<c:choose>
          			<c:when test="${requestScope.like eq 'emptyH'}">
          				<button><img src="images/notlike.png" id= "like"  style="background-color: transparent;"></button>
          			</c:when>
          			<c:otherwise>
          				<button><img src="images/like.png " id= "like" style="background-color: transparent;"></button>
          			</c:otherwise>
          		</c:choose>
			</form>						
					
					<c:if test = "${restaurant.idu eq requestScope.currentUser.id}">
						<a class = "manage-restaurant" href = "<c:url value = 'UpdateRestaurantServlet.do?idR=${restaurant.id}&idU=${currentUser.id}'/>">Manage restaurant</a>
					</c:if>
					
				</div>
				<div class = "dishes-container">
					<c:forEach var = "dish" items = "${dishList}">
						<div class = "individual-dish">
							<img src = "images/${dish.dishPic}" id = "dishPic">
							<h2>${dish.name}
								<span class = "number-value">${dish.price}€</span>
							</h2>
							<h3>${dish.description}</h3>
						</div>
					</c:forEach>
				</div>
				<c:if test = "${restaurant.idu eq currentUser.id}">
					<a class = "manage-restaurant" id = "back-to-my-restaurants" href = "<c:url value = 'MyRestaurantsServlet.do'/>">My Restaurants</a>
					<a class = "manage-restaurant" id = "manage-reviews" href = "<c:url value = 'LoadReviewsServlet.do?id=${restaurant.id}'/>">Check reviews</a>
				</c:if>
				<c:if test = "${restaurant.idu ne currentUser.id}">
					<a class = "manage-restaurant" id = "back-to-my-restaurants" href = "<c:url value = 'SearchServlet.do'/>">Back</a>
					<a class = "manage-restaurant" id = "manage-reviews" href = "<c:url value = 'LoadReviewsServlet.do?id=${restaurant.id}'/>">Rate this restaurant</a>
				</c:if>
				<a class = "manage-restaurant" id = "make-order-button" href = "<c:url value = 'MakeOrderServlet.do?id=${restaurant.id}'/>">Make order</a>
            </div>
        </div>
    </body>
</html>