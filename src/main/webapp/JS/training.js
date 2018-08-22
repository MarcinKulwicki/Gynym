function TrainingDTO(name){
    this.name = name;
}
function ExerciseDTO(name, description , trainingID){
    this.name = name;
    this.description = description;
    this.trainingID = trainingID;
}

$(function () {

    let buttonTraining = $("#buttonTraining");
    buttonTraining.on("click", function () {
        let list = $(".context");
        list.empty();
        showTraining();

    });

});



function deleteExercise(id){
    $.ajax({
        url: "/exerciseRest/"+id,
        data: {},
        type: "DELETE",
        contentType: 'application/json; charset=utf-8',
        dataType : "json",
        success: showTraining,
        complete: function( xhr, status ){showTraining()}
    });
}
function deleteTraining(id){
    $.ajax({
        url: "/trainingRest/"+id,
        data: {},
        type: "DELETE",
        contentType: 'application/json; charset=utf-8',
        dataType : "json",
        success: showTraining,
        complete: function( xhr, status ){showTraining()}
    });
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

            let buttonRemoveTraining = $("<button>").data(training).text("Delete")
                .on("click", function () {
                    deleteTraining(training.id);
                });

            elemList.append("<p>").append(training.name).append(" / "). append(buttonRemoveTraining);
            elemList.append("<p>");
            for(let exercise of training.exerciseDTOList){
                elemList.append(exercise.name);

                let buttonChoise = $("<button>").data(exercise).text("Take")
                    .on("click", function () {
                        elemList.append(
                            "<p class='additionalList'>"+ exercise.name+" - "+
                            +exercise.description+" - "+
                            +exercise.recommend+" - "+
                            +exercise.series+" - "+
                            +exercise.repeats+" - "
                    );
                    });


                let buttonRemove = $("<button>").data(exercise).text("Remove")
                    .on("click" , function () {
                        deleteExercise(exercise.id);
                    });


                elemList.append(buttonChoise).append("/");
                elemList.append(buttonRemove).append("/");
            }

            let buttonClear = $("<button>").text("Clear")
                .on("click", function () {
                    elemList.find(".additionalList").remove();
                });
            let formAdd = $("<p style=\"border: solid black 0px\">");
            let buttonAddExercise = $("<button id='addButton'>").text("Add New")
                .on("click", function () {
                    formAdd.append(""+
                        "<form method='post'>"+
                        "<input type='text' placeholder='name' id='exerciseName'>"+
                        "<input type='text' placeholder='description' id='exerciseDescription'>"+
                        "<input type='submit' id='sub' value='Add'>"+
                        "</form>"
                    );

                    let subClick = $("#sub");
                    subClick.on("click", function (event) {

                        let exercise = new ExerciseDTO(
                            $("#exerciseName").val(),
                            $("#exerciseDescription").val(),
                            training.id
                        );

                        $.ajax({
                            headers: {
                                'Content-Type': 'application/json'
                            },
                            url: "/exerciseRest",
                            data: JSON.stringify(
                                exercise
                            ),
                            type: "POST",
                            dataType : "json",
                            success: showTraining,
                            error: function( xhr, status,
                                             errorThrown ) {},
                            complete: function( xhr, status ){showTraining()}
                        });
                        event.preventDefault();

                    });
                });


            elemList.append(buttonAddExercise);
            elemList.append(buttonClear);
            elemList.append(formAdd);
            list.append(elemList);
        }

        let formAdd = $("<p style=\"border: solid black 1px\">");
        let buttonAdd = $("<button id='addButton'>").text("Add New")
            .on("click", function () {
                formAdd.append(""+
                    "<form method='post'>"+
                    "<input type='text' id='trainingName' placeholder='Name of Training'>"+
                    "<input type='submit' value='Add' id='sub'>"+
                    "</form>");

                let subClick = $("#sub");
                subClick.on("click", function (event) {

                    let training = new TrainingDTO(
                        $("#trainingName").val()
                    );
                    event.preventDefault();

                    $.ajax({
                        headers: {
                            'Content-Type': 'application/json'
                        },
                        url: "/trainingRest",
                        data: JSON.stringify(
                            training
                        ),
                        type: "POST",
                        dataType : "json",
                        success: showTraining,
                        error: function( xhr, status,
                                         errorThrown ) {},
                        complete: function( xhr, status ){showTraining()}
                    });
                    event.preventDefault();

                });

            });
        list.append(formAdd);
        list.append(buttonAdd);


    }

}