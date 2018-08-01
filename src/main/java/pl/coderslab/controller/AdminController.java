package pl.coderslab.controller;

import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping
    public String admin(Model model){
        model.addAttribute("user", adminService.getAllUsers());
        return "admin/listUser";
    }
    @GetMapping("/list")
    public String adminn(Model model){
        model.addAttribute("user", adminService.getAllUsers());
        return "admin/listUser";
    }
}
