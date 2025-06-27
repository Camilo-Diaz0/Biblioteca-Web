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
                <form id="register-form" action="<%= request.getContextPath() %>/ServUpdateReserva" method="POST">                    
                    <div class="form-group">
                        <label for="codigo">Id de la reserva</label>
                        <input type="text" id="codigo" name="id" required placeholder="Código de la reserva" value="${reserva.getId()}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="codigo_estudiante">Código del Estudiante</label>
                        <input type="text" id="codigo_estudiante" name="estudiante_id" list="estudiante" placeholder="Código del estudiante" required value="${reserva.getEstudianteID()}">
                        <datalist id="estudiante">
                        </datalist>
                    </div>
                    <div class="form-group">
                        <label for="codigo">Id del ejemplar</label>
                        <input type="text" id="id_ejemplar" name="id_ejemplar" required placeholder="Id del ejemplar" value="${reserva.getEjemplarID()}">
                    </div>
                    <div class="form-group">
                        <label for="nombres">Fecha</label>
                        <input type="date" id="fecha" name="fecha" value="${reserva.getFechaString()}">
                    </div>                    
                    
                    <div class="button-group">
                        <button type="reset" class="btn btn-limpiar">Limpiar</button>
                        <button type="submit" class="btn btn-registrar">Actualizar</button>
                        <button type="button" class="btn btn-volver" data-action="volver" onclick="window.location.href = '/BibliotecaWeb/View/HTML/menu_admin.jsp'"> Cancelar</button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>

