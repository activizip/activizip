var actividad = {
    email: "lauragisellesilva@gmail.com",
    password: "Madrid19"
}

document.getElementById("GET-email").innerHTML = actividad.email;
document.getElementById("GET-password").innerHTML = actividad.password;

// $.getJSON('http://localhost:8080/login/1', function (data) {
//     console.log(data)
//     document.getElementById("activityName").innerHTML = "Nombre de actividad: " + data.name;
// });