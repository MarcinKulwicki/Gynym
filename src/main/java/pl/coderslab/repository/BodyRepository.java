package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.Body;

import java.util.List;

public interface BodyRepository extends JpaRepository<Body , Long> {
    List<Body> findAllByUser_Id(Long id);


    @Query(value = "SELECT * FROM body where user_id = :param and flag like 'stat' order by data_mod desc limit 1" , nativeQuery = true)
    Body findByUser_IdOrderByData_mod(@Param("param") Long param);





    @Query(value = "SELECT a FROM Body a where a.user.id = :id and a.flag like 'target'")
    Body findFirstByUser_IdAndFlagLikeTarget(@Param("id") Long id);

    @Query(value = "SELECT a FROM Body a where a.user.id = :id and a.flag like 'start'")
    Body findFirstByUser_IdAndFlagLikeStart(@Param("id") Long id);

    @Query(value = "SELECT a FROM Body a where a.user.id = :id and a.flag like 'stat' order by a.data_mod desc")
    List<Body> findFirstByUser_IDAndFlagLikeStatOrderByDataMod(@Param("id") Long id);


    Body findFirstById(Long id);
}
