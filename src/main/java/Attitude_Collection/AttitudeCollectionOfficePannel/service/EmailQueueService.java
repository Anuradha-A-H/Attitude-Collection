package Attitude_Collection.AttitudeCollectionOfficePannel.service;


import Attitude_Collection.AttitudeCollectionOfficePannel.entity.EmailQueue;
import Attitude_Collection.AttitudeCollectionOfficePannel.repository.EmailQueueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailQueueService {

    @Autowired
    private EmailQueueRepository emailQueueRepository;

    public List<EmailQueue> allEmailQueue(){
        return emailQueueRepository.findAll();
    }
}
