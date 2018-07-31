//package pl.coderslab.entity;
//
//
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//
//import javax.persistence.*;
//import java.sql.Timestamp;
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Entity
//@Table(name = "profil_progress")
//public class ProfilProgress {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    //Kontrola Bazy danych
//    @CreationTimestamp
//    Timestamp data_add;
//    @UpdateTimestamp
//    Timestamp data_mod;
//    @Version
//    Long idv;
//
//
//    @OneToOne
//    private User user;
//
//    @OneToMany(mappedBy = "profilProgress")
//    private List<Body> bodies;
//
//    public ProfilProgress(){
//
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
//    public List<Body> getBodies() {
//        return bodies;
//    }
//
//    public void setBodies(List<Body> bodies) {
//        this.bodies = bodies;
//    }
//}
