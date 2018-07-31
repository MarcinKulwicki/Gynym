package pl.coderslab.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "training")
public class Training {

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

    private Long series;
    private Long repeats;
    private Long weight;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "training")
    private List<Exercise> exercises;


    public Training(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
}
