package com.hackathon.dto;

import java.time.LocalDateTime;

import com.hackathon.constants.Status;

import lombok.Data;

@Data
public class TimeSheetDto {

	private LocalDateTime weekStartTime;
	private int contractorId;
	private Status status;
	private String managerComments;
}
