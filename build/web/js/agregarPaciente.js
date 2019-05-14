/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 Created on : 17-10-2018, 14:18:05
 Author     : matias
 */

$(document).ready(function () {
    //Validadores
    $("#bt_guardar").on("click", function () {
        //Rut
        var rut = $("#tx_rut").val();
        if (rut.trim().length === 0) {
            alert("Debe ingresar el rut del paciente");
            return false;
        }
        //Nombre
        var nombre = $("#tx_nombre").val();
        if (nombre.trim().length === 0) {
            alert("Debe ingresar el nombre del paciente");
            return false;
        }
        //Apellido
        var apellido = $("#tx_apellido").val();
        if (apellido.trim().length === 0) {
            alert("Debe ingresar el apellido del paciente");
            return false;
        }
        //Dirección
        var direccion = $("#tx_direccion").val();
        if (direccion.trim().length === 0) {
            alert("Debe ingresar la dirección del paciente");
            return false;
        }
        //Teléfono
        var productora = $("#tx_telefono").val();
        if (productora.trim().length === 0) {
            alert("Debe ingresar el teléfono del paciente");
            return false;
        }
        //Email
        var email = $("#tx_email").val();
        if (email.trim().length === 0) {
            alert("Debe ingresar el email del paciente");
            return false;
        }
    });
});
