package pl.coderslab.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "body")
public class Body {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long weight;
    private Long hight;

    private Long biceps;
    private Long chest;
    private Long waist;
    private Long thigh;
    private Long calf;

    @OneToOne
    private Profil profil;

    @OneToMany(mappedBy = "")
    private List<ProfilProgress> profilProgresses;

    @OneToOne(mappedBy = "bodyNow")
    private ProfilProgress profilProgressNow;
    @OneToOne(mappedBy = "bodyStart")
    private ProfilProgress profilProgressStart;
    @OneToOne(mappedBy = "bodyTarget")
    private ProfilProgress profilProgressTarget;


    public Body(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public List<ProfilProgress> getProfilProgresses() {
        return profilProgresses;
    }

    public void setProfilProgresses(List<ProfilProgress> profilProgresses) {
        this.profilProgresses = profilProgresses;
    }

    public ProfilProgress getProfilProgressNow() {
        return profilProgressNow;
    }

    public void setProfilProgressNow(ProfilProgress profilProgressNow) {
        this.profilProgressNow = profilProgressNow;
    }

    public ProfilProgress getProfilProgressStart() {
        return profilProgressStart;
    }

    public void setProfilProgressStart(ProfilProgress profilProgressStart) {
        this.profilProgressStart = profilProgressStart;
    }

    public ProfilProgress getProfilProgressTarget() {
        return profilProgressTarget;
    }

    public void setProfilProgressTarget(ProfilProgress profilProgressTarget) {
        this.profilProgressTarget = profilProgressTarget;
    }
}
