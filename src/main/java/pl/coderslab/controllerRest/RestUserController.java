package pl.coderslab.controllerRest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dto.UserDTO;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/userRest")
public class RestUserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @Autowired
    HttpSession sess;
    @Autowired
    public JavaMailSender emailSender;

    @PostMapping("/login")
    public void login(@RequestBody UserDTO userDTO){
        String password = userDTO.getPassword();
        String username = userDTO.getUsername();
        userService.logIn(username, password);

    }

    @GetMapping("/logout")
    public void logout(){
        sess.invalidate();
    }
}
