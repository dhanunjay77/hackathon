package com.hackathon.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class TimeSheetEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int entryId;

    private int contractorId;
    private int projectId;
    private int activityId;
    private LocalDateTime date;
    private double hoursWorked;
    private String comments;

}
