<%-- 
    Document   : FormReservas
    Created on : 21/06/2025, 9:47:50 p. m.
    Author     : DIEGO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Reservas</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/View/CSS/FormsAdmin.css">
    </head>
    <body>
        <div class="form-wrapper">
            <div class="form-header">
                <h2>Registro de Reservas</h2>
            </div>
            <div class="form-container">
                <form id="register-form" action="<%= request.getContextPath() %>/ServCrearReserva" method="POST">                    
                    <div class="form-group">
                    <label for="codigo_estudiante">Código del Estudiante</label>
                    <input type="text" id="codigo_estudiante" name="estudiante_id" list="estudiante" placeholder="Código del estudiante" value="${usuario.getCodigo()}" required>
                    <datalist id="estudiante">
                    </datalist>
                    </div>
                    <div class="form-group">
                        <label for="codigo">Id del ejemplar</label>
                        <input type="text" id="codigo" name="id_ejemplar" required placeholder="Código de la reserva" value="${ejemplar_id}">
                    </div>
                    <div class="form-group">
                        <label for="nombres">Fecha</label>
                        <input type="date" id="fecha" name="fecha">
                    </div>                    
                    
                    <div class="button-group">
                        <button type="reset" class="btn btn-limpiar">Limpiar</button>
                        <button type="submit" class="btn btn-registrar">Registrar</button>
                        <button type="button" class="btn btn-volver" data-action="volver" onclick="window.location.href = '/BibliotecaWeb/View/HTML/menu_admin.jsp'"> Volver</button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>

