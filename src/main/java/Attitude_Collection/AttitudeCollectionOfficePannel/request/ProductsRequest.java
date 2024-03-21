package Attitude_Collection.AttitudeCollectionOfficePannel.request;


import Attitude_Collection.AttitudeCollectionOfficePannel.emun.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductsRequest {


    private String productName;
    private Integer productQuantity;
    private Integer price;
    private Status status;
    private String description;
    private Integer rating = 0;
    private String image;
    private Integer subcategoryId;
    private Integer categoryId;
}
