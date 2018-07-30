package pl.coderslab.entity;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "profil_progress")
public class ProfilProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime localDateTime;

    @OneToOne
    private Profil profil;

    @OneToOne
    private Body bodyNow;
    @OneToOne
    private Body bodyStart;
    @OneToOne
    private Body bodyTarget;


    public ProfilProgress(){
        this.localDateTime = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public Body getBodyNow() {
        return bodyNow;
    }

    public void setBodyNow(Body bodyNow) {
        this.bodyNow = bodyNow;
    }

    public Body getBodyStart() {
        return bodyStart;
    }

    public void setBodyStart(Body bodyStart) {
        this.bodyStart = bodyStart;
    }

    public Body getBodyTarget() {
        return bodyTarget;
    }

    public void setBodyTarget(Body bodyTarget) {
        this.bodyTarget = bodyTarget;
    }
}
