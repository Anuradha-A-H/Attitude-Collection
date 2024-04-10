package Attitude_Collection.AttitudeCollectionOfficePannel.service;


import Attitude_Collection.AttitudeCollectionOfficePannel.response.DashboardResponse;
import Attitude_Collection.AttitudeCollectionOfficePannel.response.ResponseOrder;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class DashboardService {
    @Autowired
     RestTemplate restTemplate;

    public DashboardResponse getdetails(HttpSession session) throws Exception {
        Integer id = (Integer) session.getAttribute("userId");
        if(id == null)
            throw  new Exception("Login to see dashboard");
        String url1 = "http://localhost:8081/attitudeCollection/totalEarningMonthly";
        String url2 = "http://localhost:8081/attitudeCollection/totalEarningAnnual";
        String url3 = "http://localhost:8081/attitudeCollection/totalOrders";
        String url4 = "http://localhost:8081/attitudeCollection/pendingOrders";
        String url5 = "http://localhost:8081/attitudeCollection/resentOrderslist";
        Integer totalEarningMonthly = restTemplate.getForObject(url1,Integer.class);
        Integer totalEarningAnnual = restTemplate.getForObject(url2,Integer.class);;
        Integer totalOrders = restTemplate.getForObject(url3,Integer.class);;
        Integer pendingOrders = restTemplate.getForObject(url4,Integer.class);;
        List<ResponseOrder> orders = restTemplate.getForObject(url5, List.class);;
        return new DashboardResponse(totalEarningMonthly,totalEarningAnnual,totalOrders,pendingOrders,orders);
    }
}
