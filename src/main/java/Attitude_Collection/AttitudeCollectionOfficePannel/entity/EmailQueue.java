package Attitude_Collection.AttitudeCollectionOfficePannel.entity;


import Attitude_Collection.AttitudeCollectionOfficePannel.emun.EmailStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmailQueue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String mailBody;
    private String subject;
    private String sender;
    private String toSender;
    private String tosenderName;
    private Date insertedAt;
    private EmailStatus status;


}
