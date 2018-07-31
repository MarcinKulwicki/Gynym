//package pl.coderslab.entity;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "profil")
//public class Profil {
//
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Long id;
////
////    @OneToOne
////    private User user;
//
//    @OneToOne(mappedBy = "profil")
//    private Body body;
//
//    @OneToOne(mappedBy = "profil")
//    private ProfilProgress profilProgress;
//
//    @OneToMany(mappedBy = "profil")
//    private List<Training> trainings;
//
//    public Profil(){
//
//    }
//
//    public List<Training> getTrainings() {
//        return trainings;
//    }
//
//    public void setTrainings(List<Training> trainings) {
//        this.trainings = trainings;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public Body getBody() {
//        return body;
//    }
//
//    public void setBody(Body body) {
//        this.body = body;
//    }
//
//    public ProfilProgress getProfilProgress() {
//        return profilProgress;
//    }
//
//    public void setProfilProgress(ProfilProgress profilProgress) {
//        this.profilProgress = profilProgress;
//    }
//
//
//}
