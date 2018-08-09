package pl.coderslab.dto;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import pl.coderslab.entity.User;

import java.sql.Timestamp;

public class BodyDTO {


    private Long id;

    Timestamp data_add;
    Timestamp data_mod;
    Long idv;
    private UserDTO user;

    private Long weight;
    private Long hight;

    private Long bicepsLeft;
    private Long bicepsRight;
    private Long chest;
    private Long waist;
    private Long hips;
    private Long thighLeft;
    private Long thighRight;
    private Long calfLeft;
    private Long calfRight;

    private String flag;

    private String modDate;


    public BodyDTO(){
        flag = "stat";
    }

    public String getModDate() {
        return data_mod.toLocalDateTime().toString()+flag;
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

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Long getHight() {
        return hight;
    }

    public void setHight(Long hight) {
        this.hight = hight;
    }

    public Long getBicepsLeft() {
        return bicepsLeft;
    }

    public void setBicepsLeft(Long bicepsLeft) {
        this.bicepsLeft = bicepsLeft;
    }

    public Long getBicepsRight() {
        return bicepsRight;
    }

    public void setBicepsRight(Long bicepsRight) {
        this.bicepsRight = bicepsRight;
    }

    public Long getChest() {
        return chest;
    }

    public void setChest(Long chest) {
        this.chest = chest;
    }

    public Long getWaist() {
        return waist;
    }

    public void setWaist(Long waist) {
        this.waist = waist;
    }

    public Long getHips() {
        return hips;
    }

    public void setHips(Long hips) {
        this.hips = hips;
    }

    public Long getThighLeft() {
        return thighLeft;
    }

    public void setThighLeft(Long thighLeft) {
        this.thighLeft = thighLeft;
    }

    public Long getThighRight() {
        return thighRight;
    }

    public void setThighRight(Long thighRight) {
        this.thighRight = thighRight;
    }

    public Long getCalfLeft() {
        return calfLeft;
    }

    public void setCalfLeft(Long calfLeft) {
        this.calfLeft = calfLeft;
    }

    public Long getCalfRight() {
        return calfRight;
    }

    public void setCalfRight(Long calfRight) {
        this.calfRight = calfRight;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
