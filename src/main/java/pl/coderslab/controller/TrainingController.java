package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dto.TrainingDTO;
import pl.coderslab.entity.Training;
import pl.coderslab.entity.User;
import pl.coderslab.repository.TrainingRepository;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.service.TrainingService;
import pl.coderslab.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/training")
public class TrainingController {

    @Autowired
    TrainingService trainingService;
    @Autowired
    TrainingRepository trainingRepository;
    @Autowired
    HttpSession sess;

    @GetMapping("")
    public String list(Model model){
        User user = (User) sess.getAttribute("UserLogged");
        List<TrainingDTO> trainingDTOList = trainingService.getAllTrainingDTOByUser_Id(user.getId());
        model.addAttribute("training", trainingDTOList);
        return "training/list";
    }
    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("training", new TrainingDTO());
        return "training/form";
    }
    @PostMapping("add")
    public String add(@Valid TrainingDTO trainingDTO, BindingResult bindingResult, HttpServletRequest request){
        if(!bindingResult.hasErrors()){
            User user = (User) sess.getAttribute("UserLogged");
            trainingService.saveTraining(trainingDTO, user.getId());
        }
        return "redirect:/training";
    }
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id){

        TrainingDTO trainingDTO = trainingService.findByTrainingId(id);
        model.addAttribute("training", trainingDTO);
        return "training/form";
    }
    @PostMapping("/edit/{id}")
    public String edit(@Valid TrainingDTO trainingDTO, BindingResult bindingResult){
        if(!bindingResult.hasErrors()) {
            User user = (User) sess.getAttribute("UserLogged");
            trainingService.saveTraining(trainingDTO, user.getId());
        }
        return "redirect:/training";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        trainingRepository.delete(trainingRepository.findFirstById(id));
        return "redirect:/training";
    }
}
