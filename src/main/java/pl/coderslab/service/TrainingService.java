package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.entity.Training;
import pl.coderslab.entity.User;
import pl.coderslab.repository.TrainingRepository;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Component
public class TrainingService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    HttpSession sess;
    @Autowired
    TrainingRepository trainingRepository;

    public List<Training> getTrainingListForUserInSession(HttpServletRequest request){
        List<Training> trainings = new ArrayList<>();
        sess = request.getSession();
        User user = (User) sess.getAttribute("UserLogged");
        trainings = trainingRepository.findAllByUser_Id(user.getId());
        return trainings;
    }

    public void add(Training training, HttpServletRequest request){
        sess = request.getSession();
        training.setUser((User)sess.getAttribute("UserLogged"));
        trainingRepository.save(training);
    }
}
