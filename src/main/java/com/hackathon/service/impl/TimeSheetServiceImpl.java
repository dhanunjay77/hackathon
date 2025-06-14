package com.hackathon.service.impl;

import com.hackathon.Repository.TimeSheetRepository;
import com.hackathon.constants.Status;
import com.hackathon.dto.ManagerTimeSheetResponseDto;
import com.hackathon.dto.TimeSheetSubmitDto;
import com.hackathon.entities.TimeSheet;
import com.hackathon.exception.TimeSheetNotFoundException;
import com.hackathon.service.TimeSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TimeSheetServiceImpl implements TimeSheetService {
    @Autowired
    private TimeSheetRepository timeSheetRepository;

    @Override
    public TimeSheet submitTimeSheet(TimeSheetSubmitDto dto) {
        TimeSheet timeSheet = new TimeSheet();
        timeSheet.setContractorId(dto.getContractorId());
        timeSheet.setWeekStartTime(dto.getWeekStartTime());
        timeSheet.setStatus(Status.PENDING); // Set status to PENDING
        timeSheet.setManagerComments("");
        // Entries can be added later if needed
        return timeSheetRepository.save(timeSheet);
    }

    @Override
    public TimeSheet managerRespondToTimeSheet(ManagerTimeSheetResponseDto dto) {
        TimeSheet timeSheet = timeSheetRepository.findById(dto.getTimeSheetId())
                .orElseThrow(() -> new TimeSheetNotFoundException("TimeSheet not found with ID: " + dto.getTimeSheetId()));
        timeSheet.setStatus(dto.getStatus());
        timeSheet.setManagerComments(dto.getManagerComments());
        return timeSheetRepository.save(timeSheet);
    }
}
