package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Body;
import pl.coderslab.entity.User;
import pl.coderslab.repository.BodyRepository;
import pl.coderslab.service.BodyService;
import pl.coderslab.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    @Autowired
    HttpSession sess;

    @GetMapping("")
    public String list(Model model, HttpServletRequest request){

        sess = request.getSession();
        User user = (User) sess.getAttribute("UserLogged");
        //BENG!
        List<Body> body = bodyRepository.findAllByUser_Id(user.getId());
        body.sort(Comparator.comparing(Body::getData_mod));
        Long[] progress = bodyService.getProgressBarForCategory("",bodyService.getTargetNowAndStartPointBody(user.getId()));
        model.addAttribute("start", progress[0]);
        model.addAttribute("now", progress[1]);
        model.addAttribute("end", progress[2]);
        model.addAttribute("proc", progress[3]);
        model.addAttribute("body", body);
        return "body/list";
    }

    @GetMapping("/{name}")
    public String list(Model model, HttpServletRequest request, @PathVariable String name){

        sess = request.getSession();
        User user = (User) sess.getAttribute("UserLogged");
        //BENG!
        List<Body> body = bodyRepository.findAllByUser_Id(user.getId());
        body.sort(Comparator.comparing(Body::getData_mod));
        //TODO model to progress bar
        Long[] progress = bodyService.getProgressBarForCategory(name,bodyService.getTargetNowAndStartPointBody(user.getId()));
        model.addAttribute("start", progress[0]);
        model.addAttribute("now", progress[1]);
        model.addAttribute("end", progress[2]);
        model.addAttribute("proc", progress[3]);
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
            sess = request.getSession();
            User user = (User)sess.getAttribute("UserLogged");
            body.setUser(user);
            bodyRepository.save(body);
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
            sess = request.getSession();
            body.setUser((User) sess.getAttribute("UserLogged"));
            body = bodyService.addOrEditTarget(body);
            bodyRepository.save(body);
        }
        return "redirect:/body";
    }
    @GetMapping("/start")
    public String start(Model model, HttpServletRequest request){
        model.addAttribute("body", bodyService.getNewStartOrLatest(request));
        return "body/form";
    }
    @PostMapping("/start")
    public String start(@Valid Body body, BindingResult bindingResult, HttpServletRequest request){
        if(!bindingResult.hasErrors()){
            sess = request.getSession();
            body.setUser((User) sess.getAttribute("UserLogged"));
            body = bodyService.addOrEditStart(body);
            bodyRepository.save(body);
        }
        return "redirect:/body";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        bodyRepository.delete(bodyRepository.findFirstById(id));
        return "redirect:/body";
    }
}
