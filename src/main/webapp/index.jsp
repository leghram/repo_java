<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="utils.DatabaseConnector" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.SQLException" %>

<!DOCTYPE html>
<html>
  <head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="./css/general/general.css" />
    <link rel="stylesheet" href="./css/components/navigation.css" />
    <link rel="stylesheet" href="./css/pages/dashboard.css" />
  </head>
  <body>
    <div>
        <%
            Connection connection = null;

            try {
                // Obtener la conexión a la base de datos
                connection = DatabaseConnector.getConnection();

                // Mostrar un mensaje si la conexión se establece correctamente
                out.println("<p>Conexión exitosa a la base de datos.</p>");

                // Aquí puedes realizar otras operaciones con la base de datos si lo deseas

            } catch (SQLException e) {
                // Mostrar el mensaje de error si hay un problema de conexión
                out.println("<p>Error al conectar a la base de datos: " + e.getMessage() + "</p>");
                e.printStackTrace();
            } finally {
                // Cerrar la conexión si está abierta
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    // Mostrar el mensaje de error si hay problemas al cerrar la conexión
                    out.println("<p>Error al cerrar la conexión: " + e.getMessage() + "</p>");
                    e.printStackTrace();
                }
            }
        %>
    </div>
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
</html>
