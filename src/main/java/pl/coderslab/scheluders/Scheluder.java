package pl.coderslab.scheluders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.coderslab.dto.TrainingDTO;
import pl.coderslab.service.TrainingService;

@Component
public class Scheluder {

    @Autowired
    TrainingService trainingService;

    //@Scheduled(fixedRate = 10000)
    @Scheduled(cron = "0 28 13 * * *")
    public void doSheluder(){

        TrainingDTO trainingDTO = trainingService.findByTrainingId(1L);
        System.out.println(trainingDTO.getName()+" "+trainingDTO.getExerciseDTOList());
    }
}
