package Attitude_Collection.AttitudeCollectionOfficePannel.repository;

import Attitude_Collection.AttitudeCollectionOfficePannel.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LoginRepository extends JpaRepository<Login, Integer> {

     Login findLoginByUserNameAndPassword(String username, String password);

//     @Query(nativeQuery = true, value = "select * from login where password = :showid")
//     public List<Login> findloginwithdate(Integer showid);
}
