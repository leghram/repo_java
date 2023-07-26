<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="dao.UserDAO" %>
<%@ page import="models.User" %>

<!DOCTYPE html>
<html>
<head>
  <title>Login</title>
  <link rel="stylesheet" href="./css/general/general.css" />
  <link rel="stylesheet" href="./css/pages/login.css" />
</head>
<body>
  <div class="page-login">


<h1>Iniciar sesión</h1>
<div class="img-login">
  <img src="https://cdn.dribbble.com/users/1331/screenshots/2932603/flip.gif" alt="">
</div>
<div class="container-login">
  <form method="post" action="/login">
    <label for="username">Usuario:</label>
    <input type="text" id="username" name="username" required>
    <br>
    <label for="password">Contraseña:</label>
    <input type="password" id="password" name="password" required>
    <br>
    <input class="input-login" type="submit" value="Iniciar sesión">
  </form>
</div>
</div>

</body>
</html>
