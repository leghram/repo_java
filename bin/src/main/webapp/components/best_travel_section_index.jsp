<%
    int idCurrentUser = currentUser.getId();
    ViajeDAO viajeDAO = new ViajeDAO();
    List<Viaje> viajesPerUser = viajeDAO.getTop3ViajesByUserId(idCurrentUser);

    Viaje currentViaje = null;
%>

<div class="section-travel-index">
    <% for (Viaje viaje : viajesPerUser) {
        currentViaje = viaje;
    %>
    <div class="best-travel-box">
        <img class="img-best-travel-box" src="<%= currentViaje.getUrlImage() %>" alt="">
        <div class="info-best-travel">
            <h2> <%= currentViaje.getNombre() %></h2>
            <div class="pais-value-best-travel">
                <p><%= currentViaje.getPais() %></p>
                <p>4.4</p>
            </div>
        </div>
    </div>
    <% } %>
</div>