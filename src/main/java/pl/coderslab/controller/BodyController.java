package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Body;
import pl.coderslab.repository.BodyRepository;
import pl.coderslab.service.BodyService;
import pl.coderslab.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/body")
public class BodyController {

    @Autowired
    BodyRepository bodyRepository;
    @Autowired
    UserService userService;
    @Autowired
    BodyService bodyService;

    @GetMapping("")
    public String list(Model model, HttpServletRequest request){
        //BENG!
        List<Body> body = bodyRepository.findAllByUser_Id(userService.getUserIdFromSession(request));
        body.sort(Comparator.comparing(Body::getData_mod));
        model.addAttribute("body", body);
        return "body/list";
    }
    @GetMapping("/add")
    public String add(Model model, HttpServletRequest request){
        model.addAttribute("body", bodyService.getNewBodyOrLatest(request));
        return "body/form";
    }
    @PostMapping("/add")
    public String add(@Valid Body body, BindingResult bindingResult, HttpServletRequest request){
        if(!bindingResult.hasErrors()){
            bodyService.saveBodyToUserInDb(body, request);
        }
        return "redirect:/body";
    }
    @GetMapping("/target")
    public String target(Model model, HttpServletRequest request){
        model.addAttribute("body", bodyService.getNewTargetOrLatest(request));
        return "body/form";
    }
    @PostMapping("/target")
    public String target(@Valid Body body, BindingResult bindingResult, HttpServletRequest request){
        if(!bindingResult.hasErrors()){
            bodyService.saveTargetBodyToUserInDb(body,request);
        }
        return "redirect:/body";
    }
}
