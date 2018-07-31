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


    @OneToOne
    private User user;
    @ManyToOne
    private ProfilProgress profilProgress;


    private Long weight;
    private Long hight;

    private Long biceps;
    private Long chest;
    private Long waist;
    private Long thigh;
    private Long calf;

    private LocalDateTime dateBody;

    // 'now' - actual body
    // 'start' - start body
    // 'target' - target body
    private String flag;



    public Body(){

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

    public ProfilProgress getProfilProgress() {
        return profilProgress;
    }

    public void setProfilProgress(ProfilProgress profilProgress) {
        this.profilProgress = profilProgress;
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

    public Long getBiceps() {
        return biceps;
    }

    public void setBiceps(Long biceps) {
        this.biceps = biceps;
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

    public Long getThigh() {
        return thigh;
    }

    public void setThigh(Long thigh) {
        this.thigh = thigh;
    }

    public Long getCalf() {
        return calf;
    }

    public void setCalf(Long calf) {
        this.calf = calf;
    }

    public LocalDateTime getDateBody() {
        return dateBody;
    }

    public void setDateBody(LocalDateTime dateBody) {
        this.dateBody = dateBody;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
