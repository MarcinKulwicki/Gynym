package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
}
