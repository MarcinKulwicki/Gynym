package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dto.BodyDTO;
import pl.coderslab.dto.UserDTO;
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
    public String list(Model model){

        UserDTO userDTO = (UserDTO) sess.getAttribute("UserLogged");
        //BENG!
        List<BodyDTO> bodyDTOList = bodyService.findAllByUserId(userDTO.getId());
        bodyDTOList.sort(Comparator.comparing(BodyDTO::getData_mod));

        Long[] progress = bodyService.getProgressBarForCategory("",bodyService.getTargetNowAndStartPointBody(userDTO.getId()));
        model.addAttribute("start", progress[0]);
        model.addAttribute("now", progress[1]);
        model.addAttribute("end", progress[2]);
        model.addAttribute("proc", progress[3]);
        model.addAttribute("body", bodyDTOList);
        return "body/list";
    }

    @GetMapping("/{name}")
    public String list(Model model, @PathVariable String name){

        UserDTO userDTO = (UserDTO) sess.getAttribute("UserLogged");
        //BENG!
        List<BodyDTO> bodyDTOList = bodyService.findAllByUserId(userDTO.getId());
        bodyDTOList.sort(Comparator.comparing(BodyDTO::getData_mod));

        Long[] progress = bodyService.getProgressBarForCategory(name,bodyService.getTargetNowAndStartPointBody(userDTO.getId()));
        model.addAttribute("start", progress[0]);
        model.addAttribute("now", progress[1]);
        model.addAttribute("end", progress[2]);
        model.addAttribute("proc", progress[3]);
        model.addAttribute("body", bodyDTOList);
        return "body/list";
    }

    @GetMapping("/add")
    public String add(Model model){
        UserDTO userDTO = (UserDTO) sess.getAttribute("UserLogged");
        model.addAttribute("body", bodyService.getNewBodyOrLatest(userDTO.getId()));
        return "body/form";
    }
    @PostMapping("/add")
    public String add(@Valid BodyDTO bodyDTO, BindingResult bindingResult){
        if(!bindingResult.hasErrors()){
            UserDTO userDTO = (UserDTO)sess.getAttribute("UserLogged");
            bodyService.saveBody(bodyDTO, userDTO.getId());
        }
        return "redirect:/body";
    }
    @GetMapping("/target")
    public String target(Model model){
        UserDTO userDTO = (UserDTO)sess.getAttribute("UserLogged");
        BodyDTO bodyDTO = bodyService.getNewTargetOrLatest(userDTO.getId());
        model.addAttribute("body",bodyDTO);
        return "body/form";
    }
    @PostMapping("/target")
    public String target(@Valid BodyDTO bodyDTO, BindingResult bindingResult){
        if(!bindingResult.hasErrors()){

            UserDTO userDTO = (UserDTO) sess.getAttribute("UserLogged");
            bodyService.addOrEditTarget(bodyDTO, userDTO.getId());
        }
        return "redirect:/body";
    }
    @GetMapping("/start")
    public String start(Model model){
        UserDTO userDTO = (UserDTO)sess.getAttribute("UserLogged");
        BodyDTO bodyDTO = bodyService.getNewStartOrLatest(userDTO.getId());
        model.addAttribute("body", bodyDTO);
        return "body/form";
    }
    @PostMapping("/start")
    public String start(@Valid BodyDTO bodyDTO, BindingResult bindingResult){
        if(!bindingResult.hasErrors()){
            UserDTO userDTO = (UserDTO) sess.getAttribute("UserLogged");
            bodyService.addOrEditStart(bodyDTO, userDTO.getId());
        }
        return "redirect:/body";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        bodyService.deleteBody(id);
        return "redirect:/body";
    }
}
