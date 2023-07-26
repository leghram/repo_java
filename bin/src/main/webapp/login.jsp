<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="dao.UserDAO" %>
<%@ page import="models.User" %>

<!DOCTYPE html>
<html>
<head>
  <title>Login</title>
</head>
<body>
<h1>Iniciar sesión</h1>
<form method="post" action="login.jsp">
  <label for="username">Usuario:</label>
  <input type="text" id="username" name="username" required>
  <br>
  <label for="password">Contraseña:</label>
  <input type="password" id="password" name="password" required>
  <br>
  <input type="submit" value="Iniciar sesión">
</form>

<%-- Verificar el inicio de sesión al enviar el formulario --%>
<%
  if (request.getMethod().equalsIgnoreCase("post")) {
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    try {
      UserDAO userDAO = new UserDAO();
      User user = userDAO.getUserByUsername(username);

      if (user != null && user.getPassword().equals(password)) {
        // Autenticación exitosa
        session.setAttribute("user", user);
        response.sendRedirect("index.jsp");
      } else {
        // Autenticación fallida, establecemos el mensaje de error
        request.setAttribute("errorMessage", "Nombre de usuario o contraseña incorrectos");
      }
    } catch (SQLException e) {
      // Error en la base de datos
      request.setAttribute("errorMessage", "Error en la base de datos");
    }
  }
%>
</body>
</html>
