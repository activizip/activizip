var actividad = {
    nombre: "Senderismo en casa de campo",
    ubicacion: "Madrid, Pozuelo de alarcon",
    dia: 10,
    mes: 6,
    anio: 2022,
    hora: "14:00",
    precio: 10,
    maximoParticipantes: 4,
    rangoEdades: "25/35",
    genero: "Sin preferencia"
}

$.getJSON('http://localhost:8080/activities/1', function(data) {
        console.log(data)
        // document.getElementById("activityName").innerHTML = "Nombre de actividad: " + data.name; Solo anda con la bbdd prendida?
    });

document.getElementById("activityName").innerHTML = actividad.nombre;
document.getElementById("activityUbication").innerHTML = actividad.ubicacion;
document.getElementById("activityDay").innerHTML = actividad.dia + "·";
document.getElementById("activityMonth").innerHTML = actividad.mes  + "·";
document.getElementById("activityYear").innerHTML = actividad.anio;
document.getElementById("activityHour").innerHTML = actividad.hora + "hs";
document.getElementById("activityPrice").innerHTML = "Precio: " + actividad.precio;
document.getElementById("activityPeople").innerHTML = "Participantes max: " + actividad.maximoParticipantes;
document.getElementById("activityAge").innerHTML = "Edad entre: " + actividad.rangoEdades;
document.getElementById("activityGender").innerHTML = "Genero: " + actividad.genero;

console.log("OBJETO: Actividad:" + actividad.nombre + 
" Día: " + actividad.dia + 
" Mes: " + actividad.mes + 
" Año: " + actividad.anio + 
" Hora: " + actividad.hora);