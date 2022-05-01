// OPEN LOGIN
// detectar eventos
$('#boton-mensaje').on('click', mostrarModal);
$('#bot-cerrar-modal').on('click', cerrarModal);
$(document).on('keydown', comprobarTecla);

// funcion para mostrar ventana modal
function mostrarModal() {
    $('.fondoModal').fadeIn(500, function () {
        $('.contenidoModal').fadeIn(500);
    });
}

// funcion para cerrar la ventana modal
function cerrarModal() {
    $('.fondoModal, .contenidoModal').fadeOut(300);
}

// funcion para detectar si presiono tecla escape y cuando lo hago entonces cierra la ventana 
function comprobarTecla(e) {
    var codigoTecla = e.which;
    console.log(codigoTecla);

    if (codigoTecla == 27) {
        cerrarModal();
    }
}