package Attitude_Collection.AttitudeCollectionOfficePannel.response;

import Attitude_Collection.AttitudeCollectionOfficePannel.emun.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDtlResponse {


    private String productId;
    private String productName;
    private Integer productQuantity;
    private Integer price;
    private Status status;
    private String description;
    private Integer rating;
    private String image;
    private String subcategoryName;
    private String categoryName;

}
