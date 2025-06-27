<%-- 
    Document   : ConsMultas
    Created on : 22/06/2025, 12:13:48 a. m.
    Author     : DIEGO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar Multas</title>
        <link rel="stylesheet" href="<%= request.getContextPath()%>/View/CSS/ConsUserAdmin.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    </head>
    <body>
        <div class="content-container">
            <div class="content-header">
                <h2>Consultar Multas</h2>
            </div>
            <form class="search-group" action="<%= request.getContextPath() %>/ServBuscarMulta" method="POST">
                <input type="text" id="codigo" name="id" required placeholder="Búsqueda de multa por código">                
                <div class="button-group">
                    <button type="submit" class="search-button">
                        <i class="fas fa-search"></i>Buscar
                    </button>
                    <button type="button" class="btn-volver" data-action="volver" onclick="window.location.href = '/BibliotecaWeb/View/HTML/MenuAdmin.jsp'">Volver</button>
                </div>
            </form>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>ID del Préstamo</th>
                        <th>Monto</th>                        
                        <th>Motivo</th>
                        <th>Estado</th>
                        <th>Acción</th>
                    </tr>
                </thead>
                <c:if test="${not empty multa}">
                    <tbody>
                        <tr>
                            <td>${multa.getId()}</td>
                                <td>${multa.getMonto()}</td>
                                <td>${multa.getMotivo()}</td>
                                <td>${multa.getPrestamoID()}</td>
                                <td>${multa.getEstado()}</td>
                                <td>
                                    <a href="<%= request.getContextPath()%>/ServUpdateMulta?id=${multa.getId()}" class="tooltip">
                                        <img src="<%= request.getContextPath()%>/View/img/editar.png" alt="imagen editar" width="25px"/>
                                        <span class="tooltiptext">Actualizar multa</span>
                                    </a>
                                    <a href="<%= request.getContextPath()%>/ServDeleteMulta?id=${multa.getId()}" class="tooltip">
                                        <img src="<%= request.getContextPath()%>/View/img/borrar.png" alt="imagen eliminar" width="25px"/>
                                        <span class="tooltiptext">Eliminar multa</span>
                                    </a>
                                </td>
                        </tr>
                    </tbody>
                </c:if>
            </table>
        </div>
    </body>
</html>
