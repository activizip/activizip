var createButtton = document.getElementById("input-create-button");

createButtton.addEventListener("click", function(e) {
    // window.location.href = "index.html";
    var name = document.getElementById("GET-name").value;
    var category = document.getElementById("GET-category").value;
    
    // var month = document.getElementById("datePickerId").valueAsDate.getMonth();

    var day = datePickerId.valueAsDate.getDate();
    var month = datePickerId.valueAsDate.getMonth()+1;
    var year = datePickerId.valueAsDate.getFullYear();
    var hour = hourPickerId.value;
    var addres = document.getElementById("GET-addres").value;
    var cantPeople = document.getElementById("GET-cant-people").value;
    var price = document.getElementById("GET-price").value;
    var age = document.getElementById("GET-age").value;
    var gender = document.getElementById("GET-gender").value;
});