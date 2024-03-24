package Attitude_Collection.AttitudeCollectionOfficePannel.entity;

import Attitude_Collection.AttitudeCollectionOfficePannel.emun.Orderstatus;
import Attitude_Collection.AttitudeCollectionOfficePannel.emun.PaymentStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String orderId;

    private String totalAmount;
    private PaymentStatus paymentStatus;
    private String address;
    private Integer pincode;
    private Date OrderedDate;
    private Date deliveredDate;
    private Orderstatus orderstatus;
    private List<String> trackOrderPlace;

    @JoinColumn
    @ManyToOne
    private User user;
}
