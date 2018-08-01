package pl.coderslab.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "user")
public class User {


    //Niezalezne ID
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


    //Identyfikacja uzytkownika do logowania
    @Column(unique = true)
    @NotNull
    @NotBlank
    private String username;

    @Column(unique = true)
    @NotNull
    @NotBlank
    private String email;

    @NotNull
    private String password;

    //Profil uzytkownika
    //TODO Przeniesc HTTP do Controllera a w Service tylko logika
    @OneToMany(mappedBy = "user")
    private List<Body> bodies;

    @OneToMany(mappedBy = "user")
    private List<Training> trainings;

    public User(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    public String getUsername() {
        return username;
    }

    public void setUsername(@NotNull String username) {
        this.username = username;
    }

    @NotNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NotNull String email) {
        this.email = email;
    }

    @NotNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NotNull String password) {
        this.password = password;
    }

    public List<Body> getBodies() {
        return bodies;
    }

    public void setBodies(List<Body> bodies) {
        this.bodies = bodies;
    }

    public List<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(List<Training> trainings) {
        this.trainings = trainings;
    }
}
