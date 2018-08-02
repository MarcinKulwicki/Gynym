package pl.coderslab.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.dto.UserDTO;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    HttpSession sess;


    public boolean logIn(String username, String password){

        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(username);
        userDTO.setPassword(password);

        User user = userRepository.findFirstByUsername(userDTO.getUsername());
        if(user != null) {
            if (BCrypt.checkpw(userDTO.getPassword(), user.getPassword())) {
                userDTO.setId(user.getId());
                sess.setAttribute("UserLogged", userDTO);
                return true;
            }
        }
        return false;
    }
    public void saveToDb(UserDTO userDTO){
        User user = userRepository.findFirstByUsername(userDTO.getUsername());
        if(user.getUsername() == null){

            String password = BCrypt.hashpw(userDTO.getPassword(), BCrypt.gensalt());
            userDTO.setPassword(password);
            userRepository.save(convertToUser(userDTO, new User()));
        }
    }

    public User convertToUser(UserDTO userDTO, User user){

        user.setId(userDTO.getId());
        user.setData_add(userDTO.getData_add());
        user.setData_mod(userDTO.getData_mod());
        user.setIdv(userDTO.getIdv());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getPassword());
        return user;
    }

    public boolean editUserInDb(User user){
        User userInDb = userRepository.findFirstByUsername(user.getUsername());
        if(userInDb.getEmail().equals(user.getEmail())){
            String password = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
            userInDb.setPassword(password);
            userRepository.save(userInDb);
            return true;
        }

        return false;
    }

    public Long getUserIdFromSession(HttpServletRequest request){
        User user = getUserFromSession(request);
        if(user!=null){
            return user.getId();
        }
        return 0L;
    }
    public User getUserFromSession(HttpServletRequest request){
        sess = request.getSession();
        User user = (User)sess.getAttribute("UserLogged");
        return user;
    }
}
