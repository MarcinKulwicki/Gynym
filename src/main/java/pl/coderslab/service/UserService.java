package pl.coderslab.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import pl.coderslab.dto.UserDTO;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;

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
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            if(encoder.matches(userDTO.getPassword(), user.getPassword())) {
                userDTO.setId(user.getId());
                sess.setAttribute("UserLogged", userDTO);
                return true;
            }
        }
        return false;
    }
    public void saveToDb(UserDTO userDTO){
        User user = userRepository.findFirstByUsername(userDTO.getUsername());
        if(user== null){

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String password = encoder.encode(userDTO.getPassword());
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
        user.setEmail(userDTO.getEmail());
        return user;
    }

    public String editUserInDb(UserDTO userDTO){

        User user = userRepository.findFirstByUsername(userDTO.getUsername());
        if(user.getEmail().equals(userDTO.getEmail())){
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            Random random = new Random();
            int rand = random.nextInt(200000)+200000;


            String password = encoder.encode(rand+"");
            user.setPassword(password);
            userRepository.save(user);
            return rand+"";
        }

        return null;
    }

    public void removeUser(UserDTO userDTO) {
        User user = userRepository.findFirstByUsername(userDTO.getUsername());
        if(user != null){
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setUsername(encoder.encode("non"));
            user.setEmail(encoder.encode("non"));
            userRepository.save(user);
        }
    }

    public void changePassword(String oldPassword, String newPassword1, String newPassword2, UserDTO userDTO) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User user = userRepository.findFirstByUsername(userDTO.getUsername());

        if(encoder.matches(oldPassword,user.getPassword())){
            if(newPassword1.equals(newPassword2));

            user.setPassword(encoder.encode(newPassword1));
            userRepository.save(user);
        }

    }

    public UserDTO convertToUserDTO(User user) {
        UserDTO userDTO= new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setData_add(user.getData_add());
        userDTO.setData_mod(user.getData_mod());
        userDTO.setIdv(user.getIdv());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }
}
