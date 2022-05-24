if (sessionStorage.getItem('login') && sessionStorage.getItem('login') == "true") {
    //ESTA LOGUEADO
    document.getElementById("loginNavBar").appendChild(createNavBarNode("create.html", "Create"));
    document.getElementById("loginNavBar").appendChild(createNavBarNode("profile.html", "Profile"));
} else {
    //NO ESTA LOGEADO
    document.getElementById("loginNavBar").appendChild(createNavBarNode("register.html", "Register"));
    document.getElementById("loginNavBar").appendChild(createNavBarNode("login.html", "Login"));
}

function createNavBarNode(href, name) {
    const node = document.createElement("li");
    const link = document.createElement("a");
    link.href = href;
    const text = document.createTextNode(name);
    link.appendChild(text);
    node.appendChild(link);
    return node
}