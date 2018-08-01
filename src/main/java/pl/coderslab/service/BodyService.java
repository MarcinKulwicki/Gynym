package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.entity.Body;
import pl.coderslab.entity.User;
import pl.coderslab.repository.BodyRepository;

import javax.servlet.http.HttpServletRequest;

@Component
public class BodyService {

    @Autowired
    UserService userService;
    @Autowired
    BodyRepository bodyRepository;



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
    public Body getNewTargetOrLatest(HttpServletRequest request){
            User user = userService.getUserFromSession(request);
            Body bodyInDb = bodyRepository.findFirstByUser_IdAndFlagLikeTarget(user.getId());
            if(bodyInDb == null) return new Body();
        return bodyInDb;
    }

    public Body getNewBodyOrLatest(HttpServletRequest request){
        User user = userService.getUserFromSession(request);
        Body body;
        body = bodyRepository.findByUser_IdOrderByData_mod(user.getId());
        if(body == null) return new Body();
        return body;
    }

    public Body addOrEditTarget(Body body) {

        Body bodyInDb = bodyRepository.findFirstByUser_IdAndFlagLikeTarget(body.getUser().getId());
        body.setFlag("target");
        if(bodyInDb == null) return body;

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
        return bodyInDb;
    }
}
