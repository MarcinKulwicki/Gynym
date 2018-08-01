package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Exercise;
import pl.coderslab.repository.ExerciseRepository;
import pl.coderslab.service.ExerciseService;
import pl.coderslab.service.TrainingService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/exercise")
public class ExerciseController {


    @Autowired
    ExerciseService exerciseService;
    @Autowired
    ExerciseRepository exerciseRepository;
    @Autowired
    TrainingService trainingService;
    @Autowired
    HttpSession sess;


    @GetMapping("")
    public String list(HttpServletRequest request, Model model){
        Long idTraining = trainingService.getTrainingIdFromSession(request);
        if(idTraining == 0) model.addAttribute("noTraining", true);
        model.addAttribute("exercise", exerciseRepository.findAllByTraining_Id(idTraining));
        return "exercise/list";
    }
    @GetMapping("/{idTraining}")
    public String list(Model model, @PathVariable Long idTraining, HttpServletRequest request){
        trainingService.addTrainingToSession(idTraining, request);
        model.addAttribute("exercise", exerciseRepository.findAllByTraining_Id(idTraining));
        return "exercise/list";
    }
    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("exercise", new Exercise());
        return "exercise/form";
    }
    @PostMapping("/add")
    public String add(@Valid Exercise exercise, BindingResult bindingResult, HttpServletRequest request){
        if(!bindingResult.hasErrors()){
            exerciseService.addExercise(exercise,request);
        }
        return "redirect:/exercise";
    }
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id){
        model.addAttribute("exercise", exerciseRepository.findFirstById(id));
        return "exercise/form";
    }
    @PostMapping("/edit/{id}")
    public String edit(@Valid Exercise exercise, BindingResult bindingResult, HttpServletRequest request){
        if(!bindingResult.hasErrors()){
            exerciseService.editExercise(exercise);
        }
        return "redirect:/exercise";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        exerciseRepository.delete(exerciseRepository.findFirstById(id));
        return "redirect:/exercise";
    }
}
