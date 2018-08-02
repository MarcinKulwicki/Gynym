package pl.coderslab.dto;

import pl.coderslab.entity.Training;

import java.sql.Timestamp;

public class ExerciseDTO {
    private long id;
    Timestamp data_add;
    Timestamp data_mod;
    Long idv;

    private TrainingDTO trainingDTO;
    private String name;
    private String description;
    private String recommend;

    private Long series;
    private Long repeats;
    private Long weight;
    private Long time;

    public ExerciseDTO(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getData_add() {
        return data_add;
    }

    public void setData_add(Timestamp data_add) {
        this.data_add = data_add;
    }

    public Timestamp getData_mod() {
        return data_mod;
    }

    public void setData_mod(Timestamp data_mod) {
        this.data_mod = data_mod;
    }

    public Long getIdv() {
        return idv;
    }

    public void setIdv(Long idv) {
        this.idv = idv;
    }

    public TrainingDTO getTrainingDTO() {
        return trainingDTO;
    }

    public void setTrainingDTO(TrainingDTO trainingDTO) {
        this.trainingDTO = trainingDTO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public Long getSeries() {
        return series;
    }

    public void setSeries(Long series) {
        this.series = series;
    }

    public Long getRepeats() {
        return repeats;
    }

    public void setRepeats(Long repeats) {
        this.repeats = repeats;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
