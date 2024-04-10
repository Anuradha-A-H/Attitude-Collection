package Attitude_Collection.AttitudeCollectionOfficePannel.controller;


import Attitude_Collection.AttitudeCollectionOfficePannel.response.DashboardResponse;
import Attitude_Collection.AttitudeCollectionOfficePannel.service.DashboardService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/")
    public String dashboard(HttpSession session,Model m){
        try{
            DashboardResponse response = dashboardService.getdetails(session);
            m.addAttribute("response",response);
            return "index";
        }catch(Exception e){
            return "redirect:/attitudeCollection";
        }

    }
}
