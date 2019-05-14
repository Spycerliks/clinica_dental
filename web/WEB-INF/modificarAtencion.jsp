<%-- 
    Document   : modificarAtencion
    Created on : 15-11-2018, 17:10:02
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
        <script src="js/modificarAtencion.js"></script>
    </head>
    <body>
        <!-- Navegación -->
        <ul>
            <li><a href=".">Inicio</a></li>
            <li><a href="agregarPaciente">Ingresar Paciente</a></li>
            <li><a href="consultarPaciente">Consultar Paciente</a></li>
            <li><a href="agregarAtencion">Ingresar Atención</a></li>
            <li><a href="consultarAtencion">Consultar Atenciones</a></li>
            <li><a href="consultarDentista">Odontólogos</a></li>
            <li style="float:right" class="inactive"><a href="logout">Cerrar Sesión</a></li>
        </ul>
        <!-- Formulario -->
        <h3>Modificar Atención</h3>
        <div>
            <form action="modificarAtencion" method="POST">
                <input type="hidden" value="${atencion.id_atencion}" name="id"/>
                
                <label for="dia">Día</label>
                <input type="number" value="${atencion.dia}" name="dia" id="tx_dia">
                
                <label for="mes">Mes</label>
                <input type="number" value="${atencion.mes}" name="mes" id="tx_mes">
                
                <label for="anio">Año</label>
                <input type="number" value="${atencion.anio}" name="anio" id="tx_anio">

                <label for="pac">Paciente</label>
                <select name="pac" id="sl_paciente">
                    <option value="">Seleccione paciente...</option>
                    <c:forEach items="${pacs}" var="pac">
                        <option value="${pac.id_paciente}" ${(pac.id_paciente eq e)?'selected':''}>${pac.nombre} ${pac.apellido}</option>
                    </c:forEach>
                </select>

                <label for="den">Odontólogo</label>
                <select name="den" id="sl_dentista">
                    <option value="">Seleccione odontólogo...</option>
                    <c:forEach items="${dens}" var="den">
                        <option value="${den.id_dentista}" ${(den.id_dentista eq e)?'selected':''}>${den.nombre} ${den.apellido}</option>
                    </c:forEach>
                </select>

                <label for="trat">Tratamiento</label>
                <select name="trat" id="sl_tratamiento">
                    <option value="">Seleccione tratamiento...</option>
                    <c:forEach items="${trats}" var="trat">
                        <option value="${trat.id_tratamiento}" ${(trat.id_tratamiento eq e)?'selected':''}>${trat.nombre}</option>
                    </c:forEach>
                </select>

                <label for="descripcion">Descripción</label>
                <textarea name="descripcion" id="ta_descripcion">${atencion.descripcion}</textarea>

                <input type="submit" value="Modificar" id="bt_modificar">
                <a href="consultarAtencion" class="btn btn-warning" style="width: 100%">Cancelar Edición</a>
            </form>
            <h2 style="color: red">${mensaje}</h2>
            <c:forEach items="${mensajes}" var="mensaje">
                <h3 style="color: red">${mensaje}</h3>
            </c:forEach>
        </div>
    </body>
</html>
