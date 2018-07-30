package pl.coderslab.entity;


import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "exercise")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
    private String name;

    private String description;

    private String recommend;

    @ManyToOne
    private ExerciseBox exerciseBox;


    public Exercise(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public ExerciseBox getExerciseBox() {
        return exerciseBox;
    }

    public void setExerciseBox(ExerciseBox exerciseBox) {
        this.exerciseBox = exerciseBox;
    }
}
