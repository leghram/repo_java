

<%
    String indexUrl="";
    String ticketsUrl="";
    String favoritosUrl="";
    String settingsUrl="";

    String url = request.getRequestURL().toString();
    if(url.contains("index")){
        indexUrl="active-url";
    }else if(url.contains("tickets")){
        ticketsUrl="active-url";
    }
    else if(url.contains("favoritos")){
        favoritosUrl="active-url";
    }
    else {
        settingsUrl="active-url";
    }

%>

    <nav>
      <ul class="menu-items-data">
        <a href="index.jsp" class="item-menu <%=indexUrl%>">Dashboard</a>
        <a href="tickets.jsp" class="item-menu <%=ticketsUrl%>">Tickets</a>
        <a href="favoritos.jsp" class="item-menu <%=favoritosUrl%>">Favoritos</a>
        <a href="settings.jsp" class="item-menu <%=settingsUrl%>">Settings</a>
      </ul>
    </nav>
