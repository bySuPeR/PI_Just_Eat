<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang = "es">
    <head>
        <meta charset = "UTF-8">
        <title>Just Eat</title>
        <link rel = "stylesheet" href = "${pageContext.request.contextPath}/css/general.css">
        <link rel = "stylesheet" href = "${pageContext.request.contextPath}/css/delete.css">
    </head>
    <body>
        <div class = "full-screen-container">
            <div class = "main-page-container">
            	<form action = "DeleteUserServlet.do" action = "post">
            		<label>Are you sure you want to delete your account?</label>
            		<button type = "submit">Yes, delete</button>
            	</form>
            </div>
        </div>
    </body>
</html>