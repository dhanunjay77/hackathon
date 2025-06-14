package com.hackathon.dto;

import lombok.Data;

import com.hackathon.entities.Contractor;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
public class TimeSheetEntryDto {
    @Min(1)
    private int contractorId;

    @Min(1)
    private int projectId;
    @Min(1)
    private int activityId;
    @Min(0)
    private double hoursWorked;
    @Size(max = 255)
    private String comments;
    
    
}
