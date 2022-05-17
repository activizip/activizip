var actividad = {
    nombre: "Senderismo en casa de campo",
    ubicacion: "Madrid, Pozuelo de alarcon",
    dia: 10,
    mes: 6,
    anio: 2022,
    hora: "14:00",
    precio: 10,
    maximoParticipantes: "3/4",
    rangoEdades: "25 a 35",
    description: "Actividad por casa de campo el punto de encuentro es en el lago"
}

// $.getJSON('http://localhost:8080/activities/2', function(data) {
// console.log(data)
// document.getElementById("activityName").innerHTML = "Nombre de actividad: " + data.name; Solo anda con la bbdd prendida?
// });

document.getElementById("activityName").innerHTML = actividad.nombre;
document.getElementById("activityLocation").innerHTML = actividad.ubicacion;
document.getElementById("activityDay").innerHTML = actividad.dia + "·";
document.getElementById("activityMonth").innerHTML = actividad.mes + "·";
document.getElementById("activityYear").innerHTML = actividad.anio;
document.getElementById("activityHour").innerHTML = actividad.hora + "hs";
document.getElementById("activityPrice").innerHTML = "Apuntarse €" + actividad.precio;
document.getElementById("activityPeople").innerHTML = "Apuntados: " + actividad.maximoParticipantes;
document.getElementById("activityAge").innerHTML = "Edad: " + actividad.rangoEdades;
document.getElementById("activityDescription").innerHTML = actividad.description;

console.log("OBJETO: Actividad:" + actividad.nombre +
    " Día: " + actividad.dia +
    " Mes: " + actividad.mes +
    " Año: " + actividad.anio +
    " Hora: " + actividad.hora);