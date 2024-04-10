package Attitude_Collection.AttitudeCollectionOfficePannel.request;


import Attitude_Collection.AttitudeCollectionOfficePannel.emun.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddProductRequest {

    private String productName;
    private Integer categoryId;
    private Integer subcategoryId;
    private Integer productQuantity;
    private Integer price;
    private String description;
    private MultipartFile image;

}
