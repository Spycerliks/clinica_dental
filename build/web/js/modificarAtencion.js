/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 Created on : 17-10-2018, 14:18:40
 Author     : matias
 */

$(document).ready(function () {
    //Validadores
    $("#bt_modificar").on("click", function () {
        //Día
        var dia = $("#tx_dia").val();
        if (dia.trim().length === 0) {
            alert("Debe ingresar el día");
            return false;
        } else if (dia < 1 || dia > 31) {
            alert("El número de día es incorrecto");
            return false;
        }
        //Mes
        var mes = $("#tx_mes").val();
        if (mes.trim().length === 0) {
            alert("Debe ingresar el mes");
            return false;
        } else if (mes < 1 || mes > 12) {
            alert("El número de mes es incorrecto");
            return false;
        }
        //Año
        var anio = $("#tx_anio").val();
        if (anio.trim().length === 0) {
            alert("Debe ingresar el año");
            return false;
        } else if (anio < 2018) {
            alert("El número del año es incorrecto");
            return false;
        }
        //Paciente
        var paciente = $("#sl_paciente").val();
        if (paciente.trim().length === 0) {
            alert("Debe seleccionar un paciente");
            return false;
        }
        //Dentista
        var productora = $("#sl_dentista").val();
        if (productora.trim().length === 0) {
            alert("Debe seleccionar un odontólogo");
            return false;
        }
        //Tratamiento
        var tratamiento = $("#sl_tratamiento").val();
        if (tratamiento.trim().length === 0) {
            alert("Debe seleccionar el tipo de tratamiento");
            return false;
        }
        //Descripción
        var descripcion = $("#ta_descripcion").val();
        if (descripcion.trim().length === 0) {
            alert("Debe ingresar la descripción");
            return false;
        }
    });
});
