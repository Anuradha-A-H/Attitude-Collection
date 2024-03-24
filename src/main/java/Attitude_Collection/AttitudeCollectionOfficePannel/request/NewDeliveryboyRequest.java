package Attitude_Collection.AttitudeCollectionOfficePannel.request;

import Attitude_Collection.AttitudeCollectionOfficePannel.emun.Gender;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewDeliveryboyRequest {

    private String firstName;
    private String lastName;
    private String dateOfBirth;

    private String email;
    private Gender gender;
    private Integer roleId;
}
