<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.UserDAO" %>
<%@ page import="dao.ViajeDAO" %>
<%@ page import="models.User" %>
<%@ page import="models.Viaje" %>
<!DOCTYPE html>
<html>
  <head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="./css/general/general.css" />
    <link rel="stylesheet" href="./css/components/navigation.css" />
    <link rel="stylesheet" href="./css/pages/dashboard.css" />
  </head>
  <body>
    <%
    User user = (User) request.getSession().getAttribute("user");
    
    UserDAO userDAO = new UserDAO();
    int userId = user.getId();
    User currentUser = userDAO.getUserById(userId);

    ViajeDAO viajeDAONuevo = new ViajeDAO();
    List<Viaje> viajesPerUserNuevo = viajeDAONuevo.getViajesFavoritosByUserId(currentUser.getId());

    Viaje currentViajeNuevo = null;
  %>
    <div class="body-content">
      <%@ include file="components/header.jsp" %>
      <div class="content-page">
        <%@ include file="components/header_index.jsp" %>
        <div class="lista-destinos">
          <% for (Viaje viaje : viajesPerUserNuevo) {

            %>
            <div class="destiny-item-box">
                <div class="img-space-destiny-item">
                    <img src="<%=viaje.getUrlImage() %>" alt="">
                </div>
                <div>
                    <h3><%=viaje.getNombre() %></h3>
                </div>
                <div>
                    100$
                </div>
                <div>
                    <button class="btn-update-destiny">Update</button>
                </div>
            </div>
            <% } %>
        </div>
      </div>
    </div>
  </body>
</html>
