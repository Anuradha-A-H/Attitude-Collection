package Attitude_Collection.AttitudeCollectionOfficePannel.request;


import Attitude_Collection.AttitudeCollectionOfficePannel.emun.Gender;
import Attitude_Collection.AttitudeCollectionOfficePannel.entity.Login;
import Attitude_Collection.AttitudeCollectionOfficePannel.entity.Role;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewUserRequest {

    private String firstName;
    private String lastName;
    private Date dateOfBirth;

    private String email;
    private Gender gender;
    private Integer roleId;
    private String userName;
    private String password;
}
