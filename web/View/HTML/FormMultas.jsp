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
                <form id="register-form" action="<%= request.getContextPath() %>/ServCrearMulta" method="POST">                    
                    <div class="form-group">
                    <label for="ID_prestamo">Código del Préstamo</label>
                    <input type="number" id="ID_prestamo" name="prestamo_id" list="prestamo" placeholder="Código del préstamo" required>
                    <datalist id="prestamo">
                    </datalist>
                    </div>
                    <div class="form-group">
                        <label for="nombres">Monto</label>
                        <input type="number" id="monto" name="monto" required placeholder="Monto de la multa"> 
                    </div>   
                    <div class="form-group">
                        <label for="nombres">Motivo</label>
                        <input type="text" id="motivo" name="motivo"required placeholder="Motivo de la multa">
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
