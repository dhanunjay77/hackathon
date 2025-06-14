package com.hackathon.controller;

import com.hackathon.dto.ManagerTimeSheetResponseDto;
import com.hackathon.dto.TimeSheetSubmitDto;
import com.hackathon.entities.TimeSheet;
import com.hackathon.service.TimeSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * REST controller for handling timesheet operations (submit, manager response).
 */
@RestController
@RequestMapping("/api/timesheet")
public class TimeSheetController {
    private static final Logger logger = LoggerFactory.getLogger(TimeSheetController.class);

    @Autowired
    private TimeSheetService timeSheetService;

    /**
     * Endpoint for submitting a timesheet by a contractor.
     * @param dto the timesheet submission data
     * @return the saved timesheet
     */
    @PostMapping("/submit")
    public ResponseEntity<TimeSheet> submitTimeSheet(@RequestBody TimeSheetSubmitDto dto) {
        logger.info("Received timesheet submit request: contractorId={}, weekStartTime={}", dto.getContractorId(), dto.getWeekStartTime());
        TimeSheet timeSheet = timeSheetService.submitTimeSheet(dto);
        logger.info("Timesheet submitted successfully with id={}", timeSheet.getTimeSheetId());
        return ResponseEntity.ok(timeSheet);
    }

    /**
     * Endpoint for manager to approve or reject a timesheet.
     * @param dto the manager's response data
     * @return the updated timesheet
     */
    @PutMapping("/manager-response")
    public ResponseEntity<TimeSheet> managerRespondToTimeSheet(@RequestBody ManagerTimeSheetResponseDto dto) {
        logger.info("Manager response for timesheetId={}, status={}", dto.getTimeSheetId(), dto.getStatus());
        TimeSheet updated = timeSheetService.managerRespondToTimeSheet(dto);
        logger.info("Manager updated timesheetId={} with status={}", updated.getTimeSheetId(), updated.getStatus());
        return ResponseEntity.ok(updated);
    }
}
