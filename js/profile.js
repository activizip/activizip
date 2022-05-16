var profile = {
    name: "Laura Giselle",
    lastname: "Silva",
    age: 28
}

// $.getJSON('http://localhost:8080/profile/1', function(data) {
//         console.log(data)
        // document.getElementById("activityName").innerHTML = "Nombre de actividad: " + data.name; Solo anda con la bbdd prendida?
    // });

document.getElementById("name").innerHTML = profile.name;
document.getElementById("lastname").innerHTML = profile.lastname;
document.getElementById("age").innerHTML = "Edad: " + profile.age;