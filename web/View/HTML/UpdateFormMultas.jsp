<%-- 
    Document   : FormMultas
    Created on : 22/06/2025, 12:05:30 a. m.
    Author     : DIEGO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Multas</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/View/CSS/FormsAdmin.css">
    </head>
    <body>
        <div class="form-wrapper">
            <div class="form-header">
                <h2>Registro de Multas</h2>
            </div>
            <div class="form-container">
                <form id="register-form" action="<%= request.getContextPath() %>/ServUpdateMulta" method="POST">                    
                    <div class="form-group">
                        <label for="codigo">Id de la multa</label>
                        <input type="text" id="codigo" name="id" required placeholder="Código de la multa" value="${multa.getId()}" readonly>
                    </div>
                    
                    <div class="form-group">
                        <label for="ID_prestamo">Id del Préstamo</label>
                        <input type="text" id="ID_prestamo" name="prestamo_id" list="prestamo" placeholder="Código del préstamo" required value="${multa.getPrestamoID()}">
                        <datalist id="prestamo">
                        </datalist>
                    </div>
                    
                    <div class="form-group">
                        <label for="nombres">Monto</label>
                        <input type="text" id="monto" name="monto" required placeholder="Monto de la multa" value="${multa.getMonto()}"> 
                    </div>   
                    <div class="form-group">
                        <label for="nombres">Motivo</label>
                        <input type="text" id="motivo" name="motivo" required placeholder="Motivo de la multa" value="${multa.getMotivo()}">
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
