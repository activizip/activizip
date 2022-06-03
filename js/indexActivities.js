$.ajax({
    url: 'http://localhost:8080/activities',
    type: 'get',
    headers: { 
        'Accept': 'application/json',
        'Content-Type': 'application/json' 
    },
    success: function (response) {
        const activities = document.getElementById('activitiesScreen');
        activities.innerHTML = "";
        response.forEach(activity => {
            activities.innerHTML += createActivityCard(activity);
        });
    }
});


document.getElementById('btnSearch').addEventListener("click", function(event) {
    const term = document.getElementById("inputSearch").value;
    $.ajax({
        url: 'http://localhost:8080/activities/search?term='+term,
        type: 'GET',
        headers: { 
            'Accept': 'application/json',
            'Content-Type': 'application/json' 
        },
        success: function (response) {
            const activities = document.getElementById('activitiesScreen');
            activities.innerHTML = "";
            response.forEach(activity => {
                activities.innerHTML += createActivityCard(activity);
            });
        }
    });
});

function openActivity(id) {
    localStorage.setItem('activityId', id);
    window.location.href="activity.html";
}

function createActivityCard(activity) {
    var joined = activity.maxParticipants != null ? 
    activity.registered+"/"+activity.maxParticipants 
    : activity.registered+" (sin límite)";
    return "<div class=\"card\">" +
        "<a onClick=\"openActivity(" + activity.id + ")\">" +
        "<div class=\"cont-img\">" +
        "<img src=\"img/img-activity.jpg\" alt=\"imagen actividad\" title=\"imagen realizando una actividad\" class=\"img-prom\">" +
        "</div>" +
        "<div class=\"cont-info\">" +
        "<h3 id=\"activityName\">" + activity.name + "</h3>" +
        "<div class=\"cont-location\">" +
        "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-geo-alt-fill locationIcon2\" viewBox=\"0 0 16 16\">" +
        "<path d=\"M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10zm0-7a3 3 0 1 1 0-6 3 3 0 0 1 0 6z\" />" +
        "</svg>" +
        "<p id=\"activityLocation\">" + activity.location + "</p>" +
        "</div>" +
        "<div id=\"date\">" +
        "<div>" +
        "<p id=\"activityDay\">" + activity.day + "</p>/" +
        "<p id=\"activityMonth\">" + activity.month + "</p>/" +
        "<p id=\"activityYear\">" + activity.year + "</p>" +
        "</div>" +
        "<div>" +
        "<p id=\"activityHour\">" + activity.time + "</p>" +
        "</div>" +
        "</div>" +
        "<p id=\"activityPeople\"> Asistentes: " + joined + "</p>" +
        "<button class=\"btn-price\">" +
        "<p id=\"activityPrice\"> €" + activity.price + "</p>" +
        "</button>" +
        "</div>" +
        "</a>" +
        "</div>";
}