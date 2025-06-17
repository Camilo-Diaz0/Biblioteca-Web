<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                background-color: #f4f7fa;
                margin: 0;
                padding: 40px;
                color: #333;
            }

            h1 {
                color: #2c3e50;
                text-align: center;
                font-size: 2.5em;
                margin-bottom: 30px;
                text-transform: uppercase;
                letter-spacing: 1px;
            }

            /* Form container styling */
            .form-container {
                display: flex;
                flex-direction: column;
                align-items: center;
                padding: 20px;
                background-color: #f0f0f0;
                border-radius: 8px;
                width: fit-content;
                margin: 50px auto;
            }

            .form-container:hover {
                transform: translateY(-5px);
            }

            /* Form elements */
            .form-container label {
                margin-bottom: 10px;
                font-size: 16px;
            }

            .form-container select {
                margin-bottom: 20px;
                padding: 8px;
                font-size: 16px;
                width: 200px;
                border-radius: 5px;
            }

            select:focus {
                outline: none;
                border-color: #3498db;
                box-shadow: 0 0 8px rgba(52, 152, 219, 0.3);
            }
            
            .button-panel {
                display: flex;
                justify-content: center;
                gap: 20px;
            }
            
            .botonCerrar {
                display: block;
                margin: 20px auto 0;
                padding: 12px 30px;
                font-size: 1.1em;
                color: #fff;
                background-color: #c0392b;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                transition: background-color 0.3s ease, transform 0.2s ease;
            }

            .botonCerrar:hover {
                background-color: #a93226;
                transform: scale(1.05);
            }

            input[type="submit"] {
                display: block;
                margin: 20px auto 0;
                padding: 12px 30px;
                font-size: 1.1em;
                color: #fff;
                background-color: #3498db;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                transition: background-color 0.3s ease, transform 0.2s ease;
            }

            input[type="submit"]:hover {
                background-color: #2980b9;
                transform: scale(1.05);
            }
        </style>
    </head>
    <body>
        <h1>Consulta general</h1>

        <!-- Formulario con comboBox -->
        <div class="form-container">
            <form action="<%= request.getContextPath()%>/ServletMenuActualizar" method="POST">
                <label for="entidad">Selecciona una entidad:</label>
                <select id="entidad" name="entidad" required>
                    <option value="" disabled selected>Selecciona una opción</option>
                    <option value="usuario">Usuarios</option>
                    <option value="libro">Libro</option>
                    <option value="prestamo">Prestamo</option>
                </select>
                <div class="button-panel">
                    <input type="submit" value="Actualizar">
                    <button class = "botonCerrar" type = "button" onclick="window.location.href='<%= request.getContextPath()%>/View/HTML/menu_admin.jsp'">
                        Cerrar
                    </button> 
                </div>
            </form>
        </div>
    </body>
</html>