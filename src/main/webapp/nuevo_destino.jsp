
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="models.User" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="./css/general/general.css" />
    <link rel="stylesheet" href="./css/pages/formulario.css">
    
    
</head>
<body>
  <%
    User user = (User) request.getSession().getAttribute("user");
   %>

   
<h1>Agregar Nuevo Destino</h1>
<div class="form-container">
  <form action="/agregarDestino" method="post" class="formulario-agregar">
    <input type="text" id="id_current_user" name="id_current_user" value="<%= user.getId() %>">
    <div>
      <label for="nombre">Nombre:</label>
      <input type="text" id="nombre" name="nombre" required>
    </div>
    <div>
      <label for="pais">País:</label>
      <input type="text" id="pais" name="pais" required>
    </div>
    <div>
      <label for="puntuacion">Puntuación:</label>
      <input type="number" id="puntuacion" name="puntuacion" step="0.1" min="0" max="5" required>
    </div>
    <div>
      <label for="is_favorite">Favorito:</label>
      <input type="number" id="is_favorite" name="is_favorite"  min="0" max="1" required>
    </div>
    <div>
      <label for="url_image">URL de la imagen:</label>
      <input type="url" id="url_image" name="url_image" required>
    </div>
    <div>
      <button type="submit">Guardar Destino</button>
    </div>
  </form>
</div>
</body>
</html>

