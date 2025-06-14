package com.hackathon.entities;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
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

    @ManyToOne
    private TimeSheet timeSheet;
}
