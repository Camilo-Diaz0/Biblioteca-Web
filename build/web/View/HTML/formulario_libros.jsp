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
    <form id="formularioLibro" onsubmit="handleSubmit(event)">
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
                <option value="Disponible">Disponible</option>
                <option value="No Disponible">No Disponible</option>
            </select>
            <span class="error" id="error-estado"></span>
        </div>
        <button type="submit">Registrar Libro</button>
        <button type="button" class="back-button" onclick="window.location.href='index.html'">Volver</button>
    </form>

    <script>
        function handleSubmit(event) {
            event.preventDefault();
            clearErrors();

            const id = document.getElementById('id').value;
            const titulo = document.getElementById('titulo').value.trim();
            const autor = document.getElementById('autor').value.trim();
            const materia = document.getElementById('materia').value.trim();
            const fecha_publicacion = document.getElementById('fecha_publicacion').value;
            const estado = document.getElementById('estado').value;

            let isValid = true;

            if (id <= 0) {
                showError('id', 'El ID debe ser un número positivo');
                isValid = false;
            }
            if (titulo.length < 2) {
                showError('titulo', 'El título debe tener al menos 2 caracteres');
                isValid = false;
            }
            if (!/^[a-zA-Z\s]+$/.test(autor)) {
                showError('autor', 'El autor solo debe contener letras y espacios');
                isValid = false;
            }
            if (materia.length < 2) {
                showError('materia', 'La materia debe tener al menos 2 caracteres');
                isValid = false;
            }
            if (!fecha_publicacion) {
                showError('fecha', 'Seleccione una fecha válida');
                isValid = false;
            }

            if (isValid) {
                const libro = {
                    id: parseInt(id),
                    titulo,
                    autor,
                    materia,
                    fecha_publicacion: new Date(fecha_publicacion),
                    estado
                };
                console.log('Libro registrado:', libro);
                alert('Libro registrado con éxito');
                document.getElementById('formularioLibro').reset();
            }
        }

        function showError(field, message) {
            document.getElementById(`error-${field}`).textContent = message;
        }

        function clearErrors() {
            const errors = document.querySelectorAll('.error');
            errors.forEach(error => error.textContent = '');
        }
    </script>
</body>
</html>
