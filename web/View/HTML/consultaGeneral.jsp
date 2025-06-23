<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="<%= request.getContextPath()%>/View/CSS/consultaGeneral.css">
    </head>
    <body>
        <h1>Consulta general</h1>

        <!-- Formulario con comboBox -->
        <div class="form-container">
            <form action="<%= request.getContextPath()%>/ServletConsultaGeneral" method="GET">
                <label for="entidad">Selecciona una entidad:</label>
                <select id="entidad" name="entidad" required>
                    <option value="" disabled selected>Selecciona una opción</option>
                    <option value="administrador">Administrador</option>
                    <option value="bibliotecario">Bibliotecario</option>
                    <option value="estudiante">Estudiante</option>
                </select>
                <div class="button-panel">
                    <input type="submit" value="Buscar">
                    <button class = "botonCerrar" type = "button" onclick="window.location.href='<%= request.getContextPath()%>/View/HTML/menu_admin.jsp'">
                        Cerrar
                    </button> 
                </div>
            </form>
            
        </div>

        <!-- Tabla dinámica -->
        <c:if test="${not empty data}">
            <table>
                <thead>
                    <tr>
                        <!-- Generar encabezados dinámicamente -->
                        <c:if test="${not empty data[0]}">
                            <c:forEach var="title" items="${data[0]}">
                                <th><c:out value="${title.key}"/></th>
                            </c:forEach>
                            <th></th>
                        </c:if>
                    </tr>
                </thead>
                <tbody>
                    <!-- Iterar sobre cada fila de datos -->
                    <c:forEach var="row" items="${data}">
                        <tr>
                            <!-- Iterar sobre los valores de cada fila -->
                            <c:forEach var="value" items="${row}">
                                <c:if test="${value.key =='id'}">
                                    <c:set var="idUsuario" value="${value.value}" />
                                </c:if>
                                <td><c:out value="${value.value}"/></td>
                            </c:forEach>
                            <td>
                                <a href="<%= request.getContextPath()%>/ServletUpdate?id=${code}${idUsuario}" class="tooltip">
                                    <img src="<%= request.getContextPath()%>/View/img/editar.png" alt="imagen editar" width="20px"/>
                                    <span class="tooltiptext">Modificar usuario</span>
                                </a>
                                
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </body>
</html>