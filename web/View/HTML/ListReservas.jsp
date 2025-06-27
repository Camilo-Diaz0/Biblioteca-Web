<%-- 
    Document   : ListReservas
    Created on : 21/06/2025, 11:10:09 p. m.
    Author     : DIEGO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Reservas</title>
        <link rel="stylesheet" href="<%= request.getContextPath()%>/View/CSS/ConsUserAdmin.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    </head>
    <body>
        <div class="content-container">
        <div class="content-header">
            <h2>Listado de Reservas</h2>
        </div>

        <table style="margin-top: 30px">
            <thead>
                <tr>
                    <th>Id de la reserva</th>
                    <th>Id del Estudiante</th>
                    <th>Id del ejemplar</th>
                    <th>Fecha Reserva</th>                        
                    <th>Estado</th>
                    <th>Acción</th>
                </tr>
            </thead>
            <c:if test="${not empty lista}">
                <tbody>
                    <c:forEach var="reserva" items="${lista}">
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
                    </c:forEach>
                   
                </tbody>
            </c:if>
        </table>
        </div>
    </body>
</html>
