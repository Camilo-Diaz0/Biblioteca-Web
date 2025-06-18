<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="Content-Type" content="text/html">
  <title>Formulario</title>
  <link rel="stylesheet" href="<%= request.getContextPath()%>/View/CSS/formulario.css">
</head>
<body>
  <div class="register-container">
    <h2>Registrar Usuario</h2>
    <form action="<%= request.getContextPath() %>/ServletFormulario" method="POST">
      <div class="form-group">
        <label for="name">Nombre completo</label>
        <input type="text" id="name" name="name" required placeholder="Nombre">
      </div>
      <div class="form-group">
        <label for="lastname">Apellido completo</label>
        <input type="text" id="lastname" name="lastname" required placeholder="Apellido">
      </div>
      <div class="form-group">
        <label for="codigo">Código</label>
        <input type="text" id="codigo" name="codigo" required placeholder="Código del usuario"> 
      </div>
      <div class="form-group">
        <label for="email">Correo electrónico</label>
        <input type="email" id="email" name="email" required placeholder="correo@ejemplo.com">
      </div>
      <div class="form-group">
        <label for="password">Contraseña</label>
        <input type="password" id="password" name="password" required minlength="8" placeholder="Mínimo 8 caracteres">
      </div>
      <div class="form-group">
            <label for="role">Rol</label>
            <select id="role" name="role" required>
                <option value="">Seleccione un rol</option>
                <option value="admin">Administrador</option>
                <option value="student">Estudiante</option>
                <option value="bibl">Bibliotecario</option>
            </select>
      </div>
      <div class="form-group">
        <label>Estado: </label>
        <div class="radio-group">
            <label for="activo">Activo</label>
            <input type="radio" id="activo" name="estado" value= "Activo" required>
            <label for="inactivo">Inactivo</label>
            <input type="radio" id="inactivo" name="estado" value="Inactivo">
        </div> 
        </div>
      <button type ="submit" class="register-button">Registrar</button>
    </form>
  </div>
</body>
</html>
