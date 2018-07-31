package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.Body;

import java.util.List;

public interface BodyRepository extends JpaRepository<Body , Long> {
    List<Body> findAllByUser_Id(Long id);

    @Query(value = "SELECT a FROM Body a where a.user.id = :id and a.flag like 'target'")
    Body findFirstByUser_IdAndFlagLikeTarget(@Param("id") Long id);

    @Query(value = "SELECT a FROM Body a where a.user.id = :id and a.flag not like 'target'")
    List<Body> findAllByUser_IdAndFlagNotLikeTarget(@Param("id") Long id);
}
