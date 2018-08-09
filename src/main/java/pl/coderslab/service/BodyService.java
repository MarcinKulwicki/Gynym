package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.dto.BodyDTO;
import pl.coderslab.entity.Body;
import pl.coderslab.entity.Exercise;
import pl.coderslab.entity.User;
import pl.coderslab.repository.BodyRepository;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class BodyService {

    @Autowired
    UserService userService;
    @Autowired
    BodyRepository bodyRepository;
    @Autowired
    UserRepository userRepository;


    public BodyDTO getNewTargetOrLatest(Long id){

        Body body = bodyRepository.findFirstByUser_IdAndFlagLikeTarget(id);
        if(body == null) return new BodyDTO();
        return convertToBodyDTO(body);
    }
    public BodyDTO getNewStartOrLatest(Long id){

        Body body = bodyRepository.findFirstByUser_IdAndFlagLikeStart(id);
        if(body == null) return new BodyDTO();
        return convertToBodyDTO(body);
    }

    public BodyDTO getNewBodyOrLatest(Long id){

        Body body;
        body = bodyRepository.findByUser_IdOrderByData_mod(id);
        if(body == null) return new BodyDTO();
        return convertToBodyDTO(body);
    }

    public void addOrEditTarget(BodyDTO bodyDTO , Long userId) {

        Body body = bodyRepository.findFirstByUser_IdAndFlagLikeTarget(userId);
        if(body != null) bodyDTO.setId(body.getId());
        bodyDTO.setFlag("target");
        saveBody(bodyDTO,userId);
    }
    public void addOrEditStart(BodyDTO bodyDTO, Long userId) {

        Body body = bodyRepository.findFirstByUser_IdAndFlagLikeStart(userId);
        if(body != null) bodyDTO.setId(body.getId());
        bodyDTO.setFlag("start");
        saveBody(bodyDTO,userId);
    }

    public List<BodyDTO> getTargetNowAndStartPointBody(Long id) {
        Body bodyStart = bodyRepository.findFirstByUser_IdAndFlagLikeStart(id);
        List<Body> bodyNow = bodyRepository.findFirstByUser_IDAndFlagLikeStatOrderByDataMod(id);
        Body bodyTarget = bodyRepository.findFirstByUser_IdAndFlagLikeTarget(id);

        if (bodyStart != null && bodyNow != null && bodyTarget != null) {

            BodyDTO bodyDTOStart = convertToBodyDTO(bodyStart);
            BodyDTO bodyDTONow = convertToBodyDTO(bodyNow.get(0));
            BodyDTO bodyDTOTarget = convertToBodyDTO(bodyTarget);

            List<BodyDTO> bodyDTOList = new ArrayList<>();
            bodyDTOList.add(bodyDTOStart);
            bodyDTOList.add(bodyDTONow);
            bodyDTOList.add(bodyDTOTarget);
            return bodyDTOList;
        }
        return null;
    }
    public Long[] getProgressBarForCategory(String category, List<BodyDTO> bodyDTOList){

        Long[] progresss = new Long[4];
        if(bodyDTOList == null){
            progresss[0] = 0L;
            progresss[1] = 0L;
            progresss[2] = 0L;
            progresss[3] = 100L;
            return progresss;
        }
        switch (category){

            case "Weight":
                progresss[0]= bodyDTOList.get(0).getWeight();
                progresss[1]= bodyDTOList.get(1).getWeight();
                progresss[2]= bodyDTOList.get(2).getWeight();
                progresss[3]= 0L;
                break;

                case "BicepsLeft":
                progresss[0]= bodyDTOList.get(0).getBicepsLeft();
                progresss[1]= bodyDTOList.get(1).getBicepsLeft();
                progresss[2]= bodyDTOList.get(2).getBicepsLeft();
                progresss[3]= 0L;
                break;

                case "BicepsRight":
                progresss[0]= bodyDTOList.get(0).getBicepsRight();
                progresss[1]= bodyDTOList.get(1).getBicepsRight();
                progresss[2]= bodyDTOList.get(2).getBicepsRight();
                progresss[3]= 0L;
                break;

                case "Chest":
                progresss[0]= bodyDTOList.get(0).getChest();
                progresss[1]= bodyDTOList.get(1).getChest();
                progresss[2]= bodyDTOList.get(2).getChest();
                progresss[3]= 0L;
                break;

                case "Waist":
                progresss[0]= bodyDTOList.get(0).getWaist();
                progresss[1]= bodyDTOList.get(1).getWaist();
                progresss[2]= bodyDTOList.get(2).getWaist();
                progresss[3]= 0L;
                break;

                case "Hips":
                progresss[0]= bodyDTOList.get(0).getHips();
                progresss[1]= bodyDTOList.get(1).getHips();
                progresss[2]= bodyDTOList.get(2).getHips();
                progresss[3]= 0L;
                break;

                case "ThighLeft":
                progresss[0]= bodyDTOList.get(0).getThighLeft();
                progresss[1]= bodyDTOList.get(1).getThighLeft();
                progresss[2]= bodyDTOList.get(2).getThighLeft();
                progresss[3]= 0L;
                break;

                case "ThighRight":
                progresss[0]= bodyDTOList.get(0).getThighRight();
                progresss[1]= bodyDTOList.get(1).getThighRight();
                progresss[2]= bodyDTOList.get(2).getThighRight();
                progresss[3]= 0L;
                break;

                case "CalfLeft":
                progresss[0]= bodyDTOList.get(0).getCalfLeft();
                progresss[1]= bodyDTOList.get(1).getCalfLeft();
                progresss[2]= bodyDTOList.get(2).getCalfLeft();
                progresss[3]= 0L;
                break;

                case "CalfRight":
                progresss[0]= bodyDTOList.get(0).getCalfRight();
                progresss[1]= bodyDTOList.get(1).getCalfRight();
                progresss[2]= bodyDTOList.get(2).getCalfRight();
                progresss[3]= 0L;
                break;

                default:
                    progresss[0]= bodyDTOList.get(0).getWeight();
                    progresss[1]= bodyDTOList.get(1).getWeight();
                    progresss[2]= bodyDTOList.get(2).getWeight();
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
        progresss[3] = ( 100L / (progresss[2] - progresss[0]) ) * (progresss[2] - progresss[1]);


        return progresss;
    }

    public List<BodyDTO> findAllByUserId(Long id) {

        List<Body> bodies = bodyRepository.findAllByUser_Id(id);
        List<BodyDTO> bodyDTOList = new ArrayList<>();
        for(Body body:bodies){
            bodyDTOList.add(convertToBodyDTO(body));
        }
        return bodyDTOList;
    }

    private BodyDTO convertToBodyDTO(Body body) {
        BodyDTO bodyDTO = new BodyDTO();

        bodyDTO.setHight(body.getHight());
        bodyDTO.setHips(body.getHips());
        bodyDTO.setBicepsLeft(body.getBicepsLeft());
        bodyDTO.setBicepsRight(body.getBicepsRight());
        bodyDTO.setCalfLeft(body.getCalfLeft());
        bodyDTO.setCalfRight(body.getCalfRight());
        bodyDTO.setChest(body.getChest());
        bodyDTO.setData_add(body.getData_add());
        bodyDTO.setData_mod(body.getData_mod());
        bodyDTO.setFlag(body.getFlag());
        bodyDTO.setId(body.getId());
        bodyDTO.setIdv(body.getIdv());
        bodyDTO.setThighLeft(body.getThighLeft());
        bodyDTO.setThighRight(body.getThighRight());
        bodyDTO.setWaist(body.getWaist());
        bodyDTO.setWeight(body.getWeight());
        //TODO check
        bodyDTO.setUser(userService.convertToUserDTO(body.getUser()));

        return bodyDTO;
    }

    private Body convertToBody(BodyDTO bodyDTO , Body body) {

        body.setHight(bodyDTO.getHight());
        body.setHips(bodyDTO.getHips());
        body.setBicepsLeft(bodyDTO.getBicepsLeft());
        body.setBicepsRight(bodyDTO.getBicepsRight());
        body.setCalfLeft(bodyDTO.getCalfLeft());
        body.setCalfRight(bodyDTO.getCalfRight());
        body.setChest(bodyDTO.getChest());
        body.setData_add(bodyDTO.getData_add());
        body.setData_mod(bodyDTO.getData_mod());
        body.setFlag(bodyDTO.getFlag());
        body.setId(bodyDTO.getId());
        body.setIdv(bodyDTO.getIdv());
        body.setThighLeft(bodyDTO.getThighLeft());
        body.setThighRight(bodyDTO.getThighRight());
        body.setWaist(bodyDTO.getWaist());
        body.setWeight(bodyDTO.getWeight());

        return body;
    }

    public void saveBody(BodyDTO bodyDTO,Long userId) {
        Body body;
        if( bodyDTO.getId()== null){
            body = convertToBody(bodyDTO, new Body());
        }else {
            body = convertToBody(bodyDTO, bodyRepository.findFirstById(bodyDTO.getId()));
        }
        if(userId != null) body.setUser(userRepository.findFirstById(userId));
        bodyRepository.save(body);

    }

    public void deleteBody(Long id) {
        bodyRepository.delete(bodyRepository.findFirstById(id));
    }
}
