package Attitude_Collection.AttitudeCollectionOfficePannel.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {

    private Integer id;
    private String name;
    private byte[] image;
}
