$.ajax({
    url: 'http://localhost:8080/users/' + sessionStorage.getItem('userId'),
    type: 'get',
    headers: { 
        'Accept': 'application/json',
        'Content-Type': 'application/json' 
    },
    success: function (response) {
        document.getElementById("name").innerHTML = response.name;
        document.getElementById("lastname").innerHTML = response.lastNames;
        document.getElementById("age").innerHTML = "Birthdate: " + response.birthdate;
        document.getElementById("email").innerHTML = response.email;
    }
});

document.getElementById('btnLogout').addEventListener('click', function(event) {
    sessionStorage.setItem('login', false);
    sessionStorage.setItem('token', null);
    sessionStorage.setItem('userId', null);
    window.location.href="index.html";
})