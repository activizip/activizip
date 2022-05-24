document.getElementById('btnSend').addEventListener("click", function(event) {
    var create = {
        "name": document.getElementById("GET-name").value,
        "day": datePickerId.valueAsDate.getDate(),
        "month": datePickerId.valueAsDate.getMonth()+1,
        "year": datePickerId.valueAsDate.getFullYear(),
        "time": hourPickerId.value, 
        "location": document.getElementById("GET-location").value,
        "maxParticipants": document.getElementById("GET-cant-people").value,
        "price": document.getElementById("GET-price").value,
        "description": document.getElementById("GET-description").value,
        "token": sessionStorage.getItem('token')
    }
    if (create.name != "" && create.time != "" && create.time != "" && create.location != "" && create.price != "") {
        $.ajax({
            url: 'http://localhost:8080/activities',
            type: 'post',
            data: JSON.stringify(create),
            headers: { 
                'Accept': 'application/json',
                'Content-Type': 'application/json' 
            },
            success: function (response) {
                if (response.response == "OK") {
                    alert("Actividad creada!!!")
                    window.location.href="index.html";
                } else {
                    alert("ERROR")
                }
            }
        });
    }
});