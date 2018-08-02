package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.entity.Body;
import pl.coderslab.entity.User;
import pl.coderslab.repository.BodyRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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
    public Body getNewStartOrLatest(HttpServletRequest request){
        User user = userService.getUserFromSession(request);
        Body bodyInDb = bodyRepository.findFirstByUser_IdAndFlagLikeStart(user.getId());
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
    public Body addOrEditStart(Body body) {

        Body bodyInDb = bodyRepository.findFirstByUser_IdAndFlagLikeStart(body.getUser().getId());
        body.setFlag("start");
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

    public List<Body> getTargetNowAndStartPointBody(Long id) {
        Body bodyStart = bodyRepository.findFirstByUser_IdAndFlagLikeStart(id);
        List<Body> bodyNow = bodyRepository.findFirstByUser_IDAndFlagLikeStatOrderByDataMod(id);
        Body bodyTarget = bodyRepository.findFirstByUser_IdAndFlagLikeTarget(id);

        if (bodyStart != null && bodyNow != null && bodyTarget != null) {


        List<Body> bodies = new ArrayList<>();
        bodies.add(bodyStart);
        bodies.add(bodyNow.get(0));
        bodies.add(bodyTarget);
            return bodies;
        }
        return bodyRepository.findAll();
    }
    public Long[] getProgressBarForCategory(String category, List<Body> bodies){

        Long[] progresss = new Long[4];
        switch (category){

            case "Weight":
                progresss[0]= bodies.get(0).getWeight();
                progresss[1]= bodies.get(1).getWeight();
                progresss[2]= bodies.get(2).getWeight();
                progresss[3]= 0L;
                break;

                case "BicepsLeft":
                progresss[0]= bodies.get(0).getBicepsLeft();
                progresss[1]= bodies.get(1).getBicepsLeft();
                progresss[2]= bodies.get(2).getBicepsLeft();
                progresss[3]= 0L;
                break;

                case "BicepsRight":
                progresss[0]= bodies.get(0).getBicepsRight();
                progresss[1]= bodies.get(1).getBicepsRight();
                progresss[2]= bodies.get(2).getBicepsRight();
                progresss[3]= 0L;
                break;

                case "Chest":
                progresss[0]= bodies.get(0).getChest();
                progresss[1]= bodies.get(1).getChest();
                progresss[2]= bodies.get(2).getChest();
                progresss[3]= 0L;
                break;

                case "Waist":
                progresss[0]= bodies.get(0).getWaist();
                progresss[1]= bodies.get(1).getWaist();
                progresss[2]= bodies.get(2).getWaist();
                progresss[3]= 0L;
                break;

                case "Hips":
                progresss[0]= bodies.get(0).getHips();
                progresss[1]= bodies.get(1).getHips();
                progresss[2]= bodies.get(2).getHips();
                progresss[3]= 0L;
                break;

                case "ThighLeft":
                progresss[0]= bodies.get(0).getThighLeft();
                progresss[1]= bodies.get(1).getThighLeft();
                progresss[2]= bodies.get(2).getThighLeft();
                progresss[3]= 0L;
                break;

                case "ThighRight":
                progresss[0]= bodies.get(0).getThighRight();
                progresss[1]= bodies.get(1).getThighRight();
                progresss[2]= bodies.get(2).getThighRight();
                progresss[3]= 0L;
                break;

                case "CalfLeft":
                progresss[0]= bodies.get(0).getCalfLeft();
                progresss[1]= bodies.get(1).getCalfLeft();
                progresss[2]= bodies.get(2).getCalfLeft();
                progresss[3]= 0L;
                break;

                case "CalfRight":
                progresss[0]= bodies.get(0).getCalfRight();
                progresss[1]= bodies.get(1).getCalfRight();
                progresss[2]= bodies.get(2).getCalfRight();
                progresss[3]= 0L;
                break;

                default:
                    progresss[0]= bodies.get(0).getWeight();
                    progresss[1]= bodies.get(1).getWeight();
                    progresss[2]= bodies.get(2).getWeight();
                    progresss[3]= 0L;
        }

        if((progresss[0] == null || progresss[1] == null|| progresss[2]== null)){
            progresss[0] = 0L;
            progresss[1] = 0L;
            progresss[2] = 0L;
            return progresss;
        }
        if (progresss[2] > progresss[0]) {
            Long tmp = progresss[0];
            progresss[0] = progresss[2];
            progresss[2] = tmp;
        }
        progresss[3] = ( 100L / (progresss[2] - progresss[0]) ) * (progresss[2] - progresss[1]-1);


        return progresss;
    }
}
