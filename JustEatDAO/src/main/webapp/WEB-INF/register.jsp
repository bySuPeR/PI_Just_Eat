<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang = "es">
    <head>
        <meta charset = "UTF-8">
        <title>Just Eat</title>
        <link rel = "stylesheet" href = "general.css">
        <link rel = "stylesheet" href = "login.css">
    </head>
    <body>
        <div class = "full-screen-container">
            <div class = "login-container">
                <h1 class = "login-title">Registro</h1>
                <form class = "form">
                    <div class = "input-group">
                        <label for = "full-name">Nombre completo</label>
                        <input type = "text" name = "full-name" required>
                    </div>
                    <div class = "input-group">
                        <label for = "user-name">Nombre de Usuario</label>
                        <input type = "text" name = "user-name" required>
                    </div>
                    <div class = "input-group">
                        <label for = "email">Email</label>
                        <input type = "email" name = "email" id = "email" required>
                    </div>
                    <div class = "input-group">
                        <label for = "contraseÃ±a">ContraseÃ±a</label>
                        <input type = "password" name = "contraseÃ±a" id = "contraseÃ±a" pattern = "(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required>
                    </div>
                    <button type = "submit" class = "login-button" onclick = "window.location.href='search.html';">RegÃ­strate</button>
                    <span class = "question-text">Â¿Ya tienes cuenta?<a class = "question-link" href = "login.html">Â¡Inicia sesiÃ³n!</a></span>
                </form>
            </div>
        </div>
    </body>
</html>