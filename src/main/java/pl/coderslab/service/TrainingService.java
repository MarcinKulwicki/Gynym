package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
//@Transactional //rozwiazuje problem Lazy
public class TrainingService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    HttpSession sess;
    @Autowired
    TrainingRepository trainingRepository;
    @Autowired
    ExerciseRepository exerciseRepository;

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

}
