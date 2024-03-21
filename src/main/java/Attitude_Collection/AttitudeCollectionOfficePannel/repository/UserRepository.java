package Attitude_Collection.AttitudeCollectionOfficePannel.repository;

import Attitude_Collection.AttitudeCollectionOfficePannel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
