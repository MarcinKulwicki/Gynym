//package pl.coderslab.entity;
//
//import org.hibernate.validator.constraints.NotBlank;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import java.util.List;
//
//@Entity
//@Table(name = "exercise_box")
//public class ExerciseBox {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @NotNull
//    @NotBlank
//    private String name;
//
//    @ManyToOne
//    private Training training;
//
//    @OneToMany(mappedBy = "exerciseBox")
//    private List<Exercise> exercises;
//
//    public ExerciseBox(){
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
//    @NotNull
//    public String getName() {
//        return name;
//    }
//
//    public void setName(@NotNull String name) {
//        this.name = name;
//    }
//
//    public List<Exercise> getExercises() {
//        return exercises;
//    }
//
//    public void setExercises(List<Exercise> exercises) {
//        this.exercises = exercises;
//    }
//
//    public Training getTraining() {
//        return training;
//    }
//
//    public void setTraining(Training training) {
//        this.training = training;
//    }
//}
