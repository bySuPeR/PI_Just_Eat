<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang = "es">
    <head>
        <meta charset = "UTF-8">
        <title>Just Eat</title>
        <link rel = "stylesheet" href = "css/general.css">
        <link rel = "stylesheet" href = "css/delete.css">
    </head>
    <body>
        <div class = "full-screen-container">
            <div class = "main-page-container">
            	<c:if test = "${requestScope.delete eq 0}">
            		<form action = "DeleteUserServlet.do" method = "post">
            			<label>Are you sure you want to delete your account?</label>
            			<input type = "submit" value = "Yes, delete">
            		</form>
            		<a href = "<c:url value = 'UpdateUserServlet.do'/>">No, go back</a>
            	</c:if>
            	<c:if test = "${requestScope.delete eq 1}">
            		<form action = "DeleteRestaurantServlet.do" method = "post">
            			<label>Are you sure you want to delete this restaurant?</label>
            			<input type = "submit" value = "Yes, delete">
            		</form>
            		<a href = "<c:url value = 'UpdateRestaurantServlet.do'/>">No, go back</a>
            	</c:if>
            	<c:if test = "${requestScope.delete eq 2}">
            		<form action = "DeleteDishServlet.do" method = "post">
            			<label>Are you sure you want to delete this dish?</label>
            			<input type = "submit" value = "Yes, delete">
            		</form>
            		<a href = "<c:url value = 'UpdateDishServlet.do'/>">No, go back</a>
            	</c:if>
            </div>
        </div>
    </body>
</html>