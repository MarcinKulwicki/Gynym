package pl.coderslab.dto;

import pl.coderslab.entity.User;

import java.sql.Timestamp;
import java.util.List;

public class TrainingDTO {

    private Long id;
    private Timestamp data_add;
    private Timestamp data_mod;
    private Long idv;

    private String name;

    private User user;

    private List<ExerciseDTO> exerciseDTOList;


    public TrainingDTO(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ExerciseDTO> getExerciseDTOList() {
        return exerciseDTOList;
    }

    public void setExerciseDTOList(List<ExerciseDTO> exerciseDTOList) {
        this.exerciseDTOList = exerciseDTOList;
    }
}
