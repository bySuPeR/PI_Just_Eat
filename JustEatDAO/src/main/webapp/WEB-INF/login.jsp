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
                <h1 class = "login-title">Bienvenido</h1>
                <form class = "form">
                    <div class = "input-group">
                        <label for = "email">Email</label>
                        <input type = "email" name = "email" id = "email" required>
                    </div>
                    <div class = "input-group">
                        <label for = "contraseÃ±a">ContraseÃ±a</label>
                        <input type = "password" name = "contraseÃ±a" id = "contraseÃ±a" minlength = "8" required>
                    </div>
                    <button type = "submit" class = "login-button" onclick = "window.location.href='search.html';">Iniciar sesiÃ³n</button>
                    <span class = "question-text">Â¿Eres nuevo?<a class = "question-link" href = "register.html">Â¡RegÃ­strate!</a></span>
                </form>
            </div>
        </div>
    </body>
</html>