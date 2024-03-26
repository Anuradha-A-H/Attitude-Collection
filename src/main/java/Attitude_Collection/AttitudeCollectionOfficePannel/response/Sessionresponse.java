package Attitude_Collection.AttitudeCollectionOfficePannel.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sessionresponse {

    private  Integer userId;
    private Integer userRole;
    private String name;

}
