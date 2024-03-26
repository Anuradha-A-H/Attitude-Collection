package Attitude_Collection.AttitudeCollectionOfficePannel.service;

import Attitude_Collection.AttitudeCollectionOfficePannel.entity.Login;
import Attitude_Collection.AttitudeCollectionOfficePannel.entity.User;
import Attitude_Collection.AttitudeCollectionOfficePannel.repository.LoginRepository;
import Attitude_Collection.AttitudeCollectionOfficePannel.request.ChangePasswordRequest;
import Attitude_Collection.AttitudeCollectionOfficePannel.response.Sessionresponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {
    
    @Autowired
    private LoginRepository loginRepo;


    public String changePassword(ChangePasswordRequest request){
        Login logindtl = loginRepo.findLoginByUserNameAndPassword(request.getUsername(),request.getOldPassword());
        if(logindtl == null)
             return "incorrect username or password";
        Login logins = Login.builder()
                .password(request.getNewPassword())
                .id(logindtl.getId())
                .userName(logindtl.getUserName())
                .build();
        loginRepo.save(logins);

        return "Password Updated Successfully";
    }
    public  String forgotPassword(){
        return "";
    }

//    public String changeUsername(){
//        Login logindtl = loginRepo.findLoginByUserNameAndPassword(request.getUsername(),request.getOldPassword());
//        if(logindtl == null)
//            return "incorrect username or password";
//        Login logins = Login.builder()
//                .password(request.getNewPassword())
//                .id(logindtl.getId())
//                .userName(logindtl.getUserName())
//                .build();
//        loginRepo.save(logins);
//
//        return "Password Updated Successfully";
//    }

    public Sessionresponse logindetails(Login login){
        Login  logindtl =  loginRepo.findLoginByUserNameAndPassword(login.getUserName(),login.getPassword());

        if(logindtl.getId() == null)
            return null;
        User user = logindtl.getUser();
        if(user.getUserId() == null)
            return null;

        return Sessionresponse.builder()
                .userId(user.getUserId())
                .name(user.getFirstName()+" "+user.getLastName())
                .userRole(user.getRole().getRoleId())
                .build();
    }
}
