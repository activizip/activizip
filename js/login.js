const emailRegEx = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
document.getElementById('btnSend').addEventListener("click", function(event) {
    //VALIDO FORMATO EMAIL
    if (emailRegEx.test(document.getElementById("GETemail").value)) {
        document.getElementById("textErrorEmail").innerHTML = "";
        var login = {
            "email": document.getElementById("GETemail").value,
            "password": document.getElementById("GETpassword").value
        }
        $.ajax({
            url: 'http://localhost:8080/users/login',
            type: 'post',
            data: JSON.stringify(login),
            headers: { 
                'Accept': 'application/json',
                'Content-Type': 'application/json' 
            },
            dataType: 'json',
            success: function (response) {
                if (response.valid) {
                    //LOGIN CORRECTO
                    sessionStorage.setItem('login',response.valid);
                    sessionStorage.setItem('token',response.token);
                    sessionStorage.setItem('userId',response.id);
                    window.location.href="index.html";
                } else {
                    //LOGIN INCORRECTO
                    document.getElementById("textErrorEmail").innerHTML = "Email o contraseña incorrectos";
                }
            }
        });
    } else {
        document.getElementById("textErrorEmail").innerHTML = "Ingrese bien su email";
    }    
});