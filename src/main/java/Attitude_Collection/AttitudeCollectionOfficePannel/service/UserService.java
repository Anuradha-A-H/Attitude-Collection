package Attitude_Collection.AttitudeCollectionOfficePannel.service;


import Attitude_Collection.AttitudeCollectionOfficePannel.entity.Login;
import Attitude_Collection.AttitudeCollectionOfficePannel.entity.Role;
import Attitude_Collection.AttitudeCollectionOfficePannel.entity.User;
import Attitude_Collection.AttitudeCollectionOfficePannel.repository.RoleRepository;
import Attitude_Collection.AttitudeCollectionOfficePannel.repository.UserRepository;
import Attitude_Collection.AttitudeCollectionOfficePannel.request.NewUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private RoleRepository roleRepo;

    public  String addUser(NewUserRequest request){
        Login logindtl = Login.builder()
                .userName(request.getUserName())
                .password(request.getPassword())
                .build();
        Optional<Role> role = roleRepo.findById(request.getRoleId());
        if(role.isEmpty())
            return "Invalid RoleId";
        User userdtl = User.builder()
                .age(request.getAge())
                .email(request.getEmail())
                .gender(request.getGender())
                .role(role.get())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .login(logindtl)
                .build();
        userRepo.save(userdtl);
        return "User Added Successfully";
    }

    public User getUserById(Integer id)
    {
        return userRepo.findById(id).get();
    }



}
