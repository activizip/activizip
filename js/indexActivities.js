var actividad = {
    nombre: "Senderismo en casa de campo",
    ubicacion: "Madrid, Pozuelo de alarcon",
    dia: 10,
    mes: 6,
    anio: 2022,
    hora: "14:00",
    precio: "Gratis",
    maximoParticipantes: 4,
    rangoEdades: "25 a 35"
}

$.getJSON('http://localhost:8080/index/1', function (data) {
    console.log(data)
    // document.getElementById("activityName").innerHTML = "Nombre de actividad: " + data.name; Solo anda con la bbdd prendida?
});

document.getElementById("activityName").innerHTML = actividad.nombre;
document.getElementById("activityLocation").innerHTML = actividad.ubicacion;
document.getElementById("activityDay").innerHTML = actividad.dia + "·";
document.getElementById("activityMonth").innerHTML = actividad.mes + "·";
document.getElementById("activityYear").innerHTML = actividad.anio;
document.getElementById("activityHour").innerHTML = actividad.hora + "hs";
document.getElementById("activityPrice").innerHTML = actividad.precio;
document.getElementById("activityPeople").innerHTML = "Participantes max: " + actividad.maximoParticipantes;
document.getElementById("activityAge").innerHTML = "Edad: " + actividad.rangoEdades;