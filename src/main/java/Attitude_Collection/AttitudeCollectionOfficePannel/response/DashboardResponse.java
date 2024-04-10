package Attitude_Collection.AttitudeCollectionOfficePannel.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DashboardResponse {

    private Integer totalEarningMonthly;
    private Integer totalEarningAnnual ;
    private Integer totalOrders ;
    private Integer pendingOrders ;
    private List<ResponseOrder> orders;
}
