package Attitude_Collection.AttitudeCollectionOfficePannel.response;


import Attitude_Collection.AttitudeCollectionOfficePannel.emun.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryBoyResponseList {

    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;
}
