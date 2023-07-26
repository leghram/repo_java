<%
    ViajeDAO viajeDAODos = new ViajeDAO();
    List<Viaje> viajesPerUserDos = viajeDAODos.getViajesByUserId(currentUser.getId());
    int cantidadViajes = viajesPerUserDos.size();

    Viaje currentViajeDos = null;
%>

<div class="destinations-section">
    <div class="destinos-header">
        <div>
            <h2>Destinos</h2>
            <p><%=cantidadViajes %> destinos encontrados.</p>
        </div>
        <a href="nuevo_destino.jsp" class="btn-agregar-destino">Agregar nuevo</a>
    </div>
    <div class="lista-destinos">

        <% for (Viaje viaje : viajesPerUserDos) {

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