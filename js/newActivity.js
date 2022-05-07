var createButtton = document.getElementById("input-create-button");

createButtton.addEventListener("click", function(e) {
    // window.location.href = "index.html";
    var name = document.getElementById("GET-name").value;
    var category = document.getElementById("GET-category").value; //obtener valor de un select
    var day = document.getElementById("GET-day").value;
    var month = document.getElementById("GET-month").value;
    var hour = document.getElementById("GET-hour").value;
    var addres = document.getElementById("GET-addres").value;
    var cantPeople = document.getElementById("GET-cant-people").value;
    var price = document.getElementById("GET-price").value;
    var age = document.getElementById("GET-age").value;
    var gender = document.getElementById("GET-gender").value;//obtener valor de un select
    console.log("Nombre: " + name + " Categoria: " + category + " Fecha: " + day + month + hour + 
    " Direccion : " + addres + " Cantidad de personas: " + cantPeople + " Precio: " + price +
    " Edad: " + age + " Genero: " + gender);
});