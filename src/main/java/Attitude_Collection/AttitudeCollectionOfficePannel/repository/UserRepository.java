package Attitude_Collection.AttitudeCollectionOfficePannel.repository;

import Attitude_Collection.AttitudeCollectionOfficePannel.entity.Role;
import Attitude_Collection.AttitudeCollectionOfficePannel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findAllByRoleRoleId(Integer roleId);
    User findByEmail(String email);
   User findByRoleRoleId(Integer roleId);

}
