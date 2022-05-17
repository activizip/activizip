var register = {
    name: "laura giselle",
    lastname: "silva",
    email: "lauragisellesilva@gmail.com",
    password: "Madrid19",
    age: 28
}

ocument.getElementById("GET-name").innerHTML = register.name;
ocument.getElementById("GET-lastname").innerHTML = register.lastname;
ocument.getElementById("GET-email").innerHTML = register.email;
ocument.getElementById("GET-password").innerHTML = register.password;
ocument.getElementById("GET-age").innerHTML = register.age;

// $.getJSON('http://localhost:8080/register/1', function (data) {
//     console.log(data)
//     document.getElementById("activityName").innerHTML = "Nombre de actividad: " + data.name; Solo anda con la bbdd prendida?
// });