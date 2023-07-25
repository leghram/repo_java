package servlets;

import dao.UserDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.User;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet ", value = "/LoginServlet ")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDAO userDAO = new UserDAO();
        try {
            User user = userDAO.getUserByUsername(username);

            if (user != null && user.getPassword().equals(password)) {
                // El usuario existe y la contraseña es correcta
                // Agregar el usuario a la sesión
                request.getSession().setAttribute("user", user);

                // Redireccionar a la página de inicio
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            } else {
                // El usuario no existe o la contraseña es incorrecta
                // Redireccionar de nuevo a la página de inicio de sesión con un mensaje de error
                request.setAttribute("error", "Usuario o contraseña incorrectos");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            // Manejar la excepción en caso de un problema con la base de datos
            e.printStackTrace();
            request.setAttribute("error", "Error en la base de datos");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
