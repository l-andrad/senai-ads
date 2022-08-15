login = new Object();

$(document).ready(function() {

    login.path = "/projtrilhaseguranca/";

    $.ajax({
        url: login.path + "usuariologado",
        success: function(usuario) {
            document.getElementById("nome").innerHTML = usuario;
        }
    })
});