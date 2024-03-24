package Attitude_Collection.AttitudeCollectionOfficePannel.service;


import Attitude_Collection.AttitudeCollectionOfficePannel.entity.Login;
import Attitude_Collection.AttitudeCollectionOfficePannel.entity.Role;
import Attitude_Collection.AttitudeCollectionOfficePannel.entity.User;
import Attitude_Collection.AttitudeCollectionOfficePannel.repository.RoleRepository;
import Attitude_Collection.AttitudeCollectionOfficePannel.repository.UserRepository;
import Attitude_Collection.AttitudeCollectionOfficePannel.request.NewUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private RoleRepository roleRepo;
    @Autowired
    private JavaMailSender javaMailSender;

    public  String addUser(NewUserRequest request){
        Login logindtl = Login.builder()
                .userName(request.getUserName())
                .password(request.getPassword())
                .build();
        Optional<Role> role = roleRepo.findById(request.getRoleId());
        if(role.isEmpty())
            return "Invalid RoleId";
        User userdtl = User.builder()
                .dateOfBirth(request.getDateOfBirth())
                .email(request.getEmail())
                .gender(request.getGender())
                .role(role.get())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .login(logindtl)
                .build();
        userRepo.save(userdtl);
        sendMailtoCustomer(userdtl,request);

        return "User Added Successfully";
    }

    public User getUserById(Integer id)
    {
        return userRepo.findById(id).get();
    }

    private void sendMailtoCustomer(User user,NewUserRequest request){

        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Registration (Attitude Collection Portal)");
        message.setFrom("anuradhaah667@gmail.com");
        message.setTo(user.getEmail());
        String body = "Dear "+user.getFirstName()+" "+user.getLastName()+"\n" +
                "Your profile has been successfully created on http://localhost:8080/rest/auth/login\n" +
                "\n" +
                "Now you can login on above link with the help of your reference ID.\n" +
                "\n" +
                "Your reference no is :"+ request.getUserName() +"\n" +
                "\n" +
                "\n" +
                "Your password is :"+request.getPassword();
        message.setText(body);
        javaMailSender.send(message);

    }





}
