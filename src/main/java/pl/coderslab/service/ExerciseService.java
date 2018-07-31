package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.entity.Exercise;
import pl.coderslab.repository.ExerciseRepository;
import pl.coderslab.repository.TrainingRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
public class ExerciseService {

    @Autowired
    ExerciseRepository exerciseRepository;
    @Autowired
    HttpSession sess;
    @Autowired
    TrainingRepository trainingRepository;

    public boolean addExercise(Exercise exercise, HttpServletRequest request){

        sess = request.getSession();
        Long trainingId = (Long) sess.getAttribute("trainingId");
        if(trainingId!=null){
            exercise.setTraining(trainingRepository.findFirstById(trainingId));
            exerciseRepository.save(exercise);
            return true;
        }
        return false;
    }
}
