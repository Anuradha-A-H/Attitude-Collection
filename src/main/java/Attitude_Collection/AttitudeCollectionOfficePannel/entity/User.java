package Attitude_Collection.AttitudeCollectionOfficePannel.entity;

import Attitude_Collection.AttitudeCollectionOfficePannel.emun.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String firstName;
    private String lastName;
    private Date dateOfBirth;

    @Column(unique = true,nullable = false)
    private String email;
    private Gender gender;

    @JoinColumn
    @ManyToOne
    private Role role;


    @JoinColumn
    @OneToOne
    private Login login;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Orders> orderList = new ArrayList<>();

}
