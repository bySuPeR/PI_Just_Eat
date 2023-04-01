<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang = es>
    <head>
        <meta charset = "UTF-8">
        <title>Just Eat</title>
        <link rel = "stylesheet" href = "general.css">
        <link rel = "stylesheet" href = "edit_restaurant.css">
    </head>
    <body>
        <div class = "full-screen-container">
            <div class = "main-page-container">
                <img src = "canteria.jpg" class = "restaurant-photo">
                <form class = "form-edit-restaurant">
                    <div class = "left-column">
                        <div class = "input-group">
                            <label for = "name">Nombre</label>
                            <input type = "text" name = "name" class = "text-input" required>
                        </div>
                        <div class = "input-group">
                            <label for = "address">DirecciÃ³n</label>
                            <input type = "textarea" name = "address" class = "text-input" required>
                        </div>
                        <div class = "input-group">
                            <label for = "telephone">TelÃ©fono</label>
                            <input type = "tel" name = "telephone" class = "text-input" required>
                        </div>
                        <div class = "input-group">
                            <label for = "email">Email</label>
                            <input type = "email" name = "email" class = "text-input" required>
                        </div>
                        <div class = "input-group">
                            <label for = "range">Precio</label>
                            <input type = "range" name = "range" class = "text-input" required>
                        </div>
                    </div>
                    <div class = "right-column">
                        <div class = "input-group">
                            <label for = "burguer">Burguer</label>
                            <input type = "checkbox" name = "burguer" required>
                        </div>
                        <div class = "input-group">
                            <label for = "pizzas">Pizzas</label>
                            <input type = "checkbox" name = "pizzas" required>
                        </div>
                        <div class = "input-group">
                            <label for = "kebab">Kebab</label>
                            <input type = "checkbox" name = "kebab" required>
                        </div>
                        <div class = "input-group">
                            <label for = "italiano">Italiano</label>
                            <input type = "checkbox" name = "italiano" required>
                        </div>
                        <div class = "input-group">
                            <label for = "americano">Americano</label>
                            <input type = "checkbox" name = "americano" required>
                        </div>
                        <div class = "input-group">
                            <label for = "range">ValoraciÃ³n</label>
                            <input type = "range" name = "range" required>
                        </div>
                        <label id = "bike-parking">Â¿Se pueden aparcar bicicletas?</label>
                        <div class = bike-radio>
                            <div class = "input-group">
                                <label for = "range">SÃ­</label>
                                <input type = "radio" name = "bici" value = "SÃ­" required>
                            </div>
                            <div class = "input-group">
                                <label for = "range">No</label>
                                <input type = "radio" name = "bici" value = "No" required>
                            </div>
                        </div>
                    </div>
                </form>
                <a href = "edit_plate.html" id = "manage-plates">Â¡Gestiona tus platos!</a>
                <button type = "submit" id = "confirm" onclick = "window.location.href='restaurants.html';">Aceptar</button>
            </div>
        </div>
    </body>
</html>