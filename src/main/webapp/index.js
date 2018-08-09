$(function () {



   let buttonBody = $("#buttonBody");
   buttonBody.on("click", function () {
       let context = $(".context");
       context.empty();
       showBody();
   });

    let buttonTraining = $("#buttonTraining");
    buttonTraining.on("click", function () {
        let list = $(".context");
        list.empty();
        showTraining();

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

        for(let body of bodies){
            let elemList = $("<p style=\"border: solid black 1px\">");
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
function showTraining() {
    $.ajax({
        url: "/trainingRest" ,
        data: {} ,
        type: "GET" ,
        dataType: "json",
        success: displayTraining
    });

    function displayTraining(trainings) {

        let list = $("#listTraining");
        list.empty();

        for(let training of trainings){
            let elemList = $("<p style=\"border: solid black 1px\">");
            elemList.append("<p>").append(training.name);
            elemList.append("<p>");
            for(let exercise of training.exerciseDTOList){
                elemList.append(exercise.name);

                var buttonChoise = $("<button>").data(exercise).text("Take")
                    .on("click", function () {
                        elemList.append("<p>")
                            .append(exercise.name).append(" - ")
                            .append(exercise.description).append(" - ")
                            .append(exercise.recommend).append(" - ")
                            .append(exercise.series).append(" - ")
                            .append(exercise.repeats).append(" - ")
                    })
                elemList.append(buttonChoise).append(" / ");
            }
            list.append(elemList);
        }

    }

}