package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.dto.TrainingDTO;
import pl.coderslab.entity.Exercise;
import pl.coderslab.entity.Training;
import pl.coderslab.entity.User;
import pl.coderslab.repository.ExerciseRepository;
import pl.coderslab.repository.TrainingRepository;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
@Transactional
public class TrainingService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    HttpSession sess;
    @Autowired
    TrainingRepository trainingRepository;
    @Autowired
    ExerciseRepository exerciseRepository;
    @Autowired
    ExerciseService exerciseService;

    public List<Training> getTrainingListForUserInSession(HttpServletRequest request){
        List<Training> trainings;
        sess = request.getSession();
        User user = (User) sess.getAttribute("UserLogged");
        if(user!= null){
            trainings = trainingRepository.findAllByUser_Id(user.getId());
            return trainings;
        }
        trainings = new ArrayList<>();
        return trainings;
    }

    public void add(Training training, HttpServletRequest request){
        sess = request.getSession();
        training.setUser((User)sess.getAttribute("UserLogged"));
        trainingRepository.save(training);
    }

    public void addTrainingToSession(Long id, HttpServletRequest request){
        sess = request.getSession();

        sess.setAttribute("trainingId", id);
    }

    public Long getTrainingIdFromSession(HttpServletRequest request){
        sess = request.getSession();
        Long tmp = (Long) sess.getAttribute("trainingId");
        if(tmp == null) return 0L;
        return tmp;
    }
    public void editTraining(Training training){
        Training trainingInDb = trainingRepository.findFirstById(training.getId());
        trainingInDb.setName(training.getName());
        trainingRepository.save(trainingInDb);
    }

    public List<TrainingDTO> getAllTrainingDTOByUser_Id(Long id) {
        List<Training> trainings = trainingRepository.findAllByUser_Id(id);
        List<TrainingDTO> trainingDTOList = new ArrayList<>();
        for(Training training:trainings){
            trainingDTOList.add(convertToTrainingDTO(training));
        }
        return trainingDTOList;
    }

    private TrainingDTO convertToTrainingDTO(Training training) {
        TrainingDTO trainingDTO = new TrainingDTO();

        trainingDTO.setData_add(training.getData_add());
        trainingDTO.setData_mod(training.getData_mod());
        trainingDTO.setId(training.getId());
        trainingDTO.setIdv(training.getIdv());
        trainingDTO.setName(training.getName());
        trainingDTO.setExerciseDTOList(
                exerciseService.findAllByTraining_Id(training.getId())
        );

        return trainingDTO;
    }
    private Training convertToTraining(TrainingDTO trainingDTO){
        Training training = new Training();

        training.setName(trainingDTO.getName());
        training.setData_add(trainingDTO.getData_add());
        training.setData_mod(trainingDTO.getData_mod());
        training.setId(trainingDTO.getId());
        training.setIdv(trainingDTO.getIdv());

        return training;
    }

    public void saveTraining(TrainingDTO trainingDTO, Long userId) {
        if(trainingDTO.getId()==null){

        }else {

        }
        Training training = convertToTraining(trainingDTO);
        training.setUser(userRepository.findFirstById(userId));
        if(training.getId()!=null)
            training.setExercises(exerciseRepository.findAllByTraining_Id(training.getId()));

        trainingRepository.save(training);
    }

    public TrainingDTO findByTrainingId(Long id) {
        Training training = trainingRepository.findFirstById(id);
        TrainingDTO trainingDTO = convertToTrainingDTO(training);
        return trainingDTO;
    }
}
