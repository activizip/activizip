document.getElementById('btnSend').addEventListener("click", function(event) {
    var register = {
        "name": document.getElementById("GET-name").value,
        "lastNames": document.getElementById("GET-lastname").value,
        "email": document.getElementById("GET-email").value,
        "password": document.getElementById("GET-password").value,
        "birthDate": document.getElementById("datePickerId").value
    }
    $.ajax({
        url: 'http://localhost:8080/users',
        type: 'post',
        data: JSON.stringify(register),
        headers: { 
            'Accept': 'application/json',
            'Content-Type': 'application/json' 
        },
        success: function (response) {
            if (response.response == "OK") {
                alert("Registro completo!!!")
                window.location.href="login.html";
            } else {
                alert("ERROR")
            }
        }
    });
});