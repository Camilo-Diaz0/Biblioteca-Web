<%-- 
    Document   : formulario_libros
    Created on : 17/06/2025, 10:21:39 p. m.
    Author     : Esteb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario de Libro</title>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/View/CSS/formulario_libros.css">
</head>
<body>
    <h2>Registro de Libro</h2>
    <form id="formularioLibro" action="<%= request.getContextPath() %>/ServletFormularioLibros" method="POST">
        <div class="form-group">
            <label for="id">ID del Libro:</label>
            <input type="number" id="id" name="id" required min="1">
            <span class="error" id="error-id"></span>
        </div>
        <div class="form-group">
            <label for="titulo">Título:</label>
            <input type="text" id="titulo" name="titulo" required>
            <span class="error" id="error-titulo"></span>
        </div>
        <div class="form-group">
            <label for="autor">Autor:</label>
            <input type="text" id="autor" name="autor" required>
            <span class="error" id="error-autor"></span>
        </div>
        <div class="form-group">
            <label for="materia">Materia:</label>
            <input type="text" id="materia" name="materia" required>
            <span class="error" id="error-materia"></span>
        </div>
        <div class="form-group">
            <label for="fecha_publicacion">Fecha de Publicación:</label>
            <input type="date" id="fecha_publicacion" name="fecha_publicacion" required>
            <span class="error" id="error-fecha"></span>
        </div>
        <div class="form-group">
            <label for="estado">Estado:</label>
            <select id="estado" name="estado" required>
                <option value="DISPONIBLE">Disponible</option>
                <option value="PRESTADO">Prestado</option>
                <option value="RESERVADO">Reservado</option>
                <option value="PERDIDO">Perdido</option>
            </select>
            <span class="error" id="error-estado"></span>
        </div>
        <button name="accion" value="go">Registrar Libro</button>
        <button class="back-button" name="accion" value="back" formnovalidate>Volver</button>
    </form>
</body>
</html>
