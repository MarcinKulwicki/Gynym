package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.service.HomeService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @Autowired
    HomeService homeService;


    @GetMapping("")
    public String list(){
        return "home";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        homeService.logout(request);
        return "redirect:/user";
    }
}
