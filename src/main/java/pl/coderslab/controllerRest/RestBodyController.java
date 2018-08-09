package pl.coderslab.controllerRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.dto.BodyDTO;
import pl.coderslab.dto.UserDTO;
import pl.coderslab.repository.BodyRepository;
import pl.coderslab.service.BodyService;
import pl.coderslab.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/bodyRest")
public class RestBodyController {

    @Autowired
    BodyRepository bodyRepository;
    @Autowired
    UserService userService;
    @Autowired
    BodyService bodyService;
    @Autowired
    HttpSession sess;

    @GetMapping("/")
    public List<BodyDTO> list(Model model){

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
        return bodyDTOList;
    }
}
