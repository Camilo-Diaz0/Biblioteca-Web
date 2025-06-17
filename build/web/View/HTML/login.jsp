<%-- 
    Document   : login
    Created on : 21/04/2025, 2:24:56 p. m.
    Author     : Esteb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Login</title>
  <link rel="stylesheet" href="<%= request.getContextPath()%>/View/CSS/login.css">
</head>
<body>
  <div class="login-container">
    <h2>Iniciar Sesión</h2>
    <form action="<%= request.getContextPath() %>/ServletLogin" method="POST">
      <div class="form-group">
        <label for="codigo">Codigo</label>
        <input type="codigo" id="codigo" name="codigo" required placeholder="2357...">
      </div>
      <div class="form-group">
        <label for="password">Contraseña</label>
        <input type="password" id="password" name="password" required minlength="6" placeholder="Tu contraseña">
      </div>
      <button type="submit" class="login-button">Entrar</button>
    </form>
  </div>
</body>
</html>
