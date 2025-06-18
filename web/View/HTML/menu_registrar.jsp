<%-- 
    Document   : menu_registrar
    Created on : 17/06/2025, 10:43:53 p. m.
    Author     : Esteb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menú Principal</title>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/View/CSS/menu_registrar.css">
</head>
<body>
    <h2>Menú Principal</h2>
    <form action="<%= request.getContextPath()%>/ServletMenuRegistrar" method="POST">
        <select id="menuOpciones" name = "options-formulario">
            <option value="" selected disabled>Seleccione una opción</option>
            <option value="usuarios">Usuarios</option>
            <option value="libros">Libros</option>
            <option value="ejemplares">Ejemplares</option>
        </select>
        <div class="button-container">
            <button class="go-button" name = "accion" value = "go" >Ir</button>
            <button class="back-button" name = "accion" value = "back">Volver</button>
        </div>
    </form>
    <script>
        function navegar() {
            const select = document.getElementById('menuOpciones');
            const url = select.value;
            if (url) {
                window.location.href = url;
            } else {
                alert('Por favor, seleccione una opción válida.');
            }
        }
    </script>
</body>
</html>
