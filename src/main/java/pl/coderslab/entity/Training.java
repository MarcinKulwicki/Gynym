package pl.coderslab.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "training")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long series;
    private Long repeats;
    private Long weight;

    @ManyToOne
    Profil profil;

    @OneToMany(mappedBy = "training")
    List<ExerciseBox> exerciseBoxes;


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

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public List<ExerciseBox> getExerciseBoxes() {
        return exerciseBoxes;
    }

    public void setExerciseBoxes(List<ExerciseBox> exerciseBoxes) {
        this.exerciseBoxes = exerciseBoxes;
    }
}
