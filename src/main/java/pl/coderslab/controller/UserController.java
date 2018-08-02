package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dto.UserDTO;
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
    @Autowired
    HttpSession sess;

    @GetMapping("")
    public String loginGet(){
        UserDTO userDTO = (UserDTO) sess.getAttribute("UserLogged");
        if(userDTO != null) return "redirect:/body";
        return "user/login";
    }
    @PostMapping("")
    public String login(HttpServletRequest request){
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        if(userService.logIn(username, password)){
            return "redirect:/body";
        }
        return "redirect:/user";
    }
    @GetMapping("/register")
    public String add(Model model){
        model.addAttribute("user", new UserDTO());
        return "user/register";
    }
    @PostMapping("/register")
    public String add(@Valid UserDTO userDTO, BindingResult bindingResult){
        if(!bindingResult.hasErrors()){
            userService.saveToDb(userDTO);
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
    @GetMapping("/delete")
    public String edit(HttpServletRequest request){
        sess = request.getSession();
        User user = (User) sess.getAttribute("UserLogged");
        User userInBase = userRepository.findFirstByUsername(user.getUsername());
        userInBase.setUsername("non");
        userRepository.save(userInBase);
        sess.invalidate();
        return "redirect:/";
    }

}
