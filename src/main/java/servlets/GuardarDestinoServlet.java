package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import utils.DatabaseConnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "GuardarDestinoServlet", value = "/GuardarDestinoServlet")
public class GuardarDestinoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String pais = request.getParameter("pais");
        double puntuacion = Double.parseDouble(request.getParameter("puntuacion"));
        int isFavorite = request.getParameter("is_favorite") != null ? 1 : 0;
        String urlImage = request.getParameter("url_image");
        int idCurrentUser = Integer.parseInt(request.getParameter("id_current_user"));

        Connection connection = null;
        try {
            connection = DatabaseConnector.getConnection();
        } catch (SQLException e) {
            e.printStackTrace(); 
            throw new ServletException("Error al guardar el destino en la base de datos", e);
        }

        try {
            // Query para insertar el nuevo destino en la tabla VIAJES
            String insertQuery = "INSERT INTO VIAJES (nombre, pais, puntuacion, is_favorite, url_image, user_id) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, pais);
            preparedStatement.setDouble(3, puntuacion);
            preparedStatement.setInt(4, isFavorite);
            preparedStatement.setString(5, urlImage);
            preparedStatement.setInt(6, idCurrentUser);

            // Ejecutar la inserción
            preparedStatement.executeUpdate();
            preparedStatement.close();

            // Redirigir a una página de éxito o a otra página de tu elección
            response.sendRedirect("index.jsp"); // Cambia "exito.jsp" por la página que deseas mostrar al guardar el destino
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar cualquier excepción que pueda ocurrir al guardar en la base de datos
            // Redirigir a una página de error o mostrar un mensaje de error apropiado

           //response.sendRedirect("index.jsp"); // Cambia "error.jsp" por la página de error que desees
        } finally {
            // Cerrar la conexión a la base de datos cuando ya no sea necesaria
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
