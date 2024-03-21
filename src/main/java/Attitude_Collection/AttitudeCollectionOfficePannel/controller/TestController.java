package Attitude_Collection.AttitudeCollectionOfficePannel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
