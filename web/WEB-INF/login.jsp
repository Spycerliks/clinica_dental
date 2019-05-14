<%-- 
    Document   : login
    Created on : 15-11-2018, 17:08:27
    Author     : matias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clínica Dental</title>
        <!-- CSS -->
        <link rel="stylesheet" href="css/login.css">
    </head>
    <body style="text-align: center">
        <form action="." method="POST">
            <div class="container">
                <img src="images/login-logo.png" width="140px" height="100px"><br>
                
                <label for="usuario"><b>Correo electrónico</b></label>
                <input type="email" placeholder="Ingresa correo electrónico" name="usuario" required>

                <label for="pass"><b>Contraseña</b></label>
                <input type="password" placeholder="Ingresa contraseña" name="pass" required>

                <button type="submit">Iniciar Sesión</button>
                
                <p>${mensaje}</p>
            </div>
        </form>
    </body>
</html>
