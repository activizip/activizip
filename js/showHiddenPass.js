// SHOW AND HIDE PASSWORD
var iconEyeShow = document.getElementById("btn-show-pass");
var iconEyeHide = document.getElementById("btn-hide-pass");

iconEyeShow.addEventListener("click", function(e) {
    e.preventDefault();
    var password = document.getElementById("inputPass");
    if (password.type = "password") {
        password.type = "text";
        iconEyeShow.style.display = "none";
        iconEyeHide.style.display = "block";
    }
});

iconEyeHide.addEventListener("click", function(e) {
    e.preventDefault();
    var password = document.getElementById("inputPass");
    if (password.type = "text") {
        password.type = "password";
        iconEyeShow.style.display = "block";
        iconEyeHide.style.display = "none";
    }
});