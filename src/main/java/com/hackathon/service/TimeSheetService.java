package com.hackathon.service;

import com.hackathon.dto.ManagerTimeSheetResponseDto;
import com.hackathon.dto.TimeSheetSubmitDto;
import com.hackathon.entities.TimeSheet;

public interface TimeSheetService {
    TimeSheet submitTimeSheet(TimeSheetSubmitDto dto);
    TimeSheet managerRespondToTimeSheet(ManagerTimeSheetResponseDto dto);
}
