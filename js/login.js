document.getElementById('btnSend').addEventListener("click", function(event) {
    var login = {
        "email": document.getElementById("GET-email").value,
        "password": document.getElementById("GET-password").value
    }
    $.ajax({
        url: 'http://localhost:8080/users/login',
        type: 'post',
        data: login,
        headers: { 
            'Accept': 'application/json',
            'Content-Type': 'application/json' 
        },
        dataType: 'json',
        success: function (response) {
            console.log(response);
        }
    });
});