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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 * Service implementation for handling timesheet operations.
 */
@Service
public class TimeSheetServiceImpl implements TimeSheetService {
    private static final Logger logger = LoggerFactory.getLogger(TimeSheetServiceImpl.class);

    @Autowired
    private TimeSheetRepository timeSheetRepository;

    /**
     * Submits a new timesheet for a contractor for a given week.
     * @param dto the timesheet submission data
     * @return the saved TimeSheet entity
     */
    @Override
    public TimeSheet submitTimeSheet(TimeSheetSubmitDto dto) {
        logger.info("Submitting timesheet for contractorId={}, weekStartTime={}", dto.getContractorId(), dto.getWeekStartTime());
        TimeSheet timeSheet = new TimeSheet();
        timeSheet.setContractorId(dto.getContractorId());
        timeSheet.setWeekStartTime(dto.getWeekStartTime());
        timeSheet.setStatus(Status.PENDING); // Set status to PENDING
        timeSheet.setManagerComments("");
        // Entries can be added later if needed
        TimeSheet saved = timeSheetRepository.save(timeSheet);
        logger.info("Timesheet submitted with id={}", saved.getTimeSheetId());
        return saved;
    }

    /**
     * Allows a manager to approve or reject a timesheet.
     * @param dto the manager's response data
     * @return the updated TimeSheet entity
     */
    @Override
    public TimeSheet managerRespondToTimeSheet(ManagerTimeSheetResponseDto dto) {
        logger.info("Manager responding to timesheetId={} with status={}", dto.getTimeSheetId(), dto.getStatus());
        TimeSheet timeSheet = timeSheetRepository.findById(dto.getTimeSheetId())
                .orElseThrow(() -> new TimeSheetNotFoundException("TimeSheet not found with ID: " + dto.getTimeSheetId()));
        timeSheet.setStatus(dto.getStatus());
        timeSheet.setManagerComments(dto.getManagerComments());
        TimeSheet updated = timeSheetRepository.save(timeSheet);
        logger.info("Timesheet id={} updated with status={}", updated.getTimeSheetId(), updated.getStatus());
        return updated;
    }
}
