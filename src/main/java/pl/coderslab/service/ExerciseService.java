package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.dto.ExerciseDTO;
import pl.coderslab.entity.Exercise;
import pl.coderslab.repository.ExerciseRepository;
import pl.coderslab.repository.TrainingRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
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
    public boolean editExercise(Exercise exercise){

            Exercise exerciseInDb = exerciseRepository.findFirstById(exercise.getId());
            exerciseInDb.setDescription(exercise.getDescription());
            exerciseInDb.setName(exercise.getName());
            exerciseInDb.setRecommend(exercise.getRecommend());
            exerciseInDb.setRepeats(exercise.getRepeats());
            exerciseInDb.setSeries(exercise.getSeries());
            exerciseInDb.setWeight(exercise.getWeight());
            exerciseInDb.setTime(exercise.getTime());
            exerciseRepository.save(exerciseInDb);
            return true;
    }
    //DTO

    public List<ExerciseDTO> findAllByTraining_Id(Long trainingId) {
        List<Exercise> exercises = exerciseRepository.findAllByTraining_Id(trainingId);
        List<ExerciseDTO> exerciseDTOList = new ArrayList<>();
        for(Exercise exercise:exercises){
            exerciseDTOList.add(convertToExerciseDTO(exercise));
        }
        return exerciseDTOList;
    }

    private ExerciseDTO convertToExerciseDTO(Exercise exercise) {
        ExerciseDTO exerciseDTO = new ExerciseDTO();

        exerciseDTO.setId(exercise.getId());
        exerciseDTO.setData_add(exercise.getData_add());
        exerciseDTO.setData_mod(exercise.getData_mod());
        exerciseDTO.setIdv(exercise.getIdv());
        exerciseDTO.setName(exercise.getName());
        exerciseDTO.setRecommend(exercise.getRecommend());
        exerciseDTO.setRepeats(exercise.getRepeats());
        exerciseDTO.setSeries(exercise.getSeries());
        exerciseDTO.setTime(exercise.getTime());
        exerciseDTO.setWeight(exercise.getWeight());
        exerciseDTO.setDescription(exercise.getDescription());
        //exerciseDTO.setTrainingDTO(exercise.getTraining());
        return exerciseDTO;
    }
    private Exercise convertToExercise(ExerciseDTO exerciseDTO){
        Exercise exercise = new Exercise();

        exercise.setId(exerciseDTO.getId());
        exercise.setData_add(exerciseDTO.getData_add());
        exercise.setData_mod(exerciseDTO.getData_mod());
        exercise.setIdv(exerciseDTO.getIdv());
        exercise.setName(exerciseDTO.getName());
        exercise.setRecommend(exerciseDTO.getRecommend());
        exercise.setRepeats(exerciseDTO.getRepeats());
        exercise.setSeries(exerciseDTO.getSeries());
        exercise.setTime(exerciseDTO.getTime());
        exercise.setWeight(exerciseDTO.getWeight());
        exercise.setDescription(exerciseDTO.getDescription());

        return exercise;
    }

    public void saveExercise(ExerciseDTO exerciseDTO, Long trainingId) {
        Exercise exercise = convertToExercise(exerciseDTO);
        if(trainingId != null) exercise.setTraining(trainingRepository.findFirstById(trainingId));
        exerciseRepository.save(exercise);
    }

    public ExerciseDTO findByExercise_Id(Long id) {
        Exercise exercise = exerciseRepository.findFirstById(id);
        return convertToExerciseDTO(exercise);
    }

    public void deleteExercise(Long id) {
        exerciseRepository.delete(exerciseRepository.findFirstById(id));
    }
}
