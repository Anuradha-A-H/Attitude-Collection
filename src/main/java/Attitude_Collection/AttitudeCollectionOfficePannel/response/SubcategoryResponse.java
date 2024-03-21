package Attitude_Collection.AttitudeCollectionOfficePannel.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubcategoryResponse {

    private Integer subcategoryId;
    private String subcategoryName;
    private Integer categoryId;
}
