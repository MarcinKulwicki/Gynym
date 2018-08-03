package pl.coderslab.dto;



import pl.coderslab.entity.Body;
import pl.coderslab.entity.Training;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;

public class UserDTO {


    private Long id;

    private Timestamp data_add;
    private Timestamp data_mod;
    private Long idv;

    @Size(min = 3 , max = 30)
    private String username;
    @Size(min = 3 , max = 100)
    private String email;
    @Size(min = 3)
    private String password;

    private List<BodyDTO> bodyDTOList;
    private List<TrainingDTO> trainingDTOList;

    public UserDTO(){

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<BodyDTO> getBodyDTOList() {
        return bodyDTOList;
    }

    public void setBodyDTOList(List<BodyDTO> bodyDTOList) {
        this.bodyDTOList = bodyDTOList;
    }

    public List<TrainingDTO> getTrainingDTOList() {
        return trainingDTOList;
    }

    public void setTrainingDTOList(List<TrainingDTO> trainingDTOList) {
        this.trainingDTOList = trainingDTOList;
    }
}
