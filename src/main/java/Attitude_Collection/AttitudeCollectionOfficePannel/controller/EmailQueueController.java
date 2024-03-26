package Attitude_Collection.AttitudeCollectionOfficePannel.controller;


import Attitude_Collection.AttitudeCollectionOfficePannel.entity.EmailQueue;
import Attitude_Collection.AttitudeCollectionOfficePannel.entity.User;
import Attitude_Collection.AttitudeCollectionOfficePannel.service.EmailQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/emailqueue")
public class EmailQueueController {
    @Autowired
    private EmailQueueService emailQueueService;
    @GetMapping("/")
    public ResponseEntity<List<EmailQueue>> allEmailQueue() {
        List<EmailQueue> emailQueueList = emailQueueService.allEmailQueue();
        return ResponseEntity.ok(emailQueueList);
    }

    @GetMapping("/allemail")
    public String allEmail(Model m) {
        List<EmailQueue> emailQueueList = emailQueueService.allEmailQueue();
        m.addAttribute("pro",emailQueueList);
        return "showemail";
    }

}
