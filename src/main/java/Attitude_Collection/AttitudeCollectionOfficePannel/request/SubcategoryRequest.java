package Attitude_Collection.AttitudeCollectionOfficePannel.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubcategoryRequest {
    private String subcategoryName;
    private Integer categoryId;
}
