package Attitude_Collection.AttitudeCollectionOfficePannel.entity;

import Attitude_Collection.AttitudeCollectionOfficePannel.emun.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String firstName;
    private String lastName;
    private Integer age;

    @Column(unique = true,nullable = false)
    private String email;
    private Gender gender;

    @JoinColumn
    @ManyToOne
    private Role role;
    @JoinColumn
    @OneToOne
    private Login login;
}
