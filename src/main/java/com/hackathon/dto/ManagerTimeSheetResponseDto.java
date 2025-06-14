package com.hackathon.dto;

import com.hackathon.constants.Status;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ManagerTimeSheetResponseDto {
    @NotNull
    private Integer timeSheetId;
    @NotNull
    private Status status; // APPROVED or REJECTED
    private String managerComments;
}

