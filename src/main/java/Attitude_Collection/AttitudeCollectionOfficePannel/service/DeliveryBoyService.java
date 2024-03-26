package Attitude_Collection.AttitudeCollectionOfficePannel.service;

import Attitude_Collection.AttitudeCollectionOfficePannel.emun.EmailStatus;
import Attitude_Collection.AttitudeCollectionOfficePannel.entity.EmailQueue;
import Attitude_Collection.AttitudeCollectionOfficePannel.entity.Login;
import Attitude_Collection.AttitudeCollectionOfficePannel.entity.Role;
import Attitude_Collection.AttitudeCollectionOfficePannel.entity.User;
import Attitude_Collection.AttitudeCollectionOfficePannel.repository.EmailQueueRepository;
import Attitude_Collection.AttitudeCollectionOfficePannel.repository.LoginRepository;
import Attitude_Collection.AttitudeCollectionOfficePannel.repository.RoleRepository;
import Attitude_Collection.AttitudeCollectionOfficePannel.repository.UserRepository;
import Attitude_Collection.AttitudeCollectionOfficePannel.request.NewDeliveryboyRequest;
import Attitude_Collection.AttitudeCollectionOfficePannel.response.DeliveryBoyResponseList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryBoyService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private EmailQueueRepository emailQueueRepository;

    public String addDeliveryboy(NewDeliveryboyRequest request) {


        String sub[] = request.getEmail().split("@");
        String username = sub[0];
        String password = sub[0] + "@123";
        Login logindtl = Login.builder()
                .userName(username)
                .password(password)
                .build();
            loginRepository.save(logindtl);
        Optional<Role> role = roleRepo.findById(request.getRoleId());

        if (role.isEmpty())
            return "Invalid RoleId";
        try {
            User userdtl = User.builder()
                    .dateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse(request.getDateOfBirth()))
                    .email(request.getEmail())
                    .gender(request.getGender())
                    .role(role.get())
                    .firstName(request.getFirstName())
                    .lastName(request.getLastName())
                    .login(logindtl)
                    .build();
            userRepository.save(userdtl);
            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject("Registration (Attitude Collection Portal)");
            message.setFrom("anuradhaah667@gmail.com");
            message.setTo(request.getEmail());
            String body = "Dear " + request.getFirstName() + " " + request.getLastName() + "\n" +
                    "Your profile has been successfully created on http://localhost:8080/rest/auth/login\n" +
                    "\n" +
                    "Now you can login on above link with the help of your reference ID.\n" +
                    "\n" +
                    "Your reference no is :" + username + "\n" +
                    "\n" +
                    "Your password is :" + password;
            message.setText(body);
            javaMailSender.send(message);
            User senderdlt = userRepository.findByEmail(request.getEmail());
            EmailQueue email =  EmailQueue.builder()
                    .insertedAt(new Date())
                    .sender("anuradhaah667@gmail.com")
                    .toSender(request.getEmail())
                    .mailBody(body)
                    .tosenderName(senderdlt.getFirstName()+" "+senderdlt.getLastName())
                    .subject(message.getSubject())
                    .status(EmailStatus.SENT)
                    .build();

            emailQueueRepository.save(email);
            return "User Addedd Successfully";
        }catch (ParseException e)
        {
            return "Something went wrong";
        }
    }

    public User getDeliveryboyById(Integer id){
        return userRepository.findById(id).get();
    }
    public List<User> allDeliveryboy(){
        Optional<Role> role = roleRepo.findById(2);
        if(role.isEmpty())
        {
            System.out.println("role issue");
            return null;
        }

        List<User> userList = userRepository.findByRoleRoleId(role.get().getRoleId());
        List<DeliveryBoyResponseList> responseLists = new ArrayList<>();
        for(User u :userList)
        {
            System.out.println(u.getFirstName()+" "+u.getLastName()+" "+u.getEmail()+" "+u.getGender());
              responseLists.add(DeliveryBoyResponseList.builder()
                    .firstName(u.getFirstName())
                    .lastName(u.getLastName())
                    .email(u.getEmail())
                    .gender(u.getGender())
                    .build());

        }

        return userList;


    }





}
