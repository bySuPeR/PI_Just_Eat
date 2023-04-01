<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang = es>
    <head>
        <meta charset = "UTF-8">
        <title>Just Eat</title>
        <link rel = "stylesheet" href = "general.css">
        <link rel = "stylesheet" href = "res_details.css">
    </head>
    <body>
        <div class = "full-screen-container">
            <div class = "main-page-container">
                <div class="foto-restaurante">
                    <div class="apartados-restaurante">
                        <div class = "restaurant-container">
                            <div class="logo-restaurante">
                                <a href="edit_restaurant.html"><img src="burguertown.png" height="90px" width="100px"></a>
                            </div>
                            <h1 id="titulo">Burguer Town</h1>
                            <h3 id="tipo"> Burguer</h3>
                            <div class="puntuacion">
                                <a id="foto_valoracion"><img src="valoracion.png" height="90px" width="100px"></a>
                                <h2 id="valoracion">8,5</h2>
                            </div>
                            <div class="contacto">
                                <h3 id="email">burguertown@gmail.com</h3>
                                <h3 id="telefono">66235784</h3>
                            </div>
                            <h3 id="direccion">Plaza del MadroÃ±o, 2, CÃ¡ceres, 10005</h3>
                            <h3 id="bike"> Bike Friendly</h3>
                            </form>
                            <div class="preferidos">
                                <input type = "button" id="cheesburguer"  class = "tipo_burguer">
                                <p id="desc1">Burguer con queso, lechuga y pepinillos</p>
                                <h4 id="precio1">CHEESBURGUER 12â¬</h4>
                                <input type = "button" id="bbqburguer"  class = "tipo_burguer">
                                <p id="desc2">Burguer con queso, bacon, salsa barbacoa</p>
                                <h4 id="precio2">BBQBURGUER 14â¬</h4>
                                <input type = "button" id="thetown"  class = "tipo_burguer">
                                <p id="desc3">Burguer con queso, lechuga, tomate y salsa ranchera</p>
                                <h4 id="precio3">THETOWN 18â¬</h4>
                            </div>
                        </div>
                        <div class="order-container ">
                            <h1 id="titulo_pedido">Termina tu pedido</h1>
                            <input type = "button" value = "Pagar">
                            <div class="pedido">
                                <h4 id="pedido_minimo">Pedido mÃ­nimo: 10â¬</h3>
                                <h4 id="gasto_envio">Gasto de envÃ­os: 1,5â¬</h3>
                            </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>