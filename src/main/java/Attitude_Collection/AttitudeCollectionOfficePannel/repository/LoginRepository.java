package Attitude_Collection.AttitudeCollectionOfficePannel.repository;

import Attitude_Collection.AttitudeCollectionOfficePannel.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Integer> {

     Login findLoginByUserNameAndPassword(String username, String password);
}
