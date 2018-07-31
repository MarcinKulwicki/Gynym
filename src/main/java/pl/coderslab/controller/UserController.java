package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @GetMapping("")
    public String login(){
        return "user/login";
    }
    @PostMapping("")
    public String login(HttpServletRequest request){
        if(userService.logIn(request)){
            return "redirect:/profil";
        }
        return "redirect:/user";
    }
    @GetMapping("/register")
    public String add(Model model){
        model.addAttribute("user", new User());
        return "user/register";
    }
    @PostMapping("/register")
    public String add(@Valid User user, BindingResult bindingResult){
        if(!bindingResult.hasErrors()){
            userService.saveToDb(user);
        }
        return "redirect:/user";
    }
    @GetMapping("/forgotPassword")
    public String forgot(Model model){
        model.addAttribute("user", new User());
        return "user/forgotPassword";
    }
    @PostMapping("/forgotPassword")
    public String forgot(@Valid User user, BindingResult bindingResult){
        if(!bindingResult.hasErrors()){
            userService.editUserInDb(user);
        }
        return "redirect:/user";
    }

}
