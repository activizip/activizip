$.ajax({
    url: 'http://localhost:8080/activities/' + localStorage.getItem('activityId'),
    type: 'get',
    headers: { 
        'Accept': 'application/json',
        'Content-Type': 'application/json' 
    },
    success: function (response) {
        var joined = response.maxParticipants != null ? 
            response.registered+"/"+response.maxParticipants 
            : response.registered+" (sin límite)";
        document.getElementById("activityName").innerHTML = response.name;
        document.getElementById("activityLocation").innerHTML = response.location;
        document.getElementById("activityDay").innerHTML = response.day + "·";
        document.getElementById("activityMonth").innerHTML = response.month + "·";
        document.getElementById("activityYear").innerHTML = response.year;
        document.getElementById("activityHour").innerHTML = response.time + "hs";
        document.getElementById("activityPeople").innerHTML = "Asistentes: " + joined;
        document.getElementById("activityDescription").innerHTML = response.description;

        if (response.maxParticipants != null && response.maxParticipants == response.registered) {
            var button = document.getElementById('btnJoin');
            button.disabled = true;
            document.getElementById("activityPrice").innerHTML = "Evento completo";
            button.style = "background-color: grey; cursor: initial";
        } else {
            document.getElementById("activityPrice").innerHTML = "Apuntarse €" + response.price;
        }

    }
});

document.getElementById('btnJoin').addEventListener('click', function(event) {
    var join = {
        "activityId": localStorage.getItem('activityId'),
        "token": sessionStorage.getItem('token')
    }
    $.ajax({
        url: 'http://localhost:8080/attendance/join',
        type: 'post',
        data: JSON.stringify(join),
        headers: { 
            'Accept': 'application/json',
            'Content-Type': 'application/json' 
        },
        success: function (response) {
            if (response.response == "OK") {
                window.location.href="activity.html";
            } else {
                alert(response.response)
            }
        }
    });
});