package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.entity.Body;
import pl.coderslab.repository.BodyRepository;

import javax.servlet.http.HttpServletRequest;

@Component
public class BodyService {

    @Autowired
    UserService userService;
    @Autowired
    BodyRepository bodyRepository;


    public boolean saveBodyToUserInDb(Body body, HttpServletRequest request){

        body.setUser(userService.getUserFromSession(request));
        if(body.getUser() != null){
            bodyRepository.save(body);
            return true;
        }
        return false;
    }

    public boolean saveTargetBodyToUserInDb(Body body, HttpServletRequest request){


        body.setUser(userService.getUserFromSession(request));
        if(body.getUser() != null){
            Body bodyInDb = bodyRepository.findFirstByUser_IdAndFlagLikeTarget(body.getUser().getId());
            if(bodyInDb != null){
                bodyInDb.setBicepsLeft(body.getBicepsLeft());
                bodyInDb.setBicepsRight(body.getCalfRight());
                bodyInDb.setCalfLeft(body.getCalfLeft());
                bodyInDb.setCalfRight(body.getCalfRight());
                bodyInDb.setChest(body.getChest());
                bodyInDb.setHight(body.getHight());
                bodyInDb.setWeight(body.getWeight());
                bodyInDb.setWaist(body.getWaist());
                bodyInDb.setThighLeft(body.getThighLeft());
                bodyInDb.setThighRight(body.getThighRight());
                bodyInDb.setHips(body.getHips());
            }
            bodyRepository.save(bodyInDb);
            return true;
        }
        return false;
    }
}
