package pl.coderslab.entity;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "body")
public class Body {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Kontrola Bazy danych
    @CreationTimestamp
    Timestamp data_add;
    @UpdateTimestamp
    Timestamp data_mod;
    @Version
    Long idv;


    @ManyToOne
    private User user;

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



    // 'now' - actual body
    // 'start' - start body
    // 'target' - target body
    private String flag;



    public Body(){
        flag = "stat";

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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

    public Timestamp getData_mod() {
        return data_mod;
    }

    @Override
    public String toString() {
        return data_mod.toLocalDateTime().getYear()+":"+data_mod.toLocalDateTime().getMonth()+":"+data_mod.toLocalDateTime().getDayOfMonth();
    }
}
