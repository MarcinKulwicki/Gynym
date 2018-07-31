package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Training;

import java.util.List;

public interface TrainingRepository extends JpaRepository<Training , Long> {

    List<Training> findAllByUser_Id(Long id);
    Training findFirstById(Long id);
}
