package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.service.HomeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    HomeService homeService;
    @Autowired
    HttpSession sess;


    @GetMapping("")
    public String list(){
        return "home";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        try {
            request.logout();
        } catch (ServletException e) {
            System.out.println("Cannot logout");
        }
        sess = request.getSession();
        sess.invalidate();
        return "redirect:/user";
    }
}
