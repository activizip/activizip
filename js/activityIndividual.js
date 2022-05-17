var actividad = {
    nombre: "Senderismo en casa de campo",
    ubicacion: "Madrid, Pozuelo de alarcon",
    dia: 10,
    mes: 6,
    anio: 2022,
    hora: "14:00",
    precio: 10,
    maximoParticipantes: "3/4",
    description: "Lorem ipsum dolor sit amet consectetur adipisicing elit. At velit laborum accusamus saepe a sequi dignissimos consequuntur nemo vel doloribus, iusto, aspernatur quaerat molestiae! Harum, porro nemo in, laudantium tempore omnis aliquam ipsa itaque, quos ipsam odit sit nisi perspiciatis"
}

// $.getJSON('http://localhost:8080/activity/1', function(data) {
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
document.getElementById("activityDescription").innerHTML = actividad.description;