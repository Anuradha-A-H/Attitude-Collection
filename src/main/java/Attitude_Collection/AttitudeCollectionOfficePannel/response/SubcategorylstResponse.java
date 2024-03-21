package Attitude_Collection.AttitudeCollectionOfficePannel.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubcategorylstResponse {
    private Integer id;
    private String subcategoryName;
    private String category;
    private Integer noOfProducts;
}
