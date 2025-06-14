package com.hackathon.entities;


import com.hackathon.constants.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class TimeSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID timeSheetId;

    private LocalDateTime weekStartTime;
    private int contractorId;
    private Status status;
    private String managerComments;

}
