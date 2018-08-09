$(function () {

   showBody();

});


function showBody() {
    $.ajax({
        url: "/bodyRest/",
        data: {} ,
        type: "GET" ,
        dataType: "json",
        success: displayBody
    });

    function displayBody(bodies) {


        let list = $("#listBodies");
        list.empty();

        for(let body of bodies){
            var elemList = $("<p style=\"border: solid black 1px\">");
            let bicepsLeft = $("<p>")
                .append(body.user.email)
                .append(" : ")
                .append(body.weight)
                .append("kg : ")
                .append(body.hight)
                .append("cm : ")
                .append(body.bicepsLeft)
                .append(" : ")
                .append(body.bicepsRight);

            elemList.append(bicepsLeft);
            list.append(elemList);
        }


    }




}