package pl.coderslab.controllerRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.dto.TrainingDTO;
import pl.coderslab.dto.UserDTO;
import pl.coderslab.repository.TrainingRepository;
import pl.coderslab.service.TrainingService;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/trainingRest")
public class RestTrainingController {

    @Autowired
    TrainingService trainingService;
    @Autowired
    TrainingRepository trainingRepository;
    @Autowired
    HttpSession sess;


    @GetMapping("")
    public List<TrainingDTO> list(Model model){
        UserDTO userDTO = (UserDTO) sess.getAttribute("UserLogged");
        List<TrainingDTO> trainingDTOList = trainingService.getAllTrainingDTOByUser_Id(userDTO.getId());
        model.addAttribute("training", trainingDTOList);
        return trainingDTOList;
    }
}
