package pl.coderslab.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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


    public boolean logIn(HttpServletRequest request){

        User user = new User();
        user.setPassword(request.getParameter("password"));
        user.setUsername(request.getParameter("username"));

        User userInBase = userRepository.findFirstByUsername(user.getUsername());
        if(userInBase != null) {
            if (BCrypt.checkpw(user.getPassword(), userInBase.getPassword())) {
                sess = request.getSession();
                sess.setAttribute("UserLogged", userInBase);
                return true;
            }
        }
        return false;
    }
    public void saveToDb(User user){
        String password = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(password);
        userRepository.save(user);
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
}
