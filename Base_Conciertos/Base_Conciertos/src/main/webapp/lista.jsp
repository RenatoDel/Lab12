<%@page import="com.example.Base_Conciertos.Beans.Artistas" %>
<%@page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:useBean id="listaArtistas" type="ArrayList<Artistas>" scope="request"/>
<!DOCTYPE html>
<html>
    <head>

        <title>Artistas</title>
    </head>
    <body>
    <nav class="navbar navbar-expand" style="background-color: #c1d6fa;">
        <div class="container-fluid">
            <a class="navbar-brand" th:href="@{'/'}">
                Artistas
            </a>
            <div class="collapse navbar-collapse" id="navbarText">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                    <li class="nav-item">
                        <a class="nav-link" th:href="@{'/artista'}">Artistas</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container">
        <div style="text-align: center;"><h1>Lista de Proveedores</h1></div>
        <table class="table">
            <thead>
            <tr>
                <th>Nombre Grupo</th>
                <th>Fecha Creacion</th>
                <th>Tipo musica</th>
            </tr>
            </thead>
            <tbody>
            <%
                int i = 1;
                for (Artistas a : listaArtistas ) {
            %>
            <tr>
                <td><%= i%>
                </td>
                <td><%= a.getNombre_Grupo()%>
                </td>
                <td><%= a.getFecha_creacion()%>
                </td>
                <td><%= a.getTipo_musica()%>
                <td>
                    <a href="<%=request.getContextPath()%>/ArtistasServlet?action=editar&id=<%= a.getIdArtistas()%>"
                       type="button" class="btn btn-primary">
                        <i class="bi bi-pencil-square"></i>
                    </a>
                </td>
                <td>
                    <a onclick="return confirm('¿Estas seguro de borrar?');"
                       href="<%=request.getContextPath()%>/ArtistasServlet?action=editar&id=<%= a.getIdArtistas()%>"
                       type="button" class="btn btn-danger">
                        <i class="bi bi-trash"></i>
                    </a>
                </td>
                <% } %>
            </tr>
            <%
                    i++;
                }
            %>
            </tbody>
        </table>
    </div>
    <div style="background-color: #dae0e8;">
        <div style="padding-top: 10px; padding-bottom: 10px;" class="container">
            # Grupo 3 PUCP @ 2023
        </div>

    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N"
            crossorigin="anonymous"></script>
    </body>
</html>
