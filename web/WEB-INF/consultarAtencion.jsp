<%-- 
    Document   : consultarAtencion
    Created on : 15-11-2018, 17:08:15
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
    </head>
    <body>
        <!-- Navegación -->
        <ul>
            <li><a href=".">Inicio</a></li>
            <li><a href="agregarPaciente">Ingresar Paciente</a></li>
            <li><a href="consultarPaciente">Consultar Paciente</a></li>
            <li><a href="agregarAtencion">Ingresar Atención</a></li>
            <li><a href="consultarAtencion" class="active">Consultar Atenciones</a></li>
            <li><a href="consultarDentista">Odontólogos</a></li>
            <li style="float:right" class="inactive"><a href="logout">Cerrar Sesión</a></li>
        </ul>
        <!-- Tabla -->
        <h3>Listado de Atenciones</h3>
        <table id="tabla">
            <tr>
                <th>ID</th>
                <th>Fecha Atención</th>
                <th>Paciente</th>
                <th>Odontólogo</th>
                <th>Tratamiento</th>
                <th>Descripción</th>
                <th>Costo</th>
                <th>Fecha Registro</th>
                <th colspan="2">Acción</th>
            </tr>
            <c:forEach var="atencion" items="${atenciones}">
                <tr>
                    <td>${atencion.id_atencion}</td>
                    <td>${atencion.dia}-${atencion.mes}-${atencion.anio}</td>
                    <td>${atencion.paciente.nombre} ${atencion.paciente.apellido}</td>
                    <td>${atencion.dentista.nombre} ${atencion.dentista.apellido}</td>
                    <td>${atencion.tratamiento.nombre}</td>
                    <td>${atencion.descripcion}</td>
                    <td>$${atencion.tratamiento.costo}</td>
                    <td>${atencion.fecha_registro}</td>
                    <td>
                        <form action="consultarAtencion" method="POST">
                            <input type="hidden" value="${atencion.id_atencion}" name="id">
                            <button type="submit" class="btn btn-warning">Eliminar</button>
                        </form>
                    <td>
                        <a href="modificarAtencion?id=${atencion.id_atencion}" class="btn btn-primary">Modificar</a>
                    </td>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
