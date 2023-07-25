<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.UserDAO" %>
<%@ page import="models.User" %>

<!DOCTYPE html>
<html>
  <head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="./css/general/general.css" />
    <link rel="stylesheet" href="./css/components/navigation.css" />
    <link rel="stylesheet" href="./css/pages/dashboard.css" />
  </head>
  <body>
    <div class="body-content">
      <%@ include file="components/header.jsp" %>
      <div class="content-page">
        <%@ include file="components/header_index.jsp" %>
        <%@ include file="components/best_travel_section_index.jsp" %>
        <%@ include file="components/destinations-section.jsp" %>
      </div>
      <div class="content-info">
        <h1>Home Dashboard Page</h1>
      </div>
    </div>
  </body>

  <div>
    <table border="1">
      <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Correo</th>
        <th>Contraseña</th>
      </tr>
      <%
        try {
          // Crear una instancia del UserDAO
          UserDAO userDAO = new UserDAO();

          // Obtener la lista de usuarios
          List<User> users = userDAO.getAllUsers();

          // Iterar sobre la lista de usuarios y mostrarlos en la tabla
          for (User user : users) {

      %>
      <tr>
        <td><%= user.getId() %></td>
        <td><%= user.getNombre() %></td>
        <td><%= user.getCorreo() %></td>

      </tr>
      <%
          }
        } catch (Exception e) {
          // Manejo de errores
            out.println("asdf NO CARGA CTMARE"+ e);
          e.printStackTrace();
        }
      %>
    </table>
  </div>

</html>
