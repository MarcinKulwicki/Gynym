function UserDTO(username, password){
    this.username = username;
    this.password = password;
}
function logged(){
    let login = $("#login");
    login.empty();
    $("#formLogin").hide();
    $("#logout").show();


    buttonLogout = $("#logout");

    buttonLogout.on("click", function () {
        window.alert("You're logged out");
        logout();
        $("#formLogin").show();
        $("#logout").hide();

        logout();
    });


    login.append(buttonLogout);
}

function logout(){
    $.ajax({
        url: "/userRest/logout",
        data: {},
        type: "GET",
        dataType : "json",
    });
}

$(function () {


    logout();

    let loginButton = $("#loginButton");

    loginButton.on("click", function (event) {

        let user = new UserDTO(
            $("#username").val(),
            $("#password").val()
        );


        $.ajax({
            headers: {
                'Content-Type': 'application/json'
            },
            url: "/userRest/login",
            data: JSON.stringify(
                user
            ),
            type: "POST",
            dataType : "json",
            success: showTraining,
            error: function( xhr, status,
                             errorThrown ) {},
            complete: function( xhr, status ){logged()}
        });


        event.preventDefault();
    });


});