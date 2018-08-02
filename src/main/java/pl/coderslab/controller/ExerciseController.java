package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dto.ExerciseDTO;
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
    public String list(Model model){

        Long trainingId = (Long) sess.getAttribute("trainingId");
        if(trainingId == null)
            model.addAttribute("noTraining", true);
        List<ExerciseDTO> exerciseDTO = exerciseService.findAllByTraining_Id(trainingId);

        model.addAttribute("exercise", exerciseDTO);
        return "exercise/list";
    }
    @GetMapping("/{trainingId}")
    public String list(Model model, @PathVariable Long trainingId){

        sess.setAttribute("trainingId", trainingId);
        List<ExerciseDTO> exerciseDTO = exerciseService.findAllByTraining_Id(trainingId);
        model.addAttribute("exercise", exerciseDTO);
        return "exercise/list";
    }
    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("exercise", new ExerciseDTO());
        return "exercise/form";
    }
    @PostMapping("/add")
    public String add(@Valid ExerciseDTO exerciseDTO, BindingResult bindingResult){
        if(!bindingResult.hasErrors()){
            Long trainingId = (Long) sess.getAttribute("trainingId");
            exerciseService.saveExercise(exerciseDTO, trainingId);
        }
        return "redirect:/exercise";
    }
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id){
        ExerciseDTO exerciseDTO = exerciseService.findByExercise_Id(id);
        model.addAttribute("exercise", exerciseDTO);
        return "exercise/form";
    }
    @PostMapping("/edit/{id}")
    public String edit(@Valid ExerciseDTO exerciseDTO, BindingResult bindingResult){
        if(!bindingResult.hasErrors()){
            Long trainingId = (Long) sess.getAttribute("trainingId");
            exerciseService.saveExercise(exerciseDTO,trainingId);
        }
        return "redirect:/exercise";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        exerciseService.deleteExercise(id);
        return "redirect:/exercise";
    }
}
