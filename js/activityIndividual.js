$.ajax({
    url: 'http://localhost:8080/activities/' + localStorage.getItem('activityId'),
    type: 'get',
    headers: { 
        'Accept': 'application/json',
        'Content-Type': 'application/json' 
    },
    success: function (response) {
        document.getElementById("activityName").innerHTML = response.name;
        document.getElementById("activityLocation").innerHTML = response.location;
        document.getElementById("activityDay").innerHTML = response.day + "·";
        document.getElementById("activityMonth").innerHTML = response.month + "·";
        document.getElementById("activityYear").innerHTML = response.year;
        document.getElementById("activityHour").innerHTML = response.time + "hs";
        document.getElementById("activityPrice").innerHTML = "Apuntarse €" + response.price;
        document.getElementById("activityPeople").innerHTML = "Apuntados: " + response.registered + "/" + response.maxParticipants;
        document.getElementById("activityDescription").innerHTML = response.description;
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