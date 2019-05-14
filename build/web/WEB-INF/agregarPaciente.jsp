<%-- 
    Document   : agregarPaciente
    Created on : 15-11-2018, 17:07:53
    Author     : matias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clínica Dental</title>
        <!-- CSS -->
        <link rel="stylesheet" href="css/estilo.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <!-- JavaScript -->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="js/agregarPaciente.js"></script>
    </head>
    <body>
        <!-- Navegación -->
        <ul>
            <li><a href=".">Inicio</a></li>
            <li><a href="agregarPaciente" class="active">Ingresar Paciente</a></li>
            <li><a href="consultarPaciente">Consultar Paciente</a></li>
            <li><a href="agregarAtencion">Ingresar Atención</a></li>
            <li><a href="consultarAtencion">Consultar Atenciones</a></li>
            <li><a href="consultarDentista">Odontólogos</a></li>
            <li style="float:right" class="inactive"><a href="logout">Cerrar Sesión</a></li>
        </ul>
        <!-- Formulario -->
        <h3>Ingreso de Paciente</h3>
        <div>
            <form action="agregarPaciente" method="POST">
                <label for="rut">Rut</label>
                <input type="text" name="rut" id="tx_rut">

                <label for="nombre">Nombre</label>
                <input type="text" name="nombre" id="tx_nombre">

                <label for="apellido">Apellido</label>
                <input type="text" name="apellido" id="tx_apellido">

                <label for="direccion">Dirección</label>
                <input type="text" name="direccion" id="tx_direccion">

                <label for="telefono">Teléfono</label>
                <input type="number" name="telefono" id="tx_telefono">
                
                <label for="email">Email</label>
                <input type="email" name="email" id="tx_email">

                <input type="submit" value="Guardar" id="bt_guardar">
            </form>
            <h2 style="color: red">${mensaje}</h2>
            <c:forEach items="${mensajes}" var="mensaje">
                <h3 style="color: red">${mensaje}</h3>
            </c:forEach>
        </div>
    </body>
</html>
