package com.hackathon.entities;


import com.hackathon.constants.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Data
public class TimeSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int timeSheetId;

    private LocalDateTime weekStartTime;
    private int contractorId;
    private Status status;
    private String managerComments;

    @OneToMany
    private Set<TimeSheetEntry> timeSheetEntries;
}
