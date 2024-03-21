package Attitude_Collection.AttitudeCollectionOfficePannel.entity;


import Attitude_Collection.AttitudeCollectionOfficePannel.emun.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String productId;

    private String productName;
    private Integer productQuantity;
    private Integer price;
    private Status status;
    private String description;
    private Integer rating;
    private String image;

    @JoinColumn
    @ManyToOne
    private Subcategory subcategory;

}
