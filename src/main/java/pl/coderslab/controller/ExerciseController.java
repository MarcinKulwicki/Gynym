package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.repository.ExerciseRepository;
import pl.coderslab.service.ExerciseService;
import pl.coderslab.service.TrainingService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/exercise")
public class ExerciseController {


    @Autowired
    ExerciseService exerciseService;
    @Autowired
    ExerciseRepository exerciseRepository;
    @Autowired
    TrainingService trainingService;

    @GetMapping("")
    public String list(HttpServletRequest request, Model model){
        Long idTraining = trainingService.getTrainingIdFromSession(request);
        model.addAttribute("exercise", exerciseRepository.findAllByTraining_Id(idTraining));
        return "exercise/list";
    }
    @GetMapping("/{idTraining}")
    public String list(Model model, @PathVariable Long idTraining, HttpServletRequest request){
        trainingService.addTrainingToSession(idTraining, request);
        model.addAttribute("exercise", exerciseRepository.findAllByTraining_Id(idTraining));
        return "exercise/list";
    }
}
