
$(function () {

    let buttonBody = $("#buttonBody");
    buttonBody.on("click", function () {
        let context = $(".context");
        context.empty();
        showBody();
    });

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

        let elemList = $("<p style=\"border: solid black 1px\">");
        list.append("<table><thead><tr>" +
            "<th>Date</th>" +
            "<th>Height</th>" +
            "<th>Weight</th>" +
            "<th>BicepsLeft</th>" +
            "<th>BicepsRight</th>" +
            "<th>Chest</th>" +
            "<th>Waist</th>" +
            "<th>Hips</th>" +
            "<th>ThighLeft</th>" +
            "<th>ThighRight</th>" +
            "<th>CalfLeft</th>" +
            "<th>CalfRight</th>" +
            "</tr></thead><tbody id='bodyTable'>");
        for(let body of bodies){

            $('#bodyTable').append(
                "<tr>" +
                "<td>"+body.modDate+"</td>" +
                "<td>"+body.hight+"</td>" +
                "<td>"+body.weight+"</td>" +
                "<td>"+body.bicepsLeft+"</td>" +
                "<td>"+body.bicepsRight+"</td>" +
                "<td>"+body.chest+"</td>" +
                "<td>"+body.waist+"</td>" +
                "<td>"+body.hips+"</td>" +
                "<td>"+body.thighLeft+"</td>" +
                "<td>"+body.thighRight+"</td>" +
                "<td>"+body.calfLeft+"</td>" +
                "<td>"+body.calfRight+"</td>" +
                "</tr>"
            )
        }

        list.append(elemList);
        list.append("</tbody>").append("</table>");
    }
}