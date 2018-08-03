package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
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
    @Autowired
    public JavaMailSender emailSender;

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
        model.addAttribute("user", new UserDTO());
        return "user/forgotPassword";
    }
    @PostMapping("/forgotPassword")
    public String forgot(@Valid UserDTO userDTO, BindingResult bindingResult){
        if(!bindingResult.hasErrors()){

            String email = userDTO.getEmail();
            //TODO if you delete email = "kulwik@gmail.com"; it will work for E-mail in form
            email = "kulwik@gmail.com";
            MimeMessage message = emailSender.createMimeMessage();
            boolean multipart = true;

            try {
                String password = userService.editUserInDb(userDTO);
                MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");
                String htmlMsg = "<h3></h3>"
                        + "<p>Your new password is "+password + "</p>";

                message.setContent(htmlMsg, "text/html");
                helper.setTo(email);
                helper.setSubject("Forgot Password");
                this.emailSender.send(message);
            }catch (MessagingException err){
                System.out.println(err.toString());
            }
        }
        return "redirect:/user";
    }
    @GetMapping("/delete")
    public String edit(){
        UserDTO userDTO = (UserDTO) sess.getAttribute("UserLogged");
        userService.removeUser(userDTO);
        sess.invalidate();
        return "redirect:/";
    }

    @GetMapping("/changePassword")
    public String change(){
        return "user/changePassword";
    }
    @PostMapping("/changePassword")
    public String change(HttpServletRequest request){
        String oldPassword = request.getParameter("oldPassword");
        String newPassword1 = request.getParameter("newPassword1");
        String newPassword2 = request.getParameter("newPassword2");
        UserDTO userDTO = (UserDTO) sess.getAttribute("UserLogged");

        userService.changePassword(oldPassword,newPassword1,newPassword2,userDTO);

        return "redirect:/user";
    }

}
