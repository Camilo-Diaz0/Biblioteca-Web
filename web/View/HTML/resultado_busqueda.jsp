<%-- 
    Document   : ResultadoBusqueda
    Created on : 6/05/2025, 8:59:35 p. m.
    Author     : Esteb
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <link rel="stylesheet" href="<%= request.getContextPath()%>/View/CSS/resultado_busqueda.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="search-results-panel" id="search-results-panel">
            <label>Resultados de consulta</label>
            <div class="results-container">
                <table class="results-table">
                    <thead>
                        <tr>
                            <th>Código</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Estado</th>
                            <th>Correo electrónico</th>  
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${not empty userData}">
                            <tr>
                                <td><c:out value="${userData[0]}"/></td> <!-- ID -->
                                <td><c:out value="${userData[1]}"/></td> <!-- Nombre -->
                                <td><c:out value="${userData[2]}"/></td> <!-- Apellido -->
                                <td><c:out value="${userData[3]}"/></td> <!-- Estado -->
                                <td><c:out value="${userData[4]}"/></td> <!-- Correo -->
                            </tr>
                        </c:if>
                        <c:if test="${empty userData}">
                            <tr>
                                <td colspan="5">No se encontraron resultados.</td>
                            </tr>
                        </c:if>
                    </tbody>
                </table> 
            </div>
        </div>
    </body>
</html>
