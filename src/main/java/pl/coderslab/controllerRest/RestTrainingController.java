package pl.coderslab.controllerRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dto.TrainingDTO;
import pl.coderslab.dto.UserDTO;
import pl.coderslab.repository.TrainingRepository;
import pl.coderslab.service.TrainingService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
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
    @PostMapping("")
    public void add(@RequestBody TrainingDTO trainingDTO){
            UserDTO userDTO = (UserDTO) sess.getAttribute("UserLogged");
            trainingService.saveTraining(trainingDTO, userDTO.getId());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        trainingService.deleteTraining(id);
    }
}
