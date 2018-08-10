package pl.coderslab.controllerRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.dto.ExerciseDTO;
import pl.coderslab.repository.ExerciseRepository;
import pl.coderslab.service.ExerciseService;
import pl.coderslab.service.TrainingService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@RequestMapping("/exerciseRest")
public class RestExerciseController {

    @Autowired
    ExerciseService exerciseService;
    @Autowired
    ExerciseRepository exerciseRepository;
    @Autowired
    TrainingService trainingService;
    @Autowired
    HttpSession sess;


    @PostMapping("")
    public void add(@RequestBody ExerciseDTO exerciseDTO){

            Long trainingId = (Long) sess.getAttribute("trainingId");
            exerciseService.saveExercise(exerciseDTO, trainingId);
    }
}
