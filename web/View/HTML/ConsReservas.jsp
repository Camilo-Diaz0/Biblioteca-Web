<%-- 
    Document   : ConsReservas
    Created on : 21/06/2025, 10:50:30 p. m.
    Author     : DIEGO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar Reservas</title>
        <link rel="stylesheet" href="<%= request.getContextPath()%>/View/CSS/ConsUserAdmin.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    </head>
    <body>
        <div class="content-container">
            <div class="content-header">
                <h2>Consultar Reservas</h2>
            </div>
            <form class="search-group" action="<%= request.getContextPath() %>/ServBuscarReserva" method="POST">
                <input type="text" id="codigo" name="id" required placeholder="Búsqueda de reserva por código">                
                <div class="button-group">
                    <button type="submit" class="search-button">
                        <i class="fas fa-search"></i>Buscar
                    </button>
                    <button type="button" class="btn-volver" data-action="volver" onclick="window.location.href = '/BibliotecaWeb/View/HTML/menu_admin.jsp'">Volver</button>
                </div>
            </form>
            <table>
                <thead>
                    <tr>
                        <th>ID de la reserva</th>
                        <th>ID Estudiante</th>
                        <th>ID del ejemplar</th>
                        <th>Fecha Reserva</th>                        
                        <th>Estado</th>
                        <th></th>
                    </tr>
                </thead>
                <c:if test="${not empty reserva}">
                    <tbody>
                        <tr>
                            <td>${reserva.getId()}</td>
                            <td>${reserva.getEstudianteID()}</td>
                            <td>${reserva.getEjemplarID()}</td>
                            <td>${reserva.getFechaString()}</td>
                            <td>${reserva.getEstado()}</td>
                            <td>
                                <a href="<%= request.getContextPath()%>/ServUpdateReserva?id=${reserva.getId()}" class="tooltip">
                                    <img src="<%= request.getContextPath()%>/View/img/editar.png" alt="imagen editar" width="25px"/>
                                    <span class="tooltiptext">Actualizar reserva</span>
                                </a>
                                <a href="<%= request.getContextPath()%>/ServDeleteReserva?id=${reserva.getId()}" class="tooltip">
                                    <img src="<%= request.getContextPath()%>/View/img/borrar.png" alt="imagen eliminar" width="25px"/>
                                    <span class="tooltiptext">Eliminar reserva</span>
                                </a>
                            </td>
                        </tr>
                    </tbody>
                </c:if>
            </table>
        </div>
    </body>
</html>
