package com.hackathon.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TimeSheetSubmitDto {
    @Min(1)
    private int contractorId;
    @NotNull
    private String projectCode;
    @NotNull
    private LocalDateTime weekStartTime;
}

