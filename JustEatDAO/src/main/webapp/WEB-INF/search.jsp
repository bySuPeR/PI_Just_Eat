<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang = es>
    <head>
        <meta charset = "UTF-8">
        <title>Just Eat</title>
        <link rel = "stylesheet" href = "general.css">
        <link rel = "stylesheet" href = "search.css">
    </head>
    <body>
        <div class = "full-screen-container">
            <div class = "main-page-container">
                <div class="foto-container">
                <div class = "restaurant-container">
                        <h1>Â¡Busca restaurantes cerca de ti!</h1>
                        <form class = "form">
                            <input type = "text">
                            <input type = "button" value = "Â¡Busca!" onclick = "window.location.href='restaurants.html';">
                        </form>
                    </div>
                </div> 
                <div class="titulo-categorias">
                    <h2>LOS MÃS POPULARES ENTRE LA GENTE</h2>
                    <h4>Busca el restaurante que mÃ¡s te guste de tu zona y pide a domicilio</h3>
                </div>
                <div class = "categories-list">
                    <input type = "button" value = "BURGUER" class = "single-category" onclick = "window.location.href='restaurants.html';" id = "burguer-id">
                    <input type = "button" value = "PIZZAS" class = "single-category" onclick = "window.location.href='restaurants.html';" id = "pizzas-id">
                    <input type = "button" value = "KEBAB" class = "single-category" onclick = "window.location.href='restaurants.html';" id = "kebab-id">
                    <input type = "button" value = "ITALIANO" class = "single-category" onclick = "window.location.href='restaurants.html';" id = "italiano-id">
                    <input type = "button" value = "AMERICANO" class = "single-category" onclick = "window.location.href='restaurants.html';" id = "americano-id">
                </div>
            </div>
        </div>
    </body>
</html>