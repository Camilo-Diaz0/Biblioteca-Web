<%-- 
    Document   : formulario_ejemplares
    Created on : 18/06/2025, 12:10:05 a. m.
    Author     : Esteb
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registrar Ejemplar</title>
    <link rel="stylesheet" href="/BibliotecaWeb/View/CSS/formulario_ejemplares.css"
</head>
<body>
    <div class="register-container">
        <h2>Registrar Ejemplar</h2>
        <form id="formularioEjemplar" action="<%= request.getContextPath() %>/ServletEjemplar" method="POST" onsubmit="return validarFormulario()">
            <div class="form-group">
                <label for="codigo">Código del Ejemplar</label>
                <input type="number" id="codigo" name="codigo" required min="1" placeholder="Código único">
                <span class="error" id="error-codigo">El código debe ser un número positivo</span>
            </div>
            <div class="form-group">
                <label for="ubicacion">Ubicación</label>
                <input type="text" id="ubicacion" name="ubicacion" required placeholder="Sector o estantería">
                <span class="error" id="error-ubicacion">La ubicación debe tener al menos 3 caracteres</span>
            </div>
            <div class="form-group">
                <label for="estado_fisico">Estado Físico</label>
                <select id="estado_fisico" name="estado_fisico" required>
                    <option value="">Seleccione un estado</option>
                    <option value="Nuevo">Nuevo</option>
                    <option value="Dañado">Dañado</option>
                    <option value="Perdido">Perdido</option>
                </select>
                <span class="error" id="error-estado_fisico">Seleccione un estado físico</span>
            </div>
            <div class="form-group">
                <label for="estado">Estado en el Sistema</label>
                <select id="estado" name="estado" required>
                    <option value="">Seleccione un estado</option>
                    <option value="Activo">Activo</option>
                    <option value="Inactivo">Inactivo</option>
                </select>
                <span class="error" id="error-estado">Seleccione un estado</span>
            </div>
            <div class="form-group">
                <label for="id_libro">ID del Libro</label>
                <input type="number" id="id_libro" name="id_libro" required min="1" placeholder="ID del libro asociado">
                <span class="error" id="error-id_libro">El ID del libro debe ser un número positivo</span>
            </div>
            <div class="button-container">
                <button type="submit" name="accion" value="registrar" class="register-button">Registrar</button>
                <button type="button" name="accion" value="volver" class="back-button" formnovalidate>Volver</button>
            </div>
        </form>
    </div>

    <script>
        function validarFormulario() {
            let isValid = true;
            clearErrors();

            const codigo = document.getElementById('codigo').value;
            const ubicacion = document.getElementById('ubicacion').value.trim();
            const estado_fisico = document.getElementById('estado_fisico').value;
            const estado = document.getElementById('estado').value;
            const id_libro = document.getElementById('id_libro').value;

            if (codigo <= 0) {
                showError('codigo', 'El código debe ser un número positivo');
                isValid = false;
            }
            if (ubicacion.length < 3) {
                showError('ubicacion', 'La ubicación debe tener al menos 3 caracteres');
                isValid = false;
            }
            if (!estado_fisico) {
                showError('estado_fisico', 'Seleccione un estado físico');
                isValid = false;
            }
            if (!estado) {
                showError('estado', 'Seleccione un estado');
                isValid = false;
            }
            if (id_libro <= 0) {
                showError('id_libro', 'El ID del libro debe ser un número positivo');
                isValid = false;
            }

            return isValid;
        }

        function showError(field, message) {
            const errorElement = document.getElementById(`error-${field}`);
            errorElement.textContent = message;
            errorElement.style.display = 'block';
        }

        function clearErrors() {
            const errors = document.querySelectorAll('.error');
            errors.forEach(error => {
                error.textContent = '';
                error.style.display = 'none';
            });
        }
    </script>
</body>
</html>