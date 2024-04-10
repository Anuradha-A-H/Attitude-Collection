package Attitude_Collection.AttitudeCollectionOfficePannel.response;

import Attitude_Collection.AttitudeCollectionOfficePannel.emun.Orderstatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseOrder {
    private String orderId;
    private Orderstatus status;
    private Integer totalAmount;


}
