package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Training;
import pl.coderslab.repository.TrainingRepository;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.service.TrainingService;
import pl.coderslab.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/training")
public class TrainingController {

    @Autowired
    TrainingService trainingService;
    @Autowired
    TrainingRepository trainingRepository;

    @GetMapping("")
    public String list(HttpServletRequest request, Model model){
        model.addAttribute("training", trainingService.getTrainingListForUserInSession(request));
        return "training/list";
    }
    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("training", new Training());
        return "training/form";
    }
    @PostMapping("add")
    public String add(@Valid Training training, BindingResult bindingResult, HttpServletRequest request){
        if(!bindingResult.hasErrors()){
            trainingService.add(training,request);
        }
        return "redirect:/training";
    }
}
