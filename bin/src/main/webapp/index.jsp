<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
    UserDAO userDAO = new UserDAO();
    int userId = 2;
    User currentUser = userDAO.getUserById(userId);
  %>

    <div class="body-content">
      <%@ include file="components/header.jsp" %>
      <div class="content-page">
        <%@ include file="components/header_index.jsp" %>
        <%@ include file="components/best_travel_section_index.jsp" %>
        <%@ include file="components/destinations-section.jsp" %>
      </div>
      <div class="content-info">
        <h2>Filters</h2>
      </div>
    </div>
  </body>

</html>
